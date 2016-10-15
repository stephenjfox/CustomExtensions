package com.fox.encapsulation;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests against the VolatileAction, independent of the {@link AttemptWithException} functionality
 *
 * Created by Stephen on 10/15/2016.
 */
public class VolatileActionTest {

  @Test(expected = StringIndexOutOfBoundsException.class)
  public void accept() {
    VolatileAction<String, StringIndexOutOfBoundsException> testAction =
        (string) -> System.out.println(string.charAt(-1)); // this throws

    testAction.accept("Test");
  }

  @Test
  public void andThenTest() {
    VolatileAction<String, StringIndexOutOfBoundsException> testAction =
        ( (VolatileAction<String, StringIndexOutOfBoundsException>) (string) -> System.out.println(string.charAt(1)) )
    .andThen((string) -> System.out.println("Hello: " + string));

    testAction.accept("Test string");
  }

  @Test(expected = NullPointerException.class)
  public void andThenTestThrows() {
    // this doesn't throw
    VolatileAction<String, StringIndexOutOfBoundsException> testAction =
        ( (VolatileAction<String, StringIndexOutOfBoundsException>)
            (string) -> System.out.println("Test charAt(): " + string.charAt(5)) )
            .andThen((string) -> System.out.println("Hello: " + string));

    // this does
    testAction.andThen((s) -> ( (String) null ).isEmpty())
        .accept("Test string");
  }
}