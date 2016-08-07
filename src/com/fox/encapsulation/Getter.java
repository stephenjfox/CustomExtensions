package com.fox.encapsulation;

/**
 * This getter is supportive of the composition-focused exception handling
 * system in this package
 * <p>
 * Created by Stephen on 8/5/2016.
 */
public interface Getter<T, E extends Throwable> {
  T get() throws E;
}
