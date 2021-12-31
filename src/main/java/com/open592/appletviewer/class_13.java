package com.open592.appletviewer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import sun.security.pkcs.PKCS7;
import sun.security.pkcs.SignerInfo;

// $FF: renamed from: app.m
final class class_13 {
   // $FF: renamed from: a java.util.Hashtable
   private Hashtable field_64;
   // $FF: renamed from: b java.util.Hashtable
   private Hashtable field_65;
   // $FF: renamed from: c java.util.Hashtable
   private Hashtable field_66;
   // $FF: renamed from: d byte[]
   private byte[] field_67;
   // $FF: renamed from: e sun.security.pkcs.PKCS7
   private PKCS7 field_68;

   // $FF: renamed from: a (java.lang.String, int) byte[]
   byte[] method_33(String var1, int var2) {
      int var19 = class_21.field_91;

      System.out.println("Attempting to validate" + var1);
      try {
         byte[] var3 = (byte[]) this.field_64.remove(var1);
         if (var3 == null) {
            System.out.println("Var 3 null");
            return null;
         } else {
            class_20 var4 = (class_20)this.field_65.get(var1);
            if (null == var4) {
               System.out.println("Var 4 null");
               return null;
            } else {
               class_20 var5 = (class_20)this.field_66.get(var1);
               if (var5 == null) {
                  System.out.println("Var 5 null");
                  return null;
               } else {
                  MessageDigest var6 = MessageDigest.getInstance("MD5");
                  var6.reset();
                  var6.update(var3);
                  byte[] var7 = var6.digest();
                  if (var2 > -124) {
                     this.field_66 = null;
                  }

                  String var8 = class_7.byteArrayToBase64StringEntry(var7);
                  if (!var8.equals(var4.field_86)) {
                     System.out.println("Var 8" + var8 + " Doesn't equal " + var4.field_86);
                     return null;
                  } else {
                     MessageDigest var9 = MessageDigest.getInstance("SHA");
                     var9.reset();
                     var9.update(var3);
                     byte[] var10 = var9.digest();
                     String var11 = class_7.byteArrayToBase64StringEntry(var10);
                     if (!var11.equals(var4.field_88)) {
                        return null;
                     } else {
                        System.out.println(var11 + " Equals: " + var4.field_88);
                        var6.reset();
                        var6.update(var4.field_85);
                        var7 = var6.digest();
                        var8 = class_7.byteArrayToBase64StringEntry(var7);
                        if (!var8.equals(var5.field_86)) {
                           return null;
                        } else {
                           System.out.println(var8 + " Equals: " + var5.field_86);
                           var9.reset();
                           var9.update(var4.field_85);
                           var10 = var9.digest();
                           var11 = class_7.byteArrayToBase64StringEntry(var10);
                           if (!var11.equals(var5.field_88)) {
                              return null;
                           } else {
                              System.out.println(var11 + " Equals: " + var5.field_88);
                              SignerInfo[] var12 = this.field_68.verify(this.field_67);
                              if (var12 != null && -1 != ~var12.length) {
                                 ArrayList<X509Certificate> var13 = var12[0].getCertificateChain(this.field_68);
                                 if (3 != var13.size()) {
                                    return null;
                                 } else {
                                    int var14 = 0;

                                    while(var14 < var13.size()) {
                                       X509Certificate var15 = var13.get(var14);
                                       String var16 = var15.getSerialNumber().toString();
                                       byte[] var17 = var15.getPublicKey().getEncoded();
                                       String var18 = class_7.byteArrayToBase64StringEntry(var17);
                                       if (-1 == ~var14) {
                                          System.out.println("-1");
                                          System.out.println(var16);
                                          if (!var16.equals("42616207341001253724625765329114307230")) {
                                             return null;
                                          }

                                          System.out.println(var18);
                                          if (!var18.equals("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxehHTKQFiy/+t7xlQ0UYmmpQyoohClLm5Gfcy9hqwSps8riRS4LH4F3Ii9XnPYYC85R0wMfsfFCQlqgPbHK4X2iuUNw/bAT8jVHeIAIHPrxBaBqIzq92CHfGmLDDWEMQh+R5EpKW6caR0HB38c/eNYce5Do8DwOIMI/tC0LTcfjkgSjB2G19pT38W/ra1XwFVZR3fL/vvUGPiNDdcCcQCniPjYE1wLI/y9iNDfPcEnL92rhq3g5WVYrZ/CAXHAdQ9wCGBRyRgtVM1AjWYranZI9fNj+h/KjRDa+Fsu+k5gKLiKRNz9PGk+mmrBFOWOWMCsjyOalnkkx+N1/Gh4KcRwIDAQAB")) {
                                             return null;
                                          }
                                       }

                                       if (~var14 == -2) {
                                          System.out.println("-2");
                                          System.out.println(var16);
                                          if (!var16.equals("10")) {
                                             return null;
                                          }

                                          System.out.println(var18);
                                          if (!var18.equals("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDGuLknYK8L45FpZdt+je2R5qrxvtXt/m3ULH/RcHf7JplXtN0/MLjcIepojYGS/C5LkTWEIPLaSrq0/ObaiPIgxSGSCUeVoAkcpnm+sUwd/PGKblTSaaHxTJM6Qf591GR7Y0X3YGAdMR2k6dMPi/tuJiSzqP/l5ZDUtMLcUGCuWQIDAQAB")) {
                                             return null;
                                          }
                                       }

                                       ++var14;
                                       if (var19 != 0) {
                                          break;
                                       }
                                    }

                                    return var3;
                                 }
                              } else {
                                 return null;
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      } catch (Exception var20) {
         var20.printStackTrace();
         class_19.method_40((byte)47, AppletViewer.method_19("err_get_file", 0) + ":" + var1 + " [" + var20 + "]");
         return null;
      }
   }

   class_13(byte[] var1) throws IOException {
      super();
      int var17 = class_21.field_91;
      this.field_64 = new Hashtable();
      this.field_65 = new Hashtable();
      this.field_66 = new Hashtable();
      ZipInputStream var2 = new ZipInputStream(new ByteArrayInputStream(var1));
      byte[] var3 = new byte[1000];

      do {
         ZipEntry var4 = var2.getNextEntry();
         if (var4 == null) {
            break;
         }

         String var5 = var4.getName();
         ByteArrayOutputStream var6 = new ByteArrayOutputStream();

         do {
            int var7 = var2.read(var3, 0, 1000);
            if (0 == ~var7 && var17 == 0) {
               break;
            }

            var6.write(var3, 0, var7);
         } while(var17 == 0);

         byte[] var18 = var6.toByteArray();
         if (!var5.equals("META-INF/manifest.mf") && !var5.equals("META-INF/zigbert.sf")) {
            if (!var5.equals("META-INF/zigbert.rsa")) {
               this.field_64.put(var5, var18);
               if (var17 == 0) {
                  continue;
               }
            }

            this.field_68 = new PKCS7(var18);
            if (var17 == 0) {
               continue;
            }
         }

         int var8 = 0;
         int[] var9 = new int[1000];
         int var10 = 0;

         while(var10 < var18.length - 5) {
            if (78 == var18[var10] && var18[1 + var10] == 97 && -110 == ~var18[2 + var10] && 101 == var18[var10 - -3] && 58 == var18[var10 + 4]) {
               var9[var8++] = var10;
            }

            ++var10;
            if (var17 != 0) {
               break;
            }
         }

         var10 = 0;

         while(var8 > var10) {
            class_20 var11;
            int var12;
            int var13;
            label76: {
               var11 = new class_20();
               var12 = var9[var10];
               if (var8 <= 1 + var10) {
                  var13 = var18.length;
                  if (var17 == 0) {
                     break label76;
                  }
               }

               var13 = -1 + var9[var10 - -1];
            }

            var11.field_85 = new byte[-var12 + var13];
            System.arraycopy(var18, var12, var11.field_85, 0, -var12 + var13);
            int var14 = 0;
            int var15 = 0;

            while(~var11.field_85.length < ~var15) {
               if (~var11.field_85[var15] == -11 || ~var11.field_85[var15] == -14) {
                  String var16 = (new String(var11.field_85, var14, -var14 + var15)).trim();
                  if (var16.startsWith("Name: ")) {
                     var11.field_87 = var16.substring(6);
                  }

                  if (var16.startsWith("MD5-Digest: ")) {
                     var11.field_86 = var16.substring(12);
                  }

                  var14 = var15 + 1;
                  if (var16.startsWith("SHA1-Digest: ")) {
                     var11.field_88 = var16.substring(13);
                  }
               }

               ++var15;
               if (var17 != 0) {
                  break;
               }
            }

            if (var5.equalsIgnoreCase("META-INF/manifest.mf")) {
               this.field_65.put(var11.field_87, var11);
            }

            if (var5.equalsIgnoreCase("META-INF/zigbert.sf")) {
               this.field_66.put(var11.field_87, var11);
            }

            ++var10;
            if (var17 != 0) {
               break;
            }
         }

         if (var5.equalsIgnoreCase("META-INF/zigbert.sf")) {
            this.field_67 = var18;
         }
      } while(var17 == 0);

   }
}
