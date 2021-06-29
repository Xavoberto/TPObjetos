package domain.entities;

import domain.entities.entitiesDtos.ProductoServicioDTO;

public class ProveedorProducto {
    private Proveedor proveedor;
    private ProductoServicio producto;
    private double precio;

    public ProveedorProducto(Proveedor proveedor, ProductoServicio productoServicio, double precio){
        this.precio = precio;
        this.proveedor = proveedor;
        this.producto = productoServicio;
    }

    public ProductoServicioDTO getProductoServicio(){
         return new ProductoServicioDTO(producto.getNombre(),producto.getTipoDeUnidad(),producto.getPrecio(),producto.getDescripcion(),producto.getIva());
    }
}