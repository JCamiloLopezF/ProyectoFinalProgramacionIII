package co.edu.uniquindio.DTO;

public class PresupuestoDTO{
    private String nombre;
    private double monto;
    private String nombreUsuario;

    // Constructor con parámetros
    public PresupuestoDTO(String nombre, double monto, String nombreUsuario) {
        this.nombre = nombre;
        this.monto = monto;
        this.nombreUsuario = nombreUsuario;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Override
    public String toString() {
        return "PresupuestoDTO{" +
                "nombre='" + nombre + '\'' +
                ", monto=" + monto +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                '}';
    }
}
