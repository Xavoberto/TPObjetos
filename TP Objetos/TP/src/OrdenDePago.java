import java.util.List;

public class OrdenDePago {
    private double total;
    private FormaDePago formaDePago;
    private Retencion totalRetencion;
    private List<DocumentoRecibido> documentosAsociados;

    OrdenDePago(OrdenDePagoDTO ordenDePagoDTO){
        this.documentosAsociados = ordenDePagoDTO.getDocumentosAsociados();
        this.formaDePago = ordenDePagoDTO.getFormaDePago();
        this.total = ordenDePagoDTO.getTotal();
        this.totalRetencion = ordenDePagoDTO.getTotalRetencion();
    }
}
