package vistas;

import javax.swing.*;
import java.awt.*;

public class FrmInternalFacturasRecibidas extends JInternalFrame{

    private JPanel panelPrincipal;
    private JTextField proveedor;
    private JTextField fecha;
    private JButton buscarButton;

    public FrmInternalFacturasRecibidas(String titulo){

        super(titulo);

        this.setContentPane(panelPrincipal);

        this.setBorder(null);

        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);

    }

    //public void
}
