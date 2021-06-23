package domain.entities;

import domain.entities.documentos.Certificado;
import domain.entities.documentos.dtos.CertificadoDTO;
import domain.entities.documentos.NotaRecibida;
import domain.entities.documentos.dtos.NotaRecibidaDTO;
import domain.entities.entitiesDtos.CuentaCorrienteDTO;
import domain.entities.entitiesDtos.ProveedorDTO;
import domain.entities.entitiesDtos.ProveedorProductoDTO;
import domain.entities.enumeraciones.ResponsableIva;

import java.time.LocalDateTime;
import java.util.List;

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

    public boolean BuscarProducto(ProductoServicio productoServicio){
        return false;
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
}

