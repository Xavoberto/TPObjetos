package vistas;

import javax.swing.*;
import java.awt.*;

public class FrmPantallaOtros extends JDialog{

    private JPanel panelPrincipal;
    private JTextField proveedorField;
    private JButton proveedorButton;
    private JTextField facturaField;
    private JButton facturaButton;

    public FrmPantallaOtros(Window owner, String titulo){
        super(owner , titulo);

        this.setContentPane(panelPrincipal);

        this.setSize(1000, 400);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // se libera cuando se cierra

        this.setLocationRelativeTo(null); // Esto inicia la pantalla centrada

        this.setModal(true);


    }
}
