package com.open592.loader;

import java.applet.Applet;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.Hashtable;
import java.util.Vector;

// $FF: renamed from: et
public class class_10 implements Runnable {
    // $FF: renamed from: b java.util.Hashtable
    private static Hashtable field_45 = new Hashtable(16);
    // $FF: renamed from: i rp[]
    public class_12[] field_46;
    // $FF: renamed from: u java.awt.EventQueue
    public EventQueue systemEventQueue;
    // $FF: renamed from: m java.lang.String
    public static String systemOSVersion;
    // $FF: renamed from: c qt
    private class_4 field_49 = null;
    // $FF: renamed from: q java.lang.String
    public static String javaVersion;
    // $FF: renamed from: s java.lang.String
    public static String systemOSNameLowerCase;
    // $FF: renamed from: j java.applet.Applet
    public Applet field_52 = null;
    // $FF: renamed from: l qt
    private class_4 field_53 = null;
    // $FF: renamed from: n rp
    public class_12 field_54 = null;
    // $FF: renamed from: f java.lang.String
    public static String systemOSName;
    // $FF: renamed from: a rp
    public class_12 field_56 = null;
    // $FF: renamed from: d boolean
    private boolean field_57 = false;
    // $FF: renamed from: e java.lang.Thread
    private Thread field_58;
    // $FF: renamed from: r int
    public static int field_59 = 1;
    // $FF: renamed from: g java.lang.String
    private static String systemUserHome;
    // $FF: renamed from: h java.lang.String
    public static String systemOSArch;
    // $FF: renamed from: v rp
    public class_12 field_62 = null;
    // $FF: renamed from: k int
    private int field_63;
    // $FF: renamed from: o java.lang.String
    private String field_64;
    // $FF: renamed from: t g
    private class_8 field_65;
    // $FF: renamed from: p java.lang.String
    public static String javaVendor;
    // $FF: renamed from: z qn
    private class_1 field_67;
    // $FF: renamed from: A f
    private class_7 field_68;
    // $FF: renamed from: w java.lang.reflect.Method
    public static Method field_69;
    // $FF: renamed from: x java.lang.reflect.Method
    public static Method field_70;
    // $FF: renamed from: y long
    static volatile long field_71 = 0L;

    // $FF: renamed from: a (int, byte, java.lang.Object, int, int) qt
    private final class_4 method_27(int var1, byte var2, Object var3, int var4, int var5) {
        try {
            class_4 var6 = new class_4();
            synchronized (var6) {
                var6.field_7 = var5;
                var6.field_10 = var4;
                var6.field_9 = var3;
                var6.field_13 = var1;
                synchronized (this) {
                    if (null != this.field_49) {
                        this.field_49.field_11 = var6;
                        this.field_49 = var6;
                    } else {
                        this.field_49 = this.field_53 = var6;
                    }

                    this.notify();
                }

                try {
                    if (var2 != 117) {
                        this.method_56(null);
                    }

                    var6.wait();
                } catch (InterruptedException var11) {
                }
            }

            return var6;
        } catch (RuntimeException var14) {
            throw var14;
        }
    }

    // $FF: renamed from: a (byte) qt
    public final class_4 method_28(byte var1) {
        try {
            if (var1 != -128) {
                this.field_54 = (class_12) null;
            }

            return this.method_32(18, (Object) null, (byte) 99, 0, 0);
        } catch (RuntimeException var3) {
            throw var3;
        }
    }

    // $FF: renamed from: a (java.awt.datatransfer.Transferable, byte) qt
    public final class_4 method_29(Transferable var1, byte var2) {
        try {
            return var2 != 87 ? (class_4) null : this.method_32(19, var1, (byte) 99, 0, 0);
        } catch (RuntimeException var4) {
            throw var4;
        }
    }

    // $FF: renamed from: a (java.lang.String, boolean) java.io.File
    public final File method_31(String var1, boolean var2) {
        return var2 ? (File) null : method_48(var1, 0, this.field_63, this.field_64);
    }

    // $FF: renamed from: a (int, java.lang.Object, byte, int, int) qt
    private final class_4 method_32(int var1, Object var2, byte var3, int var4, int var5) {
        try {
            class_4 var6 = new class_4();
            var6.field_13 = var5;
            var6.field_10 = var1;
            var6.field_9 = var2;
            var6.field_7 = var4;
            synchronized (this) {
                if (null == this.field_49) {
                    this.field_49 = this.field_53 = var6;
                } else {
                    this.field_49.field_11 = var6;
                    this.field_49 = var6;
                }

                this.notify();
            }

            if (var3 != 99) {
                this.method_29((Transferable) null, (byte) 58);
            }

            return var6;
        } catch (RuntimeException var10) {
            throw var10;
        }
    }

    // $FF: renamed from: e (byte) boolean
    public final boolean method_33(byte var1) {
        try {
            if (var1 >= -85) {
                this.method_42((URL) null, 14);
            }

            return this.field_65 != null;
        } catch (RuntimeException var3) {
            throw var3;
        }
    }

    // $FF: renamed from: a (int, java.awt.Component, boolean) qt
    public final class_4 method_34(int var1, Component var2, boolean var3) {
        try {
            return var1 != -23993 ? (class_4) null : this.method_32(15, var2, (byte) 99, var3 ? 1 : 0, 0);
        } catch (RuntimeException var5) {
            throw var5;
        }
    }

    // $FF: renamed from: a (java.lang.Class, int) void
    public final void method_35(Class var1, int var2) throws Exception {
        try {
            Class[] var3 = new Class[]{Class.forName("java.lang.Class"), Class.forName("java.lang.String")};
            Runtime var4 = Runtime.getRuntime();
            Method var5 = Class.forName("java.lang.reflect.Method").getMethod("setAccessible", Boolean.TYPE);
            Method var7;
            if (!systemOSNameLowerCase.startsWith("mac")) {
                var7 = Class.forName("java.lang.Runtime").getDeclaredMethod("loadLibrary0", var3);
                var5.invoke(var7, Boolean.TRUE);
                var7.invoke(var4, var1, "jawt");
                var5.invoke(var7, Boolean.FALSE);
            }

            var7 = Class.forName("java.lang.Runtime").getDeclaredMethod("load0", var3);
            var5.invoke(var7, Boolean.TRUE);
            if (systemOSNameLowerCase.startsWith("win")) {
                var7.invoke(var4, var1, this.method_31("sw3d.dll", false).toString());
                var5.invoke(var7, Boolean.FALSE);
            } else {
                throw new Exception();
            }
        } catch (RuntimeException var8) {
            throw var8;
        }
    }

    // $FF: renamed from: b (byte) void
    public final void method_36(byte var1) {
        try {
            synchronized (this) {
                this.field_57 = true;
                this.notifyAll();
            }

            try {
                this.field_58.join();
                if (var1 >= -51) {
                    this.method_38((Class) null, false);
                }
            } catch (InterruptedException var8) {
            }

            if (null != this.field_62) {
                try {
                    this.field_62.method_59(-1);
                } catch (IOException var7) {
                }
            }

            if (this.field_56 != null) {
                try {
                    this.field_56.method_59(-1);
                } catch (IOException var6) {
                }
            }

            if (null != this.field_46) {
                for (int var2 = 0; ~var2 > ~this.field_46.length; ++var2) {
                    if (this.field_46[var2] != null) {
                        try {
                            this.field_46[var2].method_59(-1);
                        } catch (IOException var5) {
                        }
                    }
                }
            }

            if (null != this.field_54) {
                try {
                    this.field_54.method_59(-1);
                } catch (IOException var4) {
                }
            }

        } catch (RuntimeException var10) {
            throw var10;
        }
    }

    // $FF: renamed from: b (java.lang.String, int) qt
    public final class_4 method_37(String var1, int var2) {
        try {
            if (var2 != 14) {
                this.field_62 = (class_12) null;
            }

            return this.method_32(16, var1, (byte) 99, 0, 0);
        } catch (RuntimeException var4) {
            throw var4;
        }
    }

    // $FF: renamed from: a (java.lang.Class, boolean) qt
    public final class_4 method_38(Class var1, boolean var2) {
        try {
            return var2 ? (class_4) null : this.method_32(11, var1, (byte) 99, 0, 0);
        } catch (RuntimeException var4) {
            throw var4;
        }
    }

    public final void run() {
        try {
            while (true) {
                class_4 var1;
                synchronized (this) {
                    while (true) {
                        if (this.field_57) {
                            return;
                        }

                        if (this.field_53 != null) {
                            var1 = this.field_53;
                            this.field_53 = this.field_53.field_11;
                            if (this.field_53 == null) {
                                this.field_49 = null;
                            }
                            break;
                        }

                        try {
                            this.wait();
                        } catch (InterruptedException var11) {
                        }
                    }
                }

                try {
                    int var2 = var1.field_10;
                    if (1 != var2) {
                        if (2 == var2) {
                            Thread var33 = new Thread((Runnable) var1.field_9);
                            var33.setDaemon(true);
                            var33.start();
                            var33.setPriority(var1.field_7);
                            var1.field_8 = var33;
                        } else if (var2 != 4) {
                            Object[] var3;
                            if (var2 == 8) {
                                var3 = (Object[]) ((Object[]) var1.field_9);
                                if (null == ((Class) var3[0]).getClassLoader()) {
                                    throw new SecurityException();
                                }

                                var1.field_8 = ((Class) var3[0]).getDeclaredMethod((String) var3[1], (Class[]) ((Class[]) var3[2]));
                            } else if (var2 != 9) {
                                if (var2 == 18) {
                                    Clipboard var32 = Toolkit.getDefaultToolkit().getSystemClipboard();
                                    var1.field_8 = var32.getContents((Object) null);
                                } else if (~var2 == -20) {
                                    Transferable var31 = (Transferable) var1.field_9;
                                    Clipboard var29 = Toolkit.getDefaultToolkit().getSystemClipboard();
                                    var29.setContents(var31, (ClipboardOwner) null);
                                } else {
                                    String var19;
                                    if (~var2 == -4) {
                                        if (~class_11.method_57(-48) > ~field_71) {
                                            throw new IOException();
                                        }

                                        var19 = (var1.field_7 >> -1578467176 & 255) + "." + (255 & var1.field_7 >> -1030710640) + "." + (255 & var1.field_7 >> -26172504) + "." + (var1.field_7 & 255);
                                        var1.field_8 = InetAddress.getByName(var19).getHostName();
                                    } else if (-22 != ~var2) {
                                        if (~var2 == -6) {
                                            var1.field_8 = this.field_65.method_24((byte) -80);
                                        } else if (var2 == 6) {
                                            Frame var30 = new Frame("Jagex Full Screen");
                                            var1.field_8 = var30;
                                            var30.setResizable(false);
                                            this.field_65.method_26(113, var1.field_7 >>> -1757097072, var30, var1.field_13 >> 1428037648, '\uffff' & var1.field_13, '\uffff' & var1.field_7);
                                        } else if (-8 == ~var2) {
                                            this.field_65.method_23(-127);
                                        } else {
                                            int var28;
                                            if (11 == var2) {
                                                Field var26 = Class.forName("java.lang.ClassLoader").getDeclaredField("nativeLibraries");
                                                var26.setAccessible(true);
                                                Vector var27 = (Vector) var26.get(((Class) var1.field_9).getClassLoader());

                                                for (var28 = 0; ~var27.size() < ~var28; ++var28) {
                                                    Object var6 = var27.elementAt(var28);
                                                    Method var7 = var6.getClass().getDeclaredMethod("finalize");
                                                    var7.setAccessible(true);
                                                    var7.invoke(var6);
                                                    var7.setAccessible(false);
                                                    Field var8 = var6.getClass().getDeclaredField("handle");
                                                    var8.setAccessible(true);
                                                    var8.set(var6, new Integer(0));
                                                    var8.setAccessible(false);
                                                }

                                                var26.setAccessible(false);
                                            } else if (~var2 == -13) {
                                                class_12 var24 = method_40((String) var1.field_9, this.field_64, this.field_63, 0);
                                                var1.field_8 = var24;
                                            } else if (var2 == 14) {
                                                int var22 = var1.field_7;
                                                int var25 = var1.field_13;
                                                this.field_68.method_14(var22, (byte) 75, var25);
                                            } else if (-16 == ~var2) {
                                                boolean var20 = var1.field_7 != 0;
                                                Component var23 = (Component) var1.field_9;
                                                this.field_68.method_15(var20, var23, false);
                                            } else if (var2 == 17) {
                                                var3 = (Object[]) ((Object[]) var1.field_9);
                                                this.field_68.method_16((int[]) ((int[]) var3[1]), var1.field_7, (Component) var3[0], var1.field_13, (byte) 109, (Point) var3[2]);
                                            } else if (16 == var2) {
                                                try {
                                                    if (!systemOSNameLowerCase.startsWith("win")) {
                                                        throw new Exception();
                                                    }

                                                    var19 = (String) var1.field_9;
                                                    if (!var19.startsWith("http://") && !var19.startsWith("https://")) {
                                                        throw new Exception();
                                                    }

                                                    String var21 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

                                                    for (var28 = 0; var19.length() > var28; ++var28) {
                                                        if (0 == ~var21.indexOf(var19.charAt(var28))) {
                                                            throw new Exception();
                                                        }
                                                    }

                                                    Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var19 + "\"");
                                                    var1.field_8 = null;
                                                } catch (Exception var12) {
                                                    var1.field_8 = var12;
                                                    throw var12;
                                                }
                                            } else {
                                                if (20 != var2) {
                                                    throw new Exception("");
                                                }

                                                try {
                                                    Class[] var18 = new Class[]{Class.forName("java.lang.Class"), Class.forName("java.lang.String")};
                                                    Runtime var4 = Runtime.getRuntime();
                                                    Method var5 = Class.forName("java.lang.Runtime").getDeclaredMethod("load0", var18);
                                                    var5.setAccessible(true);
                                                    if (systemOSNameLowerCase.startsWith("win")) {
                                                        if (!systemOSArch.startsWith("amd64") && !systemOSArch.startsWith("x86_64")) {
                                                            var5.invoke(var4, var1.field_9, this.method_31("jagmisc.dll", false).toString());
                                                        } else {
                                                            var5.invoke(var4, var1.field_9, this.method_31("jagmisc64.dll", false).toString());
                                                        }
                                                    }

                                                    var5.setAccessible(false);
                                                } catch (Throwable var13) {
                                                    var1.field_8 = var13;
                                                }
                                            }
                                        }
                                    } else {
                                        if (class_11.method_57(-84) < field_71) {
                                            throw new IOException();
                                        }

                                        var1.field_8 = InetAddress.getByName((String) var1.field_9).getAddress();
                                    }
                                }
                            } else {
                                var3 = (Object[]) ((Object[]) var1.field_9);
                                if (((Class) var3[0]).getClassLoader() == null) {
                                    throw new SecurityException();
                                }

                                var1.field_8 = ((Class) var3[0]).getDeclaredField((String) var3[1]);
                            }
                        } else {
                            if (class_11.method_57(-55) < field_71) {
                                throw new IOException();
                            }

                            var1.field_8 = new DataInputStream(((URL) var1.field_9).openStream());
                        }
                    } else {
                        if (field_71 > class_11.method_57(-51)) {
                            throw new IOException();
                        }

                        var1.field_8 = new Socket(InetAddress.getByName((String) var1.field_9), var1.field_7);
                    }

                    var1.field_12 = 1;
                } catch (ThreadDeath var14) {
                    throw var14;
                } catch (Throwable var15) {
                    var1.field_12 = 2;
                }

                synchronized (var1) {
                    var1.notify();
                }
            }
        } catch (RuntimeException var17) {
            throw var17;
        }
    }

    // $FF: renamed from: a (int, java.lang.Class, java.lang.String) qt
    public final class_4 method_39(int var1, Class var2, String var3) {
        try {
            return var1 >= -77 ? (class_4) null : this.method_32(9, new Object[]{var2, var3}, (byte) 99, 0, 0);
        } catch (RuntimeException var5) {
            throw var5;
        }
    }

    // $FF: renamed from: a (java.lang.String, java.lang.String, int, int) rp
    private static final class_12 method_40(String var0, String var1, int var2, int var3) {
        try {
            String var4;
            if (var2 == 33) {
                var4 = "jagex_" + var1 + "_preferences" + var0 + "_rc.dat";
            } else if (var2 != 34) {
                var4 = "jagex_" + var1 + "_preferences" + var0 + ".dat";
            } else {
                var4 = "jagex_" + var1 + "_preferences" + var0 + "_wip.dat";
            }

            String[] var5 = new String[]{"c:/rscache/", "/rscache/", systemUserHome, "c:/windows/", "c:/winnt/", "c:/", "/tmp/", ""};

            for (int var6 = var3; var5.length > var6; ++var6) {
                String var7 = var5[var6];
                if (-1 <= ~var7.length() || (new File(var7)).exists()) {
                    try {
                        class_12 var8 = new class_12(new File(var7, var4), "rw", 10000L);
                        return var8;
                    } catch (Exception var9) {
                    }
                }
            }

            return null;
        } catch (RuntimeException var10) {
            throw var10;
        }
    }

    // $FF: renamed from: a (java.awt.Point, java.awt.Component, int, int[], int, int) qt
    public final class_4 method_41(Point var1, Component var2, int var3, int[] var4, int var5, int var6) {
        try {
            if (var6 != -23853) {
                this.field_53 = (class_4) null;
            }

            return this.method_32(17, new Object[]{var2, var4, var1}, (byte) 99, var3, var5);
        } catch (RuntimeException var8) {
            throw var8;
        }
    }

    // $FF: renamed from: a (java.net.URL, int) qt
    public final class_4 method_42(URL var1, int var2) {
        try {
            if (var2 > -97) {
                this.field_68 = (class_7) null;
            }

            return this.method_32(4, var1, (byte) 99, 0, 0);
        } catch (RuntimeException var4) {
            throw var4;
        }
    }

    // $FF: renamed from: a (int, int, java.lang.Runnable) qt
    public final class_4 method_43(int var1, int var2, Runnable var3) {
        try {
            int var4 = 89 % ((var1 - 20) / 51);
            return this.method_32(2, var3, (byte) 99, var2, 0);
        } catch (RuntimeException var5) {
            throw var5;
        }
    }

    // $FF: renamed from: c (java.lang.String, int) qt
    public final class_4 method_44(String var1, int var2) {
        try {
            if (var2 <= 71) {
                this.field_68 = (class_7) null;
            }

            return this.method_32(21, var1, (byte) 99, 0, 0);
        } catch (RuntimeException var4) {
            throw var4;
        }
    }

    // $FF: renamed from: a (byte, int) qt
    public final class_4 method_45(byte var1, int var2) {
        try {
            if (var1 != 122) {
                this.field_57 = true;
            }

            return this.method_32(3, (Object) null, (byte) 99, var2, 0);
        } catch (RuntimeException var4) {
            throw var4;
        }
    }

    // $FF: renamed from: a (byte, java.lang.Class) qt
    public final class_4 method_46(byte var1, Class var2) {
        try {
            int var3 = 17 / ((var1 - -62) / 58);
            return this.method_32(20, var2, (byte) 99, 0, 0);
        } catch (RuntimeException var4) {
            throw var4;
        }
    }

    // $FF: renamed from: a (byte, java.awt.Frame) qt
    public final class_4 method_47(byte var1, Frame var2) {
        try {
            return var1 != -64 ? (class_4) null : this.method_32(7, var2, (byte) 99, 0, 0);
        } catch (RuntimeException var4) {
            throw var4;
        }
    }

    // $FF: renamed from: a (java.lang.String, int, int, java.lang.String) java.io.File
    public static final File method_48(String var0, int var1, int var2, String var3) {
        try {
            File var4 = (File) field_45.get(var0);
            if (null != var4) {
                return var4;
            } else {
                String[] var5 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", systemUserHome, "/tmp/", ""};
                String[] var6 = new String[]{".jagex_cache_" + var2, ".file_store_" + var2};

                for (int var7 = var1; ~var7 > -3; ++var7) {
                    for (int var8 = 0; var8 < var6.length; ++var8) {
                        for (int var9 = 0; ~var5.length < ~var9; ++var9) {
                            String var10 = var5[var9] + var6[var8] + "/" + (null == var3 ? "" : var3 + "/") + var0;
                            RandomAccessFile var11 = null;

                            try {
                                File var12 = new File(var10);
                                if (~var7 != -1 || var12.exists()) {
                                    String var13 = var5[var9];
                                    if (~var7 != -2 || -1 <= ~var13.length() || (new File(var13)).exists()) {
                                        (new File(var5[var9] + var6[var8])).mkdir();
                                        if (null != var3) {
                                            (new File(var5[var9] + var6[var8] + "/" + var3)).mkdir();
                                        }

                                        var11 = new RandomAccessFile(var12, "rw");
                                        int var14 = var11.read();
                                        var11.seek(0L);
                                        var11.write(var14);
                                        var11.seek(0L);
                                        var11.close();
                                        field_45.put(var0, var12);
                                        return var12;
                                    }
                                }
                            } catch (Exception var16) {
                                try {
                                    if (var11 != null) {
                                        var11.close();
                                        var11 = null;
                                    }
                                } catch (Exception var15) {
                                }
                            }
                        }
                    }
                }

                throw new RuntimeException();
            }
        } catch (RuntimeException var17) {
            throw var17;
        }
    }

    // $FF: renamed from: c (byte) qt
    public final class_4 method_49(byte var1) {
        try {
            if (var1 != -80) {
                this.field_54 = (class_12) null;
            }

            return this.method_32(5, (Object) null, (byte) 99, 0, 0);
        } catch (RuntimeException var3) {
            throw var3;
        }
    }

    // $FF: renamed from: a (java.lang.Class[], java.lang.String, java.lang.Class, int) qt
    public final class_4 method_50(Class[] var1, String var2, Class var3, int var4) {
        try {
            if (var4 != 2) {
                method_40((String) null, (String) null, 62, -116);
            }

            return this.method_32(8, new Object[]{var3, var2, var1}, (byte) 99, 0, 0);
        } catch (RuntimeException var6) {
            throw var6;
        }
    }

    // $FF: renamed from: a (java.awt.Component, boolean, int, int) qt
    public final class_4 method_51(Component var1, boolean var2, int var3, int var4) {
        try {
            Point var5 = var1.getLocationOnScreen();
            if (var2) {
                this.method_38((Class) null, false);
            }

            return this.method_32(14, (Object) null, (byte) 99, var3 - -var5.x, var5.y + var4);
        } catch (RuntimeException var6) {
            throw var6;
        }
    }

    // $FF: renamed from: d (byte) void
    public final void method_52(byte var1) {
        try {
            field_71 = class_11.method_57(var1 + -133) + 5000L;
            if (var1 != 62) {
                field_70 = (Method) null;
            }

        } catch (RuntimeException var3) {
            throw var3;
        }
    }

    // $FF: renamed from: a (java.lang.String, int) byte[]
    public final byte[] method_53(String var1, int var2) {
        try {
            if (var2 != 14) {
                this.field_63 = 80;
            }

            class_4 var3 = this.method_27(0, (byte) 117, var1, 21, 0);
            return (byte[]) ((byte[]) var3.field_8);
        } catch (RuntimeException var4) {
            throw var4;
        }
    }

    // $FF: renamed from: a (int) qn
    public final class_1 method_54(int var1) {
        if (var1 != 18) {
            method_40((String) null, (String) null, -105, -1);
        }

        return this.field_67;
    }

    // $FF: renamed from: a (int, java.lang.String, int) qt
    public final class_4 method_55(int var1, String var2, int var3) {
        try {
            return var1 != 0 ? (class_4) null : this.method_32(1, var2, (byte) 99, var3, 0);
        } catch (RuntimeException var5) {
            throw var5;
        }
    }

    // $FF: renamed from: a (byte, java.lang.String) qt
    public final void method_56(String var2) {
        this.method_32(12, var2, (byte) 99, 0, 0);
    }

    public class_10(Applet var1, int var2, String var3, int var4) throws Exception {
        javaVendor = "Unknown";
        this.field_64 = var3;
        this.field_63 = var2;
        this.field_52 = var1;
        javaVersion = "1.1";

        try {
            javaVendor = System.getProperty("java.vendor");
            javaVersion = System.getProperty("java.version");
        } catch (Exception ignored) {
        }

        try {
            systemOSName = System.getProperty("os.name");
        } catch (Exception e) {
            systemOSName = "Unknown";
        }

        systemOSNameLowerCase = systemOSName.toLowerCase();

        try {
            systemOSArch = System.getProperty("os.arch").toLowerCase();
        } catch (Exception e) {
            systemOSArch = "";
        }

        try {
            systemOSVersion = System.getProperty("os.version").toLowerCase();
        } catch (Exception e) {
            systemOSVersion = "";
        }

        try {
            systemUserHome = System.getProperty("user.home");
            if (systemUserHome != null) {
                systemUserHome = systemUserHome + "/";
            }
        } catch (Exception ignored) {
        }

        if (systemUserHome == null) {
            systemUserHome = "~/";
        }

        try {
            this.systemEventQueue = Toolkit.getDefaultToolkit().getSystemEventQueue();
        } catch (Throwable ignored) {
        }

        try {
            if (var1 == null) {
                field_69 = Class.forName("java.awt.Component").getDeclaredMethod("setFocusTraversalKeysEnabled", Boolean.TYPE);
            } else {
                field_69 = var1.getClass().getMethod("setFocusTraversalKeysEnabled", Boolean.TYPE);
            }
        } catch (Exception ignored) {
        }

        try {
            if (null == var1) {
                field_70 = Class.forName("java.awt.Container").getDeclaredMethod("setFocusCycleRoot", Boolean.TYPE);
            } else {
                field_70 = var1.getClass().getMethod("setFocusCycleRoot", Boolean.TYPE);
            }
        } catch (Exception ignored) {
        }

        this.field_54 = new class_12(method_48("random.dat", 0, this.field_63, null), "rw", 25L);
        this.field_62 = new class_12(this.method_31("main_file_cache.dat2", false), "rw", 209715200L);
        this.field_56 = new class_12(this.method_31("main_file_cache.idx255", false), "rw", 1048576L);
        this.field_46 = new class_12[var4];

        for (int var5 = 0; ~var4 < ~var5; ++var5) {
            this.field_46[var5] = new class_12(this.method_31("main_file_cache.idx" + var5, false), "rw", 1048576L);
        }

        try {
            this.field_65 = new class_8();
        } catch (Throwable ignored) {
        }

        try {
            this.field_68 = new class_7();
        } catch (Throwable ignored) {
        }

        ThreadGroup var20 = Thread.currentThread().getThreadGroup();

        for (ThreadGroup var6 = var20.getParent(); var6 != null; var6 = var6.getParent()) {
            var20 = var6;
        }

        Thread[] var7 = new Thread[1000];
        var20.enumerate(var7);

        for (int var8 = 0; ~var8 > ~var7.length; ++var8) {
            if (var7[var8] != null && var7[var8].getName().startsWith("AWT")) {
                var7[var8].setPriority(1);
            }
        }

        this.field_57 = false;
        this.field_58 = new Thread(this);
        this.field_58.setPriority(10);
        this.field_58.setDaemon(true);
        this.field_58.start();
    }
}
