package com.fox.encapsulation;

import org.junit.Test;

import static org.junit.Assert.*;

public class Mutable3Test {
  @Test
  public void getValue() {
    Mutable3<String> mutable3 = new Mutable3<>("cats");

    assertEquals("The same value is store", "cats", mutable3.get());
  }

  @Test
  public void getValueNull() {
    Mutable3<String> mutable3 = new Mutable3<>();

    assertEquals("The same value is store", null, mutable3.get());
  }

  @Test
  public void setValueOnce() {
    Mutable3<String> mutable3 = new Mutable3<>("cats");

    assertEquals("The same value is store", "cats", mutable3.get());

    mutable3.set("foxes");

    assertEquals("There should be a change", "foxes", mutable3.get());
  }

  @Test
  public void setValueTwice() {
    Mutable3<String> mutable3 = new Mutable3<>("cats");

    assertEquals("The same value is store", "cats", mutable3.get());

    mutable3.set("foxes");

    assertEquals("There should be a change", "foxes", mutable3.get());

    mutable3.set("squirrels");

    assertEquals("There should be a change", "squirrels", mutable3.get());
  }

  @Test
  public void setValueMax() {
    Mutable3<String> mutable3 = new Mutable3<>("cats");

    assertEquals("The same value is store", "cats", mutable3.get());

    mutable3.set("foxes");

    assertEquals("There should be a change", "foxes", mutable3.get());

    mutable3.set("잘 딸리다");

    assertEquals("There should be a change", "잘 딸리다", mutable3.get());

    mutable3.set("잘 먹었어?");

    assertEquals("One final change", "잘 먹었어?", mutable3.get());
  }

  @Test
  public void setValueIgnoresRemaining() {
    Mutable3<String> mutable3 = new Mutable3<>("cats");

    assertEquals("The same value is store", "cats", mutable3.get());

    mutable3.set("foxes");

    assertEquals("There should be a change", "foxes", mutable3.get());

    mutable3.set("Hello, world!");

    assertEquals("Should have Hello, world", "Hello, world!", mutable3.get());

    mutable3.set("잘 딸리다");

    assertEquals("There should be a change", "잘 딸리다", mutable3.get());


    assertEquals("No change should happen", "잘 딸리다", mutable3.get());
  }
}