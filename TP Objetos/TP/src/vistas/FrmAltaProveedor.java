package vistas;

import javax.swing.*;
import java.awt.*;

public class FrmAltaProveedor extends JDialog{
    private JPanel panelPrincipal;
    private JPanel altaPanel;
    private JTextField cuitField;
    private JTextField nombreField;
    private JTextField ingresosBField;
    private JTextField telefonoField;
    private JTextField correoField;
    private JComboBox comboRIVA;
    private JTextField calleField;
    private JTextField paisField;
    private JTextField alturaField;
    private JTextField provinciaField;
    private JTextField codigoPostalField;
    private JTextField localidadField;
    private JButton buttonAltaProveedor;

    public FrmAltaProveedor(Window owner, String titulo) {
        super(owner, titulo);

        this.setContentPane(panelPrincipal);

        this.setSize(600, 525);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // se libera cuando se cierra

        this.setLocationRelativeTo(null); // Esto inicia la pantalla centrada

        this.setModal(true);
    }


}
