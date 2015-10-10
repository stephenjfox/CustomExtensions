package com.fox.collections;

import com.fox.general.IterableExtension;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by stephen on 4/15/15.
 */
public class MapExtension
{
    public static <T extends Comparable, U extends Comparable> void
    printKeyValuePairs( Map<T, U> dict )
    {
        for ( Map.Entry<T, U> keyValPair : dict.entrySet() )
        {
            System.out.printf("%s: %s", keyValPair.getKey(), keyValPair.getValue());
        }
    }

    /**
     * Haskell's Map.fromList is to thank for this idea.
     * [(a,b)] -> Map a b, where the last key->value wins, overwriting any previous
     * entries
     * @param tuples or key-value pairs
     * @param <K> type of the key
     * @param <V> type of the value
     * @return non-null {@code Map<K, V>}, where K is the type of {@link Tuple#item1}
     * and V is the type of {@link Tuple#item2}
     */
    public static <K, V> Map<K, V> fromList( Iterable<Tuple<K, V>> tuples ) {
        HashMap<K, V> hashMap = new HashMap<>();

        tuples.forEach(kvTuple -> hashMap.put(kvTuple.item1, kvTuple.item2));

        return hashMap;
    }

    /**
     *
     * @param tuples
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V extends Iterable> Map<K, Iterable> fromConcatableList( Iterable<Tuple<K, V>> tuples ) {

        HashMap<K, Iterable> hashMap = new HashMap<>();

        tuples.forEach(kvPair -> {
            K key = kvPair.item1;
            V iterValue = kvPair.item2;

            Iterable concat = IterableExtension.concat(hashMap.get(key), iterValue);
            hashMap.put(key, concat);
        });

        return hashMap;
    }

}
