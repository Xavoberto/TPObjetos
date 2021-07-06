package vistas;

import javax.swing.*;
import java.awt.*;

public class FrmConsultas2 extends JDialog{
    private JPanel panelPrincipal;
    private JComboBox comboCuitProveedorBuscarFactura;
    private JTextField fechaBuscarFacturaField;
    private JButton buttonBuscarFacturas;
    private JComboBox comboRubroConsultaDePrecios;
    private JTextField productoServicioConsultaDePreciosField;
    private JButton buttonConsultaDePrecios;
    private JComboBox comboCuitProveedorConsultaLibroIva;
    private JComboBox comboDocumentoConsultaLibroIva;
    private JButton buttonBuscarDocumentosConsultaLibroIva;
    private JButton buttonConsultaLibroIva;

    public FrmConsultas2(Window owner, String titulo) {
        super(owner, titulo);

        this.setContentPane(panelPrincipal);

        this.setSize(600, 525);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // se libera cuando se cierra

        this.setLocationRelativeTo(null); // Esto inicia la pantalla centrada

        this.setModal(true);
    }
}
