package domain.entities.documentos.dtos;

import domain.entities.Proveedor;
import domain.entities.documentos.Iva;
import domain.entities.entitiesDtos.ProveedorDTO;
import domain.entities.enumeraciones.TipoDocumento;
import domain.entities.interfaces.DocumentoRecibido;

import java.time.LocalDate;

public class ConsultaLibroIvaDTO {
    private ProveedorDTO proveedor;
    private LocalDate fecha;
    private TipoDocumento tipoDocumento;
    private Iva iva;
    private double total;

    public ConsultaLibroIvaDTO(ProveedorDTO proveedor, LocalDate fecha, TipoDocumento tipoDocumento, Iva iva, double total){
        this.fecha = fecha;
        this.iva = iva;
        this.proveedor = proveedor;
        this.tipoDocumento = tipoDocumento;
        this.total = total;
    }
}
