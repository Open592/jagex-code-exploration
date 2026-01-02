package com.jagex.client.encoding;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Base37 {
  public static final char[] BASE37_TABLE =
      new char[] {
        '_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
        'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
        '9'
      };

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

  public static String decodeLower(long input) {
    if (input <= 0L || input >= 6582952005840035281L) {
      return null;
    }

    if (input % 37L == 0L) {
      return null;
    }

    int len = 0;

    for (long local36 = input; local36 != 0L; local36 /= 37L) {
      len++;
    }

    StringBuilder res = new StringBuilder(len);

    while (input != 0L) {
      long prev = input;
      input /= 37L;
      res.append(BASE37_TABLE[(int) (prev - input * 37L)]);
    }

    return res.reverse().toString();
  }

  @OriginalMember(owner = "client!cb", name = "b", descriptor = "(JI)Ljava/lang/String;")
  public static String method766(@OriginalArg(0) long arg0) {
    if (arg0 <= 0L || arg0 >= 6582952005840035281L) {
      return null;
    } else if (arg0 % 37L == 0L) {
      return null;
    } else {
      @Pc(29)
      int local29 = 0;
      for (@Pc(36) long local36 = arg0; local36 != 0L; local36 /= 37L) {
        local29++;
      }
      @Pc(52)
      StringBuilder local52 = new StringBuilder(local29);
      while (arg0 != 0L) {
        @Pc(56)
        long local56 = arg0;
        arg0 /= 37L;
        @Pc(70)
        char local70 = BASE37_TABLE[(int) (local56 - arg0 * 37L)];
        if (local70 == '_') {
          @Pc(80)
          int local80 = local52.length() - 1;
          local70 = ' ';
          local52.setCharAt(local80, Character.toUpperCase(local52.charAt(local80)));
        }
        local52.append(local70);
      }
      local52.reverse();
      local52.setCharAt(0, Character.toUpperCase(local52.charAt(0)));
      return local52.toString();
    }
  }
}
