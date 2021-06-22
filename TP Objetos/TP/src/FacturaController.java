import java.time.LocalDate;
import java.util.List;

public class FacturaController {
    private List<Factura> facturas;


    public void AltaFactura(FacturaDTO Factura){
        return;
    }

    public double FacturasRecibidas(LocalDate fecha,Proveedor proveedor){
        double total = 0;
        for (int i = 0; i < facturas.size(); i++){
            if (facturas.get(i).getFecha() == fecha && facturas.get(i).getProveedor() == proveedor){
                total += facturas.get(i).getMonto();
            }
        }
        return total;
    }

    public double FacturasRecibidas(LocalDate fecha){
        double total = 0;
        for (int i = 0; i < facturas.size(); i++){
            if (facturas.get(i).getFecha() == fecha){
                total += facturas.get(i).getMonto();
            }
        }
        return total;
    }

    public double FacturasRecibidas(Proveedor proveedor){
        double total = 0;
        for (int i = 0; i < facturas.size(); i++){
            if (facturas.get(i).getProveedor() == proveedor){
                total += facturas.get(i).getMonto();
            }
        }
        return total;
    }
}
