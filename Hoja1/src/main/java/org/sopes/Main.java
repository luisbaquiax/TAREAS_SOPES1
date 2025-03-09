package org.sopes;

import org.sopes.ejercicio1.Persona;
import org.sopes.ejercicio2.Carrera;
import org.sopes.ejercicio2.Corredor;
import org.sopes.ejercicio3.Recurso;

public class Main {
    public static void main(String[] args) {
        //ejercicio 1
        /*System.out.println("*************");
        for (int i = 1; i < 6; i++) {
            Thread hilo = new Thread(new Persona("Hilo " + i));
            hilo.run();
        }*/

        //ejercicio 2
        /*Thread hilo1 = new Thread(new Carrera(new Corredor("Luis", 0), "0"));
        Thread hilo2 = new Thread(new Carrera(new Corredor("Mary", 0), "*"));
        Thread hilo3 = new Thread(new Carrera(new Corredor("Marta", 0), "X"));
        hilo1.start();
        hilo2.start();
        hilo3.start();*/

        //ejercicio 3
        Recurso recurso1 = new Recurso("Recurso 1");
        Recurso recurso2 = new Recurso("Recurso 2");

        Thread hilo1 = new Thread(()->{
           recurso1.bloquearRecurso(recurso2);
        }, "hilo1");

        Thread hilo2 = new Thread(()->{
            recurso2.bloquearRecurso(recurso1);
        }, "hilo2");

        hilo1.start();
        hilo2.start();

    }
}