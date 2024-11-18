package co.edu.uniquindio.View;

import java.io.IOException;
import java.util.LinkedList;

import co.edu.uniquindio.Controller.GestionCuentasController;
import co.edu.uniquindio.Model.Cuenta;
import co.edu.uniquindio.Model.LuxoraWallet;
import co.edu.uniquindio.Model.Usuario;
import co.edu.uniquindio.Persistencia.GestorArchivo;

public class CuentaView {
    LuxoraWallet luxoraWallet = LuxoraWallet.getInstanciaUnica();
    Usuario usuarioActual = luxoraWallet.getUsuarioSeleccionado().get(0);
    GestorArchivo gestor = new GestorArchivo();
    GestionCuentasController cuentas = new GestionCuentasController();

    public String mostrarListaCuentas() throws IOException{
        LinkedList<Cuenta> listaCuantas = gestor.cargarCuentasBancarias(usuarioActual);

        String cuenta = "";
        for(Cuenta cuent: listaCuantas){
            cuenta += "Cuenta " + cuent.getNombreBanco() + " por un valor de: $" + cuent.getSaldo() + "\n";
        }
        return cuenta;
    }
}
