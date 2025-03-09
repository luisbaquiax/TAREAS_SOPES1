package org.sopes;

import java.util.Random;

public class Utiles {

    public static int numeroAleatorio(int min, int max) {
        Random random = new Random();
        return min + random.nextInt(max - min);
    }
}
