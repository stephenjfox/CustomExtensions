package com.fox.collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Created by stephen on 4/15/15.
 */
public class Tuple<T1, T2>
{
    public final T1 item1;
    public final T2 item2;

    private Tuple( T1 item1, T2 item2 )
    {
        this.item1 = item1;
        this.item2 = item2;
    }

    public static <T1, T2, T3> Triple<T1, T2, T3>  create( T1 i1, T2 i2, T3 i3 ) {
        return new Triple<>(i1, i2, i3);
    }

    public static <T1, T2, T3, T4> Quadruple<T1, T2, T3, T4> create( T1 i1, T2 i2, T3 i3, T4 i4 ) {
        return new Quadruple<>(i1, i2, i3, i4);
    }

    public static <T1, T2, T3, T4, T5> Quintuple<T1, T2, T3, T4, T5> create ( T1 item1, T2 item2, T3 item3, T4 item4, T5 item5 ) {
        return new Quintuple<>(item1, item2, item3, item4, item5);
    }

    public static <T1, T2> Iterable<Tuple<T1, T2>> zip( Iterable<T1> t1Iterable, Iterable<T2> t2Iterable ) {

        Iterator<T1> iterator = t1Iterable.iterator();
        Iterator<T2> iterator1 = t2Iterable.iterator();

        return zip(iterator, iterator1);
    }

    private static <T1, T2> Iterable<Tuple<T1, T2>> zip( Iterator<T1> iterator, Iterator<T2> iterator1 ) {

        Objects.requireNonNull(iterator);
        Objects.requireNonNull(iterator1);

        LinkedList<Tuple<T1, T2>> list = new LinkedList<>();

        while ( iterator.hasNext() && iterator1.hasNext() ) {

            list.add(create(iterator.next(), iterator1.next()));

        }

        return list;
    }

    public static <T1, T2> Tuple<T1, T2> create( T1 i1, T2 i2 )
    {
        return new Tuple<>(i1, i2);
    }

    private static class Triple<T1, T2, T3> extends Tuple<T1, T2> {

        public final T3 item3;

        private Triple( T1 item1, T2 item2, T3 item3 ) {
            super(item1, item2);
            this.item3 = item3;
        }
    }

    private static class Quadruple<T1, T2, T3, T4> extends Tuple<T1, T2> {

        public final T3 item3;
        public final T4 item4;

        private Quadruple( T1 item1, T2 item2, T3 item3, T4 item4 ) {
            super(item1, item2);
            this.item3 = item3;
            this.item4 = item4;
        }
    }

    public static class Quintuple<T1, T2, T3, T4, T5> extends Tuple<T1, T2> {

        public final T3 item3;
        public final T4 item4;
        public final T5 item5;

        private Quintuple( T1 item1, T2 item2, T3 item3, T4 item4, T5 item5 ) {
            super(item1, item2);
            this.item3 = item3;
            this.item4 = item4;
            this.item5 = item5;
        }
    }
}


