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

public class EventosDelJuego implements Serializable {
    private static final long serialVersionUID = 1L;
    private final List<String> log = new ArrayList<>();
    public void agregar(String e){ log.add(e); }
    public List<String> getLog(){ return new ArrayList<>(log); }
    public void clear(){ log.clear(); }
}