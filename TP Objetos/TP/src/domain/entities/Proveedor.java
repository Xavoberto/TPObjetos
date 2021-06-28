package domain.entities;

import domain.entities.documentos.Certificado;
import domain.entities.documentos.OrdenDePago;
import domain.entities.documentos.dtos.CertificadoDTO;
import domain.entities.documentos.NotaRecibida;
import domain.entities.documentos.dtos.NotaRecibidaDTO;
import domain.entities.entitiesDtos.CuentaCorrienteDTO;
import domain.entities.entitiesDtos.ProveedorDTO;
import domain.entities.entitiesDtos.ProveedorProductoDTO;
import domain.entities.enumeraciones.ResponsableIva;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
        cuentaCorriente = proveedor.getCuentaCorriente();
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
                        LocalDateTime inicioActividades, List<Rubro> rubros, List<Certificado> certificados, CuentaCorriente cuentaCorriente,
                        List<ProveedorProducto> proveedorProductos, List<NotaRecibida> notaRecibidas){

        this.certificados = certificados;
        this.correoElectronico = correoElectronico;
        this.cuentaCorriente = cuentaCorriente;
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


    public void AltaCertificado(CertificadoDTO Certificado){
        return;
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

    public ProveedorProducto getProducto(String productoServicio){
        Optional<ProveedorProducto> productoServicioOptional  = this.proveedorProductos.stream().filter(p -> p.getProductoServicio().getNombre() == productoServicio).findFirst();
        if (productoServicioOptional.isPresent())
            return productoServicioOptional.get();
        else {
            return null;
        }
    }

    public boolean TieneProducto(String productoServicio){
       return this.proveedorProductos.stream().anyMatch(p -> p.getProductoServicio().getNombre() == productoServicio);
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

    public void CertificadoVencido(Certificado certificado) {
        certificados.remove(certificado);
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


}

