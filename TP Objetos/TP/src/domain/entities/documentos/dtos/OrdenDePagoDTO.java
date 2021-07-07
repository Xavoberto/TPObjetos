package domain.entities.documentos.dtos;

import domain.entities.Retencion;
import domain.entities.documentos.Factura;
import domain.entities.documentos.OrdenDePago;
import domain.entities.enumeraciones.FormaDePago;
import domain.entities.interfaces.DocumentoRecibido;

import java.util.List;

public class OrdenDePagoDTO {
    private double total;
    private FormaDePago formaDePago;
    private Retencion retencion;
    private List<DocumentoRecibido> documentoRecibidos;

    public OrdenDePagoDTO(double total, FormaDePago formaDePago, Retencion retencion, List<DocumentoRecibido> documentoRecibido){
        this.total = total;
        this.formaDePago = formaDePago;
        this.retencion = retencion;
        this.documentoRecibidos = documentoRecibido;
    }

    public OrdenDePagoDTO(OrdenDePago ordenDePago){
        documentoRecibidos = ordenDePago.getDocumentosRecibidos();
        total = ordenDePago.getTotal();
        formaDePago = ordenDePago.getFormaDePago();
        retencion = ordenDePago.getRetencion();

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