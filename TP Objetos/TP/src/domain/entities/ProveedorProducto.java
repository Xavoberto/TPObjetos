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
    public ProveedorProducto(ProductoServicio productoServicio, double precio){
        this.producto = productoServicio;
        this.precio = precio;
    }

    public ProductoServicioDTO getProductoServicio(){
         return new ProductoServicioDTO(producto.getNombre(),producto.getTipoDeUnidad(),producto.getPrecio(),producto.getDescripcion(),producto.getIva());
    }

    public String ToString() {return producto.getNombre();
    }
}