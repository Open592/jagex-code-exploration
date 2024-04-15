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
final class PatchedClassLoader extends ClassLoader {
    // $FF: renamed from: b java.lang.ClassLoader
   private static ClassLoader systemClassLoader;

   public PatchedClassLoader() {}

   // $FF: renamed from: a (byte) void
   private void patchSystemClassLoader() {
      try {
         systemClassLoader = ClassLoader.getSystemClassLoader();

         Field scl = ClassLoader.class.getDeclaredField("scl");
         scl.setAccessible(true);
         scl.set(systemClassLoader, this);
         scl.setAccessible(false);
      } catch (Throwable ignored) {}
   }

   // $FF: renamed from: a (int) void
   public static void initialize() {
       // $FF: renamed from: a app.u
       PatchedClassLoader self = new PatchedClassLoader();

      self.patchSystemClassLoader();
   }

   public Class<?> loadClass(String name) throws ClassNotFoundException {
      if (!name.equals("netscape.javascript.JSObject")) {
         return fallbackLoadClass(name);
      }

      CodeSource codeSource = new CodeSource(null, (Certificate[])null);
      Permissions permissions = new Permissions();
      permissions.add(new AllPermission());
      ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, permissions);

      try {
         URL JSObjec_Class = this.getClass().getClassLoader().getResource("netscape/javascript/JSObjec_.class");

         if (JSObjec_Class == null) {
            return fallbackLoadClass(name);
         }

         URLConnection connection = JSObjec_Class.openConnection();
         InputStream stream = connection.getInputStream();
         byte[] buffer = new byte[connection.getContentLength()];
         int bytesRead = 0;

         while (bytesRead < buffer.length) {
            bytesRead += stream.read(buffer, bytesRead, buffer.length - bytesRead);
         }

         int var10 = 0;

         while(var10 < buffer.length) {
            int var11 = 255 & buffer[var10];
            if (var11 == 'J') {
               int var12 = 1;

               while(buffer.length > var12 + var10) {
                  if (~(-1 + "JSObject".length()) == ~var12) {
                     buffer[var12 + var10] = (byte)"JSObject".charAt(var12);
                     break;
                  }

                  var11 = buffer[var12 - -var10] & 255;
                  if (~var11 != ~"JSObject".charAt(var12)) {
                     break;
                  }

                  ++var12;
               }
            }

            ++var10;
         }

         return this.defineClass(name, buffer, 0, buffer.length, protectionDomain);
      } catch (IOException ignored) {
         return fallbackLoadClass(name);
      }
   }

   private Class<?> fallbackLoadClass(String name) throws ClassNotFoundException {
      try {
         return this.getClass().getClassLoader().loadClass(name);
      } catch (ClassNotFoundException ignored) {
         return systemClassLoader.loadClass(name);
      }
   }
}
