package com.fox.collections;

/**
 * Created by stephen on 4/15/15.
 */
public class Tuple<T1, T2>
{
    public final T1 item1;
    public final T2 item2;

    public Tuple( T1 item1, T2 item2 )
    {
        this.item1 = item1;
        this.item2 = item2;
    }

    public static <typeLeft, typeRight> Tuple<typeLeft, typeRight> Create( typeLeft i1, typeRight i2 )
    {
        return new Tuple<>(i1, i2);
    }
}


