package domain.controllers;

import domain.entities.sistema.Usuario;
import domain.entities.sistema.UsuarioDTO;

import java.util.ArrayList;
import java.util.List;

public class UsuariosController {
    private List<Usuario> usuarios;
    private static UsuariosController instancia = null;

    private UsuariosController (){
        usuarios = new ArrayList<Usuario>();
    }

    public static UsuariosController getInstance(){
        if (instancia == null){
            instancia = new UsuariosController();
        }
        return instancia;
    }

    public void AltaUsuario(String nombre, String contraseña, int dni){
        if(usuarios.stream().anyMatch(usuario -> usuario.getDni() == dni))
            usuarios.add(new Usuario(new UsuarioDTO(nombre,contraseña,dni)));
    }

    public  void BajaUsuario(int dni){
        usuarios.removeIf(usuario -> usuario.getDni() == dni);
    }

    public void ModificarUsuario(String nombre, String contraseña, int dni){
        usuarios.removeIf(usuario -> usuario.getDni() == dni);
        usuarios.add(new Usuario(new UsuarioDTO(nombre,contraseña,dni)));
    }
}