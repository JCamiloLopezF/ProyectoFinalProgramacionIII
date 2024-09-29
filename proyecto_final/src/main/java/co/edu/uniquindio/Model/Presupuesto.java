package co.edu.uniquindio.Model;

public class Presupuesto {
    public String idPresupuesto;
    public String nombre;
    public double montoTotalAsignado;
    public double montoGastado;
    public Categoria categoria;
    
    public Presupuesto(String idPresupuesto, String nombre, double montoTotalAsignado, double montoGastado,
            Categoria categoria) {
        this.idPresupuesto = idPresupuesto;
        this.nombre = nombre;
        this.montoTotalAsignado = montoTotalAsignado;
        this.montoGastado = montoGastado;
        this.categoria = categoria;
    }

    public String getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(String idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
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

    public double getMontoGastado() {
        return montoGastado;
    }

    public void setMontoGastado(double montoGastado) {
        this.montoGastado = montoGastado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
