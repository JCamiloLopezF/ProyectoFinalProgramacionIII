package co.edu.uniquindio.View;

import java.io.IOException;
import java.util.LinkedList;

import co.edu.uniquindio.Controller.GestionPresupuestosController;
import co.edu.uniquindio.Model.LuxoraWallet;
import co.edu.uniquindio.Model.Presupuesto;
import co.edu.uniquindio.Model.Usuario;
import co.edu.uniquindio.Persistencia.GestorArchivo;

public class VerPresupuestos {
    LuxoraWallet luxoraWallet = LuxoraWallet.getInstanciaUnica();
    Usuario usuarioActual = luxoraWallet.getUsuarioSeleccionado().get(0);
    GestorArchivo gestor = new GestorArchivo();

    public String mostrarListaPresupuestos() throws IOException{
        GestionPresupuestosController presupuestos = new GestionPresupuestosController();
        LinkedList<Presupuesto> listaPresupuestos = gestor.cargarPresupuestos(usuarioActual);

        String presupuesto = "";
        for(Presupuesto pr: listaPresupuestos){
            presupuesto += "Motivo: " + pr.getNombre() + " por un valor de: $" + pr.getMontoTotalAsignado() +"\n";
        }
        return presupuesto;
    }
}
