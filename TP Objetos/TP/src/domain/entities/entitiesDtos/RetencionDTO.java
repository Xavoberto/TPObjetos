package domain.entities.entitiesDtos;

import domain.entities.Proveedor;

public class RetencionDTO {
    private Proveedor proveedor;
    private double total;

    RetencionDTO(Proveedor proveedor,double total){
        this.total = total;
        this.proveedor = proveedor;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public double getTotal() {
        return total;
    }
}