package vistas;

import javax.swing.*;

public class FrmInternalCuentaCorriente extends JInternalFrame {

    private JPanel panelPrincipal;
    private JTextField textField1;
    private JButton buscarButton;

    public FrmInternalCuentaCorriente(String titulo){

        super(titulo);

        this.setContentPane(panelPrincipal);

        this.setBorder(null);

        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);







    }
}
