package co.edu.uniquindio.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.App;
import co.edu.uniquindio.Model.LuxoraWallet;
import co.edu.uniquindio.Persistencia.GestorArchivo;
import co.edu.uniquindio.View.AdministradorView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class AdministradorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label txt_transaccionesRealizadas;

    LuxoraWallet luxora = LuxoraWallet.getInstanciaUnica();
    GestorArchivo gestor = new GestorArchivo();
    AdministradorView adminView = new AdministradorView();

    @FXML
    void btn_cerrarSesion(MouseEvent event) throws IOException {
        App.setRoot("inicioSesion", "Luxora Wallet -Inicia sesión-");
    }

    @FXML
    void btn_estadisticas(MouseEvent event) {

    }

    @FXML
    void btn_generarReportes(MouseEvent event) {

    }

    @FXML
    void btn_gestionarUsuario(MouseEvent event) throws IOException {
        App.setRoot("adminGUsuario", "Admin ");
    }

    public void mostrarTransacciones() throws IOException{
        txt_transaccionesRealizadas.setText(adminView.mostrarTransacciones());
    }

    @FXML
    void initialize() throws IOException {
        mostrarTransacciones();

        assert txt_transaccionesRealizadas != null : "fx:id=\"txt_transaccionesRealizadas\" was not injected: check your FXML file 'aministradorView.fxml'.";
    }
}
