package com.fox.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by stephen on 4/15/15.
 */
public class ListExtension {
  public static <T> void printContents(List<T> list) {
    list.forEach(System.out::println);

    System.out.println();
  }

  public static <T> int countNonNulls(List<T> list) {
    int count = 0;
    for (T item : list) {
      if (item != null) count++;
    }
    return count;
  }

  public static <T> ArrayList<T> newArrayList() {
    return new ArrayList<>();
  }

  public static <T> ArrayList<T> newArrayList(T... items) {
    ArrayList<T> retList = new ArrayList<>();

    Collections.addAll(retList, items);

    return retList;
  }

  public static <T> ArrayList<T> newArrayList(Iterable<T> items) {
    ArrayList<T> list = new ArrayList<>();
    items.forEach(list::add);

    return list;
  }

  public static <T> ArrayList<T> newArrayList(Iterator<T> iterator) {
    ArrayList<T> list = new ArrayList<>();
    iterator.forEachRemaining(list::add);

    return list;
  }
}
