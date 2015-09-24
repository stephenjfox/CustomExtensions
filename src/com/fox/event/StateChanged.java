package com.fox.event;

/**
 * Created by Stephen on 10/30/2014.
 * In project: NeumontWork
 */
public interface StateChanged <T extends Event> {
    void fireEvent();

    void onEvent( T event );
}
