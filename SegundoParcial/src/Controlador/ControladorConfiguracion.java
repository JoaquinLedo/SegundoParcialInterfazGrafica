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
import Vista.VentanaConfiguracion;

import javax.swing.*;

public class ControladorConfiguracion {
    private final EstadoDelJuego estado = new EstadoDelJuego();
    private final ControladorPersistencia persistencia = new ControladorPersistencia();
    private VentanaConfiguracion vista;

    public void iniciar() {
        vista = new VentanaConfiguracion(this, estado);
        vista.setVisible(true);
    }

    public void agregarJugador(String nombre, String apodo, String tipo, int dineroInicial) {
        if (nombre.isBlank() || apodo.isBlank()) {
            JOptionPane.showMessageDialog(vista, "Nombre y apodo son obligatorios");
            return;
        }
        if (estado.getJugadores().size() >= 4) {
            JOptionPane.showMessageDialog(vista, "Máximo 4 jugadores");
            return;
        }
        Jugador j;
        switch (tipo) {
            case "Experto": j = new JugadorExperto(nombre, apodo, dineroInicial); break;
            case "VIP": j = new JugadorVip(nombre, apodo, dineroInicial); break;
            default: j = new JugadorNovato(nombre, apodo, dineroInicial);
        }
        estado.agregarJugador(j);
        vista.refrescarLista();
    }

    public void eliminarJugador(int index) {
        if (index >= 0 && index < estado.getJugadores().size()) {
            estado.getJugadores().remove(index);
            vista.refrescarLista();
        }
    }

    public void configurar(int dineroInicial, int partidas, int rondas, int apuesta) {
        estado.configurar(dineroInicial, partidas, rondas, apuesta);
    }

    public void iniciarJuego() {
        if (estado.getJugadores().size() < 2) {
            JOptionPane.showMessageDialog(vista, "Debe haber entre 2 y 4 jugadores");
            return;
        }
        estado.iniciar();
        vista.dispose();
        new ControladorJuego(estado, persistencia).abrir();
    }

    public java.util.List<String> historialGuardado() { return persistencia.cargarHistorialSeguro(); }
}
