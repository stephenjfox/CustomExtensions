package com.fox.util.math;

import java.util.Random;

/**
 * Created by stephen on 5/26/15.
 */
public class MathExtension {

    private static Random rGen = new Random();

    /**
     * Computes the complimentary angle for the input
     * @param angleA
     * @return the angle that would sum the angle
     */
    public static double complementaryAngle( double angleA ) {

        if (angleA > 90) angleA -= 90;

        return 90 - angleA;
    }

    public static void seedRandom(long seed) {
        rGen = new Random(seed);
    }

    public static int randomInt( int lowerBound, int upperBound ) {
        return randomInt(lowerBound, upperBound, true);
    }

    public static int randomInt( int lowerBound, int upperBound, boolean upperInclusive ) {
        return randomInt(lowerBound, upperBound, true, upperInclusive);
    }

    public static int randomInt( int lowerBound, int upperBound, boolean lowerInclusive, boolean upperInclusive ) {
        int low = lowerInclusive ? lowerBound : lowerBound + 1;
        int high = upperInclusive ? upperBound + 1 : upperBound;

        return rGen.nextInt(high - low) + low;
    }

}
