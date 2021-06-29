package vistas;

import javax.swing.*;
import java.awt.*;

public class FrmPantallaOtros extends JDialog{

    private JPanel panelPrincipal;
    private JTextField textField1;
    private JButton ingresarButton5;
    private JTextField textField2;
    private JButton ingresarButton4;
    private JTextField textField3;
    private JButton ingresarButton3;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField textField4;
    private JButton ingresarButton2;
    private JButton ingresarButton1;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JTextField textField5;
    private JButton ingresarButton;

    public FrmPantallaOtros(Window owner, String titulo){
        super(owner , titulo);

        this.setContentPane(panelPrincipal);

        this.setSize(1000, 800);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // se libera cuando se cierra

        this.setLocationRelativeTo(null); // Esto inicia la pantalla centrada

        this.setModal(true);


    }
}
