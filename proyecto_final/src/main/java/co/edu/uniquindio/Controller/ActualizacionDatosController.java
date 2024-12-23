package co.edu.uniquindio.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import co.edu.uniquindio.App;
import co.edu.uniquindio.Model.LuxoraWallet;
import co.edu.uniquindio.Model.Usuario;
import co.edu.uniquindio.Persistencia.ArchivoUtil;
import co.edu.uniquindio.Persistencia.GestorArchivo;
import co.edu.uniquindio.View.ActualizacionDatosView;
import co.edu.uniquindio.View.UsuarioView;

public class ActualizacionDatosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text btn_regresar;

    @FXML
    private Button btn_guardar;

    @FXML
    private TextField txt_contraseniaActual;

    @FXML
    private TextField txt_contraseniaConfirm;

    @FXML
    private TextField txt_contraseniaNueva;

    @FXML
    private TextField txt_direccion;

    @FXML
    private TextField txt_telefono;

    @FXML
    private Text txt_nombreUsuario;

    LuxoraWallet luxoraWallet = LuxoraWallet.getInstanciaUnica();
    UsuarioView usuario = new UsuarioView();
    ActualizacionDatosView usuarioActualizarDatos = new ActualizacionDatosView();
    LinkedList<Usuario> usuarioActual = luxoraWallet.getUsuarioSeleccionado();

    public void inicializarTextField(){
        txt_nombreUsuario.setText(usuario.nombreUsuario());
        txt_direccion.setText(usuarioActualizarDatos.direccionUsuario());
        txt_telefono.setText(usuarioActualizarDatos.telefonoUsuario());
    }

    @FXML
    void btn_guardar(ActionEvent event) throws IOException {
        GestorArchivo gestorArchivo = new GestorArchivo();
        Usuario usuarioSeleccionado = usuarioActual.get(0);
        String direccionNueva = txt_direccion.getText(); 
        String telefonoNuevo = txt_telefono.getText();
        String contraseniaActual = txt_contraseniaActual.getText();
        String contraseniaNueva = txt_contraseniaNueva.getText();
        String contraseniaConfirm = txt_contraseniaConfirm.getText();

        if (!contraseniaNueva.equals(contraseniaConfirm)) {
            ArchivoUtil.mostrarAlerta("ERROR", "La nueva contraseña no concuerda con la confirmación");
            return;
        }

        usuarioSeleccionado.setDireccion(direccionNueva);
        usuarioSeleccionado.setNumeroTelefono(telefonoNuevo);
        usuarioSeleccionado.setContrasenia(contraseniaNueva);

        if (!usuarioActual.isEmpty()) {
            
            // Actualización de los atributos en el objeto usuarioSeleccionado
            usuarioSeleccionado.setDireccion(direccionNueva);
            usuarioSeleccionado.setNumeroTelefono(telefonoNuevo);
            usuarioSeleccionado.setContrasenia(contraseniaNueva);
        
            // Guardar en el archivo usando el método de actualización parcial
            gestorArchivo.actualizarDatosParcialesUsuario(usuarioSeleccionado, direccionNueva, telefonoNuevo, contraseniaNueva);
        
            ArchivoUtil.mostrarAlerta("Éxito", "Los datos han sido actualizados correctamente");
        }

        App.setRoot("usuarioView", "Luxora Wallet - Pagina principal");
    }

    @FXML
    void btn_regresar(MouseEvent event) throws IOException {
        App.setRoot("usuarioView", "Luxora Wallet - Pagina principal");
    }

    @FXML
    void initialize() {
        inicializarTextField();
        txt_telefono.addEventFilter(javafx.scene.input.KeyEvent.KEY_TYPED, event -> {
            if (!event.getCharacter().matches("\\d")) {
                event.consume();
            }
        });
        assert btn_guardar != null : "fx:id=\"btn_guardar\" was not injected: check your FXML file 'actualizarDatosView.fxml'.";
        assert txt_contraseniaActual != null : "fx:id=\"txt_contraseniaActual\" was not injected: check your FXML file 'actualizarDatosView.fxml'.";
        assert txt_contraseniaConfirm != null : "fx:id=\"txt_contraseniaConfirm\" was not injected: check your FXML file 'actualizarDatosView.fxml'.";
        assert txt_contraseniaNueva != null : "fx:id=\"txt_contraseniaNueva\" was not injected: check your FXML file 'actualizarDatosView.fxml'.";
        assert txt_direccion != null : "fx:id=\"txt_direccion\" was not injected: check your FXML file 'actualizarDatosView.fxml'.";
        assert txt_telefono != null : "fx:id=\"txt_telefono\" was not injected: check your FXML file 'actualizarDatosView.fxml'.";

    }
}
