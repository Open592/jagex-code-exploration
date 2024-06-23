package com.open592.loader;

import java.io.EOFException;
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
    private File field_77;

    // $FF: renamed from: a (int, int, byte[], byte) int
    public final int method_58(int var1, int var2, byte[] var3, byte var4) throws IOException {
        try {
            if (var4 > -88) {
                this.field_74 = -96L;
            }

            int var5 = this.field_75.read(var3, var1, var2);
            if (~var5 < -1) {
                this.field_74 += (long) var5;
            }

            return var5;
        } catch (RuntimeException var6) {
            throw var6;
        }
    }

    // $FF: renamed from: a (int) void
    public final void method_59(int var1) throws IOException {
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
    public final void method_60(long var1, int var3) throws IOException {
        try {
            if (var3 != 0) {
                this.field_76 = -60L;
            }

            this.field_75.seek(var1);
            this.field_74 = var1;
        } catch (RuntimeException var5) {
            throw var5;
        }
    }

    // $FF: renamed from: b (int) java.io.File
    public final File method_61(int var1) {
        try {
            if (var1 >= -9) {
                this.field_76 = -10L;
            }

            return this.field_77;
        } catch (RuntimeException var3) {
            throw var3;
        }
    }

    // $FF: renamed from: a (int, int, byte[], int) void
    public final void method_62(int var1, int var2, byte[] var3, int var4) throws IOException {
        try {
            if (this.field_74 + (long) var2 <= this.field_76) {
                if (var4 == 1) {
                    this.field_75.write(var3, var1, var2);
                    this.field_74 += (long) var2;
                }
            } else {
                this.field_75.seek(this.field_76);
                this.field_75.write(1);
                throw new EOFException();
            }
        } catch (RuntimeException var6) {
            throw var6;
        }
    }

    protected void finalize() throws Throwable {
        try {
            if (null != this.field_75) {
                System.out.println("Warning! fileondisk " + this.field_77 + " not closed correctly using close(). Auto-closing instead. ");
                this.method_59(-1);
            }

        } catch (RuntimeException var2) {
            throw var2;
        }
    }

    // $FF: renamed from: c (int) long
    public final long method_63(int var1) throws IOException {
        try {
            if (var1 != 74) {
                this.method_61(27);
            }

            return this.field_75.length();
        } catch (RuntimeException var3) {
            throw var3;
        }
    }

    public class_12(File var1, String var2, long var3) throws IOException {
        try {
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
        } catch (RuntimeException var6) {
            throw var6;
        }
    }
}
