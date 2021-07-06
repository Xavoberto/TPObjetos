package vistas;

import domain.controllers.ProveedorController;
import domain.entities.Proveedor;
import domain.entities.enumeraciones.RetencionImpuestos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmAltaCertificado extends JDialog{
    private JPanel panelPrincipal;
    private JComboBox comboCuitProveedorCertificado;
    private JComboBox comboRetencionCertificado;
    private JButton buttonAltaCertificado;

    public FrmAltaCertificado(Window owner, String titulo) {
        super(owner, titulo);

        this.setContentPane(panelPrincipal);

        this.setSize(600, 200);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // se libera cuando se cierra

        this.setLocationRelativeTo(null); // Esto inicia la pantalla centrada

        this.setModal(true);

        ProveedorController proveedorController = ProveedorController.getInstance();

        DefaultComboBoxModel modeloProveedor = new DefaultComboBoxModel();

        for(Proveedor proveedor : proveedorController.getProveedoresParaPantalla()){
            modeloProveedor.addElement(proveedor);

        }
        comboCuitProveedorCertificado.setModel(modeloProveedor);

        DefaultComboBoxModel modeloRI = new DefaultComboBoxModel();

        for(RetencionImpuestos retencionImpuestos : RetencionImpuestos.values()){
            modeloRI.addElement(retencionImpuestos);
        }
        comboRetencionCertificado.setModel(modeloRI);


        buttonAltaCertificado.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Proveedor proveedor = (Proveedor) comboCuitProveedorCertificado.getSelectedItem();
                RetencionImpuestos retencionImpuestos = (RetencionImpuestos) comboRetencionCertificado.getSelectedItem();
                proveedorController.AltaCertificado(proveedor, retencionImpuestos);

            }
        });
    }
}
