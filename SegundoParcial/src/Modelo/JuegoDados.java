/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Joaquin
 */
public class JuegoDados {
    private final EstadoDelJuego estado = new EstadoDelJuego();

    public EstadoDelJuego getEstado() { return estado; }

    public void configurar(int dinero, int partidas, int rondas, int apuesta) {
        estado.configurar(dinero, partidas, rondas, apuesta);
    }

    public void iniciar() { estado.iniciar(); }

    public ResultadoRonda jugarRonda() { return estado.jugarRonda(); }
}
