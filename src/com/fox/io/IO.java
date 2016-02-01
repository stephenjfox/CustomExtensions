package com.fox.io;

import com.fox.io.log.ConsoleColor;
import com.fox.io.log.ConsoleLogger;

import java.util.Scanner;

/**
 * Created by stephen on 5/6/15.
 */
public class IO {

    public static <ItemType> int promptMenu(boolean withTerminator, ItemType... items) {

        ConsoleLogger.writeLine("Select an option below: ", ConsoleColor.YELLOW, 1);

        int i = 1;

        for (ItemType item : items) {
            ConsoleLogger.writeLineFormatted("\t%d. %s", i++, item);
        }

        return new Scanner(System.in).nextInt();
    }

}
