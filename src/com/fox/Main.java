package com.fox;

import com.fox.io.Prompter;
import com.fox.io.log.ConsoleColor;
import com.fox.io.log.ConsoleLogger;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.function.Function;

public class Main {

  public static void main(String[] args) {

    ConsoleLogger.writeLine("Testing text", ConsoleColor.CYAN);
    ConsoleLogger.writeLine("This should be fine");
    ConsoleLogger.writeLine("This should be red", ConsoleColor.RED);

  }
}
