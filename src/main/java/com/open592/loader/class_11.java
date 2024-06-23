package com.open592.loader;

// $FF: renamed from: of
public final class class_11 {
    // $FF: renamed from: b long
    private static long field_72;
    // $FF: renamed from: a long
    private static long field_73;

    // $FF: renamed from: a (int) long
    public static final synchronized long method_57(int var0) {
        try {
            long var1 = System.currentTimeMillis();
            if (~var1 > ~field_72) {
                field_73 += field_72 - var1;
            }

            if (var0 > -47) {
                method_57(87);
            }

            field_72 = var1;
            return field_73 + var1;
        } catch (RuntimeException var3) {
            throw var3;
        }
    }

    private class_11() {
    }
}
