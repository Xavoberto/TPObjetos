package domain.entities;

import domain.entities.documentos.Certificado;
import domain.entities.documentos.Factura;
import domain.entities.documentos.OrdenDePago;
import domain.entities.documentos.dtos.CertificadoDTO;
import domain.entities.documentos.NotaRecibida;
import domain.entities.documentos.dtos.NotaRecibidaDTO;
import domain.entities.entitiesDtos.CuentaCorrienteDTO;
import domain.entities.entitiesDtos.ProveedorDTO;
import domain.entities.entitiesDtos.ProveedorProductoDTO;
import domain.entities.enumeraciones.ResponsableIva;
import domain.entities.enumeraciones.RetencionImpuestos;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Proveedor {
    private int cuit;
    private ResponsableIva responsableIva;
    private String nombreFantasia;
    private Direccion direccion;
    private String telefono;
    private String correoElectronico;
    private double numeroIngresosBrutos;
    private LocalDateTime inicioActividades;
    private List<Rubro> rubros;
    private List<Certificado> certificados;
    private CuentaCorriente cuentaCorriente;
    private List<ProveedorProducto> proveedorProductos;
    private List<NotaRecibida> notaRecibidas;

    public Proveedor(ProveedorDTO proveedor) {
        certificados = proveedor.getCertificados();
        correoElectronico = proveedor.getCorreoElectronico();
        cuentaCorriente = new CuentaCorriente(proveedor.getCuentaCorriente());
        inicioActividades = proveedor.getInicioActividades();
        cuit = proveedor.getCuit();
        direccion = proveedor.getDireccion();
        nombreFantasia = proveedor.getNombre();
        telefono = proveedor.getTelefono();
        numeroIngresosBrutos = proveedor.getIngresosBrutos();
        rubros = proveedor.getRubros();
        notaRecibidas = proveedor.getNotasRecibidas();
        proveedorProductos = proveedor.getProveedorProductos();
        responsableIva = proveedor.getResponsableIva();
    }

    public Proveedor(int cuit, ResponsableIva responsableIva, String nombreFantasia, Direccion direccion, String telefono, String correoElectronico, double numeroIngresosBrutos,
                        LocalDateTime inicioActividades, List<Rubro> rubros, List<Certificado> certificados,
                        List<ProveedorProducto> proveedorProductos, List<NotaRecibida> notaRecibidas){

        this.certificados = certificados;
        this.correoElectronico = correoElectronico;
        cuentaCorriente = new CuentaCorriente(this,0,new ArrayList<NotaRecibida>(),new ArrayList<Factura>(),new ArrayList<OrdenDePago>());
        this.inicioActividades = inicioActividades;
        this.cuit = cuit;
        this.direccion = direccion;
        this.nombreFantasia = nombreFantasia;
        this.telefono = telefono;
        this.numeroIngresosBrutos = numeroIngresosBrutos;
        this.rubros = rubros;
        this.notaRecibidas = notaRecibidas;
        this.proveedorProductos = proveedorProductos;
        this.responsableIva = responsableIva;
    }

    public Proveedor(String[] datos, String[] direccion) {
        cuit = Integer.parseInt(datos[0]);
        responsableIva = Objects.equals(datos[1].toUpperCase(), "MONOTRIBUTO") ? ResponsableIva.MONOTRIBUTO : ResponsableIva.RESPONSABLE_INSCRIPTO;
        nombreFantasia = datos[2];
        this.direccion = new Direccion(direccion[0],direccion[1],direccion[2],direccion[3],direccion[4],direccion[5]);
        telefono = datos[4];
        correoElectronico = datos[5];
        numeroIngresosBrutos = Double.parseDouble(datos[6]);
        inicioActividades = LocalDateTime.now();
        rubros = new ArrayList<Rubro>();
        certificados = new ArrayList<Certificado>();
        cuentaCorriente = new CuentaCorriente(this,0,new ArrayList<NotaRecibida>(),new ArrayList<Factura>(),new ArrayList<OrdenDePago>());
        proveedorProductos = new ArrayList<ProveedorProducto>();
        notaRecibidas = new ArrayList<NotaRecibida>();
    }

    public Proveedor(String nombre, ResponsableIva responsableIva, int cuit, String telefono, String correo, double ingresosBrutos,
                     String calle, String pais, String provincia, String localidad, int altura, int codigoPostal){

        this.nombreFantasia = nombre;
        this.responsableIva = responsableIva;
        this.cuit = cuit;
        this.telefono = telefono;
        this.correoElectronico = correo;
        this.numeroIngresosBrutos = ingresosBrutos;
        this.direccion = new Direccion(calle, altura, localidad, codigoPostal, provincia, pais);
        inicioActividades = LocalDateTime.now();
        rubros = new ArrayList<Rubro>();
        certificados = new ArrayList<Certificado>();
        cuentaCorriente = new CuentaCorriente(this,0,new ArrayList<NotaRecibida>(),new ArrayList<Factura>(),new ArrayList<OrdenDePago>());
        proveedorProductos = new ArrayList<ProveedorProducto>();
        notaRecibidas = new ArrayList<NotaRecibida>();
    }

    public void AltaCertificado(CertificadoDTO Certificado){
        return;
    }

    public void AltaCertificado(RetencionImpuestos retencionImpuestos){
        ValidarCertificados();

        if (certificados.stream().anyMatch(c -> c.getTipoDeRetencion().equals(retencionImpuestos))){
            JOptionPane.showMessageDialog(null, "El certificado no se puede crear porque ya existe uno valido");
            return;
        }
        certificados.add(new Certificado(retencionImpuestos));
        JOptionPane.showMessageDialog(null, "Certificado Creado Correctamente");

    }

    public void ValidarCertificados(){
        List<Certificado> certificadosList = certificados.stream().filter(c -> c.getVencimiento().isBefore(LocalDate.now())).collect(Collectors.toList());

        if(!certificadosList.isEmpty()) {
            for (Certificado certificado : certificadosList) {
                certificados.remove(certificado);
            }
        }
    }

    public void AltaCuentaCorriente(CuentaCorrienteDTO CuentaCorriente){
        return;
    }

    public void AltaNotaRecibida(NotaRecibidaDTO NotaRecibida){
        return;
    }

    public void AltaProveedorProducto(ProveedorProductoDTO ProveedorProducto){
        return;
    }

    public boolean AltaProveedorProducto(ProductoServicio productoServicio, double precio){
        try{
            ProveedorProducto proveedorProducto = new ProveedorProducto(this,productoServicio,precio);
            if(proveedorProductos.stream().anyMatch(p -> Objects.equals(p.getProductoServicio().getNombre(),proveedorProducto.getProductoServicio().getNombre()))) {
                proveedorProductos.stream().filter(p -> Objects.equals(p.getProductoServicio().getNombre(), proveedorProducto.getProductoServicio().getNombre())).findFirst()
                        .get().setPrecio(precio);
                JOptionPane.showMessageDialog(null,"Precio actualizado.");
                return true;
            }
            proveedorProductos.add(proveedorProducto);
            JOptionPane.showMessageDialog(null,"Proveedor Producto Creado");
            return true;

        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"El Proveedor Producto no pudo ser creado");
            return false;
        }
    }

    public ProveedorProducto getProducto(String productoServicio){
        Optional<ProveedorProducto> productoServicioOptional  = this.proveedorProductos.stream().filter(p ->
                Objects.equals(p.getProductoServicio().getNombre().toLowerCase(),productoServicio.toLowerCase())).findFirst();
        if (productoServicioOptional.isPresent())
            return productoServicioOptional.get();
        else {
            return null;
        }
    }

    public boolean TieneProducto(String productoServicio){
       return this.proveedorProductos.stream().anyMatch(p -> Objects.equals(p.getProductoServicio().getNombre().toLowerCase(), productoServicio.toLowerCase()));
    }

    public int getCuit() {
        return cuit;
    }

    public CuentaCorriente getCuentaCorriente() {
        return cuentaCorriente;
    }

    public List<Certificado> getCertificados() {
        return certificados;
    }


    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public LocalDateTime getInicioActividades() {
        return inicioActividades;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public String getNombre() {
        return nombreFantasia;
    }

    public String getTelefono() {
        return telefono;
    }

    public double getIngresosBrutos() {
        return numeroIngresosBrutos;
    }

    public List<Rubro> getRubros() {
        return rubros;
    }

    public List<NotaRecibida> getNotasRecibidas() {
        return notaRecibidas;
    }

    public List<ProveedorProducto> getProveedorProductos() {
        return proveedorProductos;
    }

    public ResponsableIva getResponsableIva() {
        return responsableIva;
    }

    public void setProveedorCuentaCorriente() {
        this.cuentaCorriente.setProveedor(this);
    }

    public String toString(){
        return "" + cuit;
    }

    public void AgregarRubro(Rubro rubro) {
        rubros.add(rubro);
    }
}