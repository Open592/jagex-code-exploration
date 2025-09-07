package com.jagex.client.display;

import com.jagex.client.utilities.ThreadingUtilities;
import com.jagex.signlink.Message;
import com.jagex.signlink.SignLink;
import java.awt.*;
import org.openrs2.deob.annotation.OriginalMember;

public final class FullScreenWindow {
  @OriginalMember(
      owner = "client!ag",
      name = "a",
      descriptor = "(IILclient!et;III)Ljava/awt/Frame;")
  public static Frame enterFullScreenMode(int width, SignLink signLink, int height, int bitDepth) {
    if (!signLink.isFullScreenModeSupported()) {
      return null;
    }

    GraphicsDeviceDisplayMode[] displayModes = getFullScreenDisplayModes(signLink);

    // NOTE: Was originally checking for `null` but if our signlink message returns
    // an error we don't return `null` we return an empty array.
    if (displayModes.length == 0) {
      return null;
    }

    boolean foundBitDepth = false;
    for (GraphicsDeviceDisplayMode displayMode : displayModes) {
      if (displayMode.width == width
          && displayMode.height == height
          && (!foundBitDepth || displayMode.bitDepth > bitDepth)) {
        foundBitDepth = true;
        bitDepth = displayMode.bitDepth;
      }
    }

    if (!foundBitDepth) {
      return null;
    }

    Message enterFullScreenModeMessage =
        signLink.emitEnterFullScreenModeMessage(height, bitDepth, width);

    while (enterFullScreenModeMessage.isInProgress()) {
      ThreadingUtilities.sleepFor(10L);
    }

    Frame frame = (Frame) enterFullScreenModeMessage.output;

    if (frame == null) {
      return null;
    } else if (!enterFullScreenModeMessage.isSuccess()) {
      exitFullScreenMode(signLink, frame);
      return null;
    } else {
      return frame;
    }
  }

  @OriginalMember(owner = "client!kg", name = "a", descriptor = "(Lclient!et;I)[Lclient!ic;")
  public static GraphicsDeviceDisplayMode[] getFullScreenDisplayModes(SignLink signLink) {
    if (!signLink.isFullScreenModeSupported()) {
      return new GraphicsDeviceDisplayMode[0];
    }

    Message getFullScreenDisplayModesMessage = signLink.emitGetFullScreenDisplayModesMessage();

    while (getFullScreenDisplayModesMessage.isInProgress()) {
      ThreadingUtilities.sleepFor(10L);
    }

    if (!getFullScreenDisplayModesMessage.isSuccess()) {
      return new GraphicsDeviceDisplayMode[0];
    }

    int[] output = (int[]) getFullScreenDisplayModesMessage.output;
    GraphicsDeviceDisplayMode[] displayModes = new GraphicsDeviceDisplayMode[output.length >> 2];

    for (int i = 0; i < displayModes.length; i++) {
      GraphicsDeviceDisplayMode displayMode = new GraphicsDeviceDisplayMode();
      displayModes[i] = displayMode;

      displayMode.width = output[i << 2];
      displayMode.height = output[(i << 2) + 1];
      displayMode.bitDepth = output[(i << 2) + 2];
      displayMode.refreshRate = output[(i << 2) + 3];
    }

    return displayModes;
  }

  @OriginalMember(owner = "client!wl", name = "a", descriptor = "(Lclient!et;BLjava/awt/Frame;)V")
  public static void exitFullScreenMode(SignLink signLink, Frame frame) {
    while (true) {
      Message exitFullScreenModeMessage = signLink.emitExitFullScreenModeMessage(frame);

      while (exitFullScreenModeMessage.isInProgress()) {
        ThreadingUtilities.sleepFor(10L);
      }

      if (exitFullScreenModeMessage.isSuccess()) {
        frame.setVisible(false);
        frame.dispose();

        return;
      }

      ThreadingUtilities.sleepFor(100L);
    }
  }
}
