public class NotaRecibida implements DocumentoRecibido{
    private double monto;
    private Proveedor proveedor;
    private TipoNota notaDe;


    public double getMonto() {
        return monto;
    }

    public boolean esFactura(){
        return false;
    }
}
