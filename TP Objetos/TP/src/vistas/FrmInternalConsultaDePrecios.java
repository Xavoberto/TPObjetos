package vistas;

import domain.entities.Rubro;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

public class FrmInternalConsultaDePrecios extends JInternalFrame {
    private JPanel panelPrincipal;
    private JComboBox cbRubros;
    private JComboBox cbProductos;
    private JLabel lblRubro;
    private JLabel lblPrecio;

    private List<Rubro> rubros = new ArrayList<Rubro>();


    public FrmInternalConsultaDePrecios(){
        super("Demo");

        this.setContentPane(panelPrincipal);

        this.setBorder(null);

        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);

        rubros.add(new Rubro("farmacia", null));
        rubros.add(new Rubro("carnicos", null));
        rubros.add(new Rubro("constructor", null));


    DefaultComboBoxModel model = new DefaultComboBoxModel();
    model.addElement(rubros);
    cbRubros.setModel(model);


    }
}
