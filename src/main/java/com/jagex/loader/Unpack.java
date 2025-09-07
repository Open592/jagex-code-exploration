package com.jagex.loader;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Unpack {
  protected HashMap<String, byte[]> cache = new HashMap<>();

  // $FF: renamed from: a (java.lang.String, int) byte[]
  public final byte[] getEntry(String entryName) {
    return this.cache.remove(entryName);
  }

  public Unpack(byte[] zipFileBytes) throws IOException {
    ZipInputStream zipStream = new ZipInputStream(new ByteArrayInputStream(zipFileBytes));
    byte[] buffer = new byte[1000];

    while (true) {
      String entryName;
      do {
        ZipEntry entry = zipStream.getNextEntry();
        if (entry == null) {
          zipStream.close();
          return;
        }

        entryName = entry.getName();
      } while (!entryName.endsWith(".class"));

      entryName = entryName.substring(0, entryName.length() - 6).replace('/', '.');

      ByteArrayOutputStream output = new ByteArrayOutputStream();

      while (true) {
        int entryBytesRead = zipStream.read(buffer, 0, 1000);

        if (entryBytesRead == -1) {
          byte[] entryBytes = output.toByteArray();
          this.cache.put(entryName, entryBytes);

          break;
        }

        output.write(buffer, 0, entryBytesRead);
      }
    }
  }
}
