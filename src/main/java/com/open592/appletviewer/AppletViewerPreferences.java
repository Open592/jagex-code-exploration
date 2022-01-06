package com.open592.appletviewer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Hashtable;

// $FF: renamed from: app.b
public final class AppletViewerPreferences {
   // $FF: renamed from: a java.util.Hashtable
   private static Hashtable<String, String> preferences = new Hashtable<>();
   // $FF: renamed from: b java.io.File
   private static File preferencesFile = new File("jagexappletviewer.preferences");
   // $FF: renamed from: c int
   public static int field_91;

   // $FF: renamed from: a (int) void
   static void readPreferencesFile() {
      int var6 = field_91;

      try (BufferedReader fileReader = new BufferedReader(new FileReader(preferencesFile))) {

         while (fileReader.ready()) {
            String line = fileReader.readLine();
            int equalPos = line.indexOf("=");
            if (equalPos >= 0) {
               preferences.put(line.substring(0, equalPos), line.substring(equalPos - -1));
               if (var6 != 0) {
                  break;
               }
            }
         }
      } catch (IOException ignored) {
      }

   }

   // $FF: renamed from: a (int, java.lang.String) java.lang.String
   static String getPreference(String name) {
      return preferences.get(name);
   }

   // $FF: renamed from: a (java.lang.String, byte, java.lang.String) void
   public static void addPreference(String var0, byte var1, String var2) {
      preferences.put(var2, var0);
   }

   // $FF: renamed from: a (boolean) void
   public static void writePreferencesToFile(boolean var0) {
      int var6 = field_91;

      try (PrintStream filePrintStream = new PrintStream(new FileOutputStream(preferencesFile))) {
         Enumeration<String> keys = preferences.keys();

         while (keys.hasMoreElements()) {
            String preferenceKey = keys.nextElement();
            String preferenceValue = preferences.get(preferenceKey);
            filePrintStream.println(preferenceKey + "=" + preferenceValue);
            if (var6 != 0) {
               break;
            }
         }

         if (!var0) {
            preferencesFile = (File) null;
         }
      } catch (IOException var9) {
         var9.printStackTrace();
      }

   }
}
