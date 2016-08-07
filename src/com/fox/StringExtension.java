package com.fox;

import java.lang.reflect.Array;
import java.util.*;

import static com.fox.general.Predication.existenceCheck;

/**
 * Created by stephen on 4/15/15.
 */
public class StringExtension {

  private static final String EMPTY_STRING = "";

  /**
   * @param string
   * @return the number of substrings that are delimited by spaces
   */
  public static int wordCount(String string) {
    return string.split("\\s").length;
  }

  /**
   * @return the equivalent of C#'s "String.empty".
   */
  public static String empty() {
    return EMPTY_STRING;
  }

  /**
   * @param str potentially null or "empty" string
   *            Empty: only white space characters compose the String
   * @return whether the string is null, is of 0 length, or composed of ONLY whitespace
   */
  public static boolean isNullOrWhiteSpace(String str) {
    boolean clear = isNullOrEmpty(str);

    boolean clearState = true;
    if (!clear) {
      char[] chars = str.toCharArray();
      final char emptyChar = ' '; // for compiler assistance. inlined constant MAY be faster
      for (char aChar : chars) {
        clearState &= aChar == emptyChar; // boolean AND on "aChar is white space"
      }
    }

    return clear || clearState;
  }

  /**
   * @param str potentially null or zero-length string
   * @return
   */
  public static boolean isNullOrEmpty(String str) {
    return str == null || str.isEmpty();
  }

  /**
   * We don't have default methods, so overload with wrapper length of 20
   *
   * @see StringExtension#wrappedIn(String, char, int)
   */
  public static String wrappedIn(String toWrap, char wrappingChar) {
    return wrappedIn(toWrap, wrappingChar, 20);
  }

  /**
   * Defaults the padding spaces to 1 for
   *
   * @see StringExtension#wrappedIn(String, char, int, int)
   */
  public static String wrappedIn(String toWrap, char wrappingChar, int wrapCount) {
    return wrappedIn(toWrap, wrappingChar, wrapCount, 1);
  }

  /**
   * @param toWrap        some String - perhaps a message - that we would like to surround
   *                      I.e. {@code "foo"}
   * @param wrappingChar  that will surround {@code toWrap}
   *                      I.e. {@code 'c'}
   * @param wrapCount     the length of the replicated {@code wrappingChar} produced String
   *                      I.e. with {@code wrappingChar} = 'c' and {@code wrapCount} = 2, result
   *                      will be padded with {@code "cc"}.
   * @param paddingSpaces between the composed wrapper and {@code toWrap}
   * @return a String wrapped with the given semantics.
   * Ex: {@code wrappedIn("My message", '-', 5, 1} // "----- My message -----"
   */
  public static String wrappedIn(String toWrap, char wrappingChar, int wrapCount, int paddingSpaces) {
    final String wrapping = repeatedChar(wrappingChar, wrapCount);

    final boolean goingToPad = paddingSpaces > 0;

    final StringBuilder builder = new StringBuilder(wrapping);
    if (goingToPad) builder.append(repeatedChar(CharExtension.Constants.SINGLE_SPACE, paddingSpaces));

    builder.append(toWrap);

    if (goingToPad) builder.append(repeatedChar(CharExtension.Constants.SINGLE_SPACE, paddingSpaces));
    builder.append(wrapping);

    return builder.toString();
  }

  /**
   * @param repeat the char to replicate
   * @param count  times to replicate
   * @return the string that would be {@code repeat}, {@code count} times:
   * <p>
   * Ex: assert repeatedChar('c', 3) == "ccc"
   */
  public static String repeatedChar(char repeat, int count) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < count; i++) builder.append(repeat);
    return builder.toString();
  }

  public static Map<String, Integer> listWordCount(String text) {
    TreeMap<String, Integer> frequencies = new TreeMap<>();

    String[] words = text.split("\\w+");

    for (String word : words) {
      if (frequencies.containsKey(word))
        frequencies.put(word, 1);
      else
        frequencies.put(word, frequencies.get(word) + 1);
    }

    return frequencies;
  }

  /**
   * Takes every word in a given "sentence" (think basic English, syntactically) and
   * capitalize them.
   *
   * @param sentence Some string sentence that is potentially space-delimited
   * @return effectively "Pascal-case" string (ignoring spaces, of course)
   */
  public static String captalizeSentence(String sentence) {

    final String space = " ";
    return Arrays.stream(sentence.split("\\s"))
        .map(StringExtension::capitalize)
        .reduce(empty(), (s, s2) -> s.concat(space).concat(s2));
  }

  /**
   * @param string that you would like to capitalize, such that
   *               {@code StringExtension.capitalize("foo") == "Foo"}
   * @return the capitalized result
   */
  public static String capitalize(String string) {
    existenceCheck(string);
    char[] stringAsArray = string.toCharArray();
    char caps = Character.toUpperCase(stringAsArray[0]);
    StringBuilder returner = new StringBuilder(Character.toString(caps));

    for (int i = 1; i < stringAsArray.length; i++) {
      returner.append(stringAsArray[i]);
    }

    return returner.toString();
  }

  public static String substringExcludeIndex(String s, int... indicesToIgnore) {
    existenceCheck(s);

    StringBuilder builder = new StringBuilder();

    Vector<Integer> indices = new Vector<>(indicesToIgnore.length);

    for (int ignoreDex : indicesToIgnore) {
      indices.add(ignoreDex);
    }

    for (int i = 0, count = s.length(); i < count; i++) {
      if (indices.contains(i))
        continue;
      builder.append(s.charAt(i));
    }

    return builder.toString();
  }

  /**
   * @param s potential palindrome
   * @return
   */
  public static boolean isPalindrome(String s) {
    boolean cond = true;
    char[] chars = s.toCharArray();

    for (int i = 0, j = chars.length / 2; i < j; i++) {
      cond &= chars[i] == chars[chars.length - 1 - i];
    }

    return cond;
  }
}
