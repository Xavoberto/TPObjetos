package domain.controllers;

import domain.entities.*;
import domain.entities.documentos.*;
import domain.entities.documentos.dtos.OrdenDePagoDTO;
import domain.entities.entitiesDtos.CuentaCorrienteDTO;
import domain.entities.entitiesDtos.ProveedorDTO;
import domain.entities.enumeraciones.FormaDePago;
import domain.entities.enumeraciones.ResponsableIva;
import domain.entities.interfaces.DocumentoRecibido;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProveedorController {


    private List<Proveedor> proveedores;
    private static ProveedorController instancia = null;

    private ProveedorController (){
        proveedores = new ArrayList<Proveedor>();
        List<OrdenDePago> ordenDePagoList = new ArrayList<OrdenDePago>();
        List<DocumentoRecibido> documentoRecibidos = new ArrayList<DocumentoRecibido>();
        List<ProductoFactura> productoFacturas = new ArrayList<ProductoFactura>();
        productoFacturas.add(new ProductoFactura( "productofac1", 2, "prod1",new Iva(5)));

        ordenDePagoList.add(new OrdenDePago(0, null, null ,  documentoRecibidos ));
        proveedores.add(new Proveedor(
            123, ResponsableIva.MONOTRIBUTO, "Proveedor de Prueba", new Direccion(), "63746397",".com",1238721,
            LocalDateTime.now(), new ArrayList<Rubro>(), new ArrayList<Certificado>(), new CuentaCorriente(null,0,null, null,null),
                    new ArrayList<ProveedorProducto>(), new ArrayList<NotaRecibida>()));
        proveedores.get(0).setProveedorCuentaCorriente();
        documentoRecibidos.add(new Factura(proveedores.get(0), null, LocalDate.now(), productoFacturas ));
        proveedores.get(0).getCuentaCorriente().RealizarPago(FormaDePago.EFECTIVO,documentoRecibidos);

    }

    public static ProveedorController getInstance(){
        if (instancia == null){
            instancia = new ProveedorController();
        }
        return instancia;
    }

    public void AltaProveedor(ProveedorDTO proveedor){
        proveedores.add(new Proveedor(proveedor));
    }

    public CuentaCorrienteDTO ConsultaCuentaCorriente(int cuitProveedor){
        CuentaCorrienteDTO cuentaCorrienteDTO;

        Optional<Proveedor> proveedorOptional = buscarProveedor(cuitProveedor);
            if (proveedorOptional.isPresent())
                return new CuentaCorrienteDTO(proveedorOptional.get().getCuentaCorriente());

        for (int i=0; i < proveedores.size(); i++) {
            if (proveedores.get(i).getCuit() == cuitProveedor) {
                CuentaCorriente aux = proveedores.get(i).getCuentaCorriente();
                cuentaCorrienteDTO = new CuentaCorrienteDTO(aux.getProveedor(), aux.getDeuda(), aux.getDocumentoRecibido(),
                        aux.getDocumentoImpago(), aux.PagoRealizado());
                return cuentaCorrienteDTO;
            }
        }
        return null;
    }

    public List<ProveedorPrecio> ConsultaDePrecios (Rubro rubro, String nombreProducto){
        List<ProveedorPrecio> proveedorPrecioList = new ArrayList<ProveedorPrecio>();
        List<Proveedor>  proveedorList = this.proveedores.stream().filter(p -> p.TieneProducto(nombreProducto)).collect(Collectors.toList());

        for (Proveedor proveedor: proveedorList){
            proveedorPrecioList.add(new ProveedorPrecio(proveedor.getProducto(nombreProducto).getProductoServicio().getPrecio(),proveedor.getCuit()));
        }

        return proveedorPrecioList;
    }


    //Lista de cuit de proveedor con su respectiva deuda
    public List<DeudaProveedor> TotalDeudaPorProveedor(){
        List<DeudaProveedor> deudores = new ArrayList<DeudaProveedor>();

        for(Proveedor proveedor : proveedores){
            deudores.add(new DeudaProveedor(proveedor.getCuit(), proveedor.getCuentaCorriente().getDeuda()));
        }

        return deudores;
    }

    public ProveedorDTO getProveedor(int cuitProveedor){
        for(Proveedor proveedor : proveedores){
            if(proveedor.getCuit() == cuitProveedor)
                return new ProveedorDTO(proveedor);
        }
        return null;
    }

    public ProveedorDTO getProveedor(Rubro rubro){
        for(Proveedor proveedor : proveedores){
            if(proveedor.getRubros().contains(rubro))
                return new ProveedorDTO(proveedor);
        }
        return null;
    }

    public Optional<Proveedor> buscarProveedor(int cuit){
        Optional<Proveedor> proveedorOptional = this.proveedores.stream().filter(p -> p.getCuit() == cuit).findFirst();

        if (!proveedorOptional.isPresent())
            return null;
        return proveedorOptional;
    }

    public List<OrdenDePagoDTO> OrdenesDePagoEmitidas(){
        List<OrdenDePagoDTO> ordenDePagoDTOList = new ArrayList<OrdenDePagoDTO>();
        List<OrdenDePago> ordenDePagoList = new ArrayList<OrdenDePago>();


        for (Proveedor proveedor : proveedores){
            ordenDePagoList.addAll(proveedor.getCuentaCorriente().getPagosRealizados());

        }
        for (OrdenDePago ordenDePago : ordenDePagoList){
            ordenDePagoDTOList.add(new OrdenDePagoDTO(ordenDePago));
        }
        return ordenDePagoDTOList;
    }
}