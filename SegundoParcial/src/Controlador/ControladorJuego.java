/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author Joaquin
 */
import Modelo.*;
import Vista.VentanaJuego;
import Vista.VentanaReporteFinal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ControladorJuego implements EventosJuego {
    private final EstadoDelJuego estado;
    private final ControladorPersistencia persistencia;
    private Vista.VentanaJuego vista;

    public ControladorJuego(EstadoDelJuego estado, ControladorPersistencia persistencia) {
        this.estado = estado;
        this.persistencia = persistencia;
    }

    public void abrir() {
        vista = new VentanaJuego(this, estado);
        vista.setVisible(true);
        onActualizacion();
    }

    public void jugarRonda() {
        if (estado.finalizado()) { finalizar(); return; }
        estado.jugarRonda();
        onActualizacion();
        if (estado.finalizado()) finalizar();
    }

    private void finalizar() {
        persistencia.guardarTodo(estado);         
        new VentanaReporteFinal(rankingActual(),  
                estadisticas(), ultimas3()).setVisible(true);
        vista.dispose();
    }

    // ===== Datos para UI =====
    public List<Jugador> rankingActual() {
        List<Jugador> rk = new ArrayList<>(estado.getJugadores());
        Collections.sort(rk);
        return rk;
    }

    public String[] estadisticas() {
        int mayorApuesta = 0; Jugador jApuesta = null;
        int mejorTiro = 0;    Jugador jTiro = null;
        int jugadoresAfectados = 0;

        for (Jugador j : estado.getJugadores()) {
            if (j.getUltimaApuesta() >= mayorApuesta) { mayorApuesta = j.getUltimaApuesta(); jApuesta = j; }
            if (j.getUltimoTiro()   >= mejorTiro)     { mejorTiro   = j.getUltimoTiro();     jTiro = j; }
        }
        for (String e : estado.getEventos().getLog())
            if (e.contains("confunde")) jugadoresAfectados++;

        return new String[] {
                jApuesta == null ? "-" : (jApuesta.getNombre()+" $"+mayorApuesta),
                jTiro == null ? "-" : (jTiro.getNombre()+" ("+mejorTiro+")"),
                String.valueOf(jugadoresAfectados)
        };
    }

    public List<String> ultimas3() {
        List<String> hist = new ArrayList<>();
        int i = 1;
        for (Partida p : estado.getPartidas()) {
            String ganador = p.getRondas().isEmpty()? "—" :
                    p.getRondas().get(p.getRondas().size()-1).getGanador().getNombre();
            hist.add("PARTIDA #"+i+" - Ganador: "+ganador+" | Rondas: "+p.getRondas().size());
            i++;
        }
        if (hist.size() > 3) return hist.subList(hist.size()-3, hist.size());
        return hist;
    }

    @Override public void onEvento(String texto) {}
    @Override public void onActualizacion() { if (vista != null) vista.refrescar(); }

    public List<String> historialGuardado() { return persistencia.cargarHistorialSeguro(); }
}