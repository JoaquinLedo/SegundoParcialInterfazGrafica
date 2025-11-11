/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Joaquin
 */
import java.io.Serializable;
import java.util.List;

public class Ronda implements Serializable {
    private static final long serialVersionUID = 1L;
    private final int numero;
    public Ronda(int n){ this.numero = n; }
    public int getNumero() { return numero; }

    public ResultadoRonda jugar(List<Jugador> jugadores, Dado dado, int apuestaFija) {
        ResultadoRonda res = new ResultadoRonda();
        int pozo = 0;

        for (Jugador j : jugadores) pozo += j.apostar(apuestaFija);

        int mejor = -1; Jugador ganador = null;
        for (Jugador j : jugadores) {
            int tiro = j.tirar(dado);
            res.registrarTiro(j, tiro);
            if (tiro > mejor) { mejor = tiro; ganador = j; }
        }

        ganador.cobrar(pozo);
        res.setGanador(ganador);
        res.setPozo(pozo);
        return res;
    }
}
