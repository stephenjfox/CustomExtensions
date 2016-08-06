package com.fox.function;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Basic function that returns without parameter. Have a likeness to
 * {@link Supplier}
 *
 * Created by Stephen on 8/5/2016.
 */
@FunctionalInterface
public interface Getter<T> {
  /**
   * This should be an idempotent action, due to other implementations.
   * If the end user supplied lambda does external data access (for you FP
   * developers, has "side-effects"), the burden is left to the developer
   *
   * @return an instance of the backed type.
   */
  T get();

  /**
   * This function is the slowest of this set of supporting function,
   * but exist if your API is built around {@link java.util.function.Function}
   * you can do this slower operation once.
   *
   * @param <B> is ignored, and should just be passed as {@code null}
   * @return
   */
  default <B> Function<B, T> asFunction() {
    return b -> this.get();
  }

  default Supplier<T> asSupplier() {
    return this::get;
  }

  static <T> Getter<T> fromSupplier(Supplier<T> supplier) {
    return supplier::get;
  }
}