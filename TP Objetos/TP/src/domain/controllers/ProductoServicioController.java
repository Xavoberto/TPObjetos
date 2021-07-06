package domain.controllers;

import domain.entities.ProductoServicio;
import domain.entities.Rubro;
import domain.entities.documentos.Iva;
import domain.entities.enumeraciones.TipoDeUnidad;

import javax.swing.*;
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
                "primero", new Iva(5),new Rubro("rubro")));
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



    public boolean AltaProductoServicio(Rubro rubro,TipoDeUnidad tipoDeUnidad,String[] ps){
       Rubro rubro2 = getRubros().stream().filter(r -> Objects.equals(r.getNombre(),rubro.getNombre())).findFirst().get();
        return rubro2.AltaProductoServicio(tipoDeUnidad, ps, rubro);
    }

    public boolean AltaProductoServicio(Rubro rubro, TipoDeUnidad tipoDeUnidad, String nombre, double precio, String descripcion, double iva) {
        Rubro rubro1 = getRubros().stream().filter(r -> Objects.equals(r.getNombre(),rubro.getNombre())).findFirst().get();
        return rubro1.AltaProductoServicio(rubro,tipoDeUnidad, nombre, precio, descripcion, iva);
    }

    public boolean AltaRubro(String nombre){
        try{
            rubros.add(new Rubro(nombre));

            JOptionPane.showMessageDialog(null,"Rubro creado");
            return true;

        }catch (Exception ex){
            JOptionPane.showMessageDialog(null,"El rubro no se pudo crear");
            return false;

        }

    }


}

