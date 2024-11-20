package co.edu.uniquindio.View;

import java.io.IOException;
import java.util.LinkedList;

import co.edu.uniquindio.Controller.GestionPresupuestosController;
import co.edu.uniquindio.Model.Categoria;
import co.edu.uniquindio.Model.LuxoraWallet;
import co.edu.uniquindio.Model.Presupuesto;
import co.edu.uniquindio.Model.Transaccion;
import co.edu.uniquindio.Model.Usuario;
import co.edu.uniquindio.Persistencia.GestorArchivo;

public class PresupuestosView {
    LuxoraWallet luxoraWallet = LuxoraWallet.getInstanciaUnica();
    Usuario usuarioActual = luxoraWallet.getUsuarioSeleccionado().get(0);
    GestorArchivo gestor = new GestorArchivo();
    GestionPresupuestosController presupuestos = new GestionPresupuestosController();

    public String mostrarListaPresupuestos() throws IOException{
        LinkedList<Presupuesto> listaPresupuestos = gestor.cargarPresupuestos(usuarioActual);

        String presupuesto = "";
        for(Presupuesto pr: listaPresupuestos){
            presupuesto += "Motivo: " + pr.getNombre() + " por un valor de: $" + pr.getMontoTotalAsignado() +"\n";
        }
        return presupuesto;
    }

    public void actualizarPresupuesto(String nombrePresupuesto, double nuevoMonto) throws IOException {
        LinkedList<Presupuesto> listaPresupuestos = gestor.cargarPresupuestos(usuarioActual);
        for (Presupuesto pr : listaPresupuestos) {
            if (pr.getNombre().equals(nombrePresupuesto)) {
                pr.setMontoTotalAsignado(nuevoMonto);
                gestor.guardarPresupuestosActualizados(usuarioActual);
                break;
            }
        }
    }

    public void eliminarPresupuesto(String nombrePresupuesto) throws IOException {
        gestor.eliminarPresupuesto(nombrePresupuesto);
    }

    public String monitorearGastoPorCategoria(Categoria categoria) {
        LinkedList<Transaccion> transacciones = usuarioActual.filtrarTransaccionesPorCategoria(categoria);
        double totalGasto = 0;
        for (Transaccion transaccion : transacciones) {
            totalGasto += Double.parseDouble(transaccion.getMonto());
        }
        return "Total gastado en la categoría " + categoria.getNombre() + ": $" + totalGasto;
    }
}
