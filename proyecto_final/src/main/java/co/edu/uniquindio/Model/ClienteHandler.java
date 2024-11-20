package co.edu.uniquindio.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

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
                String respuesta = procesarSolicitud(mensaje);
                writer.println(respuesta);
            }
        } catch (IOException e) {
            System.err.println("Error en la comunicación con el cliente: " + e.getMessage());
        }
    }

    public String procesarSolicitud(String mensaje) {
        //lógica del cliente
        return "Solicitud presentada: " + mensaje;
    }
}
