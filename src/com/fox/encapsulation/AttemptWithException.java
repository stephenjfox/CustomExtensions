package com.fox.encapsulation;

import com.fox.collection.Tuple;

/**
 * An encapsulation - in the vein of {@link java.util.Optional} - for exceptional operations.
 * This idea was motivated by a need to avoid try-catch code (which makes for inconsistencies in
 * declaring variables {@code final} in scope
 *
 * Created by Stephen on 8/5/2016. Under MIT license (see /LICENSE)
 */
public final class AttemptWithException<RET_TYPE, ERR_TYPE extends Throwable> {

  private final RET_TYPE result;
  private final ERR_TYPE error;

  AttemptWithException(RET_TYPE result, ERR_TYPE error) {
    this.result = result;
    this.error = error;
  }

  public RET_TYPE getResult() {
    return result;
  }

  public ERR_TYPE getError() {
    return error;
  }

  public boolean wasSuccessful() {
    return error == null;
  }

  public static <RET, E extends Throwable>
  AttemptWithException<? extends RET, E> evaluate(Getter<RET, E> getter) {
    AttemptWithException<RET, E> withException;
    try {
      withException = new AttemptWithException<>(getter.get(), null);
    } catch (Throwable somethingExceptional) {
      withException = new AttemptWithException<>(null, (E) somethingExceptional);
    }
    return withException;
  }

  public static <RET1, RET2, E extends Throwable>
  AttemptWithException<Tuple<? extends RET1, ? extends RET2>, E> evaluate(
      Getter2<RET1, RET2, E> getter) {
    AttemptWithException<Tuple<? extends RET1, ? extends RET2>, E> withException;
    try {
      withException = new AttemptWithException<>(getter.get(), null);
    } catch (Throwable somethingExceptional) {
      withException = new AttemptWithException<>(null, (E) somethingExceptional);
    }

    return withException;
  }

  public static <RET1, RET2, RET3, E extends Throwable>
  AttemptWithException<Tuple.Triple<? extends RET1, ? extends RET2, ? extends RET3>, E> evaluate(
      Getter3<RET1, RET2, RET3, E> getter) {
    AttemptWithException<Tuple.Triple<? extends RET1, ? extends RET2, ? extends RET3>, E> withException;
    try {
      withException = new AttemptWithException<>(getter.get(), null);
    } catch (Throwable somethingExceptional) {
      withException = new AttemptWithException<>(null, (E) somethingExceptional);
    }

    return withException;
  }

  /**
   * Executes the (potentially) throwing action and encapsulates the success.
   * When an {@code action} succeeds the void result isn't captured, thus the encapsulating
   * return value {@link AttemptWithException#getResult()} will be null.
   * If it fails, you will have an encapsulation of the {@link Throwable}
   *
   * @param input to feed into the action
   * @param action potentially throwing action
   * @param <T> input type
   * @param <E> exception type that CAN occur
   */
  public static <T, E extends Throwable>
  AttemptWithException<Void, E> evaluate(T input, VolatileAction<T, E> action) {
    AttemptWithException<Void, E> withException;
    try {
      action.accept(input);
      withException = new AttemptWithException<>(null, null);
    } catch (Throwable somethingExceptional) {
      withException = new AttemptWithException<>(null, (E) somethingExceptional);
    }
    return withException;
  }
}
