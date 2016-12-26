package com.fox.encapsulation;

/**
 * The base of our hierarchy, using the behavioral {@link Lockable} for expediting behavior of
 * finality.
 * Created by Stephen on 12/26/2016.
 */
public abstract class Mutable<T> implements Lockable {

  private final int allowedMutations;
  private T value;
  private int mutationCount;

  Mutable(final T value, final int mutationLimit) {
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

  public static <T> Mutable<T> of(final T initial, final int allowedMutations) {
    return new MutableOfN<T>(initial, allowedMutations);
  }

  private static class MutableOfN<T> extends Mutable<T> {
    public MutableOfN(final T initial, final int allowedMutations) {
      super(initial, allowedMutations);
    }
  }
}
