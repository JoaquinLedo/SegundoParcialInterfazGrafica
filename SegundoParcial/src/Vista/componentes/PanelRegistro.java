/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.componentes;

/**
 *
 * @author Joaquin
 */
import javax.swing.*;
import java.awt.*;

public class PanelRegistro extends JPanel {
    public final JTextField txtNombre = new JTextField(10);
    public final JTextField txtApodo  = new JTextField(10);
    public final JComboBox<String> cboTipo = new JComboBox<>(new String[]{"Novato", "Experto", "VIP"});

    public PanelRegistro() {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(4,4,4,4); c.anchor = GridBagConstraints.WEST;

        c.gridx=0;c.gridy=0; add(new JLabel("Nombre:"), c);
        c.gridx=1;           add(txtNombre, c);
        c.gridx=0;c.gridy=1; add(new JLabel("Apodo:"), c);
        c.gridx=1;           add(txtApodo, c);
        c.gridx=0;c.gridy=2; add(new JLabel("Tipo:"), c);
        c.gridx=1;           add(cboTipo, c);
    }
}
