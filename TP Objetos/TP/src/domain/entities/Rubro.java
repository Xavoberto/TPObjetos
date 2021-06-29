package domain.entities;

import domain.entities.documentos.Iva;
import domain.entities.entitiesDtos.ProductoServicioDTO;
import domain.entities.enumeraciones.TipoDeUnidad;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Rubro {

    private String nombre;
    private List<ProductoServicio> productoServicios;



    public Rubro(String nombre, List<ProductoServicio> productoServicios){
        this.nombre = nombre;
        this.productoServicios = productoServicios;
    }


    public String getNombre(){
        return this.nombre;
    }


    public boolean AltaProductoServicio(TipoDeUnidad tipoDeUnidad,String[] PS){
        try {
            productoServicios.add(new ProductoServicio(tipoDeUnidad, PS));
            JOptionPane.showMessageDialog(null,"producto creado");
            return true;

        }catch (Exception ex){
            JOptionPane.showMessageDialog(null,"producto no exite");
            return false;
        }
    }

    public List<ProductoServicio> getProductoServicios(){
        return productoServicios;
    }
}