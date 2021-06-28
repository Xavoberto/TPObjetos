package domain.entities.documentos;

import domain.entities.Proveedor;
import domain.entities.enumeraciones.TipoNota;
import domain.entities.interfaces.DocumentoRecibido;

public class NotaRecibida implements DocumentoRecibido {
    private double monto;
    private Proveedor proveedor;
    private TipoNota notaDe;


    public double getMonto() {
        return monto;
    }

    public boolean esFactura(){
        return false;
    }
    public TipoNota getNotaDe(){
        return notaDe;
    }
}
