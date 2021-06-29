package domain.entities.entitiesDtos;

import domain.entities.CuentaCorriente;
import domain.entities.Proveedor;
import domain.entities.documentos.Factura;
import domain.entities.documentos.NotaRecibida;
import domain.entities.documentos.OrdenDePago;

import java.util.List;

public class CuentaCorrienteDTO {
    private Proveedor proveedor;
    private double deuda;
    private List<NotaRecibida> documentosRecibidos;
    private List<Factura> documentosImpagos;
    private List<OrdenDePago> pagosRealizados;

    public CuentaCorrienteDTO(Proveedor proveedor, double deuda, List<NotaRecibida> documentosRecibidos, List<Factura> documentosImpagos, List<OrdenDePago> pagosRealizados){
        this.proveedor = proveedor;
        this.deuda = deuda;
        this.documentosRecibidos = documentosRecibidos;
        this.documentosImpagos = documentosImpagos;
        this.pagosRealizados = pagosRealizados;
    }

    public CuentaCorrienteDTO(CuentaCorriente cuentaCorriente){
        this.proveedor = cuentaCorriente.getProveedor();
        this.deuda = cuentaCorriente.getDeuda();
        this.documentosRecibidos = cuentaCorriente.getDocumentoRecibido();
        this.documentosImpagos = cuentaCorriente.getDocumentoImpago();
        this.pagosRealizados = cuentaCorriente.getPagosRealizados();
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public double getDeuda() {
        return deuda;
    }

    public List<NotaRecibida> getDocumentoRecibido() {
        return documentosRecibidos;
    }

    public List<Factura> getDocumentoImpago() {
        return documentosImpagos;
    }

    public List<OrdenDePago> getPagosRealizados() {
        return pagosRealizados;
    }

    public String Print() {
        return "Nombre: " + proveedor.getNombre() + "  Deuda: " + deuda;
    }
}
