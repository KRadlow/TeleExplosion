package org.teleexplosion.controlers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.teleexplosion.App;

public class PrimaryController implements Initializable{
    @FXML
    public ImageView logo;
    @FXML
    private AnchorPane primaryScene;
    @FXML
    private Button logButton;
    @FXML
    private Button playButton;
    @FXML
    private Button exitButton;

    @FXML
    private void switchToGameMenu() throws IOException {
        App.setRoot("menu");
    }
    @FXML
    private void switchToLogin() {
        //App.setRoot("logIn");
    }

    // exit the application
    Stage stage;
    @FXML
    private void exit() {
        stage = (Stage) primaryScene.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image img = new Image(new File("img/logo.png").toURI().toString());
        logo.setImage(img);
    }
}
