package com.fox.collections;

/**
 * Created by stephen on 12/3/15.
 */
public interface ReversibleIterable<T> extends Iterable<T> {
  @Override
  ReversibleIterator<T> iterator();
}
