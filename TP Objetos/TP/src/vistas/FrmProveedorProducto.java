package vistas;

import javax.swing.*;
import java.awt.*;

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
    }
}
