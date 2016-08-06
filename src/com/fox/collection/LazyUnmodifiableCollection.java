package com.fox.collection;

import java.util.AbstractCollection;
import java.util.Iterator;

/**
 * Its name describes its exact function: transition from the modifiable state to unmodifiable.
 * Created by Stephen on 8/4/2016.
 */
public class LazyUnmodifiableCollection<E> extends AbstractCollection<E> {

  // TODO

  @Override
  public Iterator<E> iterator() {
    return null;
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  protected void finalize() throws Throwable {
    super.finalize();
  }
}
