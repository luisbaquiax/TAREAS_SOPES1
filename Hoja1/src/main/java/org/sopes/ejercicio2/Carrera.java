package org.sopes.ejercicio2;

import org.sopes.Utiles;

public class Carrera implements Runnable {

    private Corredor corredor;
    private int distancia;
    private int meta;
    private StringBuffer recorrido;
    private String simbolo;

    public Carrera(Corredor corredor, String simbolo) {
        this.corredor = corredor;
        this.distancia = 0;
        this.meta = 100;
        this.recorrido = new StringBuffer();
        this.simbolo = simbolo;
    }

    @Override
    public void run() {
        while (distancia < meta) {
            int pasos = Utiles.numeroAleatorio(1, 5);
            actualizarRecorrido(pasos);
            distancia += pasos;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("************************** FIN DE LA CARRERA **************************");
    }

    private void actualizarRecorrido(int pasos) {
        System.out.println("-".repeat(100));
        for (int i = 0; i < pasos; i++) {
            this.recorrido.append(simbolo);
        }
        System.out.println(this.recorrido);
    }
}
