package com.fox.general;

import com.fox.collections.Tuple;

/**
 * Created by stephen on 7/29/15.
 */
public class ShortExtension {

    public static Tuple<Boolean, Short> tryParse(String str) {
        return tryParse(str, 10);
    }

    public static Tuple<Boolean, Short> tryParse( String string, int radix ) {

        try {
            Short s = Short.parseShort(string, radix);
            return Tuple.create(true, s);
        } catch (Exception e) {
            return Tuple.create(false, null);
        }

    }

}
