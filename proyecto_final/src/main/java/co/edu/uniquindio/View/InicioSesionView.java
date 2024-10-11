package co.edu.uniquindio.View;

import java.util.LinkedList;

import co.edu.uniquindio.Model.LuxoraWallet;
import co.edu.uniquindio.Model.Usuario;

public class InicioSesionView {

    LuxoraWallet luxoraWallet = LuxoraWallet.getInstanciaUnica();

    public boolean verificarUsuarioExistente(String idUsuario){
        LinkedList<Usuario> usuarios = luxoraWallet.getUsuarios();

        for(Usuario usuario : usuarios){
            if(usuario.getIdUsuario().equals(idUsuario)){
                luxoraWallet.agregarUsuarioSeleccionado(usuario);
                return true;
            }
        }
        return false;
    }
}
