/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.luisbaquiax.hoja_2.seccion2;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author luis
 */
public class Cajero implements Runnable {

    private BlockingQueue<String> cola;
    private Random random;

    public Cajero(BlockingQueue cola) {
        this.cola = cola;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            while (true) {
                String productoAprocesar = cola.take();
                if (productoAprocesar.equals("VACIA")) {
                    break;
                }
                int tardanza = random.nextInt(1, 7) * 1000;
                Thread.sleep(tardanza);
                System.out.println(Thread.currentThread().getName() + " ha procesado el producto " + productoAprocesar);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
