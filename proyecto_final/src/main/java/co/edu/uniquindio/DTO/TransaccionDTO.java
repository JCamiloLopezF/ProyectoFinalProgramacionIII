package co.edu.uniquindio.DTO;

public class TransaccionDTO{
    private String idTransaccion;
    private String fechaTransaccion;
    private double monto;
    private String descripcionOpcional;
    private String numeroCuenta;
    private String nombreUsuario;

    public TransaccionDTO(String idTransaccion, String fechaTransaccion, double monto, String descripcionOpcional,
                          String numeroCuenta, String nombreUsuario) {
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

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
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

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Override
    public String toString() {
        return "TransaccionDTO{" +
                "idTransaccion='" + idTransaccion + '\'' +
                ", fechaTransaccion='" + fechaTransaccion + '\'' +
                ", monto=" + monto +
                ", descripcionOpcional='" + descripcionOpcional + '\'' +
                ", numeroCuenta='" + numeroCuenta + '\'' +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                '}';
    }
}
