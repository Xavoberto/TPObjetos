package domain.controllers;

import domain.entities.sistema.Usuario;
import domain.entities.sistema.UsuarioDTO;

import java.util.List;

public class UsuariosController {
    private List<Usuario> usuarios;
    private static UsuariosController instancia = null;

    private UsuariosController (){

    }

    public static UsuariosController getInstance(){
        if (instancia == null){
            instancia = new UsuariosController();
        }
        return instancia;
    }

    public void AltaUsuario(UsuarioDTO usuario){


    }

    public  void BajaUsuario(UsuarioDTO usuario){


    }

    public void ModificarUsuario(UsuarioDTO usuario){


    }





}
