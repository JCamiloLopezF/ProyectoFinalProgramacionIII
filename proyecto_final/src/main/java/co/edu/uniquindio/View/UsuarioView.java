package co.edu.uniquindio.View;

import java.util.LinkedList;

import co.edu.uniquindio.Model.LuxoraWallet;
import co.edu.uniquindio.Model.Usuario;

public class UsuarioView {
    
    private String nombre;
    LuxoraWallet luxoraWallet = new LuxoraWallet();

    public String nombreUsuario(){
        LinkedList<Usuario> usuario = luxoraWallet.getUsuarioSeleccionado();
        nombre += usuario.get(3);
        return nombre;
    }
}
