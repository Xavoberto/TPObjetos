import java.time.LocalDate;

public class CertificadoDTO {
    private RetencionImpuestos tipoDeRetencion;
    private LocalDate vencimiento;

    CertificadoDTO(RetencionImpuestos retencion, LocalDate fecha){
        tipoDeRetencion = retencion;
        fecha = vencimiento;
    }
}
