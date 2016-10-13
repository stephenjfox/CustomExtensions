package com.fox.encapsulation;

/**
 * Lockable instance that allows a single mutation before it's value becomes effectively final,
 * or otherwise immutable.
 * Calling {@code lock} before a mutation operation seals the class prematurely.
 *
 * Created by Stephen on 10/13/2016.
 */
public class Mutable1<T> implements Lockable {

  private static final int MUTATION_ALLOWANCE = 1;
  private T value;
  private short mutationCount = 0;

  public Mutable1() {
    this(null);
  }

  public Mutable1(T value) {
    this.value = value;
  }

  @Override
  public void lock() {
    mutationCount = MUTATION_ALLOWANCE;
  }

  public T get() {
    return value;
  }

  public void set(T value) {
    if (MUTATION_ALLOWANCE > mutationCount++) {
      this.value = value;
    }
  }
}
