package co.edu.uniquindio.Persistencia;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ArchivoUtil {
    static String fechaSistema = "";

    public static void guardarArchivo(String ruta,String contenido, Boolean flagAnexarContenido) throws IOException {

        File archivo = new File(ruta);
        File directorio = archivo.getParentFile();

        if (directorio != null && !directorio.exists()) {
            directorio.mkdirs();  // Crea los directorios si no existen
        }

        FileWriter fw = new FileWriter(ruta,flagAnexarContenido);
        BufferedWriter bfw = new BufferedWriter(fw);
        bfw.write(contenido);
        bfw.close();
        fw.close();
    }

    public static ArrayList<String> leerArchivo(String ruta) throws IOException {
        ArrayList<String>  contenido = new ArrayList<String>();
        //abrir conexion
        FileReader fr=new FileReader(ruta);
        BufferedReader bfr=new BufferedReader(fr);
        // leer
        String linea="";
        while((linea = bfr.readLine())!=null)
        {
            contenido.add(linea);
        }
        //cerrar
        bfr.close();
        fr.close();
        return contenido;
    }

    public static void guardarRegistroLog(String mensajeLog, int nivel, String accion, String rutaArchivo){
        String log = "";
        Logger LOGGER = Logger.getLogger(accion);
        FileHandler fileHandler = null;

        cargarFechaSistema();

        try{
            fileHandler = new FileHandler(rutaArchivo,true);
			fileHandler.setFormatter(new SimpleFormatter());
			LOGGER.addHandler(fileHandler);

			switch (nivel) {
			case 1:
				LOGGER.log(Level.INFO,accion+", " + mensajeLog + "\n") ;
				break;

			case 2:
				LOGGER.log(Level.WARNING,accion+", "+ mensajeLog + "\n") ;
				break;

			case 3:
				LOGGER.log(Level.SEVERE,accion+", "+ mensajeLog + "\n") ;
				break;

			default:
				break;
			}
        }catch(SecurityException e){
            LOGGER.log(Level.SEVERE,e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOGGER.log(Level.SEVERE,e.getMessage());
			e.printStackTrace();
		}
		finally {
			fileHandler.close();
		}      
    }

    private static void cargarFechaSistema() {
        String diaN= "";
        String mesN= "";
        String anio = "";

        Calendar cal = Calendar.getInstance();

        int dia = cal.get(Calendar.DATE);
        int mes = cal.get(Calendar.MONTH) + 1;
        int anioSistema = cal.get(Calendar.YEAR);
        int hora = cal.get(Calendar.HOUR);

        if(dia < 10){
			diaN+="0"+dia;
		}
		else{
			diaN+=""+dia;
		}
		if(mes < 10){
			mesN+="0"+mes;
		}
		else{
			mesN+=""+mes;
		}

        fechaSistema = anio + "-" + mesN + "-" + diaN;
    }

    //binarios
    public static Object cargarRecursoSerializado(String rutaArchivo)throws Exception
	{
		Object aux = null;
		ObjectInputStream ois = null;
		try {
			// Se crea un ObjectInputStream
			ois = new ObjectInputStream(new FileInputStream(rutaArchivo));

			aux = ois.readObject();

		} catch (Exception e2) {
			throw e2;
		} finally {
			if (ois != null)
				ois.close();
		}
		return aux;
	}
/*
Este es para cuando quiero sobreescibir la informacion
public static void guardarRecursoSerializado(String rutaArchivo, Object recurso) throws Exception {
    public static void salvarRecursoSerializado(String rutaArchivo, Object object)	throws Exception {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo));
			oos.writeObject(object);
		} catch (Exception e) {
			throw e;
		} finally {
			if (oos != null)
				oos.close();
		}
	}
*/
    //binarios
    public static void salvarRecursoSerializado(String rutaArchivo, Object object, boolean append) throws Exception {
        ObjectOutputStream oos = null;
        try {
            // Si el archivo existe y estamos en modo append, usamos un ObjectOutputStream especial
            if (append && new File(rutaArchivo).exists()) {
                oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo, true)) {
                    @Override
                    protected void writeStreamHeader() throws IOException {
                        reset(); // Evitar escribir el encabezado de nuevo
                    }
                };
            } else {
                // Si el archivo no existe o no estamos en modo append, creamos un nuevo archivo
                oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo));
            }
            oos.writeObject(object);
        } catch (Exception e) {
            throw e;
        } finally {
            if (oos != null) oos.close();
        }
    }

    public static List<Object> cargarRecursoSerializadoXML(String rutaArchivo) throws IOException {
        List<Object> listaObjetos = new ArrayList<>();
        XMLDecoder decodificadorXML = null;

        try {
            // Abrir el archivo XML y decodificar los objetos
            decodificadorXML = new XMLDecoder(new FileInputStream(rutaArchivo));
            listaObjetos = (List<Object>) decodificadorXML.readObject(); // Se espera una lista de objetos
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al cargar el archivo XML: " + e.getMessage());
        } finally {
            if (decodificadorXML != null) {
                decodificadorXML.close();
            }
        }
        return listaObjetos; // Devolver la lista de objetos
    }

    public static void salvarRecursoSerializadoXML(String rutaArchivo, Object nuevoObjeto) throws IOException {
        List<Object> listaObjetos = new ArrayList<>();

        // Intentamos cargar los objetos ya guardados
        try {
            listaObjetos = cargarRecursoSerializadoXML(rutaArchivo); // Cargar lo que ya está en el archivo
        } catch (IOException e) {
            // Si no se puede cargar, simplemente continuamos, el archivo puede no existir aún
        }
        // Añadir el nuevo objeto a la lista
        listaObjetos.add(nuevoObjeto);

        // Guardar toda la lista de objetos de vuelta en el archivo
        XMLEncoder codificadorXML = null;
        try {
            codificadorXML = new XMLEncoder(new FileOutputStream(rutaArchivo));
            codificadorXML.writeObject(listaObjetos); // Guardar la lista completa
        } catch (Exception e) {
            System.out.println("Error al guardar el archivo XML: " + e.getMessage());
        } finally {
            if (codificadorXML != null) {
                codificadorXML.close();
            }
        }
    }

    /*
    public static void salvarRecursoSerializadoXML(String rutaArchivo, Object objeto) throws IOException {

		XMLEncoder codificadorXML;

		codificadorXML = new XMLEncoder(new FileOutputStream(rutaArchivo));
		codificadorXML.writeObject(objeto);
		codificadorXML.close();
	}
    */

   //public static String generarNombreArchivoRespaldo(String) ...
}
