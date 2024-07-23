package com.jagex.signlink;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

// $FF: renamed from: rp
public final class class_12 {
    // $FF: renamed from: c long
    private long field_74;
    // $FF: renamed from: a java.io.RandomAccessFile
    private RandomAccessFile field_75;
    // $FF: renamed from: d long
    private long field_76;
    // $FF: renamed from: b java.io.File
    private final File field_77;

    // $FF: renamed from: a (int, int, byte[], byte) int
    public int method_58(int var1, int var2, byte[] var3, byte var4) throws IOException {
        if (var4 > -88) {
            this.field_74 = -96L;
        }

        int var5 = this.field_75.read(var3, var1, var2);
        if (~var5 < -1) {
            this.field_74 += (long) var5;
        }

        return var5;
    }

    // $FF: renamed from: a (int) void
    public void method_59(int var1) throws IOException {
        try {
            if (null != this.field_75) {
                this.field_75.close();
                this.field_75 = null;
            }

            if (var1 != -1) {
                this.method_61(-5);
            }

        } catch (RuntimeException var3) {
            throw var3;
        }
    }

    // $FF: renamed from: a (long, int) void
    public void method_60(long var1, int var3) throws IOException {
        if (var3 != 0) {
            this.field_76 = -60L;
        }

        this.field_75.seek(var1);
        this.field_74 = var1;
    }

    // $FF: renamed from: b (int) java.io.File
    public File method_61(int var1) {
        if (var1 >= -9) {
            this.field_76 = -10L;
        }

        return this.field_77;
    }

    // $FF: renamed from: a (int, int, byte[], int) void
    public void method_62(int var1, int var2, byte[] var3, int var4) throws IOException {
        if (this.field_74 + (long) var2 <= this.field_76) {
            if (var4 == 1) {
                this.field_75.write(var3, var1, var2);
                this.field_74 += (long) var2;
            }
        } else {
            this.field_75.seek(this.field_76);
            this.field_75.write(1);
            throw new java.io.EOFException();
        }
    }

    protected void finalize() throws Throwable {
        if (null != this.field_75) {
            System.out.println("Warning! fileondisk " + this.field_77 + " not closed correctly using close(). Auto-closing instead. ");
            this.method_59(-1);
        }

    }

    // $FF: renamed from: c (int) long
    public long method_63(int var1) throws IOException {
        if (var1 != 74) {
            this.method_61(27);
        }

        return this.field_75.length();
    }

    public class_12(File var1, String var2, long var3) throws IOException {
        if (~var3 == 0L) {
            var3 = Long.MAX_VALUE;
        }

        if (var3 < var1.length()) {
            var1.delete();
        }

        this.field_75 = new RandomAccessFile(var1, var2);
        this.field_76 = var3;
        this.field_77 = var1;
        this.field_74 = 0L;
        int var5 = this.field_75.read();
        if (-1 != var5 && !var2.equals("r")) {
            this.field_75.seek(0L);
            this.field_75.write(var5);
        }

        this.field_75.seek(0L);
    }
}
