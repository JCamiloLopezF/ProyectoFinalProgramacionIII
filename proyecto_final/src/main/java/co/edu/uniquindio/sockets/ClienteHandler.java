package co.edu.uniquindio.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import co.edu.uniquindio.Model.Transaccion;
import co.edu.uniquindio.Model.Usuario;
import co.edu.uniquindio.Persistencia.GestorArchivo;

public class ClienteHandler implements Runnable {
    private Socket socket;

    public ClienteHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            PrintWriter writer = new PrintWriter(output, true)
        ) {
            String mensaje;
            while ((mensaje = reader.readLine()) != null) {
                System.out.println("Mensaje recibido: " + mensaje);
                //String respuesta = procesarSolicitud(mensaje);
                //writer.println(respuesta);
            }
        } catch (IOException e) {
            System.err.println("Error en la comunicación con el cliente: " + e.getMessage());
        }
    }

    /*public String procesarSolicitud(String mensaje) {
        //lógica del cliente

        String[] partes = mensaje.split(":");

        switch (partes[0]) {
            case "agregarUsuario":
                return agregarUsuario(partes);
            case "realizarTransaccion":
                return realizarTransaccion(partes);
            case "verSaldo":
                return verSaldo(partes);
            case "estadisticas":
                return mostrarEstadisticas();
            default:
                return "Acción no reconocida.";
    }*/

    private String agregarUsuario(String[] partes) {
        try {
            String nombre = partes[1];
            String correo = partes[2];
            String telefono = partes[3];
            String direccion = partes[4];
            String id = partes[5];
            String contrasenia = partes[6];
            double saldo = Double.parseDouble(partes[7]);

            Usuario usuario = new Usuario(nombre, correo, telefono, direccion, id, contrasenia, saldo);
            GestorArchivo gestor = new GestorArchivo();
            gestor.guardarUsuario(usuario);

            return "Usuario agregado correctamente.";
        } catch (Exception e) {
            return "Error al agregar el usuario: " + e.getMessage();
        }
    }

    /*private String realizarTransaccion(String[] partes) {
        try {
            String idOrigen = partes[1];
            String idDestino = partes[2];
            String monto = partes[3];
            String descripcion = partes[4];
            String numeroCuenta = partes[5];
            String nombreUsuario = partes[6];

            Transaccion transaccion = new Transaccion(idOrigen, idDestino, monto, descripcion, numeroCuenta, nombreUsuario);
            
            GestorArchivo gestor = new GestorArchivo();
            gestor.guardarTransaccion(transaccion);

            gestor.actualizarSaldoCuentasBancarias(idOrigen, monto);
            gestor.actualizarSaldoCuentas
        }
    }*/
}