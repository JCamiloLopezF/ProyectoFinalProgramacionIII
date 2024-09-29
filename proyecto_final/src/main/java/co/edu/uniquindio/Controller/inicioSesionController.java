package co.edu.uniquindio.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class inicioSesionController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label resgiter;

    @FXML
    void initialize() {
        assert resgiter != null : "fx:id=\"resgiter\" was not injected: check your FXML file 'inicioSesion.fxml'.";

    }

}
