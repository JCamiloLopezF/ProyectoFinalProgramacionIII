package co.edu.uniquindio.Model;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            new GestorArchivo().eliminarUsuario(correo);
        }
    }

    public List<Usuario> listarUsuarios() throws IOException {
        return new GestorArchivo().cargarUsuarios(new LuxoraWallet());
    }

    public Usuario buscarUsuarioPorCorreo(String correo) throws IOException {
        LuxoraWallet luxoraWallet = new LuxoraWallet();
        List<Usuario> listaUsuarios = new GestorArchivo().cargarUsuarios(luxoraWallet);

        for (Usuario usuario : listaUsuarios) {
            if (usuario.getCorreo().equalsIgnoreCase(correo)) {
                return usuario;
            }
        }
        return null;
    }

    //Gestionar cuentas bancarias
    public void agregarCuentaBancaria(Usuario usuario, String idCuenta, String nombreBanco, String numeroCuenta, String tipoCuenta, Double saldo) throws IOException {
        new GestorCuentas().agregarCuentaBancaria(usuario, idCuenta, nombreBanco, numeroCuenta, tipoCuenta, saldo, usuario.getNombreCompleto());
    }

    public void actualizarCuentaBancaria(Usuario usuario, String idCuenta, String nuevoNombreBanco, String nuevoNumeroCuenta, String nuevoTipoCuenta, double nuevoSaldo) throws IOException {
        new GestorCuentas().actualizarCuentaBancaria(usuario, idCuenta, nuevoNombreBanco, nuevoNumeroCuenta, nuevoTipoCuenta, nuevoSaldo);
    }

    public void eliminarCuentaBancaria(Usuario usuario, String idCuenta) throws IOException {
        new GestorCuentas().eliminarCuentaBancaria(usuario, idCuenta);
    }

    //Gestionar transacciones

    public void crearTransaccion(String idTransaccion, String fechaTransaccion, String monto, String descripcionOpcional, String numeroCuenta, String idUsuario, Usuario usuario) throws IOException {
        
        Transaccion transaccion = new Transaccion(idTransaccion, fechaTransaccion, monto, descripcionOpcional, numeroCuenta, idUsuario );
        
        new GestorArchivo().guardarTransaccion(transaccion, usuario);
    }

    public List<Transaccion> listarTransacciones(Usuario usuario) throws IOException {
        List<Transaccion> todasLasTransacciones = new GestorArchivo().cargarTransacciones(new LuxoraWallet(), usuario);

        return todasLasTransacciones.stream()
        .filter(transaccion -> transaccion.getIdUsuario().equals(usuario.getIdUsuario()))
        .collect(Collectors.toList());
    }

    public void mostrarEstadisticas() {
        //...
    }

    public void mostrarEstadisticasEnGrafica() {
        //dios mio
    }

    public void gastosComunes() {
        //aaaaa
    }

    public void usuariosConMasTransacciones() throws IOException{
        List<Transaccion> transacciones = listarTransacciones();
        Map<String, Integer> conteoTransacciones = new HashMap<>();

        for (Transaccion transaccion : transacciones) {
            String correoUsuario = transaccion.getCorreoUsuario();
            conteoTransacciones.put(correoUsuario, conteoTransacciones.getOrDefault(correoUsuario,0) + 1 );
        }
    }

    public void saldoPromedioUsuarios() {
        //aaaaaa
    }
}



