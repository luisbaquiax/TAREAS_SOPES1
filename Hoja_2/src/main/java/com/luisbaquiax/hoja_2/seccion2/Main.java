/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.luisbaquiax.hoja_2.seccion2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author luis
 */
public class Main {

    public static void main(String[] args) {
        /*
        Semaphore semaforo = new Semaphore(1);
        Banco banco = new Banco(semaforo);
        for (int i = 0; i < 5; i++) {
            String cliente = "Cliente " + i;
            new Thread(()-> banco.entrar(cliente)).start();
        }
        System.out.println("****************** capacidad 1 ******************");
        Biblioteca biblioteca = new Biblioteca(1);
        for (int i = 0; i < 10; i++) {
            String estudiante = "Estudiante " + (i+1);
            new Thread(() -> biblioteca.entrar(estudiante)).start();
        }
        System.out.println("****************** capacidad 3 ******************");
        Biblioteca biblioteca1 = new Biblioteca(3);
        for (int i = 0; i < 10; i++) {
            String estudiante = "Estudiante " + (i+1);
            new Thread(() -> biblioteca1.entrar(estudiante)).start();
        }
        System.out.println("****************** capacidad 5 ******************");
        Biblioteca biblioteca2 = new Biblioteca(5);
        for (int i = 0; i < 10; i++) {
            String estudiante = "Estudiante " + (i+1);
            new Thread(() -> biblioteca2.entrar(estudiante)).start();
        }
         */

        BlockingQueue<String> cola = new ArrayBlockingQueue(10);
        Thread cliente = new Thread(new Cliente(cola, 10), "Cliente");
        Thread cajero = new Thread(new Cajero(cola), "Cajero");
        cliente.start();
        cajero.start();
        try {
            cliente.join();
            cola.put("VACIA");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
