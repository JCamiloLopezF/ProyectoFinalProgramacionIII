package co.edu.uniquindio.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import co.edu.uniquindio.App;
import co.edu.uniquindio.Model.LuxoraWallet;
import co.edu.uniquindio.Model.Usuario;
import co.edu.uniquindio.Persistencia.ArchivoUtil;
import co.edu.uniquindio.Persistencia.GestorArchivo;
import co.edu.uniquindio.View.UsuarioView;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.control.Label;

public class UsuarioController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text txt_saldoCensurado;

    @FXML
    private Text txt_saldo;

    @FXML
    private Text btn_saldoDisponible;

    @FXML
    private Text txt_nombreUsuario;

    LuxoraWallet luxoraWallet = LuxoraWallet.getInstanciaUnica();
    Usuario usuarioActual = luxoraWallet.getUsuarioSeleccionado().get(0);
    UsuarioView usuario = new UsuarioView();
    
    boolean visibilidadSaldo = false;

    @FXML
    void btn_actualizarDatos(MouseEvent event) throws IOException {
        App.setRoot("actualizarDatosView", "Actualice sus Datos -Modificacion-");
    }

    @FXML
    void btn_gestionarCuentas(MouseEvent event) {

    }

    @FXML
    void btn_verTransacciones(MouseEvent event) throws IOException {
        App.setRoot("verTransacciones", "Transacciones -LuxoraWallet-");
    }

    @FXML
    void btn_enviarDinero(MouseEvent event) throws IOException {
        App.setRoot("envioDinero", "Envie su dinero -LuxoraWallet-");
    }

    @FXML
    void btn_saldoDisponible(MouseEvent event) {
        ArchivoUtil.guardarRegistroLog("El usuario " + usuarioActual.getIdUsuario() + " consultó su saldo", 1, "consultarSaldo", "C:/td/persistencia/log/luxoraWallet_Log.txt");
        System.out.println("Consultar saldo");

        visibilidadSaldo = !visibilidadSaldo;

        txt_saldoCensurado.setVisible(!visibilidadSaldo);
        txt_saldo.setVisible(visibilidadSaldo); 
    }

    public void iniciar_nombre(){
        txt_nombreUsuario.setText("Hola " + usuario.nombreUsuario());
    }

    @FXML
    void btn_cerrarSesion(MouseEvent event) throws IOException {
        luxoraWallet.usuarioSeleccionado.remove();
        App.setRoot("inicioSesion", "Luxora Wallet -Inicia sesión-");
    }

    @FXML
    void initialize() {
        iniciar_nombre();
        ArchivoUtil.guardarRegistroLog("El usuario: " + usuarioActual.getIdUsuario() + " inició sesión", 1, "inicioSesionUsuario", "C:/td/persistencia/log/luxoraWallet_Log.txt");

        txt_saldoCensurado.setVisible(true);
        txt_saldo.setVisible(false);


        assert txt_nombreUsuario != null : "fx:id=\"txt_idUsuario\" was not injected: check your FXML file 'usuarioView.fxml'.";   
    }
}
