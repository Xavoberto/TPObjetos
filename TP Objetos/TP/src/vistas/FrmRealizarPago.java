package vistas;

import javax.swing.*;
import java.awt.*;

public class FrmRealizarPago extends JDialog{
    private JPanel panelPrincipal;
    private JComboBox comboCuitProveedorRealizarPago;
    private JButton buttonBuscarRealizarPago;
    private JComboBox comboDocumentosAPagar;
    private JButton buttonAgregarRealizarPago;
    private JComboBox comboTipoDeUnidad;
    private JButton ButtonPagar;

    public FrmRealizarPago(Window owner, String titulo) {
        super(owner, titulo);

        this.setContentPane(panelPrincipal);

        this.setSize(600, 525);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // se libera cuando se cierra

        this.setLocationRelativeTo(null); // Esto inicia la pantalla centrada

        this.setModal(true);
    }
}
