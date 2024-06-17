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
public class class_5 extends RuntimeException {
   // $FF: renamed from: a int
   public static int field_14;
   // $FF: renamed from: b java.lang.String
   private String field_15;
   // $FF: renamed from: c java.lang.Throwable
   private Throwable field_16;
   // $FF: renamed from: d int
   public static int field_17;

   // $FF: renamed from: a (java.lang.Throwable, java.lang.String, java.applet.Applet, byte) void
   public static void method_9(Throwable var0, String var1, Applet var2, byte var3) {
      try {
         try {
            String var4 = "";
            if (null != var0) {
               var4 = method_12(var0, true);
            }

            if (null != var1) {
               if (null != var0) {
                  var4 = var4 + " | ";
               }

               var4 = var4 + var1;
            }

            method_11(-105, var4);
            var4 = method_13(":", "%3a", 0, var4);
            var4 = method_13("@", "%40", 0, var4);
            var4 = method_13("&", "%26", 0, var4);
            int var5 = 122 / ((var3 - -36) / 61);
            var4 = method_13("#", "%23", 0, var4);
            URL var6 = new URL(var2.getCodeBase(), "loadererror.ws?c=" + field_14 + "&v1=" + class_10.field_66 + "&v2=" + class_10.field_50 + "&e=" + var4);
            DataInputStream var7 = new DataInputStream(var6.openStream());
            var7.read();
            var7.close();
         } catch (Exception var8) {
         }

      } catch (RuntimeException var9) {
         throw var9;
      }
   }

   // $FF: renamed from: a (java.lang.Throwable, java.lang.String) d
   public static class_5 method_10(Throwable var0, String var1) {
      try {
         class_5 var2;
         if (var0 instanceof class_5) {
            var2 = (class_5)var0;
            var2.field_15 = var2.field_15 + ' ' + var1;
         } else {
            var2 = new class_5(var0, var1);
         }

         return var2;
      } catch (RuntimeException var3) {
         throw var3;
      }
   }

   // $FF: renamed from: a (int, java.lang.String) void
   private static final void method_11(int var0, String var1) {
      try {
         System.out.println("Error: " + method_13("%0a", "\n", 0, var1));
         if (var0 >= -72) {
            method_9((Throwable)null, (String)null, (Applet)null, (byte)50);
         }

      } catch (RuntimeException var3) {
         throw var3;
      }
   }

   // $FF: renamed from: a (java.lang.Throwable, boolean) java.lang.String
   public static String method_12(Throwable var0, boolean var1) throws IOException {
      boolean var13 = class_2.field_6;

      try {
         String var2;
         label50: {
            if (var0 instanceof class_5) {
               class_5 var3 = (class_5)var0;
               var2 = var3.field_15 + " | ";
               var0 = var3.field_16;
               if (!var13) {
                  break label50;
               }

               int var14 = field_17;
               ++var14;
               field_17 = var14;
            }

            var2 = "";
         }

         if (!var1) {
            field_14 = -15;
         }

         StringWriter var16 = new StringWriter();
         PrintWriter var4 = new PrintWriter(var16);
         var0.printStackTrace(var4);
         var4.close();
         String var5 = var16.toString();
         BufferedReader var6 = new BufferedReader(new StringReader(var5));
         String var7 = var6.readLine();

         do {
            String var8 = var6.readLine();
            if (null == var8) {
               break;
            }

            int var9;
            int var10;
            String var11;
            label40: {
               var9 = var8.indexOf(40);
               var10 = var8.indexOf(41, 1 + var9);
               if (-1 != var9) {
                  var11 = var8.substring(0, var9);
                  if (!var13) {
                     break label40;
                  }
               }

               var11 = var8;
            }

            var11 = var11.trim();
            var11 = var11.substring(1 + var11.lastIndexOf(32));
            var11 = var11.substring(1 + var11.lastIndexOf(9));
            var2 = var2 + var11;
            if (~var9 != 0 && ~var10 != 0) {
               int var12 = var8.indexOf(".java:", var9);
               if (0 <= var12) {
                  var2 = var2 + var8.substring(5 + var12, var10);
               }
            }

            var2 = var2 + ' ';
         } while(!var13);

         var2 = var2 + "| " + var7;
         return var2;
      } catch (RuntimeException var15) {
         throw var15;
      }
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String, int, java.lang.String) java.lang.String
   private static final String method_13(String var0, String var1, int var2, String var3) {
      boolean var5 = class_2.field_6;

      try {
         if (var2 != 0) {
            field_14 = -62;
         }

         int var4 = var3.indexOf(var0);

         while(0 != ~var4) {
            var3 = var3.substring(0, var4) + var1 + var3.substring(var0.length() + var4);
            var4 = var3.indexOf(var0, var1.length() + var4);
            if (var5) {
               break;
            }
         }

         return var3;
      } catch (RuntimeException var6) {
         throw var6;
      }
   }

   private class_5(Throwable var1, String var2) {
      try {
         this.field_15 = var2;
         this.field_16 = var1;
      } catch (RuntimeException var4) {
         throw var4;
      }
   }
}
