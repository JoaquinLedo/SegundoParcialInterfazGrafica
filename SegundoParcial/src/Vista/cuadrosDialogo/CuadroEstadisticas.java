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

public class CuadroEstadisticas extends JDialog {
    public CuadroEstadisticas(Frame owner, String[] stats) {
        super(owner, "Estadísticas", true);
        setSize(420, 220);
        setLocationRelativeTo(owner);
        JPanel p = new JPanel(new GridLayout(3,1,6,6));
        p.add(new JLabel("Mayor apuesta: " + stats[0]));
        p.add(new JLabel("Mejor puntaje de dados: " + stats[1]));
        p.add(new JLabel("Jugadores afectados por trampas: " + stats[2]));
        add(p);
    }
}
