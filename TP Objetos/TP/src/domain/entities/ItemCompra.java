package domain.entities;

public class ItemCompra {
    private ProveedorProducto producto;
    private  int cantidad;
    private double precio;

    public ItemCompra(String[] itemCompra, ProveedorProducto proveedorProducto) {
        producto = proveedorProducto;
        cantidad = Integer.parseInt(itemCompra[0]);
        precio = Double.parseDouble(itemCompra[1]);
    }

    public ItemCompra(ProveedorProducto proveedorProducto, int cantidad, double precio){
        producto = proveedorProducto;
        cantidad = cantidad;
        this.precio = precio;
    }



    public double getPrecio() {
        return precio;
    }
}