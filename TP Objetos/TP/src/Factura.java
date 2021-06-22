import java.time.LocalDate;
import java.util.List;

public class Factura implements DocumentoRecibido{
    private Proveedor proveedor;
    private OrdenDeCompra ordenDeCompra;
    private LocalDate fecha;
    private List<ProductoFactura> productos;



    public Factura BuscarFactura(LocalDate fecha, Proveedor proveedor){
        Factura factura = new Factura();

        return factura;
    }

    public Factura BuscarFactura(LocalDate fecha){
        Factura factura = new Factura();
        return factura;
    }

    public Factura BuscarFactura(Proveedor proveedor){
        Factura factura = new Factura();
        return factura;
    }

    public double getMonto(){
        double monto = 0;

        for (ProductoFactura producto : productos) {
            monto =+ producto.getPrecio();
        }

        return monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }
}
