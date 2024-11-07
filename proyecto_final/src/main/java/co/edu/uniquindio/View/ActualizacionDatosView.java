package co.edu.uniquindio.View;

import java.util.LinkedList;

import co.edu.uniquindio.Model.LuxoraWallet;
import co.edu.uniquindio.Model.Usuario;

public class ActualizacionDatosView {
    String telefono;
    String direccion;
    String contraseniaActual;
    String contraseniaNueva;
    LuxoraWallet luxoraWallet = LuxoraWallet.getInstanciaUnica();
    LinkedList<Usuario> usuario = luxoraWallet.getUsuarioSeleccionado();

    public String telefonoUsuario(){
        
        if (!usuario.isEmpty()) {
            for(Usuario u : usuario){
                telefono += u.getNumeroTelefono();
            }
        }
        return telefono;
    }

    public String direccionUsuario(){
        
        if (!usuario.isEmpty()) {
            for(Usuario u : usuario){
                direccion += u.getDireccion();
            }
        }
        return direccion;
    }
}
