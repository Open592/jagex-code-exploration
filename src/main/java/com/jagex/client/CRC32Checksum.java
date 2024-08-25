package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class CRC32Checksum {
    @OriginalMember(owner = "client!ue", name = "z", descriptor = "[I")
    public static final int[] CRCTable32 = new int[256];

    static {
        init();
    }

    @OriginalMember(owner = "client!ja", name = "a", descriptor = "(IB[BI)I")
    public static int calculateChecksum(@OriginalArg(2) byte[] buffer, @OriginalArg(3) int length, @OriginalArg(0) int offset) {
        @Pc(7) int checksum = -1;

        for (@Pc(9) int i = offset; i < length; i++) {
            checksum = CRCTable32[(checksum ^ buffer[i]) & 0xFF] ^ checksum >>> 8;
        }

        return ~checksum;
    }

    private static void init() {
        for (@Pc(4) int i = 0; i < 256; i++) {
            @Pc(7) int r = i;

            for (@Pc(9) int j = 0; j < 8; j++) {
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
