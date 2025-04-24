/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.luisbaquiax.hoja_2.seccion2;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis
 */
public class Cliente implements Runnable {

    private BlockingQueue<String> cola;
    private Random random;
    private int productos;

    public Cliente(BlockingQueue cola, int productos) {
        this.cola = cola;
        this.random = new Random();
        this.productos = productos;
    }

    @Override
    public void run() {
        for (int i = 0; i < productos; i++) {
            String nombreProducto = "Producto " + (i + 1);
            try {
                int tardanza = random.nextInt(1, 7) * 1000;
                Thread.sleep(tardanza);
                cola.put(nombreProducto);
                System.out.println(Thread.currentThread().getName() + " ha agregado el producto " + nombreProducto);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    }
}
