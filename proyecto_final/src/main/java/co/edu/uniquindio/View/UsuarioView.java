package co.edu.uniquindio.View;

import java.util.LinkedList;

import co.edu.uniquindio.Model.LuxoraWallet;
import co.edu.uniquindio.Model.Usuario;

public class UsuarioView {
    
    private String nombre = "";
    LuxoraWallet luxoraWallet = LuxoraWallet.getInstanciaUnica();

    public String nombreUsuario(){
        LinkedList<Usuario> usuario = luxoraWallet.getUsuarioSeleccionado();
        
        if (!usuario.isEmpty()) {
            for(Usuario u : usuario){
                nombre += u.getIdUsuario();
            }
        }
        return nombre;
    }
}
