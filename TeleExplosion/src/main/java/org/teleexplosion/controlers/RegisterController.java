package org.teleexplosion.controlers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.teleexplosion.App;

import java.io.IOException;

public class RegisterController {
    @FXML
    public Button registerButton;

    @FXML
    private void backToLogin() throws IOException {
        App.setRoot("LogIn");
    }
}
