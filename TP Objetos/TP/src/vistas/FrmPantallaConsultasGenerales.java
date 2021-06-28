package vistas;

import javax.swing.*;
import java.awt.*;

public class FrmPantallaConsultasGenerales extends JDialog {

    private JPanel panelPrincipal;
    private JTextField cuitProveedorFR;
    private JButton BotonFR;
    private JComboBox rubroCDP;
    private JTextField productoServicioCDP;
    private JButton botonCDP;
    private JTextField cuitProveedorCC;
    private JButton botonCC;
    private JButton BotonODP;
    private JComboBox documentoCLI;
    private JButton botonCLI;
    private JTextField cuitProveedorCLI;
    private JButton botonDPP;
    private JButton botonTDR;
    private JTextField fechaFR;

    public FrmPantallaConsultasGenerales(Window owner, String titulo){
        super(owner , titulo);

        this.setContentPane(panelPrincipal);

        this.setSize(1000, 400);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // se libera cuando se cierra

        this.setLocationRelativeTo(null); // Esto inicia la pantalla centrada

        this.setModal(true);






    }



}
