package co.edu.uniquindio.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.App;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class verTransaccionesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text btn_regresar;

    @FXML
    private Text txt_nombreUsuario;

    @FXML
    private Label txt_transacciones;

    @FXML
    void btn_regresar(MouseEvent event) throws IOException {
        App.setRoot("usuarioView", "Luxora Wallet - Pagina principal");
    }

    @FXML
    void initialize() {
        assert btn_regresar != null : "fx:id=\"btn_regresar\" was not injected: check your FXML file 'verTransacciones.fxml'.";
        assert txt_nombreUsuario != null : "fx:id=\"txt_nombreUsuario\" was not injected: check your FXML file 'verTransacciones.fxml'.";
        assert txt_transacciones != null : "fx:id=\"txt_transacciones\" was not injected: check your FXML file 'verTransacciones.fxml'.";

    }

}
