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
final class SignedFileValidator {
   // $FF: renamed from: a java.util.Hashtable
   private final Hashtable<String, byte[]> fileMap;
   // $FF: renamed from: b java.util.Hashtable
   private final Hashtable<String, FileMetadata> manifestFileMap;
   // $FF: renamed from: c java.util.Hashtable
   private final Hashtable<String, FileMetadata> signatureFileMap;
   // $FF: renamed from: d byte[]
   private byte[] signatureFileBytes;
   // $FF: renamed from: e sun.security.pkcs.PKCS7
   private PKCS7 PKCS7Block;

   // $FF: renamed from: a (java.lang.String, int) byte[]
   byte[] validateFile(String filename) {
      try {
         byte[] var3 = this.fileMap.remove(filename);
         if (var3 == null) {
            return null;
         } else {
            FileMetadata var4 = this.manifestFileMap.get(filename);
            if (null == var4) {
               System.out.println("Var 4 null");
               return null;
            } else {
               FileMetadata var5 = this.signatureFileMap.get(filename);
               if (var5 == null) {
                  System.out.println("Var 5 null");
                  return null;
               } else {
                  System.out.println("Attempting to validate: " + filename);

                  MessageDigest var6 = MessageDigest.getInstance("MD5");
                  var6.reset();
                  var6.update(var3);
                  byte[] var7 = var6.digest();

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
                        var6.update(var4.bytes);
                        var7 = var6.digest();
                        var8 = class_7.byteArrayToBase64StringEntry(var7);
                        if (!var8.equals(var5.md5Digest)) {
                           return null;
                        } else {
                           System.out.println(var8 + " Equals: " + var5.md5Digest);
                           var9.reset();
                           var9.update(var4.bytes);
                           var10 = var9.digest();
                           var11 = class_7.byteArrayToBase64StringEntry(var10);
                           if (!var11.equals(var5.sha1Digest)) {
                              return null;
                           } else {
                              System.out.println(var11 + " Equals: " + var5.sha1Digest);
                              SignerInfo[] var12 = this.PKCS7Block.verify(this.signatureFileBytes);
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

   SignedFileValidator(byte[] fileBuffer) throws IOException {
      super();
      this.fileMap = new Hashtable<>();
      this.manifestFileMap = new Hashtable<>();
      this.signatureFileMap = new Hashtable<>();
      ZipInputStream jarInputStream = new ZipInputStream(new ByteArrayInputStream(fileBuffer));
      byte[] entryBuffer = new byte[1000];

      do {
         ZipEntry entry = jarInputStream.getNextEntry();

         if (entry == null) {
            break;
         }

         String entryName = entry.getName();
         ByteArrayOutputStream entryByteOutputStream = new ByteArrayOutputStream();

         do {
            int bytesRead = jarInputStream.read(entryBuffer, 0, 1000);

            if (bytesRead == -1) {
               break;
            }

            entryByteOutputStream.write(entryBuffer, 0, bytesRead);
         } while(true);

         byte[] entryBytes = entryByteOutputStream.toByteArray();

         if (!entryName.equals("META-INF/manifest.mf") && !entryName.equals("META-INF/zigbert.sf")) {
            if (!entryName.equals("META-INF/zigbert.rsa")) {
               this.fileMap.put(entryName, entryBytes);

               continue;
            }

            this.PKCS7Block = new PKCS7(entryBytes);

            continue;
         }

         int metadataCount = 0;
         int[] metadataStartingIndexes = new int[1000];
         int bufferPOS = 0;

         while((bufferPOS + 5) < entryBytes.length) {
            if (entryBytes[bufferPOS] == 78 && entryBytes[bufferPOS + 1] == 97 && 109 == entryBytes[bufferPOS + 2] && 101 == entryBytes[bufferPOS + 3] && 58 == entryBytes[bufferPOS + 4]) {
               metadataStartingIndexes[metadataCount++] = bufferPOS;
            }

            ++bufferPOS;
         }

         int currentIndex = 0;

         while(currentIndex < metadataCount) {
            FileMetadata metadata = new FileMetadata();
            int metadataStartingPOS = metadataStartingIndexes[currentIndex];
            int metadataEndingPOS;

            if (metadataCount <= 1 + currentIndex) {
               metadataEndingPOS = entryBytes.length;
            } else {
               metadataEndingPOS = metadataStartingIndexes[currentIndex + 1] - 1;
            }

            metadata.bytes = new byte[metadataEndingPOS - metadataStartingPOS];
            System.arraycopy(entryBytes, metadataStartingPOS, metadata.bytes, 0, metadataEndingPOS - metadataStartingPOS);

            int newlineStartingPOS = 0;
            int currentSearchPOS = 0;

            while (currentSearchPOS < metadata.bytes.length) {
               if (metadata.bytes[currentSearchPOS] == 10 || metadata.bytes[currentSearchPOS] == 13) {
                  String metadataLine = (new String(metadata.bytes, newlineStartingPOS, currentSearchPOS - newlineStartingPOS)).trim();
                  if (metadataLine.startsWith("Name: ")) {
                     metadata.name = metadataLine.substring(6);
                  }

                  if (metadataLine.startsWith("MD5-Digest: ")) {
                     metadata.md5Digest = metadataLine.substring(12);
                  }

                  if (metadataLine.startsWith("SHA1-Digest: ")) {
                     metadata.sha1Digest = metadataLine.substring(13);
                  }

                  newlineStartingPOS = currentSearchPOS + 1;
               }

               ++currentSearchPOS;
            }

            if (entryName.equalsIgnoreCase("META-INF/manifest.mf")) {
               this.manifestFileMap.put(metadata.name, metadata);
            }

            if (entryName.equalsIgnoreCase("META-INF/zigbert.sf")) {
               this.signatureFileMap.put(metadata.name, metadata);
            }

            ++currentIndex;
         }

         if (entryName.equalsIgnoreCase("META-INF/zigbert.sf")) {
            this.signatureFileBytes = entryBytes;
         }
      } while(true);
   }
}
