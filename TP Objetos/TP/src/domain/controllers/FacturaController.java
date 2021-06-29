package domain.controllers;

import domain.entities.ProductoServicio;
import domain.entities.Proveedor;
import domain.entities.documentos.Factura;
import domain.entities.documentos.OrdenDeCompra;
import domain.entities.documentos.ProductoFactura;
import domain.entities.documentos.dtos.FacturaDTO;
import domain.entities.entitiesDtos.ProveedorDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class FacturaController {
    private List<Factura> facturas;
    private static FacturaController instancia = null;
    ProveedorController proveedorController = ProveedorController.getInstance();

    private FacturaController (){
        facturas = new ArrayList<Factura>();
        List<ProductoFactura> productosFacturas = new ArrayList<ProductoFactura>();
        Proveedor proveedor = new Proveedor(proveedorController.getProveedor(123));

        productosFacturas.add(new ProductoFactura(new ProductoServicio(proveedor.getProducto("test").getProductoServicio())));
        facturas.add(new Factura(proveedor, new OrdenDeCompra(), LocalDate.now(), productosFacturas));
    }

    public static FacturaController getInstance(){
        if (instancia == null){
            instancia = new FacturaController();
        }
        return instancia;
    }


    public void AltaFactura(FacturaDTO factura){
            facturas.add(new Factura(factura));
    }

    public Double TotalDeFacturas(LocalDate fecha, int cuitProveedor){
        ProveedorController proveedorController = ProveedorController.getInstance();
        Optional<Proveedor> optionalProveedor = proveedorController.buscarProveedor(cuitProveedor);

        return optionalProveedor.get().getCuentaCorriente().TotalDeFacturas(fecha);
    }

    public double TotalDeFacturas(LocalDate fecha){
        return this.facturas.stream().filter(f -> Objects.equals(f.getFecha(), fecha)).mapToDouble(f -> f.getMonto()).sum();
    }

    public Double TotalDeFacturas(int cuitProveedor){
        ProveedorController proveedorController = ProveedorController.getInstance();
        Optional<Proveedor> optionalProveedor = proveedorController.buscarProveedor(cuitProveedor);

        if (!optionalProveedor.isPresent())
            return null;
        return optionalProveedor.get().getCuentaCorriente().TotalDeFacturas();

    }

    public List<OrdenDeCompra> getOrdenesDeCompra() {
        List<OrdenDeCompra> ordenDeCompras = new ArrayList<OrdenDeCompra>();

        for (Factura factura : facturas){
            ordenDeCompras.add(factura.getOrdenDeCompra());
        }
        return ordenDeCompras;
    }

    public FacturaDTO getFactura(int cuitProveedor) {
        for(Factura factura : facturas){
            if(factura.getProveedor().getCuit() == cuitProveedor)
                return new FacturaDTO(factura);
        }
        return null;

    }
}