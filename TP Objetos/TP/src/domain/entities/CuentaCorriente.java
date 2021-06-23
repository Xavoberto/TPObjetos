package domain.entities;

import domain.entities.documentos.Factura;
import domain.entities.documentos.NotaRecibida;
import domain.entities.documentos.OrdenDePago;
import domain.entities.documentos.dtos.OrdenDePagoDTO;
import domain.entities.enumeraciones.FormaDePago;
import domain.entities.interfaces.DocumentoRecibido;

import java.time.LocalDate;
import java.util.List;

public class CuentaCorriente {

    private Proveedor proveedor;
    private double deuda;
    private List<NotaRecibida> documentosRecibidos;
    private List<Factura> documentosImpagos;
    private List<OrdenDePago> pagosRealizados;

    public double TotalDeFacturas(){
        return this.documentosImpagos.stream().mapToDouble(f -> f.getMonto()).sum();
    }

    public double TotalDeFacturas(LocalDate fecha){
        return this.documentosImpagos.stream().filter(f -> f.getFecha() == fecha).mapToDouble(f -> f.getMonto()).sum();
    }

    public double getDeuda(){
        return deuda;
    }

    public List<OrdenDePago> getPagosRealizados(){
        return pagosRealizados;
    }

    public void RealizarPago(FormaDePago formaDePago, List<DocumentoRecibido> documentosAPagar){
        double montoAPagar = 0;
        for (DocumentoRecibido documentoRecibido : documentosAPagar) {
            montoAPagar += documentoRecibido.getMonto();
        }

        Retencion retencion = new Retencion(proveedor,montoAPagar, documentosAPagar);

        OrdenDePagoDTO ordenDTO = new OrdenDePagoDTO(montoAPagar,formaDePago,retencion,documentosAPagar);
        OrdenDePago orden = new OrdenDePago(ordenDTO);

        pagosRealizados.add(orden);
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public List<NotaRecibida> getDocumentoRecibido() {
        return documentosRecibidos;
    }

    public List<Factura> getDocumentoImpago() {
        return documentosImpagos;
    }

    public List<OrdenDePago> PagoRealizado() {
        return PagoRealizado();
    }
}
