package com.fox.general;

import com.fox.collections.Tuple;

/**
 * Created by stephen on 7/29/15.
 */
public class NumberExtension {

    public static boolean isNumber( String string ) {

        Tuple<Boolean, Short> booleanShortTuple = ShortExtension.tryParse(string);
        if ( booleanShortTuple.first ) {
            return true;
        } else {
            Tuple<Boolean, Integer> booleanIntegerTuple = IntegerExtension.tryParse(string);
            if ( booleanIntegerTuple.first ) {
                return true;
            }
            else {
                return LongExtension.tryParse(string).first;
            }
        }
    }
}
