package co.edu.uniquindio.View;

import java.io.IOException;
import java.util.LinkedList;

import co.edu.uniquindio.Controller.AdministradorController;
import co.edu.uniquindio.Model.LuxoraWallet;
import co.edu.uniquindio.Model.Transaccion;
import co.edu.uniquindio.Persistencia.GestorArchivo;

public class AdministradorView {
    LuxoraWallet luxoraWallet = LuxoraWallet.getInstanciaUnica();
    GestorArchivo gestor = new GestorArchivo();

    public String mostrarTransacciones() throws IOException{
        LinkedList<Transaccion> listaTransacciones = gestor.cargarTodasLasTransacciones(luxoraWallet);

        String transacciones = "";

        for(Transaccion transaccion : listaTransacciones){
            transacciones += "Se transfirió $" + transaccion.getMonto() + " el dia " + transaccion.getFechaTransaccion() + "\n";
        }
        return transacciones;
    }  
}
