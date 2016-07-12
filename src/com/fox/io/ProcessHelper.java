package com.fox.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;

public class ProcessHelper {
  /**
   * Analyzes the {@link InputStream} instances for the passed {@link Process},
   * first checking for failures, then proceeding to standard input for that instance.
   * Line breaks are persisted, for the caller can decide if they are needed our not.
   * <p>
   * <p>
   * Performance wise, on my Mac, executes <200ms consistently.
   *
   * @param process instance that executing a command-line program
   * @return Either the error output (first choice) or any other output that would be presented
   * in a (user) shell upon completion of the process executing
   * @throws IOException
   */
  static String reviewInputStreamsOn(Process process) throws IOException {

    InputStreamReader inputStreamReader = new InputStreamReader(process.getErrorStream());
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    StringBuilder valuedOutput = new StringBuilder();
    boolean madeAddition = false; // track if first the stream had anything for us

    String line;
    while (( line = bufferedReader.readLine() ) != null) {
      valuedOutput.append(line).append('\n');
      madeAddition = true;
    }

    if (madeAddition) return valuedOutput.toString();

    // read the other input stream
    inputStreamReader = new InputStreamReader(process.getInputStream());
    bufferedReader = new BufferedReader(inputStreamReader);

    while (( line = bufferedReader.readLine() ) != null) {
      valuedOutput.append(line).append('\n');
    }

    return valuedOutput.toString();
  }

  /**
   * Full execution time is around 300ms (200 of which is thanks to the work done by
   * {@link ProcessHelper#reviewInputStreamsOn(Process)}).
   *
   * NOTE: Because this computation is so heavy, perhaps we should cache it?
   *
   * @return {@link ExecutingProcessInfo} reference that contains all of the system process info
   * that can't be derived by other means.
   */
  public static ExecutingProcessInfo getApplicationProcessInfo() {
    try {
      // 'ls' for java processes on the system
      Process jps = Runtime.getRuntime().exec("jps -l"); // produces the fully qualified names

      // jps prints each on its own line
      String[] pidWithNames = reviewInputStreamsOn(jps).split("\n");

      StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

      // this produces the fully qualified names
      String myAppName = stackTrace[stackTrace.length - 1].getClassName();

      Optional<String[]> first = Arrays.stream(pidWithNames)
          .map(s -> s.split(" "))
          .filter(arr -> arr.length > 1)
          .filter(arr -> myAppName.equals(arr[1]))
          .findFirst();

      boolean success = first.isPresent();
      if (success) {
        String[] pidAndName = first.get();
        return new ExecutingProcessInfo()
            .succeeded(true)
            .withPid(pidAndName[0])
            .withProcessName(pidAndName[1]);
      } else {
        return new ExecutingProcessInfo()
            .succeeded(false)
            .withMessage("Couldn't find pid for Application with name: " + myAppName);
      }
    } catch (IOException e) {
      return new ExecutingProcessInfo()
          .succeeded(false)
          .withStackTrace(e.getStackTrace())
          .withMessage("IOException was thrown");
    }
  }

  /**
   * A carrier POJO that is dependent on the "didSucceeded" field, much like {@link Optional}.
   * Under the "success" scenario, the
   */
  public static class ExecutingProcessInfo {
    private boolean didSucceeded;
    private StackTraceElement[] callStack;
    private int pid;
    private String processName;
    private String message;

    public ExecutingProcessInfo succeeded(final boolean succeeded) {
      this.didSucceeded = succeeded;
      return this;
    }

    public ExecutingProcessInfo withStackTrace(StackTraceElement[] stackTrace) {
      this.callStack = stackTrace;
      return this;
    }

    public ExecutingProcessInfo withPid(String processIdString) {
      this.pid = Integer.parseInt(processIdString);
      return this;
    }

    public ExecutingProcessInfo withPid(int processId) {
      this.pid = processId;
      return this;
    }

    public ExecutingProcessInfo withProcessName(String processName) {
      this.processName = processName;
      return this;
    }

    public ExecutingProcessInfo withMessage(String failureMessage) {
      this.message = failureMessage;
      return this;
    }

    public boolean succeeded() {
      return this.didSucceeded;
    }

    public int pid() {
      return this.pid;
    }

    public String processName() {
      return this.processName;
    }
  }
}
