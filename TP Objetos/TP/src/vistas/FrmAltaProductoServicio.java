package vistas;

import javax.swing.*;
import java.awt.*;

public class FrmAltaProductoServicio extends JDialog{
    private JPanel panelPrincipal;
    private JComboBox comboRubro;
    private JComboBox comboTipoDeUnidad;
    private JTextField nombreField;
    private JTextField precioField;
    private JTextField descripcionField;
    private JTextField IvaField;
    private JButton buttonAltaProductoServicio;


    public FrmAltaProductoServicio(Window owner, String titulo) {
        super(owner, titulo);

        this.setContentPane(panelPrincipal);

        this.setSize(600, 525);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // se libera cuando se cierra

        this.setLocationRelativeTo(null); // Esto inicia la pantalla centrada

        this.setModal(true);
    }
}
