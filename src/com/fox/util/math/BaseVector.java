package com.fox.util.math;

/**
 * Created by Stephen on 5/28/2015.
 */
public abstract class BaseVector
{
    private final double[] values;

    public BaseVector( double xComp, double yComp, double zComp )
    {
        this.values = new double[3];
        this.values[0] = xComp;
        this.values[1] = yComp;
        this.values[2] = zComp;
    }

    public BaseVector( double... components )
    {
        this.values = components;
    }

    public BaseVector( BaseVector baseVector )
    {
        this.values = baseVector.values;
    }

}
