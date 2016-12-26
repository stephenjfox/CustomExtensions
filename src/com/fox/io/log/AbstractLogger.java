package com.fox.io.log;

import java.io.PrintStream;

/**
 * Created by stephen on 7/9/15.
 */
public abstract class AbstractLogger implements Logger {
  protected PrintStream outStream, errStream;

  public AbstractLogger(PrintStream outputStream, PrintStream errorStream) {
    this.outStream = outputStream;
    this.errStream = errorStream;
  }

  @Override
  public void writeLine(String text) {
    outStream.println(text);
  }
}
