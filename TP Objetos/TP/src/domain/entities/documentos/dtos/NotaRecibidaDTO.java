package domain.entities.documentos.dtos;

import domain.entities.Proveedor;
import domain.entities.enumeraciones.TipoNota;

public class NotaRecibidaDTO {
    private double monto;
    private Proveedor proveedor;
    private TipoNota nota;

    NotaRecibidaDTO(double monto, Proveedor proveedor, TipoNota nota){
        this.monto = monto;
        this.nota = nota;
        this.proveedor = proveedor;
    }
}
