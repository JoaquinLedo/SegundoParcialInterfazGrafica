/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Joaquin
 */
import java.util.List;

public class Ronda {
    private final int numero;
    public Ronda(int numero) { this.numero = numero; }
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
