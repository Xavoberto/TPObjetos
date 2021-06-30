package vistas;

import domain.controllers.FacturaController;
import domain.controllers.ProductoServicioController;
import domain.controllers.ProveedorController;
import domain.controllers.RetencionController;
import domain.entities.ProductoServicio;
import domain.entities.Proveedor;
import domain.entities.Rubro;
import domain.entities.enumeraciones.RetencionImpuestos;
import domain.entities.enumeraciones.TipoDeUnidad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.TileObserver;
import java.util.Objects;

public class FrmPantallaOtros extends JDialog{

    private JPanel panelPrincipal;
    private JTextField textField1;
    private JButton ingresarButton5;
    private JTextField textField2;
    private JButton ingresarButton4;
    private JTextField cargarPS;
    private JButton botonIngresarPS;
    private JComboBox proveedorPP;
    private JComboBox productoServicioPP;
    private JTextField precioAcordadoPP;
    private JButton botonIngresarPP;
    private JButton botonAltaCertificado;
    private JComboBox cuitProveedorAC;
    private JComboBox retencionAC;
    private JTextField nombreRubro;
    private JButton ingresarButton;
    private JComboBox rubroAPS;
    private JComboBox tipoDeUnidadAPS;

    public FrmPantallaOtros(Window owner, String titulo){
        super(owner , titulo);

        this.setContentPane(panelPrincipal);

        this.setSize(1200, 800);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // se libera cuando se cierra

        this.setLocationRelativeTo(null); // Esto inicia la pantalla centrada

        this.setModal(true);

        ProductoServicioController productoServicioController = ProductoServicioController.getInstance();
        ProveedorController proveedorController = ProveedorController.getInstance();
        FacturaController facturaController = FacturaController.getInstance();
        RetencionController retencionController = RetencionController.getInstance();


        DefaultComboBoxModel modelorubro = new DefaultComboBoxModel();

        for (Rubro rubro : productoServicioController.getRubros()){
            modelorubro.addElement(rubro);
        }

        rubroAPS.setModel(modelorubro);

        DefaultComboBoxModel modeloTDU = new DefaultComboBoxModel();

        for(TipoDeUnidad tipoDeUnidad  : TipoDeUnidad.values()){
            modeloTDU.addElement(tipoDeUnidad);
        }
        tipoDeUnidadAPS.setModel(modeloTDU);

        DefaultComboBoxModel modeloProveedor = new DefaultComboBoxModel();

        for(Proveedor proveedor : proveedorController.getProveedoresParaPantalla()){
            modeloProveedor.addElement(proveedor);

        }
        proveedorPP.setModel(modeloProveedor);
        cuitProveedorAC.setModel(modeloProveedor);

        DefaultComboBoxModel modeloProductoServ = new DefaultComboBoxModel();

        for(Rubro rubro : productoServicioController.getRubros())
            for(ProductoServicio productoServicio : rubro.getProductoServicios()){
                modeloProductoServ.addElement(productoServicio);
            }

        productoServicioPP.setModel(modeloProductoServ);


        DefaultComboBoxModel modeloRI = new DefaultComboBoxModel();

        for(RetencionImpuestos retencionImpuestos : RetencionImpuestos.values()){
            modeloRI.addElement(retencionImpuestos);
        }
        retencionAC.setModel(modeloRI);

        //----------------------------------Alta Producto Servicio---------------------------------------------

        botonIngresarPS.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               String[] PS = cargarPS.getText().replaceAll("\\s+","").split("\\,");
                Rubro rubro = (Rubro)rubroAPS.getSelectedItem();
                TipoDeUnidad tipoDeUnidad = (TipoDeUnidad)tipoDeUnidadAPS.getSelectedItem();


               productoServicioController.AltaProductoServicio(rubro,tipoDeUnidad,PS);

            }
        });

        //-----------------------------------Alta Proveedor Producto--------------------------------------------

        botonIngresarPP.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                 double precioAcordado = 0;
                try {
                    precioAcordado = Double.parseDouble(precioAcordadoPP.getText());

                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"Ingrese datos validos");
                    return;
                }


                Proveedor proveedor = (Proveedor)proveedorPP.getSelectedItem();
                ProductoServicio productoServicio = (ProductoServicio)productoServicioPP.getSelectedItem();

                proveedorController.AltaProveedorProducto(proveedor, productoServicio, precioAcordado);

            }
        });

        //---------------------------------------Alta Rubro-----------------------------------------------------
        ingresarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {


                String nombre = nombreRubro.getText();
                if (!Objects.equals(nombre, "")) {
                    productoServicioController.AltaRubro(nombre);
                }

            }
        });

        //----------------------------------------Alta Certificado-----------------------------------------------
        botonAltaCertificado.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Proveedor proveedor = (Proveedor) cuitProveedorAC.getSelectedItem();
                RetencionImpuestos retencionImpuestos = (RetencionImpuestos) retencionAC.getSelectedItem();
                proveedorController.AltaCertificado(proveedor, retencionImpuestos);

            }
        });
    }
}
