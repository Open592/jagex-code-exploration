package com.jagex.client;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class PacketXteaTest {
  // Produced by invoking iv.a on the original 592 gamepack (SHA-1
  // ec95e23db0322a6e8741ba3a5ff3a25744f1a20e), independently of this client.
  private static final int[][] KEYS = {
    {0, 0, 0, 0}, {0x00112233, 0x44556677, 0x8899aabb, 0xccddeeff}
  };
  private static final String[] PLAIN = {
    "0000000000000000", "000102030405060708090a0b0c0d0e0f"
  };
  private static final String[] CIPHER = {
    "dee9d4d8f7131ed9", "c4b97f2631966c6d65ebf3404889bfb3"
  };

  private static byte[] hex(String value) {
    byte[] bytes = new byte[value.length() / 2];
    for (int i = 0; i < bytes.length; i++) {
      bytes[i] = (byte) Integer.parseInt(value.substring(i * 2, i * 2 + 2), 16);
    }
    return bytes;
  }

  @Test
  void encryptionMatchesOriginalClientVectors() {
    for (int i = 0; i < KEYS.length; i++) {
      byte[] plain = hex(PLAIN[i]);
      byte[] framed = Arrays.copyOf(plain, plain.length + 3);
      Arrays.fill(framed, plain.length, framed.length, (byte) 0x5a);
      Packet packet = new Packet(framed);
      packet.pos = framed.length;
      packet.tinyKeyEncrypt(KEYS[i]);
      assertArrayEquals(hex(CIPHER[i]), Arrays.copyOf(framed, plain.length));
      assertEquals(plain.length, packet.pos);
      assertArrayEquals(new byte[] {0x5a, 0x5a, 0x5a},
          Arrays.copyOfRange(framed, plain.length, framed.length));
    }
  }

  @Test
  void decryptionMatchesOriginalClientAndPreservesFramingAndCursor() {
    for (int i = 0; i < KEYS.length; i++) {
      byte[] cipher = hex(CIPHER[i]);
      byte[] framed = new byte[5 + cipher.length + 3];
      Arrays.fill(framed, (byte) 0x5a);
      System.arraycopy(cipher, 0, framed, 5, cipher.length);
      Packet packet = new Packet(framed);
      packet.pos = 2;
      packet.tinyKeyDecrypt(framed.length, KEYS[i]);
      assertArrayEquals(hex(PLAIN[i]), Arrays.copyOfRange(framed, 5, 5 + cipher.length));
      assertArrayEquals(new byte[] {0x5a, 0x5a, 0x5a, 0x5a, 0x5a}, Arrays.copyOf(framed, 5));
      assertArrayEquals(new byte[] {0x5a, 0x5a, 0x5a},
          Arrays.copyOfRange(framed, 5 + cipher.length, framed.length));
      assertEquals(2, packet.pos);
    }
  }
}
