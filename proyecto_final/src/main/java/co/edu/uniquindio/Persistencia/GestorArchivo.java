package co.edu.uniquindio.Persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import co.edu.uniquindio.Model.Usuario;

public class GestorArchivo {
    private static final String RUTA_USUARIO_ARCHIVO = "C:\\td\\persistencia\\usuarios.txt";

    public static void guardarUsuario(Usuario usuario) {
        try (BufferedWriter escritura = new BufferedWriter(new FileWriter(RUTA_USUARIO_ARCHIVO, true))) {
            escritura.write(usuario.toString() + "\n");
        } catch (IOException e) {
            System.err.println("Error al guardar el usuario: "+ e.getMessage());
        }
    }

    public static void cargarUsuarios() {
        try (BufferedReader lectura = new BufferedReader(new FileReader(RUTA_USUARIO_ARCHIVO))) {
            String linea;

            while ((linea = lectura.readLine()) != null) {
                String[] datos = linea.split("@@");

                String idUsuario = datos[0];
                String nombreCompleto = datos[1];
                String correo = datos[2];
                String numeroTelefono = datos[3];
                String contrasenia = datos[4];
                double saldoDisponible = Double.parseDouble(datos[5]);

                Usuario usuario = new Usuario(idUsuario, nombreCompleto, correo, numeroTelefono, contrasenia, saldoDisponible);

            }
        } catch (IOException e) {
            System.err.println("Error al cargar usuarios: " + e.getMessage());
        }
    }
}
