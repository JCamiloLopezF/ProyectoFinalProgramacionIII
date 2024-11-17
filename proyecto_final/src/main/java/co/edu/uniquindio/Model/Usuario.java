package co.edu.uniquindio.Model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Usuario implements Serializable{
    public String idUsuario;
    private String nombreCompleto;
    private String correo;
    private String numeroTelefono;
    private String direccion;
    private String contrasenia;
    private double saldoDisponible;
    private List<Cuenta> cuentasBancarias = new LinkedList<Cuenta>();
    public Cuenta cuentaBilletera;

    public Usuario(){

    }

    public Usuario(String nombreCompleto, String correo, String numeroTelefono, String direccion, String idUsuario, String contrasenia,
            double saldoDisponible) {
        this.idUsuario = idUsuario;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.numeroTelefono = numeroTelefono;
        this.direccion = direccion;
        this.contrasenia = contrasenia;
        this.saldoDisponible = saldoDisponible;
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

    public List<Cuenta> getCuentasBancarias() {
        return cuentasBancarias;
    }

    public void setCuentasBancarias(List<Cuenta> cuentasBancarias) {
        this.cuentasBancarias = cuentasBancarias;
    }

    public Cuenta getCuentaBilletera() {
        return cuentaBilletera;
    }

    public void setCuentaBilletera(Cuenta cuentaBilletera) {
        this.cuentaBilletera = cuentaBilletera;
    }

    @Override
    public String toString() {
        return "Usuario [idUsuario=" + idUsuario + ", nombreCompleto=" + nombreCompleto + ", correo=" + correo
                + ", numeroTelefono=" + numeroTelefono + ", contrasenia=" + contrasenia + ", saldoDisponible="
                + saldoDisponible + ", cuentaBilletera=" + cuentaBilletera + ", cuentasBancarias=" + cuentasBancarias + "]";
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
