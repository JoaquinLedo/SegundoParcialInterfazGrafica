/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

/**
 *
 * @author Joaquin
 */
import Controlador.ControladorConfiguracion;
import Modelo.EstadoDelJuego;
import Modelo.Jugador;
import Vista.componentes.PanelRegistro;

import javax.swing.*;
import java.awt.*;

public class VentanaConfiguracion extends JFrame {
    private final ControladorConfiguracion controlador;
    private final EstadoDelJuego estado;

    private final DefaultListModel<String> model = new DefaultListModel<>();
    private final JList<String> lst = new JList<>(model);

    private final PanelRegistro panelRegistro = new PanelRegistro();
    private final JSpinner spDinero  = new JSpinner(new SpinnerNumberModel(500,100,5000,50));
    private final JSpinner spPartida = new JSpinner(new SpinnerNumberModel(3,1,10,1));
    private final JSpinner spRondas  = new JSpinner(new SpinnerNumberModel(3,1,10,1));
    private final JSpinner spApuesta = new JSpinner(new SpinnerNumberModel(100,10,1000,10));

    public VentanaConfiguracion(ControladorConfiguracion controlador, EstadoDelJuego estado) {
        super("Configuración de Juego");
        this.controlador = controlador;
        this.estado = estado;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        armarUI();
    }

    private void armarUI() {
        JPanel izq = new JPanel(new BorderLayout());
        izq.setBorder(BorderFactory.createTitledBorder("Registro de jugadores"));
        izq.add(panelRegistro, BorderLayout.NORTH);

        JPanel btns = new JPanel();
        JButton btnAgregar = new JButton("Agregar jugador");
        JButton btnEliminar = new JButton("Eliminar seleccionado");
        btns.add(btnAgregar); btns.add(btnEliminar);
        izq.add(btns, BorderLayout.CENTER);

        JPanel der = new JPanel(new GridBagLayout());
        der.setBorder(BorderFactory.createTitledBorder("Configuración"));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6,6,6,6); c.anchor = GridBagConstraints.WEST;
        c.gridx=0;c.gridy=0; der.add(new JLabel("Dinero inicial:"), c);
        c.gridx=1;           der.add(spDinero, c);
        c.gridx=0;c.gridy=1; der.add(new JLabel("Partidas totales:"), c);
        c.gridx=1;           der.add(spPartida, c);
        c.gridx=0;c.gridy=2; der.add(new JLabel("Rondas por partida:"), c);
        c.gridx=1;           der.add(spRondas, c);
        c.gridx=0;c.gridy=3; der.add(new JLabel("Apuesta fija:"), c);
        c.gridx=1;           der.add(spApuesta, c);

        JPanel lista = new JPanel(new BorderLayout());
        lista.setBorder(BorderFactory.createTitledBorder("Jugadores (2 a 4)"));
        lista.add(new JScrollPane(lst));

        JPanel abajo = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnHist    = new JButton("Historial");
        JButton btnIniciar = new JButton("Iniciar juego");
        JButton btnSalir   = new JButton("Salir");
        abajo.add(btnHist); abajo.add(btnIniciar); abajo.add(btnSalir);

        JPanel centro = new JPanel(new GridLayout(1,3,10,10));
        centro.add(izq); centro.add(der); centro.add(lista);

        setLayout(new BorderLayout(10,10));
        add(centro, BorderLayout.CENTER);
        add(abajo,  BorderLayout.SOUTH);

      
        btnAgregar.addActionListener(e -> {
            controlador.configurar((int)spDinero.getValue(), (int)spPartida.getValue(),
                    (int)spRondas.getValue(), (int)spApuesta.getValue());
            controlador.agregarJugador(
                    panelRegistro.txtNombre.getText().trim(),
                    panelRegistro.txtApodo.getText().trim(),
                    (String) panelRegistro.cboTipo.getSelectedItem(),
                    (int) spDinero.getValue());
            panelRegistro.txtNombre.setText("");
            panelRegistro.txtApodo.setText("");
        });

        btnEliminar.addActionListener(e -> controlador.eliminarJugador(lst.getSelectedIndex()));

        btnIniciar.addActionListener(e -> {
            controlador.configurar((int)spDinero.getValue(), (int)spPartida.getValue(),
                    (int)spRondas.getValue(), (int)spApuesta.getValue());
            controlador.iniciarJuego();
        });

        btnHist.addActionListener(e -> {
            java.util.List<String> h = controlador.historialGuardado();
            JOptionPane.showMessageDialog(this, h.isEmpty()? "Sin historial" : String.join("\n", h),
                    "Historial", JOptionPane.INFORMATION_MESSAGE);
        });

        btnSalir.addActionListener(e -> System.exit(0));

        refrescarLista();
    }

    public void refrescarLista() {
        model.clear();
        for (Jugador j : estado.getJugadores()) {
            model.addElement(j.getNombre()+" ("+j.getTipo()+") - @"+j.getApodo());
        }
    }

    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new Controlador.ControladorConfiguracion().iniciar());
    }
}