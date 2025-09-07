package com.jagex.loader;

import com.jagex.signlink.SignLink;
import java.applet.Applet;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;

// $FF: renamed from: d
public class LoaderRuntimeException extends RuntimeException {
  // $FF: renamed from: a int
  public static int gameVersionIdentifier;
  // $FF: renamed from: b java.lang.String
  private String message;
  // $FF: renamed from: c java.lang.Throwable
  private final Throwable throwable;

  // $FF: renamed from: a (java.lang.Throwable, java.lang.String, java.applet.Applet, byte) void
  public static void publishError(
      Throwable throwable, String parentExceptionMessage, Applet applet) {
    try {
      String stackTrace = "";

      if (throwable != null) {
        stackTrace = getStackTraceFromThrowable(throwable);
      }

      if (parentExceptionMessage != null) {
        if (throwable != null) {
          stackTrace = stackTrace + " | ";
        }

        stackTrace = stackTrace + parentExceptionMessage;
      }

      printErrorToConsole(stackTrace);

      stackTrace = stackTrace.replace(":", "%3a");
      stackTrace = stackTrace.replace("@", "%40");
      stackTrace = stackTrace.replace("&", "%26");
      stackTrace = stackTrace.replace("#", "%23");

      URL url =
          new URL(
              applet.getCodeBase(),
              "loadererror.ws?c="
                  + gameVersionIdentifier
                  + "&v1="
                  + SignLink.javaVendor
                  + "&v2="
                  + SignLink.javaVersion
                  + "&e="
                  + stackTrace);

      DataInputStream response = new DataInputStream(url.openStream());

      response.read();
      response.close();
    } catch (Exception ignored) {
    }
  }

  // $FF: renamed from: a (java.lang.Throwable, java.lang.String) d
  public static LoaderRuntimeException create(Throwable throwable, String message) {
    LoaderRuntimeException result;

    if (throwable instanceof LoaderRuntimeException) {
      result = (LoaderRuntimeException) throwable;
      result.message = result.message + ' ' + message;
    } else {
      result = new LoaderRuntimeException(throwable, message);
    }

    return result;
  }

  // $FF: renamed from: a (int, java.lang.String) void
  private static void printErrorToConsole(String message) {
    System.out.println("Error: " + message.replace("%0a", "\n"));
  }

  // $FF: renamed from: a (java.lang.Throwable, boolean) java.lang.String
  public static String getStackTraceFromThrowable(Throwable throwable) throws IOException {
    StringBuilder result = new StringBuilder();

    if (throwable instanceof LoaderRuntimeException) {
      LoaderRuntimeException wrappingException = (LoaderRuntimeException) throwable;
      result.append(wrappingException.message).append(" | ");
      throwable = wrappingException.throwable;
    }

    StringWriter stringWriter = new StringWriter();
    PrintWriter printWriter = new PrintWriter(stringWriter);

    throwable.printStackTrace(printWriter);
    printWriter.close();

    String stackTrace = stringWriter.toString();
    BufferedReader stackTraceStream = new BufferedReader(new StringReader(stackTrace));
    String exceptionMessage = stackTraceStream.readLine();

    while (true) {
      String stackFrame = stackTraceStream.readLine();

      if (stackFrame == null) {
        break;
      }

      int openingParenthesisPOS;
      int closingParenthesisPOS;
      String fullMethodPath;

      resolveStackFrame:
      {
        openingParenthesisPOS = stackFrame.indexOf('(');
        closingParenthesisPOS = stackFrame.indexOf(')', openingParenthesisPOS + 1);

        if (openingParenthesisPOS != -1) {
          fullMethodPath = stackFrame.substring(0, openingParenthesisPOS);
          break resolveStackFrame;
        }

        fullMethodPath = stackFrame;
      }

      fullMethodPath = fullMethodPath.trim();
      fullMethodPath = fullMethodPath.substring(1 + fullMethodPath.lastIndexOf(' '));
      fullMethodPath = fullMethodPath.substring(1 + fullMethodPath.lastIndexOf('\t'));

      result.append(fullMethodPath);

      if (openingParenthesisPOS != -1 && closingParenthesisPOS != -1) {
        // Given 	at
        // java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:581)
        // Find ":581)"
        int lineNumberStartPOS = stackFrame.indexOf(".java:", openingParenthesisPOS);

        if (lineNumberStartPOS >= 0) {
          // And extract substring "581"
          result.append(stackFrame, lineNumberStartPOS + 5, closingParenthesisPOS);
        }
      }

      result.append(" ");
    }

    return result.append("| ").append(exceptionMessage).toString();
  }

  private LoaderRuntimeException(Throwable throwable, String message) {
    this.throwable = throwable;
    this.message = message;
  }
}
