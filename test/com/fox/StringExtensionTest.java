package com.fox;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stephen on 8/6/2016.
 */
public class StringExtensionTest {
  @Test
  public void wordCount() throws Exception {
    String test = "This is a sentence";
    int wordCount = StringExtension.wordCount(test);

    Assert.assertEquals("There are four words", 4L, wordCount);
  }

  @Test
  public void empty() throws Exception {
    String empty = StringExtension.empty();

    Assert.assertEquals("Should be no length", 0, empty.length());
    Assert.assertEquals("Sholud be empty", "", empty);
  }

  @Test
  public void isNullOrWhiteSpace() throws Exception {

  }

  @Test
  public void isNullOrEmpty() throws Exception {
    String testNull = null;
    String testEmpty = ""; // no really on our own libraries, because coupling

    Assert.assertTrue("The string IS null", StringExtension.isNullOrEmpty(testNull));
    Assert.assertTrue("The string IS empty", StringExtension.isNullOrEmpty(testEmpty));
  }

  @Test
  public void wrappedInDefaultCountAndPadding() throws Exception {
    String expected = "-------------------- Foo --------------------";
    String test = StringExtension.wrappedIn("Foo", '-');

    assertEquals("The messages should be equivalent", expected, test);
  }


  @Test
  public void wrappedInDefaultPadding() throws Exception {
    String expected = "----- message -----";
    String test = StringExtension.wrappedIn("message", '-', 5);

    assertEquals("The messages should be equivalent", expected, test);
    assertArrayEquals(expected.toCharArray(), test.toCharArray());
  }

  @Test
  public void wrappedIn() {
    String expected = "****  test  ****";
    String test = StringExtension.wrappedIn("test", '*', 4, 2);

    assertEquals("The messages should be equivalent", expected, test);
    assertArrayEquals(expected.toCharArray(), test.toCharArray());
  }

  @Test
  public void repeatedChar() throws Exception {
    String expected = "*****";
    String test = StringExtension.repeatedChar('*', 5);

    assertEquals("The messages should be equivalent", expected, test);
    assertArrayEquals(expected.toCharArray(), test.toCharArray());
  }

  @Test
  public void listWordCount() throws Exception {

  }

  @Test
  public void listWordCountMulti() {
    //
  }

  @Test
  public void capitalizeSentence() throws Exception {
    String expected = "Foo Bar";
    String test = StringExtension.capitalizeSentence("foo bar");

    assertNotNull(test);
    assertEquals("Strings should be equivalent", expected, test);
  }

  @Test
  public void capitalizeSentence_EdgeCases() {
    // Case #1: strange extra characters
    String expected = "Foobar. Test";
    String test = StringExtension.capitalizeSentence("Foobar. test");

    assertNotNull(test);
    assertEquals("Strings should be equivalent", expected, test);

    // Case #2: empty
    expected = "";
    test = StringExtension.capitalizeSentence("");

    assertEquals("Strings should be equivalent", expected, test);

    expected = "A B C D E";
    test = StringExtension.capitalizeSentence("a b c d e");

    assertEquals("Strings should be equivalent", expected, test);
  }

  @Test
  public void capitalize() throws Exception {
    String expected = "Foo";
    String test = StringExtension.capitalize("foo");

    assertNotNull(test);
    assertEquals("Strings should be equivalent", expected, test);
  }

  @Test
  public void substringExcludeIndex() throws Exception {

  }

  @Test
  public void isPalindrome() throws Exception {
    String palin = "racecar";
    boolean test = StringExtension.isPalindrome(palin);

    assertTrue("'racecar' is a palindrome", test);
  }

}