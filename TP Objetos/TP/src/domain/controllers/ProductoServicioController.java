package domain.controllers;

import domain.entities.ProductoServicio;
import domain.entities.Rubro;
import domain.entities.documentos.Iva;
import domain.entities.enumeraciones.TipoDeUnidad;

import java.util.ArrayList;
import java.util.List;





public class ProductoServicioController {
    private List<Rubro> rubros;
    private static ProductoServicioController instancia = null;

    private ProductoServicioController (){
        rubros = new ArrayList<Rubro>();
        List<ProductoServicio> productoServicios = new ArrayList<ProductoServicio>();
        productoServicios.add(new ProductoServicio("producto1", TipoDeUnidad.UNIDAD, 2.5,
                "primero", new Iva(5)));
        rubros.add(new Rubro("rubro1",productoServicios));
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

