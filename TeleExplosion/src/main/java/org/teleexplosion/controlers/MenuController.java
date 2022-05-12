package org.teleexplosion.controlers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import org.teleexplosion.App;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    @FXML
    private void startGame() throws IOException {
        // checking the numer of players
        int NumOfPlayers = 0;
        for(int i=0; i<4; i++){
            if(joinedPlayers.get(i))
                NumOfPlayers+=1;
        }

        if(NumOfPlayers>=2) {
            App.setGameRoot(mapsName.get(level), joinedPlayers);
        }
    }

    // map choosing
    @FXML
    private void nextMap() {
        if(mapsName.size()-1 >= level+1){
            mapList.setText(mapsName.get(level+1));
            level+=1;
        }
    }
    @FXML
    private void previousMap() {
        if(level-1 >= 0){
            mapList.setText(mapsName.get(level-1));
            level-=1;
        }
    }

    @FXML
    public TextField mapList;

    // list of maps
    ArrayList<String> mapsName = new ArrayList<>();

    // selected map number
    int level = 0;

    // list of selected players
    ArrayList<Boolean> joinedPlayers = new ArrayList<>();

    public void setJoinedPlayers() {
        this.joinedPlayers.add(0,false);
        this.joinedPlayers.add(1,false);
        this.joinedPlayers.add(2,false);
        this.joinedPlayers.add(3,false);
    }

    @FXML
    private ImageView p1Img;
    @FXML
    private ImageView p2Img;
    @FXML
    private ImageView p3Img;
    @FXML
    private ImageView p4Img;
    @FXML
    public ImageView logoMenu;

    @FXML
    private TextField p1TextField;
    @FXML
    private TextField p2TextField;
    @FXML
    private TextField p3TextField;
    @FXML
    private TextField p4TextField;

    @FXML
    private void keyPressed(KeyEvent event){
        // player selection
        switch (event.getCode()) {
            case Q -> {
                if(joinedPlayers.get(0)) {
                    p1TextField.setText("PRESS Q TO JOIN");
                    p1Img.opacityProperty().setValue(0.25);
                    joinedPlayers.set(0,false);
                }
                else {
                    p1TextField.setText("P1 JOINED");
                    p1Img.opacityProperty().setValue(1);
                    joinedPlayers.set(0,true);
                }
            }
            case U -> {
                if(joinedPlayers.get(1)) {
                    p2TextField.setText("PRESS U TO JOIN");
                    p2Img.opacityProperty().setValue(0.25);
                    joinedPlayers.set(1,false);
                }
                else {
                    p2TextField.setText("P2 JOINED");
                    p2Img.opacityProperty().setValue(1);
                    joinedPlayers.set(1,true);
                }
            }
            case CONTROL -> {
                if(joinedPlayers.get(2)) {
                    p3TextField.setText("PRESS CTRL TO JOIN");
                    p3Img.opacityProperty().setValue(0.25);
                    joinedPlayers.set(2,false);
                }
                else {
                    p3TextField.setText("P3 JOINED");
                    p3Img.opacityProperty().setValue(1);
                    joinedPlayers.set(2,true);
                }
            }
            case NUMPAD7 -> {
                if(joinedPlayers.get(3)) {
                    p4TextField.setText("PRESS NUM7 TO JOIN");
                    p4Img.opacityProperty().setValue(0.25);
                    joinedPlayers.set(3,false);
                }
                else {
                    p4TextField.setText("P4 JOINED");
                    p4Img.opacityProperty().setValue(1);
                    joinedPlayers.set(3,true);
                }
            }
            default -> {}
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // adding new map
        mapsName.add("CASTLE");
        mapsName.add("DESERT");
        mapsName.add("JUNGLE");

        mapList.setText(mapsName.get(level));

        // loading logo
        Image logo = new Image(new File("img/logoMenu.png").toURI().toString());
        logoMenu.setImage(logo);

        // loading players picture
        Image img1 = new Image(new File("img/p1.png").toURI().toString());
        p1Img.setImage(img1);
        p1Img.opacityProperty().setValue(.25);
        Image img2 = new Image(new File("img/p2.png").toURI().toString());
        p2Img.setImage(img2);
        p2Img.opacityProperty().setValue(.25);
        Image img3 = new Image(new File("img/p3.png").toURI().toString());
        p3Img.setImage(img3);
        p3Img.opacityProperty().setValue(.25);
        Image img4 = new Image(new File("img/p4.png").toURI().toString());
        p4Img.setImage(img4);
        p4Img.opacityProperty().setValue(.25);

        // setting default players
        setJoinedPlayers();
    }
}