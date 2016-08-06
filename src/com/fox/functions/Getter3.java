package com.fox.functions;

import com.fox.collections.Tuple;

import static com.fox.collections.Tuple.create;

/**
 * The limit of the Getter# series. If you need more returns from a function,
 * we recommend making an encapsulating type.
 *
 * Created by Stephen on 8/5/2016.
 */
public interface Getter3<T1, T2, T3> extends Getter<Tuple.Triple<T1, T2, T3>> {

  default Getter2<T1, Tuple<T2, T3>> splitLeft() {
    Tuple.Triple<T1, T2, T3> triple = get();
    return () -> create(triple.first, create(triple.second, triple.third));
  }

  default Getter2<Tuple<T1, T2>, T3> splitRight() {
    Tuple.Triple<T1, T2, T3> triple = get();
    return () -> create(create(triple.first, triple.second), triple.third);
  }
}
