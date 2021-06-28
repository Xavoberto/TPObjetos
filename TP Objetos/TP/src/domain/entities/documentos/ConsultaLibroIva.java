package domain.entities.documentos;

import domain.entities.Proveedor;
import domain.entities.enumeraciones.TipoDocumento;
import domain.entities.interfaces.DocumentoRecibido;

import java.time.LocalDate;

public class ConsultaLibroIva {
    private Proveedor proveedor;
    private LocalDate fecha;
    private TipoDocumento tipoDocumento;
    private Iva iva;
    private double total;

    public int getCuitProveedor() {
        return proveedor.getCuit();
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
