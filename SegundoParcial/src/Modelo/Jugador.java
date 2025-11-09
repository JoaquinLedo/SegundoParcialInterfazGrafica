/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Joaquin
 */
public abstract class Jugador implements Comparable<Jugador> {
    protected String nombre;
    protected String apodo;
    protected int dinero;
    protected int victorias;
    protected int ultimaApuesta;
    protected int ultimoTiro;
    protected Trampa trampa = Trampa.NINGUNA;

    public Jugador(String nombre, String apodo, int dineroInicial) {
        this.nombre = nombre;
        this.apodo  = apodo;
        this.dinero = dineroInicial;
    }

    public abstract String getTipo();

    public int apostar(int monto) {
        int m = Math.min(monto, dinero);
        ultimaApuesta = m;
        dinero -= m;
        return m;
    }

    public int tirar(Dado dado) {
        int t = dado.tirar() + dado.tirar(); // 2..12
        if (trampa == Trampa.CARGADOS) t = Math.max(2, t - 2);
        else if (trampa == Trampa.CONFUSION) t = Math.max(2, t - 1);
        ultimoTiro = t;
        trampa = Trampa.NINGUNA;
        return t;
    }

    public void cobrar(int monto) {
        dinero += monto;
        victorias++;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getApodo()  { return apodo; }
    public int getDinero()    { return dinero; }
    public int getVictorias() { return victorias; }
    public int getUltimaApuesta() { return ultimaApuesta; }
    public int getUltimoTiro()    { return ultimoTiro; }
    public Trampa getTrampa()     { return trampa; }
    public void setTrampa(Trampa t) { this.trampa = t; }

    @Override
    public int compareTo(Jugador o) {
        return Integer.compare(o.dinero, this.dinero);
    }
}
