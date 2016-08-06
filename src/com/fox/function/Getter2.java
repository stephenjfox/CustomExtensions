package com.fox.function;

import com.fox.collection.Tuple;

/**
 * For when you just have to return two things.
 *
 * Created by Stephen on 8/5/2016.
 */
public interface Getter2<T1, T2> extends Getter<Tuple<T1, T2>> {

  default T1 first() {
    return get().first;
  }

  default T2 second() {
    return get().second;
  }
}
