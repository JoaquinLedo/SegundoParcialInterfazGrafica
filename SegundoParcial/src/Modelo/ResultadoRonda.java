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
import java.util.LinkedHashMap;
import java.util.Map;

public class ResultadoRonda implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Map<Jugador,Integer> tiros = new LinkedHashMap<>();
    private Jugador ganador;
    private int pozo;
    
    public void registrarTiro(Jugador j, int valor) { tiros.put(j, valor); }
    public Map<Jugador,Integer> getTiros() { return tiros; }
    public Jugador getGanador() { return ganador; }
    public void setGanador(Jugador g) { this.ganador = g; }
    public int getPozo() { return pozo; }
    public void setPozo(int p) { this.pozo = p; }
}
