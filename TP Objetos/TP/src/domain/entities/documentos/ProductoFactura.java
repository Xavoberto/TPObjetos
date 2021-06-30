package domain.entities.documentos;

import domain.entities.ProductoServicio;
import domain.entities.ProveedorProducto;

public class ProductoFactura {
    private String nombre;
    private double precio;
    private String descripcion;
    private Iva iva;


    public ProductoFactura(String nombre, double precio, String descripcion, Iva iva){
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.iva = iva;
    }

    public ProductoFactura(ProductoServicio productoServicio) {
        nombre = productoServicio.getNombre();
        precio = productoServicio.getPrecio();
        descripcion = productoServicio.getDescripcion();
        iva = productoServicio.getIva();
    }

    public ProductoFactura(String[] productoFactura) {
        nombre = productoFactura[0];
        precio = Double.parseDouble(productoFactura[1]);
        descripcion = productoFactura[2];
        iva = new Iva(Double.parseDouble(productoFactura[3]));
    }

    public double getPrecio() {
        return precio;
    }
    public Iva getIva() {return iva;}
}
