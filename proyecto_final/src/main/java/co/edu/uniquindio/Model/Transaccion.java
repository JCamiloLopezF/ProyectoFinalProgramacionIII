package co.edu.uniquindio.Model;

public class Transaccion {
    public String idTransaccion;
    public String fechaTransaccion;
    private String monto;
    private String descripcionOpcional;
    private String numeroCuenta;
    public String nombreUsuario;
    
    public Transaccion(String idTransaccion, String fechaTransaccion, String monto,
            String descripcionOpcional, String numeroCuenta, String nombreUsuario) {
        this.idTransaccion = idTransaccion;
        this.fechaTransaccion = fechaTransaccion;
        
        this.monto = monto;
        this.descripcionOpcional = descripcionOpcional;
        this.numeroCuenta = numeroCuenta;
        this.nombreUsuario = nombreUsuario;
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(String fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getDescripcionOpcional() {
        return descripcionOpcional;
    }

    public void setDescripcionOpcional(String descripcionOpcional) {
        this.descripcionOpcional = descripcionOpcional;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public String toString() {
        return "Transaccion [idTransaccion=" + idTransaccion + ", fechaTransaccion=" + fechaTransaccion + ", monto="
                + monto + ", descripcionOpcional=" + descripcionOpcional + ", numeroCuenta=" + numeroCuenta + "]";
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }


    
}
