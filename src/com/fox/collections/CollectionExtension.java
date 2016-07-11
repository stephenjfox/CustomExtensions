package com.fox.collections;

import com.fox.io.log.ConsoleLogger;
import com.fox.types.ClassExtension;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.fox.general.PredicateTests.isTrue;
import static com.fox.io.log.ConsoleLogger.debugFormatted;
import static com.fox.io.log.ConsoleLogger.exception;

/**
 * Created by stephen on 6/17/15.
 */
public class CollectionExtension {

  public static void classLoader() {
    try {
      Method[] myMethods = Class.forName("com.fox.collections.CollectionExtension").getDeclaredMethods();

      for (Method myMethod : myMethods) {
        ConsoleLogger.writeLine(myMethod);
      }

    } catch (ClassNotFoundException e) {
      exception(e, "the classLoading is still experimental");
    }
  }

  public static <T> boolean containsAll(Collection<T> a, Collection<T> b, boolean sequential) {
    if (sequential) {
      return containsAllSequential(a, b);
    } else {
      boolean contains = false;

      for (T t : b) {
        contains = a.contains(t);
      }
      return contains;
    }
  }

  public static <T> boolean containsAllSequential(Collection<T> a, Collection<T> b) {

    Iterator<T> left = a.iterator();
    Iterator<T> right = b.iterator();

    T left_Curr = left.next(), right_Curr = right.next();

    while (left.hasNext() && left_Curr != right_Curr)
      left_Curr = left.next(); // find the first match to check the sequence.

    try {
      isTrue(left.hasNext()); // If we've gone the entirety of our first collection.

      for (; left.hasNext() && right.hasNext(); left_Curr = left.next(), right_Curr = right.next()) {
        if (left_Curr != right_Curr) return false;
      }

      return true;
    } catch (Exception e) {

      exception(e, "The first collection never found the start of the second collection");
      return false;
    }
  }

  // TODO: Provide a better implementation than Collectors.toList(), which is "good enough"
  public static <E, T extends E> Collection<T> cast(Collection<E> collection) throws ClassCastException {
    return collection.stream().map(e -> (T) e).collect(Collectors.toList());
  }

  public static <E, T extends E> Collection<T> transform(Iterable<E> iterable, Function<? super E, T> function) {
    return StreamSupport.stream(iterable.spliterator(), false).map(function).collect(Collectors.toList());
  }

  public static <E, T extends E> Collection<T> transform(Collection<E> collection, Function<? super E, T> function) {
    return collection.stream().map(function).collect(Collectors.toList());
  }

  public static <E> Collection<E> from(Iterable<E> iterable) {

    if (iterable instanceof Collection) return (Collection<E>) iterable;

    return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
  }

  /**
   * Performs an O(n) - where 'n' is the element count of the passed collection - casting of the
   * elements into another type lens
   * Ex:
   * // This runs, given HistoricEvent matches the Event constructor
   * {@code
   * ArrayDequeue<Event> events = EventQueueFactory.foo();
   * Queue<HistoricEvent> histories = CollectionExtension.castBetter(events);
   * }
   * <p>
   * In the future, I want this to be able to match constructors reflectively and be able to match
   * the type off of param <C> instead.
   * <p>
   * Future ex:
   * <p>
   * // shout out to Google's Guava library "collections" package
   * {@code
   * ImmutableList<Integer> integers = ImmutableList.of(1,2,3,4);
   * RegularImmutableList<Integer> regularInts = CollectionExtension.castBetter(integers);
   * // of better yet...
   * RegularImmutableList<Long> regularInts = CollectionExtension.castBetter(integers);
   * // because, if we can, we SHOULD
   * }
   *
   * @param collection Some generic collection
   * @param <E>        type in passed collection
   * @param <T>        some child
   * @param <C>        Some collection of that child, where super/interface types perform more reliably
   * @return newInstance of the passed collection through the lens of param {@code <C>}
   */
  public static <E, T extends E, C extends Collection<T>> C castBetter(Collection<? extends E> collection) {
//        Type preliminarySuperType = ClassExtension.getPreliminarySuperType(collection.getClass());
    try {
      Class<Object> objectClass = ClassExtension.dotClass(collection.getClass());
      debugFormatted("collection.class: %s", objectClass);

      Constructor<Object> constructor = objectClass.getConstructor(Collection.class);
      debugFormatted("Got ctor: %s", constructor);
      debugFormatted("Collection<E>.preliminarySuperType()", ClassExtension.getPreliminarySuperType(collection.getClass()));

      return (C) constructor.newInstance(collection);
    } catch (NoSuchMethodException e) {
      exception(e, "No method could be found");
    } catch (InvocationTargetException e) {
      exception(e, "Invocation target was invalid... Probably");
    } catch (InstantiationException e) {
      exception(e, "Instantiation exception... Whatever that is\n");
    } catch (IllegalAccessException e) {
      exception(e, "Constructor was inaccessible");
    } catch (NullPointerException e) {
      exception(e, "Null pointer on objectClass (see code for more)\n");
    } catch (ClassNotFoundException e) {
      exception(e, "ClassNotFound from ClassExtension.dotClass(collection.getClass())");
    }
    return null;
  }

}
