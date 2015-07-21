package by.intexsoft.random;

import java.util.Random;

/**
 * Created by Admin on 21.07.2015.
 */
public class Randomize {
    private static Random random = new Random();
    public static int randInt(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }
}
