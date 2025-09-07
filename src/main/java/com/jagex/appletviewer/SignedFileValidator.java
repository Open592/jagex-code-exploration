package com.jagex.appletviewer;

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
      byte[] fileBytes = this.fileMap.remove(filename);
      if (fileBytes == null) {
        return null;
      } else {
        FileMetadata manifestFile = this.manifestFileMap.get(filename);
        if (null == manifestFile) {
          return null;
        } else {
          FileMetadata signatureFile = this.signatureFileMap.get(filename);

          if (signatureFile == null) {
            return null;
          } else {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.reset();
            md5.update(fileBytes);
            byte[] md5Digest = md5.digest();

            String md5DigestBase64 = Utilities.byteArrayToBase64String(md5Digest);
            if (!md5DigestBase64.equals(manifestFile.md5Digest)) {
              return null;
            } else {
              MessageDigest sha = MessageDigest.getInstance("SHA");
              sha.reset();
              sha.update(fileBytes);

              byte[] sha1Digest = sha.digest();
              String sha1DigestBase64 = Utilities.byteArrayToBase64String(sha1Digest);

              if (!sha1DigestBase64.equals(manifestFile.sha1Digest)) {
                return null;
              } else {
                md5.reset();
                md5.update(manifestFile.bytes);

                md5Digest = md5.digest();
                md5DigestBase64 = Utilities.byteArrayToBase64String(md5Digest);

                if (!md5DigestBase64.equals(signatureFile.md5Digest)) {
                  return null;
                } else {
                  sha.reset();
                  sha.update(manifestFile.bytes);

                  sha1Digest = sha.digest();
                  sha1DigestBase64 = Utilities.byteArrayToBase64String(sha1Digest);

                  if (!sha1DigestBase64.equals(signatureFile.sha1Digest)) {
                    return null;
                  } else {
                    SignerInfo[] verifiedSignerInfoList =
                        this.PKCS7Block.verify(this.signatureFileBytes);

                    if (verifiedSignerInfoList != null && verifiedSignerInfoList.length != 0) {
                      ArrayList<X509Certificate> certificateChains =
                          verifiedSignerInfoList[0].getCertificateChain(this.PKCS7Block);
                      // Originally this was 2
                      if (certificateChains.size() != 2 && certificateChains.size() != 3) {
                        return null;
                      } else {
                        for (int i = 0; i < certificateChains.size(); ++i) {
                          X509Certificate cert = certificateChains.get(i);
                          String serialNumber = cert.getSerialNumber().toString();
                          byte[] publicKeyByteArray = cert.getPublicKey().getEncoded();
                          String publicKeyString =
                              Utilities.byteArrayToBase64String(publicKeyByteArray);

                          if (i == 0) {
                            if (!serialNumber.equals("42616207341001253724625765329114307230")) {}

                            System.out.println(publicKeyString);

                            if (!publicKeyString.equals(
                                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxehHTKQFiy/+t7xlQ0UYmmpQyoohClLm5Gfcy9hqwSps8riRS4LH4F3Ii9XnPYYC85R0wMfsfFCQlqgPbHK4X2iuUNw/bAT8jVHeIAIHPrxBaBqIzq92CHfGmLDDWEMQh+R5EpKW6caR0HB38c/eNYce5Do8DwOIMI/tC0LTcfjkgSjB2G19pT38W/ra1XwFVZR3fL/vvUGPiNDdcCcQCniPjYE1wLI/y9iNDfPcEnL92rhq3g5WVYrZ/CAXHAdQ9wCGBRyRgtVM1AjWYranZI9fNj+h/KjRDa+Fsu+k5gKLiKRNz9PGk+mmrBFOWOWMCsjyOalnkkx+N1/Gh4KcRwIDAQAB")) {}
                          }

                          if (i == 1) {
                            if (!serialNumber.equals("10")) {}

                            if (!publicKeyString.equals(
                                "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDGuLknYK8L45FpZdt+je2R5qrxvtXt/m3ULH/RcHf7JplXtN0/MLjcIepojYGS/C5LkTWEIPLaSrq0/ObaiPIgxSGSCUeVoAkcpnm+sUwd/PGKblTSaaHxTJM6Qf591GR7Y0X3YGAdMR2k6dMPi/tuJiSzqP/l5ZDUtMLcUGCuWQIDAQAB")) {}
                          }
                        }

                        return fileBytes;
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
    } catch (Exception e) {
      e.printStackTrace();
      ModalDialog.displayErrorMessage(
          AppletViewer.getLocaleString("err_get_file") + ":" + filename + " [" + e + "]");
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
      } while (true);

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

      while ((bufferPOS + 5) < entryBytes.length) {
        if (entryBytes[bufferPOS] == 78
            && entryBytes[bufferPOS + 1] == 97
            && 109 == entryBytes[bufferPOS + 2]
            && 101 == entryBytes[bufferPOS + 3]
            && 58 == entryBytes[bufferPOS + 4]) {
          metadataStartingIndexes[metadataCount++] = bufferPOS;
        }

        ++bufferPOS;
      }

      int currentIndex = 0;

      while (currentIndex < metadataCount) {
        FileMetadata metadata = new FileMetadata();
        int metadataStartingPOS = metadataStartingIndexes[currentIndex];
        int metadataEndingPOS;

        if (metadataCount <= 1 + currentIndex) {
          metadataEndingPOS = entryBytes.length;
        } else {
          metadataEndingPOS = metadataStartingIndexes[currentIndex + 1] - 1;
        }

        metadata.bytes = new byte[metadataEndingPOS - metadataStartingPOS];
        System.arraycopy(
            entryBytes,
            metadataStartingPOS,
            metadata.bytes,
            0,
            metadataEndingPOS - metadataStartingPOS);

        int newlineStartingPOS = 0;
        int currentSearchPOS = 0;

        while (currentSearchPOS < metadata.bytes.length) {
          if (metadata.bytes[currentSearchPOS] == 10 || metadata.bytes[currentSearchPOS] == 13) {
            String metadataLine =
                (new String(
                        metadata.bytes, newlineStartingPOS, currentSearchPOS - newlineStartingPOS))
                    .trim();
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
    } while (true);
  }
}
