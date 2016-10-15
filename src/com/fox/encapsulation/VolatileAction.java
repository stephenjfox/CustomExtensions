package com.fox.encapsulation;

import java.util.Objects;

/**
 * Akin to the {@link java.util.function.Consumer}, but supporting a 'throw' to interweave into the
 * {@link AttemptWithException} architecture
 *
 * @see java.util.function.Consumer for more on documenation and expected behavior
 *
 * Created by Stephen on 8/5/2016.
 */
@FunctionalInterface
public interface VolatileAction<T, E extends Throwable> {
  void accept(T t) throws E;

  default VolatileAction<T, E> andThen(VolatileAction<? super T, ? extends E> after) {
    Objects.requireNonNull(after);
    return (T t) -> { accept(t); after.accept(t); };
  }
}
