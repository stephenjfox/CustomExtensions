package com.fox.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;

/**
 * Created by stephen on 4/15/15.
 */
public class EnumerableExtensions
{
    public static <T> Iterable<T> FindAll( Iterable<T> collection, Predicate<T> searchFunction )
    {
        Collection<T> matched = new ArrayList<>();

        if ( collection == null ) throw new IllegalArgumentException("collection");
        if ( searchFunction == null ) throw new IllegalArgumentException("searchFunction");

        for ( T element : collection )
        {
            if ( searchFunction.test(element) ) matched.add(element);
        }

        return matched;
    }

    public static <T> Iterable<T> Skip( Iterable<T> collection, int skipCount )
    {
        Collection<T> colMinusSkip = new ArrayList<>();

        int count = 0;

        for ( T item : collection )
        {
            if ( count == skipCount ) colMinusSkip.add(item);
            else count++;
        }

        return colMinusSkip;
    }

    public static <T> Iterable<T> Take( Iterable<T> collection, int takeCount )
    {
        Collection<T> takenValues = new ArrayList<>();

        Iterator<T> iterator = collection.iterator();

        int count = 0;

        for (; iterator.hasNext() && takeCount != count; )
        {
            takenValues.add(iterator.next());
            count++;
        }

        return takenValues;
    }

    public static <T> Iterable<T> Range( Iterable<T> collection, int startIndex, int count )
    {
        if ( collection == null ) throw new IllegalArgumentException("collection");

        return Take(Skip(collection, startIndex), count);
    }

    public static <T> Collection<T> FlattenCollections( Collection<T>... collections )
    {
        Collection<T> aggregate = new ArrayList<>();

        for ( Collection<T> collection : collections )
            aggregate.addAll(collection);

        return aggregate;
    }


}
