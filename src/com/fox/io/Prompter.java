package com.fox.io;

import com.fox.general.StringExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static com.fox.io.log.ConsoleLogger.exception;
import static com.fox.io.log.ConsoleLogger.writeLine;

/**
 * Created by stephen on 7/9/15.
 */
public class Prompter {

    private static BufferedReader reader;
    // TODO: Do I actually need the C_Logger?
//    private static Logger Log = new C_Logger();
    
    public static String promptString () {
        return promptString ("Please input a valid string");
    }

    public static String promptString( String prompt ) {

//        System.out.println(prompt);
        if ( reader == null ) {
            initReader();
        }

        String value = safePrompt(prompt);

        // TODO: there should be more here, to warrant the seperate method

        return value;
    }

    private static void initReader () {
        initReader(System.in);
    }

    public static String safePrompt( String prompt ) {

        String input = null;

        while ( input == null ) {

            writeLine(prompt);

            try {
                String lineRead = reader.readLine();
                input = StringExtension.isNullOrEmpty(lineRead) ? null : lineRead;
            }
            catch (IOException e) {
                exception(e, null);
            }

        }

        return input;
    }

    private static void initReader( InputStream i_stream ) {
        initReader(new InputStreamReader(i_stream));
    }

    private static void initReader( InputStreamReader is_Reader ) {
        reader = new BufferedReader(is_Reader);
    }
}
