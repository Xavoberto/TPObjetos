package domain.entities.documentos.dtos;

import domain.entities.Proveedor;
import domain.entities.documentos.OrdenDeCompra;
import domain.entities.documentos.ProductoFactura;

import java.time.LocalDate;
import java.util.List;

public class FacturaDTO {
    private Proveedor proveedor;
    private OrdenDeCompra ordenDeCompra;
    private LocalDate fecha;
    private List<ProductoFactura> productoFacturas;

    FacturaDTO(Proveedor proveedor, OrdenDeCompra ordenDeCompra, LocalDate fecha, List<ProductoFactura>productoFacturas){
        this.fecha = fecha;
        this.ordenDeCompra = ordenDeCompra;
        this.productoFacturas = productoFacturas;
        this.proveedor = proveedor;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public OrdenDeCompra getOrdenDeCompra() {
        return ordenDeCompra;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public List<ProductoFactura> getProductos() {
        return productoFacturas;
    }
}
