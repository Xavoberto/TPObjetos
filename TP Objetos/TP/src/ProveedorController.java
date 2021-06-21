import java.util.List;

public class ProveedorController {

    private List<Proveedor> proveedores;

    public void AltaProveedor(ProveedorDTO proveedor){


    }

    public CuentaCorrienteDTO ConsultaCuentaCorriente(int cuitProveedor){
        CuentaCorrienteDTO cuentaCorrienteDTO;

        for (int i=0; i < proveedores.size(); i++) {
            if (proveedores.get(i).getCuit() == cuitProveedor) {
                CuentaCorriente aux = proveedores.get(i).getCuentaCorriente();
                cuentaCorrienteDTO = new CuentaCorrienteDTO(aux.getProveedor(), aux.getDeuda(), aux.getDocumentoRecibido(),
                        aux.getDocumentoImpago(), aux.PagoRealizado());
                return cuentaCorrienteDTO;
            }
        }
        return cuentaCorrienteDTO = null;
    }

    //Lista de cuit de proveedor con su respectiva deuda
    public List<Proveedor> TotalDeudaPorProveedor(int cuitProveedor){
        return;
    }

    public ProveedorDTO getProveedor(int cuitProveedor){
        return;
    }

    public ProveedorDTO getProveedor(Rubro rubro){

        return;
    }
}

