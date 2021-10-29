package io.github.racoondog.seasonalmobs.util;

import java.util.Random;

public class Math {
    private static final Random random = new Random();

    public static int randomNumberInRange(int min, int max) {
        return random.nextInt(max - min) + min;
    }
}
