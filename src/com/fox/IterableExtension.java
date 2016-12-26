package com.fox;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

import static com.fox.general.Predication.existenceCheck;

/**
 * {@link LinkedList}s are the returned Iterables, because they are structured for head-to-tail
 * iteration.
 * Created by stephen on 7/23/15.
 */
public class IterableExtension {

  public static <T1, T2> Iterable<T2> map(Iterable<T1> t1s, Function<T1, T2> f) {

    List<T2> collected = new LinkedList<>();

    for (T1 t1 : t1s) {
      collected.add(f.apply(t1));
    }

    return collected;
  }

  @SafeVarargs
  public static <T> Iterable<T> concat(Iterable<? extends T>... iterables) {

    LinkedList<T> list = new LinkedList<>();
    // Perhaps a custom iterable type that has .cast methods of it?

    for (Iterable<? extends T> iterable : iterables) {
      if (iterable != null) {
        iterable.forEach(list::add);
      }
    }

    return list;
  }

  /**
   * The effective complement to {@link Collection#removeIf(Predicate)}
   *
   * @param iterable       of items
   * @param searchFunction a predicate which returns {@code true} for elements to be
   *                       removed
   * @param <T> element type
   * @return {@code iterable} elements that are acceptable to the {@code searchFunction}
   */
  public static <T> Iterable<T> findAll(Iterable<T> iterable, Predicate<? super T> searchFunction) {
    existenceCheck(iterable, new IllegalArgumentException("iterable"));
    existenceCheck(iterable, new IllegalArgumentException("searchFunction"));

    Collection<T> matched = new LinkedList<>();

    for (T element : iterable) {
      if (searchFunction.test(element)) matched.add(element);
    }

    return matched;
  }

  public static <T> Iterable<T> range(Iterable<T> collection, int startIndex, int count) {
    existenceCheck(collection, new IllegalArgumentException("collection"));

    return take(skip(collection, startIndex), count);
  }

  public static <T> Iterable<T> take(Iterable<T> collection, int takeCount) {
    Collection<T> takenValues = new LinkedList<>();

    Iterator<T> iterator = collection.iterator();

    int count = 0;

    for (; iterator.hasNext() && count < takeCount; ) {
      takenValues.add(iterator.next());
      count++;
    }

    return takenValues;
  }

  public static <T> Iterable<T> skip(Iterable<T> collection, int skipCount) {
    existenceCheck(collection);
    if (skipCount == 0) return collection;

    int count = 0;
    Iterator<T> iterator = collection.iterator();

    while (iterator.hasNext() && count < skipCount) {
      iterator.next();
      count++;
    }

    Collection<T> collectionMinusSkip = new LinkedList<>();

    while (iterator.hasNext()) {
      collectionMinusSkip.add(iterator.next());
    }

    return collectionMinusSkip;
  }

  @SafeVarargs
  public static <T> Collection<T> flattenCollections(Collection<T>... collections) {
    Collection<T> aggregate = new ArrayList<>();

    for (Collection<T> collection : collections)
      aggregate.addAll(collection);

    return aggregate;
  }
}
