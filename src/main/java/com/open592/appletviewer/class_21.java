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
public final class class_21 {
   // $FF: renamed from: a java.util.Hashtable
   private static Hashtable field_89 = new Hashtable();
   // $FF: renamed from: b java.io.File
   private static File field_90 = new File("jagexappletviewer.preferences");
   // $FF: renamed from: c int
   public static int field_91;

   // $FF: renamed from: a (int) void
   static final void method_41(int var0) {
      int var6 = field_91;
      if (var0 < -89) {
         BufferedReader var1 = null;

         try {
            var1 = new BufferedReader(new FileReader(field_90));

            while(var1.ready()) {
               String var2 = var1.readLine();
               int var3 = var2.indexOf("=");
               if (var3 >= 0) {
                  field_89.put(var2.substring(0, var3), var2.substring(var3 - -1));
                  if (var6 != 0) {
                     break;
                  }
               }
            }
         } catch (IOException var13) {
         } finally {
            if (null != var1) {
               try {
                  var1.close();
               } catch (IOException var12) {
               }
            }

         }

      }
   }

   // $FF: renamed from: a (int, java.lang.String) java.lang.String
   static final String method_42(int var0, String var1) {
      if (var0 != -32237) {
         field_89 = (Hashtable)null;
      }

      return (String)field_89.get(var1);
   }

   // $FF: renamed from: a (java.lang.String, byte, java.lang.String) void
   public static final void method_43(String var0, byte var1, String var2) {
      int var3 = -60 % ((var1 - -6) / 42);
      field_89.put(var2, var0);
   }

   // $FF: renamed from: a (boolean) void
   public static final void method_44(boolean var0) {
      int var6 = field_91;
      PrintStream var1 = null;

      try {
         var1 = new PrintStream(new FileOutputStream(field_90));
         Enumeration var2 = field_89.keys();

         while(var2.hasMoreElements()) {
            String var3 = (String)var2.nextElement();
            String var4 = (String)field_89.get(var3);
            var1.println(var3 + "=" + var4);
            if (var6 != 0) {
               break;
            }
         }

         if (!var0) {
            field_90 = (File)null;
         }
      } catch (IOException var9) {
         var9.printStackTrace();
      } finally {
         if (var1 != null) {
            var1.close();
         }

      }

   }
}
