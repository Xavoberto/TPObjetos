package vistas;

import domain.controllers.ProveedorController;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmInternalCuentaCorriente extends JInternalFrame {

    private JPanel panelPrincipal;
    private JTextField textField1;
    private JButton buscarButton;
    private JTextField textField2;

    public FrmInternalCuentaCorriente(String titulo){

        super(titulo);

        this.setContentPane(panelPrincipal);

        this.setBorder(null);

        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);


        buscarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ProveedorController proveedorController = ProveedorController.getInstance();

                try{
                    textField2.setText(proveedorController.getProveedor(Integer.parseInt(textField1.getText())).getCuentaCorriente().Print());
                }
                catch (Exception ex) {
                    textField2.setText("Cuit no existe");
                }
            }
        });
    }
}
