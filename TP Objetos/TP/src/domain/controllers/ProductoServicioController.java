package domain.controllers;

import domain.entities.ProductoServicio;
import domain.entities.Rubro;
import domain.entities.documentos.Iva;
import domain.entities.enumeraciones.TipoDeUnidad;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public boolean AltaProductoServicio(Rubro rubro,String[] ps){
       Rubro rubro2 = getRubros().stream().filter(r -> Objects.equals(r.getNombre(),rubro.getNombre())).findFirst().get();
        return rubro.AltaProductoServicio(ps);
    }

}

