package co.edu.uniquindio.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.App;
import co.edu.uniquindio.Model.LuxoraWallet;
import co.edu.uniquindio.Model.Usuario;
import co.edu.uniquindio.Persistencia.ArchivoUtil;
import co.edu.uniquindio.Persistencia.GestorArchivo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class RegistroUsuarioController {
    

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_registrar;

    @FXML
    private TextField txt_telefono;

    @FXML
    private TextField txt_contrasenia;

    @FXML
    private TextField txt_correo;

    @FXML
    private TextField txt_nombre;

    @FXML
    private TextField txtx_usuario;

    LuxoraWallet luxoraWallet = new LuxoraWallet();

    @FXML
    void btn_registrar(ActionEvent event) throws IOException {    
        String nombre = txt_nombre.getText();
        String telefono = txt_telefono.getText();
        String correo = txt_correo.getText();
        String usuario = txtx_usuario.getText();
        String contrasenia = txt_contrasenia.getText();
        Usuario usuarioNuevo = new Usuario(nombre, correo, telefono, usuario, contrasenia, 0);
        
        //GUardado del usuario en archivoUsuarios
        GestorArchivo persistencia = new GestorArchivo();
        persistencia.guardarUsuario(usuarioNuevo);
        luxoraWallet.getUsuarios().add(usuarioNuevo);

        //Creacion del Log, registroUsuario
        ArchivoUtil.guardarRegistroLog("Se registro el usuario: " + usuario, 1, "registroUsuario", "C:/td/persistencia/log/luxoraWallet_Log.txt");
        
        App.setRoot("usuarioView");
    }

    @FXML
    void initialize() {
        assert btn_registrar != null : "fx:id=\"btn_registrar\" was not injected: check your FXML file 'registroUsuarioView.fxml'.";
        assert txt_telefono != null : "fx:id=\"txt_cedula\" was not injected: check your FXML file 'registroUsuarioView.fxml'.";
        assert txt_contrasenia != null : "fx:id=\"txt_contrasenia\" was not injected: check your FXML file 'registroUsuarioView.fxml'.";
        assert txt_correo != null : "fx:id=\"txt_correo\" was not injected: check your FXML file 'registroUsuarioView.fxml'.";
        assert txt_nombre != null : "fx:id=\"txt_nombre\" was not injected: check your FXML file 'registroUsuarioView.fxml'.";
        assert txtx_usuario != null : "fx:id=\"txtx_usuario\" was not injected: check your FXML file 'registroUsuarioView.fxml'.";

    }

}
