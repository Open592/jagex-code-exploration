package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static149 {

  @OriginalMember(owner = "client!hk", name = "Db", descriptor = "[I")
  public static final int[] anIntArray189 = new int[] {32, 39, 44, 47};

  @OriginalMember(owner = "client!hk", name = "Hb", descriptor = "I")
  public static int anInt3012 = 0;

  @OriginalMember(owner = "client!hk", name = "a", descriptor = "(Lclient!ya;B)V")
  public static void method2554(@OriginalArg(0) Class19 arg0) {
    if (Static299.aBoolean481) {
      Static305.method4129(arg0);
    } else {
      Static293.method4033(arg0);
    }
  }

  @OriginalMember(owner = "client!hk", name = "a", descriptor = "(Lclient!lh;I)V")
  public static void method2555(@OriginalArg(0) Class16_Sub1_Sub5_Sub1 arg0) {
    @Pc(17)
    Node_Sub8 local17 = (Node_Sub8) Static341.A_HASH_MAP___38.get((long) arg0.anInt6037);
    if (local17 == null) {
      Static126.method2264(
          arg0.anIntArray426[0], null, arg0, arg0.anIntArray427[0], 0, arg0.aByte82, null);
    } else {
      local17.method638();
    }
  }

  @OriginalMember(owner = "client!hk", name = "a", descriptor = "(IIII)V")
  public static void method2558(
      @OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
    @Pc(12)
    Class155 local12 = Static1.aClass155ArrayArray1[arg0][arg1];
    Static223.method3431(local12 == null ? Static47.aClass155_1 : local12, arg2);
  }
}
