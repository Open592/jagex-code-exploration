package com.open592.appletviewer;

import nativeadvert.browsercontrol;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.*;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Optional;

public final class AppletViewer implements ComponentListener {
    // $FF: renamed from: a app.j
    private static class_16 field_29;
    // $FF: renamed from: b app.j
    private static class_16 field_30;
    // $FF: renamed from: c app.n
    private static class_4 field_31;
    // $FF: renamed from: d java.util.Hashtable
    private static final Hashtable<String, String> configurationItems = new Hashtable<>();
    // $FF: renamed from: e java.applet.Applet
    private static Applet field_33;
    // $FF: renamed from: f java.awt.Canvas
    private static Canvas field_34;
    // $FF: renamed from: g java.awt.Frame
    static Frame frame;
    // $FF: renamed from: h boolean
    private static boolean field_36;
    // $FF: renamed from: i java.awt.Panel
    private static Panel field_37;
    // $FF: renamed from: j java.awt.Component
    private static Component field_38;
    // $FF: renamed from: k boolean
    static boolean field_39;
    // $FF: renamed from: l boolean
    static boolean isDebug = false;
    // $FF: renamed from: m java.util.Hashtable
    private static final Hashtable<String, String> params = new Hashtable<>();
    // $FF: renamed from: n java.util.Hashtable
    static Hashtable<String, String> localeStrings = new Hashtable<>();
    // $FF: renamed from: o java.lang.String[]
    private static String[] localeStringList;
    // $FF: renamed from: p app.q[]
    private static ServerSettings[] serverSettingsList = null;
    // $FF: renamed from: q int[]
    private static int[] languageIDs;
    // $FF: renamed from: r java.io.File
    private static File javConfigFile = null;
    // $FF: renamed from: s app.q
    private static ServerSettings currentServerSettings = null;
    // $FF: renamed from: u boolean
    private static boolean field_49 = true;
    // $FF: renamed from: v java.lang.String
    private static String javConfigURL = null;
    // $FF: renamed from: w float
    private static float field_51 = 0.0F;
    // $FF: renamed from: x boolean
    public static boolean field_52;

    public void componentMoved(ComponentEvent var1) {
    }

    // $FF: renamed from: a (byte) void
    static void method_8() {
        if (browsercontrol.iscreated()) {
            browsercontrol.destroy();
        }

        System.exit(0);
    }

    // $FF: renamed from: a (java.lang.String, int, java.io.File) java.io.BufferedReader
    private static BufferedReader fetchJavConfig(String URL, File file) throws IOException {
        if (URL != null) {
            return new BufferedReader(new InputStreamReader((new URL(URL)).openStream()));
        }

        if (file != null) {
            return new BufferedReader(new FileReader(file));
        }

        return null;
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
    public static void method_10(byte var0, String gameName) {
        isDebug = Boolean.getBoolean("com.jagex.debug");

        if (isDebug) {
            boolean showHostConsole = Boolean.getBoolean("com.jagex.hostConsole");

            if (showHostConsole) {
                System.setErr(class_14.method_34("Jagex host console", -24134));
                System.setOut(class_14.method_34("Jagex host console", -24134));
            }

            System.out.println("release #7");
            System.out.println("java.version = " + System.getProperty("java.version"));
            System.out.println("os.name = " + System.getProperty("os.name"));
            System.out.println("os.arch = " + System.getProperty("os.arch"));
        }

        Language language = Language.resolveFromAppletViewerPreferences().orElseGet(() -> {
            Language userLanguage = Language.resolveUserLanguage();

            AppletViewerPreferences.addPreference(Integer.toString(userLanguage.getID()), "Language");
            AppletViewerPreferences.writePreferencesToFile();

            return userLanguage;
        });

        String javConfigURL;

        InitialLocaleStrings.initialize(language);
        frame = new Frame();
        File gameDirectory = new File((new File(System.getProperty("user.dir"))).getParentFile(), gameName);
        File iconFile = new File(gameDirectory, "jagexappletviewer.png");
        System.out.println("Trying to load icon file: " + iconFile.getAbsolutePath());
        if (iconFile.exists()) {
            Image iconImage = Toolkit.getDefaultToolkit().getImage(iconFile.getAbsolutePath());
            if (iconImage != null) {
                frame.setIconImage(iconImage);
            }
        }

        class_9.method_30(var0 ^ -367);
        class_9.method_26(var0 + 155);
        class_9.method_29(false, getLocaleString("loading_config", 0));
        javConfigURL = System.getProperty("com.jagex.config");
        String configFileName = System.getProperty("com.jagex.configfile");
        if (null == javConfigURL) {
            if (null == configFileName) {
                class_19.method_40((byte)47, getLocaleString("err_missing_config", 0));
            }

            javConfigFile = new File(gameDirectory, configFileName);
        }

        if (javConfigURL != null) {
            AppletViewer.javConfigURL = resolveConfigURLTemplate(javConfigURL);
            System.out.println("Config URL is " + AppletViewer.javConfigURL);
        }

        readJavConfig(language);

        String var8 = getConfigValue("viewerversion");
        int var9;
        if (null != var8) {
            try {
                var9 = Integer.parseInt(var8);
                if (~var9 < -101) {
                    class_19.method_39(getLocaleString("new_version", var0 ^ -47), (byte)112);
                }
            } catch (NumberFormatException ignored) {
            }
        }

        var9 = 32 + Integer.parseInt(getParameter("modewhat"));
        String var10 = getConfigValue("cachesubdir");
        String var11 = getConfigValue("codebase");
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

            class_9.method_29(false, getLocaleString("loading_app_resources", 0));
            if (var14 == null) {
                var14 = "~/";
            }

            File var15 = null;

            byte[] var16;
            try {
                byte[] var17;
                if (field_36) {
                    var16 = method_13(var11, getConfigValue("browsercontrol_win_amd64_jar"));
                    var15 = method_17(var9, "browsercontrol64.dll", var14, var10, -89);
                    System.out.printf("Attempting to validate %s", "browser");
                    var17 = (new class_13(var16)).validateFile("browsercontrol64.dll", var0 ^ 83);
                    if (null == var17 && !AppletViewer.isDebug) {
                        var15 = null;
                        class_19.method_40((byte)47, getLocaleString("err_verify_bc64", 0));
                    }

                    method_21((byte)-122, var17, var15);
                } else if (field_39) {
                    var16 = method_13(var11, getConfigValue("browsercontrol_win_x86_jar"));
                    var15 = method_17(var9, "browsercontrol.dll", var14, var10, -78);
                    var17 = (new class_13(var16)).validateFile("browsercontrol.dll", -128);
                    if (var17 == null && !AppletViewer.isDebug) {
                        var15 = null;
                        class_19.method_40((byte) 47, getLocaleString("err_verify_bc", 0));
                    }

                    method_21((byte)25, var17, var15);
                    if (isDebug) {
                        System.out.println("dlldata : " + var16.length);
                    }
                }
            } catch (Exception var30) {
                if (isDebug) {
                    var30.printStackTrace();
                }

                class_19.method_40((byte)47, getLocaleString("err_load_bc", 0));
            }

            class_9.method_29(false, getLocaleString("loading_app", 0));
            if (field_39) {
                class_5.method_4(255);
            }

            try {
                var16 = method_13(var11, getConfigValue("loader_jar"));
                class_8 var36 = new class_8(var16);
                field_33 = (Applet) var36.loadClass("loader").getDeclaredConstructor().newInstance();
                if (isDebug) {
                    System.out.println("loader_jar : " + var16.length);
                }
            } catch (Exception var29) {
                if (isDebug) {
                    var29.printStackTrace();
                }

                class_19.method_40((byte)47, getLocaleString("err_target_applet", 0));
            }

            class_9.method_28(true);
            class_3.method_1(true);
            frame.setTitle(getConfigValue("title"));
            int var35 = field_39 ? Integer.parseInt(getConfigValue("advert_height")) : 0;
            int var37 = Integer.parseInt(getConfigValue("window_preferredwidth"));
            int var18 = Integer.parseInt(getConfigValue("window_preferredheight"));
            byte var19 = 40;
            Insets var20 = frame.getInsets();
            frame.setSize(var20.right + var37 + var20.left, var20.bottom + var18 + (var35 + var20.top - -var19));
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            field_37 = new Panel();
            field_37.setBackground(Color.black);
            field_37.setLayout(null);
            frame.setLayout(new BorderLayout());
            frame.add(field_37, "Center");
            AppletViewerPreferences.getPreference("Member");
            if (field_39) {
                field_34 = new Canvas();
                field_37.add(field_34);
            }

            field_37.add(field_33);
            field_31 = new class_4(new class_11());
            field_31.setBackground(Color.BLACK);
            field_31.setForeground(Color.GRAY);
            field_31.method_2(getLocaleString("language", 0), false);
            if (null != serverSettingsList && serverSettingsList.length > 1) {
                field_31.method_2(getLocaleString("switchserver", 0), false);
            }

            field_31.setFont(new Font("SansSerif", 0, 10));
            field_37.add(field_31);
            field_38 = new class_0(getLocaleString("tandc", 0));
            field_37.add(field_38);
            frame.doLayout();
            method_12((byte)69);
            if (field_39) {
                try {
                    System.load(var15.toString());
                } catch (Throwable var26) {
                    if (isDebug) {
                        var26.printStackTrace();
                    }

                    class_19.method_40((byte)47, getLocaleString("err_create_advertising", 0));
                    return;
                }
            }

            if (field_39) {
                while(!field_34.isDisplayable() || !field_34.isShowing()) {
                    try {
                        Thread.sleep(100L);
                    } catch (Exception ignored) {
                    }
                }

                try {
                    browsercontrol.create(field_34, getConfigValue("adverturl"));
                    browsercontrol.resize(field_34.getSize().width, field_34.getSize().height);
                } catch (Throwable var27) {
                    if (isDebug) {
                        var27.printStackTrace();
                    }

                    class_19.method_40((byte)47, getLocaleString("err_create_advertising", 0));
                    return;
                }
            }

            frame.addWindowListener(class_12.method_32(17407));
            field_37.addComponentListener(new AppletViewer());
            field_33.setStub(new class_17());
            field_33.init();
            field_33.start();
        }
    }

    public void componentHidden(ComponentEvent var1) {
    }

    // $FF: renamed from: a (app.q, int) void
    private static void method_11(ServerSettings var0) {
        if (null != var0) {
            class_9.method_29(false, getLocaleString("loading_app", 0));
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

            currentServerSettings = var0;
            class_9.method_25(50, (byte)-84);
            class_9.method_27(-73);
            if (field_39) {
                class_5.method_4(21870 - 21615);
            }

            try {
                String var2 = getConfigValue("codebase");
                byte[] var3 = method_13(var2, getConfigValue("loader_jar"));
                class_9.method_25(75, (byte)-115);
                class_9.method_27(-76);
                class_8 var4 = new class_8(var3);
                field_33 = (Applet)var4.loadClass("loader").newInstance();
                if (isDebug) {
                    System.out.println("loader_jar : " + var3.length);
                }

                class_9.method_28(true);
            } catch (Exception var5) {
                if (isDebug) {
                    var5.printStackTrace();
                }

                class_9.method_28(true);
                class_19.method_40((byte)47, getLocaleString("err_target_applet", 0));
            }

            field_37.add(field_33);
            field_38 = new class_0(getLocaleString("tandc", 0));
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
            int var2 = null == field_34 ? 0 : Integer.parseInt(getConfigValue("advert_height"));
            int var3 = !field_38.isVisible() ? 0 : 40;
            int var4 = Integer.parseInt(getConfigValue("applet_minwidth"));
            int var5 = Integer.parseInt(getConfigValue("applet_minheight"));
            int var6 = Integer.parseInt(getConfigValue("applet_maxwidth"));
            int var7 = Integer.parseInt(getConfigValue("applet_maxheight"));
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

            int var15 = Math.max(var4, var10);

            field_31.setBounds((-var13 + var15) / 2, 0, var13, var1);

            if (field_34 != null) {
                field_34.setBounds((-var13 + var15) / 2, var1, var13, var2);
            }

            field_33.setBounds((var15 + -var13) / 2, var2 + var1, var13, var14);
            field_38.setBounds((var15 - var13) / 2, var14 + var2 + var1, var13, var3);
            if (null != field_34 && browsercontrol.iscreated()) {
                browsercontrol.resize(field_34.getSize().width, field_34.getSize().height);
            }

            frame.repaint();
        }
    }

    // $FF: renamed from: a (java.lang.String, int, java.lang.String) byte[]
    private static byte[] method_13(String var0, String var2) {
        int var7 = AppletViewerPreferences.field_91;

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
                // $FF: renamed from: t float
                float field_48 = 58988.0F;
                class_9.method_25((int)(100.0F * (field_51 / field_48)), (byte)-90);
                if (var7 != 0) {
                    break;
                }
            }

            var5.close();
        } catch (Exception var8) {
            if (isDebug) {
                var8.printStackTrace();
            }

            class_19.method_40((byte)47, getLocaleString("err_downloading", 0) + ": " + var2);
        }

        byte[] var9 = new byte[var4];
        System.arraycopy(var3, 0, var9, 0, var4);
        return var9;
    }

    // $FF: renamed from: a (int) void
    public static void method_14(int var0) {
        if (var0 != 4443) {
            languageIDs = (int[])null;
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
    static String getParameter(String name) {
        if (currentServerSettings != null) {
            String var2 = currentServerSettings.parameters.get(name);
            if (var2 != null) {
                return var2;
            }
        }

        System.out.println("Using root param for: " + name);
        return params.get(name);
    }

    // $FF: renamed from: b (int) void
    static void getAvailableServerList() {
        int var9 = AppletViewerPreferences.field_91;
        String serverListURL = getConfigValue("serverlist");
        ServerSettings[] enabledServers = serverSettingsList;
        int enabledServerCount = serverSettingsList.length;

        /*
         * If the server includes a server list param we will use it to determine which servers are available
         * to show in the list
         */
        if (serverListURL != null) {
            enabledServers = new ServerSettings[serverSettingsList.length];
            enabledServerCount = 0;

            try {
                BufferedReader serverList = fetchJavConfig(serverListURL, null);

                label67:
                do {
                    // [SeverName, (Bool)isEnabled]
                    String[] serverListPair;
                    do {
                        String line;
                        do {
                            line = serverList.readLine();

                            if (line == null) {
                                break label67;
                            }

                            line = line.trim();
                        } while(line.startsWith("//"));

                        serverListPair = line.split(",");
                    } while(serverListPair.length < 2);

                    if (serverListPair[1].trim().equalsIgnoreCase("true")) {
                        String serverName = serverListPair[0].trim();
                        int index = 0;

                        while(serverSettingsList.length > index) {
                            if (serverSettingsList[index].name.equals(serverName)) {
                                enabledServers[enabledServerCount++] = serverSettingsList[index];
                            }

                            ++index;
                        }
                    }
                } while(true);

                serverList.close();
            } catch (IOException var10) {
                enabledServerCount = serverSettingsList.length;
                enabledServers = serverSettingsList;
            }
        }

        String[] serverNameList = new String[enabledServerCount];
        int currentIndex = 0;

        while(currentIndex < enabledServerCount) {
            serverNameList[currentIndex] = enabledServers[currentIndex].configValues.get("servername");
            ++currentIndex;
        }

        field_29.method_35(true, serverNameList);
        currentIndex = field_29.method_36();
        if (currentIndex > 0) {
            method_11(enabledServers[currentIndex]);
        }

    }

    // $FF: renamed from: a (int, java.lang.String, java.lang.String, java.lang.String, int) java.io.File
    private static final File method_17(int var0, String var1, String var2, String var3, int var4) {
        int var16 = AppletViewerPreferences.field_91;
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

                            if (isDebug) {
                                System.out.println("Unable to open/write: " + var11);
                            }

                            try {
                                if (var12 != null) {
                                    var12.close();
                                    var12 = null;
                                }
                            } catch (Exception ignored) {
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

        if (!isDebug) {
            throw new RuntimeException();
        } else {
            throw new RuntimeException("Fatal - could not find ANY location for file: " + var1);
        }
    }

    // $FF: renamed from: a (java.lang.String, int) java.lang.String
    static String getLocaleString(String key, int var1) {
        if (null != currentServerSettings) {
            String var2 = currentServerSettings.localeStrings.get(key);
            if (var2 != null) {
                return var2;
            }

        }

        System.out.println("Using root locale string for: " + key);
        return var1 != 0 ? null : localeStrings.get(key);
    }

    // $FF: renamed from: b (byte, java.lang.String) java.lang.String
    static String getConfigValue(String name) {
        if (null != currentServerSettings) {
            String configValue = currentServerSettings.configValues.get(name);

            if (configValue != null) {
                return configValue;
            }
        }

        System.out.println("Using root config item for: " + name);
        return configurationItems.get(name);
    }

    public void componentResized(ComponentEvent var1) {
        method_12((byte)2);
    }

    // $FF: renamed from: a (byte, byte[], java.io.File) boolean
    private static void method_21(byte var0, byte[] var1, File var2) {
        try {
            FileOutputStream var4 = new FileOutputStream(var2);
            var4.write(var1, 0, var1.length);
            var4.close();
        } catch (IOException var5) {
            if (isDebug) {
                var5.printStackTrace();
            }

            class_19.method_40((byte)47, getLocaleString("err_save_file", 0));
        }
    }

    // $FF: renamed from: a (byte, int) boolean
    private static void readJavConfig(Language language) {
        int var14 = AppletViewerPreferences.field_91;
        params.clear();
        int langCount = 0;
        InitialLocaleStrings.initialize(language);
        configurationItems.clear();
        currentServerSettings = null;
        serverSettingsList = null;
        int severSettingsCount = 0;
        ServerSettings[] servers = new ServerSettings[50];

        int equalPos;
        try {
            BufferedReader configReader = fetchJavConfig(javConfigURL, javConfigFile);

            Hashtable<String, String> params = AppletViewer.params;
            Hashtable<String, String> configValues = configurationItems;
            Hashtable<String, String> localeStrings = AppletViewer.localeStrings;

            parseFile:
            do {
                String settingLine;
                do {
                    do {
                        settingLine = configReader.readLine();

                        if (settingLine == null) {
                            break parseFile;
                        }

                        settingLine = settingLine.trim();
                    } while(settingLine.startsWith("//"));
                } while(settingLine.startsWith("#") && var14 == 0);

                if (settingLine.startsWith("[")) {
                    String serverName = settingLine.substring(1, settingLine.lastIndexOf("]"));
                    ServerSettings settings = new ServerSettings(serverName);
                    if (currentServerSettings == null) {
                        currentServerSettings = settings;
                    }

                    if (severSettingsCount >= servers.length) {
                        ServerSettings[] resizedServers = new ServerSettings[10 + severSettingsCount];
                        System.arraycopy(servers, 0, resizedServers, 0, servers.length);
                        servers = resizedServers;
                    }

                    servers[severSettingsCount++] = settings;
                    params = settings.parameters;
                    configValues = settings.configValues;
                    localeStrings = settings.localeStrings;
                }

                String configKey;
                String configValue;
                if (!settingLine.startsWith("param=")) {
                    if (!settingLine.startsWith("msg=")) {
                        equalPos = settingLine.indexOf("=");
                        if (equalPos != -1) {
                            configKey = settingLine.substring(0, equalPos).trim().toLowerCase();
                            configValue = settingLine.substring(1 + equalPos).trim();
                            configValues.put(configKey, configValue);

                            if (isDebug) {
                                System.out.println("Ourconfig - variable=" + configKey + " value=" + configValue);
                            }
                        }

                        if (var14 == 0) {
                            continue;
                        }
                    }

                    settingLine = settingLine.substring(4);
                    equalPos = settingLine.indexOf("=");
                    if (~equalPos != 0) {
                        configKey = settingLine.substring(0, equalPos).trim().toLowerCase();
                        configValue = settingLine.substring(equalPos - -1).trim();
                        if (configKey.startsWith("lang")) {
                            try {
                                Integer.parseInt(configKey.substring(4));
                                ++langCount;
                            } catch (NumberFormatException ignored) {
                            }
                        }

                        localeStrings.put(configKey, configValue);

                        if (isDebug) {
                            System.out.println("Message - name=" + configKey + " text=" + configValue);
                        }
                    }

                    if (var14 == 0) {
                        continue;
                    }
                }

                settingLine = settingLine.substring(6);
                equalPos = settingLine.indexOf("=");
                if (equalPos != -1) {
                    configKey = settingLine.substring(0, equalPos).trim().toLowerCase();
                    configValue = settingLine.substring(1 + equalPos).trim();
                    params.put(configKey, configValue);
                    if (isDebug) {
                        System.out.println("Innerconfig - variable=" + configKey + " value=" + configValue);
                    }
                }
            } while(true);

            configReader.close();
        } catch (IOException e) {
            if (isDebug) {
                e.printStackTrace();
            }

            class_19.method_40((byte)47, getLocaleString("err_load_config", 0));
        } catch (Exception e) {
            if (isDebug) {
                e.printStackTrace();
            }

            class_19.method_40((byte)47, getLocaleString("err_decode_config", 0));
        }

        if (langCount > 0) {
            languageIDs = new int[langCount];
            localeStringList = new String[langCount];
            int i = 0;
            Enumeration<String> localeStringKeys = localeStrings.keys();

            label136:
            do {
                while(true) {
                    if (!localeStringKeys.hasMoreElements()) {
                        break label136;
                    }

                    String localeString = localeStringKeys.nextElement();
                    if (!localeString.startsWith("lang")) {
                        break;
                    }

                    int languageID;

                    try {
                        // Example of expected format of `localeString`: "lang0"
                        languageID = Integer.parseInt(localeString.substring(4));
                    } catch (NumberFormatException var16) {
                        continue;
                    }

                    int index = 0;

                    while(i >= index) {
                        /*
                         * Sort the arrays by language ID
                         *
                         * Given languageID == 0
                         * and
                         * languageIDs == [1,2,3,0] // [3] is uninitialized
                         *
                         * The resulting array should be: [0,1,2,3]
                         *
                         * and localeStringList should be modified to match
                         */
                        if (i == index || languageID < languageIDs[index]) {
                            equalPos = i;

                            while(equalPos > index) {
                                localeStringList[equalPos] = localeStringList[equalPos - 1];
                                languageIDs[equalPos] = languageIDs[equalPos - 1];

                                --equalPos;

                                if (var14 != 0) {
                                    break;
                                }
                            }

                            languageIDs[index] = languageID;
                            localeStringList[index] = getLocaleString(localeString, 0);
                            if (var14 == 0) {
                                break;
                            }
                        }

                        ++index;
                        if (var14 != 0) {
                            break;
                        }
                    }

                    ++i;
                    break;
                }
            } while(true);

            field_30 = new class_16(getLocaleString("language", 0));
            field_30.method_35(true, localeStringList);
            if (~severSettingsCount < -1) {
                serverSettingsList = new ServerSettings[severSettingsCount];
                System.arraycopy(servers, 0, serverSettingsList, 0, severSettingsCount);
                field_29 = new class_16(getLocaleString("switchserver", 0));
            }

            if (!AppletViewerPreferences.getPreference("Language").isPresent()) {
                method_23();
            }
        }

    }

    // $FF: renamed from: d (int) int
    static int method_23() {
        int var1 = field_30.method_36();
        if (0 <= var1) {
            AppletViewerPreferences.addPreference(Integer.toString(languageIDs[var1]), "Language");
            AppletViewerPreferences.writePreferencesToFile();
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
                } catch (Exception ignored) {
                }
            }

            try {
                browsercontrol.create(field_34, getConfigValue("adverturl"));
                browsercontrol.resize(field_34.getSize().width, field_34.getSize().height);
            } catch (Throwable var2) {
                if (isDebug) {
                    var2.printStackTrace();
                }

                class_19.method_40((byte)47, getLocaleString("err_create_advertising", 0));
            }
        }
    }

    // $FF: renamed from: b (int, java.lang.String) java.lang.String
    private static String resolveConfigURLTemplate(String template) {
        String configURL = template;

        do {
            int templateStartPos = configURL.indexOf("$(");

            if (templateStartPos == -1) {
                break;
            }

            int variableSeparatorPos = configURL.indexOf(":", templateStartPos);
            int variableEndPos = configURL.indexOf(")", variableSeparatorPos);

            if (-1 < ~variableSeparatorPos || 0 > variableEndPos) {
                break;
            }

            String variableName = configURL.substring(2 + templateStartPos, variableSeparatorPos);
            String defaultValue = configURL.substring(1 + variableSeparatorPos, variableEndPos);
            Optional<String> preferenceValue = AppletViewerPreferences.getPreference(variableName);

            if (preferenceValue.isPresent()) {
                defaultValue = preferenceValue.get();
            }

            if (variableEndPos < -1 + configURL.length()) {
                configURL = configURL.substring(0, templateStartPos) + defaultValue + configURL.substring(variableEndPos - -1);

                continue;
            }

            configURL = configURL.substring(0, templateStartPos) + defaultValue;
        } while(true);

        return configURL;
    }

    public final void componentShown(ComponentEvent var1) {
    }
}
