package co.edu.uniquindio.Model;

import java.io.IOException;
import java.util.List;

import co.edu.uniquindio.Persistencia.GestorArchivo;
import co.edu.uniquindio.Persistencia.GestorCuentas;


public class Administrador extends Usuario {
    public Administrador (String nombreCompleto, String correo, String numeroTelefono, String direccion, String idUsuario, String contrasenia, double saldoDisponible) {
        super(nombreCompleto, correo, numeroTelefono, direccion, idUsuario, contrasenia, saldoDisponible);
    }

    public void crearUsuario(String nombreCompleto, String correo, String numeroTelefono, String direccion, String idUsuario, String contrasenia, double saldo) throws IOException {
        Usuario nuevoUsuario = new Usuario(nombreCompleto, correo, numeroTelefono, direccion, idUsuario, contrasenia, saldo);
        new GestorArchivo().guardarUsuario(nuevoUsuario);
    }

    public void actualizarUsuario(String correo, String nuevaDireccion, String nuevoTelefono, String nuevaContrasenia) throws IOException {
        Usuario usuario = buscarUsuarioPorCorreo(correo);
        if (usuario != null) {
            new GestorArchivo().actualizarDatosParcialesUsuario(usuario, nuevaDireccion, nuevoTelefono, nuevaContrasenia);
        }
    }
    
    public void eliminarUsuario(String correo) throws IOException {
        Usuario usuario = buscarUsuarioPorCorreo(correo);
        if (usuario != null) {
            //new GestorArchivo().eliminarUsuario(usuario);
        }
    }

    public List<Usuario> listarUsuarios() throws IOException {
        return new GestorArchivo().cargarUsuarios(new LuxoraWallet());
    }

    public Usuario buscarUsuarioPorCorreo(String correo) {
        //...
        return null;
    }

    public void agregarCuentaBancaria(Usuario usuario, String idCuenta, String nombreBanco, String numeroCuenta, String tipoCuenta, Double saldo) throws IOException {
        new GestorCuentas().agregarCuentaBancaria(usuario, idCuenta, nombreBanco, numeroCuenta, tipoCuenta, saldo, usuario.getNombreCompleto());
    }

    public void actualizarCuentaBancaria(Usuario usuario, String idCuenta, String nuevoNombreBanco, String nuevoNumeroCuenta, String nuevoTipoCuenta, double nuevoSaldo) throws IOException {
        new GestorCuentas().actualizarCuentaBancaria(usuario, idCuenta, nuevoNombreBanco, nuevoNumeroCuenta, nuevoTipoCuenta, nuevoSaldo);
    }

    public void eliminarCuentaBancaria(Usuario usuario, String idCuenta) throws IOException {
        new GestorCuentas().eliminarCuentaBancaria(usuario, idCuenta);
    }

    public void crearTransaccion(Transaccion transaccion) throws IOException {
        //new GestorArchivo().guardarTransaccion(transaccion);
    }

    public List<Transaccion> listarTransacciones() throws IOException {
        return null;
    }



}