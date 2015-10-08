package com.fox.collections;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;

import static com.google.common.base.Preconditions.checkState;

/**
 * Created by stephen on 6/17/15.
 */
public class Utilities {

    public static void classLoader() {
        try {
            Method[] myMethods = Class.forName("com.fox.collections.Utilities").getDeclaredMethods();

            System.out.println("My Utilities' class methods");
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

    private static <T> boolean containsAllSequential( Collection<T> a, Collection<T> b ) {

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

        }.go();
    }

}