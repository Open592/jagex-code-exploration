package com.open592.loader;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.jar.JarOutputStream;
import java.util.jar.Pack200;
import java.util.zip.GZIPInputStream;

// $FF: renamed from: c
public class class_3 extends Unpack {
    // $FF: renamed from: a (byte, byte[]) byte[]
    private static byte[] method_8(byte var0, byte[] var1) throws IOException {
        try {
            byte[] var2 = new byte[var1.length + 2];
            var2[1] = -117;
            var2[0] = 31;
            System.arraycopy(var1, 0, var2, 2, var1.length);
            ByteArrayOutputStream var3 = new ByteArrayOutputStream();
            if (var0 >= -25) {
                return (byte[]) null;
            } else {
                Pack200.newUnpacker().unpack(new GZIPInputStream(new ByteArrayInputStream(var2)), new JarOutputStream(var3));
                return var3.toByteArray();
            }
        } catch (RuntimeException var4) {
            throw var4;
        }
    }

    public class_3(byte[] var1) throws IOException {
        super(method_8((byte) -47, var1));
    }
}
