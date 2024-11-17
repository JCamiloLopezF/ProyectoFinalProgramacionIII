package co.edu.uniquindio.Model;

public class Transaccion {
    public String idTransaccion;
    public String fechaTransaccion;
    private String monto;
    private String descripcionOpcional;
    private String numeroCuenta;
    
    public Transaccion(String idTransaccion, String fechaTransaccion, String monto,
            String descripcionOpcional, String numeroCuenta) {
        this.idTransaccion = idTransaccion;
        this.fechaTransaccion = fechaTransaccion;
        this.monto = monto;
        this.descripcionOpcional = descripcionOpcional;
        this.numeroCuenta = numeroCuenta;
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public String getFechaTransaccion() {
        return fechaTransaccion;
    }

    public String getMonto() {
        return monto;
    }

    public String getDescripcionOpcional() {
        return descripcionOpcional;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    @Override
    public String toString() {
        return "Transaccion [idTransaccion=" + idTransaccion + ", fechaTransaccion=" + fechaTransaccion + ", monto="
                + monto + ", descripcionOpcional=" + descripcionOpcional + ", numeroCuenta=" + numeroCuenta + "]";
    }


    
}
