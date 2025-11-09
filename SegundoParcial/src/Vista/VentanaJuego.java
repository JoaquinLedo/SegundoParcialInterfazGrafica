/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

/**
 *
 * @author Joaquin
 */
import Controlador.ControladorJuego;
import Modelo.EstadoDelJuego;
import Modelo.Jugador;
import Vista.componentes.PanelJugador;
import Vista.cuadrosDialogo.CuadroEstadisticas;
import Vista.cuadrosDialogo.CuadroHistorial;
import Vista.cuadrosDialogo.CuadroRanking;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaJuego extends JFrame {
    private final ControladorJuego controlador;
    private final EstadoDelJuego estado;

    private final JLabel lblPartida = new JLabel();
    private final JLabel lblRonda = new JLabel();
    private final JLabel lblPozo = new JLabel();

    private final JPanel contJugadores = new JPanel(new GridLayout(4,1,6,6));
    private final DefaultListModel<String> logModel = new DefaultListModel<>();
    private final JList<String> lstLog = new JList<>(logModel);

    public VentanaJuego(ControladorJuego controlador, EstadoDelJuego estado) {
        super("Juego de Dados");
        this.controlador = controlador;
        this.estado = estado;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        armarUI();
    }

    private void armarUI() {
        // Menú
        JMenuBar mb = new JMenuBar();
        JMenu mPartida = new JMenu("Partida");
        JMenuItem miSalir = new JMenuItem("Salir");
        mPartida.add(miSalir);

        JMenu mVer = new JMenu("Ver");
        JMenuItem miRanking = new JMenuItem("Ranking actual");
        JMenuItem miHist = new JMenuItem("Historial");
        JMenuItem miStats = new JMenuItem("Estadísticas");
        mVer.add(miRanking); mVer.add(miHist); mVer.add(miStats);

        mb.add(mPartida); mb.add(mVer);
        setJMenuBar(mb);

        // Header
        JPanel sup = new JPanel(new GridLayout(1,3));
        sup.add(lblPartida); sup.add(lblRonda); sup.add(lblPozo);
        sup.setBorder(BorderFactory.createTitledBorder("Información de partida"));

        // Centro
        for (int i=0;i<4;i++) contJugadores.add(new PanelJugador());
        JPanel centro = new JPanel(new BorderLayout());
        centro.add(contJugadores, BorderLayout.CENTER);
        JButton btnRonda = new JButton("Jugar Ronda");
        centro.add(btnRonda, BorderLayout.SOUTH);

        // Log
        lstLog.setVisibleRowCount(6);
        JPanel inf = new JPanel(new BorderLayout());
        inf.setBorder(BorderFactory.createTitledBorder("Log de eventos"));
        inf.add(new JScrollPane(lstLog), BorderLayout.CENTER);

        setLayout(new BorderLayout(8,8));
        add(sup, BorderLayout.NORTH);
        add(centro, BorderLayout.CENTER);
        add(inf, BorderLayout.SOUTH);

        // acciones
        btnRonda.addActionListener(e -> controlador.jugarRonda());
        miSalir.addActionListener(e -> System.exit(0));
        miRanking.addActionListener(e -> new CuadroRanking(this, controlador.rankingActual()).setVisible(true));
        miHist.addActionListener(e -> new CuadroHistorial(this, controlador.ultimas3(), controlador.historialGuardado()).setVisible(true));
        miStats.addActionListener(e -> new CuadroEstadisticas(this, controlador.estadisticas()).setVisible(true));

        refrescar();
    }

    public void refrescar() {
        lblPartida.setText("Partida " + (estado.getIndicePartida()+1) + "/" + estado.getPartidasTotales());
        lblRonda.setText("Ronda " + (estado.getIndiceRonda()+1) + "/" + estado.getRondasPorPartida());
        lblPozo.setText("Pozo acumulado: $" + estado.getPozoAcumulado());

        java.util.List<Jugador> js = estado.getJugadores();
        for (int i = 0; i < contJugadores.getComponentCount(); i++) {
            PanelJugador pj = (PanelJugador) contJugadores.getComponent(i);
            if (i < js.size()) { pj.setVisible(true); pj.setJugador(js.get(i)); }
            else pj.setVisible(false);
        }

        logModel.clear();
        for (String e : estado.getEventos().getLog()) logModel.addElement(e);
        if (!logModel.isEmpty()) lstLog.ensureIndexIsVisible(logModel.size()-1);
    }
}
