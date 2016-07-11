package com.fox.io.log;

import com.sun.istack.internal.Nullable;

/**
 * Created by stephen on 7/8/15.
 */
public interface Logger {

  void writeLine(String text);

  void printDebug(String text);

  void printWarning(String text);

  void printError(String text);

  void printException(Exception ex, @Nullable String text);
}

