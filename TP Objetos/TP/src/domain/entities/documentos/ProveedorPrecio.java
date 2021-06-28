package domain.entities.documentos;

public class ProveedorPrecio {

    private int cuitProveedor;
    private double precioProducto;

    public ProveedorPrecio(double precio, int cuit) {

        this.cuitProveedor = cuit;
        this.precioProducto = precio;
    }

    public int getCuitProveedor() {
        return cuitProveedor;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public String Print() {
        return "Cuit Del Proveedor: " + cuitProveedor + "  Precio del Producto: " + precioProducto;
    }

}
