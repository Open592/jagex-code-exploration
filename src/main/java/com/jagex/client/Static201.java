package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static201 {

  @OriginalMember(owner = "client!kd", name = "t", descriptor = "[I")
  public static final int[] anIntArray410 =
      new int[] {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};

  @OriginalMember(owner = "client!kd", name = "a", descriptor = "(II)V")
  public static void method4602(@OriginalArg(1) int arg0) {
    if (-1 != arg0 && Static453.aBooleanArray25[arg0]) {
      Static356.aJs5_81.method2115(arg0);
      Static297.aClass247ArrayArray2[arg0] = null;
      Static30.aClass247ArrayArray1[arg0] = null;
      Static453.aBooleanArray25[arg0] = false;
    }
  }

  @OriginalMember(owner = "client!kd", name = "a", descriptor = "(Z)V")
  public static void method4605() {
    if (Static142.aClass199_6 == null) {
      return;
    }
    if (Static142.aClass199_6.status == 1) {
      Static142.aClass199_6 = null;
      return;
    }
    if (Static142.aClass199_6.status == 2) {
      Static197.method3110(Static248.aSignLink_6, 2, Static333.aString57);
      Static142.aClass199_6 = null;
      return;
    }
  }

  @OriginalMember(owner = "client!kd", name = "a", descriptor = "(I)V")
  public static void method4607() {
    @Pc(9)
    int local9 = (int) ((double) Static326.anInt5666 * 34.46D);
    local9 <<= 0x0;
    if (Static122.aClass19_16.method4286()) {
      local9 += 128;
    }
    Static122.aClass19_16.ia(50, local9);
  }
}
