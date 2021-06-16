import java.time.LocalDate;

public class ConsultaLibroIvaDTO {
    private Proveedor proveedor;
    private LocalDate fecha;
    private DocumentoRecibido tipoDocumento;
    private Iva iva;
    private double total;

    ConsultaLibroIvaDTO(Proveedor proveedor,LocalDate fecha,DocumentoRecibido documentoRecibido,Iva iva,double total){
        this.fecha = fecha;
        this.iva = iva;
        this.proveedor = proveedor;
        this.tipoDocumento = documentoRecibido;
        this.total = total;
    }
}
