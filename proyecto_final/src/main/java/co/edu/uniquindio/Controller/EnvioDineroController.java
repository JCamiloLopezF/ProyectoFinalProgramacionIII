package co.edu.uniquindio.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.App;
import co.edu.uniquindio.Model.LuxoraWallet;
import co.edu.uniquindio.Model.Transaccion;
import co.edu.uniquindio.Model.Usuario;
import co.edu.uniquindio.Persistencia.ArchivoUtil;
import co.edu.uniquindio.Persistencia.GestorArchivo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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
    private TextField txt_descripcion;

    @FXML
    private TextField txt_fecha;

    @FXML
    private TextField txt_monto;

    @FXML
    private TextField txt_idCuenta;
    
    @FXML
    private Text txt_nombreUsuario;

    @FXML
    private TextField txt_numeroCuenta;

    LuxoraWallet luxoraWallet = LuxoraWallet.getInstanciaUnica();

    @FXML
    void btn_enviar(ActionEvent event) throws IOException {
        String idTransaccion = txt_idCuenta.getText();
        String numeroCuenta = txt_numeroCuenta.getText();
        String descripcion = txt_descripcion.getText();
        String montoStr = txt_monto.getText();
        String fecha = txt_fecha.getText();

        Transaccion transaccion = new Transaccion(idTransaccion, fecha, montoStr, descripcion, numeroCuenta);
        guardarTransaccion(transaccion);

        if (numeroCuenta.isEmpty() || montoStr.isEmpty() || fecha == null) {
            ArchivoUtil.mostrarAlerta("ERROR!", "Por favor, complete todos los campos requeridos.");
            return;
        }
        
        try {
            double monto = Double.parseDouble(montoStr);

            if (monto <= 0) {
                ArchivoUtil.mostrarAlerta("ERROR!", "El monto debe ser mayor a cero.");
                return;
            }

            System.out.println("");
            ArchivoUtil.mostrarAlerta("ÉXITO!", "Transacción realizada con éxito.");
        } catch (NumberFormatException e) {
            ArchivoUtil.mostrarAlerta("ERROR", "El monto ingresado no es válido.");
        }

        App.setRoot("usuarioView", "Luxora Wallet - Pagina principal");
    }

    public void guardarTransaccion(Transaccion transaccion) throws IOException{
        //GUardado del usuario en archivoUsuarios
        GestorArchivo persistencia = new GestorArchivo();
        persistencia.guardarTransaccion(transaccion);
        luxoraWallet.getTransacciones().add(transaccion);
    }

    @FXML
    void btn_regresar(MouseEvent event) throws IOException {
        App.setRoot("usuarioView", "Luxora Wallet - Pagina principal");
  
    }

    @FXML
    void initialize() {
        assert btn_enviar != null : "fx:id=\"btn_enviar\" was not injected: check your FXML file 'envioDinero.fxml'.";
        assert btn_regresar != null : "fx:id=\"btn_regresar\" was not injected: check your FXML file 'envioDinero.fxml'.";
        assert txt_descripcion != null : "fx:id=\"txt_descripcion\" was not injected: check your FXML file 'envioDinero.fxml'.";
        assert txt_fecha != null : "fx:id=\"txt_fecha\" was not injected: check your FXML file 'envioDinero.fxml'.";
        assert txt_monto != null : "fx:id=\"txt_monto\" was not injected: check your FXML file 'envioDinero.fxml'.";
        assert txt_nombreUsuario != null : "fx:id=\"txt_nombreUsuario\" was not injected: check your FXML file 'envioDinero.fxml'.";
        assert txt_numeroCuenta != null : "fx:id=\"txt_numeroCuenta\" was not injected: check your FXML file 'envioDinero.fxml'.";

    }
}
