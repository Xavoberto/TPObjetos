import java.time.LocalDate;
import java.util.List;

public class ProveedorDTO {
    private int cuit;
    private ResponsableIva responsableIva;
    private String nombreFantasia;
    private Direccion direccion;
    private String telefono;
    private String correoElectronico;
    private double numeroIngresosBrutos;
    private LocalDate inicioActividades;
    private List<Rubro> rubros;
    private List<Certificado> certificados;
    private CuentaCorriente cuentaCorriente;
    private List<ProveedorProducto> proveedorProductos;
    private List<NotaRecibida> notaRecibidas;

    ProveedorDTO(int cuit, ResponsableIva responsableIva,String nombreFantasia,Direccion direccion,String telefono, String correoElectronico,double numeroIngresosBrutos,
                 LocalDate inicioActividades,List<Rubro> rubros,List<Certificado> certificados,CuentaCorriente cuentaCorriente,
                 List<ProveedorProducto> proveedorProductos,List<NotaRecibida> notaRecibidas){

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
}
