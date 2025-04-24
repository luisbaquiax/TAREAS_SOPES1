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
public class Banco {

    private Semaphore semaphore;

    public Banco(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public void entrar(String cliente) {
        try {
            System.out.println(cliente + " intenta entrar al banco...");
            semaphore.acquire();
            System.out.println(cliente + " ha ingresado al banco.");
            Thread.sleep(2000);
            System.out.println(cliente + " ha salido del banco.");
            semaphore.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
