package com.fox.util.math;

/**
 * Created by Stephen on 5/28/2015.
 */
public abstract class Vector
{
    private final double[] values;

    public Vector(double xComp, double yComp, double zComp)
    {
        this.values = new double[3];
        this.values[0] = xComp;
        this.values[1] = yComp;
        this.values[2] = zComp;
    }

    public Vector(double... components)
    {
        this.values = components;
    }

    public Vector(Vector vector)
    {
        this.values = vector.values;
    }

}
