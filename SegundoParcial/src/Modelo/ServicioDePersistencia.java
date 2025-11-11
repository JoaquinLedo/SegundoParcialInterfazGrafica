/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Joaquin
 */
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ServicioDePersistencia {

    public void guardarJugadores(List<Jugador> jugadores) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("jugadores.txt"), StandardCharsets.UTF_8))) {
            for (Jugador j : jugadores) {
                bw.write(String.format("%s,%s,%s,%d,%d",
                        j.getNombre(), j.getApodo(), j.getTipo(), j.getDinero(), j.getVictorias()));
                bw.newLine();
            }
        }
    }

    public void guardarHistorial(List<Partida> partidas) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("historial.txt", true), StandardCharsets.UTF_8))) {
            int n = 1;
            for (Partida p : partidas) {
                String ganador = p.getRondas().isEmpty() ? "—" :
                        p.getRondas().get(p.getRondas().size()-1).getGanador().getNombre();
                bw.write(String.format("PARTIDA #%d - Ganador: %s | Rondas: %d", n++, ganador, p.getRondas().size()));
                bw.newLine();
            }
        }
    }

    public List<String> cargarHistorial() throws IOException {
        File f = new File("historial.txt");
        if (!f.exists()) return new ArrayList<>();
        List<String> out = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f), StandardCharsets.UTF_8))) {
            String s; while ((s = br.readLine()) != null) out.add(s);
        }
        return out;
    }
}