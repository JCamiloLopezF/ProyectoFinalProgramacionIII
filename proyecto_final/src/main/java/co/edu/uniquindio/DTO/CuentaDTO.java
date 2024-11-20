package co.edu.uniquindio.DTO;

public class CuentaDTO{
    private String idCuenta;
    private String nombreBanco;
    private String numeroCuenta;
    private String tipoCuenta;
    private double saldo;
    private String nombreUsuario;

    // Constructor con parámetros
    public CuentaDTO(String idCuenta, String nombreBanco, String numeroCuenta, String tipoCuenta, double saldo, String nombreUsuario) {
        this.idCuenta = idCuenta;
        this.nombreBanco = nombreBanco;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
        this.nombreUsuario = nombreUsuario;
    }

    // Getters y Setters
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

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Override
    public String toString() {
        return "CuentaDTO{" +
                "idCuenta='" + idCuenta + '\'' +
                ", nombreBanco='" + nombreBanco + '\'' +
                ", numeroCuenta='" + numeroCuenta + '\'' +
                ", tipoCuenta='" + tipoCuenta + '\'' +
                ", saldo=" + saldo +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                '}';
    }
}
