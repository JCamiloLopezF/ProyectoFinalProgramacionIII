package co.edu.uniquindio.Persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import co.edu.uniquindio.Model.Categoria;
import co.edu.uniquindio.Model.Cuenta;
import co.edu.uniquindio.Model.LuxoraWallet;
import co.edu.uniquindio.Model.Presupuesto;
import co.edu.uniquindio.Model.Transaccion;
import co.edu.uniquindio.Model.Usuario;

public class GestorArchivo {
	LuxoraWallet luxora = LuxoraWallet.getInstanciaUnica();
    String rutaArchivoUsuarios = "";
	String rutaArchivoCuentas = "";

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

	public void eliminarUsuario(String correo) throws IOException {
		rutaArchivoUsuarios = obtenerRutaProperties("rutaArchivosUsuarios");

		ArrayList<String> contenidoArchivo = ArchivoUtil.leerArchivo(rutaArchivoUsuarios);
		ArrayList<String> contenidoActualizado = new ArrayList<>();

		boolean usuarioEncontrado = false;

		for (String linea : contenidoArchivo) {
			String[] datos = linea.split("@@");

			if (datos[1].equals(correo)) {
				usuarioEncontrado = true;
			} else {
				contenidoActualizado.add(linea);
			}
		}

		if (usuarioEncontrado) {
			ArchivoUtil.guardarArchivo(rutaArchivoUsuarios, String.join("\n", contenidoActualizado), false);
		} else {
			System.err.println("Usuario no encontrado: " + correo);
		}
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


	public void actualizarDatosAdminsUsuario(String usuarioActualizado, String nuevaDireccion, String nuevoTelefono) throws IOException {
		rutaArchivoUsuarios = obtenerRutaProperties("rutaArchivoUsuarios");
	
		// Cargar el contenido completo del archivo
		ArrayList<String> contenidoArchivo = ArchivoUtil.leerArchivo(rutaArchivoUsuarios);
		ArrayList<String> contenidoActualizado = new ArrayList<>();
	
		for (String linea : contenidoArchivo) {
			String[] datos = linea.split("@@");
	
			// Verificar si esta línea corresponde al usuario que queremos actualizar
			if (datos[4].equals(usuarioActualizado)) { // Comparar por correo (o algún identificador único)
				// Actualizar solo los datos específicos sin modificar los otros
				datos[3] = nuevaDireccion; // Actualiza la dirección
				datos[2] = nuevoTelefono;  // Actualiza el teléfono
	
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
		textoTransaccion.append(usuario.getIdUsuario() + "\n" );

		ArchivoUtil.guardarArchivo(rutaArchivoUsuarios,textoTransaccion.toString(),true);
		luxora.getTransacciones().add(transaccion);
    }

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
	
			if (split.length == 7) { // Updated length check to 7
				try {
					// Verifica si el id del usuario de la transacción coincide con el id del usuario actual
					String idUsuarioTransaccion = split[5];
					if (idUsuarioTransaccion.equals(usuario.getIdUsuario())) {
						 // Create a new Categoria object
						Categoria categoria = new Categoria(); // Assuming Categoria has a default constructor
						categoria.setNombre(split[6]); // Assuming Categoria has a setNombre method
						// Create a new transaction with the new constructor
						Transaccion transaccion = new Transaccion(
							split[0], // idTransaccion
							split[1], // fechaTransaccion
							split[2], // monto
							split[3], // descripcionOpcional
							split[4], // numeroCuenta
							idUsuarioTransaccion, // nombreUsuario
							categoria // categoria
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
		luxoraWallet.setTransacciones(transaccionesFiltradas);
		return transaccionesFiltradas;
	}


	public LinkedList<Transaccion> cargarTodasLasTransacciones(LuxoraWallet luxoraWallet) throws IOException {
		// Obtiene la ruta al archivo de transacciones desde las properties
		rutaArchivoUsuarios = obtenerRutaProperties("rutaArchivoTransacciones");
		LinkedList<Transaccion> todasLasTransacciones = new LinkedList<>();
		ArrayList<String> contenido = ArchivoUtil.leerArchivo(rutaArchivoUsuarios);
	
		for (String transaccionTexto : contenido) {
			// Divide la línea en partes usando "@@" como separador
			String[] split = transaccionTexto.split("@@");
	
			if (split.length == 7) { // Updated length check to 7
				try {
					// Create a new Categoria object
					Categoria categoria = new Categoria(); // Assuming Categoria has a default constructor
					categoria.setNombre(split[6]); // Assuming Categoria has a setNombre method
					// Create a new transaction with the new constructor
					Transaccion transaccion = new Transaccion(
						split[0], // idTransaccion
						split[1], // fechaTransaccion
						split[2], // monto
						split[3], // descripcionOpcional
						split[4], // numeroCuenta
						split[5], // nombreUsuario
						categoria // categoria
					);
					todasLasTransacciones.add(transaccion);
				} catch (Exception e) {
					System.err.println("Error al procesar la transacción: " + transaccionTexto);
				}
			} else {
				System.err.println("Línea con datos incompletos: " + transaccionTexto);
			}
		}
	
		// Asigna todas las transacciones cargadas a la wallet
		luxoraWallet.setTransacciones(todasLasTransacciones);
		return todasLasTransacciones;
	}


//*********************************
//ARCHIVOS DE PRESUPUESTOS
//*********************************

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

	public void guardarPresupuestosActualizados(Usuario usuario) throws IOException {
		// Obtiene la ruta del archivo de presupuestos
		rutaArchivoUsuarios = obtenerRutaProperties("rutaArchivoPresupuestos");
		StringBuilder textoPresupuestos = new StringBuilder();

		// Recorre la lista de presupuestos del usuario y los guarda en el formato correcto
		for (Presupuesto presupuesto : usuario.getPresupuestos()) {
			textoPresupuestos.append(presupuesto.getNombre()).append("@@");
			textoPresupuestos.append(presupuesto.getMontoTotalAsignado()).append("@@");
			textoPresupuestos.append(usuario.getIdUsuario()).append("\n");
		}

		// Sobrescribe el archivo con los presupuestos actualizados
		ArchivoUtil.guardarArchivo(rutaArchivoUsuarios, textoPresupuestos.toString(), false);
	}

	public void actualizarPresupuesto(String nombrePresupuesto, double nuevoMonto) throws IOException {
		rutaArchivoUsuarios = obtenerRutaProperties("rutaArchivoPresupuestos");
    	List<String> lineasArchivo = ArchivoUtil.leerArchivo(rutaArchivoUsuarios);
    	StringBuilder textoPresupuestos = new StringBuilder();

		for (String linea : lineasArchivo) {
			String[] partes = linea.split("@@");
			if (partes[0].equals(nombrePresupuesto)) {
				partes[1] = String.valueOf(nuevoMonto);
			}
			textoPresupuestos.append(String.join("@@", partes)).append("\n");
		}

		ArchivoUtil.guardarArchivo(rutaArchivoUsuarios, textoPresupuestos.toString(), false);
	}

	public double eliminarPresupuesto(String nombrePresupuesto) throws IOException {
		// Ruta del archivo de presupuestos
		rutaArchivoUsuarios = obtenerRutaProperties("rutaArchivoPresupuestos");
		List<String> lineasArchivo = ArchivoUtil.leerArchivo(rutaArchivoUsuarios);
		StringBuilder textoPresupuestos = new StringBuilder();
		double montoEliminado = 0;
		boolean encontrado = false;

		// Recorrer las líneas del archivo para buscar el presupuesto por nombre
		for (String linea : lineasArchivo) {
			String[] partes = linea.split("@@");
			String nombre = partes[0];
			double monto = Double.parseDouble(partes[1]);

			// Si el nombre coincide, se elimina (no se añade al nuevo contenido)
			if (nombre.equals(nombrePresupuesto) && !encontrado) {
				montoEliminado = monto;
				System.out.println("Monto del presupuesto eliminado: " + montoEliminado);
				encontrado = true;
			} else {
				// Si no coincide, se guarda en el nuevo contenido
				textoPresupuestos.append(linea).append("\n");
			}
		}

		// Sobrescribir el archivo con los presupuestos actualizados
		ArchivoUtil.guardarArchivo(rutaArchivoUsuarios, textoPresupuestos.toString(), false);

		if (encontrado) {
			System.out.println("Presupuesto eliminado correctamente.");
		} else {
			System.out.println("Presupuesto no encontrado.");
		}

		return montoEliminado;
	}

	public double consultarEstadoPresupuesto(String nombrePresupuesto, Usuario usuario) throws IOException {
		rutaArchivoUsuarios = obtenerRutaProperties("rutaArchivoPresupuestos");
		ArrayList<String> lineasArchivo = ArchivoUtil.leerArchivo(rutaArchivoUsuarios);

		for (String linea : lineasArchivo) {
			String[] partes = linea.split("@@");
			if (partes[0].equals(nombrePresupuesto) && partes[2].equals(usuario.getIdUsuario())) {
				return Double.parseDouble(partes[1]);
			}
		}
		return 0;
	}

	public double consultarMontoGastado(String nombrePresupuesto, Usuario usuario) throws IOException {
		rutaArchivoUsuarios = obtenerRutaProperties("rutaArchivoTransacciones");
		ArrayList<String> lineasArchivo = ArchivoUtil.leerArchivo(rutaArchivoUsuarios);
		double montoGastado = 0;

		for (String linea : lineasArchivo) {
			String[] partes = linea.split("@@");
			if (partes[5].equals(usuario.getIdUsuario())) {
				montoGastado += Double.parseDouble(partes[2]);
			}
		}
		return montoGastado;
	}

	public double monitorearGastoPorCategoria(String nombreCategoria, Usuario usuario) throws IOException {
		rutaArchivoUsuarios = obtenerRutaProperties("rutaArchivoTransacciones");
		ArrayList<String> lineasArchivo = ArchivoUtil.leerArchivo(rutaArchivoUsuarios);
		double montoGastado = 0;

		for (String linea : lineasArchivo) {
			String[] partes = linea.split("@@");
			if (partes[5].equals(usuario.getIdUsuario()) && partes[6].equals(nombreCategoria)) {
				montoGastado += Double.parseDouble(partes[2]);
			}
		}
		return montoGastado;
	}


//************************
//ARCHIVOS DE CATEGORIAS
//************************


	public void agregarCategoria(Categoria categoria) throws IOException {
		rutaArchivoUsuarios = obtenerRutaProperties("rutaArchivoCategorias");
		StringBuilder textoCategoria = new StringBuilder();
		textoCategoria.append(categoria.getIdCategoria() + "@@");
		textoCategoria.append(categoria.getNombre() + "@@");
		textoCategoria.append(categoria.getDescripcion() + "\n");
		ArchivoUtil.guardarArchivo(rutaArchivoUsuarios, textoCategoria.toString(), true);
	}

	public void actualizarCategoria(String idCategoria, String nuevoNombre, String nuevaDescripcion) throws IOException {
		rutaArchivoUsuarios = obtenerRutaProperties("rutaArchivoCategorias");
		List<String> lineasArchivo = ArchivoUtil.leerArchivo(rutaArchivoUsuarios);
		StringBuilder textoCategorias = new StringBuilder();

		for (String linea : lineasArchivo) {
			String[] partes = linea.split("@@");
			if (partes[0].equals(idCategoria)) {
				partes[1] = nuevoNombre;
				partes[2] = nuevaDescripcion;
			}
			textoCategorias.append(String.join("@@", partes)).append("\n");
		}

		ArchivoUtil.guardarArchivo(rutaArchivoUsuarios, textoCategorias.toString(), false);
	}

	public void eliminarCategoria(String idCategoria) throws IOException {
		rutaArchivoUsuarios = obtenerRutaProperties("rutaArchivoCategorias");
		List<String> lineasArchivo = ArchivoUtil.leerArchivo(rutaArchivoUsuarios);
		StringBuilder textoCategorias = new StringBuilder();

		for (String linea : lineasArchivo) {
			String[] partes = linea.split("@@");
			if (!partes[0].equals(idCategoria)) {
				textoCategorias.append(linea).append("\n");
			}
		}

		ArchivoUtil.guardarArchivo(rutaArchivoUsuarios, textoCategorias.toString(), false);
	}

	public LinkedList<Categoria> listarCategorias() throws IOException {
		rutaArchivoUsuarios = obtenerRutaProperties("rutaArchivoCategorias");
		LinkedList<Categoria> categorias = new LinkedList<>();
		ArrayList<String> lineasArchivo = ArchivoUtil.leerArchivo(rutaArchivoUsuarios);

		for (String linea : lineasArchivo) {
			String[] partes = linea.split("@@");
			if (partes.length == 3) {
				Categoria categoria = new Categoria(partes[0], partes[1], partes[2]);
				categorias.add(categoria);
			}
		}

		return categorias;
	}


//************************
//ARCHIVOS DE CUENTAS BANCARIAS
//************************

	public void guardarCuentaBancaria(Cuenta cuenta) throws IOException{
		rutaArchivoCuentas = obtenerRutaProperties("rutaArchivoCuentas");
		StringBuilder textoCuenta = new StringBuilder();
		
		textoCuenta.append(cuenta.getIdCuenta()+"@@");
		textoCuenta.append(cuenta.getNombreBanco()+"@@");
		textoCuenta.append(cuenta.getNumeroCuenta()+"@@");
		textoCuenta.append(cuenta.getTipoCuenta()+"@@");
		textoCuenta.append(cuenta.getSaldo()+"@@");
		textoCuenta.append(cuenta.getNombreUsuario() + "\n");

		ArchivoUtil.guardarArchivo(rutaArchivoCuentas,textoCuenta.toString(),true);
	}

    public LinkedList<Cuenta> cargarCuentasBancarias(Usuario usuario)throws IOException {
		rutaArchivoCuentas = obtenerRutaProperties("rutaArchivoCuentas");

		ArrayList<String> contenido = ArchivoUtil.leerArchivo(rutaArchivoCuentas);

		for (String cuentaTexto: contenido) {
			String[] split = cuentaTexto.split("@@");

			if (split.length >= 5) {
				Cuenta cuenta = new Cuenta(split[0], split[1], split[2], split[3], Double.valueOf(split[4]), split[5]);
				usuario.getCuentasBancarias().add(cuenta);
			} else {
				System.err.println("Línea con datos incompletos: " + cuentaTexto);
			}
		}
		return usuario.getCuentasBancarias();
	}

	public void actualizarDatosParcialesCuentasBancarias(Cuenta cuentaActualizada, String nuevaIdCuenta, String nuevoNombreBanco, String nuevoNumeroCuenta, String nuevoTipoCuenta, double nuevoSaldo, String nuevoNombreUsuario) throws IOException {
		rutaArchivoCuentas = obtenerRutaProperties("rutaArchivoCuentas");
	
		// Cargar el contenido completo del archivo
		ArrayList<String> contenidoArchivo = ArchivoUtil.leerArchivo(rutaArchivoCuentas);
		ArrayList<String> contenidoActualizado = new ArrayList<>();
	
		for (String linea : contenidoArchivo) {
			String[] datos = linea.split("@@");
	
			// Verificar si esta línea corresponde a la cuenta que queremos actualizar
			if (datos[0].equals(cuentaActualizada.getIdCuenta())) { // Comparar por IdCuenta (o algún identificador único)
				// Actualizar solo los datos específicos sin modificar los otros
				datos[0] = nuevaIdCuenta; // Actualiza la dirección
				datos[1] = nuevoNombreBanco;  // Actualiza el teléfono
				datos[2] = nuevoNumeroCuenta; // Actualiza la contraseña
				datos[3] = nuevoTipoCuenta; // Actualiza el nombre del banco
				datos[4] = String.valueOf(nuevoSaldo); // Actualiza el saldo
				datos[5] = nuevoNombreUsuario; // Actualiza el nombre del usuario
	
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

	public void actualizarSaldoCuentasBancarias(Cuenta cuentaActualizada, Double saldo) throws IOException {
		rutaArchivoCuentas = obtenerRutaProperties("rutaArchivoCuentas");
	
		// Cargar el contenido completo del archivo
		ArrayList<String> contenidoArchivo = ArchivoUtil.leerArchivo(rutaArchivoCuentas);
		ArrayList<String> contenidoActualizado = new ArrayList<>();
	
		for (String linea : contenidoArchivo) {
			String[] datos = linea.split("@@");
	
			// Verificar si esta línea corresponde al usuario que queremos actualizar
			if (datos[0].equals(cuentaActualizada.getIdCuenta())) { // Comparar por correo (o algún identificador único)
				// Actualizar solo los datos específicos sin modificar los otros
				String saldoStr = String.valueOf(saldo);
				datos[4] = saldoStr; // Actualiza el saldo
	
				// Reconstruir la línea con los datos actualizados
				String lineaActualizada = String.join("@@", datos);
				contenidoActualizado.add(lineaActualizada);
			} else {
				// Mantener la línea sin cambios
				contenidoActualizado.add(linea);
			}
		}
	
		// Sobrescribir el archivo con el contenido actualizado
		ArchivoUtil.guardarArchivo(rutaArchivoCuentas, String.join("\n", contenidoActualizado), false);
	}


	public double eliminarCuenta(String idCuenta) throws IOException {
		// Obtiene la ruta del archivo de cuentas desde las properties
		rutaArchivoUsuarios = obtenerRutaProperties("rutaArchivoCuentas");
		List<String> lineasArchivo = ArchivoUtil.leerArchivo(rutaArchivoUsuarios);
		StringBuilder textoCuentas = new StringBuilder();
		double saldoEliminado = 0;
		boolean encontrado = false;

		// Recorrer las líneas del archivo para buscar la cuenta por ID
		for (String linea : lineasArchivo) {
			String[] partes = linea.split("@@");
			String idActual = partes[0];  // idCuenta está en la tercera posición
			double saldo = Double.parseDouble(partes[1]);

			// Si el id coincide, se elimina (no se añade al nuevo contenido)
			if (idActual.equals(idCuenta) && !encontrado) {
				saldoEliminado = saldo;
				System.out.println("Saldo de la cuenta eliminada: " + saldoEliminado);
				encontrado = true;
			} else {
				// Si no coincide, se guarda en el nuevo contenido
				textoCuentas.append(linea).append("\n");
			}
		}

		// Sobrescribir el archivo con las cuentas actualizadas
		ArchivoUtil.guardarArchivo(rutaArchivoUsuarios, textoCuentas.toString(), false);

		if (encontrado) {
			System.out.println("Cuenta eliminada correctamente.");
		} else {
			System.out.println("Cuenta no encontrada.");
		}

		return saldoEliminado;
	}


}
