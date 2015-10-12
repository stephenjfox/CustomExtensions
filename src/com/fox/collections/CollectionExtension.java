package com.fox.collections;

import com.fox.io.log.ConsoleLogger;
import com.fox.types.Classes;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.google.common.base.Preconditions.checkState;

/**
 * Created by stephen on 6/17/15.
 */
public class CollectionExtension {

    public static void classLoader() {
        try {
            Method[] myMethods = Class.forName("com.fox.collections.CollectionExtension").getDeclaredMethods();

            System.out.println("My CollectionExtension' class methods");
            for ( Method myMethod : myMethods ) {
                System.out.println(myMethod);
            }

        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static <T> boolean containsAll( Collection<T> a, Collection<T> b, boolean sequential ) {
        if ( sequential ) {
            return containsAllSequential(a, b);
        }
        else {
            boolean contains = false;

            for ( T t : b ) {
                contains = a.contains(t);
            }
            return contains;
        }
    }

    public static <T> boolean containsAllSequential( Collection<T> a, Collection<T> b ) {

        Iterator<T> left  = a.iterator();
        Iterator<T> right = b.iterator();

        T left_Curr = left.next(), right_Curr = right.next();

        while ( left.hasNext() && left_Curr != right_Curr)
            left_Curr = left.next(); // find the first match to check the sequence.

        try {
            checkState(left.hasNext()); // If we've gone the entiritey of our first collection.

            for (; left.hasNext() && right.hasNext();
                 left_Curr = left.next(), right_Curr = right.next()) {
                if (left_Curr != right_Curr) return false;
            }

            return true;
        }
        catch (Exception e) {

            System.err.println("The first collection never found the start of the second collection");
            return false;
        }

        /*
        // this is cute, but unnecessary
        return new Object() { // this is how we do inline-methods in Java. I think it's funny

            boolean go() {

                Iterator<T> left  = a.iterator();
                Iterator<T> right = b.iterator();

                T left_Curr = left.next(), right_Curr = right.next();

                while ( left.hasNext() && left_Curr != right_Curr)
                    left_Curr = left.next(); // find the first match to check the sequence.

                try {
                    checkState(left.hasNext()); // If we've gone the entiritey of our first collection.

                    for (; left.hasNext() && right.hasNext();
                         left_Curr = left.next(), right_Curr = right.next()) {
                        if (left_Curr != right_Curr) return false;
                    }

                    return true;
                }
                catch (Exception e) {

                    System.err.println("The first collection never found the start of the second collection");
                    return false;
                }

            }

        }.go();*/
    }

    // TODO: Provide a better implementation than Collectors.toList(), which is "good enough"
    public static <E, T extends E> Collection<T> cast( Collection<E> collection ) throws ClassCastException {
        return collection.stream().map(e -> (T) e).collect(Collectors.toList());
    }

    public static <E, T extends E> Collection<T> transform( Iterable<E> iterable, Function<? super E, T> function ) {
        return StreamSupport.stream(iterable.spliterator(), false).map(function).collect(Collectors.toList());
    }

        public static <E, T extends E> Collection<T> transform( Collection<E> collection, Function<? super E, T> function ) {
        return collection.stream().map(function).collect(Collectors.toList());
    }

    public static <E> Collection<E> from( Iterable<E> iterable ) {

        if (iterable instanceof Collection) return (Collection<E>) iterable;

        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    public static <E, T extends E, C extends Collection<T>> C castBetter( Collection<E> collection ) {
//        Type preliminarySuperType = Classes.getPreliminarySuperType(collection.getClass());
        try {
            return (C) Classes.dotClass(collection).getConstructor(Collection.class).newInstance(collection);
        }
        catch (NoSuchMethodException e) {
            ConsoleLogger.exception(e, "No method could be found");
        }
        catch (InvocationTargetException e) {
            ConsoleLogger.exception(e, "Invocation target was invalid... Probably");
        }
        catch (InstantiationException e) {
            ConsoleLogger.exception(e, "Instantiation exception... Whatever that is\n");
        }
        catch (IllegalAccessException e) {
            ConsoleLogger.exception(e, "Constructor was inaccessible");
        }
        return null;
    }

}
