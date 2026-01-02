package com.jagex.client.encoding;

public final class Base37 {
  public static long encode(String str) {
    long res = 0L;
    int len = str.length();

    for (int i = 0; i < len; i++) {
      res *= 37L;
      char c = str.charAt(i);

      if (c >= 'A' && c <= 'Z') {
        res += c + 1 - 65;
      } else if (c >= 'a' && c <= 'z') {
        res += c + 1 - 97;
      } else if (c >= '0' && c <= '9') {
        res += c + 27 - 48;
      }

      if (res >= 177917621779460413L) {
        break;
      }
    }

    while (res % 37L == 0L && res != 0L) {
      res /= 37L;
    }

    return res;
  }
}
