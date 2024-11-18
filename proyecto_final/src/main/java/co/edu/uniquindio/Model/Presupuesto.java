package co.edu.uniquindio.Model;

public class Presupuesto {
    public String nombre;
    public double monto;
    public String nombreUsuario;
    
    public Presupuesto(String nombre, double monto, String nombreUsuario) {
        this.nombre = nombre;
        this.monto = monto;
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMontoTotalAsignado() {
        return monto;
    }

    public void setMontoTotalAsignado(double monto) {
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
        return "Presupuesto [nombre=" + nombre + ", monto=" + monto + ", nombreUsuario=" + nombreUsuario + "]";
    }
}
