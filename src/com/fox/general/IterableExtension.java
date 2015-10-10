package com.fox.general;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by stephen on 7/23/15.
 */
public class IterableExtension {

    public static <T1, T2> Iterable<T2> map( Iterable<T1> t1s, Function<T1, T2> f ) {

        List<T2> collected = new ArrayList<>();

        t1s.forEach(x -> collected.add(f.apply(x)));

        return collected;
    }

    public static <T> Iterable<T> concat( Iterable<? extends T>... iterables ) {

        LinkedList<T> list = new LinkedList<>();

        for ( Iterable<? extends T> iterable : iterables ) {
            if ( iterable != null ) {
                iterable.forEach(list::add);
            }
        }

        return list;
    }
}
