package domain.entities.sistema;

public class Usuario {
    private String nombre;
    private int dni;
    private String contraseña;

    public Usuario(UsuarioDTO usuarioDTO){
        nombre = usuarioDTO.getNombre();
        dni = usuarioDTO.getDni();
        contraseña = usuarioDTO.getContraseña();
    }

    public int getDni() {
        return dni;
    }
}
