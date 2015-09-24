package com.fox.io.log;

import com.sun.istack.internal.Nullable;

/**
 * Static wrapper class for the C_Logger initiative
 */
public class ConsoleLogger {

    private static C_Logger log;

    public static void writeLine() {
        initLogger();
        log.writeLine("");
    }

    public static void writeLine( Object object ) {
        initLogger();
        log.writeLine(object.toString());
    }

    public static void writeLine( String text ) {
        initLogger();
        log.writeLine(text);
    }

    public static void writeLine( String text, ConsoleColor consoleColor ) {

        initLogger();
        log.writeLine(String.format("%s%s%s",
                consoleColor.ansiCode(),text,ConsoleColor.RESET.ansiCode()));
    }

    public static void writeAllLines( Object[] objects, ConsoleColor consoleColor ) {
        initLogger();

        for ( Object object : objects ) {
            log.writeLine(String.format("%s%s%s",
                    consoleColor.ansiCode(), object.toString(), ConsoleColor.RESET.ansiCode()));
        }
    }

    public static void writeAllLines( ConsoleColor color, Object... objects ) {
        writeAllLines(objects, color);
    }

    public static void debug( String text ) {
        initLogger();
        log.printDebug(text);
    }

    public static void warning( String text ) {
        initLogger();
        log.printWarning(text);
    }

    public static void error( String text ) {
        initLogger();
        log.printError(text);
    }

    public static void exception( Exception ex, @Nullable String text ) {
        initLogger();
        log.printException(ex, text);
    }

    private static void initLogger() {
        if ( log == null ) {
            log = new C_Logger();
        }
    }

}
