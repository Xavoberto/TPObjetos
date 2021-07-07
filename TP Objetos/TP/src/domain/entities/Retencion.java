package domain.entities;

import domain.entities.documentos.Certificado;
import domain.entities.documentos.Factura;
import domain.entities.entitiesDtos.RetencionDTO;
import domain.entities.enumeraciones.RetencionImpuestos;
import domain.entities.interfaces.DocumentoRecibido;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Retencion {

    private Proveedor proveedor;
    private LocalDate fecha;
    private double total;
    private boolean pagaIva;

    public double getTotal(){
        return total;
    }

    Retencion(RetencionDTO retencionDTO){
        proveedor = retencionDTO.getProveedor();
        fecha = LocalDate.now();
        total = retencionDTO.getTotal();
    }

    public Retencion(Proveedor proveedor, double total, List<DocumentoRecibido> documentoRecibidos){
        this.proveedor = proveedor;
        fecha = LocalDate.now();
        this.total = CalcularRetencion(total,documentoRecibidos);
        pagaIva = true;
    }

    private double CalcularRetencion(double total, List<DocumentoRecibido> documentoRecibidos){
        double retencionAPagar = 0;
        double iva = 0;
        double ivaPagado = 0;

        proveedor.ValidarCertificados();
        List<Certificado> certificados = proveedor.getCertificados();
        List<DocumentoRecibido> facturas = documentoRecibidos.stream().filter(d -> d.esFactura()).collect(Collectors.toList());
        List<Factura> facturaList = new ArrayList<Factura>();

        for(DocumentoRecibido documentoRecibido : facturas){
            facturaList.add((Factura)documentoRecibido);
        }

         ivaPagado = facturaList.stream().mapToDouble(factura -> (factura).getIvaTotal()).sum();

        if(certificados.isEmpty()){
            return (total * (38.5 / 100)) + ivaPagado;
        }
        else {
            if(!proveedor.getCertificados().stream().anyMatch(certificado -> certificado.getTipoDeRetencion() == RetencionImpuestos.IIBB))
                retencionAPagar += 3.5;

            if(!proveedor.getCertificados().stream().anyMatch(certificado -> certificado.getTipoDeRetencion() == RetencionImpuestos.GANANCIAS))
                retencionAPagar += 35;

            if(!proveedor.getCertificados().stream().anyMatch(certificado -> certificado.getTipoDeRetencion() == RetencionImpuestos.IVA))
                iva = ivaPagado;
        }
        return (total * (retencionAPagar / 100)) + iva;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public String toString(){
        return (""+total);
    }
}