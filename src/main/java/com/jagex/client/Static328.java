package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static328 {

  @OriginalMember(owner = "client!qk", name = "b", descriptor = "I")
  public static int anInt5676 = -60;

  @OriginalMember(owner = "client!qk", name = "a", descriptor = "(IBI)I")
  public static int method4425(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
    return arg1 == 4 || arg1 == 5 ? Static411.anIntArray514[arg0 & 0x3] : 256;
  }
}
