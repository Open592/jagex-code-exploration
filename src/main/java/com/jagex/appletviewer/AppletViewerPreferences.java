package com.jagex.appletviewer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Optional;

// $FF: renamed from: app.b
public final class AppletViewerPreferences {
  // $FF: renamed from: a java.util.Hashtable
  private static final Hashtable<String, String> preferences = new Hashtable<>();
  // $FF: renamed from: b java.io.File
  private static final File preferencesFile = new File("jagexappletviewer.preferences");

  // $FF: renamed from: a (int) void
  static void readPreferencesFile() {
    try (BufferedReader fileReader = new BufferedReader(new FileReader(preferencesFile))) {
      while (fileReader.ready()) {
        String line = fileReader.readLine();
        int equalPos = line.indexOf("=");
        if (equalPos >= 0) {
          preferences.put(line.substring(0, equalPos), line.substring(equalPos - -1));
        }
      }
    } catch (IOException ignored) {
    }
  }

  // $FF: renamed from: a (int, java.lang.String) java.lang.String
  static Optional<String> getPreference(String name) {
    return Optional.ofNullable(preferences.get(name));
  }

  // $FF: renamed from: a (java.lang.String, byte, java.lang.String) void
  public static void addPreference(String value, String name) {
    preferences.put(name, value);
  }

  // $FF: renamed from: a (boolean) void
  public static void writePreferencesToFile() {
    try (PrintStream filePrintStream = new PrintStream(new FileOutputStream(preferencesFile))) {
      Enumeration<String> keys = preferences.keys();

      while (keys.hasMoreElements()) {
        String preferenceKey = keys.nextElement();
        String preferenceValue = preferences.get(preferenceKey);
        filePrintStream.println(preferenceKey + "=" + preferenceValue);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
