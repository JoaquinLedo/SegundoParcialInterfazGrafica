/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.cuadrosDialogo;

/**
 *
 * @author Joaquin
 */
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CuadroHistorial extends JDialog {
    public CuadroHistorial(Frame owner, List<String> ultimas, List<String> guardado) {
        super(owner, "Historial de Partidas", true);
        setSize(520, 380);
        setLocationRelativeTo(owner);
        JTextArea ta = new JTextArea(); ta.setEditable(false);

        if (ultimas != null && !ultimas.isEmpty()) {
            ta.append("ÚLTIMAS PARTIDAS\n");
            for (String s : ultimas) ta.append("• " + s + "\n");
            ta.append("\n");
        }
        if (guardado != null && !guardado.isEmpty()) {
            ta.append("HISTORIAL GUARDADO\n");
            for (String s : guardado) ta.append("• " + s + "\n");
        }
        if (ta.getText().isBlank()) ta.setText("Sin historial.");

        add(new JScrollPane(ta));
    }
}
