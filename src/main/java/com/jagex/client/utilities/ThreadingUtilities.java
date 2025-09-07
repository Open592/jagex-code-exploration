package com.jagex.client.utilities;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class ThreadingUtilities {
  @OriginalMember(owner = "client!vv", name = "a", descriptor = "(JI)V")
  public static void sleepFor(@OriginalArg(0) long milliseconds) {
    if (milliseconds <= 0L) {
      return;
    }
    if (milliseconds % 10L == 0L) {
      sleepUninterrupted(milliseconds - 1L);
      sleepUninterrupted(1L);
    } else {
      sleepUninterrupted(milliseconds);
    }
  }

  @OriginalMember(owner = "client!tp", name = "a", descriptor = "(IJ)V")
  private static void sleepUninterrupted(@OriginalArg(1) long milliseconds) {
    try {
      Thread.sleep(milliseconds);
    } catch (
        @Pc(11)
        InterruptedException ignored) {
    }
  }
}
