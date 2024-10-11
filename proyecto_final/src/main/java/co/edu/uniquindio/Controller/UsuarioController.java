package co.edu.uniquindio.Controller;

import java.io.IOException;
import java.lang.classfile.Label;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import co.edu.uniquindio.Model.LuxoraWallet;
import co.edu.uniquindio.Model.Usuario;
import co.edu.uniquindio.Persistencia.GestorArchivo;
import co.edu.uniquindio.View.UsuarioView;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class UsuarioController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text txt_nombreUsuario;

    LuxoraWallet luxoraWallet = LuxoraWallet.getInstanciaUnica();

    @FXML
    void btn_actualizarDatos(MouseEvent event) {

    }

    @FXML
    void btn_gestionarCuentas(MouseEvent event) {

    }

    @FXML
    void btn_verTransacciones(MouseEvent event) {

    }

    @FXML
    void initialize() {

        assert txt_nombreUsuario != null : "fx:id=\"txt_idUsuario\" was not injected: check your FXML file 'usuarioView.fxml'.";

    }

}
