package com.fox.encapsulation;

import org.junit.Test;

import static org.junit.Assert.*;

public class Mutable2Test {
  @Test
  public void getValue() {
    Mutable2<String> mutable2 = new Mutable2<>("cats");

    assertEquals("The same value is store", "cats", mutable2.get());
  }

  @Test
  public void getValueNull() {
    Mutable2<String> mutable2 = new Mutable2<>();

    assertEquals("The same value is store", null, mutable2.get());
  }

  @Test
  public void setValueOnce() {
    Mutable2<String> mutable2 = new Mutable2<>("cats");

    assertEquals("The same value is store", "cats", mutable2.get());

    mutable2.set("foxes");

    assertEquals("There should be a change", "foxes", mutable2.get());
  }

  @Test
  public void setValueMax() {
    Mutable2<String> mutable2 = new Mutable2<>("cats");

    assertEquals("The same value is store", "cats", mutable2.get());

    mutable2.set("foxes");

    assertEquals("There should be a change", "foxes", mutable2.get());

    mutable2.set("잘 딸리다");

    assertEquals("There should be a change", "잘 딸리다", mutable2.get());
  }

  @Test
  public void setValueIgnoresRemaining() {
    Mutable2<String> mutable2 = new Mutable2<>("cats");

    assertEquals("The same value is store", "cats", mutable2.get());

    mutable2.set("foxes");

    assertEquals("There should be a change", "foxes", mutable2.get());

    mutable2.set("잘 딸리다");

    assertEquals("There should be a change", "잘 딸리다", mutable2.get());

    mutable2.set("Hello, world!");

    assertEquals("No change should happen", "잘 딸리다", mutable2.get());
  }
}