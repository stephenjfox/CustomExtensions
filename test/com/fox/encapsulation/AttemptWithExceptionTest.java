package com.fox.encapsulation;

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
  public void evaluate() throws Exception {

  }

}