package com.fox.function;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Proof that the Getter behaves as documented
 *
 * Created by Stephen on 8/5/2016.
 */
public class GetterTest {

  private Getter<String> testGetter;

  @Before
  public void setup() {
    testGetter = () -> "Test message";
  }

  @Test
  public void get() throws Exception {

    String get = testGetter.get();

    Assert.assertEquals("Our property shouldn't change as it's transferred",
        "Test message", get);
  }

  /**
   * Proof that this function is slow.
   *
   * @throws Exception
   */
  @Test
  public void asFunction() throws Exception {
    Function<Object, String> function = testGetter.asFunction();

    String apply = function.apply(null);
    String get = testGetter.get(); // backup for later

    Assert.assertEquals("Our property shouldn't change as it's transferred",
        "Test message", get);
    Assert.assertEquals("apply() should equal get()",
        get, apply);
  }

  @Test
  public void asSupplier() throws Exception {
    Supplier<String> supplier = testGetter.asSupplier();

    Assert.assertEquals("They should equate",
        testGetter.get(), supplier.get());
  }

  @Test
  public void fromSupplier1() throws Exception {
    Getter<Integer> getter = Getter.fromSupplier(() -> 12);

    Assert.assertEquals("getter.get() === 12", 12, getter.get().intValue());
  }

  /**
   * Testing the recursive consistency of the function
   */
  @Test
  public void fromSupplier2() {
    Getter<String> getter = Getter.fromSupplier(testGetter.asSupplier());

    Assert.assertEquals("Recursive calls shouldn't matter",
        testGetter.get(), getter.get());
  }

}