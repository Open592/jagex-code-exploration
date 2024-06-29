package com.open592.signlink;

import java.awt.DisplayMode;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.lang.reflect.Field;

// $FF: renamed from: g
public class class_8 {
    // $FF: renamed from: a java.awt.DisplayMode
    private DisplayMode field_40;
    // $FF: renamed from: b java.awt.GraphicsDevice
    private GraphicsDevice field_41;

    // $FF: renamed from: a (int) void
    public void method_23(int var1) {
        if (this.field_40 != null) {
            this.field_41.setDisplayMode(this.field_40);
            if (!this.field_41.getDisplayMode().equals(this.field_40)) {
                throw new RuntimeException("Did not return to correct resolution!");
            }

            this.field_40 = null;
        }

        this.method_25(1617321346, null);
        if (var1 >= -104) {
            this.method_24((byte) 21);
        }

    }

    // $FF: renamed from: a (byte) int[]
    public int[] method_24(byte var1) {
        DisplayMode[] var2 = this.field_41.getDisplayModes();
        int[] var3 = new int[var2.length << 778819202];
        if (var1 != -80) {
            this.method_24((byte) -91);
        }

        for (int var4 = 0; var4 < var2.length; ++var4) {
            var3[var4 << 1617321346] = var2[var4].getWidth();
            var3[1 + (var4 << 208102274)] = var2[var4].getHeight();
            var3[(var4 << 1565940610) + 2] = var2[var4].getBitDepth();
            var3[3 + (var4 << -990362622)] = var2[var4].getRefreshRate();
        }

        return var3;
    }

    // $FF: renamed from: a (int, java.awt.Frame) void
    private void method_25(int var1, Frame var2) {
        boolean var3 = false;

        Field var4;
        try {
            if (var1 != 1617321346) {
                this.method_23(126);
            }

            var4 = Class.forName("sun.awt.Win32GraphicsDevice").getDeclaredField("valid");
            var4.setAccessible(true);
            boolean var5 = (Boolean) var4.get(this.field_41);
            if (var5) {
                var3 = true;
                var4.set(this.field_41, Boolean.FALSE);
            }
        } catch (Throwable ignored) {
        }

        boolean var13 = false;

        try {
            var13 = true;
            this.field_41.setFullScreenWindow(var2);
            var13 = false;
        } finally {
            if (var13) {
                if (var3) {
                    try {
                        Field var7 = Class.forName("sun.awt.Win32GraphicsDevice").getDeclaredField("valid");
                        var7.set(this.field_41, Boolean.TRUE);
                    } catch (Throwable ignored) {
                    }
                }

            }
        }

        if (var3) {
            try {
                var4 = Class.forName("sun.awt.Win32GraphicsDevice").getDeclaredField("valid");
                var4.set(this.field_41, Boolean.TRUE);
            } catch (Throwable ignored) {
            }
        }
    }

    // $FF: renamed from: a (int, int, java.awt.Frame, int, int, int) void
    public void method_26(int var1, int var2, Frame var3, int var4, int var5, int var6) {
        int var7 = 124 % ((61 - var1) / 43);
        this.field_40 = this.field_41.getDisplayMode();
        if (this.field_40 == null) {
            throw new NullPointerException();
        } else {
            var3.setUndecorated(true);
            var3.enableInputMethods(false);
            this.method_25(1617321346, var3);
            if (-1 == ~var5) {
                int var8 = this.field_40.getRefreshRate();
                DisplayMode[] var9 = this.field_41.getDisplayModes();
                boolean var10 = false;

                for (DisplayMode displayMode : var9) {
                    if (displayMode.getWidth() == var2 && var6 == displayMode.getHeight() && var4 == displayMode.getBitDepth()) {
                        int var12 = displayMode.getRefreshRate();
                        if (!var10 || Math.abs(var12 + -var8) < Math.abs(-var8 + var5)) {
                            var10 = true;
                            var5 = var12;
                        }
                    }
                }

                if (!var10) {
                    var5 = var8;
                }
            }

            this.field_41.setDisplayMode(new DisplayMode(var2, var6, var4, var5));
        }
    }

    public class_8() throws Exception {
        GraphicsEnvironment var1 = GraphicsEnvironment.getLocalGraphicsEnvironment();
        this.field_41 = var1.getDefaultScreenDevice();
        if (!this.field_41.isFullScreenSupported()) {
            GraphicsDevice[] var2 = var1.getScreenDevices();
            GraphicsDevice[] var3 = var2;

            for (int var4 = 0; ~var4 > ~var3.length; ++var4) {
                GraphicsDevice var5 = var3[var4];
                if (null != var5 && var5.isFullScreenSupported()) {
                    this.field_41 = var5;
                    return;
                }
            }

            throw new Exception();
        }
    }
}
