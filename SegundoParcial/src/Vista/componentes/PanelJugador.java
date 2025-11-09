/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.componentes;

/**
 *
 * @author Joaquin
 */
import Modelo.Jugador;

import javax.swing.*;
import java.awt.*;

public class PanelJugador extends JPanel {
    private final JLabel lblNombre = new JLabel();
    private final JLabel lblTipo = new JLabel();
    private final JLabel lblDinero = new JLabel();
    private final JLabel lblApuesta = new JLabel();
    private final JLabel lblTiro = new JLabel();
    private final JLabel lblVictorias = new JLabel();

    public PanelJugador() {
        setLayout(new GridLayout(1,6,8,0));
        add(lblNombre); add(lblTipo); add(lblDinero);
        add(lblApuesta); add(lblTiro); add(lblVictorias);
        setBorder(BorderFactory.createEmptyBorder(4,4,4,4));
    }

    public void setJugador(Jugador j) {
        lblNombre.setText(j.getNombre());
        lblTipo.setText(j.getTipo());
        lblDinero.setText("$"+j.getDinero());
        lblApuesta.setText("Apuesta: " + (j.getUltimaApuesta()==0? "-" : "$"+j.getUltimaApuesta()));
        lblTiro.setText("Tiro: " + (j.getUltimoTiro()==0? "-" : j.getUltimoTiro()));
        lblVictorias.setText("Victorias: " + j.getVictorias());
    }
}
