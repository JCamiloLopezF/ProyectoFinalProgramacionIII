package co.edu.uniquindio.View;

import java.util.LinkedList;

import co.edu.uniquindio.Controller.VerTransaccionesController;
import co.edu.uniquindio.Model.Transaccion;

public class VerDineroView {

    public String mostrarListaTransacciones(){
        VerTransaccionesController transacciones = new VerTransaccionesController();
        LinkedList<Transaccion> listaTransacciones = transacciones.mostrarTransacciones();

        String transaccion = "";
        for(Transaccion tr : listaTransacciones){
            transaccion += "Se envió $" + tr.getMonto() + " a la cuenta " + tr.getNumeroCuenta() + " el dia " + tr.getFechaTransaccion() + "\n";
        }
        return transaccion;
    }
}
