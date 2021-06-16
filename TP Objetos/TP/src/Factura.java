import java.time.LocalDate;
import java.util.List;

public class Factura {
    private Proveedor proveedor;
    private OrdenDeCompra ordenDeCompra;
    private LocalDate fecha;
    private List<ProductoFactura> producto;



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
        return 0;
    }
}
