package com.fox.general;

import com.fox.collections.Tuple;

/**
 * Created by stephen on 7/29/15.
 */
public class IntegerExtension {

    public static Tuple<Boolean, Integer> tryParse(String str) {
        return tryParse(str, 10);
    }

    public static Tuple<Boolean, Integer> tryParse( String string, int radix ) {

        try {
            Integer anInt = Integer.parseInt(string, radix);
            return Tuple.create(true, anInt);
        } catch (Exception e) {
            return Tuple.create(false, null);
        }

    }

}
