package vistas;

import domain.controllers.ProductoServicioController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmPantallaOtros extends JDialog{

    private JPanel panelPrincipal;
    private JTextField textField1;
    private JButton ingresarButton5;
    private JTextField textField2;
    private JButton ingresarButton4;
    private JTextField cargarPS;
    private JButton botonIngresarPS;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField textField4;
    private JButton ingresarButton2;
    private JButton ingresarButton1;
    private JComboBox cuitProveedorAC;
    private JComboBox retencionAC;
    private JTextField textField5;
    private JButton ingresarButton;
    private JComboBox rubroAPS;

    public FrmPantallaOtros(Window owner, String titulo){
        super(owner , titulo);

        this.setContentPane(panelPrincipal);

        this.setSize(1000, 800);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // se libera cuando se cierra

        this.setLocationRelativeTo(null); // Esto inicia la pantalla centrada

        this.setModal(true);

        ProductoServicioController productoServicioController = ProductoServicioController.getInstance();


        botonIngresarPS.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               String[] PS = cargarPS.getText().replaceAll("\s+","").split("\\,");

               productoServicioController.AltaProductoServicio(rubroAPS,PS);

            }
        });
    }
}
