package com.fox;

import com.fox.io.Prompter;
import com.fox.io.log.ConsoleColor;
import com.fox.io.log.ConsoleLogger;

public class Main {

  public static void main(String[] args) {
    String output = Prompter.promptString();

    System.out.println("You said: " + output);

    ConsoleLogger.writeLine("Testing text", ConsoleColor.CYAN);
    ConsoleLogger.writeLine("This should be fine");
    ConsoleLogger.writeLine("This should be red", ConsoleColor.RED);
  }
}
