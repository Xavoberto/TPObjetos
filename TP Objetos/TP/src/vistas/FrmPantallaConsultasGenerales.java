package vistas;

import domain.controllers.FacturaController;
import domain.controllers.ProductoServicioController;
import domain.controllers.ProveedorController;
import domain.entities.Proveedor;
import domain.entities.Rubro;
import domain.entities.documentos.ProveedorPrecio;
import domain.entities.entitiesDtos.ProveedorDTO;

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

    public FrmPantallaConsultasGenerales(Window owner, String titulo){
        super(owner , titulo);

        this.setContentPane(panelPrincipal);

        this.setSize(1000, 400);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // se libera cuando se cierra

        this.setLocationRelativeTo(null); // Esto inicia la pantalla centrada

        this.setModal(true);

        ProveedorController proveedorController = ProveedorController.getInstance();
        ProductoServicioController productoServicioController = ProductoServicioController.getInstance();
        FacturaController facturaController = FacturaController.getInstance();

        DefaultComboBoxModel model = new DefaultComboBoxModel();

        for (Rubro rubro : productoServicioController.getRubros()){
            model.addElement(rubro);
        }

        rubroCDP.setModel(model);

//--------------------------------------- FACTURAS RECIBIDAS---------------------------------------------------------------------------
        BotonFR.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                double totalAImprimir = 0;
                boolean cuitEntered = false;
                boolean dateEntered = false;
                LocalDate fecha = LocalDate.now();

                if(cuitProveedorFR.getText() != ""){
                    cuitEntered = true;
                }
                if(LocalDate.parse(fechaFR.getText()) != null){
                    dateEntered = true;
                    fecha = LocalDate.parse(fechaFR.getText());
                }

                if(cuitEntered && dateEntered){
                    totalAImprimir = facturaController.TotalDeFacturas(fecha, Integer.parseInt(cuitProveedorFR.getText()));
                }
                else{
                    if(dateEntered){
                        fecha = LocalDate.parse(fechaFR.getText());
                        totalAImprimir = facturaController.TotalDeFacturas(fecha);
                    }
                    if(cuitEntered){
                        totalAImprimir = facturaController.TotalDeFacturas(Integer.parseInt(cuitProveedorFR.getText()));
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

                        for(ProveedorPrecio proveedorPrecio : proveedorPrecioList){
                            respuesta += proveedorPrecio.Print() + "   /n  ";
                        };

                JOptionPane.showMessageDialog(null, respuesta);
            }
        });
    }
}
