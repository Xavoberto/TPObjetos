package vistas;

import domain.controllers.FacturaController;
import domain.controllers.ProductoServicioController;
import domain.controllers.ProveedorController;
import domain.controllers.RetencionController;
import domain.entities.ProductoServicio;
import domain.entities.Proveedor;
import domain.entities.Rubro;
import domain.entities.documentos.Factura;
import domain.entities.documentos.ProveedorPrecio;
import domain.entities.interfaces.DocumentoRecibido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FrmConsultas2 extends JDialog{
    private JPanel panelPrincipal;
    private JTextField fechaBuscarFacturaField;
    private JButton buttonBuscarFacturas;
    private JComboBox comboRubroConsultaDePrecios;
    private JButton buttonConsultaDePrecios;
    private JComboBox comboCuitProveedorConsultaLibroIva;
    private JComboBox comboDocumentoConsultaLibroIva;
    private JButton buttonBuscarDocumentosConsultaLibroIva;
    private JButton buttonConsultaLibroIva;
    private JComboBox comboProductoServicio;
    private JTextField cuitProveedorField;

    public FrmConsultas2(Window owner, String titulo) {
        super(owner, titulo);

        this.setContentPane(panelPrincipal);

        this.setSize(600, 470);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // se libera cuando se cierra

        this.setLocationRelativeTo(null); // Esto inicia la pantalla centrada

        this.setModal(true);

        //INSTANCIAS
        ProveedorController proveedorController = ProveedorController.getInstance();
        ProductoServicioController productoServicio = ProductoServicioController.getInstance();
        FacturaController facturaController = FacturaController.getInstance();
        RetencionController retencionController = RetencionController.getInstance();

        //COMBO BOX

        DefaultComboBoxModel model = new DefaultComboBoxModel();

        for (Rubro rubro : productoServicio.getRubros()){
            model.addElement(rubro);
        }

        comboRubroConsultaDePrecios.setModel(model);

        DefaultComboBoxModel modeloProductoServ = new DefaultComboBoxModel();

        for(Rubro rubro : productoServicio.getRubros())
            for(ProductoServicio productoServicioCombo : rubro.getProductoServicios()){
                modeloProductoServ.addElement(productoServicioCombo);
            }

        comboProductoServicio.setModel(modeloProductoServ);


        DefaultComboBoxModel modeloProvedor = new DefaultComboBoxModel();
        for (Proveedor proveedor : proveedorController.getProveedoresParaPantalla()) {
            modeloProvedor.addElement(proveedor);
        }
        comboCuitProveedorConsultaLibroIva.setModel(modeloProvedor);


            //ACCIONES DE LOS BOTONES

        //--------------------------------- CONSULTA DE PRECIOS------------------------------------------------------------------
        buttonConsultaDePrecios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                List<ProveedorPrecio> proveedorPrecioList = new ArrayList<ProveedorPrecio>();
                Rubro rubro = (Rubro)comboRubroConsultaDePrecios.getSelectedItem();
                ProductoServicio productoServicio = (ProductoServicio)comboProductoServicio.getSelectedItem();

                proveedorPrecioList = proveedorController.ConsultaDePrecios(rubro, productoServicio.getNombre());
                String respuesta = "";

                if (!proveedorPrecioList.isEmpty()){
                    for (ProveedorPrecio proveedorPrecio : proveedorPrecioList){
                        respuesta += proveedorPrecio.Print() + "    \n   ";

                    }
                }
                else
                    respuesta = "El producto indicado no existe";

                JOptionPane.showMessageDialog(null, respuesta);
            }
        });

        //--------------------------------------- FACTURAS RECIBIDAS----------------------------------------------------------------
        buttonBuscarFacturas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                double totalAImprimir = 0;
                boolean cuitEntered = false;
                boolean dateEntered = false;
                int cuitProveedor = 0;
                LocalDate fecha = LocalDate.now();

                try{
                    cuitProveedor = Integer.parseInt(cuitProveedorField.getText());
                    cuitEntered = true;
                }
                catch (Exception ex){
                    cuitEntered = false;
                }
                try{
                    fecha = LocalDate.parse(fechaBuscarFacturaField.getText());
                    dateEntered = true;
                }
                catch (Exception ex){
                    dateEntered = false;
                }
                if(!cuitEntered && !dateEntered)
                    return;

                if(cuitEntered && dateEntered){
                    totalAImprimir = facturaController.TotalDeFacturas(fecha, cuitProveedor);
                }
                else{
                    if(dateEntered){
                        totalAImprimir = facturaController.TotalDeFacturas(fecha);
                    }
                    if(cuitEntered){
                        totalAImprimir = facturaController.TotalDeFacturas(cuitProveedor);
                    }
                }
                try {
                    JOptionPane.showMessageDialog(null, String.valueOf(totalAImprimir));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"Cuit no existe");
                }
            }
        });

        //---------------------------------CONSULTA LIBRO IVA--------------------------------------------------------
        buttonBuscarDocumentosConsultaLibroIva.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Proveedor proveedor = (Proveedor)comboCuitProveedorConsultaLibroIva.getSelectedItem();
                List<Factura> documentoRecibidos = proveedorController.DocumentosConsultaLibroIva(proveedor.getCuit());

                DefaultComboBoxModel model = new DefaultComboBoxModel();

                for (DocumentoRecibido documentoRecibido : documentoRecibidos){
                    model.addElement(documentoRecibido);
                }

                comboDocumentoConsultaLibroIva.setModel(model);

            }
        });


        buttonConsultaLibroIva.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Proveedor proveedor = (Proveedor)comboCuitProveedorConsultaLibroIva.getSelectedItem();
                JOptionPane.showMessageDialog(null, retencionController.ConsultaLibroIva(proveedor.getCuit(),
                        (DocumentoRecibido)comboDocumentoConsultaLibroIva.getSelectedItem()));
            }
        });
    }


}
