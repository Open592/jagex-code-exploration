package com.open592.loader;

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
    public static int errorSourceVersion;
    // $FF: renamed from: b java.lang.String
    private String message;
    // $FF: renamed from: c java.lang.Throwable
    private final Throwable throwable;

    // $FF: renamed from: a (java.lang.Throwable, java.lang.String, java.applet.Applet, byte) void
    public static void publishError(Throwable throwable, String var1, Applet applet) {
        try {
            String stackTrace = "";

            if (throwable != null) {
                stackTrace = getStackTraceFromThrowable(throwable);
            }

            if (var1 != null) {
                if (throwable != null) {
                    stackTrace = stackTrace + " | ";
                }

                stackTrace = stackTrace + var1;
            }

            printErrorToConsole(stackTrace);

            stackTrace = replaceCharacter(":", "%3a", stackTrace);
            stackTrace = replaceCharacter("@", "%40", stackTrace);
            stackTrace = replaceCharacter("&", "%26", stackTrace);
            stackTrace = replaceCharacter("#", "%23", stackTrace);

            URL url = new URL(
                    applet.getCodeBase(),
                    "loadererror.ws?c=" + errorSourceVersion + "&v1=" + class_10.javaVendor + "&v2=" + class_10.javaVersion + "&e=" + stackTrace
            );

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
        System.out.println("Error: " + replaceCharacter("%0a", "\n", message));
    }

    // $FF: renamed from: a (java.lang.Throwable, boolean) java.lang.String
    public static String getStackTraceFromThrowable(Throwable throwable) throws IOException {
        boolean var13 = class_2.field_6;

        StringBuilder result = new StringBuilder();

        if (throwable instanceof LoaderRuntimeException) {
            LoaderRuntimeException var3 = (LoaderRuntimeException) throwable;
            result.append(var3.message).append(" | ");
            throwable = var3.throwable;
        }

        errorSourceVersion = -15;

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        throwable.printStackTrace(printWriter);
        printWriter.close();

        String var5 = stringWriter.toString();
        BufferedReader var6 = new BufferedReader(new StringReader(var5));
        String rootError = var6.readLine();

        do {
            String line = var6.readLine();

            if (line == null) {
                break;
            }

            int openingParenthesisPOS;
            int closingParenthesisPOS;
            String var11;
            label40:
            {
                openingParenthesisPOS = line.indexOf('(');
                closingParenthesisPOS = line.indexOf(')', openingParenthesisPOS + 1);
                if (openingParenthesisPOS != -1) {
                    var11 = line.substring(0, openingParenthesisPOS);
                    if (!var13) {
                        break label40;
                    }
                }

                var11 = line;
            }

            var11 = var11.trim();
            var11 = var11.substring(1 + var11.lastIndexOf(' '));
            var11 = var11.substring(1 + var11.lastIndexOf('\t'));

            result.append(var11);
            if (~openingParenthesisPOS != 0 && ~closingParenthesisPOS != 0) {
                int var12 = line.indexOf(".java:", openingParenthesisPOS);
                if (0 <= var12) {
                    result.append(line, 5 + var12, closingParenthesisPOS);
                }
            }

            result.append(" ");
        } while (!var13);

        return result.append(" | ")
                .append(rootError)
                .toString();
    }

    // $FF: renamed from: a (java.lang.String, java.lang.String, int, java.lang.String) java.lang.String
    private static String replaceCharacter(String search, String replace, String string) {
        return string.replace(search, replace);
    }

    private LoaderRuntimeException(Throwable throwable, String message) {
        this.throwable = throwable;
        this.message = message;
    }
}
