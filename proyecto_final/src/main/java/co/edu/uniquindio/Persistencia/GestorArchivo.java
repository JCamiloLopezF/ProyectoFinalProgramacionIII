package co.edu.uniquindio.Persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Properties;

import co.edu.uniquindio.Model.LuxoraWallet;
import co.edu.uniquindio.Model.Presupuesto;
import co.edu.uniquindio.Model.Transaccion;
import co.edu.uniquindio.Model.Usuario;

public class  GestorArchivo {
    String rutaArchivoUsuarios = "";

    public static String obtenerRutaProperties(String ruta){
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
        rutaArchivoUsuarios = obtenerRutaProperties("rutaArchivoUsuarios");
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
		rutaArchivoUsuarios = obtenerRutaProperties("rutaArchivoUsuarios");

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
		rutaArchivoUsuarios = obtenerRutaProperties("rutaArchivoUsuarios");
	
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

	public void actualizarSaldoUsuario(Usuario usuarioActualizado, Double saldo) throws IOException {
		rutaArchivoUsuarios = obtenerRutaProperties("rutaArchivoUsuarios");
	
		// Cargar el contenido completo del archivo
		ArrayList<String> contenidoArchivo = ArchivoUtil.leerArchivo(rutaArchivoUsuarios);
		ArrayList<String> contenidoActualizado = new ArrayList<>();
	
		for (String linea : contenidoArchivo) {
			String[] datos = linea.split("@@");
	
			// Verificar si esta línea corresponde al usuario que queremos actualizar
			if (datos[1].equals(usuarioActualizado.getCorreo())) { // Comparar por correo (o algún identificador único)
				// Actualizar solo los datos específicos sin modificar los otros
				String saldoStr = String.valueOf(saldo);
				datos[6] = saldoStr; // Actualiza el saldo
	
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

	public void guardarTransaccion(Transaccion transaccion, Usuario usuario) throws IOException{
        rutaArchivoUsuarios = obtenerRutaProperties("rutaArchivoTransacciones");
        StringBuilder textoTransaccion = new StringBuilder();
		
		textoTransaccion.append(transaccion.getIdTransaccion()+"@@");
		textoTransaccion.append(transaccion.getFechaTransaccion()+"@@");
		textoTransaccion.append(transaccion.getMonto()+"@@");
		textoTransaccion.append(transaccion.getDescripcionOpcional()+"@@");
		textoTransaccion.append(transaccion.getNumeroCuenta() + "@@");
		textoTransaccion.append(usuario.getIdUsuario() + "\n");

		ArchivoUtil.guardarArchivo(rutaArchivoUsuarios,textoTransaccion.toString(),true);
		usuario.getTransacciones().add(transaccion);
    }

    /**public LinkedList<Transaccion> cargarTransacciones(LuxoraWallet luxoraWallet)throws IOException {
		rutaArchivoUsuarios = obtenerRutaProperties("rutaArchivoTransacciones");

		ArrayList<String> contenido = ArchivoUtil.leerArchivo(rutaArchivoUsuarios);

		for (String transaccionTexto: contenido) {
			String[] split = transaccionTexto.split("@@");

			if (split.length >= 4) {
				Transaccion transaccion = new Transaccion(split[0], split[1], split[2], split[3], split [4], split[5]);
				luxoraWallet.getTransacciones().add(transaccion);
			} else {
				System.err.println("Línea con datos incompletos: " + transaccionTexto);
			}
		}
		return luxoraWallet.getTransacciones();
	}**/

	public LinkedList<Transaccion> cargarTransacciones(LuxoraWallet luxoraWallet, Usuario usuario) throws IOException {
		// Obtiene la ruta al archivo de transacciones desde las properties
		rutaArchivoUsuarios = obtenerRutaProperties("rutaArchivoTransacciones");
	
		// Lista para almacenar las transacciones filtradas
		LinkedList<Transaccion> transaccionesFiltradas = new LinkedList<>();
	
		// Lee las líneas del archivo
		ArrayList<String> contenido = ArchivoUtil.leerArchivo(rutaArchivoUsuarios);
	
		for (String transaccionTexto : contenido) {
			// Divide la línea en partes usando "@@" como separador
			String[] split = transaccionTexto.split("@@");
	
			if (split.length == 6) {
				try {
					// Verifica si el id del usuario de la transacción coincide con el id del usuario actual
					String idUsuarioTransaccion = split[5];
					if (idUsuarioTransaccion.equals(usuario.getIdUsuario())) {
						// Crea una nueva transacción a partir de los datos
						Transaccion transaccion = new Transaccion(
							split[0], // Detalle 1
							split[1], // Detalle 2
							split[2], // Detalle 3
							split[3], // Detalle 4
							split[4], // Detalle 5
							idUsuarioTransaccion // ID del usuario
						);
						transaccionesFiltradas.add(transaccion);
					}
				} catch (Exception e) {
					System.err.println("Error al procesar la transacción: " + transaccionTexto);
				}
			} else {
				System.err.println("Línea con datos incompletos: " + transaccionTexto);
			}
		}
	
		// Asigna las transacciones cargadas a la wallet del usuario
		usuario.setTransacciones(transaccionesFiltradas);
		return transaccionesFiltradas;
	}
	

	public void guardarPresupuesto(Presupuesto presupuesto, Usuario usuario) throws IOException {
		rutaArchivoUsuarios = obtenerRutaProperties("rutaArchivoPresupuestos");
		StringBuilder textoPresupuesto = new StringBuilder();

		textoPresupuesto.append(presupuesto.getNombre()+"@@");
		textoPresupuesto.append(presupuesto.getMontoTotalAsignado() + "@@");
		textoPresupuesto.append(usuario.getIdUsuario() + "\n");

		ArchivoUtil.guardarArchivo(rutaArchivoUsuarios,textoPresupuesto.toString(),true);
		usuario.agregarPresupuesto(presupuesto);
	}

	public LinkedList<Presupuesto> cargarPresupuestos(Usuario usuario) throws IOException {
		// Obtiene la ruta al archivo de presupuestos desde las properties
		rutaArchivoUsuarios = obtenerRutaProperties("rutaArchivoPresupuestos");
	
		// Lista para almacenar los presupuestos cargados
		LinkedList<Presupuesto> presupuestosFiltrados = new LinkedList<>();
	
		// Lee las líneas del archivo
		ArrayList<String> lineasArchivo = ArchivoUtil.leerArchivo(rutaArchivoUsuarios);
	
		for (String linea : lineasArchivo) {
			// Divide la línea en partes usando "@@" como separador
			String[] partes = linea.split("@@");
	
			if (partes.length == 3) {
				try {
					// Verifica si el id del presupuesto coincide con el id del usuario
					String idUsuarioPresupuesto = partes[2];
					if (idUsuarioPresupuesto.equals(usuario.getIdUsuario())) {
						// Crea un nuevo presupuesto a partir de los datos
						String nombrePresupuesto = partes[0];
						double monto = Double.parseDouble(partes[1]);
	
						Presupuesto presupuesto = new Presupuesto(nombrePresupuesto, monto, idUsuarioPresupuesto);
						presupuestosFiltrados.add(presupuesto);
					}
				} catch (NumberFormatException e) {
					System.err.println("Error al parsear monto: " + partes[1]);
				}
			} else {
				System.err.println("Línea con datos incompletos: " + linea);
			}
		}
	
		// Asigna los presupuestos cargados al usuario
		usuario.setPresupuestos(presupuestosFiltrados);
		return presupuestosFiltrados;
	}
	
}
