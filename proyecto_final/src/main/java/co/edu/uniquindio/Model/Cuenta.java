package co.edu.uniquindio.Model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Cuenta {
    public String idCuenta;
    public String nombreBanco;
    public String numeroCuenta;
    public TipoCuenta tipoCuenta;
    public double saldo;
    private List<Presupuesto> presupuestos = new LinkedList<Presupuesto>();
    private List<Transaccion> transacciones = new LinkedList<Transaccion>();

    public Cuenta(String idCuenta, String nombreBanco, String numeroCuenta, TipoCuenta tipoCuenta) {
        this.idCuenta = idCuenta;
        this.nombreBanco = nombreBanco;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
    }

    public String getIdCuenta() {
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

    public TipoCuenta getTipoCuenta() {return tipoCuenta;}

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public double getSaldo() {return saldo;}

    public void setSaldo(double saldo) {this.saldo = saldo;}

    public void agregarTransaccion(Transaccion transaccion) {
        transacciones.add(transaccion);
    }

    public void agregarPresupuesto (Presupuesto presupuesto){presupuestos.add(presupuesto);}

    public void eliminarPresupuesto (Presupuesto presupuesto){presupuestos.remove(presupuesto);}

    public List<Transaccion> getTransacciones() {return transacciones;}

    public List<Presupuesto> getPresupuestos() {return presupuestos;}

    @Override
    public String toString() {
        return "Cuenta [idCuenta=" + idCuenta + ", nombreBanco=" + nombreBanco + ", numeroCuenta=" + numeroCuenta
                + ", tipoCuenta=" + tipoCuenta + ", saldo=" + saldo + "]";
    }

    

}
