package org.teleexplosion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.teleexplosion.controlers.GameController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("primary.fxml")));
        scene = new Scene(root, 800, 600);

        // stylesheet style.css
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        //title
        stage.setTitle("TeleExplosion");

        // bomb icon
        Image icon = new Image(new File("img/bomb.png").toURI().toString());
        stage.getIcons().add(icon);

        // closing app
        stage.setOnCloseRequest(event ->{
            event.consume();
            logout(stage);
        });
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    // passing data between controllers
    public static void setGameRoot(String mapName, ArrayList<Boolean> playersList) throws IOException {
        FXMLLoader gameLoader = new FXMLLoader(App.class.getResource("game.fxml"));
        Parent root = gameLoader.load();
        GameController gameController = gameLoader.getController();
        gameController.setData(mapName,playersList);
        scene.setRoot(root);
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    // alert before closing
    public void logout(Stage stage){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Close the app");
        alert.setContentText("Are you sure want to exit?");
        alert.setHeaderText("Click OK if you want to close the app");
        if(alert.showAndWait().get() == ButtonType.OK){
            stage.close();
        }
    }
    public static void main(String[] args) {
        launch();
    }
}