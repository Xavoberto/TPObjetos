package domain.entities.entitiesDtos;

import domain.entities.Rubro;
import domain.entities.documentos.Iva;
import domain.entities.enumeraciones.TipoDeUnidad;

public class ProductoServicioDTO {
    private String nombre;
    private TipoDeUnidad tipoDeUnidad;
    private double precio;
    private String descripcion;
    private Iva iva;
    private Rubro rubro;

    public ProductoServicioDTO(String nombre, TipoDeUnidad tipoDeUnidad, double precio, String descripcion, Iva iva, Rubro rubro){
        this.descripcion = descripcion;
        this.iva = iva;
        this.nombre = nombre;
        this.tipoDeUnidad = tipoDeUnidad;
        this.precio = precio;
        this.rubro = rubro;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public TipoDeUnidad getTipoDeUnidad() {
        return tipoDeUnidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Rubro getRubro() {
        return rubro;
    }
}
