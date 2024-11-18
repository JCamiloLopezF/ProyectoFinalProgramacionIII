package co.edu.uniquindio.Model;

import java.util.LinkedList;
import java.util.List;

public class Cuenta {
    public String idCuenta;
    public String nombreBanco;
    public String numeroCuenta;
    public String tipoCuenta;
    public double saldo;
    public String nombreUsuario;
    private List<Transaccion> transacciones = new LinkedList<Transaccion>();

    public Cuenta(String idCuenta, String nombreBanco, String numeroCuenta, String tipoCuenta, double saldo, String nombreUsuario) {
        this.idCuenta = idCuenta;
        this.nombreBanco = nombreBanco;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
        this.nombreUsuario = nombreUsuario;
    }

    public String getIdCuenta(){
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {return tipoCuenta;}

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public double getSaldo() {return saldo;}

    public void setSaldo(double saldo) {this.saldo = saldo;}

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void agregarTransaccion(Transaccion transaccion) {
        transacciones.add(transaccion);
    }

    public List<Transaccion> getTransacciones() {return transacciones;}

    @Override
    public String toString() {
        return "Cuenta [idCuenta=" + idCuenta + ", nombreBanco=" + nombreBanco + ", numeroCuenta=" + numeroCuenta
                + ", tipoCuenta=" + tipoCuenta + ", saldo=" + saldo + "]";
    }
}