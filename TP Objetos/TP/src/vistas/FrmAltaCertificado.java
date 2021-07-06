package vistas;

import javax.swing.*;
import java.awt.*;

public class FrmAltaCertificado extends JDialog{
    private JPanel panelPrincipal;
    private JComboBox comboCuitProveedorCertificado;
    private JComboBox comboRetencionCertificado;
    private JButton buttonAltaCertificado;

    public FrmAltaCertificado(Window owner, String titulo) {
        super(owner, titulo);

        this.setContentPane(panelPrincipal);

        this.setSize(600, 525);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // se libera cuando se cierra

        this.setLocationRelativeTo(null); // Esto inicia la pantalla centrada

        this.setModal(true);
    }
}
