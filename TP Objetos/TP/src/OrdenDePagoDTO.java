import java.util.List;

public class OrdenDePagoDTO {
    private final List<DocumentoRecibido> documentosRecibidos;
    private double total;
    private FormaDePago formaDePago;
    private Retencion retencion;
    private List<DocumentoRecibido> documentoRecibidos;

    OrdenDePagoDTO(double total,FormaDePago formaDePago,Retencion retencion,List<DocumentoRecibido>documentoRecibido){
        this.documentosRecibidos = documentoRecibido;
        this.total = total;
        this.formaDePago = formaDePago;
        this.retencion = retencion;
    }

    public List<DocumentoRecibido> getDocumentosAsociados() {
        return documentoRecibidos;
    }

    public FormaDePago getFormaDePago() {
        return formaDePago;
    }

    public double getTotal() {
        return total;
    }

    public Retencion getTotalRetencion() {
        return retencion;
    }
}
