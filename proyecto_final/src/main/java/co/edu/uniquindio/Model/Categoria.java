package co.edu.uniquindio.Model;

import java.util.LinkedList;

public class Categoria {
    public String idCategoria;
    public String nombre;
    public String descripcion;

    public Categoria() {
    }
    
    public Categoria(String idCategoria, String nombre, String descripcion) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Categoria [idCategoria=" + idCategoria + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
    }

    private static LinkedList<Categoria> categorias = new LinkedList<>();
}
