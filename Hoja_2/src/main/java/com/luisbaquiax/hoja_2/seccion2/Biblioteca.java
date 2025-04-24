/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.luisbaquiax.hoja_2.seccion2;

import java.util.concurrent.Semaphore;

/**
 *
 * @author luis
 */
public class Biblioteca {
    private int cantidadAsientos;
    private Semaphore asientos;
    private int cantidadEstudiantes;
    
    public Biblioteca(int cantidadAsientos){
        this.cantidadAsientos = cantidadAsientos;
        this.asientos = new Semaphore(cantidadAsientos);
        this.cantidadEstudiantes = 0;
    }
    
    public void entrar(String estudiante){
        try {
            System.out.println(estudiante + " intenta entrar a la biblioteca");
            asientos.acquire();
            
            synchronized (this) {
                cantidadEstudiantes++;
                System.out.println(estudiante + " ha entrado a la biblioteca");
            }
            Thread.sleep(2000);
            synchronized (this) {
                cantidadEstudiantes++;
                System.out.println(estudiante + " ha salido a la biblioteca");
            }
            asientos.release();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
