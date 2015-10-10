package com.fox.collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

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

    public static <typeLeft, typeRight> Tuple<typeLeft, typeRight> create( typeLeft i1, typeRight i2 )
    {
        return new Tuple<>(i1, i2);
    }

    public static <T1, T2> Iterable<Tuple<T1, T2>> zip( Iterable<T1> t1Iterable, Iterable<T2> t2Iterable ) {

        Iterator<T1> iterator = t1Iterable.iterator();
        Iterator<T2> iterator1 = t2Iterable.iterator();

        return zip(iterator, iterator1);
    }

    private static <T1, T2> Iterable<Tuple<T1, T2>> zip( Iterator<T1> iterator, Iterator<T2> iterator1 ) {

        Objects.requireNonNull(iterator);
        Objects.requireNonNull(iterator1);

        LinkedList<Tuple<T1, T2>> list = new LinkedList<>();

        while ( iterator.hasNext() && iterator1.hasNext() ) {

            list.add(create(iterator.next(), iterator1.next()));

        }

        return list;
    }
}


