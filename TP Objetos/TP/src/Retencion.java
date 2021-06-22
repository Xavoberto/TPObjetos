import java.time.LocalDate;

public class Retencion {

    private Proveedor proveedor;
    private int idLibroRetencion;
    private LocalDate fecha;
    private double total;

    public double getTotal(){
        return total;
    }

    public Retencion CalcularRetencion(DocumentoRecibido documentosAsociados){

    }

    Retencion(RetencionDTO retencionDTO){
        proveedor = retencionDTO.getProveedor();
        fecha = LocalDate.now();
        total = retencionDTO.getTotal();
    }
}