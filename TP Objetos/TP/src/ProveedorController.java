import java.util.List;

public class ProveedorController {

    private List<Proveedor> proveedores;

    public void AltaProveedor(ProveedorDTO proveedor){
        proveedores.add(new Proveedor(proveedor));
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
        return null;
    }

    //Lista de cuit de proveedor con su respectiva deuda
    public List<DeudaProveedor> TotalDeudaPorProveedor(){
        List<DeudaProveedor> deudores = null;

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
}

