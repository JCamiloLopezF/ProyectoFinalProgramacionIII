package co.edu.uniquindio.Persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializacion {
    public static void serializar(String archivo, Object objeto) {
        try (ObjectOutputStream  oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(objeto);
        } catch (IOException e) {
        System.err.println("Error al serializar: " + e.getMessage());
        }
    }

    public static Object deserializar(String archivo, Object objeto) {
        try (ObjectInputStream  ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al deserializar: " + e.getMessage());
            return null;
        }
    }
}