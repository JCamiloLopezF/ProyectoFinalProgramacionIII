package co.edu.uniquindio.Model;

import java.io.IOException;

import co.edu.uniquindio.Persistencia.GestorArchivo;


public class Administrador extends Usuario {
    public Administrador (String nombreCompleto, String correo, String numeroTelefono, String direccion, String idUsuario, String contrasenia, double saldoDisponible) {
        super(nombreCompleto, correo, numeroTelefono, direccion, idUsuario, contrasenia, saldoDisponible);
    }

    public void crearUsuario(String nombreCompleto, String correo, String numeroTelefono, String direccion, String idUsuario, String contrasenia, double saldo) throws IOException {
        Usuario nuevoUsuario = new Usuario(nombreCompleto, correo, numeroTelefono, direccion, idUsuario, contrasenia, saldo);
        new GestorArchivo().guardarUsuario(nuevoUsuario);
    }

    //public void actualizarUsuario
}