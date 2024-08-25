package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class CP1252StringTools {
    /**
     * Given a code unit offset by 128 return the corresponding CP1252 character.
     */
    @OriginalMember(owner = "client!ve", name = "o", descriptor = "[C")
    private static final char[] CP1252_LOOKUP_TABLE = new char[] {
        '€',
        '\u0000',
        '‚',
        'ƒ',
        '„',
        '…',
        '†',
        '‡',
        'ˆ',
        '‰',
        'Š',
        '‹',
        'Œ',
        '\u0000',
        'Ž',
        '\u0000',
        '\u0000',
        '‘',
        '’',
        '“',
        '”',
        '•',
        '–',
        '—',
        '˜',
        '™',
        'š',
        '›',
        'œ',
        '\u0000',
        'ž',
        'Ÿ'
    };

    @OriginalMember(owner = "client!be", name = "a", descriptor = "(ZC)Z")
    public static boolean isValidCP1252Character(@OriginalArg(1) char input) {
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

    @OriginalMember(owner = "client!oh", name = "a", descriptor = "(Ljava/lang/String;I)[B")
    public static byte[] UTF8ToCP1252(@OriginalArg(0) String input) {
        @Pc(8) int length = input.length();
        @Pc(11) byte[] outputBuffer = new byte[length];

        for (@Pc(13) int i = 0; i < length; i++) {
            @Pc(22) char codeUnit = input.charAt(i);

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

    @OriginalMember(owner = "client!j", name = "a", descriptor = "(Ljava/lang/String;IIII[B)I")
    public static int UTF8ToCP1252(
            @OriginalArg(0) String value,
            @OriginalArg(2) int length,
            @OriginalArg(3) int currentPosition,
            @OriginalArg(5) byte[] buffer
    ) {
        for (@Pc(12) int i = 0; i < length; i++) {
            @Pc(20) char ch = value.charAt(i);

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

    @OriginalMember(owner = "client!ut", name = "a", descriptor = "(I[BII)Ljava/lang/String;")
    public static String CP1252ToUTF8(@OriginalArg(1) byte[] input, @OriginalArg(2) int length, @OriginalArg(3) int offset) {
        @Pc(8) char[] resultBuffer = new char[length];
        @Pc(10) int resultLength = 0;

        for (@Pc(12) int i = 0; i < length; i++) {
            @Pc(22) int codeUnit = input[i + offset] & 0xFF;

            if (codeUnit != 0) {
                if (codeUnit >= 128 && codeUnit < 160) {
                    @Pc(38) char cp1252CodeUnit = CP1252_LOOKUP_TABLE[codeUnit - 128];

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

    @OriginalMember(owner = "client!ne", name = "a", descriptor = "(IB)C")
    public static char CP1252ToUTF8(@OriginalArg(1) byte input) {
        @Pc(7) int codeUnit = input & 0xFF;

        if (codeUnit == 0) {
            throw new IllegalArgumentException("Non cp1252 character 0x" + Integer.toString(codeUnit, 16) + " provided");
        }

        if (codeUnit >= 128 && codeUnit < 160) {
            @Pc(41) char local41 = CP1252_LOOKUP_TABLE[codeUnit - 128];

            if (local41 == '\u0000') {
                local41 = '?';
            }

            codeUnit = local41;
        }

        return (char) codeUnit;
    }
}
