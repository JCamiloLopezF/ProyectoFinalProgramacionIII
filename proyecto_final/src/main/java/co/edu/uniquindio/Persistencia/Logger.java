package co.edu.uniquindio.Persistencia;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private static final String RUTA_LOG_ARCHIVO = "C:\\td\\persistencia\\LuxoraWallet_Log.txt";

    public static void log(String message) {
        try (FileWriter escritura = new FileWriter(RUTA_LOG_ARCHIVO, true);
        PrintWriter imprimir = new PrintWriter(escritura)) {
            imprimir.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void registrarAccion(String usuario, String accion) {
        log("Usuario: " + usuario + " - Accion: " + accion);
    }

    public static void registrarException (String exception) {
        log("Excepción: " + exception);
    }
}
