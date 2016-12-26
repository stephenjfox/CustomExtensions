package com.fox.encapsulation;

/**
 * Encapsulation of temporarily mutable state. After the lock() function is called, all functions
 * that would change the internal state of {@code this} will seize to operate.
 * The implementor can choose how the halting of inner-mutation will be presented to the user.
 *
 * Created by Stephen on 10/13/2016.
 */
public interface Lockable {
  void lock();
}
