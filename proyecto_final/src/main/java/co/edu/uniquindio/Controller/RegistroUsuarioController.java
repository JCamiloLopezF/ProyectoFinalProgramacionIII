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
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;


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
    private TextField txt_direccion;

    @FXML
    private Text btn_salir;

    @FXML
    private TextField txt_correo;

    @FXML
    private TextField txt_nombre;

    @FXML
    private TextField txtx_usuario;

    LuxoraWallet luxoraWallet = LuxoraWallet.getInstanciaUnica();

    @FXML
    void btn_registrar(ActionEvent event) throws Exception {    
        String nombre = txt_nombre.getText(); 
        String telefono = txt_telefono.getText();
        String correo = txt_correo.getText();
        String direccion = txt_direccion.getText();
        String usuario = txtx_usuario.getText();
        String contrasenia = txt_contrasenia.getText();
        Usuario usuarioNuevo = new Usuario(nombre, correo, telefono, direccion, usuario, contrasenia, 0);

        GestorArchivo persistencia = new GestorArchivo();
        String rutaArchivoBin = persistencia.obtenerRutaProperties("rutaRecursoSerializado");
        String rutaArchivoXML = persistencia.obtenerRutaProperties("rutaSerializadoXML");
        
        guardarUsuario(usuarioNuevo);

        //Creacion del Log, registroUsuario
        ArchivoUtil.guardarRegistroLog("Se registró el usuario: " + usuario, 1, "registroUsuario", "C:/td/persistencia/log/luxoraWallet_Log.txt");
       
        //Creación del XML y binario
        ArchivoUtil.salvarRecursoSerializado(rutaArchivoBin, usuarioNuevo, true);
        ArchivoUtil.salvarRecursoSerializadoXML(rutaArchivoXML, usuarioNuevo);

        App.setRoot("inicioSesion", "Luxora Wallet - Inicio de sesión");
    }

    public void guardarUsuario(Usuario usuarioNuevo) throws IOException{
        //GUardado del usuario en archivoUsuarios
        GestorArchivo persistencia = new GestorArchivo();
        persistencia.guardarUsuario(usuarioNuevo);
        luxoraWallet.getUsuarios().add(usuarioNuevo);
    }

    @FXML
    void btn_salir(MouseEvent event) throws IOException {
        App.setRoot("usuarioView", "Luxora Wallet - Pagina principal");
    }

    @FXML
    void initialize() {
        txt_telefono.addEventFilter(javafx.scene.input.KeyEvent.KEY_TYPED, event -> {
            if (!event.getCharacter().matches("\\d")) {
                event.consume();
            }
        });
        assert btn_registrar != null : "fx:id=\"btn_registrar\" was not injected: check your FXML file 'registroUsuarioView.fxml'.";
        assert txt_telefono != null : "fx:id=\"txt_cedula\" was not injected: check your FXML file 'registroUsuarioView.fxml'.";
        assert txt_contrasenia != null : "fx:id=\"txt_contrasenia\" was not injected: check your FXML file 'registroUsuarioView.fxml'.";
        assert txt_correo != null : "fx:id=\"txt_correo\" was not injected: check your FXML file 'registroUsuarioView.fxml'.";
        assert txt_nombre != null : "fx:id=\"txt_nombre\" was not injected: check your FXML file 'registroUsuarioView.fxml'.";
        assert txtx_usuario != null : "fx:id=\"txtx_usuario\" was not injected: check your FXML file 'registroUsuarioView.fxml'.";
    }
}
