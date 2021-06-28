package domain.entities.entitiesDtos;

import domain.entities.documentos.Iva;
import domain.entities.enumeraciones.TipoDeUnidad;

public class ProductoServicioDTO {
    private String nombre;
    private TipoDeUnidad tipoDeUnidad;
    private double precio;
    private String descripcion;
    private Iva iva;

    public ProductoServicioDTO(String nombre, TipoDeUnidad tipoDeUnidad, double precio, String descripcion, Iva iva){
        this.descripcion = descripcion;
        this.iva = iva;
        this.nombre = nombre;
        this.tipoDeUnidad = tipoDeUnidad;
        this.precio = precio;
    }


}
