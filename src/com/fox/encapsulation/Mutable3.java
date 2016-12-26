package com.fox.encapsulation;

/**
 * Effectively final instance, allowing up to three mutations
 * Created by Stephen on 12/26/2016.
 */
public class Mutable3<T> extends Mutable<T> {
  public Mutable3(final T value) {
    super(value, 3);
  }
}
