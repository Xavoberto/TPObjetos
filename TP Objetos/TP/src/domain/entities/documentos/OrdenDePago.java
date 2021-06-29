package domain.entities.documentos;

import domain.entities.Retencion;
import domain.entities.documentos.dtos.OrdenDePagoDTO;
import domain.entities.enumeraciones.FormaDePago;
import domain.entities.interfaces.DocumentoRecibido;

import java.util.List;

public class OrdenDePago {
    private double total;
    private FormaDePago formaDePago;
    private Retencion totalRetencion;
    private List<DocumentoRecibido> documentosAsociados;

    public OrdenDePago(OrdenDePagoDTO ordenDePagoDTO){
        this.documentosAsociados = ordenDePagoDTO.getDocumentosAsociados();
        this.formaDePago = ordenDePagoDTO.getFormaDePago();
        this.total = ordenDePagoDTO.getTotal();
        this.totalRetencion = ordenDePagoDTO.getTotalRetencion();
    }

    public OrdenDePago(double total, FormaDePago formaDePago, Retencion retencion, List<DocumentoRecibido> documentoRecibido){
        this.total = total;
        this.formaDePago = formaDePago;
        this.totalRetencion = retencion;
        this.documentosAsociados = documentoRecibido;
    }

    public List<DocumentoRecibido> getDocumentosRecibidos() {
        return documentosAsociados;
    }

    public double getTotal() {
        return total;
    }

    public FormaDePago getFormaDePago() {
        return formaDePago;
    }

    public Retencion getRetencion() {
        return totalRetencion;
    }

    public String Print() {
        return "Total: " + total + "  Forma de Pago: " + formaDePago + " Total de retencion: " + totalRetencion + ".      ";
    }
}
