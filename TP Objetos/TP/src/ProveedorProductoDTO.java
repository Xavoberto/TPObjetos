public class ProveedorProductoDTO {

    private Proveedor proveedor;
    private ProductoServicio productoServicio;
    private double precio;


    public ProveedorProductoDTO(Proveedor proveedor, ProductoServicio productoServicio, double precio){
        this.proveedor = proveedor;
        this.productoServicio = productoServicio;
        this.precio = precio;

    }
}