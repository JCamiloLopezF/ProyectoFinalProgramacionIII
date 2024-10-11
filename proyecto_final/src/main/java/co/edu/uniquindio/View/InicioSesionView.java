package co.edu.uniquindio.View;

import java.io.IOException;
import java.util.LinkedList;

import co.edu.uniquindio.Model.LuxoraWallet;
import co.edu.uniquindio.Model.Usuario;
import co.edu.uniquindio.Persistencia.GestorArchivo;

public class InicioSesionView {

    LuxoraWallet luxoraWallet = LuxoraWallet.getInstanciaUnica();

    public boolean verificarUsuarioExistente(String idUsuario, String contrasenia) throws IOException{
        GestorArchivo persistencia = new GestorArchivo();
        LinkedList<Usuario> usuarios = persistencia.cargarUsuarios(luxoraWallet);

        for(Usuario usuario : usuarios){
            if(usuario.getIdUsuario().equals(idUsuario) && usuario.getContrasenia().equals(contrasenia)){
                luxoraWallet.agregarUsuarioSeleccionado(usuario);
                return true;
            }
        }
        return false;
    }
}
