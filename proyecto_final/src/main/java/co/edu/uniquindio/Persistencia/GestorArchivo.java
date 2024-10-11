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

    public static String obtenerRutaUsuariosProperties(){
        Properties properties= new Properties();
		try {
			properties.load(new FileInputStream(new File("C:/td/persistencia/properties.properties")));
            return properties.get("rutaArchivoUsuarios").toString();
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
        rutaArchivoUsuarios = obtenerRutaUsuariosProperties();
        StringBuilder textoUsuario = new StringBuilder();
		
		textoUsuario.append(usuario.getNombreCompleto()+"@@");
		textoUsuario.append(usuario.getCorreo()+"@@");
		textoUsuario.append(usuario.getNumeroTelefono()+"@@");
		textoUsuario.append(usuario.getIdUsuario() + "@@");
		textoUsuario.append(usuario.getConntrasenia() + "@@");
        textoUsuario.append(usuario.getSaldoDisponible() + "\n");

		ArchivoUtil.guardarArchivo(rutaArchivoUsuarios,textoUsuario.toString(),true);
    }

    public LinkedList<Usuario> cargarUsuarios(LuxoraWallet luxoraWallet)throws IOException {

		rutaArchivoUsuarios = obtenerRutaUsuariosProperties();

		ArrayList<String> contenido = ArchivoUtil.leerArchivo(rutaArchivoUsuarios);

		for (String usuarioTexto: contenido) {
			String[] split = usuarioTexto.split("@@");

			if (split.length >= 4) {
				Usuario usuario = new Usuario(split[0], split[1], split[2], split [3], split[4], Double.valueOf(split[3]));
				luxoraWallet.getUsuarios().add(usuario);
			} else {
				System.err.println("Línea con datos incompletos: " + usuarioTexto);
			}
		}
		return luxoraWallet.getUsuarios();
	}
}
