package com.fox.io;

import com.fox.StringExtension;

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

  public static String promptString() {
    return promptString("Please input a valid string");
  }

  public static String promptString(String prompt) {

    if (reader == null) {
      initReader();
    }

    // TODO: there should be more here, to warrant the separate method
    return safePrompt(prompt);
  }

  public static String safePrompt(String prompt) {

    String input = null;

    while (input == null) {

      writeLine(prompt);

      try {
        final String lineRead = reader.readLine();
        input = StringExtension.isNullOrEmpty(lineRead) ? null : lineRead;
      } catch (IOException e) {
        exception(e, null);
      }

    }

    return input;
  }

  private static void initReader() {
    initReader(System.in);
  }

  private static void initReader(InputStream inputStream) {
    initReader(new InputStreamReader(inputStream));
  }

  private static void initReader(InputStreamReader inputStreamReader) {
    reader = new BufferedReader(inputStreamReader);
  }
}
