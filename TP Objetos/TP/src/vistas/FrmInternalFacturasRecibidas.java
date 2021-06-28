package vistas;

import domain.controllers.FacturaController;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmInternalFacturasRecibidas extends JInternalFrame {

    private JPanel panelPrincipal;
    private JTextField proveedorCuit;
    private JTextField fecha;
    private JButton buscarButton;
    private JTextField salida;

    public FrmInternalFacturasRecibidas(String titulo) {

        super(titulo);

        this.setContentPane(panelPrincipal);

        this.setBorder(null);

        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);

        buscarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                FacturaController facturaController = FacturaController.getInstance();
            }
        });
    }
}
