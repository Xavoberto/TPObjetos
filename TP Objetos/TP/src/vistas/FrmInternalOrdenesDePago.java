package vistas;

import domain.controllers.FacturaController;

import javax.swing.*;

public class FrmInternalOrdenesDePago extends JInternalFrame {
    private JPanel panelPrincipal;
    private JButton buscarButton;

    public FrmInternalOrdenesDePago(String titulo) {

        super(titulo);

        this.setContentPane(panelPrincipal);

        this.setBorder(null);

        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);


    }

    public void ConsultarOrdenesDeCompra(){
        FacturaController facturaController = FacturaController.getInstance();

        facturaController.getOrdenesDeCompra();
    }
}
