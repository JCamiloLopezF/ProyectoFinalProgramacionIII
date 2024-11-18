package co.edu.uniquindio.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.App;
import co.edu.uniquindio.Persistencia.GestorArchivo;
import co.edu.uniquindio.View.CuentaView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class GestionCuentasController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txt_cuentaEliminar;

    @FXML
    private Button btn_ActualizarCuenta;

    @FXML
    private Button btn_EliminarCuenta;

    @FXML
    private Button btn_crearCuenta;

    @FXML
    private Text btn_regresar;

    @FXML
    private Label txt_cuentas;

    GestorArchivo gestor = new GestorArchivo();

    @FXML
    void btn_ActualizarCuenta(ActionEvent event) throws IOException {
        App.setRoot("actualizarCuenta", "Actualización de cuenta -LuxoraWallet-");
    }

    @FXML
    void btn_EliminarCuenta(ActionEvent event) throws IOException {
        String idCuenta = txt_cuentaEliminar.getText();
        gestor.eliminarCuenta(idCuenta);
    }

    @FXML
    void btn_crearCuenta(ActionEvent event) throws IOException {
        App.setRoot("creacionCuentaView", "Añade tu cuenta a LuxoraWallet!");
    }

    @FXML
    void btn_regresar(MouseEvent event) throws IOException {
        App.setRoot("usuarioView", "Luxora Wallet - Pagina principal");
    }

    public void inicializarCuentas() throws IOException{
        txt_cuentas.setText("");
        CuentaView cuentas = new CuentaView();
        txt_cuentas.setText(cuentas.mostrarListaCuentas());
    }

    @FXML
    void initialize() throws IOException {

        inicializarCuentas();
        assert btn_ActualizarCuenta != null : "fx:id=\"btn_ActualizarCuenta\" was not injected: check your FXML file 'gestionCuentasView.fxml'.";
        assert btn_EliminarCuenta != null : "fx:id=\"btn_EliminarCuenta\" was not injected: check your FXML file 'gestionCuentasView.fxml'.";
        assert btn_crearCuenta != null : "fx:id=\"btn_crearCuenta\" was not injected: check your FXML file 'gestionCuentasView.fxml'.";
        assert btn_regresar != null : "fx:id=\"btn_regresar\" was not injected: check your FXML file 'gestionCuentasView.fxml'.";
        assert txt_cuentas != null : "fx:id=\"txt_cuentas\" was not injected: check your FXML file 'gestionCuentasView.fxml'.";
    }
}
