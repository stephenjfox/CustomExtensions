package com.fox.general;

import com.fox.collections.Tuple;

/**
 * Created by stephen on 7/29/15.
 */
public class NumberExtension {

    public static boolean isNumber( String string ) {
        return isNumber(string, 10);
    }

    public static boolean isNumber( String potential, int radix ) {
        Tuple<Boolean, Short> booleanShortTuple = ShortExtension.tryParse(potential, radix);
        if ( booleanShortTuple.first ) {
            return true;
        }
        else {
            Tuple<Boolean, Integer> booleanIntegerTuple = IntegerExtension.tryParse(potential, radix);
            if ( booleanIntegerTuple.first ) {
                return true;
            }
            else {
                return LongExtension.tryParse(potential, radix).first;
            }
        }
    }
}
