package co.edu.uniquindio.DTO;

public class AdministradorDTO {
    private String admin;
    private String contrasena;

    // Constructor con parámetros
    public AdministradorDTO(String admin, String contrasena) {
        this.admin = admin;
        this.contrasena = contrasena;
    }

    // Getters y Setters
    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "AdministradorDTO{" +
                "admin='" + admin + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }
}
