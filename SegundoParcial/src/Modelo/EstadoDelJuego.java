/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Joaquin
 */
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.*;

public class EstadoDelJuego implements Serializable {
    private static final long serialVersionUID = 1L;

    private final List<Jugador> jugadores = new ArrayList<>();
    private final List<Partida> partidas = new ArrayList<>();
    private int partidasTotales = 3, rondasPorPartida = 3, dineroInicial = 500, apuestaFija = 100;
    private int idxPartida = 0, idxRonda = 0;

    private final Dado dado = new Dado();
    private final EventosDelJuego eventos = new EventosDelJuego();
    private transient Random rnd = new Random(); // ¡transient!

    public void configurar(int dineroInicial, int partidasTotales, int rondasPorPartida, int apuestaFija) {
        this.dineroInicial = dineroInicial;
        this.partidasTotales = partidasTotales;
        this.rondasPorPartida = rondasPorPartida;
        this.apuestaFija = apuestaFija;
    }

    public void agregarJugador(Jugador j) { jugadores.add(j); }
    public void limpiarJugadores() { jugadores.clear(); }

    public void iniciar() {
        partidas.clear();
        for (Jugador j : jugadores) {
            j.dinero = dineroInicial;
            j.victorias = 0;
            j.ultimaApuesta = 0;
            j.ultimoTiro = 0;
            j.trampa = Trampa.NINGUNA;
        }
        idxPartida = 0; idxRonda = 0;
        partidas.add(new Partida(1));
        eventos.clear();
    }

    public boolean finalizado() {
        if (idxPartida >= partidasTotales) return true;
        for (Jugador j : jugadores) if (j.getDinero() <= 0) return true;
        return false;
    }

    public ResultadoRonda jugarRonda() {
        if (finalizado()) return null;

       
        if (rnd.nextInt(100) < 20) {
            Jugador victima = jugadores.get(rnd.nextInt(jugadores.size()));
            Trampa t = rnd.nextBoolean() ? Trampa.CONFUSION : Trampa.CARGADOS;
            victima.setTrampa(t);
            eventos.agregar("El Casino confunde a " + victima.getNombre() + " (" + victima.getTipo() + ")");
        }

        Ronda r = new Ronda(idxRonda + 1);
        ResultadoRonda res = r.jugar(jugadores, dado, apuestaFija);
        partidas.get(idxPartida).agregarResultado(res);

        eventos.agregar("Ganador de la ronda: " + res.getGanador().getNombre() + " gana $" + res.getPozo());

        idxRonda++;
        if (idxRonda >= rondasPorPartida) {
            idxPartida++;
            idxRonda = 0;
            if (idxPartida < partidasTotales) partidas.add(new Partida(idxPartida + 1));
        }
        return res;
    }

    public int getPozoAcumulado() {
        int pozo = 0;
        for (Partida p : partidas)
            for (ResultadoRonda rr : p.getRondas())
                pozo += rr.getPozo();
        return pozo;
    }

  
    public List<Jugador> getJugadores() { return jugadores; }
    public List<Partida> getPartidas()  { return partidas; }
    public int getPartidasTotales()     { return partidasTotales; }
    public int getRondasPorPartida()    { return rondasPorPartida; }
    public int getIndicePartida()       { return idxPartida; }
    public int getIndiceRonda()         { return idxRonda; }
    public EventosDelJuego getEventos() { return eventos; }
    
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        rnd = new Random(); 
    }
}
