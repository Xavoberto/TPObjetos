import domain.controllers.ProveedorController;
import domain.entities.*;
import domain.entities.documentos.Certificado;
import domain.entities.documentos.NotaRecibida;
import domain.entities.documentos.OrdenDePago;
import domain.entities.documentos.dtos.OrdenDePagoDTO;
import domain.entities.entitiesDtos.ProveedorDTO;
import domain.entities.enumeraciones.ResponsableIva;

import java.time.LocalDateTime;
import java.util.List;

public class test {
    public void OrdenesDePagoEmitidas() {

        ProveedorController proveedorController = ProveedorController.getInstance();

        proveedorController.AltaProveedor(new ProveedorDTO(123, ResponsableIva.MONOTRIBUTO, "asd", new Direccion(),"2312313", "p",
        12312.32,LocalDateTime.now(), null, null, null, null, null));


        List<OrdenDePago> ordenDePagoList = null;

        ordenDePagoList.addAll(proveedorController.getProveedor(123).getCuentaCorriente().getPagosRealizados());

        System.out.println(ordenDePagoList.stream().findFirst().get().getTotal());
    }
}
