package co.edu.uniquindio.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.App;
import co.edu.uniquindio.Model.Usuario;
import co.edu.uniquindio.Persistencia.ArchivoUtil;
import co.edu.uniquindio.Persistencia.GestorCuentas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class ActualizacionCuentaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text btn_regresar;

    @FXML
    private TextField txt_idCuenta;

    @FXML
    private TextField txt_nombreBanco;

    @FXML
    private Text txt_nombreUsuario;

    @FXML
    private TextField txt_numeroCuenta;

    @FXML
    private TextField txt_saldo;

    @FXML
    private TextField txt_tipoCuenta;

    private Usuario usuario;
    private GestorCuentas gestorCuentas = new GestorCuentas();

    @FXML
    void btn_actualizarCuenta(ActionEvent event) {
        try {
            String idCuenta = txt_idCuenta.getText();
            String nuevoNombreBanco = txt_nombreBanco.getText();
            String nuevoNumeroCuenta = txt_numeroCuenta.getText();
            double nuevoSaldo = Double.parseDouble(txt_saldo.getText());
            String nuevoTipoCuenta = txt_tipoCuenta.getText();

            if (gestorCuentas.cuentaExiste(usuario, idCuenta)) {
                gestorCuentas.actualizarCuentaBancaria(usuario, idCuenta, nuevoNombreBanco, nuevoNumeroCuenta, nuevoTipoCuenta, nuevoSaldo);
                ArchivoUtil.mostrarAlerta("CUENTA ACTUALIZADA", "La cuenta ha sido actualizada");
            } else {
                ArchivoUtil.mostrarAlerta("ERROR", "No se encontró el ID de cuenta.");
            }
        } catch (NumberFormatException e) {
            ArchivoUtil.mostrarAlerta("ERROR!!", "El saldo debe ser un número válido.");
        } catch (IllegalArgumentException e) {
            ArchivoUtil.mostrarAlerta("ERROR!!", "El tipo de cuenta proporcionada no es válido.");
        }
    }

    @FXML
    void btn_regresar(MouseEvent event) throws IOException {
        App.setRoot("gestionCuentasView", "Luxora Wallet - Pagina principal");
    }

    @FXML
    void initialize() {
        assert btn_regresar != null : "fx:id=\"btn_regresar\" was not injected: check your FXML file 'actualizarCuenta.fxml'.";
        assert txt_idCuenta != null : "fx:id=\"txt_idCuenta\" was not injected: check your FXML file 'actualizarCuenta.fxml'.";
        assert txt_nombreBanco != null : "fx:id=\"txt_nombreBanco\" was not injected: check your FXML file 'actualizarCuenta.fxml'.";
        assert txt_nombreUsuario != null : "fx:id=\"txt_nombreUsuario\" was not injected: check your FXML file 'actualizarCuenta.fxml'.";
        assert txt_numeroCuenta != null : "fx:id=\"txt_numeroCuenta\" was not injected: check your FXML file 'actualizarCuenta.fxml'.";
        assert txt_saldo != null : "fx:id=\"txt_saldo\" was not injected: check your FXML file 'actualizarCuenta.fxml'.";
        assert txt_tipoCuenta != null : "fx:id=\"txt_tipoCuenta\" was not injected: check your FXML file 'actualizarCuenta.fxml'.";

    }

}
