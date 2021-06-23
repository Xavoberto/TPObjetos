package domain.entities;

import domain.entities.entitiesDtos.ProductoServicioDTO;

public class ProveedorProducto {
    private Proveedor proveedor;
    private ProductoServicio producto;
    private double precio;

    public ProductoServicioDTO getProductoServicio(){
         return new ProductoServicioDTO(producto.getNombre(),producto.getTipoDeUnidad(),producto.getPrecio(),producto.getDescripcion(),producto.getIva());
    }
}