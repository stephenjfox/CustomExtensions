package com.fox.general;

/**
 * Created by stephen on 11/17/15.
 */
public class PredicateTests {

    public static void isTrue( boolean check ) {
        if ( !check ) {
            throw new IllegalStateException();
        }
    }

    public static void existanceCheck( Object check) {
        if ( check == null ) {
            throw new IllegalStateException();
        }
    }

}
