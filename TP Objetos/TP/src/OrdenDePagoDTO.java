import java.util.List;

public class OrdenDePagoDTO {
    private double total;
    private FormaDePago formaDePago;
    private Retencion retencion;
    private List<DocumentoRecibido> documentoRecibidoList;

    OrdenDePagoDTO(double total,FormaDePago formaDePago,Retencion retencion,List<DocumentoRecibido>documentoRecibido){
        this.documentoRecibidoList = documentoRecibido;
        this.total = total;
        this.formaDePago = formaDePago;
        this.retencion = retencion;
    }
}
