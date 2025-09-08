package com.jagex.client;

public final class CRC32Checksum {
  public static final int[] CRCTable32 = new int[256];

  static {
    init();
  }

  public static int calculateChecksum(int length, byte[] buffer) {
    return calculateChecksum(buffer, length, 0);
  }

  public static int calculateChecksum(byte[] buffer, int length, int offset) {
    int checksum = -1;

    for (int i = offset; i < length; i++) {
      checksum = CRCTable32[(checksum ^ buffer[i]) & 0xFF] ^ checksum >>> 8;
    }

    return ~checksum;
  }

  private static void init() {
    for (int i = 0; i < 256; i++) {
      int r = i;

      for (int j = 0; j < 8; j++) {
        if ((r & 0x1) == 1) {
          r = r >>> 1 ^ 0xEDB88320;
        } else {
          r >>>= 0x1;
        }
      }

      CRCTable32[i] = r;
    }
  }
}
