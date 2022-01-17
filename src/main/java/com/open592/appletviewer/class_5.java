package com.open592.appletviewer;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLConnection;
import java.security.AllPermission;
import java.security.CodeSource;
import java.security.Permissions;
import java.security.ProtectionDomain;
import java.security.cert.Certificate;

// $FF: renamed from: app.u
final class class_5 extends ClassLoader {
   // $FF: renamed from: a app.u
   private static class_5 field_19;
   // $FF: renamed from: b java.lang.ClassLoader
   private static ClassLoader field_20;

   public class_5() {
   }

   // $FF: renamed from: a (byte) void
   private final void method_3(byte var1) {
      try {
         int var2 = -35 / ((var1 - -44) / 45);
         field_20 = ClassLoader.getSystemClassLoader();
         Field var3 = ClassLoader.class.getDeclaredField("scl");
         var3.setAccessible(true);
         var3.set(field_20, this);
         var3.setAccessible(false);
      } catch (Throwable var4) {
      }

   }

   // $FF: renamed from: a (int) void
   static final void method_4(int var0) {
      field_19 = new class_5();
      if (var0 != 255) {
         field_20 = (ClassLoader)null;
      }

      field_19.method_3((byte)88);
   }

   public final Class loadClass(String var1) throws ClassNotFoundException {
      if ("netscape.javascript.JSObject".equals(var1)) {
         CodeSource var2 = new CodeSource((URL)null, (Certificate[])null);
         Permissions var3 = new Permissions();
         var3.add(new AllPermission());
         ProtectionDomain var4 = new ProtectionDomain(var2, var3);

         try {
            URL var5 = this.getClass().getClassLoader().getResource("netscape/javascript/JSObjec_.class");
            URLConnection var6 = var5.openConnection();
            InputStream var7 = var6.getInputStream();
            byte[] var8 = new byte[var6.getContentLength()];
            int var9 = 0;

            while(~var8.length < ~var9) {
               var9 += var7.read(var8, var9, -var9 + var8.length);
            }

            int var10 = 0;

            while(var10 < var8.length) {
               int var11 = 255 & var8[var10];
               if (var11 == "JSObject".charAt(0)) {
                  int var12 = 1;

                  while(var8.length > var12 + var10) {
                     if (~(-1 + "JSObject".length()) == ~var12) {
                        var8[var12 + var10] = (byte)"JSObject".charAt(var12);
                        break;
                     }

                     var11 = var8[var12 - -var10] & 255;
                     if (~var11 != ~"JSObject".charAt(var12)) {
                        break;
                     }

                     ++var12;
                  }
               }

               ++var10;
            }

            Class var16 = this.defineClass(var1, var8, 0, var8.length, var4);
            return var16;
         } catch (IOException var15) {
            var15.printStackTrace();
         }
      }

      try {
         return this.getClass().getClassLoader().loadClass(var1);
      } catch (Exception var14) {
         return field_20.loadClass(var1);
      }
   }
}
