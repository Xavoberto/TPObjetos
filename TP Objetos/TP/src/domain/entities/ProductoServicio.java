package domain.entities;

import domain.entities.documentos.Iva;
import domain.entities.entitiesDtos.ProductoServicioDTO;
import domain.entities.enumeraciones.TipoDeUnidad;

public class ProductoServicio {
    private String nombre;
    private TipoDeUnidad tipoDeUnidad;
    private double precio;
    private String descripcion;
    private Iva iva;


    public ProductoServicio(String nombre, TipoDeUnidad tipoDeUnidad, double precio, String descripcion, Iva iva){
        this.nombre = nombre;
        this.tipoDeUnidad = tipoDeUnidad;
        this.precio = precio;
        this.descripcion = descripcion;
        this.iva = iva;
    }

    public ProductoServicio(ProductoServicioDTO productoServicioDTO){
        this.nombre = productoServicioDTO.getNombre();
        this.tipoDeUnidad = productoServicioDTO.getTipoDeUnidad();
        this.precio = productoServicioDTO.getPrecio();
        this.descripcion = productoServicioDTO.getDescripcion();
        this.iva = iva;
    }

    public ProductoServicio(TipoDeUnidad tipoDeUnidad,String[] PS){
        this.nombre = PS[0];
        this.tipoDeUnidad = tipoDeUnidad;
        this.precio = Double.parseDouble(PS[1]);
        this.descripcion = PS[2];
        this.iva = new Iva(Double.parseDouble(PS[3]));
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoDeUnidad getTipoDeUnidad() {
        return tipoDeUnidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Iva getIva() {
        return iva;
    }

    public String toString(){
        return nombre;
    }
}
