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



    public double getMonto(){
        double monto = 0;

        for (ProductoFactura producto : productos) {
            monto =+ producto.getPrecio();
        }

        return monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public double getIvaTotal(){
        double iva = 0;

        for(ProductoFactura producto : productos){
            iva += producto.getIva().getValor();
        }
        return iva;
    }

    public boolean esFactura(){
        return true;
    }
}
