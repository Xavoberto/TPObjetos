package domain.entities.entitiesDtos;

import domain.entities.Proveedor;
import domain.entities.Retencion;
import domain.entities.interfaces.DocumentoRecibido;

import java.time.LocalDate;
import java.util.List;

public class RetencionDTO {
    private Proveedor proveedor;
    private double total;
    private LocalDate fecha;

    public RetencionDTO(Retencion retencion){
        this.total = retencion.getTotal();
        this.proveedor = retencion.getProveedor();
        fecha = retencion.getFecha();
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public double getTotal() {
        return total;
    }
}