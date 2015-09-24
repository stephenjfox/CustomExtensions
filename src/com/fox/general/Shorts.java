package com.fox.general;

import com.fox.collections.Tuple;

/**
 * Created by stephen on 7/29/15.
 */
public class Shorts {

    public static Tuple<Boolean, Short> tryParse(String str) {

        try {
            Short s = Short.parseShort(str);
            return Tuple.Create(true, s);
        } catch (Exception e) {
            return Tuple.Create(false, null);
        }

    }

}
