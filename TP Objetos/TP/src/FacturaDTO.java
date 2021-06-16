import java.time.LocalDate;
import java.util.List;

public class FacturaDTO {
    private Proveedor proveedor;
    private OrdenDePago ordenDePago;
    private LocalDate fecha;
    private List<ProductoFactura> productoFacturas;

    FacturaDTO(Proveedor proveedor,OrdenDePago ordenDePago,LocalDate fecha,List<ProductoFactura>productoFacturas){
        this.fecha = fecha;
        this.ordenDePago = ordenDePago;
        this.productoFacturas = productoFacturas;
        this.proveedor = proveedor;
    }
}
