package vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmPantallaAltas extends JDialog{
    private JButton altaProveedorButton;
    private JPanel panelPrincipal;
    private JButton altaFacturaButton;
    private JButton altaProductoServicioButton;
    private JButton altaProveedorProductoButton;
    private JButton altaCertificadoButton;
    private JButton altaRubroButton;
    private JButton realizarPagoButton;
    private FrmPantallaAltas self;

    public FrmPantallaAltas(Window owner, String titulo) {
        super(owner, titulo);

        this.setContentPane(panelPrincipal);

        this.setSize(400, 600);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // se libera cuando se cierra

        this.setLocationRelativeTo(null); // Esto inicia la pantalla centrada



        this.asociarEventos();

        this.self = this;



    }

    private void asociarEventos(){

        altaProveedorButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                FrmAltaProveedor frame = new FrmAltaProveedor(self , "Alta Proveedor");
                frame.setVisible(true);
            }
        });

        altaFacturaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                FrmAltaFactura frame = new FrmAltaFactura(self, "Alta Factura");
                frame.setVisible(true);
            }
        });

        altaProductoServicioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                FrmAltaProductoServicio frame = new FrmAltaProductoServicio(self, "Alta Producto Servicio");
                frame.setVisible(true);
            }
        });

        altaProveedorProductoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                FrmProveedorProducto frame = new FrmProveedorProducto(self, "Alta Proveedor Producto");
                frame.setVisible(true);
            }
        });

        altaCertificadoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                FrmAltaCertificado frame = new FrmAltaCertificado(self, "Alta Certificado");
                frame.setVisible(true);
            }
        });

        altaRubroButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                FrmRubro frame = new FrmRubro(self, "Alta Rubro");
                frame.setVisible(true);
            }
        });

        realizarPagoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                FrmRealizarPago frame = new FrmRealizarPago(self, "Realizar Pago");
                frame.setVisible(true);
            }
        });

    }
}
