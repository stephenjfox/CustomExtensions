package com.fox.util.math;

/**
 * Created by stephen on 5/26/15.
 */
public class FoxMath {

    /**
     * Computes the complimentary angle for the input
     * @param angleA
     * @return the angle that would sum the angle
     */
    public static double compAngle( double angleA ) {

        if (angleA > 90) angleA -= 90;

        return 90 - angleA;
    }


}
