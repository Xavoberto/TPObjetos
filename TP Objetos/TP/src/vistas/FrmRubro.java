package vistas;

import domain.controllers.ProductoServicioController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

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


        ProductoServicioController productoServicioController = ProductoServicioController.getInstance();


        ingresarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String nombre = nombreField.getText();
                if (!Objects.equals(nombre, "")) {
                    productoServicioController.AltaRubro(nombre);
                }

            }
        });
    }




}
