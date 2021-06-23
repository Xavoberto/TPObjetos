package domain.controllers;

import domain.entities.Rubro;

import java.util.List;

public class ProductoServicioController {
    private List<Rubro> rubros;
    private static ProductoServicioController instancia = null;

    private ProductoServicioController (){

    }

    public static ProductoServicioController getInstance(){
        if (instancia == null){
            instancia = new ProductoServicioController();
        }
        return instancia;
    }

    public List<Rubro> getRubros() {
        return rubros;
    }
}

