package com.fox.event;

/**
 * Created by Stephen on 11/3/2014.
 * In project: NXTSoftware
 */
public class Event
{
    /**
     * The object on which the Event initially occurred.
     */
    protected transient EventSource  source;

    /**
     * Constructs a prototypical Event.
     *
     * @param    source    The object on which the Event initially occurred.
     * @exception  IllegalArgumentException  if source is null.
     */
    public Event(EventSource source) {
        if (source == null)
            throw new IllegalArgumentException("null source");

        this.source = source;
    }

    /**
     * The object on which the Event initially occurred.
     *
     * @return   The object on which the Event initially occurred.
     */
    public EventSource getSource() {
        return source;
    }

    /**
     * Returns a String representation of this EventObject.
     *
     * @return  A a String representation of this EventObject.
     */
    public String toString() {
        return "Event" + "[source=" + source + "]";
    }
}
