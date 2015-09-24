package com.fox.io;

import java.util.Scanner;

/**
 * Created by stephen on 5/6/15.
 */
public class IO {

    public static <itemType> int promptMenu( boolean withTerminator, itemType... items ) {

        System.out.println("Select an option below: ");

        int i = 1;

        for ( itemType item : items ) {
            System.out.println(String.format("\t%d. %s", i++, item));
        }

        return new Scanner(System.in).nextInt();
    }

}
