package domain.controllers;

import domain.entities.*;
import domain.entities.documentos.ConsultaLibroIva;
import domain.entities.documentos.Factura;
import domain.entities.documentos.Iva;
import domain.entities.documentos.NotaRecibida;
import domain.entities.documentos.dtos.ConsultaLibroIvaDTO;
import domain.entities.entitiesDtos.ProveedorDTO;
import domain.entities.entitiesDtos.RetencionDTO;
import domain.entities.enumeraciones.TipoDocumento;
import domain.entities.enumeraciones.TipoNota;
import domain.entities.interfaces.DocumentoRecibido;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RetencionController {

    private List<ConsultaLibroIva> librosIva;
    private List<Retencion> retenciones;
    private static RetencionController instancia = null;

    private RetencionController (){
        retenciones = new ArrayList<Retencion>();
        librosIva = new ArrayList<ConsultaLibroIva>();
    }

    public static RetencionController getInstance(){
        if (instancia == null){
            instancia = new RetencionController();
        }
        return instancia;
    }

    public Retencion AltaRetencion(Proveedor proveedor,double total, List<DocumentoRecibido> documentoRecibidos){
        Retencion retencion = new Retencion(proveedor,total, documentoRecibidos);
        retenciones.add(retencion);
        return retencion;
    }

    public String ConsultaLibroIva(int cuitProveedor, DocumentoRecibido documentoRecibido){
        ProveedorController proveedorController = ProveedorController.getInstance();
        ProveedorDTO proveedor = proveedorController.getProveedor(cuitProveedor);

        double monto = documentoRecibido.esFactura() ? ((Factura) documentoRecibido).getIvaTotal() : 0;

         return new ConsultaLibroIvaDTO(proveedor,LocalDate.now(),
                 documentoRecibido.esFactura() ? TipoDocumento.Factura : ((NotaRecibida)documentoRecibido).getNotaDe() == TipoNota.CREDITO ? TipoDocumento.NotaCredito : TipoDocumento.NotaDebito,
                 new Iva(monto),documentoRecibido.getMonto()).Print();
    }

    public double TotalImpuestosRetenidos(){
       return this.retenciones.stream().mapToDouble(r -> r.getTotal()).sum();

    }

    public ConsultaLibroIva BuscarLibroIva(LocalDate fecha, int cuitProveedor){
        Optional<ConsultaLibroIva> optionalConsultaLibroIva = librosIva.stream().filter(consultaLibroIva -> (consultaLibroIva.getCuitProveedor() == cuitProveedor
                && consultaLibroIva.getFecha() == fecha)).findFirst();

        if (!optionalConsultaLibroIva.isPresent())
            return null;

        return optionalConsultaLibroIva.get();
    }
}