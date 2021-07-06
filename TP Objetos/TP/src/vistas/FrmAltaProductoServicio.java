package vistas;

import domain.controllers.ProductoServicioController;
import domain.entities.Rubro;
import domain.entities.enumeraciones.TipoDeUnidad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmAltaProductoServicio extends JDialog{
    private JPanel panelPrincipal;
    private JComboBox comboRubro;
    private JComboBox comboTipoDeUnidad;
    private JTextField nombreField;
    private JTextField precioField;
    private JTextField descripcionField;
    private JTextField IvaField;
    private JButton buttonAltaProductoServicio;


    public FrmAltaProductoServicio(Window owner, String titulo) {
        super(owner, titulo);

        this.setContentPane(panelPrincipal);

        this.setSize(600, 350);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // se libera cuando se cierra

        this.setLocationRelativeTo(null); // Esto inicia la pantalla centrada

        this.setModal(true);

        ProductoServicioController productoServicioController = ProductoServicioController.getInstance();


        DefaultComboBoxModel modelorubro = new DefaultComboBoxModel();

        for (Rubro rubro : productoServicioController.getRubros()){
            modelorubro.addElement(rubro);
        }
        comboRubro.setModel(modelorubro);

        DefaultComboBoxModel modeloTDU = new DefaultComboBoxModel();

        for(TipoDeUnidad tipoDeUnidad  : TipoDeUnidad.values()){
            modeloTDU.addElement(tipoDeUnidad);
        }
        comboTipoDeUnidad.setModel(modeloTDU);


        buttonAltaProductoServicio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String nombre = nombreField.getText();
                double precio = Double.parseDouble(precioField.getText());
                String descripcion = descripcionField.getText();
                double iva = Double.parseDouble(IvaField.getText());
                Rubro rubro = (Rubro)comboRubro.getSelectedItem();
                TipoDeUnidad tipoDeUnidad = (TipoDeUnidad)comboTipoDeUnidad.getSelectedItem();

                productoServicioController.AltaProductoServicio(rubro,tipoDeUnidad,nombre, precio, descripcion,iva);
            }
        });
    }
}
