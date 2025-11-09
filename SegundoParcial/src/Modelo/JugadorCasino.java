/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Joaquin
 */
public class JugadorCasino extends Jugador {
    public JugadorCasino() { super("Casino", "Casa", Integer.MAX_VALUE / 4); }
    @Override public String getTipo() { return "Casino"; }
}
