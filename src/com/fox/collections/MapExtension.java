package com.fox.collections;

import com.fox.general.IterableExtension;
import com.fox.io.log.ConsoleLogger;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by stephen on 4/15/15.
 */
public class MapExtension {
  public static <T extends Comparable, U extends Comparable> void
  printKeyValuePairs(Map<T, U> dict) {
    for (Map.Entry<T, U> keyValPair : dict.entrySet()) {
      ConsoleLogger.writeLineFormatted("%s: %s", keyValPair.getKey(), keyValPair.getValue());
    }
  }

  /**
   * Haskell's Map.fromList is to thank for this idea.
   * [(a,b)] -> Map a b, where the last key->value wins, overwriting any previous
   * entries
   *
   * @param tuples or key-value pairs
   * @param <K>    type of the key
   * @param <V>    type of the value
   * @return non-null {@code Map<K, V>}, where K is the type of {@link Tuple#first}
   * and V is the type of {@link Tuple#second}
   */
  public static <K, V> Map<K, V> fromList(Iterable<Tuple<K, V>> tuples) {
    HashMap<K, V> hashMap = new HashMap<>();

    tuples.forEach(kvTuple -> hashMap.put(kvTuple.first, kvTuple.second));

    return hashMap;
  }

  public static <K, V, E extends Iterable<V>>
  Map<K, Iterable<V>> concatenateToMap(Iterable<Tuple<K, E>> tuples) {

    HashMap<K, Iterable<V>> hashMap = new HashMap<>();

    tuples.forEach(kvPair -> {
      K key = kvPair.first;
      E iterValue = kvPair.second;

      Iterable<V> concat = IterableExtension.concat(hashMap.get(key), iterValue);
      hashMap.put(key, concat);
    });

    return hashMap;
  }

  public static <K, V, E extends Iterable<V>, R>
  Map<K, R> concatenateToMapWith(Iterable<Tuple<K, E>> tuples, Function<E, R> transform) {
    HashMap<K, Iterable<V>> hashMap = new HashMap<>();

    tuples.forEach(kvPair -> {
      K key = kvPair.first;
      E iterableAsValue = kvPair.second;

      Iterable<V> concat = IterableExtension.concat(hashMap.get(key), iterableAsValue);
      hashMap.put(key, concat);
    });

    HashMap<K, R> trueRet = new HashMap<>();

    hashMap.entrySet().forEach(entry -> trueRet.put(entry.getKey(), transform.apply((E) entry.getValue())));

    return trueRet;
  }

}
