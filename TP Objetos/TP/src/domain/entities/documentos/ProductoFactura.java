package domain.entities.documentos;

public class ProductoFactura {
    private String nombre;
    private double precio;
    private String descripcion;
    private Iva iva;

    public double getPrecio() {
        return precio;
    }
    public Iva getIva() {return iva;}
}
