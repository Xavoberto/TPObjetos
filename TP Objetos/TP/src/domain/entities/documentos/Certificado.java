package domain.entities.documentos;

import domain.entities.enumeraciones.RetencionImpuestos;

import java.time.LocalDate;

public class Certificado {
    private RetencionImpuestos tipoDeRetencion;
    private LocalDate vencimiento;

    public Certificado(RetencionImpuestos tipoDeRetencion){
        this.tipoDeRetencion = tipoDeRetencion;
        this.vencimiento = LocalDate.now().plusMonths(1);
    }

    public LocalDate getVencimiento() {
        return vencimiento;
    }

    public RetencionImpuestos getTipoDeRetencion() {
        return tipoDeRetencion;
    }

}