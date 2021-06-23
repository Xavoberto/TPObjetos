package domain.controllers;

import domain.entities.CuentaCorriente;
import domain.entities.Rubro;
import domain.entities.documentos.OrdenDePago;
import domain.entities.documentos.dtos.OrdenDePagoDTO;
import domain.entities.entitiesDtos.CuentaCorrienteDTO;
import domain.entities.DeudaProveedor;
import domain.entities.Proveedor;
import domain.entities.entitiesDtos.ProveedorDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProveedorController {


    private List<Proveedor> proveedores;
    private static ProveedorController instancia = null;

    private ProveedorController (){

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

