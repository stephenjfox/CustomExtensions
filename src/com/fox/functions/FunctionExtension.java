package com.fox.functions;

import com.fox.collections.Tuple;

import static com.fox.collections.Tuple.create;

/**
 * Created by stephen on 10/8/15.
 */
public class FunctionExtension {

  public static <T1, T2> Getter2<T1, T2> getter2(T1 t1, T2 t2) {
    return () -> create(t1, t2);
  }

  public static <T1, T2, T3> Getter2<T1, Tuple<T2, T3>> getter2(T1 t1, T2 t2, T3 t3) {
    return () -> create(t1, create(t2, t3));
  }

  public static <T1, T2, T3> Getter2<T1, Tuple<T2, T3>> getter2(Tuple.Triple<T1, T2, T3> triple) {
    return () -> create(triple.first, create(triple.second, triple.third));
  }
}
