import java.util.List;

public class CuentaCorrienteDTO {
    private Proveedor proveedor;
    private double deuda;
    private List<NotaRecibida> documentosRecibidos;
    private List<Factura> documentosImpagos;
    private List<OrdenDePago> pagosRealizados;

    CuentaCorrienteDTO(Proveedor proveedor,double deuda,List<NotaRecibida> documentosRecibidos,List<Factura> documentosImpagos,List<OrdenDePago> pagosRealizados){
        this.proveedor = proveedor;
        this.deuda = deuda;
        this.documentosRecibidos = documentosRecibidos;
        this.documentosImpagos = documentosImpagos;
        this.pagosRealizados = pagosRealizados;
    }
}
