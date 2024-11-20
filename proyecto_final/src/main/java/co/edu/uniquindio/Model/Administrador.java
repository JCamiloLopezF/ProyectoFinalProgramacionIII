package co.edu.uniquindio.Model;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.edu.uniquindio.Persistencia.ArchivoUtil;
import co.edu.uniquindio.Persistencia.GestorArchivo;
import co.edu.uniquindio.Persistencia.GestorCuentas;


public class Administrador{
    public String admin;
    public String contraseña;

    public Administrador() {
        this.admin = admin;
        this.contraseña = contraseña;
    }

    public static void actualizarUsuario(String nombreUsuario, String nuevaDireccion, String nuevoTelefono) throws IOException {
        new GestorArchivo().actualizarDatosAdminsUsuario(nombreUsuario, nuevaDireccion, nuevoTelefono);
        ArchivoUtil.guardarRegistroLog("Admin actualizó un usuario", 1, "ActualizacionUsuario","C:/td/persistencia/log/luxoraWallet_Log.txt");
    }
    
    public void eliminarUsuario(String nombre) throws IOException {
        Usuario usuario = buscarUsuarioPorCorreo(nombre);
                if (usuario != null) {
                    new GestorArchivo().eliminarUsuario(nombre);
                }
                ArchivoUtil.guardarRegistroLog("Admin eliminó el usuario " + usuario.getIdUsuario(), 3, "ActualizacionUsuario","C:/td/persistencia/log/luxoraWallet_Log.txt");
            }
        
    public List<Usuario> listarUsuarios() throws IOException {
        return new GestorArchivo().cargarUsuarios(new LuxoraWallet());
    }
        
    public  Usuario buscarUsuarioPorCorreo(String nombre) throws IOException {
        LuxoraWallet luxoraWallet = new LuxoraWallet();
        List<Usuario> listaUsuarios = new GestorArchivo().cargarUsuarios(luxoraWallet);

        for (Usuario usuario : listaUsuarios) {
            if (usuario.getIdUsuario().equalsIgnoreCase(nombre)) {
                return usuario;
            }
        }
        return null;
    }

    //Gestionar cuentas bancarias
    public void eliminarCuentaBancaria(Usuario usuario, String idCuenta) throws IOException {
        new GestorCuentas().eliminarCuentaBancaria(usuario, idCuenta);
        ArchivoUtil.guardarRegistroLog("Admin eliminó cuenta bancaria", 3, "ActualizacionUsuario","C:/td/persistencia/log/luxoraWallet_Log.txt");

    }

    /**public List<Transaccion> listarTransacciones(Usuario usuario) throws IOException {
        List<Transaccion> todasLasTransacciones = new GestorArchivo().cargarTransacciones(new LuxoraWallet(), usuario);

        return todasLasTransacciones.stream()
        .filter(transaccion -> transaccion.getIdUsuario().equals(usuario.getIdUsuario()))
        .collect(Collectors.toList());
    }**/

    public void mostrarEstadisticas() {
        //...
    }

    public void mostrarEstadisticasEnGrafica() {
        //dios mio
    }

    /**public void usuariosConMasTransacciones() throws IOException{
        List<Transaccion> transacciones = listarTransacciones();
        Map<String, Integer> conteoTransacciones = new HashMap<>();

        for (Transaccion transaccion : transacciones) {
            String correoUsuario = transaccion.getCorreoUsuario();
            conteoTransacciones.put(correoUsuario, conteoTransacciones.getOrDefault(correoUsuario,0) + 1 );
        }
    }**/

    public double saldoPromedioUsuarios() {
            return 0;
    }
}



