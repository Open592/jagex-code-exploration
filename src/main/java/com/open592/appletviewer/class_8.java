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
final class class_8 extends ClassLoader {
   // $FF: renamed from: a java.util.Hashtable
   private Hashtable field_26 = new Hashtable();
   // $FF: renamed from: b java.security.ProtectionDomain
   private ProtectionDomain field_27;
   // $FF: renamed from: c app.m
   private class_13 field_28;

   protected final synchronized Class loadClass(String var1, boolean var2) throws ClassNotFoundException {
      Class var3 = (Class)this.field_26.get(var1);
      if (null == var3) {
         byte[] var4 = this.field_28.validateFile(var1 + ".class");
         if (null != var4) {
            var3 = this.defineClass(var1, var4, 0, var4.length, this.field_27);
            if (var2) {
               this.resolveClass(var3);
            }

            this.field_26.put(var1, var3);
            return var3;
         } else {
            return super.findSystemClass(var1);
         }
      } else {
         return var3;
      }
   }

   class_8(byte[] var1) throws IOException {
      this.field_28 = new class_13(var1);
      CodeSource var2 = new CodeSource((URL)null, (Certificate[])null);
      Permissions var3 = new Permissions();
      var3.add(new AllPermission());
      this.field_27 = new ProtectionDomain(var2, var3);
   }
}
