package co.edu.uniquindio.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import co.edu.uniquindio.App;
import co.edu.uniquindio.Model.LuxoraWallet;
import co.edu.uniquindio.Model.Transaccion;
import co.edu.uniquindio.Model.Usuario;
import co.edu.uniquindio.Persistencia.GestorArchivo;
import co.edu.uniquindio.View.UsuarioView;
import co.edu.uniquindio.View.VerDineroView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class VerTransaccionesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text btn_regresar;

    @FXML
    private Text txt_nombreUsuario;

    @FXML
    private Button btn_mostrarTransaccion;

    @FXML
    private Label txt_transacciones;

    LuxoraWallet luxora = LuxoraWallet.getInstanciaUnica();
    VerDineroView verDineroView = new VerDineroView();
    Usuario usuarioActual = luxora.getUsuarioSeleccionado().get(0);
    UsuarioView usuario = new UsuarioView();


    @FXML
    void btn_regresar(MouseEvent event) throws IOException {
        txt_transacciones.setText("");
        App.setRoot("usuarioView", "Luxora Wallet - Pagina principal");
    }

    @FXML
    void btn_mostrarTransaccion(ActionEvent event) {
        txt_transacciones.setText(" ");
        mostrarTransacciones().clear();
        txt_transacciones.setText(verDineroView.mostrarListaTransacciones());

        btn_mostrarTransaccion.setDisable(true);
    }

    public LinkedList<Transaccion> mostrarTransacciones() {
        GestorArchivo gestor = new GestorArchivo();
        try {
            gestor.cargarTransacciones(luxora, usuarioActual);
            return usuarioActual.getTransacciones();
        } catch(IOException e){
            e.printStackTrace();
        }
		return null;
    }

    @FXML
    void initialize() {
        txt_transacciones.setText("");
        
        txt_nombreUsuario.setText("Transacciones realizadas por: " + usuario.nombreUsuario());

        assert btn_regresar != null : "fx:id=\"btn_regresar\" was not injected: check your FXML file 'verTransacciones.fxml'.";
        assert txt_nombreUsuario != null : "fx:id=\"txt_nombreUsuario\" was not injected: check your FXML file 'verTransacciones.fxml'.";
        assert txt_transacciones != null : "fx:id=\"txt_transacciones\" was not injected: check your FXML file 'verTransacciones.fxml'.";
    }
}
