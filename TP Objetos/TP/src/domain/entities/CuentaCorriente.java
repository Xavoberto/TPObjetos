package domain.entities;

import domain.controllers.RetencionController;
import domain.entities.documentos.Factura;
import domain.entities.documentos.NotaRecibida;
import domain.entities.documentos.OrdenDePago;
import domain.entities.documentos.dtos.OrdenDePagoDTO;
import domain.entities.entitiesDtos.CuentaCorrienteDTO;
import domain.entities.entitiesDtos.RetencionDTO;
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

    public CuentaCorriente(Proveedor proveedor, double deuda, List<NotaRecibida> documentoRecibidos, List<Factura> facturas, List<OrdenDePago> pagosRealizados){
        this.proveedor = proveedor;
        this.deuda = deuda;
        this.documentosRecibidos = documentoRecibidos;
        this.documentosImpagos = facturas;
        this.pagosRealizados = pagosRealizados;
    }

    public CuentaCorriente(CuentaCorrienteDTO cuentaCorriente) {
        this.proveedor = cuentaCorriente.getProveedor();
        this.deuda = cuentaCorriente.getDeuda();
        this.documentosRecibidos = cuentaCorriente.getDocumentoRecibido();
        this.documentosImpagos = cuentaCorriente.getDocumentoImpago();
        this.pagosRealizados = cuentaCorriente.getPagosRealizados();
    }

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
        RetencionController retencionController = RetencionController.getInstance();

        double montoAPagar = documentosAPagar.stream().mapToDouble(d -> d.getMonto()).sum();
        Retencion retencion = retencionController.AltaRetencion(proveedor, montoAPagar, documentosAPagar);
        pagosRealizados.add(new OrdenDePago(montoAPagar,formaDePago,retencion,documentosAPagar));
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

    public String Print() {
        return "Nombre: " + proveedor.getNombre() + "  Deuda: " + deuda;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }


}
