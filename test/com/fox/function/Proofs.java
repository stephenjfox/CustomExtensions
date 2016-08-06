package com.fox.function;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.function.Function;

/**
 * Created by Stephen on 8/4/2016.
 */
public class Proofs {
  private void proof1() {

    Function<Integer, String> intToString = Object::toString;

    Function<String, StringBuilder> stringToBuilder = StringBuilder::new;

    Function<StringBuilder, Integer> builderToInt = stringBuilder -> stringBuilder.length();

    Function<Integer, Integer> function = intToString.andThen(stringToBuilder).andThen(builderToInt);

    Queue<Integer> preQueue = new ArrayDeque<>(3),
        postQueue = new ArrayDeque<>(3);

    Arrays.stream(new Integer[] { 1, 2, 3 })
        .map(_int -> {
          preQueue.add(_int);
          return _int;
        })
        .map(function)
        .forEach(postQueue::add);

    preQueue.forEach(System.out::print);
    System.out.println(" spacer ");
    postQueue.forEach(System.out::print);
  }
}
