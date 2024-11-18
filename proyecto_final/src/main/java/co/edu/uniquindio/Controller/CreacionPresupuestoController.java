package co.edu.uniquindio.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.App;
import co.edu.uniquindio.Model.LuxoraWallet;
import co.edu.uniquindio.Model.Presupuesto;
import co.edu.uniquindio.Model.Usuario;
import co.edu.uniquindio.Persistencia.ArchivoUtil;
import co.edu.uniquindio.Persistencia.GestorArchivo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class CreacionPresupuestoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text btn_regresar;

    @FXML
    private TextField txt_montoPresupuesto;

    @FXML
    private TextField txt_nombrePresupuesto;

    @FXML
    private Text txt_nombreUsuario;

    LuxoraWallet luxoraWallet = LuxoraWallet.getInstanciaUnica();
    Usuario usuarioActual = luxoraWallet.getUsuarioSeleccionado().get(0);
    GestorArchivo gestor = new GestorArchivo();

    @FXML
    void btn_crearPresupuesto(ActionEvent event) throws IOException {
        
        Presupuesto presupuesto = new Presupuesto(txt_nombrePresupuesto.getText(), Double.parseDouble(txt_montoPresupuesto.getText()), usuarioActual.getIdUsuario());
        String valorIngresado = txt_montoPresupuesto.getText();
        Double valor = Double.parseDouble(valorIngresado);
        Double valorActual = usuarioActual.getSaldoDisponible();
        Double valorFinal = valorActual - valor;


        if(valor > valorActual || valor <= 0){
            ArchivoUtil.mostrarAlerta("ERROR!", "Ingrese un valor correcto");
            return;
        }else{
            usuarioActual.setSaldoDisponible(valorFinal);
            gestor.actualizarSaldoUsuario(usuarioActual, valorFinal);
            ArchivoUtil.mostrarAlerta("Presupuesto creado corectamente!", "Se creó correctamente el presupuesto de monto: $" + valor);
       
            gestor.guardarPresupuesto(presupuesto, usuarioActual);
        }

        txt_montoPresupuesto.clear(); //Limpia los campos
        txt_nombrePresupuesto.clear();
        
    }

    @FXML
    void btn_regresar(MouseEvent event) throws IOException {
        App.setRoot("usuarioView", "Luxora Wallet - Pagina principal");
    }

    @FXML
    void initialize() {
        assert btn_regresar != null : "fx:id=\"btn_regresar\" was not injected: check your FXML file 'creacionPresupuestosView.fxml'.";
        assert txt_montoPresupuesto != null : "fx:id=\"txt_montoPresupuesto\" was not injected: check your FXML file 'creacionPresupuestosView.fxml'.";
        assert txt_nombrePresupuesto != null : "fx:id=\"txt_nombrePresupuesto\" was not injected: check your FXML file 'creacionPresupuestosView.fxml'.";
        assert txt_nombreUsuario != null : "fx:id=\"txt_nombreUsuario\" was not injected: check your FXML file 'creacionPresupuestosView.fxml'.";

    }

}