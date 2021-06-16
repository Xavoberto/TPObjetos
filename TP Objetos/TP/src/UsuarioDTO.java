public class UsuarioDTO {
    private String nombre;
    private int dni;
    private String contrasena;

    UsuarioDTO(String nombre, String contrasena,int dni){
        this.contrasena = contrasena;
        this.dni = dni;
        this.nombre = nombre;
    }
}
