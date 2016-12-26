package com.fox.encapsulation;

/**
 * Effectively final instance, allowing up to two mutations
 * Created by Stephen on 12/26/2016.
 */
public class Mutable2<T> extends Mutable<T> {

  public Mutable2() {super(null, 2);}

  public Mutable2(final T value) {
    super(value, 2);
  }
}
