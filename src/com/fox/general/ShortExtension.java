package com.fox.general;

import com.fox.collections.Tuple;

/**
 * Created by stephen on 7/29/15.
 */
public class ShortExtension {

    public static Tuple<Boolean, Short> tryParse(String str) {

        try {
            Short s = Short.parseShort(str);
            return Tuple.create(true, s);
        } catch (Exception e) {
            return Tuple.create(false, null);
        }

    }

}
