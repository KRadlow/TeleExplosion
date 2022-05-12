package org.teleexplosion.controlers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import org.teleexplosion.App;
import org.teleexplosion.Game;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GameController {

    ArrayList<Boolean> players = new ArrayList<>();
    Game game;

    @FXML
    private void exitGame() throws IOException {
        game.endGame();
        App.setRoot("menu");
    }

    @FXML
    public GridPane mapGrid;
    @FXML
    public AnchorPane mapPane;
    @FXML
    public Button stopGameButton;
    @FXML
    private ImageView p1Img;
    @FXML
    private ImageView p2Img;
    @FXML
    private ImageView p3Img;
    @FXML
    private ImageView p4Img;

    @FXML
    private void keyPressed(KeyEvent event) {
        Game.playersMove(event.getCode());
    }

    // setting game data
    public void setData(String selectedMap, ArrayList<Boolean> selectedPlayers) {
        this.players = selectedPlayers;

        // loading players icon
        // Player 1 icon
        Image img1 = new Image(new File("img/icon1.png").toURI().toString());
        p1Img.setImage(img1);
        if(!players.get(0))
            p1Img.opacityProperty().setValue(.25);

        // Player 2 icon
        Image img2 = new Image(new File("img/icon2.png").toURI().toString());
        p2Img.setImage(img2);
        if(!players.get(1))
            p2Img.opacityProperty().setValue(.25);

        // Player 3 icon
        Image img3 = new Image(new File("img/icon3.png").toURI().toString());
        p3Img.setImage(img3);
        if(!players.get(2))
            p3Img.opacityProperty().setValue(.25);

        // Player 4 icon
        Image img4 = new Image(new File("img/icon4.png").toURI().toString());
        p4Img.setImage(img4);
        if(!players.get(3))
            p4Img.opacityProperty().setValue(.25);

        // game start
        this.game = new Game(mapPane, mapGrid, selectedMap, players);
        //Thread thread = new Thread(new Game(mapPane, mapGrid, selectedMap, players));
        Thread thread = new Thread(game);
        thread.start();
    }
}

