package co.edu.uniquindio.Model;

import java.util.LinkedList;

public class LuxoraWallet {
    private static LuxoraWallet instanciaUnica;
    public String nombre = "Luxora Wallet";
    public LinkedList<Usuario> usuarios;


    public static LuxoraWallet getInstanciaUnica() {
        if(instanciaUnica == null){
            instanciaUnica = new LuxoraWallet();
        }
        return instanciaUnica;
    }

    public LuxoraWallet() {
        this.usuarios = new LinkedList<>();
    }

    public LinkedList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void agregarUsuario(Usuario usuario){
        this.usuarios.add(usuario);
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
