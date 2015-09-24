package com.fox.collections;

import java.util.Map;

/**
 * Created by stephen on 4/15/15.
 */
public class MapExtension
{
    public static <T extends Comparable, U extends Comparable> void
    printKeyValuePairs( Map<T, U> dict )
    {
        for ( Map.Entry<T, U> keyValPair : dict.entrySet() )
        {
            System.out.printf("%s: %s", keyValPair.getKey(), keyValPair.getValue());
        }
    }
}
