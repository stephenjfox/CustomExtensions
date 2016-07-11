package com.fox.general;

import com.fox.collections.Tuple;

/**
 * Created by stephen on 7/29/15.
 */
public class LongExtension {

  public static Tuple<Boolean, Long> tryParse(String str) {

    try {
      Long l = Long.parseLong(str);
      return Tuple.create(true, l);
    } catch (Exception e) {
      return Tuple.create(false, null);
    }

  }

  public static Tuple<Boolean, Long> tryParse(String string, int radix) {

    try {
      Long l = Long.parseLong(string, radix);
      return Tuple.create(true, l);
    } catch (Exception e) {
      return Tuple.create(false, null);
    }

  }

  public static class Constants {
    public final int BYTES = Long.BYTES;
    public final int SIZE = Long.SIZE;
  }

}
