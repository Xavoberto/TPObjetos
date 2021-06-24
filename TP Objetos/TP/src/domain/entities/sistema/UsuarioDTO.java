package domain.entities.sistema;

public class UsuarioDTO {
    private String nombre;
    private int dni;
    private String contrasena;

    public UsuarioDTO(String nombre, String contrasena,int dni){
        this.contrasena = contrasena;
        this.dni = dni;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    public String getContraseña() {
        return contrasena;
    }
}
