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
   private Hashtable<String, byte[]> fileMap;
   // $FF: renamed from: b java.util.Hashtable
   private Hashtable<String, class_20> field_65;
   // $FF: renamed from: c java.util.Hashtable
   private Hashtable<String, class_20> field_66;
   // $FF: renamed from: d byte[]
   private byte[] field_67;
   // $FF: renamed from: e sun.security.pkcs.PKCS7
   private PKCS7 PKCS7Block;

   // $FF: renamed from: a (java.lang.String, int) byte[]
   byte[] validateFile(String filename, int var2) {
      int var19 = AppletViewerPreferences.field_91;

      System.out.println("Attempting to validate: " + filename);
      try {
         byte[] var3 = this.fileMap.remove(filename);
         if (var3 == null) {
            return null;
         } else {
            class_20 var4 = this.field_65.get(filename);
            if (null == var4) {
               System.out.println("Var 4 null");
               return null;
            } else {
               class_20 var5 = this.field_66.get(filename);
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
                  if (!var8.equals(var4.md5Digest)) {
                     System.out.println("Var 8" + var8 + " Doesn't equal " + var4.md5Digest);
                     return null;
                  } else {
                     MessageDigest var9 = MessageDigest.getInstance("SHA");
                     var9.reset();
                     var9.update(var3);
                     byte[] var10 = var9.digest();
                     String var11 = class_7.byteArrayToBase64StringEntry(var10);
                     if (!var11.equals(var4.sha1Digest)) {
                        return null;
                     } else {
                        System.out.println(var11 + " Equals: " + var4.sha1Digest);
                        var6.reset();
                        var6.update(var4.buffer);
                        var7 = var6.digest();
                        var8 = class_7.byteArrayToBase64StringEntry(var7);
                        if (!var8.equals(var5.md5Digest)) {
                           return null;
                        } else {
                           System.out.println(var8 + " Equals: " + var5.md5Digest);
                           var9.reset();
                           var9.update(var4.buffer);
                           var10 = var9.digest();
                           var11 = class_7.byteArrayToBase64StringEntry(var10);
                           if (!var11.equals(var5.sha1Digest)) {
                              return null;
                           } else {
                              System.out.println(var11 + " Equals: " + var5.sha1Digest);
                              SignerInfo[] var12 = this.PKCS7Block.verify(this.field_67);
                              if (var12 != null && -1 != ~var12.length) {
                                 ArrayList<X509Certificate> certificateChains = var12[0].getCertificateChain(this.PKCS7Block);
                                 // Originally this was 2
                                 if (certificateChains.size() != 2 && certificateChains.size() != 3) {
                                    return null;
                                 } else {
                                    int var14 = 0;

                                    while(var14 < certificateChains.size()) {
                                       X509Certificate certificateChain = certificateChains.get(var14);
                                       String serialNumber = certificateChain.getSerialNumber().toString();
                                       byte[] publicKeyByteArray = certificateChain.getPublicKey().getEncoded();
                                       String publicKeyString = class_7.byteArrayToBase64StringEntry(publicKeyByteArray);

                                       if (var14 == 0) {
                                          if (!serialNumber.equals("42616207341001253724625765329114307230")) {
                                          }

                                          System.out.println(publicKeyString);
                                          if (!publicKeyString.equals("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxehHTKQFiy/+t7xlQ0UYmmpQyoohClLm5Gfcy9hqwSps8riRS4LH4F3Ii9XnPYYC85R0wMfsfFCQlqgPbHK4X2iuUNw/bAT8jVHeIAIHPrxBaBqIzq92CHfGmLDDWEMQh+R5EpKW6caR0HB38c/eNYce5Do8DwOIMI/tC0LTcfjkgSjB2G19pT38W/ra1XwFVZR3fL/vvUGPiNDdcCcQCniPjYE1wLI/y9iNDfPcEnL92rhq3g5WVYrZ/CAXHAdQ9wCGBRyRgtVM1AjWYranZI9fNj+h/KjRDa+Fsu+k5gKLiKRNz9PGk+mmrBFOWOWMCsjyOalnkkx+N1/Gh4KcRwIDAQAB")) {
                                          }
                                       }

                                       if (var14 == 1) {
                                          if (!serialNumber.equals("10")) {
                                          }

                                          if (!publicKeyString.equals("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDGuLknYK8L45FpZdt+je2R5qrxvtXt/m3ULH/RcHf7JplXtN0/MLjcIepojYGS/C5LkTWEIPLaSrq0/ObaiPIgxSGSCUeVoAkcpnm+sUwd/PGKblTSaaHxTJM6Qf591GR7Y0X3YGAdMR2k6dMPi/tuJiSzqP/l5ZDUtMLcUGCuWQIDAQAB")) {
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
         ModalDialog.displayErrorMessage(AppletViewer.getLocaleString("err_get_file") + ":" + filename + " [" + var20 + "]");
         return null;
      }
   }

   class_13(byte[] jarByteBuf) throws IOException {
      super();
      this.fileMap = new Hashtable<>();
      this.field_65 = new Hashtable<>();
      this.field_66 = new Hashtable<>();
      ZipInputStream jarInputStream = new ZipInputStream(new ByteArrayInputStream(jarByteBuf));
      byte[] var3 = new byte[1000];

      do {
         ZipEntry entry = jarInputStream.getNextEntry();

         if (entry == null) {
            break;
         }

         String entryName = entry.getName();
         ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

         do {
            int bytesRead = jarInputStream.read(var3, 0, 1000);

            if (bytesRead == -1) {
               break;
            }

            outputStream.write(var3, 0, bytesRead);
         } while(true);

         byte[] outputStreamBytes = outputStream.toByteArray();

         if (!entryName.equals("META-INF/manifest.mf") && !entryName.equals("META-INF/zigbert.sf")) {
            if (!entryName.equals("META-INF/zigbert.rsa")) {
               this.fileMap.put(entryName, outputStreamBytes);

               continue;
            }

            this.PKCS7Block = new PKCS7(outputStreamBytes);

            continue;
         }

         int var8 = 0;
         int[] var9 = new int[1000];
         int var10 = 0;

         while(var10 < outputStreamBytes.length - 5) {
            if (78 == outputStreamBytes[var10] && outputStreamBytes[1 + var10] == 97 && -110 == ~outputStreamBytes[2 + var10] && 101 == outputStreamBytes[var10 - -3] && 58 == outputStreamBytes[var10 + 4]) {
               var9[var8++] = var10;
            }

            ++var10;
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
                  var13 = outputStreamBytes.length;

                  break label76;
               }

               var13 = -1 + var9[var10 - -1];
            }

            var11.buffer = new byte[-var12 + var13];
            System.arraycopy(outputStreamBytes, var12, var11.buffer, 0, -var12 + var13);
            int var14 = 0;
            int var15 = 0;

            while(~var11.buffer.length < ~var15) {
               if (~var11.buffer[var15] == -11 || ~var11.buffer[var15] == -14) {
                  String var16 = (new String(var11.buffer, var14, -var14 + var15)).trim();
                  if (var16.startsWith("Name: ")) {
                     var11.name = var16.substring(6);
                  }

                  if (var16.startsWith("MD5-Digest: ")) {
                     var11.md5Digest = var16.substring(12);
                  }

                  var14 = var15 + 1;
                  if (var16.startsWith("SHA1-Digest: ")) {
                     var11.sha1Digest = var16.substring(13);
                  }
               }

               ++var15;
            }

            if (entryName.equalsIgnoreCase("META-INF/manifest.mf")) {
               this.field_65.put(var11.name, var11);
            }

            if (entryName.equalsIgnoreCase("META-INF/zigbert.sf")) {
               this.field_66.put(var11.name, var11);
            }

            ++var10;
         }

         if (entryName.equalsIgnoreCase("META-INF/zigbert.sf")) {
            this.field_67 = outputStreamBytes;
         }
      } while(true);
   }
}
