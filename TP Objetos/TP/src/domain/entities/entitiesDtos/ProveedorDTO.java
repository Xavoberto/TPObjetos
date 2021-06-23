package domain.entities.entitiesDtos;

import domain.entities.*;
import domain.entities.documentos.Certificado;
import domain.entities.documentos.NotaRecibida;
import domain.entities.enumeraciones.ResponsableIva;

import java.time.LocalDateTime;
import java.util.List;

public class ProveedorDTO{
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

    public ProveedorDTO(int cuit, ResponsableIva responsableIva, String nombreFantasia, Direccion direccion, String telefono, String correoElectronico, double numeroIngresosBrutos,
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
    public ProveedorDTO(Proveedor proveedor){
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
}
