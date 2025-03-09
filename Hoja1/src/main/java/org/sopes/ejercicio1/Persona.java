package org.sopes.ejercicio1;

public class Persona implements Runnable{
    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }
    public void run() {
        System.out.println(this.nombre);
    }
}

