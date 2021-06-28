package domain.entities;

import domain.entities.entitiesDtos.ProductoServicioDTO;

import java.util.List;

public class Rubro {

    private String nombre;
    private List<ProductoServicio> productoServicios;

    public void AltaProductoServicio(ProductoServicioDTO productoServicioDTO){


    }
    public Rubro(String nombre, List<ProductoServicio> productoServicios){
        this.nombre = nombre;
        this.productoServicios = productoServicios;
    }


    public String toString(){
        return this.nombre;
    }

}