package com.fox.general;

import com.fox.collections.Tuple;

/**
 * Created by stephen on 7/29/15.
 */
public class LongExtension {

    public static Tuple<Boolean, Long> tryParse(String str) {

        try {
            Long l = Long.parseLong(str);
            return Tuple.create(true, l);
        }
        catch (Exception e) {
            return Tuple.create(false, null);
        }

    }

}
