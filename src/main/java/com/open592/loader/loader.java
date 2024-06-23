package com.open592.loader;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.security.MessageDigest;
import java.util.zip.Inflater;

public final class loader extends Applet implements Runnable {
    // $FF: renamed from: a boolean
    private boolean field_29 = false;
    // $FF: renamed from: b int
    private static int field_30 = 0;
    // $FF: renamed from: c java.applet.Applet
    private Applet applet;
    // $FF: renamed from: d int
    private int field_32;
    // $FF: renamed from: e boolean
    private boolean field_33 = false;
    // $FF: renamed from: f boolean
    private boolean field_34 = false;
    // $FF: renamed from: g boolean
    private boolean field_35 = false;
    // $FF: renamed from: h java.lang.String
    private static String field_36;
    // $FF: renamed from: i java.lang.String
    private static String field_37;
    // $FF: renamed from: j int
    private int field_38;
    // $FF: renamed from: k int
    private int field_39 = 0;

    // $FF: renamed from: a (b, byte, boolean) byte[]
    private final byte[] method_17(class_2 var1, byte var2, boolean var3) {
        try {
            Font var4 = new Font("Helvetica", 1, 13);
            FontMetrics var5 = this.getFontMetrics(var4);
            Color var6 = new Color(class_6.field_26[field_30]);
            Color var7 = new Color(class_6.field_24[field_30]);
            byte[] var8 = new byte[var1.field_1];

            try {
                InputStream var9;
                label61:
                {
                    if (!var3) {
                        var9 = (new URL(this.getCodeBase(), var1.field_4)).openStream();
                        break label61;
                    }

                    URL var10 = this.getCodeBase();
                    Socket var11 = new Socket(InetAddress.getByName(var10.getHost()), 443);
                    var11.setSoTimeout(10000);
                    OutputStream var12 = var11.getOutputStream();
                    var12.write(17);
                    var12.write(("JAGGRAB " + var10.getFile() + var1.field_4 + "\n\n").getBytes());
                    var9 = var11.getInputStream();
                }

                if (var2 >= -77) {
                    this.paint((Graphics) null);
                }

                int var21 = -1;
                int var22 = 0;

                while (~var8.length < ~var22) {
                    int var23 = -var22 + var8.length;
                    if (var23 > 1000) {
                        var23 = 1000;
                    }

                    int var13 = var9.read(var8, var22, var23);
                    if (-1 < ~var13) {
                        throw new EOFException();
                    }

                    var22 += var13;
                    int var14 = var22 * 100 / var8.length;
                    if (~var14 != ~var21) {
                        try {
                            label74:
                            {
                                Graphics var15 = this.getGraphics();
                                if (var15 == null) {
                                    this.repaint();
                                    break label74;
                                }

                                var15.setColor(Color.black);
                                var15.fillRect(0, 0, this.field_38, this.field_32);
                                var15.setColor(var6);
                                var15.drawRect(-152 + this.field_38 / 2, -18 + this.field_32 / 2, 303, 33);
                                String var16 = var1.field_0[this.field_39] + " - " + var14 + "%";
                                var15.setFont(var4);
                                var15.setColor(var7);
                                var15.drawString(var16, (this.field_38 - var5.stringWidth(var16)) / 2, this.field_32 / 2 - -4);
                                var21 = var14;
                            }
                        } catch (Exception var18) {
                        }
                    }
                }

                var9.close();
                if (~var1.field_1 != ~var1.field_2) {
                    byte[] var24 = new byte[var1.field_2];
                    Inflater var25 = new Inflater(true);
                    var25.setInput(var8);
                    var8 = var24;
                    var25.inflate(var24);
                }
            } catch (Exception var19) {
                return null;
            }

            return !this.method_19(var1, false, 3, var8) ? null : var8;
        } catch (RuntimeException var20) {
            throw LoaderRuntimeException.create(var20, "loader.D(" + (var1 != null ? "{...}" : "null") + ',' + var2 + ',' + var3 + ')');
        }
    }

    // $FF: renamed from: a (boolean, java.io.File, byte[]) boolean
    private final boolean method_18(boolean var1, File var2, byte[] var3) {
        try {
            try {
                if (!var1) {
                    this.run();
                }

                FileOutputStream var4 = new FileOutputStream(var2);
                var4.write(var3, 0, var3.length);
                var4.close();
                return true;
            } catch (IOException var5) {
                this.method_22("savefile");
                return false;
            }
        } catch (RuntimeException var6) {
            throw LoaderRuntimeException.create(var6, "loader.B(" + var1 + ',' + (var2 != null ? "{...}" : "null") + ',' + (var3 != null ? "{...}" : "null") + ')');
        }
    }

    // $FF: renamed from: a (b, boolean, int, byte[]) boolean
    private final boolean method_19(class_2 var1, boolean var2, int var3, byte[] var4) {
        try {
            if (var3 != 3) {
                this.method_18(false, (File) null, (byte[]) null);
            }

            try {
                if (var4 == null) {
                    return false;
                }

                MessageDigest var5 = MessageDigest.getInstance("SHA");
                var5.reset();
                var5.update(var4);
                byte[] var6 = var5.digest();
                int var7 = 0;

                while (~var7 > -21) {
                    if (var1.field_5[var7] != var6[var7]) {
                        return false;
                    }

                    ++var7;
                }
            } catch (Exception var9) {
                this.method_22("sha");
                return false;
            }

            return true;
        } catch (RuntimeException var10) {
            throw LoaderRuntimeException.create(var10, "loader.F(" + (var1 != null ? "{...}" : "null") + ',' + var2 + ',' + var3 + ',' + (var4 != null ? "{...}" : "null") + ')');
        }
    }

    // $FF: renamed from: a (java.io.File, boolean) byte[]
    private final byte[] method_20(File var1, boolean var2) {
        try {
            try {
                if (var1.exists()) {
                    int var3 = (int) var1.length();
                    DataInputStream var4 = new DataInputStream(new BufferedInputStream(new FileInputStream(var1)));
                    byte[] var5 = new byte[var3];
                    if (var2) {
                        return (byte[]) null;
                    } else {
                        var4.readFully(var5, 0, var3);
                        var4.close();
                        return var5;
                    }
                } else {
                    return null;
                }
            } catch (IOException var6) {
                return null;
            }
        } catch (RuntimeException var7) {
            throw LoaderRuntimeException.create(var7, "loader.E(" + (var1 != null ? "{...}" : "null") + ',' + var2 + ')');
        }
    }

    public final synchronized void start() {
        try {
            this.field_33 = true;
            this.field_35 = false;
            if (this.applet != null) {
                this.applet.start();
            }

        } catch (RuntimeException var2) {
            throw LoaderRuntimeException.create(var2, "loader.start()");
        }
    }

    public final void run() {
        try {
            try {
                field_37 = this.getParameter("unsignedurl");
                if (field_37 != null) {
                    try {
                        SecurityManager var1 = System.getSecurityManager();
                        if (null != var1) {
                            var1.checkExec("echo");
                        }
                    } catch (SecurityException var20) {
                        this.field_29 = true;

                        try {
                            this.getAppletContext().showDocument(new URL(field_37), "_parent");
                        } catch (Exception var14) {
                        }

                        return;
                    }
                }

                field_36 = this.getParameter("crashurl");
                int var23 = 0;
                String var24 = this.getParameter("cachesubdirid");
                if (var24 != null) {
                    var23 = Integer.parseInt(var24);
                    if (0 > var23 || var23 >= class_6.field_25.length) {
                        var23 = 0;
                    }
                }

                String var3 = this.getParameter("colourid");
                if (var3 != null) {
                    field_30 = Integer.parseInt(var3);
                    if (-1 < ~field_30 || class_6.field_26.length <= field_30) {
                        field_30 = 0;
                    }
                }

                this.field_38 = this.getSize().width;
                this.field_32 = this.getSize().height;
                int var4 = 32;

                try {
                    int var5 = Integer.parseInt(this.getParameter("modewhat"));
                    var4 += var5;
                } catch (Exception var19) {
                }

                try {
                    String var25 = this.getParameter("lang");
                    if (var25 != null) {
                        this.field_39 = Integer.parseInt(var25);
                    }
                } catch (Exception var18) {
                }

                class_10 var26;
                try {
                    var26 = new class_10(this, var4, class_6.field_25[var23], 30);
                } catch (Exception var17) {
                    this.method_22("nocache");
                    return;
                }

                Object var6 = null;

                byte[] var7;
                try {
                    Class.forName("java.util.jar.Pack200");
                    var7 = this.method_21(var26, class_6.field_19, (byte) -122, false);
                    if (null == var7) {
                        return;
                    }

                    var6 = new class_3(var7);
                } catch (Throwable var16) {
                }

                if (var6 == null) {
                    var7 = this.method_21(var26, class_6.field_18, (byte) -123, false);
                    if (var7 == null) {
                        return;
                    }

                    Unpack var8 = new Unpack(var7);
                    class_9 var9 = new class_9(var8);
                    Class var10 = Class.forName("unpack");
                    var9.method_0(var10.getName(), -29048, var10);
                    var10 = var9.loadClass("unpackclass");
                    byte[] var11 = this.method_21(var26, class_6.field_20, (byte) -127, false);
                    if (null == var11) {
                        return;
                    }

                    var6 = (Unpack) var10.getConstructor(Class.forName("[B"), Boolean.TYPE).newInstance(var11, Boolean.TRUE);
                }

                class_9 var27;
                byte var28;
                String var29;
                String var31;
                label283:
                {
                    var27 = new class_9((Unpack) var6);
                    var28 = -1;
                    var29 = System.getProperty("os.name").toLowerCase();
                    var31 = System.getProperty("os.arch").toLowerCase();
                    if (var29.startsWith("win")) {
                        if (!var31.startsWith("amd64") && !var31.startsWith("x86_64")) {
                            var28 = 0;
                            break label283;
                        }

                        var28 = 1;
                        break label283;
                    }

                    if (!var29.startsWith("linux")) {
                        if (!var29.startsWith("mac")) {
                            break label283;
                        }

                        if (!var31.startsWith("ppc")) {
                            if (!var31.startsWith("x86_64")) {
                                var28 = 7;
                                break label283;
                            }

                            var28 = 6;
                            break label283;
                        }

                        var28 = 4;
                        break label283;
                    }

                    if (var31.startsWith("amd64") || var31.startsWith("x86_64")) {
                        var28 = 3;
                        break label283;
                    }

                    var28 = 2;
                }

                if (0 != ~var28) {
                    this.method_21(var26, class_6.field_21[var28], (byte) -128, null != this.getParameter("suppress_sha"));
                }

                if (class_6.field_22 != null) {
                    var28 = -1;
                    var29 = System.getProperty("os.name").toLowerCase();
                    var31 = System.getProperty("os.arch").toLowerCase();
                    if (var29.startsWith("win")) {
                        label284:
                        {
                            if (var31.startsWith("amd64") || var31.startsWith("x86_64")) {
                                var28 = 2;
                                break label284;
                            }

                            var28 = 0;
                        }
                    }

                    if (var28 != -1) {
                        this.method_21(var26, class_6.field_22[var28], (byte) -124, null != this.getParameter("suppress_sha"));
                    }
                }

                if (null != class_6.field_23) {
                    var28 = -1;
                    var29 = System.getProperty("os.name").toLowerCase();
                    var31 = System.getProperty("os.arch").toLowerCase();
                    if (var29.startsWith("win") && !var31.startsWith("amd64") && !var31.startsWith("x86_64")) {
                        var28 = 0;
                    }

                    if (var28 != -1) {
                        this.method_21(var26, class_6.field_23[var28], (byte) -124, null != this.getParameter("suppress_sha"));
                    }
                }

                Class var32 = Class.forName("rp");
                var27.method_0(var32.getName(), -29048, var32);
                Class var30 = Class.forName("et");
                var27.method_0(var30.getName(), -29048, var30);
                var32 = Class.forName("qt");
                var27.method_0(var32.getName(), -29048, var32);
                var32 = Class.forName("of");
                var27.method_0(var32.getName(), -29048, var32);
                var32 = Class.forName("qn");
                var27.method_0(var32.getName(), -29048, var32);
                var32 = var27.loadClass("client");
                synchronized (this) {
                    if (this.field_34) {
                        return;
                    }

                    this.applet = (Applet) var32.newInstance();
                    var32.getMethod("providesignlink", var30).invoke((Object) null, var26);
                    this.applet.init();
                    if (this.field_33) {
                        this.applet.start();
                    }

                    if (this.field_35) {
                        this.applet.stop();
                    }
                }
            } catch (Exception var21) {
                label201:
                {
                    LoaderRuntimeException.gameVersionIdentifier = -682932437;
                    if (var21 instanceof InvocationTargetException) {
                        Throwable var2 = ((InvocationTargetException) var21).getTargetException();
                        if (var2 instanceof ThreadDeath) {
                            return;
                        }

                        LoaderRuntimeException.publishError(var2, var21.toString(), this);
                        break label201;
                    }

                    LoaderRuntimeException.publishError(var21, (String) null, this);
                }

                this.method_22("crash");
            }

        } catch (RuntimeException var22) {
            throw LoaderRuntimeException.create(var22, "loader.run()");
        }
    }

    // $FF: renamed from: a (et, b, byte, boolean) byte[]
    private final byte[] method_21(class_10 var1, class_2 var2, byte var3, boolean var4) {
        try {
            if (var3 > -121) {
                return (byte[]) null;
            } else {
                File var5;
                try {
                    var5 = var1.method_31(var2.field_3, false);
                } catch (Exception var7) {
                    this.method_22("nocache");
                    return null;
                }

                byte[] var6 = this.method_20(var5, false);
                if (!this.method_19(var2, var4, 3, var6)) {
                    var6 = this.method_17(var2, (byte) -83, false);
                    if (var6 == null) {
                        var6 = this.method_17(var2, (byte) -98, true);
                    }

                    if (var6 == null) {
                        this.method_22("download");
                        return null;
                    }

                    if (!this.method_18(true, var5, var6)) {
                        return null;
                    }

                    var6 = this.method_20(var5, false);
                    if (!this.method_19(var2, false, 3, var6)) {
                        this.method_22("mismatch");
                        return null;
                    }
                }

                return var6;
            }
        } catch (RuntimeException var8) {
            throw LoaderRuntimeException.create(var8, "loader.A(" + (var1 != null ? "{...}" : "null") + ',' + (var2 != null ? "{...}" : "null") + ',' + var3 + ',' + var4 + ')');
        }
    }

    public final void update(Graphics var1) {
        try {
            if (null != this.applet) {
                this.applet.update(var1);
            }

        } catch (RuntimeException var3) {
            throw LoaderRuntimeException.create(var3, "loader.update(" + (var1 != null ? "{...}" : "null") + ')');
        }
    }

    public final synchronized void init() {
        try {
            this.field_34 = false;
            Thread var1 = new Thread(this);
            var1.start();
        } catch (RuntimeException var2) {
            throw LoaderRuntimeException.create(var2, "loader.init()");
        }
    }

    // $FF: renamed from: a (java.lang.String, int) void
    private final void method_22(String var1) {
        try {
            if (!this.field_29) {
                this.field_29 = true;

                try {
                    if (null != field_36) {
                        this.getAppletContext().showDocument(new URL(field_36 + "&s=" + var1), "_parent");

                        return;
                    }

                    this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_loader_" + var1 + ".ws"), "_top");
                } catch (Exception ignored) {
                }

            }
        } catch (RuntimeException e) {
            throw LoaderRuntimeException.create(e, "loader.C(" + (var1 != null ? "{...}" : "null") + ',' + -9625 + ')');
        }
    }

    public final synchronized void stop() {
        try {
            this.field_33 = false;
            this.field_35 = true;
            if (null != this.applet) {
                this.applet.stop();
            }

        } catch (RuntimeException var2) {
            throw LoaderRuntimeException.create(var2, "loader.stop()");
        }
    }

    public final void paint(Graphics var1) {
        try {
            if (null != this.applet) {
                this.applet.paint(var1);
            }

        } catch (RuntimeException var3) {
            throw LoaderRuntimeException.create(var3, "loader.paint(" + (var1 != null ? "{...}" : "null") + ')');
        }
    }

    public final synchronized void destroy() {
        try {
            this.field_34 = true;
            this.field_33 = this.field_35 = false;
            if (null != this.applet) {
                this.applet.destroy();
            }

            this.applet = null;
        } catch (RuntimeException var2) {
            throw LoaderRuntimeException.create(var2, "loader.destroy()");
        }
    }
}
