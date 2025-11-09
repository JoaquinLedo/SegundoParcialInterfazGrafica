/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author Joaquin
 */
import Modelo.EstadoDelJuego;
import Modelo.ServicioDePersistencia;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class ControladorPersistencia {
    private final ServicioDePersistencia servicio = new ServicioDePersistencia();

    public void guardarTodo(EstadoDelJuego estado) {
        try {
            servicio.guardarJugadores(estado.getJugadores());
            servicio.guardarHistorial(estado.getPartidas());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> cargarHistorialSeguro() {
        try { return servicio.cargarHistorial(); }
        catch (IOException e) { return Collections.emptyList(); }
    }
}
