package com.fox.encapsulation;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stephen on 8/5/2016.
 */
public class AttemptWithExceptionTest {

  @Test
  public void getResult() throws Exception {

  }

  @Test
  public void getError() throws Exception {
    AttemptWithException<String, IndexOutOfBoundsException> stringAttempt =
        new AttemptWithException<>("String", new IndexOutOfBoundsException());

  }

  @Test
  public void wasSuccessful() throws Exception {

  }

  @Test
  public void evaluateVoid() {

    final AttemptWithException<Void, RuntimeException> stringOutOfBounds =
        AttemptWithException.evaluate("String", (s) -> System.out.println(s.charAt(-1)));

    Assert.assertFalse("Should not have succeeded", stringOutOfBounds.wasSuccessful());

    Assert.assertSame("Should be an IndexOutOfBoundsException",
        StringIndexOutOfBoundsException.class, stringOutOfBounds.getError().getClass());
  }

}