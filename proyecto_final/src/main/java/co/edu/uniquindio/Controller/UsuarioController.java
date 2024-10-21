package co.edu.uniquindio.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import co.edu.uniquindio.Model.LuxoraWallet;
import co.edu.uniquindio.Model.Usuario;
import co.edu.uniquindio.Persistencia.ArchivoUtil;
import co.edu.uniquindio.Persistencia.GestorArchivo;
import co.edu.uniquindio.View.UsuarioView;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.control.Label;

public class UsuarioController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text txt_nombreUsuario;

    LuxoraWallet luxoraWallet = LuxoraWallet.getInstanciaUnica();
    UsuarioView usuario = new UsuarioView();
    
    public void iniciar_nombre(){
        String nombre = usuario.nombreUsuario();
        txt_nombreUsuario.setText("Hola " + nombre);
    }

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
        String nombre = usuario.nombreUsuario();
        ArchivoUtil.guardarRegistroLog("El usuario: " + nombre + " inició sesión", 1, "inicioSesionUsuario", "C:/td/persistencia/log/luxoraWallet_Log.txt");

        assert txt_nombreUsuario != null : "fx:id=\"txt_idUsuario\" was not injected: check your FXML file 'usuarioView.fxml'.";
        iniciar_nombre();
    }

}
