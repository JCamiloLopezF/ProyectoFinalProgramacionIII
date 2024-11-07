package co.edu.uniquindio.Model;

import java.io.Serializable;

public class Usuario implements Serializable{
    public String idUsuario;
    private String nombreCompleto;
    private String correo;
    private String numeroTelefono;
    private String direccion;
    private String contrasenia;
    private double saldoDisponible;
   // public Cuenta cuentasAsociadas;

    public Usuario(){

    }

    public Usuario(String nombreCompleto, String correo, String numeroTelefono, String direccion, String idUsuario, String contrasenia,
            double saldoDisponible) {
        this.idUsuario = idUsuario;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.numeroTelefono = numeroTelefono;
        this.contrasenia = contrasenia;
        this.saldoDisponible = saldoDisponible;
      //  this.cuentasAsociadas = cuentasAsociadas;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia= contrasenia;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }
    
    /*
    public Cuenta getCuentasAsociadas() {
        return cuentasAsociadas;
    }

    public void setCuentasAsociadas(Cuenta cuentasAsociadas) {
        this.cuentasAsociadas = cuentasAsociadas;
    }
    */

    @Override
    public String toString() {
        return "Usuario [idUsuario=" + idUsuario + ", nombreCompleto=" + nombreCompleto + ", correo=" + correo
                + ", numeroTelefono=" + numeroTelefono + ", contrasenia=" + contrasenia + ", saldoDisponible="
                + saldoDisponible + "]";
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
