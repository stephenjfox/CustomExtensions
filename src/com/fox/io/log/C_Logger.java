package com.fox.io.log;

import com.sun.istack.internal.Nullable;

import java.util.Arrays;

/**
 * Created by stephen on 7/8/15.
 */
public class C_Logger extends AbstractLogger {

    public C_Logger() {
        // Code goes here
        super(System.out, System.err);
    }

    @Override
    public void printDebug( String text ) {
        ConsoleColor dColor = ConsoleColor.CYAN;
        outStream.println(
                String.format("%sDEBUG:%s %s", dColor.ansiCode(), ConsoleColor.RESET.ansiCode(),
                        text));
    }

    @Override
    public void printWarning( String text ) {
        errStream.println("WARNING: " + text);
    }

    @Override
    public void printError( String text ) {
        errStream.println("ERROR: " + text);
    }

    @Override
    public void printException( Exception ex, @Nullable String text ) {
        String userMsg = ( text != null ? text : "" );
        errStream.println("EXCEPTION: " +
                Arrays.asList(ex.getStackTrace()).stream().map(StackTraceElement::toString).reduce(( s, s2 ) -> s.concat("\n" + s2 )) + userMsg);
    }
}
