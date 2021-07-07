package vistas;

import domain.controllers.FacturaController;
import domain.controllers.ProductoServicioController;
import domain.controllers.ProveedorController;
import domain.entities.ItemCompra;
import domain.entities.ProductoServicio;
import domain.entities.Proveedor;
import domain.entities.ProveedorProducto;
import domain.entities.documentos.Factura;
import domain.entities.documentos.ProductoFactura;
import domain.entities.interfaces.DocumentoRecibido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class FrmAltaFactura extends JDialog{
    private JPanel panelPrincipal;
    private JComboBox comboCuitProveedor;
    private JComboBox comboProveedorProducto;
    private JButton buscarButtonAltaFactura;
    private JTextField numeroDeCompraField;
    private JTextField cantidadField;
    private JButton buttonAltaFactura;
    private JButton buttonAgregarAltaFactura;

    public FrmAltaFactura(Window owner, String titulo) {
        super(owner, titulo);

        this.setContentPane(panelPrincipal);

        this.setSize(600, 400);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // se libera cuando se cierra

        this.setLocationRelativeTo(null); // Esto inicia la pantalla centrada

        this.setModal(true);


        List<ProveedorProducto> productosCargados = new ArrayList<ProveedorProducto>();
        List<ItemCompra> itemsCompra = new ArrayList<ItemCompra>();
        List<ProductoFactura> productoFacturas = new ArrayList<ProductoFactura>();
        double precioTotal = 0;


        ProveedorController proveedorController = ProveedorController.getInstance();
        FacturaController facturaController = FacturaController.getInstance();
        ProductoServicioController productoServicioController = ProductoServicioController.getInstance();

        DefaultComboBoxModel modeloProveedor = new DefaultComboBoxModel();

        for(Proveedor proveedor : proveedorController.getProveedoresParaPantalla()){
            modeloProveedor.addElement(proveedor);

        }
        comboCuitProveedor.setModel(modeloProveedor);


        //-------------------------------------------------Funcion Buscar todos los Proveedor Producto del proveedor---------------------------------------------------------------------
        buscarButtonAltaFactura.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DefaultComboBoxModel modelPago = new DefaultComboBoxModel();

                for(ProveedorProducto proveedorProducto : ((Proveedor) comboCuitProveedor.getSelectedItem()).getProveedorProductos()){
                    modelPago.addElement(proveedorProducto);
                }
                comboProveedorProducto.setModel(modelPago);
            }
        });


        //--------------------------------------------------------Boton Agregar Producto Servicio-----------------------------------------------------------
        buttonAgregarAltaFactura.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int cantidad = Integer.parseInt(cantidadField.getText());

                ProveedorProducto producto = (ProveedorProducto) comboProveedorProducto.getSelectedItem();
                productosCargados.add((ProveedorProducto) producto);

                double precioItemCompra = producto.getPrecio();
                double precioTotal =+ producto.getPrecio() * cantidad;


                itemsCompra.add(new ItemCompra(producto, cantidad, precioItemCompra));


                JOptionPane.showMessageDialog(null, "Producto Agregado Correctamente");

                    }

        });

        buttonAltaFactura.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int nroCompra = Integer.parseInt(numeroDeCompraField.getText());
                Proveedor proveedor = (Proveedor) comboCuitProveedor.getSelectedItem();
                for (ProveedorProducto proveedorProductoFactura : productosCargados){
                    productoFacturas.add(new ProductoFactura(new ProductoServicio(proveedorProductoFactura.getProductoServicio())));
                }

                facturaController.AltaFactura(proveedor,nroCompra, itemsCompra, precioTotal, productoFacturas);
            }
        });

    }
}