package co.edu.uniquindio.DTO;


public class UsuarioDTO{
    private String idUsuario;
    private String nombreCompleto;
    private String correo;
    private String numeroTelefono;
    private String direccion;
    private double saldoDisponible;
    private String cuentaBilleteraId; 


    // Constructor con parámetros
    public UsuarioDTO(String idUsuario, String nombreCompleto, String correo, String numeroTelefono, String direccion, double saldoDisponible, String cuentaBilleteraId) {
        this.idUsuario = idUsuario;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.numeroTelefono = numeroTelefono;
        this.direccion = direccion;
        this.saldoDisponible = saldoDisponible;
        this.cuentaBilleteraId = cuentaBilleteraId;
    }

    // Getters y Setters
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public String getCuentaBilleteraId() {
        return cuentaBilleteraId;
    }

    public void setCuentaBilleteraId(String cuentaBilleteraId) {
        this.cuentaBilleteraId = cuentaBilleteraId;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "idUsuario='" + idUsuario + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", correo='" + correo + '\'' +
                ", numeroTelefono='" + numeroTelefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", saldoDisponible=" + saldoDisponible +
                ", cuentaBilleteraId='" + cuentaBilleteraId + '\'' +
                '}';
    }
}
