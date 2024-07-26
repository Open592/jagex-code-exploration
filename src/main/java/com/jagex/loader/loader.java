package com.jagex.loader;

import com.jagex.signlink.SignLink;

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
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.security.MessageDigest;
import java.util.zip.Inflater;

public final class loader extends Applet implements Runnable {
    // $FF: renamed from: a boolean
    private boolean hasErrorOccured = false;
    // $FF: renamed from: b int
    private static int colourID = 0;
    // $FF: renamed from: c java.applet.Applet
    private Applet applet;
    // $FF: renamed from: d int
    private int appletHeight;
    // $FF: renamed from: e boolean
    private boolean isStarting = false;
    // $FF: renamed from: f boolean
    private boolean isDestroyed = false;
    // $FF: renamed from: g boolean
    private boolean isDestroying = false;
    // $FF: renamed from: h java.lang.String
    private static String crashURL;
    // $FF: renamed from: i java.lang.String
    private static String unsignedURL;
    // $FF: renamed from: j int
    private int appletWidth;
    // $FF: renamed from: k int
    private int langID = 0;

    // $FF: renamed from: a (b, byte, boolean) byte[]
    private byte[] fetchRemoteGameAsset(GameAsset gameAsset, byte var2, boolean useJaggrab) {
        try {
            Font loadingBoxFont = new Font("Helvetica", java.awt.Font.BOLD, 13);
            FontMetrics loadingBoxFontMetrics = this.getFontMetrics(loadingBoxFont);
            Color loadingBoxBackgroundColour = new Color(GameAssets.loadingBoxBackgroundColours[colourID]);
            Color loadingBoxForegroundColour = new Color(GameAssets.loadingBoxForegroundColours[colourID]);
            byte[] buffer = new byte[gameAsset.compressedSize];

            try {
                InputStream connectionStream;

                openConnection:
                {
                    if (!useJaggrab) {
                        connectionStream = (new URL(this.getCodeBase(), gameAsset.remoteFilename)).openStream();

                        break openConnection;
                    }

                    URL baseURL = this.getCodeBase();
                    Socket socket = new Socket(InetAddress.getByName(baseURL.getHost()), 443);
                    socket.setSoTimeout(10000);

                    OutputStream sink = socket.getOutputStream();
                    sink.write(17);
                    sink.write(("JAGGRAB " + baseURL.getFile() + gameAsset.remoteFilename + "\n\n").getBytes());

                    connectionStream = socket.getInputStream();
                }

                if (var2 >= -77) {
                    this.paint(null);
                }

                int previousPercentDownloaded = -1;
                int totalBytesRead = 0;

                while (totalBytesRead < buffer.length) {
                    int bytesToRead = buffer.length - totalBytesRead;

                    if (bytesToRead > 1000) {
                        bytesToRead = 1000;
                    }

                    int bytesRead = connectionStream.read(buffer, totalBytesRead, bytesToRead);

                    if (bytesRead < 0) {
                        throw new EOFException();
                    }

                    totalBytesRead += bytesRead;

                    int newPercentDownloaded = totalBytesRead * 100 / buffer.length;

                    if (newPercentDownloaded != previousPercentDownloaded) {
                        try {
                            updateLoaderBox:
                            {
                                Graphics graphics = this.getGraphics();

                                if (graphics == null) {
                                    this.repaint();

                                    break updateLoaderBox;
                                }

                                graphics.setColor(Color.black);
                                graphics.fillRect(0, 0, this.appletWidth, this.appletHeight);
                                graphics.setColor(loadingBoxBackgroundColour);
                                graphics.drawRect(-152 + this.appletWidth / 2, -18 + this.appletHeight / 2, 303, 33);
                                String loaderBoxContent = gameAsset.loadingStatusContent[this.langID] + " - " + newPercentDownloaded + "%";
                                graphics.setFont(loadingBoxFont);
                                graphics.setColor(loadingBoxForegroundColour);
                                graphics.drawString(loaderBoxContent, (this.appletWidth - loadingBoxFontMetrics.stringWidth(loaderBoxContent)) / 2, this.appletHeight / 2 + 4);
                                previousPercentDownloaded = newPercentDownloaded;
                            }
                        } catch (Exception ignored) {
                        }
                    }
                }

                connectionStream.close();
                if (gameAsset.uncompressedSize != gameAsset.compressedSize) {
                    byte[] uncompressedBuffer = new byte[gameAsset.uncompressedSize];
                    Inflater inflater = new Inflater(true);

                    inflater.setInput(buffer);
                    buffer = uncompressedBuffer;
                    inflater.inflate(uncompressedBuffer);
                }
            } catch (Exception e) {
                return null;
            }

            if (this.verifyGameAsset(gameAsset, false, buffer)) {
                return buffer;
            } else {
                return null;
            }
        } catch (RuntimeException var20) {
            throw LoaderRuntimeException.create(var20, "loader.D(" + (gameAsset != null ? "{...}" : "null") + ',' + var2 + ',' + useJaggrab + ')');
        }
    }

    // $FF: renamed from: a (boolean, java.io.File, byte[]) boolean
    private boolean saveFile(File file, byte[] bytes) {
        try {
            try {
                FileOutputStream sink = new FileOutputStream(file);
                sink.write(bytes, 0, bytes.length);
                sink.close();
                return true;
            } catch (IOException var5) {
                this.handleError("savefile");
                return false;
            }
        } catch (RuntimeException var6) {
            throw LoaderRuntimeException.create(var6, "loader.B(" + true + ',' + (file != null ? "{...}" : "null") + ',' + (bytes != null ? "{...}" : "null") + ')');
        }
    }

    // $FF: renamed from: a (b, boolean, int, byte[]) boolean
    private boolean verifyGameAsset(GameAsset gameAsset, boolean suppressSHA, byte[] fileBytes) {
        if (suppressSHA) {
            return true;
        }

        try {
            try {
                if (fileBytes == null) {
                    return false;
                }

                MessageDigest SHAMessageDigest = MessageDigest.getInstance("SHA");
                SHAMessageDigest.reset();
                SHAMessageDigest.update(fileBytes);
                byte[] hash = SHAMessageDigest.digest();

                for (int i = 0; i < 20; i++) {
                    if (gameAsset.sha1Bytes[i] != hash[i]) {
                        return false;
                    }
                }
            } catch (Exception var9) {
                this.handleError("sha");
                return false;
            }

            return true;
        } catch (RuntimeException e) {
            throw LoaderRuntimeException.create(e, "loader.F(" + (gameAsset != null ? "{...}" : "null") + ',' + suppressSHA + ',' + 3 + ',' + "{...}" + ')');
        }
    }

    // $FF: renamed from: a (java.io.File, boolean) byte[]
    private byte[] readFileToBytes(File file) {
        try {
            try {
                if (file.exists()) {
                    int fileSize = (int) file.length();
                    DataInputStream stream = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
                    byte[] buffer = new byte[fileSize];
                    stream.readFully(buffer, 0, fileSize);
                    stream.close();
                    return buffer;
                } else {
                    return null;
                }
            } catch (IOException e) {
                return null;
            }
        } catch (RuntimeException e) {
            throw LoaderRuntimeException.create(e, "loader.E(" + (file != null ? "{...}" : "null") + ',' + false + ')');
        }
    }

    public synchronized void start() {
        try {
            this.isStarting = true;
            this.isDestroying = false;

            if (this.applet != null) {
                this.applet.start();
            }

        } catch (RuntimeException e) {
            throw LoaderRuntimeException.create(e, "loader.start()");
        }
    }

    public void run() {
        try {
            try {
                unsignedURL = this.getParameter("unsignedurl");

                if (unsignedURL != null) {
                    try {
                        SecurityManager securityManager = System.getSecurityManager();
                        if (securityManager != null) {
                            securityManager.checkExec("echo");
                        }
                    } catch (SecurityException e) {
                        this.hasErrorOccured = true;

                        try {
                            this.getAppletContext().showDocument(new URL(unsignedURL), "_parent");
                        } catch (Exception ignored) {
                        }

                        return;
                    }
                }

                crashURL = this.getParameter("crashurl");

                int cacheSubDirID = 0;
                String cacheSubDirIDParameter = this.getParameter("cachesubdirid");

                if (cacheSubDirIDParameter != null) {
                    cacheSubDirID = Integer.parseInt(cacheSubDirIDParameter);
                    if (0 > cacheSubDirID || cacheSubDirID >= GameAssets.gameNames.length) {
                        cacheSubDirID = 0;
                    }
                }

                String colourIDParameter = this.getParameter("colourid");

                if (colourIDParameter != null) {
                    colourID = Integer.parseInt(colourIDParameter);

                    if (colourID < 0 || colourID >= GameAssets.loadingBoxBackgroundColours.length) {
                        colourID = 0;
                    }
                }

                this.appletWidth = this.getSize().width;
                this.appletHeight = this.getSize().height;
                int modewhat = 32;

                try {
                    int modewhatParameter = Integer.parseInt(this.getParameter("modewhat"));
                    modewhat += modewhatParameter;
                } catch (Exception ignored) {
                }

                try {
                    String langParameter = this.getParameter("lang");

                    if (langParameter != null) {
                        this.langID = Integer.parseInt(langParameter);
                    }
                } catch (Exception ignored) {
                }

                SignLink signLink;
                try {
                    signLink = new SignLink(this, modewhat, GameAssets.gameNames[cacheSubDirID], 30);
                } catch (Exception e) {
                    this.handleError("nocache");
                    return;
                }

                Unpack unpack = null;

                byte[] var7;
                try {
                    Class.forName("java.util.jar.Pack200");
                    var7 = this.method_21(signLink, GameAssets.gameCodePack200, (byte) -122, false);
                    if (var7 == null) {
                        return;
                    }

                    unpack = new class_3(var7);
                } catch (Throwable ignored) {
                }

                if (unpack == null) {
                    var7 = this.method_21(signLink, GameAssets.gameUnpacker, (byte) -123, false);
                    if (var7 == null) {
                        return;
                    }

                    Unpack var8 = new Unpack(var7);
                    class_9 var9 = new class_9(var8);
                    Class var10 = Class.forName("unpack");
                    var9.method_0(var10.getName(), -29048, var10);
                    var10 = var9.loadClass("unpackclass");
                    byte[] var11 = this.method_21(signLink, GameAssets.gameCodeJS5, (byte) -127, false);
                    if (null == var11) {
                        return;
                    }

                    unpack = (Unpack) var10.getConstructor(Class.forName("[B"), Boolean.TYPE).newInstance(var11, Boolean.TRUE);
                }

                class_9 var27;
                byte var28;
                String osName;
                String osArch;
                label283:
                {
                    var27 = new class_9(unpack);
                    var28 = -1;
                    osName = System.getProperty("os.name").toLowerCase();
                    osArch = System.getProperty("os.arch").toLowerCase();
                    if (osName.startsWith("win")) {
                        if (!osArch.startsWith("amd64") && !osArch.startsWith("x86_64")) {
                            var28 = 0;
                            break label283;
                        }

                        var28 = 1;
                        break label283;
                    }

                    if (!osName.startsWith("linux")) {
                        if (!osName.startsWith("mac")) {
                            break label283;
                        }

                        if (!osArch.startsWith("ppc")) {
                            if (!osArch.startsWith("x86_64")) {
                                var28 = 7;
                                break label283;
                            }

                            var28 = 6;
                            break label283;
                        }

                        var28 = 4;
                        break label283;
                    }

                    if (osArch.startsWith("amd64") || osArch.startsWith("x86_64")) {
                        var28 = 3;
                        break label283;
                    }

                    var28 = 2;
                }

                if (0 != ~var28) {
                    this.method_21(signLink, GameAssets.jaggl[var28], (byte) -128, null != this.getParameter("suppress_sha"));
                }

                if (GameAssets.jagMisc != null) {
                    var28 = -1;
                    osName = System.getProperty("os.name").toLowerCase();
                    osArch = System.getProperty("os.arch").toLowerCase();
                    if (osName.startsWith("win")) {
                        label284:
                        {
                            if (osArch.startsWith("amd64") || osArch.startsWith("x86_64")) {
                                var28 = 2;
                                break label284;
                            }

                            var28 = 0;
                        }
                    }

                    if (var28 != -1) {
                        this.method_21(signLink, GameAssets.jagMisc[var28], (byte) -124, null != this.getParameter("suppress_sha"));
                    }
                }

                if (null != GameAssets.sw3d) {
                    var28 = -1;
                    osName = System.getProperty("os.name").toLowerCase();
                    osArch = System.getProperty("os.arch").toLowerCase();
                    if (osName.startsWith("win") && !osArch.startsWith("amd64") && !osArch.startsWith("x86_64")) {
                        var28 = 0;
                    }

                    if (var28 != -1) {
                        this.method_21(signLink, GameAssets.sw3d[var28], (byte) -124, null != this.getParameter("suppress_sha"));
                    }
                }

                Class var32 = Class.forName("com.jagex.signlink.FileOnDisk");
                var27.method_0(var32.getName(), -29048, var32);
                Class var30 = Class.forName("com.jagex.signlink.SignLink");
                var27.method_0(var30.getName(), -29048, var30);
                var32 = Class.forName("com.jagex.signlink.Class199");
                var27.method_0(var32.getName(), -29048, var32);
                var32 = Class.forName("com.jagex.signlink.MonotonicClock");
                var27.method_0(var32.getName(), -29048, var32);
                var32 = Class.forName("com.jagex.signlink.Interface10");
                var27.method_0(var32.getName(), -29048, var32);
                var32 = var27.loadClass("com.jagex.client.client");
                synchronized (this) {
                    if (this.isDestroyed) {
                        return;
                    }

                    this.applet = (Applet) var32.newInstance();
                    Method method = var32.getMethod("providesignlink", var30);
                    method.invoke((Object) null, signLink);
                    this.applet.init();
                    if (this.isStarting) {
                        this.applet.start();
                    }

                    if (this.isDestroying) {
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

                this.handleError("crash");
            }

        } catch (RuntimeException var22) {
            throw LoaderRuntimeException.create(var22, "loader.run()");
        }
    }

    // $FF: renamed from: a (et, b, byte, boolean) byte[]
    private byte[] method_21(SignLink signLink, GameAsset gameAsset, byte var3, boolean suppressSHA) {
        try {
            if (var3 > -121) {
                return null;
            }

            File file;
            try {
                file = signLink.resolveCacheFilePath(gameAsset.localFilename);
            } catch (Exception e) {
                this.handleError("nocache");
                return null;
            }

            byte[] fileBytes = this.readFileToBytes(file);
            if (!this.verifyGameAsset(gameAsset, suppressSHA, fileBytes)) {
                fileBytes = this.fetchRemoteGameAsset(gameAsset, (byte) -83, false);

                if (fileBytes == null) {
                    fileBytes = this.fetchRemoteGameAsset(gameAsset, (byte) -98, true);
                }

                if (fileBytes == null) {
                    this.handleError("download");
                    return null;
                }

                if (!this.saveFile(file, fileBytes)) {
                    return null;
                }

                fileBytes = this.readFileToBytes(file);

                if (!this.verifyGameAsset(gameAsset, false, fileBytes)) {
                    this.handleError("mismatch");
                    return null;
                }
            }

            return fileBytes;
        } catch (RuntimeException var8) {
            throw LoaderRuntimeException.create(var8, "loader.A(" + (signLink != null ? "{...}" : "null") + ',' + (gameAsset != null ? "{...}" : "null") + ',' + var3 + ',' + suppressSHA + ')');
        }
    }

    public void update(Graphics graphics) {
        try {
            if (this.applet != null) {
                this.applet.update(graphics);
            }

        } catch (RuntimeException e) {
            throw LoaderRuntimeException.create(e, "loader.update(" + (graphics != null ? "{...}" : "null") + ')');
        }
    }

    public synchronized void init() {
        try {
            this.isDestroyed = false;
            Thread thread = new Thread(this);
            thread.start();
        } catch (RuntimeException var2) {
            throw LoaderRuntimeException.create(var2, "loader.init()");
        }
    }

    // $FF: renamed from: a (java.lang.String, int) void
    private void handleError(String errorID) {
        try {
            if (!this.hasErrorOccured) {
                this.hasErrorOccured = true;

                try {
                    if (crashURL != null) {
                        this.getAppletContext().showDocument(new URL(crashURL + "&s=" + errorID), "_parent");

                        return;
                    }

                    this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_loader_" + errorID + ".ws"), "_top");
                } catch (Exception ignored) {
                }
            }
        } catch (RuntimeException e) {
            throw LoaderRuntimeException.create(e, "loader.C(" + (errorID != null ? "{...}" : "null") + ',' + -9625 + ')');
        }
    }

    public synchronized void stop() {
        try {
            this.isStarting = false;
            this.isDestroying = true;
            if (null != this.applet) {
                this.applet.stop();
            }

        } catch (RuntimeException var2) {
            throw LoaderRuntimeException.create(var2, "loader.stop()");
        }
    }

    public void paint(Graphics var1) {
        try {
            if (null != this.applet) {
                this.applet.paint(var1);
            }

        } catch (RuntimeException var3) {
            throw LoaderRuntimeException.create(var3, "loader.paint(" + (var1 != null ? "{...}" : "null") + ')');
        }
    }

    public synchronized void destroy() {
        try {
            this.isDestroyed = true;
            this.isStarting = this.isDestroying = false;
            if (null != this.applet) {
                this.applet.destroy();
            }

            this.applet = null;
        } catch (RuntimeException var2) {
            throw LoaderRuntimeException.create(var2, "loader.destroy()");
        }
    }
}
