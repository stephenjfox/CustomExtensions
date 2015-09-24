package com.fox.event;

/**
 * Created by stephen on 5/5/15.
 */
public abstract class EventSource implements StateChanged {
    protected EventListenerList myListeners;

    public EventSource() {
        myListeners = new EventListenerList();
    }

    public <T extends EventListener> void addListeners( Class<T> type, T... listeners ) {

        for ( T listener : listeners ) {
//            System.out.println("Event-Type: \t" + EventListener.class);
//            System.out.println("T-Type: \t" + type);
            myListeners.add(type, listener);
        }

    }

    public <T extends EventListener> void removeListeners( Class<T> type, T... listeners ) {

        for ( T listener : listeners ) {
//            System.out.println("Type: \t" + type);
            myListeners.remove(type, listener);

        }
    }

}
