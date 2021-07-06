package vistas;

import javax.swing.*;
import java.awt.*;

public class FrmAltaFactura extends JDialog{
    private JPanel panelPrincipal;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton buscarButtonAltaFactura;
    private JTextField numeroDeCompraField;
    private JTextField cantidadField;
    private JTextField precioPorUnidadField;
    private JTextField nombreItemCompraField;
    private JTextField precioItemCompraField;
    private JTextField descripcionItemCompraField;
    private JTextField ivaItemCompraField;
    private JButton buttonAltaFactura;

    public FrmAltaFactura(Window owner, String titulo) {
        super(owner, titulo);

        this.setContentPane(panelPrincipal);

        this.setSize(600, 525);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // se libera cuando se cierra

        this.setLocationRelativeTo(null); // Esto inicia la pantalla centrada

        this.setModal(true);
    }
}
