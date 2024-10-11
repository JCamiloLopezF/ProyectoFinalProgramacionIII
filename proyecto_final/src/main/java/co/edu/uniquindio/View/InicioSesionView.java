package co.edu.uniquindio.View;

import java.util.LinkedList;

import co.edu.uniquindio.Model.LuxoraWallet;
import co.edu.uniquindio.Model.Usuario;

public class InicioSesionView {

    LuxoraWallet luxoraWallet = new LuxoraWallet();

    public void verificarUsuarioExistente(String idUsuario){
        LinkedList<Usuario> usuarios = luxoraWallet.getUsuarios();

        for(Usuario usuario : usuarios){
            if(usuario.getIdUsuario().equals(idUsuario)){
                luxoraWallet.getUsuarioSeleccionado().add(usuario);
            }
        }
    }
}
