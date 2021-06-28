package domain.entities.documentos;

import domain.entities.Proveedor;
import domain.entities.documentos.dtos.FacturaDTO;
import domain.entities.interfaces.DocumentoRecibido;

import java.time.LocalDate;
import java.util.List;

public class Factura implements DocumentoRecibido {
    private Proveedor proveedor;
    private OrdenDeCompra ordenDeCompra;
    private LocalDate fecha;
    private List<ProductoFactura> productos;

    public Factura(FacturaDTO factura) {
        proveedor = factura.getProveedor();
        ordenDeCompra = factura.getOrdenDeCompra();
        fecha = factura.getFecha();
        productos = factura.getProductos();

    }

    public Factura(Proveedor proveedor, OrdenDeCompra ordenDeCompra, LocalDate fecha, List<ProductoFactura> productoFacturas){
        this.fecha = fecha;
        this.ordenDeCompra = ordenDeCompra;
        this.productos = productoFacturas;
        this.proveedor = proveedor;
    }


    public double getMonto(){
        return productos.stream().mapToDouble(p -> p.getPrecio()).sum();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public boolean esFactura(){
        return true;
    }

    public double getIvaTotal(){
        return productos.stream().mapToDouble(p -> p.getIva().getValor()).sum();
    }

    public OrdenDeCompra getOrdenDeCompra(){
        return ordenDeCompra;
    }

    public List<ProductoFactura> getProductos() {return productos;
    }
}