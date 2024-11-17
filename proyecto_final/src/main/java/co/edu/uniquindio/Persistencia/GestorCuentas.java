package co.edu.uniquindio.Persistencia;

import co.edu.uniquindio.Model.Cuenta;
import co.edu.uniquindio.Model.TipoCuenta;
import co.edu.uniquindio.Model.Usuario;

public class GestorCuentas {
    public void agregarCuentaBancaria(Usuario usuario, String idCuenta
            , String nombreBanco, String numeroCuenta, TipoCuenta tipoCuenta) {
        Cuenta nuevaCuenta = new Cuenta(idCuenta, nombreBanco, numeroCuenta, tipoCuenta);
        usuario.getCuentasBancarias().add(nuevaCuenta);
    }

    public void actualizarCuentaBancaria(Usuario usuario, String idCuenta, String nuevoNombreBanco, String nuevoNumeroCuenta, TipoCuenta nuevoTipoCuenta, double nuevoSaldo){
        for (Cuenta cuenta : usuario.getCuentasBancarias()) {
            
        }
    }
}
