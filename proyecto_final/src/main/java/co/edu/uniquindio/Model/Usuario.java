package co.edu.uniquindio.Model;

import java.io.Serializable;
import java.util.LinkedList;

import co.edu.uniquindio.Persistencia.GestorArchivo;

public class Usuario implements Serializable{
    public String idUsuario;
    private String nombreCompleto;
    private String correo;
    private String numeroTelefono;
    private String direccion;
    private String contrasenia;
    private double saldoDisponible;
    private LinkedList<Cuenta> cuentasBancarias;
    private LinkedList<Presupuesto> presupuestos;
    private LinkedList<Transaccion> transacciones;
    public Cuenta cuentaBilletera;
    GestorArchivo gestor = new GestorArchivo();

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
        this.presupuestos = new LinkedList<>();
        this.transacciones = new LinkedList<>();
        this.cuentasBancarias = new LinkedList<>();
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

    public LinkedList<Presupuesto> getPresupuestos() {
        return presupuestos;
    }

    public void setPresupuestos(LinkedList<Presupuesto> presupuestos) {
        this.presupuestos = presupuestos;
    }

    public LinkedList<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(LinkedList<Transaccion> transacciones) {
        this.transacciones = transacciones;
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

    public LinkedList<Cuenta> getCuentasBancarias() {
        return cuentasBancarias;
    }

    public void setCuentasBancarias(LinkedList<Cuenta> cuentasBancarias) {
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
                + saldoDisponible + "]";
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void agregarPresupuesto(Presupuesto presupuesto) {
        presupuestos.add(presupuesto);
    }
}
