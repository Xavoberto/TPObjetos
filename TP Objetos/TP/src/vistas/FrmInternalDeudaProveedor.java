package vistas;

import domain.controllers.ProveedorController;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmInternalDeudaProveedor extends JInternalFrame {
    private JPanel panelPrincipal;
    private JTextField ingresoCuit;
    private JTextField salida;
    private JButton botonBuscar;

    public FrmInternalDeudaProveedor(String titulo) {

        super(titulo);

        this.setContentPane(panelPrincipal);

        this.setBorder(null);

        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);


        botonBuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ProveedorController proveedorController = ProveedorController.getInstance();

                try {
                    salida.setText(proveedorController.getProveedor(Integer.parseInt(ingresoCuit.getText())).getCuentaCorriente().Print());
                }
                catch (Exception ex){
                    salida.setText("El cuit ingresado no existe");
                }
            }
        });
    }
}
