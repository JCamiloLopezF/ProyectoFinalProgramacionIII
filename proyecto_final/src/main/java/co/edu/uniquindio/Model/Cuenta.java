package co.edu.uniquindio.Model;

public class Cuenta {
    public String idCuenta;
    public String nombreBanco;
    public String numeroCuenta;
<<<<<<< Updated upstream
    public TipoCuenta tipoCuenta;
=======
    public String tipoCuenta;
    public double saldo;
    public String nombreUsuario;
    private List<Transaccion> transacciones = new LinkedList<Transaccion>();
>>>>>>> Stashed changes

    public Cuenta(String idCuenta, String nombreBanco, String numeroCuenta, String tipoCuenta, double saldo, String nombreUsuario) {
        this.idCuenta = idCuenta;
        this.nombreBanco = nombreBanco;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
<<<<<<< Updated upstream
=======
        this.saldo = saldo;
        this.transacciones = new LinkedList<>();
        this.nombreUsuario = nombreUsuario;
>>>>>>> Stashed changes
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
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

<<<<<<< Updated upstream
    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }
=======
    public String getTipoCuenta() {return tipoCuenta;}
>>>>>>> Stashed changes

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    @Override
    public String toString() {
        return "Cuenta [idCuenta=" + idCuenta + ", nombreBanco=" + nombreBanco + ", numeroCuenta=" + numeroCuenta
                + ", tipoCuenta=" + tipoCuenta + "]";
    }

    

}
