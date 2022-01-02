package com.open592.appletviewer;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;

import nativeadvert.browsercontrol;

public final class AppletViewer implements ComponentListener {
    // $FF: renamed from: a app.j
    private static class_16 field_29;
    // $FF: renamed from: b app.j
    private static class_16 field_30;
    // $FF: renamed from: c app.n
    private static class_4 field_31;
    // $FF: renamed from: d java.util.Hashtable
    private static Hashtable field_32 = new Hashtable();
    // $FF: renamed from: e java.applet.Applet
    private static Applet field_33;
    // $FF: renamed from: f java.awt.Canvas
    private static Canvas field_34;
    // $FF: renamed from: g java.awt.Frame
    static Frame field_35;
    // $FF: renamed from: h boolean
    private static boolean field_36;
    // $FF: renamed from: i java.awt.Panel
    private static Panel field_37;
    // $FF: renamed from: j java.awt.Component
    private static Component field_38;
    // $FF: renamed from: k boolean
    static boolean field_39;
    // $FF: renamed from: l boolean
    static boolean field_40 = false;
    // $FF: renamed from: m java.util.Hashtable
    private static Hashtable field_41 = new Hashtable();
    // $FF: renamed from: n java.util.Hashtable
    static Hashtable field_42 = new Hashtable();
    // $FF: renamed from: o java.lang.String[]
    private static String[] field_43;
    // $FF: renamed from: p app.q[]
    private static class_1[] field_44 = null;
    // $FF: renamed from: q int[]
    private static int[] field_45;
    // $FF: renamed from: r java.io.File
    private static File field_46 = null;
    // $FF: renamed from: s app.q
    private static class_1 field_47 = null;
    // $FF: renamed from: t float
    private static float field_48 = 58988.0F;
    // $FF: renamed from: u boolean
    private static boolean field_49 = true;
    // $FF: renamed from: v java.lang.String
    private static String field_50 = null;
    // $FF: renamed from: w float
    private static float field_51 = 0.0F;
    // $FF: renamed from: x boolean
    public static boolean field_52;
    // $FF: renamed from: y int
    public static int field_53;
    // $FF: renamed from: z int
    public static int field_54;
    // $FF: renamed from: A boolean
    public static boolean field_55;

    public final void componentMoved(ComponentEvent var1) {
    }

    // $FF: renamed from: a (byte) void
    static final void method_8(byte var0) {
        if (browsercontrol.iscreated()) {
            browsercontrol.destroy();
        }

        System.exit(0);
        int var1 = 121 / ((-21 - var0) / 34);
    }

    // $FF: renamed from: a (java.lang.String, int, java.io.File) java.io.BufferedReader
    private static final BufferedReader method_9(String var0, int var1, File var2) throws IOException {
        if (var1 != -1) {
            field_50 = (String)null;
        }

        if (var0 != null) {
            return new BufferedReader(new InputStreamReader((new URL(var0)).openStream()));
        } else {
            return var2 != null ? new BufferedReader(new FileReader(var2)) : null;
        }
    }

    public static void removeadvert() {
        if (field_34 != null) {
            if (browsercontrol.iscreated()) {
                browsercontrol.destroy();
            }

            field_37.remove(field_34);
            field_34 = null;
            method_12((byte)80);
        }

    }

    // $FF: renamed from: a (byte, java.lang.String) void
    public static final void method_10(byte var0, String var1) {
        int var23 = class_21.field_91;
        field_40 = Boolean.getBoolean("com.jagex.debug");
        if (field_40) {
            System.setErr(class_14.method_34("Jagex host console", -24134));
            System.setOut(class_14.method_34("Jagex host console", -24134));
            System.out.println("release #7");
            System.out.println("java.version = " + System.getProperty("java.version"));
            System.out.println("os.name = " + System.getProperty("os.name"));
            System.out.println("os.arch = " + System.getProperty("os.arch"));
        }

        String var2;
        int var3;
        String var6;
        label275: {
            class_21.method_41(-91);
            var2 = class_21.method_42(-32237, "Language");
            var3 = 0;
            if (null == var2) {
                byte var7;
                label280: {
                    Locale var4 = Locale.getDefault();
                    String var5 = var4.getISO3Language();
                    var6 = var4.getISO3Country();
                    var7 = -1;
                    if (var5 != null) {
                        if (var5.equals("eng")) {
                            var7 = 0;
                        }

                        if (var5.equals("ger") || var5.equals("deu")) {
                            var7 = 1;
                        }

                        if (var5.equals("fre") || var5.equals("fra")) {
                            var7 = 2;
                        }

                        if (!var5.equals("por")) {
                            break label280;
                        }

                        var7 = 3;
                        if (var23 == 0) {
                            break label280;
                        }
                    }

                    if (null != var6) {
                        if (var6.equals("GB") || var6.equals("US")) {
                            var7 = 0;
                        }

                        if (var6.equals("DE")) {
                            var7 = 1;
                        }

                        if (var6.equals("FR")) {
                            var7 = 2;
                        }

                        if (var6.equals("BR")) {
                            var7 = 3;
                        }
                    }
                }

                if (var7 >= 0) {
                    class_21.method_43(Integer.toString(var7), (byte)120, "Language");
                    class_21.method_44(true);
                }

                if (var23 == 0) {
                    break label275;
                }
            }

            var3 = Integer.parseInt(var2);
        }

        class_10.method_31(var3, true);
        field_35 = new Frame();
        File var31 = new File((new File(System.getProperty("user.dir"))).getParentFile(), var1);
        File var32 = new File(var31, "jagexappletviewer.png");
        System.out.println("Trying to load icon file: " + var32.getAbsolutePath());
        if (var32.exists()) {
            Image var33 = Toolkit.getDefaultToolkit().getImage(var32.getAbsolutePath());
            if (var33 != null) {
                field_35.setIconImage(var33);
            }
        }

        class_9.method_30(var0 ^ -367);
        class_9.method_26(var0 + 155);
        class_9.method_29(false, method_19("loading_config", 0));
        var6 = System.getProperty("com.jagex.config");
        String var34 = System.getProperty("com.jagex.configfile");
        if (null == var6) {
            if (null == var34) {
                class_19.method_40((byte)47, method_19("err_missing_config", 0));
            }

            field_46 = new File(var31, var34);
        }

        while(true) {
            if (var6 != null) {
                field_50 = method_24(var0 + -44, var6);
                System.out.println("Config URL is " + field_50);
            }

            if (method_22((byte)-69, var3) && var23 == 0) {
                break;
            }

            var3 = 0;
            var2 = class_21.method_42(-32237, "Language");
            if (var2 != null) {
                var3 = Integer.parseInt(var2);
                if (var23 != 0) {
                    break;
                }
            }
        }

        String var8 = method_20((byte)-63, "viewerversion");
        int var9;
        if (null != var8) {
            try {
                var9 = Integer.parseInt(var8);
                if (~var9 < -101) {
                    class_19.method_39(method_19("new_version", var0 ^ -47), (byte)112);
                }
            } catch (NumberFormatException ignored) {
            }
        }

        var9 = 32 + Integer.parseInt(method_15(0, "modewhat"));
        String var10 = method_20((byte)-14, "cachesubdir");
        String var11 = method_20((byte)-90, "codebase");
        if (var0 == -47) {
            String var12 = System.getProperty("os.name").toLowerCase();
            String var13 = System.getProperty("os.arch").toLowerCase();
            field_39 = var12.startsWith("win");
            field_36 = field_39 && var13.startsWith("amd64") || var13.startsWith("x86_64");
            String var14 = null;

            try {
                var14 = System.getProperty("user.home");
                if (null != var14) {
                    var14 = var14 + "/";
                }
            } catch (Exception ignored) {
            }

            class_9.method_29(false, method_19("loading_app_resources", 0));
            if (var14 == null) {
                var14 = "~/";
            }

            File var15 = null;

            byte[] var16;
            try {
                byte[] var17;
                if (field_36) {
                    var16 = method_13(var11, -1, method_20((byte)98, "browsercontrol_win_amd64_jar"));
                    var15 = method_17(var9, "browsercontrol64.dll", var14, var10, -89);
                    System.out.printf("Attempting to validate %s", "browser");
                    var17 = (new class_13(var16)).validateFile("browsercontrol64.dll", var0 ^ 83);
                    if (null == var17) {
                        var15 = null;
                        class_19.method_40((byte)47, method_19("err_verify_bc64", 0));
                    }

                    method_21((byte)-122, var17, var15);
                } else if (field_39) {
                    var16 = method_13(var11, -1, method_20((byte)110, "browsercontrol_win_x86_jar"));
                    var15 = method_17(var9, "browsercontrol.dll", var14, var10, -78);
                    var17 = (new class_13(var16)).validateFile("browsercontrol.dll", -128);
                    if (var17 == null) {
                        var15 = null;
                        class_19.method_40((byte)47, method_19("err_verify_bc", 0));
                    }

                    method_21((byte)25, var17, var15);
                    if (field_40) {
                        System.out.println("dlldata : " + var16.length);
                    }
                }
            } catch (Exception var30) {
                if (field_40) {
                    var30.printStackTrace();
                }

                class_19.method_40((byte)47, method_19("err_load_bc", 0));
            }

            class_9.method_29(false, method_19("loading_app", 0));
            if (field_39) {
                class_5.method_4(255);
            }

            try {
                var16 = method_13(var11, -1, method_20((byte) -92, "loader_jar"));
                class_8 var36 = new class_8(var16);
                field_33 = (Applet) var36.loadClass("loader").getDeclaredConstructor().newInstance();
                if (field_40) {
                    System.out.println("loader_jar : " + var16.length);
                }
            } catch (Exception var29) {
                if (field_40) {
                    var29.printStackTrace();
                }

                class_19.method_40((byte)47, method_19("err_target_applet", var0 + 47));
            }

            class_9.method_28(true);
            class_3.method_1(true);
            field_35.setTitle(method_20((byte)109, "title"));
            int var35 = field_39 ? Integer.parseInt(method_20((byte)103, "advert_height")) : 0;
            int var37 = Integer.parseInt(method_20((byte)-53, "window_preferredwidth"));
            int var18 = Integer.parseInt(method_20((byte)-121, "window_preferredheight"));
            byte var19 = 40;
            Insets var20 = field_35.getInsets();
            field_35.setSize(var20.right + var37 + var20.left, var20.bottom + var18 + (var35 + var20.top - -var19));
            field_35.setLocationRelativeTo((Component)null);
            field_35.setVisible(true);
            field_37 = new Panel();
            field_37.setBackground(Color.black);
            field_37.setLayout((LayoutManager)null);
            field_35.setLayout(new BorderLayout());
            field_35.add(field_37, "Center");
            boolean var21 = !"yes".equals(class_21.method_42(-32237, "Member"));
            if (field_39 && var21) {
                field_34 = new Canvas();
                field_37.add(field_34);
            }

            field_37.add(field_33);
            field_31 = new class_4(new class_11());
            field_31.setBackground(Color.BLACK);
            field_31.setForeground(Color.GRAY);
            field_31.method_2(method_19("language", var0 ^ -47), false);
            if (null != field_44 && field_44.length > 1) {
                field_31.method_2(method_19("switchserver", 0), false);
            }

            field_31.setFont(new Font("SansSerif", 0, 10));
            field_37.add(field_31);
            field_38 = new class_0(method_19("tandc", 0));
            field_37.add(field_38);
            field_35.doLayout();
            method_12((byte)69);
            if (field_39) {
                try {
                    System.load(var15.toString());
                } catch (Throwable var26) {
                    if (field_40) {
                        var26.printStackTrace();
                    }

                    class_19.method_40((byte)47, method_19("err_create_advertising", 0));
                    return;
                }
            }

            if (field_39 && var21) {
                while(!field_34.isDisplayable() || !field_34.isShowing() || var23 != 0) {
                    try {
                        Thread.sleep(100L);
                    } catch (Exception var28) {
                        if (var23 != 0) {
                            break;
                        }
                    }
                }

                try {
                    browsercontrol.create(field_34, method_20((byte)120, "adverturl"));
                    browsercontrol.resize(field_34.getSize().width, field_34.getSize().height);
                } catch (Throwable var27) {
                    if (field_40) {
                        var27.printStackTrace();
                    }

                    class_19.method_40((byte)47, method_19("err_create_advertising", 0));
                    return;
                }
            }

            field_35.addWindowListener(class_12.method_32(17407));
            field_37.addComponentListener(new AppletViewer());
            field_33.setStub(new class_17());
            field_33.init();
            field_33.start();
        }
    }

    public final void componentHidden(ComponentEvent var1) {
    }

    // $FF: renamed from: a (app.q, int) void
    private static final void method_11(class_1 var0, int var1) {
        if (null != var0) {
            class_9.method_29(false, method_19("loading_app", var1 ^ 21870));
            class_9.method_25(0, (byte)101);
            class_9.method_26(109);
            class_9.method_27(-83);
            if (null != field_33) {
                if (field_38.isVisible()) {
                    field_38.setVisible(false);
                    method_12((byte)100);
                }

                field_33.stop();
                class_9.method_25(25, (byte)53);
                class_9.method_27(-40);
                field_33.destroy();
                field_37.remove(field_33);
                field_33 = null;
                field_37.remove(field_38);
            }

            field_47 = var0;
            class_9.method_25(50, (byte)-84);
            class_9.method_27(-73);
            if (field_39) {
                class_5.method_4(var1 + -21615);
            }

            try {
                String var2 = method_20((byte)105, "codebase");
                byte[] var3 = method_13(var2, var1 + -21871, method_20((byte)103, "loader_jar"));
                class_9.method_25(75, (byte)-115);
                class_9.method_27(-76);
                class_8 var4 = new class_8(var3);
                field_33 = (Applet)var4.loadClass("loader").newInstance();
                if (field_40) {
                    System.out.println("loader_jar : " + var3.length);
                }

                class_9.method_28(true);
            } catch (Exception var5) {
                if (field_40) {
                    var5.printStackTrace();
                }

                class_9.method_28(true);
                class_19.method_40((byte)47, method_19("err_target_applet", 0));
            }

            field_37.add(field_33);
            field_38 = new class_0(method_19("tandc", var1 ^ var1));
            field_37.add(field_38);
            field_49 = true;
            method_12((byte)95);
            field_33.setStub(new class_17());
            field_33.init();
            field_33.start();
        }
    }

    // $FF: renamed from: b (byte) void
    private static final void method_12(byte var0) {
        if (null != field_33) {
            int var1 = field_31.isVisible() ? 20 : 0;
            int var2 = null == field_34 ? 0 : Integer.parseInt(method_20((byte)98, "advert_height"));
            int var3 = !field_38.isVisible() ? 0 : 40;
            int var4 = Integer.parseInt(method_20((byte)124, "applet_minwidth"));
            int var5 = Integer.parseInt(method_20((byte)-123, "applet_minheight"));
            int var6 = Integer.parseInt(method_20((byte)-18, "applet_maxwidth"));
            int var7 = Integer.parseInt(method_20((byte)126, "applet_maxheight"));
            Dimension var8 = field_37.getSize();
            Insets var9 = field_37.getInsets();
            int var10 = -var9.right + var8.width - var9.left;
            int var11 = -var9.top + var8.height + -var9.bottom;
            int var12 = -9 / ((var0 - -47) / 34);
            int var13 = var10;
            if (~var10 > ~var4) {
                var13 = var4;
            }

            int var14 = -var3 + -var2 + var11 + -var1;
            if (var5 > var14) {
                var14 = var5;
            }

            if (field_49) {
                if (var7 < var14) {
                    var14 = var7;
                }

                if (var6 < var13) {
                    var13 = var6;
                }
            }

            int var15 = var10;
            if (var4 > var10) {
                var15 = var4;
            }

            field_31.setBounds((-var13 + var15) / 2, 0, var13, var1);
            if (~var11 > ~(var5 + var2 - -var3 + var1)) {
                int var16 = var1 + var3 + var2 + var5;
            }

            if (field_34 != null) {
                field_34.setBounds((-var13 + var15) / 2, var1, var13, var2);
            }

            field_33.setBounds((var15 + -var13) / 2, var2 + var1, var13, var14);
            field_38.setBounds((var15 - var13) / 2, var14 + var2 + var1, var13, var3);
            if (null != field_34 && browsercontrol.iscreated()) {
                browsercontrol.resize(field_34.getSize().width, field_34.getSize().height);
            }

            field_35.repaint();
        }
    }

    // $FF: renamed from: a (java.lang.String, int, java.lang.String) byte[]
    private static final byte[] method_13(String var0, int var1, String var2) {
        int var7 = class_21.field_91;
        if (var1 != -1) {
            field_29 = (class_16)null;
        }

        byte[] var3 = new byte[300000];
        int var4 = 0;

        try {
            InputStream var5 = (new URL(var0 + var2)).openStream();

            while(~var4 > ~var3.length) {
                int var6 = var5.read(var3, var4, -var4 + var3.length);
                if (-1 < ~var6) {
                    break;
                }

                var4 += var6;
                field_51 += (float)var6;
                class_9.method_25((int)(100.0F * (field_51 / field_48)), (byte)-90);
                if (var7 != 0) {
                    break;
                }
            }

            var5.close();
        } catch (Exception var8) {
            if (field_40) {
                var8.printStackTrace();
            }

            class_19.method_40((byte)47, method_19("err_downloading", 0) + ": " + var2);
        }

        byte[] var9 = new byte[var4];
        System.arraycopy(var3, 0, var9, 0, var4);
        return var9;
    }

    // $FF: renamed from: a (int) void
    public static final void method_14(int var0) {
        if (var0 != 4443) {
            field_45 = (int[])null;
        }

        boolean var1 = false;
        if (!field_31.isVisible()) {
            var1 = true;
            field_31.setVisible(true);
        }

        if (!field_38.isVisible()) {
            var1 = true;
            field_38.setVisible(true);
        }

        if (var1) {
            method_12((byte)-91);
        }

    }

    // $FF: renamed from: a (int, java.lang.String) java.lang.String
    static final String method_15(int var0, String var1) {
        if (var0 != 0) {
            field_37 = (Panel)null;
        }

        if (field_47 != null) {
            String var2 = (String)field_47.field_7.get(var1);
            if (var2 != null) {
                return var2;
            }
        }

        return (String)field_41.get(var1);
    }

    // $FF: renamed from: b (int) void
    static final void method_16(int var0) {
        int var9 = class_21.field_91;
        String var1 = method_20((byte)126, "serverlist");
        class_1[] var2 = field_44;
        int var3 = field_44.length;
        if (var0 != -14393) {
            method_12((byte)-41);
        }

        if (var1 != null) {
            var2 = new class_1[field_44.length];
            var3 = 0;

            try {
                BufferedReader var4 = method_9(var1, -1, (File)null);

                label67:
                do {
                    String[] var6;
                    do {
                        String var5;
                        do {
                            var5 = var4.readLine();
                            if (null == var5 && var9 == 0) {
                                break label67;
                            }

                            var5 = var5.trim();
                        } while(var5.startsWith("//"));

                        var6 = var5.split(",");
                    } while(~var6.length > -3);

                    if (var6[1].trim().toLowerCase().equals("true")) {
                        String var7 = var6[0].trim();
                        int var8 = 0;

                        while(~field_44.length < ~var8) {
                            if (field_44[var8].field_6.equals(var7)) {
                                var2[var3++] = field_44[var8];
                            }

                            ++var8;
                            if (var9 != 0) {
                                break;
                            }
                        }
                    }
                } while(var9 == 0);

                var4.close();
            } catch (IOException var10) {
                var3 = field_44.length;
                var2 = field_44;
            }
        }

        String[] var11 = new String[var3];
        int var12 = 0;

        while(~var12 > ~var3) {
            var11[var12] = (String)var2[var12].field_5.get("servername");
            ++var12;
            if (var9 != 0) {
                break;
            }
        }

        field_29.method_35(true, var11);
        var12 = field_29.method_36((byte)-57);
        if (~var12 <= -1) {
            method_11(var2[var12], 21870);
        }

    }

    // $FF: renamed from: a (int, java.lang.String, java.lang.String, java.lang.String, int) java.io.File
    private static final File method_17(int var0, String var1, String var2, String var3, int var4) {
        int var16 = class_21.field_91;
        int var7 = -66 / ((var4 - -16) / 55);
        String[] var5 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", var2, "/tmp/", ""};
        String[] var6 = new String[]{".jagex_cache_" + var0, ".file_store_" + var0};
        int var8 = 0;

        while(~var8 > -3) {
            int var9 = 0;

            label101:
            while(~var9 > ~var6.length) {
                int var10 = 0;

                while(true) {
                    if (var10 < var5.length) {
                        String var11 = var5[var10] + var6[var9] + "/" + (var3 != null ? var3 + "/" : "") + var1;
                        RandomAccessFile var12 = null;

                        label111: {
                            label112: {
                                File var13;
                                boolean var10001;
                                label92: {
                                    try {
                                        var13 = new File(var11);
                                        if (var8 != 0 || var13.exists()) {
                                            break label92;
                                        }
                                    } catch (Exception var20) {
                                        var10001 = false;
                                        break label112;
                                    }

                                    if (var16 == 0) {
                                        break label111;
                                    }
                                }

                                label84: {
                                    try {
                                        String var14 = var5[var10];
                                        if (-2 != ~var8 || 0 >= var14.length() || (new File(var14)).exists()) {
                                            break label84;
                                        }
                                    } catch (Exception var19) {
                                        var10001 = false;
                                        break label112;
                                    }

                                    if (var16 == 0) {
                                        break label111;
                                    }
                                }

                                try {
                                    (new File(var5[var10] + var6[var9])).mkdir();
                                    if (var3 != null) {
                                        (new File(var5[var10] + var6[var9] + "/" + var3)).mkdir();
                                    }

                                    var12 = new RandomAccessFile(var13, "rw");
                                    int var15 = var12.read();
                                    var12.seek(0L);
                                    var12.write(var15);
                                    var12.seek(0L);
                                    var12.close();
                                    return var13;
                                } catch (Exception var18) {
                                    var10001 = false;
                                }
                            }

                            if (field_40) {
                                System.out.println("Unable to open/write: " + var11);
                            }

                            try {
                                if (var12 != null) {
                                    var12.close();
                                    var12 = null;
                                }
                            } catch (Exception var17) {
                            }
                        }

                        ++var10;
                        if (var16 == 0) {
                            continue;
                        }
                    }

                    ++var9;
                    if (var16 == 0) {
                        break;
                    }
                    break label101;
                }
            }

            ++var8;
            if (var16 != 0) {
                break;
            }
        }

        if (!field_40) {
            throw new RuntimeException();
        } else {
            throw new RuntimeException("Fatal - could not find ANY location for file: " + var1);
        }
    }

    // $FF: renamed from: c (int) void
    public static final void method_18(int var0) {
        boolean var1 = false;
        if (null == field_44 && field_31.isVisible()) {
            field_31.setVisible(false);
            var1 = true;
        }

        if (field_38.isVisible()) {
            var1 = true;
            field_38.setVisible(false);
        }

        if (var1) {
            method_12((byte)102);
        }

        int var2 = 65 / ((var0 - 72) / 48);
    }

    // $FF: renamed from: a (java.lang.String, int) java.lang.String
    static final String method_19(String var0, int var1) {
        if (null != field_47) {
            String var2 = (String)field_47.field_8.get(var0);
            if (var2 != null) {
                return var2;
            }
        }

        return var1 != 0 ? (String)null : (String)field_42.get(var0);
    }

    // $FF: renamed from: b (byte, java.lang.String) java.lang.String
    static final String method_20(byte var0, String var1) {
        int var2 = 22 / ((42 - var0) / 55);
        if (null != field_47) {
            String var3 = (String)field_47.field_5.get(var1);
            if (var3 != null) {
                return var3;
            }
        }

        return (String)field_32.get(var1);
    }

    public final void componentResized(ComponentEvent var1) {
        method_12((byte)2);
    }

    // $FF: renamed from: a (byte, byte[], java.io.File) boolean
    private static final boolean method_21(byte var0, byte[] var1, File var2) {
        int var3 = -97 / ((-72 - var0) / 50);

        try {
            FileOutputStream var4 = new FileOutputStream(var2);
            var4.write(var1, 0, var1.length);
            var4.close();
            return true;
        } catch (IOException var5) {
            if (field_40) {
                var5.printStackTrace();
            }

            class_19.method_40((byte)47, method_19("err_save_file", 0));
            return false;
        }
    }

    // $FF: renamed from: a (byte, int) boolean
    private static final boolean method_22(byte var0, int var1) {
        int var14 = class_21.field_91;
        field_41.clear();
        int var2 = 0;
        class_10.method_31(var1, true);
        field_32.clear();
        field_47 = null;
        field_44 = null;
        int var3 = 0;
        class_1[] var4 = new class_1[50];

        int var23;
        try {
            BufferedReader var5 = method_9(field_50, -1, field_46);
            if (var0 >= -43) {
                removeadvert();
            }

            Hashtable var6 = field_41;
            Hashtable var7 = field_32;
            Hashtable var8 = field_42;

            label174:
            do {
                String var9;
                do {
                    do {
                        var9 = var5.readLine();
                        if (var9 == null) {
                            break label174;
                        }

                        var9 = var9.trim();
                    } while(var9.startsWith("//"));
                } while(var9.startsWith("#") && var14 == 0);

                if (var9.startsWith("[")) {
                    String var10 = var9.substring(1, var9.lastIndexOf(93));
                    class_1 var11 = new class_1(var10);
                    if (field_47 == null) {
                        field_47 = var11;
                    }

                    if (var3 >= var4.length) {
                        class_1[] var12 = new class_1[10 + var3];
                        System.arraycopy(var4, 0, var12, 0, var4.length);
                        var4 = var12;
                    }

                    var4[var3++] = var11;
                    var6 = var11.field_7;
                    var7 = var11.field_5;
                    var8 = var11.field_8;
                }

                String var25;
                String var26;
                if (!var9.startsWith("param=")) {
                    if (!var9.startsWith("msg=")) {
                        var23 = var9.indexOf(61);
                        if (var23 != -1) {
                            var25 = var9.substring(0, var23).trim().toLowerCase();
                            var26 = var9.substring(1 + var23).trim();
                            var7.put(var25, var26);
                            if (field_40) {
                                System.out.println("Ourconfig - variable=" + var25 + " value=" + var26);
                            }
                        }

                        if (var14 == 0) {
                            continue;
                        }
                    }

                    var9 = var9.substring(4);
                    var23 = var9.indexOf(61);
                    if (~var23 != 0) {
                        var25 = var9.substring(0, var23).trim().toLowerCase();
                        var26 = var9.substring(var23 - -1).trim();
                        if (var25.startsWith("lang")) {
                            try {
                                Integer.parseInt(var25.substring(4));
                                ++var2;
                            } catch (NumberFormatException var15) {
                            }
                        }

                        var8.put(var25, var26);
                        if (field_40) {
                            System.out.println("Message - name=" + var25 + " text=" + var26);
                        }
                    }

                    if (var14 == 0) {
                        continue;
                    }
                }

                var9 = var9.substring(6);
                var23 = var9.indexOf(61);
                if (-1 != var23) {
                    var25 = var9.substring(0, var23).trim().toLowerCase();
                    var26 = var9.substring(1 + var23).trim();
                    var6.put(var25, var26);
                    if (field_40) {
                        System.out.println("Innerconfig - variable=" + var25 + " value=" + var26);
                    }
                }
            } while(var14 == 0);

            var5.close();
        } catch (IOException var17) {
            if (field_40) {
                var17.printStackTrace();
            }

            class_19.method_40((byte)47, method_19("err_load_config", 0));
        } catch (Exception var18) {
            if (field_40) {
                var18.printStackTrace();
            }

            class_19.method_40((byte)47, method_19("err_decode_config", 0));
        }

        if (-1 > ~var2) {
            field_45 = new int[var2];
            field_43 = new String[var2];
            int var19 = 0;
            Enumeration var20 = field_42.keys();

            label136:
            do {
                while(true) {
                    if (!var20.hasMoreElements()) {
                        break label136;
                    }

                    String var21 = (String)var20.nextElement();
                    if (!var21.startsWith("lang")) {
                        break;
                    }

                    int var22 = 0;

                    try {
                        var22 = Integer.parseInt(var21.substring(4));
                    } catch (NumberFormatException var16) {
                        if (var14 == 0) {
                            continue;
                        }
                    }

                    int var24 = 0;

                    while(var19 >= var24) {
                        if (~var19 == ~var24 || ~var22 > ~field_45[var24]) {
                            var23 = var19;

                            while(~var23 < ~var24) {
                                field_43[var23] = field_43[-1 + var23];
                                field_45[var23] = field_45[-1 + var23];
                                --var23;
                                if (var14 != 0) {
                                    break;
                                }
                            }

                            field_45[var24] = var22;
                            field_43[var24] = method_19(var21, 0);
                            if (var14 == 0) {
                                break;
                            }
                        }

                        ++var24;
                        if (var14 != 0) {
                            break;
                        }
                    }

                    ++var19;
                    break;
                }
            } while(var14 == 0);

            field_30 = new class_16(method_19("language", 0));
            field_30.method_35(true, field_43);
            if (~var3 < -1) {
                field_44 = new class_1[var3];
                System.arraycopy(var4, 0, field_44, 0, var3);
                field_29 = new class_16(method_19("switchserver", 0));
            }

            if (class_21.method_42(-32237, "Language") == null) {
                return method_23(0) < 0;
            }
        }

        return true;
    }

    // $FF: renamed from: d (int) int
    static final int method_23(int var0) {
        int var1 = field_30.method_36((byte)-57);
        if (var0 <= var1) {
            class_21.method_43(Integer.toString(field_45[var1]), (byte)-90, "Language");
            class_21.method_44(true);
            return var1;
        } else {
            return -1;
        }
    }

    public static void doresize(int var0) {
        if (-1 != ~var0) {
            if (1 == var0 && field_49) {
                field_49 = false;
                method_12((byte)108);
            }
        } else if (!field_49) {
            field_49 = true;
            method_12((byte)104);
        }

    }

    public static void readdadvert() {
        if (field_39 && null == field_34) {
            field_34 = new Canvas();
            field_37.add(field_34);
            method_12((byte)9);

            while(!field_34.isDisplayable() || !field_34.isShowing()) {
                try {
                    Thread.sleep(100L);
                } catch (Exception var1) {
                }
            }

            try {
                browsercontrol.create(field_34, method_20((byte)-67, "adverturl"));
                browsercontrol.resize(field_34.getSize().width, field_34.getSize().height);
            } catch (Throwable var2) {
                if (field_40) {
                    var2.printStackTrace();
                }

                class_19.method_40((byte)47, method_19("err_create_advertising", 0));
                return;
            }
        }

    }

    // $FF: renamed from: b (int, java.lang.String) java.lang.String
    private static final String method_24(int var0, String var1) {
        int var9 = class_21.field_91;
        String var2 = var1;
        if (var0 > -7) {
            method_15(-117, (String)null);
        }

        do {
            int var3 = var2.indexOf("$(");
            if (~var3 > -1) {
                break;
            }

            int var4 = var2.indexOf(":", var3);
            int var5 = var2.indexOf(")", var4);
            if (-1 < ~var4 || 0 > var5 && var9 == 0) {
                break;
            }

            String var6 = var2.substring(2 + var3, var4);
            String var7 = var2.substring(1 + var4, var5);
            String var8 = class_21.method_42(-32237, var6);
            if (null != var8) {
                var7 = var8;
            }

            if (var5 < -1 + var2.length()) {
                var2 = var2.substring(0, var3) + var7 + var2.substring(var5 - -1);
                if (var9 == 0) {
                    continue;
                }
            }

            var2 = var2.substring(0, var3) + var7;
        } while(var9 == 0);

        return var2;
    }

    public final void componentShown(ComponentEvent var1) {
    }
}
