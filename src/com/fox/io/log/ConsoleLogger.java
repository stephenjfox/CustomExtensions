package com.fox.io.log;

import com.sun.istack.internal.Nullable;

import java.util.Arrays;

/**
 * Static wrapper class for the C_Logger initiative
 */
public class ConsoleLogger {

    private static C_Logger log;
    private static String RESET_CODE = ConsoleColor.RESET.ansiCode();

    public static void writeLine() {
        initLogger();
        log.writeLine("");
    }

    private static void initLogger() {
        if ( log == null ) {
            log = new C_Logger();
        }
    }

    public static void writeLine( Object object ) {
        initLogger();
        log.writeLine(possibleArrayString(object));
    }

    /* Helpers */
    private static String possibleArrayString( Object object ) {
        return object.getClass().isArray() ? Arrays.toString((Object[]) object) : object.toString();
    }

    public static void writeLine( Object text, ConsoleColor consoleColor, int lineBreaks ) {
        writeLine(possibleArrayString(text), consoleColor, lineBreaks);
    }

    public static void writeLine( String text, ConsoleColor consoleColor, int lineBreaks ) {
        StringBuilder builder = new StringBuilder(text);
        for ( int i = 0; i < lineBreaks; i++ ) {
            builder.append("\n");
        }
        writeLine(builder.toString(), consoleColor);
    }

    public static void writeLine( String text, ConsoleColor consoleColor ) {

        initLogger();
        log.writeLine(String.format("%s%s%s", consoleColor.ansiCode(), text, RESET_CODE));
    }

    public static void writeLine( Object object, ConsoleColor consoleColor ) {

        writeLine(possibleArrayString(object), consoleColor);

    }

    public static void writeLineFormatted( String format, ConsoleColor consoleColor, Object... args ) {
        writeLine(String.format(format, args), consoleColor);
    }

    public static void writeLineFormatted( String format, Object... args ) {
        writeLine(String.format(format, args));
    }

    public static void writeLine( String text ) {
        initLogger();
        log.writeLine(text);
    }

    public static void writeAllLines( ConsoleColor color, Object... objects ) {
        writeAllLines(objects, color);
    }

    public static void writeAllLines( Object[] objects, ConsoleColor consoleColor ) {
        initLogger();

        for ( Object object : objects ) {
            log.writeLine(String.format("%s%s%s", consoleColor.ansiCode(), object.toString(), RESET_CODE));
        }
    }

    public static void debugFormatted( String format, Object... args ) {
        debug(String.format(format, args));
    }

    public static void debug( String text ) {
        initLogger();
        log.printDebug(text);
    }

    public static void debug( Object object ) {
        String text = possibleArrayString(object);
        debug(text);
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

}
