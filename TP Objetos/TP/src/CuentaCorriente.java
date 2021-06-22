import java.util.List;

public class CuentaCorriente {

    private Proveedor proveedor;
    private double deuda;
    private List<NotaRecibida> documentosRecibidos;
    private List<Factura> documentosImpagos;
    private List<OrdenDePago> pagosRealizados;

    public double getDeuda(){
        return deuda;
    }

    public List<OrdenDePago> getPagosRealizados(){
        return pagosRealizados;
    }

    public void RealizarPago(FormaDePago formaDePago, List<DocumentoRecibido> documentosAPagar){
        RetencionDTO retencionDTO = new RetencionDTO(proveedor,0);
        Retencion retencion = new Retencion(retencionDTO);

        OrdenDePagoDTO ordenDTO = new OrdenDePagoDTO(0,formaDePago,retencion,documentosAPagar);
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
