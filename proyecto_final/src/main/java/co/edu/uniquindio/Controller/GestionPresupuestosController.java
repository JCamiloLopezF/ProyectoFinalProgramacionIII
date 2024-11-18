package co.edu.uniquindio.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.App;
import co.edu.uniquindio.Model.LuxoraWallet;
import co.edu.uniquindio.Model.Usuario;
import co.edu.uniquindio.Persistencia.GestorArchivo;
import co.edu.uniquindio.View.PresupuestosView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class GestionPresupuestosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text btn_regresar;

    @FXML
    private TextField txt_presupuestoEliminar;

    @FXML
    private Label txt_presupuestos;

    LuxoraWallet luxoraWallet = LuxoraWallet.getInstanciaUnica();
    Usuario usuarioActual = luxoraWallet.getUsuarioSeleccionado().get(0);
    GestorArchivo gestor = new GestorArchivo();
    CreacionPresupuestoController creacion = new CreacionPresupuestoController();

    @FXML
    void btn_EliminarPresupuesto(ActionEvent event) throws IOException {
        String nombrePresupuesto = txt_presupuestoEliminar.getText();
        double presupuestoEliminado = gestor.eliminarPresupuesto(nombrePresupuesto);

        Double valorUsuario = usuarioActual.getSaldoDisponible();

        Double valorNuevo = valorUsuario + presupuestoEliminado;
        usuarioActual.setSaldoDisponible(valorNuevo);

    }

    @FXML
    void btn_crearPresupuesto(ActionEvent event) throws IOException {
        App.setRoot("creacionPresupuestosView", "Crea tu presupuesto y ahorro -LuxoraWallet-");
    }

    @FXML
    void btn_regresar(MouseEvent event) throws IOException {
        App.setRoot("usuarioView", "Luxora Wallet - Pagina principal");

    }

    public void inicializarPresupuestos() throws IOException{
        PresupuestosView presupuesto = new PresupuestosView();
        txt_presupuestos.setText(presupuesto.mostrarListaPresupuestos());
    }

    @FXML
    void initialize() throws IOException {
        inicializarPresupuestos();

        assert btn_regresar != null : "fx:id=\"btn_regresar\" was not injected: check your FXML file 'gestionPresupuestosView.fxml'.";
        assert txt_presupuestos != null : "fx:id=\"txt_presupuestos\" was not injected: check your FXML file 'gestionPresupuestosView.fxml'.";
    }
}
