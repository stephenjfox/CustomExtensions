package com.fox.encapsulation;

/**
 * Created by Stephen on 12/26/2016.
 */
public abstract class Mutable<T> implements Lockable {

  private final int allowedMutations;
  private T value;
  private int mutationCount;

  public Mutable(final T value, final int mutationLimit) {
    this.value = value;
    this.allowedMutations = mutationLimit;
  }

  @Override
  public void lock() {
    this.mutationCount = allowedMutations;
  }

  public T get() {
    return value;
  }

  public void set(final T value) {
    if (allowedMutations > mutationCount) {
      this.value = value;
      mutationCount++;
    }
  }

  public int getMutationAllowance() {
    return allowedMutations;
  }

  public int getMutationCount() {
    return mutationCount;
  }
}
