package com.fox.collections;

import java.lang.reflect.Array;

import static com.fox.general.PredicateTests.existenceCheck;

/**
 * Created by stephen on 4/15/15.
 */
public class ArrayExtension {
  public static <T> String stringify(Iterable<T> objArray) {
    StringBuilder concat = new StringBuilder("[ ");
    boolean first = true;
    for (T t : objArray) {
      if (!first) concat.append(", ");

      concat.append(String.format("`%s`", t));

      if (first) first = false;
    }

    concat.append(" ]");

    return concat.toString();
  }

  public static <T> T[] reverse(T[] array, int currInd) {
    if (currInd != ( array.length / 2 )) {
      T left = array[currInd], right = array[array.length - 1 - currInd];
      array[array.length - 1 - currInd] = left;
      array[currInd] = right;
      reverse(array, currInd + 1);
    }
    return array;
  }

  public static <T> int linearSearch(T[] arr, T seek) {
    for (int i = 0, j = arr.length; i < j; i++)
      if (arr[i].equals(seek)) return i;

    return -1;
  }

  public static <T> T[] concat(T[] left, T[] right) {

    existenceCheck(left);
    existenceCheck(right);

    int totalLength = left.length + right.length;
    T[] retArr = (T[]) Array.newInstance(left.getClass().getComponentType(), totalLength);

    System.arraycopy(left, 0, retArr, 0, left.length);
    System.arraycopy(right, 0, retArr, left.length, right.length);

    return retArr;
  }
}
