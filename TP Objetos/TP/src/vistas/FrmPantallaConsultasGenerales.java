package vistas;

import domain.controllers.FacturaController;
import domain.controllers.ProductoServicioController;
import domain.controllers.ProveedorController;
import domain.controllers.RetencionController;
import domain.entities.Proveedor;
import domain.entities.Rubro;
import domain.entities.documentos.Factura;
import domain.entities.documentos.ProveedorPrecio;
import domain.entities.entitiesDtos.CuentaCorrienteDTO;
import domain.entities.entitiesDtos.ProveedorDTO;
import domain.entities.interfaces.DocumentoRecibido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FrmPantallaConsultasGenerales extends JDialog {

    private JPanel panelPrincipal;
    private JTextField cuitProveedorFR;
    private JButton BotonFR;
    private JComboBox rubroCDP;
    private JTextField productoServicioCDP;
    private JButton botonCDP;
    private JTextField cuitProveedorCC;
    private JButton botonCC;
    private JButton BotonODP;
    private JComboBox documentoCLI;
    private JButton botonCLI;
    private JTextField cuitProveedorCLI;
    private JButton botonDPP;
    private JButton botonTDR;
    private JTextField fechaFR;
    private JButton buscarDocumentosButton;

    public FrmPantallaConsultasGenerales(Window owner, String titulo){
        super(owner , titulo);

        this.setContentPane(panelPrincipal);

        this.setSize(1000, 400);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // se libera cuando se cierra

        this.setLocationRelativeTo(null); // Esto inicia la pantalla centrada

        this.setModal(true);

        ProductoServicioController productoServicioController = ProductoServicioController.getInstance();
        ProveedorController proveedorController = ProveedorController.getInstance();
        FacturaController facturaController = FacturaController.getInstance();
        RetencionController retencionController = RetencionController.getInstance();

        DefaultComboBoxModel model = new DefaultComboBoxModel();

        for (Rubro rubro : productoServicioController.getRubros()){
            model.addElement(rubro);
        }

        rubroCDP.setModel(model);

//--------------------------------------- FACTURAS RECIBIDAS--------------------------------------------------------------------------
        BotonFR.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                double totalAImprimir = 0;
                boolean cuitEntered = false;
                boolean dateEntered = false;
                int cuitProveedor = 0;
                LocalDate fecha = LocalDate.now();

                try{
                    cuitProveedor = Integer.parseInt(cuitProveedorFR.getText());
                    cuitEntered = true;
                }
                catch (Exception ex){
                    cuitEntered = false;
                }
                try{
                    fecha = LocalDate.parse(fechaFR.getText());
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

        //--------------------------------- CONSULTA DE PRECIOS------------------------------------------------------------------
        botonCDP.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                List<ProveedorPrecio> proveedorPrecioList = new ArrayList<ProveedorPrecio>();
                Rubro rubro = (Rubro)rubroCDP.getSelectedItem();

                proveedorPrecioList = proveedorController.ConsultaDePrecios(rubro, productoServicioCDP.getText());
                String respuesta = "";

                if(!proveedorPrecioList.isEmpty()) {
                    for (ProveedorPrecio proveedorPrecio : proveedorPrecioList) {
                        respuesta += proveedorPrecio.Print() + "   /n  ";
                    }
                }
                else
                    respuesta = "El producto indicado no existe";

                JOptionPane.showMessageDialog(null, respuesta);
            }
        });


        //---------------------------------CUENTA CORRIENTE--------------------------------------------------------
        botonCC.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CuentaCorrienteDTO cuentaCorrienteDTO = proveedorController.ConsultaCuentaCorriente(Integer.parseInt(cuitProveedorCC.getText()));
                JOptionPane.showMessageDialog(null, cuentaCorrienteDTO.Print());
            }
        });


        //---------------------------------ORDENES DE PAGO--------------------------------------------------------
        BotonODP.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null,proveedorController.OrdenesDePagoEmitidas());
            }
        });


        //---------------------------------DEUDA POR PROVEEDOR--------------------------------------------------------
        botonDPP.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, proveedorController.TotalDeudaPorProveedor());
            }
        });

        //---------------------------------IMPUESTOS RETENIDOS  --------------------------------------------------------
        botonTDR.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, retencionController.TotalImpuestosRetenidos());
            }
        });

        //---------------------------------CONSULTA LIBRO IVA--------------------------------------------------------
        buscarDocumentosButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                List<Factura> documentoRecibidos = proveedorController.DocumentosConsultaLibroIva(Integer.parseInt(cuitProveedorCLI.getText()));

                DefaultComboBoxModel model = new DefaultComboBoxModel();

                for (DocumentoRecibido documentoRecibido : documentoRecibidos){
                    model.addElement(documentoRecibido);
                }

                documentoCLI.setModel(model);
            }
        });
        botonCLI.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, retencionController.ConsultaLibroIva(Integer.parseInt(cuitProveedorCLI.getText()),
                        (DocumentoRecibido)documentoCLI.getSelectedItem()));
            }
        });
    }
}