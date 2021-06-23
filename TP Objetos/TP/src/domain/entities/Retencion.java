package domain.entities;

import domain.entities.documentos.Certificado;
import domain.entities.documentos.Factura;
import domain.entities.entitiesDtos.RetencionDTO;
import domain.entities.enumeraciones.RetencionImpuestos;
import domain.entities.interfaces.DocumentoRecibido;

import java.time.LocalDate;
import java.util.List;

public class Retencion {

    private Proveedor proveedor;
    private LocalDate fecha;
    private double total;
    private boolean pagaIva;

    public double getTotal(){
        return total;
    }

    private double CalcularRetencion(double total, List<DocumentoRecibido> documentoRecibidos){
        double retencionAPagar = 0;
        double iva = 0;

        List<Certificado> certificados = proveedor.getCertificados();

        if(certificados.isEmpty()){

        }
        else {
            for (Certificado certificado : certificados) {
                if(LocalDate.now().isBefore(certificado.getVencimiento())){
                    proveedor.CertificadoVencido(certificado);
                }
                else{
                    RetencionImpuestos tipo = certificado.getTipoDeRetencion();

                    switch(tipo) {
                        case IVA:
                            pagaIva = false;
                            break;
                        case IIBB:
                            retencionAPagar += 3.5;
                            break;
                        default:
                            retencionAPagar += 35;
                    }
                }
            }
            if(pagaIva) {
                for (DocumentoRecibido documento : documentoRecibidos) {
                    if (documento.esFactura()) {
                        iva += ((Factura) documento).getIvaTotal();
                    }
                }
            }
        }
        return (total * (retencionAPagar / 100)) + iva;
    }

    Retencion(RetencionDTO retencionDTO){
        proveedor = retencionDTO.getProveedor();
        fecha = LocalDate.now();
        total = retencionDTO.getTotal();
    }

    Retencion(Proveedor proveedor,double total, List<DocumentoRecibido> documentoRecibidos){
        this.proveedor = proveedor;
        fecha = LocalDate.now();
        this.total = CalcularRetencion(total,documentoRecibidos);
        pagaIva = true;
    }
}