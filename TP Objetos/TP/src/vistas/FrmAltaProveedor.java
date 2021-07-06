package vistas;

import domain.controllers.ProveedorController;
import domain.entities.Rubro;
import domain.entities.enumeraciones.ResponsableIva;
import domain.entities.enumeraciones.TipoDeUnidad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.format.ResolverStyle;
import java.util.Objects;

public class FrmAltaProveedor extends JDialog{
    private JPanel panelPrincipal;
    private JPanel altaPanel;
    private JTextField cuitField;
    private JTextField nombreField;
    private JTextField ingresosBField;
    private JTextField telefonoField;
    private JTextField correoField;
    private JComboBox comboRIVA;
    private JTextField calleField;
    private JTextField paisField;
    private JTextField alturaField;
    private JTextField provinciaField;
    private JTextField codigoPostalField;
    private JTextField localidadField;
    private JButton buttonAltaProveedor;

    public FrmAltaProveedor(Window owner, String titulo) {
        super(owner, titulo);

        this.setContentPane(panelPrincipal);

        this.setSize(600, 525);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // se libera cuando se cierra

        this.setLocationRelativeTo(null); // Esto inicia la pantalla centrada

        this.setModal(true);

        ProveedorController proveedorController = ProveedorController.getInstance();

        DefaultComboBoxModel modeloTDU = new DefaultComboBoxModel();

        for(ResponsableIva responsableIva  : ResponsableIva.values()){
            modeloTDU.addElement(responsableIva);
        }
        comboRIVA.setModel(modeloTDU);

        buttonAltaProveedor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(Objects.equals(nombreField.getText(), "") || Objects.equals(telefonoField.getText(),"") || Objects.equals(correoField.getText(),"")
                || Objects.equals(calleField.getText(),"") || Objects.equals(paisField.getText(),"") || Objects.equals(provinciaField.getText(),"")
                || Objects.equals(localidadField.getText(),"") ){
                    JOptionPane.showMessageDialog(null,"Error, ingrese datos en todas las casillas");
                    return;
                }

                String nombre = nombreField.getText();
                ResponsableIva responsableIva = (ResponsableIva)comboRIVA.getSelectedItem();
                int cuit = Integer.parseInt(cuitField.getText());
                String telefono = telefonoField.getText();
                String correo = correoField.getText();
                double ingresosBrutos = Double.parseDouble(ingresosBField.getText());
                //DIRECCION PROVEEDOR
                String calle = calleField.getText();
                String pais = paisField.getText();
                String provincia = provinciaField.getText();
                String localidad = localidadField.getText();
                int altura = Integer.parseInt(alturaField.getText());
                int codigoPostal = Integer.parseInt(codigoPostalField.getText());

                proveedorController.AltaProveedor(nombre , responsableIva , cuit, telefono, correo, ingresosBrutos, calle, pais , provincia, localidad, altura , codigoPostal);


            }
        });
    }


}
