package co.edu.uniquindio.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.App;
import co.edu.uniquindio.Model.LuxoraWallet;
import co.edu.uniquindio.Persistencia.ArchivoUtil;
import co.edu.uniquindio.View.InicioSesionView;
import co.edu.uniquindio.View.UsuarioView;
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

    LuxoraWallet luxoraWallet = LuxoraWallet.getInstanciaUnica();

    @FXML
    void btn_iniciar(ActionEvent event) throws IOException {
        String id = usuario_txt.getText();
        String contrasenia = contrasenia_txt.getText();
        InicioSesionView inicioView = new InicioSesionView();

        if(inicioView.verificarUsuarioExistente(id, contrasenia) == true){
            App.setRoot("usuarioView", "Luxora Wallet - Pagina principal");
        }
        else{
            System.out.println("No puedes iniciar sesión");
        }
    }

    @FXML
    void btn_register(MouseEvent event) throws IOException {
        App.setRoot("registroUsuarioView", "Luxora Wallet - Registrarse");
    }

    @FXML
    void initialize(URL url, ResourceBundle rb) {
        assert btn_iniciar != null : "fx:id=\"btn_iniciar\" was not injected: check your FXML file 'inicioSesion.fxml'.";
        assert contrasenia_txt != null : "fx:id=\"contrasenia_txt\" was not injected: check your FXML file 'inicioSesion.fxml'.";
        assert register != null : "fx:id=\"register\" was not injected: check your FXML file 'inicioSesion.fxml'.";
        assert usuario_txt != null : "fx:id=\"usuario_txt\" was not injected: check your FXML file 'inicioSesion.fxml'.";
    }

}
