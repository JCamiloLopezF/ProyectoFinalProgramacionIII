package co.edu.uniquindio.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class EnvioDineroController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_enviar;

    @FXML
    private Text btn_regresar;

    @FXML
    private TextField txt_monto;

    @FXML
    private Text txt_nombreUsuario;

    @FXML
    private TextField txt_numeroCuenta;

    @FXML
    void btn_enviar(ActionEvent event) {

    }

    @FXML
    void btn_regresar(MouseEvent event) throws IOException {
        App.setRoot("usuarioView", "Luxora Wallet - Pagina principal");
    }

    @FXML
    void initialize() {
        assert btn_enviar != null : "fx:id=\"btn_enviar\" was not injected: check your FXML file 'envioDinero.fxml'.";
        assert btn_regresar != null : "fx:id=\"btn_regresar\" was not injected: check your FXML file 'envioDinero.fxml'.";
        assert txt_monto != null : "fx:id=\"txt_monto\" was not injected: check your FXML file 'envioDinero.fxml'.";
        assert txt_nombreUsuario != null : "fx:id=\"txt_nombreUsuario\" was not injected: check your FXML file 'envioDinero.fxml'.";
        assert txt_numeroCuenta != null : "fx:id=\"txt_numeroCuenta\" was not injected: check your FXML file 'envioDinero.fxml'.";

    }

}
