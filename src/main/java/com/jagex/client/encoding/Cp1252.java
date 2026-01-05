package com.jagex.client.encoding;

public final class Cp1252 {
  /** Given a code unit offset by 128 return the corresponding CP1252 character. */
  private static final char[] CP1252_LOOKUP_TABLE =
      new char[] {
        '€', '\u0000', '‚', 'ƒ', '„', '…', '†', '‡', 'ˆ', '‰', 'Š', '‹', 'Œ', '\u0000', 'Ž',
        '\u0000', '\u0000', '‘', '’', '“', '”', '•', '–', '—', '˜', '™', 'š', '›', 'œ', '\u0000',
        'ž', 'Ÿ'
      };

  public static boolean isRepresentable(char input) {
    if (input > '\u0000' && input < '\u0080' || !(input < ' ' || input > 'ÿ')) {
      return true;
    }

    if (input != '\u0000') {
      for (char c : CP1252_LOOKUP_TABLE) {
        if (input == c) {
          return true;
        }
      }
    }

    return false;
  }

  public static byte[] encode(String input) {
    int length = input.length();
    byte[] outputBuffer = new byte[length];

    for (int i = 0; i < length; i++) {
      char codeUnit = input.charAt(i);

      if (codeUnit > '\u0000' && codeUnit < '\u0080' || !(codeUnit < ' ' || codeUnit > 'ÿ')) {
        outputBuffer[i] = (byte) codeUnit;
      } else if (codeUnit == '€') {
        outputBuffer[i] = -128;
      } else if (codeUnit == '‚') {
        outputBuffer[i] = -126;
      } else if (codeUnit == 'ƒ') {
        outputBuffer[i] = -125;
      } else if (codeUnit == '„') {
        outputBuffer[i] = -124;
      } else if (codeUnit == '…') {
        outputBuffer[i] = -123;
      } else if (codeUnit == '†') {
        outputBuffer[i] = -122;
      } else if (codeUnit == '‡') {
        outputBuffer[i] = -121;
      } else if (codeUnit == 'ˆ') {
        outputBuffer[i] = -120;
      } else if (codeUnit == '‰') {
        outputBuffer[i] = -119;
      } else if (codeUnit == 'Š') {
        outputBuffer[i] = -118;
      } else if (codeUnit == '‹') {
        outputBuffer[i] = -117;
      } else if (codeUnit == 'Œ') {
        outputBuffer[i] = -116;
      } else if (codeUnit == 'Ž') {
        outputBuffer[i] = -114;
      } else if (codeUnit == '‘') {
        outputBuffer[i] = -111;
      } else if (codeUnit == '’') {
        outputBuffer[i] = -110;
      } else if (codeUnit == '“') {
        outputBuffer[i] = -109;
      } else if (codeUnit == '”') {
        outputBuffer[i] = -108;
      } else if (codeUnit == '•') {
        outputBuffer[i] = -107;
      } else if (codeUnit == '–') {
        outputBuffer[i] = -106;
      } else if (codeUnit == '—') {
        outputBuffer[i] = -105;
      } else if (codeUnit == '˜') {
        outputBuffer[i] = -104;
      } else if (codeUnit == '™') {
        outputBuffer[i] = -103;
      } else if (codeUnit == 'š') {
        outputBuffer[i] = -102;
      } else if (codeUnit == '›') {
        outputBuffer[i] = -101;
      } else if (codeUnit == 'œ') {
        outputBuffer[i] = -100;
      } else if (codeUnit == 'ž') {
        outputBuffer[i] = -98;
      } else if (codeUnit == 'Ÿ') {
        outputBuffer[i] = -97;
      } else {
        outputBuffer[i] = 63;
      }
    }
    return outputBuffer;
  }

  public static int encode(String value, int length, int currentPosition, byte[] buffer) {
    for (int i = 0; i < length; i++) {
      char ch = value.charAt(i);

      if (ch > '\u0000' && ch < '\u0080' || !(ch < ' ' || ch > 'ÿ')) {
        buffer[i + currentPosition] = (byte) ch;
      } else if (ch == '€') {
        buffer[currentPosition + i] = -128;
      } else if (ch == '‚') {
        buffer[i + currentPosition] = -126;
      } else if (ch == 'ƒ') {
        buffer[i + currentPosition] = -125;
      } else if (ch == '„') {
        buffer[currentPosition + i] = -124;
      } else if (ch == '…') {
        buffer[i + currentPosition] = -123;
      } else if (ch == '†') {
        buffer[currentPosition + i] = -122;
      } else if (ch == '‡') {
        buffer[currentPosition + i] = -121;
      } else if (ch == 'ˆ') {
        buffer[currentPosition + i] = -120;
      } else if (ch == '‰') {
        buffer[currentPosition + i] = -119;
      } else if (ch == 'Š') {
        buffer[currentPosition + i] = -118;
      } else if (ch == '‹') {
        buffer[currentPosition + i] = -117;
      } else if (ch == 'Œ') {
        buffer[i + currentPosition] = -116;
      } else if (ch == 'Ž') {
        buffer[i + currentPosition] = -114;
      } else if (ch == '‘') {
        buffer[i + currentPosition] = -111;
      } else if (ch == '’') {
        buffer[currentPosition + i] = -110;
      } else if (ch == '“') {
        buffer[i + currentPosition] = -109;
      } else if (ch == '”') {
        buffer[i + currentPosition] = -108;
      } else if (ch == '•') {
        buffer[currentPosition + i] = -107;
      } else if (ch == '–') {
        buffer[i + currentPosition] = -106;
      } else if (ch == '—') {
        buffer[currentPosition + i] = -105;
      } else if (ch == '˜') {
        buffer[i + currentPosition] = -104;
      } else if (ch == '™') {
        buffer[i + currentPosition] = -103;
      } else if (ch == 'š') {
        buffer[i + currentPosition] = -102;
      } else if (ch == '›') {
        buffer[i + currentPosition] = -101;
      } else if (ch == 'œ') {
        buffer[currentPosition + i] = -100;
      } else if (ch == 'ž') {
        buffer[i + currentPosition] = -98;
      } else if (ch == 'Ÿ') {
        buffer[i + currentPosition] = -97;
      } else {
        buffer[i + currentPosition] = 63;
      }
    }

    return length;
  }

  public static String decode(byte[] input, int length, int offset) {
    char[] resultBuffer = new char[length];
    int resultLength = 0;

    for (int i = 0; i < length; i++) {
      int codeUnit = input[i + offset] & 0xFF;

      if (codeUnit != 0) {
        if (codeUnit >= 128 && codeUnit < 160) {
          char cp1252CodeUnit = CP1252_LOOKUP_TABLE[codeUnit - 128];

          if (cp1252CodeUnit == '\u0000') {
            cp1252CodeUnit = '?';
          }

          codeUnit = cp1252CodeUnit;
        }

        resultBuffer[resultLength++] = (char) codeUnit;
      }
    }

    return new String(resultBuffer, 0, resultLength);
  }

  public static char decodeChar(byte input) {
    int codeUnit = input & 0xFF;

    if (codeUnit == 0) {
      throw new IllegalArgumentException(
          "Non cp1252 character 0x" + Integer.toString(codeUnit, 16) + " provided");
    }

    if (codeUnit >= 128 && codeUnit < 160) {
      char local41 = CP1252_LOOKUP_TABLE[codeUnit - 128];

      if (local41 == '\u0000') {
        local41 = '?';
      }

      codeUnit = local41;
    }

    return (char) codeUnit;
  }

  public static byte encodeChar(char input) {
    byte res;
    if (input > '\u0000' && input < '\u0080' || input >= ' ' && input <= 'ÿ') {
      res = (byte) input;
    } else if (input == '€') {
      res = -128;
    } else if (input == '‚') {
      res = -126;
    } else if (input == 'ƒ') {
      res = -125;
    } else if (input == '„') {
      res = -124;
    } else if (input == '…') {
      res = -123;
    } else if (input == '†') {
      res = -122;
    } else if (input == '‡') {
      res = -121;
    } else if (input == 'ˆ') {
      res = -120;
    } else if (input == '‰') {
      res = -119;
    } else if (input == 'Š') {
      res = -118;
    } else if (input == '‹') {
      res = -117;
    } else if (input == 'Œ') {
      res = -116;
    } else if (input == 'Ž') {
      res = -114;
    } else if (input == '‘') {
      res = -111;
    } else if (input == '’') {
      res = -110;
    } else if (input == '“') {
      res = -109;
    } else if (input == '”') {
      res = -108;
    } else if (input == '•') {
      res = -107;
    } else if (input == '–') {
      res = -106;
    } else if (input == '—') {
      res = -105;
    } else if (input == '˜') {
      res = -104;
    } else if (input == '™') {
      res = -103;
    } else if (input == 'š') {
      res = -102;
    } else if (input == '›') {
      res = -101;
    } else if (input == 'œ') {
      res = -100;
    } else if (input == 'ž') {
      res = -98;
    } else if (input == 'Ÿ') {
      res = -97;
    } else {
      res = 63;
    }

    return res;
  }

  public static int hashCode(String input) {
    int len = input.length();
    int res = 0;
    for (int i = 0; i < len; i++) {
      res = encodeChar(input.charAt(i)) + (res << 5) - res;
    }
    return res;
  }
}
