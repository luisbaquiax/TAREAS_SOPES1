package org.sopes.ejercicio4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Recurso {

    private String nombre;

    private ReentrantLock lock = new ReentrantLock();

    public Recurso(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void bloquearRecurso(Recurso recurso) {
        boolean lockActual = false;
        boolean lockOtro = false;

        try {
            lockActual = lock.tryLock(100, TimeUnit.MILLISECONDS);
            if (lockActual) {
                System.out.println(Thread.currentThread().getName() + " ha bloqueado " + this.nombre);

                Thread.sleep(100);

                lockOtro = recurso.lock.tryLock(100, TimeUnit.MILLISECONDS);
                if (lockOtro) {
                    System.out.println(Thread.currentThread().getName() + " ha bloqueado " + recurso.getNombre());
                } else {
                    System.out.println(Thread.currentThread().getName() + " no pudo bloquear " + recurso.getNombre());
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " no pudo bloquear " + this.nombre);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Liberar los locks adquiridos
            if (lockOtro) {
                recurso.lock.unlock();
            }
            if (lockActual) {
                lock.unlock();
            }
        }
    }
}
