package com.fox.general;

import com.fox.collections.Tuple;

/**
 * Created by stephen on 7/29/15.
 */
public class Integers {

    public static Tuple<Boolean, Integer> tryParse(String str) {

        try {
            Integer i = Integer.parseInt(str);
            return Tuple.create(true, i);
        }
        catch (Exception e) {
            return Tuple.create(false, null);
        }

    }

}
