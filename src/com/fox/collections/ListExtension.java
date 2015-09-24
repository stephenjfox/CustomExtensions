package com.fox.collections;

import java.util.List;

/**
 * Created by stephen on 4/15/15.
 */
public class ListExtension
{
    public static <T> void printContents(List<T> list)
    {
        list.forEach(System.out::println);

        System.out.println();
    }

    public static <T> int countNonNulls(List<T> list)
    {
        int count = 0;
        for ( T item : list )
        {
            if (item != null) count++;
        }
        return count;
    }
}
