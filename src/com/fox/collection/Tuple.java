package com.fox.collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Created by stephen on 4/15/15.
 */
public class Tuple<T1, T2> {
  public final T1 first;
  public final T2 second;

  private Tuple(T1 item1, T2 item2) {
    this.first = item1;
    this.second = item2;
  }

  public static <T1> Unit<T1> create(T1 item) {
    return new Unit<>(item);
  }

  public static <T1, T2, T3> Triple<T1, T2, T3> create(T1 item1, T2 item2, T3 item3) {
    return new Triple<>(item1, item2, item3);
  }

  public static <T1, T2, T3, T4> Quadruple<T1, T2, T3, T4> create(T1 item1, T2 item2, T3 item3, T4 item4) {
    return new Quadruple<>(item1, item2, item3, item4);
  }

  public static <T1, T2, T3, T4, T5> Quintuple<T1, T2, T3, T4, T5> create(T1 item1, T2 item2, T3 item3, T4 item4, T5 item5) {
    return new Quintuple<>(item1, item2, item3, item4, item5);
  }

  public static <T1, T2> Iterable<Tuple<T1, T2>> zip(Iterable<T1> t1Iterable, Iterable<T2> t2Iterable) {

    Iterator<T1> iterator = t1Iterable.iterator();
    Iterator<T2> iterator1 = t2Iterable.iterator();

    return zip(iterator, iterator1);
  }

  public static <T1, T2> Iterable<Tuple<T1, T2>> zip(Iterator<T1> iterator, Iterator<T2> iterator1) {

    Objects.requireNonNull(iterator);
    Objects.requireNonNull(iterator1);

    LinkedList<Tuple<T1, T2>> list = new LinkedList<>();

    while (iterator.hasNext() && iterator1.hasNext()) {

      list.add(create(iterator.next(), iterator1.next()));

    }

    return list;
  }

  public static <T1, T2> Tuple<T1, T2> create(T1 item1, T2 item2) {
    return new Tuple<>(item1, item2);
  }

  @Override
  public String toString() {
    return String.format("( %s, %s )", first, second);
  }

  //////////////////////////////////////////////////
  /// Inner Tuple children types
  //////////////////////////////////////////////////

  public static class Unit<T1> {
    public final T1 item;

    private Unit(T1 item) {
      this.item = item;
    }

    @Override
    public String toString() {
      return String.format("( %s )", item);
    }
  }

  public static class Triple<T1, T2, T3> extends Tuple<T1, T2> {

    public final T3 third;

    private Triple(T1 item1, T2 item2, T3 item3) {
      super(item1, item2);
      this.third = item3;
    }

    @Override
    public String toString() {
      return String.format("( %s, %s, %s )", first, second, third);
    }

  }

  public static class Quadruple<T1, T2, T3, T4> extends Tuple<T1, T2> {
    public final T3 third;

    public final T4 fourth;

    private Quadruple(T1 item1, T2 item2, T3 item3, T4 item4) {
      super(item1, item2);
      this.third = item3;
      this.fourth = item4;
    }

    @Override
    public String toString() {
      return String.format("( %s, %s, %s, %s )", first, second, third, fourth);
    }

  }

  public static class Quintuple<T1, T2, T3, T4, T5> extends Tuple<T1, T2> {
    public final T3 third;
    public final T4 fourth;

    public final T5 fifth;

    private Quintuple(T1 item1, T2 item2, T3 item3, T4 item4, T5 item5) {
      super(item1, item2);
      this.third = item3;
      this.fourth = item4;
      this.fifth = item5;
    }

    @Override
    public String toString() {
      return String.format("( %s, %s, %s, %s, %s )", first, second, third, fourth, fifth);
    }

  }
}


