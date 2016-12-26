package com.fox.encapsulation;

/**
 * Lockable instance that allows a single mutation before it's value becomes effectively final,
 * or otherwise immutable.
 * Calling {@code lock} before a mutation operation seals the class prematurely.
 *
 * Created by Stephen on 10/13/2016.
 */
public class Mutable1<T> extends Mutable<T> {

  private static final int MUTATION_ALLOWANCE = 1;

  public Mutable1() {
    this(null);
  }

  public Mutable1(T value) {
    super(value, MUTATION_ALLOWANCE);
  }

}
