package vistas;

import domain.controllers.ProveedorController;
import domain.controllers.RetencionController;
import domain.entities.CuentaCorriente;
import domain.entities.Proveedor;
import domain.entities.entitiesDtos.CuentaCorrienteDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmConsultas1 extends JDialog {
    private JPanel panelPrincipal;
    private JComboBox comboCuitProveedor;
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

        ProveedorController proveedorController = ProveedorController.getInstance();


        DefaultComboBoxModel modeloProveedor = new DefaultComboBoxModel();

        for(Proveedor proveedor : proveedorController.getProveedoresParaPantalla()){
            modeloProveedor.addElement(proveedor);

        }
        comboCuitProveedor.setModel(modeloProveedor);

    }

    private void asociarEventos() {
        RetencionController retencionController = RetencionController.getInstance();
        ProveedorController proveedorController = ProveedorController.getInstance();
        botonMasConsultas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                FrmConsultas2 frame= new FrmConsultas2(self, "Pantalla Consultas 2");
                frame.setVisible(true);
            }
        });



        //---------------------------------CUENTA CORRIENTE--------------------------------------------------------
        buttonConsultaCuentaCorriente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Proveedor proveedor = (Proveedor)comboCuitProveedor.getSelectedItem();
                CuentaCorrienteDTO cuentaCorrienteDTO = proveedorController.ConsultaCuentaCorriente(proveedor.getCuit());
                JOptionPane.showMessageDialog(null, cuentaCorrienteDTO.Print());
            }
        });

        //---------------------------------ORDENES DE PAGO--------------------------------------------------------
        buttonEmitirOrdenesDePago.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null,proveedorController.OrdenesDePagoEmitidas());
            }
        });

        //---------------------------------DEUDA POR PROVEEDOR--------------------------------------------------------
        ButtonDeudaPorProveedor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, proveedorController.TotalDeudaPorProveedor());
            }
        });

        //---------------------------------IMPUESTOS RETENIDOS  --------------------------------------------------------
        buttonImpuestosRetenidos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, retencionController.TotalImpuestosRetenidos());
            }
        });
    }

}

