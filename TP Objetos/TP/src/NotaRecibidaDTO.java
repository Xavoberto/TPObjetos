public class NotaRecibidaDTO {
    private double monto;
    private Proveedor proveedor;
    private TipoNota nota;

    NotaRecibidaDTO(double monto,Proveedor proveedor,TipoNota nota){
        this.monto = monto;
        this.nota = nota;
        this.proveedor = proveedor;
    }
}
