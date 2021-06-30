package domain.controllers;

import domain.entities.*;
import domain.entities.documentos.*;
import domain.entities.documentos.dtos.OrdenDePagoDTO;
import domain.entities.entitiesDtos.CuentaCorrienteDTO;
import domain.entities.entitiesDtos.ProveedorDTO;
import domain.entities.enumeraciones.FormaDePago;
import domain.entities.enumeraciones.ResponsableIva;
import domain.entities.enumeraciones.RetencionImpuestos;
import domain.entities.enumeraciones.TipoDeUnidad;
import domain.entities.interfaces.DocumentoRecibido;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProveedorController {


    private List<Proveedor> proveedores;
    private static ProveedorController instancia = null;
    private ProductoServicioController productoServicioController = ProductoServicioController.getInstance();

    private ProveedorController (){
        proveedores = new ArrayList<Proveedor>();
        List<OrdenDePago> ordenDePagoList = new ArrayList<OrdenDePago>();
        List<DocumentoRecibido> documentoRecibidos = new ArrayList<DocumentoRecibido>();
        List<ProductoFactura> productoFacturas = new ArrayList<ProductoFactura>();
        productoFacturas.add(new ProductoFactura( "productofac1", 2, "prod1",new Iva(5)));
        List<ProveedorProducto> proveedorProductos = new ArrayList<ProveedorProducto>();
        proveedorProductos.add(new ProveedorProducto(null, new ProductoServicio("test", TipoDeUnidad.UNIDAD,21,"",new Iva(5)),21));
        List<Rubro> rubros = new ArrayList<Rubro>();
        rubros.add(productoServicioController.getRubros().get(0));
        List<Factura> facturasProveedor = new ArrayList<Factura>();
        facturasProveedor.add(new Factura(null,null,LocalDate.now(),productoFacturas));

        ordenDePagoList.add(new OrdenDePago(0, FormaDePago.EFECTIVO, null ,  documentoRecibidos ));
        proveedores.add(new Proveedor(
            123, ResponsableIva.MONOTRIBUTO, "Proveedor de Prueba", null, "63746397",".com",1238721,
            LocalDateTime.now(),rubros , new ArrayList<Certificado>(), proveedorProductos, new ArrayList<NotaRecibida>()));

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

    public void AltaProveedor(String[] datos, String[] direccion) {
        try{
            if(BuscarProveedor(Integer.parseInt(datos[0])) == null){
                proveedores.add(new Proveedor(datos, direccion));
                JOptionPane.showMessageDialog(null, "Proveedor Creado");
            }
            else
                JOptionPane.showMessageDialog(null, "Proveedor ya existe");
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null,"Error, revise los datos e intente nuevamente");
        }

    }

    public CuentaCorrienteDTO ConsultaCuentaCorriente(int cuitProveedor){
        CuentaCorrienteDTO cuentaCorrienteDTO;

        Optional<Proveedor> proveedorOptional = BuscarProveedor(cuitProveedor);
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

    public List<ProveedorPrecio> ConsultaDePrecios(Rubro rubro, String nombreProducto){
        List<ProveedorPrecio> proveedorPrecioList = new ArrayList<ProveedorPrecio>();
        List<Proveedor> proveedorList = this.proveedores.stream().filter(p -> p.TieneProducto(nombreProducto)
                && p.getRubros().stream().anyMatch(r -> Objects.equals(r.getNombre().toLowerCase(), rubro.getNombre().toLowerCase()))).collect(Collectors.toList());

        for (Proveedor proveedor: proveedorList){
            proveedorPrecioList.add(new ProveedorPrecio(proveedor.getProducto(nombreProducto).getProductoServicio().getPrecio(),proveedor.getCuit()));
        }

        return proveedorPrecioList;
    }


    //Lista de cuit de proveedor con su respectiva deuda
    public String TotalDeudaPorProveedor(){
        String respuesta = "";

        for(Proveedor proveedor : proveedores){
            respuesta += (new DeudaProveedor(proveedor.getCuit(), proveedor.getCuentaCorriente().getDeuda())).Print();
        }

        return respuesta;
    }

    public ProveedorDTO getProveedor(int cuitProveedor){
        for(Proveedor proveedor : proveedores){
            if(proveedor.getCuit() == cuitProveedor)
                return new ProveedorDTO(proveedor);
        }
        return null;
    }
    public List<Proveedor> getProveedoresParaPantalla(){
        return proveedores;
    }

    public ProveedorDTO getProveedor(Rubro rubro){
        for(Proveedor proveedor : proveedores){
            if(proveedor.getRubros().contains(rubro))
                return new ProveedorDTO(proveedor);
        }
        return null;
    }

    public Optional<Proveedor> BuscarProveedor(int cuit){
        Optional<Proveedor> proveedorOptional = this.proveedores.stream().filter(p -> p.getCuit() == cuit).findFirst();

        if (!proveedorOptional.isPresent())
            return null;
        return proveedorOptional;
    }

    public String OrdenesDePagoEmitidas(){
        String respuesta = "";
        List<OrdenDePago> ordenDePagoList = new ArrayList<OrdenDePago>();

        for (Proveedor proveedor : proveedores){
            ordenDePagoList.addAll(proveedor.getCuentaCorriente().getPagosRealizados());

        }
        for (OrdenDePago ordenDePago : ordenDePagoList){
            respuesta += ordenDePago.Print();
        }
        return respuesta;
    }

    public List<Factura> DocumentosConsultaLibroIva(int cuitProveedor) {
        return getProveedor(cuitProveedor).getCuentaCorriente().getDocumentoImpago();
    }


    public boolean AltaProveedorProducto(Proveedor proveedor, ProductoServicio productoServicio, Double precioAcordado) {

        Proveedor proveedor1 = getProveedoresParaPantalla().stream().filter(p -> Objects.equals(p.getCuit(),proveedor.getCuit())).findFirst().get();
        return proveedor1.AltaProveedorProducto(productoServicio,precioAcordado);


    }

    public void AltaCertificado(Proveedor proveedor, RetencionImpuestos retencionImpuestos) {
        Proveedor proveedor1 = getProveedoresParaPantalla().stream().filter(p -> Objects.equals(p.getCuit(),proveedor.getCuit())).findFirst().get();
        proveedor1.AltaCertificado(retencionImpuestos);
    }
}