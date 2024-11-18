package co.edu.uniquindio.Persistencia;

import java.util.List;

import co.edu.uniquindio.Model.Cuenta;
import co.edu.uniquindio.Model.Usuario;

public class GestorCuentas {
    public void agregarCuentaBancaria(Usuario usuario, String idCuenta
            , String nombreBanco, String numeroCuenta, String tipoCuenta, Double saldo, String nombreUsuario) {
        Cuenta nuevaCuenta = new Cuenta(idCuenta, nombreBanco, numeroCuenta, tipoCuenta, saldo, nombreUsuario);
        usuario.getCuentasBancarias().add(nuevaCuenta);
    }

    public void actualizarCuentaBancaria(Usuario usuario, String idCuenta, String nuevoNombreBanco, String nuevoNumeroCuenta, String nuevoTipoCuenta, double nuevoSaldo){
        for (Cuenta cuenta : usuario.getCuentasBancarias()) {
            if (cuenta.getIdCuenta().equals(idCuenta)) {
                cuenta.setNombreBanco(nuevoNombreBanco);
                cuenta.setNumeroCuenta(nuevoNumeroCuenta);
                cuenta.setTipoCuenta(nuevoTipoCuenta);
                cuenta.setSaldo(nuevoSaldo);
                break;
            }
        }
    }

    public void eliminarCuentaBancaria(Usuario usuario, String idCuenta) {
        usuario.getCuentasBancarias().removeIf(cuenta -> cuenta.getIdCuenta().equals(idCuenta));
    }

    public List<Cuenta> obtenerTodasLasCuentas(Usuario usuario) {
        return usuario.getCuentasBancarias();
    }

    public boolean cuentaExiste(Usuario usuario, String idCuenta) {
        for (Cuenta cuenta : usuario.getCuentasBancarias()) {
            if (cuenta.getIdCuenta().equals(idCuenta)) {
                return true;
            }
        }

        return false;
    }
}
