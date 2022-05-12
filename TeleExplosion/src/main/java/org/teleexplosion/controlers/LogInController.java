package org.teleexplosion.controlers;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import org.teleexplosion.App;

import java.io.IOException;

public class LogInController {
    public VBox VBoxLogin;

    @FXML
    private void backToMenu() throws IOException {
        App.setRoot("primary");
    }
    @FXML
    private void register() throws IOException {
        App.setRoot("register");
    }
}
