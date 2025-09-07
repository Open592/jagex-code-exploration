package com.jagex.signlink;

import java.awt.DisplayMode;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.lang.reflect.Field;

public class FullScreenManager {
  private DisplayMode windowedDisplayMode;

  private final GraphicsDevice fullScreenSupportedGraphicsDevice;

  public FullScreenManager() throws Exception {
    GraphicsEnvironment localGraphicsEnvironment =
        GraphicsEnvironment.getLocalGraphicsEnvironment();

    if (localGraphicsEnvironment.getDefaultScreenDevice().isFullScreenSupported()) {
      this.fullScreenSupportedGraphicsDevice = localGraphicsEnvironment.getDefaultScreenDevice();
    } else {
      for (GraphicsDevice device : localGraphicsEnvironment.getScreenDevices()) {
        if (device.isFullScreenSupported()) {
          this.fullScreenSupportedGraphicsDevice = device;

          return;
        }
      }

      throw new Exception();
    }
  }

  public void enterFullscreen(Frame window, int width, int height, int bitDepth, int refreshRate) {
    this.windowedDisplayMode = this.fullScreenSupportedGraphicsDevice.getDisplayMode();

    if (this.windowedDisplayMode == null) {
      throw new NullPointerException();
    } else {
      window.setUndecorated(true);
      window.enableInputMethods(false);

      this.setFullScreenWindow(window);

      if (refreshRate == 0) {
        int windowedRefreshRate = this.windowedDisplayMode.getRefreshRate();

        boolean foundBetterRefreshRate = false;

        for (DisplayMode displayMode : this.fullScreenSupportedGraphicsDevice.getDisplayModes()) {
          if (displayMode.getWidth() == width
              && height == displayMode.getHeight()
              && bitDepth == displayMode.getBitDepth()) {
            int candidateRefreshRate = displayMode.getRefreshRate();

            if (!foundBetterRefreshRate
                || Math.abs(candidateRefreshRate - windowedRefreshRate)
                    < Math.abs(windowedRefreshRate - refreshRate)) {
              foundBetterRefreshRate = true;
              refreshRate = candidateRefreshRate;
            }
          }
        }

        if (!foundBetterRefreshRate) {
          refreshRate = windowedRefreshRate;
        }
      }

      this.fullScreenSupportedGraphicsDevice.setDisplayMode(
          new DisplayMode(width, height, bitDepth, refreshRate));
    }
  }

  public void exitFullScreen() {
    if (this.windowedDisplayMode != null) {
      this.fullScreenSupportedGraphicsDevice.setDisplayMode(this.windowedDisplayMode);

      if (!this.fullScreenSupportedGraphicsDevice
          .getDisplayMode()
          .equals(this.windowedDisplayMode)) {
        throw new RuntimeException("Did not return to correct resolution!");
      }

      this.windowedDisplayMode = null;
    }

    this.setFullScreenWindow(null);
  }

  public int[] getDisplayModes() {
    DisplayMode[] displayModes = this.fullScreenSupportedGraphicsDevice.getDisplayModes();
    // [width, height, bitDepth, refreshRate]
    int[] result = new int[displayModes.length * 4];

    for (int i = 0; i < displayModes.length; i++) {
      int index = i * 4;

      result[index] = displayModes[i].getWidth();
      result[index + 1] = displayModes[i].getHeight();
      result[index + 2] = displayModes[i].getBitDepth();
      result[index + 3] = displayModes[i].getRefreshRate();
    }

    return result;
  }

  private void setFullScreenWindow(Frame window) {
    boolean shouldResetToValid = false;

    try {
      Field validField = Class.forName("sun.awt.Win32GraphicsDevice").getDeclaredField("valid");

      validField.setAccessible(true);

      boolean isValid = (boolean) validField.get(this.fullScreenSupportedGraphicsDevice);

      if (isValid) {
        shouldResetToValid = true;

        validField.set(this.fullScreenSupportedGraphicsDevice, Boolean.FALSE);
      }
    } catch (Throwable ignored) {

    }

    try {
      this.fullScreenSupportedGraphicsDevice.setFullScreenWindow(window);
    } finally {
      if (shouldResetToValid) {
        try {
          Field validField = Class.forName("sun.awt.Win32GraphicsDevice").getDeclaredField("valid");

          validField.set(this.fullScreenSupportedGraphicsDevice, Boolean.TRUE);
        } catch (Throwable ignored) {

        }
      }
    }
  }
}
