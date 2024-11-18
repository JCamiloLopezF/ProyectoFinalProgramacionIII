package co.edu.uniquindio.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.App;
import co.edu.uniquindio.Model.TipoCuenta;
import co.edu.uniquindio.Model.Usuario;
import co.edu.uniquindio.Persistencia.ArchivoUtil;
import co.edu.uniquindio.Persistencia.GestorCuentas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class CreacionCuentaController {

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

    private GestorCuentas gestorCuentas = new GestorCuentas();
    private Usuario usuarioSeleccionado;

    @FXML
    void btn_aniadirCuenta(ActionEvent event) {
        String idCuenta = txt_idCuenta.getText();
        String nombreBanco = txt_nombreBanco.getText();
        String numeroCuenta = txt_numeroCuenta.getText();
        String tipoCuentaStr = txt_tipoCuenta.getText();
        String saldoStr = txt_saldo.getText();

        if (idCuenta.isEmpty() || nombreBanco.isEmpty() || numeroCuenta.isEmpty() || tipoCuentaStr.isEmpty() || saldoStr.isEmpty()) {
            ArchivoUtil.mostrarAlerta("Error", "Todos los campos deben ser completados");
            return;
        }

        double saldo;
        try {
            saldo = Double.parseDouble(saldoStr);
        } catch (NumberFormatException e) {
            ArchivoUtil.mostrarAlerta("ERROR!!!", "El saldo debe ser un número válido");
            return;
        }

        TipoCuenta tipoCuenta;
        try {
            tipoCuenta = TipoCuenta.valueOf(tipoCuentaStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            ArchivoUtil.mostrarAlerta("ERROR!!!", "Tipo de cuenta inválido");
            return;
        }

        if (gestorCuentas.cuentaExiste(usuarioSeleccionado, idCuenta)) {
            ArchivoUtil.mostrarAlerta("ERROR!!!", "La cuenta ya existe");
            return;
        }

        gestorCuentas.agregarCuentaBancaria(usuarioSeleccionado, idCuenta, nombreBanco, numeroCuenta, tipoCuenta);

        ArchivoUtil.mostrarAlerta("ÉXITO!!", "Miralo pablito eh  eh eh eeeeh");

        txt_idCuenta.clear();
        txt_nombreBanco.clear();
        txt_numeroCuenta.clear();
        txt_saldo.clear();
        txt_tipoCuenta.clear();
    }

    @FXML
    void btn_regresar(MouseEvent event) throws IOException {
        App.setRoot("gestionCuentasView", "Gestiona tus cuentas -LuxoraWallet-");

    }

    @FXML
    void initialize() {
        assert btn_regresar != null : "fx:id=\"btn_regresar\" was not injected: check your FXML file 'creacionCuentaView.fxml'.";
        assert txt_idCuenta != null : "fx:id=\"txt_idCuenta\" was not injected: check your FXML file 'creacionCuentaView.fxml'.";
        assert txt_nombreBanco != null : "fx:id=\"txt_nombreBanco\" was not injected: check your FXML file 'creacionCuentaView.fxml'.";
        assert txt_nombreUsuario != null : "fx:id=\"txt_nombreUsuario\" was not injected: check your FXML file 'creacionCuentaView.fxml'.";
        assert txt_numeroCuenta != null : "fx:id=\"txt_numeroCuenta\" was not injected: check your FXML file 'creacionCuentaView.fxml'.";
        assert txt_saldo != null : "fx:id=\"txt_saldo\" was not injected: check your FXML file 'creacionCuentaView.fxml'.";
        assert txt_tipoCuenta != null : "fx:id=\"txt_tipoCuenta\" was not injected: check your FXML file 'creacionCuentaView.fxml'.";

    }

}
