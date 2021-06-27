package vistas;

import javax.swing.*;
import java.awt.*;

public class FrmPantallaConsultasGenerales extends JDialog {

    private JPanel panelPrincipal;
    private JTabbedPane tabbedPane1;
    private JDesktopPane desktopPaneFacturasRecibidas;
    private JDesktopPane desktopPaneCuentaCorriente;
    private JPanel panelOrdenDePago;
    private JDesktopPane desktopPaneOrdenesDePago;

    public FrmPantallaConsultasGenerales(Window owner, String titulo){
        super(owner , titulo);

        this.setContentPane(panelPrincipal);

        this.setSize(1000, 400);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // se libera cuando se cierra

        this.setLocationRelativeTo(null); // Esto inicia la pantalla centrada

        this.setModal(true);


        FrmInternalFacturasRecibidas frameFacturas = new FrmInternalFacturasRecibidas("Facturas");
        frameFacturas.setVisible(true);
        desktopPaneFacturasRecibidas.add(frameFacturas);


        FrmInternalCuentaCorriente frameCuenta = new FrmInternalCuentaCorriente("Consulta Cuenta Corriente");
        frameCuenta.setVisible(true);
        desktopPaneCuentaCorriente.add(frameCuenta);








    }



}
