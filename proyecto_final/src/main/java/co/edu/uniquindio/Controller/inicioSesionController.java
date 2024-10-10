package co.edu.uniquindio.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class inicioSesionController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_iniciar;

    @FXML
    private PasswordField contrasenia_txt;

    @FXML
    private Label register;

    @FXML
    private TextField usuario_txt;

    @FXML
    void btn_iniciar(ActionEvent event) {
        

        try {
            App.setRoot("usuarioView");
        } catch (IOException e) {
            System.out.println("No puedes iniciar sesión");
        }

    }

    @FXML
    void btn_register(MouseEvent event) throws IOException {
        App.setRoot("registroUsuarioView");
    }

    @FXML
    void initialize(URL url, ResourceBundle rb) {
        assert btn_iniciar != null : "fx:id=\"btn_iniciar\" was not injected: check your FXML file 'inicioSesion.fxml'.";
        assert contrasenia_txt != null : "fx:id=\"contrasenia_txt\" was not injected: check your FXML file 'inicioSesion.fxml'.";
        assert register != null : "fx:id=\"register\" was not injected: check your FXML file 'inicioSesion.fxml'.";
        assert usuario_txt != null : "fx:id=\"usuario_txt\" was not injected: check your FXML file 'inicioSesion.fxml'.";

    }

}
