package vistas;

import javax.swing.*;
import java.awt.*;

public class FrmRubro extends JDialog{
    private JPanel panelPrincipal;
    private JPanel altaRubro;
    private JTextField nombreField;
    private JButton ingresarButton;


    public FrmRubro(Window owner, String titulo) {
        super(owner, titulo);

        this.setContentPane(panelPrincipal);

        this.setSize(500, 200);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // se libera cuando se cierra

        this.setLocationRelativeTo(null); // Esto inicia la pantalla centrada

        this.setModal(true);
    }

}
