package co.edu.uniquindio.Persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Properties;

import co.edu.uniquindio.Model.LuxoraWallet;
import co.edu.uniquindio.Model.Usuario;

public class GestorArchivo {
    String rutaArchivoUsuarios = "";

    public static String obtenerRutaUsuariosProperties(String ruta){
        Properties properties= new Properties();
		try {
			properties.load(new FileInputStream(new File("C:/td/persistencia/properties.properties")));
            return properties.get(ruta).toString();
		} 
        catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

    public void guardarUsuario(Usuario usuario) throws IOException{
        rutaArchivoUsuarios = obtenerRutaUsuariosProperties("rutaArchivoUsuarios");
        StringBuilder textoUsuario = new StringBuilder();
		
		textoUsuario.append(usuario.getNombreCompleto()+"@@");
		textoUsuario.append(usuario.getCorreo()+"@@");
		textoUsuario.append(usuario.getNumeroTelefono()+"@@");
		textoUsuario.append(usuario.getDireccion()+"@@");
		textoUsuario.append(usuario.getIdUsuario() + "@@");
		textoUsuario.append(usuario.getContrasenia() + "@@");
        textoUsuario.append(usuario.getSaldoDisponible() + "\n");

		ArchivoUtil.guardarArchivo(rutaArchivoUsuarios,textoUsuario.toString(),true);
    }

    public LinkedList<Usuario> cargarUsuarios(LuxoraWallet luxoraWallet)throws IOException {
		rutaArchivoUsuarios = obtenerRutaUsuariosProperties("rutaArchivoUsuarios");

		ArrayList<String> contenido = ArchivoUtil.leerArchivo(rutaArchivoUsuarios);

		for (String usuarioTexto: contenido) {
			String[] split = usuarioTexto.split("@@");

			if (split.length >= 5) {
				Usuario usuario = new Usuario(split[0], split[1], split[2], split[3], split [4], split[5], Double.valueOf(split[6]));
				luxoraWallet.getUsuarios().add(usuario);
			} else {
				System.err.println("Línea con datos incompletos: " + usuarioTexto);
			}
		}
		return luxoraWallet.getUsuarios();
	}

	public void actualizarDatosParcialesUsuario(Usuario usuarioActualizado, String nuevaDireccion, String nuevoTelefono, String nuevaContrasenia) throws IOException {
		rutaArchivoUsuarios = obtenerRutaUsuariosProperties("rutaArchivoUsuarios");
	
		// Cargar el contenido completo del archivo
		ArrayList<String> contenidoArchivo = ArchivoUtil.leerArchivo(rutaArchivoUsuarios);
		ArrayList<String> contenidoActualizado = new ArrayList<>();
	
		for (String linea : contenidoArchivo) {
			String[] datos = linea.split("@@");
	
			// Verificar si esta línea corresponde al usuario que queremos actualizar
			if (datos[1].equals(usuarioActualizado.getCorreo())) { // Comparar por correo (o algún identificador único)
				// Actualizar solo los datos específicos sin modificar los otros
				datos[3] = nuevaDireccion; // Actualiza la dirección
				datos[2] = nuevoTelefono;  // Actualiza el teléfono
				datos[5] = nuevaContrasenia; // Actualiza la contraseña
	
				// Reconstruir la línea con los datos actualizados
				String lineaActualizada = String.join("@@", datos);
				contenidoActualizado.add(lineaActualizada);
			} else {
				// Mantener la línea sin cambios
				contenidoActualizado.add(linea);
			}
		}
	
		// Sobrescribir el archivo con el contenido actualizado
		ArchivoUtil.guardarArchivo(rutaArchivoUsuarios, String.join("\n", contenidoActualizado), false);
	}
}
