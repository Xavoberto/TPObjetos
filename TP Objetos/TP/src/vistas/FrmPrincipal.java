package vistas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FrmPrincipal extends JFrame {
    private JPanel panelPrincipal;
    private JPanel titulo;
    private JPanel panelMenu;
    private JButton otros;
    private JButton consultasGenerales;
    private FrmPrincipal self;

    public FrmPrincipal(String titulo){
        super(titulo);

        this.setContentPane(panelPrincipal);

        this.setSize(500, 500);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // se libera cuando se cierra

        this.setLocationRelativeTo(null); // Esto inicia la pantalla centrada

        this.asociarEventos();

        this.self = this;

    }

    private void asociarEventos() {

        consultasGenerales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //FrmPantallaConsultasGenerales frame = new FrmPantallaConsultasGenerales(self,"Consultas Generales" );
                FrmConsultas1 frame2 = new FrmConsultas1(self, "Pantalla Consultas 1");
                //frame.setVisible(true);
                frame2.setVisible(true);

            }
        });

        otros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmPantallaAltas frame2 = new FrmPantallaAltas(self, "Pantalla Altas");
                //FrmPantallaOtros frame = new FrmPantallaOtros(self , "Pantalla Otros");
                frame2.setVisible(true);
                //frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        FrmPrincipal frame = new FrmPrincipal("Pantalla SWING");

        frame.setVisible(true);

    }
}
