package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static426 {

  @OriginalMember(owner = "client!vl", name = "i", descriptor = "Lclient!rq;")
  public static Class208 aClass208_1;

  @OriginalMember(owner = "client!vl", name = "k", descriptor = "I")
  public static int anInt7011;

  @OriginalMember(owner = "client!vl", name = "o", descriptor = "I")
  public static int anInt7014;

  @OriginalMember(owner = "client!vl", name = "r", descriptor = "[B")
  public static final byte[] aByteArray102 = new byte[16384];

  @OriginalMember(owner = "client!vl", name = "a", descriptor = "(IBI)Z")
  public static boolean method5437(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
    return (arg1 & 0x800) != 0;
  }

  @OriginalMember(owner = "client!vl", name = "a", descriptor = "(II)V")
  public static void method5439(@OriginalArg(0) int arg0) {
    if (!Static112.method2034(arg0)) {
      return;
    }
    @Pc(14)
    Class247[] local14 = Static297.aClass247ArrayArray2[arg0];
    for (@Pc(16) int local16 = 0; local16 < local14.length; local16++) {
      @Pc(22)
      Class247 local22 = local14[local16];
      if (local22 != null) {
        local22.anInt6783 = 1;
        local22.anInt6829 = 0;
        local22.anInt6815 = 0;
      }
    }
  }

  @OriginalMember(owner = "client!vl", name = "c", descriptor = "(I)Z")
  public static boolean method5440() {
    return Static69.aBoolean292;
  }
}
