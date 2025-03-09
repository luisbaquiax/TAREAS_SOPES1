package org.sopes.ejercicio3;

public class Recurso {

    private String nombre;

    public Recurso(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public synchronized void bloquearRecurso(Recurso recurso) {
        System.out.println(Thread.currentThread().getName() + " bloquea el recurso " + this.nombre);

        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " intenta bloquear el recurso " + recurso.getNombre());
        recurso.bloquearRecurso(this);
    }
}
