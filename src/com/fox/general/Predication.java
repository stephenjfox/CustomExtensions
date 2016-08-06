package com.fox.general;

/**
 * Statically import these into your code for more human readability.
 * Created by stephen on 11/17/15.
 */
public class Predication {

  public static void isTrue(boolean check) {
    if (!check) {
      throw new IllegalStateException();
    }
  }

  public static void existenceCheck(Object check) {
    if (check == null) {
      throw new NullPointerException();
    }
  }

  public static <R extends RuntimeException>
  void existenceCheck(Object check, R exceptionToThrow) {
    if (check == null)
      throw exceptionToThrow;
  }

  public static void isFalse(boolean value) {
    if (value) {
      throw new IllegalStateException("State shouldn't be true. TRY AGAIN!");
    }
  }

}
