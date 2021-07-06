package vistas;

import domain.controllers.ProveedorController;
import domain.entities.Proveedor;
import domain.entities.documentos.Factura;
import domain.entities.enumeraciones.FormaDePago;
import domain.entities.interfaces.DocumentoRecibido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class FrmRealizarPago extends JDialog{
    private JPanel panelPrincipal;
    private JComboBox comboCuitProveedorRealizarPago;
    private JButton buttonBuscarRealizarPago;
    private JComboBox comboDocumentosAPagar;
    private JButton buttonAgregarRealizarPago;
    private JComboBox comboFormaDePago;
    private JButton buttonPagar;

    List<DocumentoRecibido> documentoRecibidos = new ArrayList<DocumentoRecibido>();

    public FrmRealizarPago(Window owner, String titulo) {
        super(owner, titulo);

        this.setContentPane(panelPrincipal);

        this.setSize(600, 400);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // se libera cuando se cierra

        this.setLocationRelativeTo(null); // Esto inicia la pantalla centrada

        this.setModal(true);

        ProveedorController proveedorController = ProveedorController.getInstance();

        DefaultComboBoxModel modeloProveedor = new DefaultComboBoxModel();

        for(Proveedor proveedor : proveedorController.getProveedoresParaPantalla()){
            modeloProveedor.addElement(proveedor);

        }
        comboCuitProveedorRealizarPago.setModel(modeloProveedor);

        DefaultComboBoxModel modeloFormaDePago = new DefaultComboBoxModel();

        for(FormaDePago formaDePago : FormaDePago.values()){
            modeloFormaDePago.addElement(formaDePago);

        }
        comboFormaDePago.setModel(modeloFormaDePago);


        buttonBuscarRealizarPago.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DefaultComboBoxModel modelPago = new DefaultComboBoxModel();

                for(Factura documentoRecibido : ((Proveedor) comboCuitProveedorRealizarPago.getSelectedItem()).getCuentaCorriente().getDocumentoImpago()){
                    modelPago.addElement(documentoRecibido);
                }
                comboDocumentosAPagar.setModel(modelPago);
            }
        });

        buttonAgregarRealizarPago.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                documentoRecibidos.add((Factura) comboDocumentosAPagar.getSelectedItem());
                JOptionPane.showMessageDialog(null,"Documento Agregado");
            }
        });

        buttonPagar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                FormaDePago formaDePago = (FormaDePago) comboFormaDePago.getSelectedItem();

                proveedorController.RealizarPago(((Proveedor) comboCuitProveedorRealizarPago.getSelectedItem()),documentoRecibidos,formaDePago);

                documentoRecibidos.clear();
            }
        });
    }
}
