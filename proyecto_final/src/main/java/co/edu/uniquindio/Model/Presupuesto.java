package co.edu.uniquindio.Model;

public class Presupuesto {

    public String nombre;
    public double montoTotalAsignado;
    public String nombreUsuario;
    
    public Presupuesto(String nombre, double montoTotalAsignado, String nombreUsuario) {
        this.nombre = nombre;
        this.montoTotalAsignado = montoTotalAsignado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMontoTotalAsignado() {
        return montoTotalAsignado;
    }

    public void setMontoTotalAsignado(double montoTotalAsignado) {
        this.montoTotalAsignado = montoTotalAsignado;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Override
    public String toString() {
        return "Motivo: " + nombre + "; Monto asignado = $" + montoTotalAsignado + "\n";
    }

    
}
