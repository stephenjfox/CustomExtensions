package com.fox.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by stephen on 4/15/15.
 */
public class Arrays2 {
    public static <T> String MyToString( Iterable<T> objArray )
    {
        StringBuilder concat = new StringBuilder("[ ");
        objArray.forEach(o -> {
            concat.append(o).append(" ");
        });

        return concat.toString();
    }

    public static <T> T[] reverse( T[] array, int currInd )
    {
        if ( currInd != ( array.length / 2 ) ) {
            T left = array[currInd], right = array[array.length - 1 - currInd];
            array[array.length - 1 - currInd] = left;
            array[currInd] = right;
            reverse(array, currInd + 1);
        }
        return array;
    }

    public static <T> int linearSearch( T[] arr, T seek )
    {
        for ( int i = 0; i < arr.length; i++ )
            if ( arr[i].equals(seek) ) return i;

        return -1;
    }

    public static <T> T[] concat( T[] left, T[] right ) {

        List<T> list = new ArrayList<>();
        Arrays.stream(left).forEach(list::add);
        Arrays.stream(right).forEach(list::add);

        return list.toArray(left.clone());
    }
}
