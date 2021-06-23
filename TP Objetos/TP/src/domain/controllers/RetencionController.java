package domain.controllers;

import domain.entities.*;
import domain.entities.documentos.ConsultaLibroIva;
import domain.entities.documentos.dtos.ConsultaLibroIvaDTO;
import domain.entities.entitiesDtos.RetencionDTO;
import domain.entities.interfaces.DocumentoRecibido;

import java.time.LocalDate;
import java.util.List;

public class RetencionController {

    private List<ConsultaLibroIva> libroIva;
    private List<Retencion> retencion;
    private static RetencionController instancia = null;

    private RetencionController (){

    }

    public static RetencionController getInstance(){
        if (instancia == null){
            instancia = new RetencionController();
        }
        return instancia;
    }

    public void AltaRetencion(RetencionDTO retencion){

    }

    public ConsultaLibroIvaDTO ConsultaLibroIva(int proveedor, DocumentoRecibido documentoRecibido){

         return null;
    }

    public double TotalImpuestosRetenidos(){
        return 0;
    }

    public ConsultaLibroIva BuscarLibroIva(LocalDate fecha, int cuitProveedor){
        return null;
    }

    public List<Retencion> getRetencion() {
        return retencion;
    }
}