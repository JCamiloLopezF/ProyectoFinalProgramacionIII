package co.edu.uniquindio.Model;

import java.util.LinkedList;

public class LuxoraWallet {
    private static LuxoraWallet instanciaUnica;
    public String nombre = "Luxora Wallet";
    public LinkedList<Usuario> usuarios;
    public LinkedList<Usuario> usuarioSeleccionado;


    public static LuxoraWallet getInstanciaUnica() {
        if(instanciaUnica == null){
            instanciaUnica = new LuxoraWallet();
        }
        return instanciaUnica;
    }

    public LuxoraWallet() {
        this.usuarios = new LinkedList<>();
        this.usuarioSeleccionado = new LinkedList<>();
    }

    public LinkedList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void agregarUsuario(Usuario usuario){
        this.usuarios.add(usuario);
    }

    public void agregarUsuarioSeleccionado(Usuario usuario){
        this.usuarioSeleccionado.add(usuario);
    }

    public LinkedList<Usuario> getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public void setUsuarioSeleccionado(LinkedList<Usuario> usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
    }

    

    /*
    public Usuario validarUsuarioExiste(Usuario user) {
        for (Usuario usuario : usuarios) {
            if(usuario.getIdUsuario().equals(user.getIdUsuario())){
                System.out.println("El usuario ya existe");
            }
        }
        return user;
    }
        */
}
