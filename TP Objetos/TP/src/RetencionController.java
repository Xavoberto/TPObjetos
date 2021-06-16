import java.time.LocalDate;
import java.util.List;

public class RetencionController {


    private List<ConsultaLibroIva> libroIva;

    private List<Retencion> retencion;

    public void AltaConsultaLibroIva(ConsultaLibroIvaDTO consultaLibroIva){

    }

    public void AltaRetencion(RetencionDTO retencion){



    }

    public ConsultaLibroIvaDTO ConsultaLibroIva(int proveedor, DocumentoRecibido documentoRecibido){

         return;
    }

    public double TotalImpuestosRetenidos(){
        return 0;
    }

    public ConsultaLibroIva BuscarLibroIva(LocalDate fecha, int cuitProveedor){
        return;
    }

    public ConsultaLibroIvaDTO getConsultaLibroIva(){
        return;
    }

    public List<Retencion> getRetencion() {
        return retencion;
    }
}
