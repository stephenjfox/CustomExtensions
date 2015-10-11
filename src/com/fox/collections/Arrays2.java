package com.fox.collections;

import java.lang.reflect.Array;

/**
 * Created by stephen on 4/15/15.
 */
public class Arrays2 {
    public static <T> String myToString( Iterable<T> objArray )
    {
        StringBuilder concat = new StringBuilder("[ ");
        objArray.forEach(o -> concat.append(o).append(" "));

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

        /*
        // This logic works, but it's heavy and slower at larger N values
        List<T> list = new ArrayList<>();
        Arrays.stream(left).forEach(list::add);
        Arrays.stream(right).forEach(list::add);
        */

        int totalLength = left.length + right.length;
        T[] retArr = (T[]) Array.newInstance(left.getClass().getComponentType(), totalLength);

        System.arraycopy(left, 0, retArr, 0, left.length);
        System.arraycopy(right, 0, retArr, left.length, right.length);
        /*
        // The above should duplicate the below
        for ( int i = 0, j = right.length; i < j; i++ ) {
            int offset = i + left.length;
            retArr[(offset)] = right[i];
        }*/

        return retArr;
    }
}
