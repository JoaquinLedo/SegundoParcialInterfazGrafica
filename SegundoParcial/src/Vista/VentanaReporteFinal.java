/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

/**
 *
 * @author Joaquin
 */
import Modelo.Jugador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VentanaReporteFinal extends JFrame {
    public VentanaReporteFinal(List<Jugador> ranking, String[] stats, List<String> ultimas) {
        super("Reporte Final");
        setSize(700, 520);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        String[] cols = {"Nombre", "Tipo", "Dinero", "Victorias"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        for (Jugador j : ranking) model.addRow(new Object[]{j.getNombre(), j.getTipo(), j.getDinero(), j.getVictorias()});
        JTable tabla = new JTable(model);

        JPanel rank = new JPanel(new BorderLayout());
        rank.setBorder(BorderFactory.createTitledBorder("Ranking"));
        rank.add(new JScrollPane(tabla), BorderLayout.CENTER);

        JPanel estad = new JPanel(new GridLayout(3,1));
        estad.setBorder(BorderFactory.createTitledBorder("Estadísticas"));
        estad.add(new JLabel("Mayor apuesta realizada: " + stats[0]));
        estad.add(new JLabel("Mejor puntaje de dados: " + stats[1]));
        estad.add(new JLabel("Jugadores afectados por trampas: " + stats[2]));

        JTextArea ta = new JTextArea(); ta.setEditable(false);
        for (String s : ultimas) ta.append(s + "\n");
        JPanel hist = new JPanel(new BorderLayout());
        hist.setBorder(BorderFactory.createTitledBorder("Últimas 3 partidas"));
        hist.add(new JScrollPane(ta), BorderLayout.CENTER);

        setLayout(new BorderLayout(8,8));
        add(rank, BorderLayout.CENTER);
        add(estad, BorderLayout.NORTH);
        add(hist, BorderLayout.SOUTH);
    }
}
