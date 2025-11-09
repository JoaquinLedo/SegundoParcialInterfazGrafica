/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.cuadrosDialogo;

/**
 *
 * @author Joaquin
 */
import Modelo.Jugador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class CuadroRanking extends JDialog {
    public CuadroRanking(Frame owner, List<Jugador> ranking) {
        super(owner, "Ranking actual", true);
        setSize(500, 360);
        setLocationRelativeTo(owner);

        String[] cols = {"Nombre","Tipo","Dinero","Victorias"};
        DefaultTableModel m = new DefaultTableModel(cols, 0);
        for (Jugador j : ranking) m.addRow(new Object[]{j.getNombre(), j.getTipo(), j.getDinero(), j.getVictorias()});
        JTable tabla = new JTable(m);

        add(new JScrollPane(tabla));
    }
}
