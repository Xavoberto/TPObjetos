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
    private List<ProveedorProducto> proveedorProducto;
    private List<NotaRecibida> notaRecibida;


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

}

