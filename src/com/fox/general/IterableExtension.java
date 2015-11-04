package com.fox.general;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * FIXME: make this more general, such that there user isn't stuck with a "secret" LinkedList
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
        // Perhaps a custom iterable type that has .cast methods of it?

        for ( Iterable<? extends T> iterable : iterables ) {
            if ( iterable != null ) {
                iterable.forEach(list::add);
            }
        }

        return list;
    }

    public static <T> Iterable<T> findAll( Iterable<T> collection, Predicate<T> searchFunction )
    {
        Collection<T> matched = new LinkedList<>();

        if ( collection == null ) throw new IllegalArgumentException("collection");
        if ( searchFunction == null ) throw new IllegalArgumentException("searchFunction");

        for ( T element : collection ) {
            if ( searchFunction.test(element) ) matched.add(element);
        }

        return matched;
    }

    public static <T> Iterable<T> range( Iterable<T> collection, int startIndex, int count )
    {
        if ( collection == null ) throw new IllegalArgumentException("collection");

        return take(skip(collection, startIndex), count);
    }

    public static <T> Iterable<T> take( Iterable<T> collection, int takeCount )
    {
        Collection<T> takenValues = new LinkedList<>();

        Iterator<T> iterator = collection.iterator();

        int count = 0;

        for (; iterator.hasNext() && takeCount != count; ) {
            takenValues.add(iterator.next());
            count++;
        }

        return takenValues;
    }

    public static <T> Iterable<T> skip( Iterable<T> collection, int skipCount )
    {
        Collection<T> colMinusSkip = new LinkedList<>();

        int count = 0;

        for ( T item : collection ) {
            if ( count == skipCount ) colMinusSkip.add(item);
            else count++;
        }

        return colMinusSkip;
    }

    public static <T> Collection<T> flattenCollections( Collection<T>... collections )
    {
        Collection<T> aggregate = new ArrayList<>();

        for ( Collection<T> collection : collections )
            aggregate.addAll(collection);

        return aggregate;
    }
}
