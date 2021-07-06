package vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmConsultas1 extends JDialog {
    private JPanel panelPrincipal;
    private JComboBox comboBox1;
    private JButton buttonConsultaCuentaCorriente;
    private JButton buttonEmitirOrdenesDePago;
    private JButton ButtonDeudaPorProveedor;
    private JButton buttonImpuestosRetenidos;
    private JButton botonMasConsultas;
    private FrmConsultas1 self;

    public FrmConsultas1(Window owner, String titulo) {
        super(owner, titulo);

        this.setContentPane(panelPrincipal);

        this.setSize(600, 525);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // se libera cuando se cierra

        this.setLocationRelativeTo(null); // Esto inicia la pantalla centrada

        this.setModal(true);

        this.asociarEventos();

        this.self = this;

    }

    private void asociarEventos() {
        botonMasConsultas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                FrmConsultas2 frame= new FrmConsultas2(self, "Pantalla Consultas 2");
                frame.setVisible(true);
            }
        });



    }

}

