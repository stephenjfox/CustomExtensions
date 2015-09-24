package com.fox.general;

import com.fox.collections.Tuple;

/**
 * Created by stephen on 7/29/15.
 */
public class Numbers {

    public static boolean isNumber( String string ) {

        Tuple<Boolean, Short> booleanShortTuple = Shorts.tryParse(string);
        if ( booleanShortTuple.item1) {
            return true;
        } else {
            Tuple<Boolean, Integer> booleanIntegerTuple = Integers.tryParse(string);
            if ( booleanIntegerTuple.item1) {
                return true;
            }
            else {
                return Longs.tryParse(string).item1;
            }
        }
    }
}
