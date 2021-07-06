package vistas;

import domain.controllers.ProductoServicioController;
import domain.controllers.ProveedorController;
import domain.entities.ProductoServicio;
import domain.entities.Proveedor;
import domain.entities.Rubro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmProveedorProducto extends JDialog{
    private JPanel panelPrincipal;
    private JPanel altaProveedorProducto;
    private JComboBox comboCuitProveedor;
    private JComboBox comboProductoServicio;
    private JTextField precioField;
    private JButton buttonIngresar;

    public FrmProveedorProducto(Window owner, String titulo) {
        super(owner, titulo);

        this.setContentPane(panelPrincipal);

        this.setSize(525, 250);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // se libera cuando se cierra

        this.setLocationRelativeTo(null); // Esto inicia la pantalla centrada

        this.setModal(true);


        ProveedorController proveedorController = ProveedorController.getInstance();
        ProductoServicioController productoServicioController = ProductoServicioController.getInstance();

        DefaultComboBoxModel modeloProveedor = new DefaultComboBoxModel();

        for(Proveedor proveedor : proveedorController.getProveedoresParaPantalla()){
            modeloProveedor.addElement(proveedor);

        }
        comboCuitProveedor.setModel(modeloProveedor);


        DefaultComboBoxModel modeloProductoServ = new DefaultComboBoxModel();

        for(Rubro rubro : productoServicioController.getRubros())
            for(ProductoServicio productoServicio : rubro.getProductoServicios()){
                modeloProductoServ.addElement(productoServicio);
            }

        comboProductoServicio.setModel(modeloProductoServ);


        buttonIngresar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                double precioAcordado = 0;
                try {
                    precioAcordado = Double.parseDouble(precioField.getText());

                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"Ingrese datos validos");
                    return;
                }

                Proveedor proveedor = (Proveedor)comboCuitProveedor.getSelectedItem();
                ProductoServicio productoServicio = (ProductoServicio)comboProductoServicio.getSelectedItem();

                proveedorController.AltaProveedorProducto(proveedor, productoServicio, precioAcordado);

            }
        });
    }
}
