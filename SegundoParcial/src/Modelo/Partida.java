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
import java.util.ArrayList;
import java.util.List;

public class Partida implements Serializable {
    private static final long serialVersionUID = 1L;
    private final int numero;
    private final List<ResultadoRonda> rondas = new ArrayList<>();
    public Partida(int n) { this.numero = n; }
    public int getNumero() { return numero; }
    public List<ResultadoRonda> getRondas() { return rondas; }
    public void agregarResultado(ResultadoRonda r) { rondas.add(r); }
}
