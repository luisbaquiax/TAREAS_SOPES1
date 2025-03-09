package org.sopes.ejercicio2;

public class Corredor {
    private String nombre;
    private int distancia;
    public Corredor(String nombre, int distancia) {
        this.nombre = nombre;
        this.distancia = distancia;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getDistancia() {
        return distancia;
    }
    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }
}
