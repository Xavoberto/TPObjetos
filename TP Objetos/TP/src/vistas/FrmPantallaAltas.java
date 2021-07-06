package vistas;

import javax.swing.*;
import java.awt.*;

public class FrmPantallaAltas extends JDialog{
    private JButton altaProveedorButton;
    private JPanel panelPrincipal;
    private JButton altaFacturaButton;
    private JButton altaProductoServicioButton;
    private JButton altaProveedorProductoButton;
    private JButton altaCertificadoButton;
    private JButton altaRubroButton;
    private JButton realizarPagoButton;

    public FrmPantallaAltas(Window owner, String titulo) {
        super(owner, titulo);

        this.setContentPane(panelPrincipal);

        this.setSize(400, 600);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // se libera cuando se cierra

        this.setLocationRelativeTo(null); // Esto inicia la pantalla centrada

        this.setModal(true);
    }
}
