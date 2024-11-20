package co.edu.uniquindio.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.App;
import co.edu.uniquindio.Model.Administrador;
import co.edu.uniquindio.Model.LuxoraWallet;
import co.edu.uniquindio.Persistencia.GestorArchivo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class AdminGUsuarioController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_guardar;

    @FXML
    private Text btn_regresar;

    @FXML
    private TextField txt_direccion;

    @FXML
    private TextField txt_telefono;

    @FXML
    private TextField txt_usuario;

    LuxoraWallet luxora = LuxoraWallet.getInstanciaUnica();
    GestorArchivo gestor = new GestorArchivo();
    Administrador admin = new Administrador();


    @FXML
    void btn_eliminar(ActionEvent event) throws IOException {
        admin.eliminarUsuario(txt_usuario.getText());
    }

    @FXML
    void btn_guardar(ActionEvent event) throws IOException {
        String nombreUsuario = txt_usuario.getText();
        String telefono = txt_telefono.getText();
        String direccion = txt_direccion.getText();
        admin.actualizarUsuario(nombreUsuario, direccion, telefono);
    }

    @FXML
    void btn_regresar(MouseEvent event) throws IOException {
        App.setRoot("aministradorView", "Administra LuxoraWallet");
    }

    @FXML
    void initialize() {
        assert btn_guardar != null : "fx:id=\"btn_guardar\" was not injected: check your FXML file 'adminGUsuario.fxml'.";
        assert btn_regresar != null : "fx:id=\"btn_regresar\" was not injected: check your FXML file 'adminGUsuario.fxml'.";
        assert txt_direccion != null : "fx:id=\"txt_direccion\" was not injected: check your FXML file 'adminGUsuario.fxml'.";
        assert txt_telefono != null : "fx:id=\"txt_telefono\" was not injected: check your FXML file 'adminGUsuario.fxml'.";
        assert txt_usuario != null : "fx:id=\"txt_usuario\" was not injected: check your FXML file 'adminGUsuario.fxml'.";
    } 
}
