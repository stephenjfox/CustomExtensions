package com.fox.collection;

import java.util.Iterator;

/**
 * Created by stephen on 12/3/15.
 */
public interface ReversibleIterator<T> extends Iterator<T> {
  boolean canReverseNext();

  T reverseNext();

  void skipToEnd();
}
