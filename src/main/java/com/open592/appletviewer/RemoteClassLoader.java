package com.open592.appletviewer;

import java.io.IOException;
import java.net.URL;
import java.security.AllPermission;
import java.security.CodeSource;
import java.security.Permissions;
import java.security.ProtectionDomain;
import java.security.cert.Certificate;
import java.util.Hashtable;

// $FF: renamed from: app.r
final class RemoteClassLoader extends ClassLoader {
   // $FF: renamed from: a java.util.Hashtable
   private final Hashtable<String, Class<?>> classCache = new Hashtable<>();
   // $FF: renamed from: b java.security.ProtectionDomain
   private final ProtectionDomain protectionDomain;
   // $FF: renamed from: c app.m
   private final SignedFileValidator signedFileValidator;

   protected synchronized Class<?> loadClass(String className, boolean shouldResolve) throws ClassNotFoundException {
      Class<?> cachedClass = this.classCache.get(className);

      if (cachedClass == null) {
         byte[] classFileBytes = this.signedFileValidator.validateFile(className + ".class");

         if (classFileBytes != null) {
            cachedClass = this.defineClass(className, classFileBytes, 0, classFileBytes.length, this.protectionDomain);

            if (shouldResolve) {
               this.resolveClass(cachedClass);
            }

            this.classCache.put(className, cachedClass);

            return cachedClass;
         } else {
            return super.findSystemClass(className);
         }
      } else {
         return cachedClass;
      }
   }

   RemoteClassLoader(byte[] classFileBytes) throws IOException {
      this.signedFileValidator = new SignedFileValidator(classFileBytes);
      CodeSource codeSource = new CodeSource(null, (Certificate[])null);
      Permissions permissions = new Permissions();
      permissions.add(new AllPermission());
      this.protectionDomain = new ProtectionDomain(codeSource, permissions);
   }
}
