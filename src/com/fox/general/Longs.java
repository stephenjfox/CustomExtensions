package com.fox.general;

import com.fox.collections.Tuple;

/**
 * Created by stephen on 7/29/15.
 */
public class Longs {

    public static Tuple<Boolean, Long> tryParse(String str) {

        try {
            Long l = Long.parseLong(str);
            return Tuple.Create(true, l);
        }
        catch (Exception e) {
            return Tuple.Create(false, null);
        }

    }

}
