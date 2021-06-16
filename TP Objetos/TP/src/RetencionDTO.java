import java.time.LocalDate;

public class RetencionDTO {
    private Proveedor proveedor;
    private int idLibroRetencion;
    private LocalDate fecha;
    private double total;

    RetencionDTO(Proveedor proveedor,double total, LocalDate fecha, int idLibroRetencion){
        this.fecha = fecha;
        this.idLibroRetencion = idLibroRetencion;
        this.total = total;
        this.proveedor = proveedor;
    }
}
