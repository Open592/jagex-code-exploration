package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static285 {

  @OriginalMember(owner = "client!oi", name = "c", descriptor = "[Lclient!ta;")
  public static Class65[] aClass65Array3;

  @OriginalMember(owner = "client!oi", name = "a", descriptor = "(IIBI)Lclient!r;")
  public static Class16_Sub1_Sub5 method3513(
      @OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(3) int arg2) {
    @Pc(11)
    Class164 local11 = Static202.aClass164ArrayArrayArray5[arg2][arg1][arg0];
    if (local11 == null) {
      return null;
    }
    @Pc(17)
    Class16_Sub1_Sub5 local17 = null;
    @Pc(24)
    int local24 = -1;
    for (@Pc(27) Class7 local27 = local11.aClass7_3; local27 != null; local27 = local27.aClass7_1) {
      @Pc(31)
      Class16_Sub1 local31 = local27.aClass16_Sub1_1;
      if (local31 instanceof Class16_Sub1_Sub5) {
        @Pc(37)
        Class16_Sub1_Sub5 local37 = (Class16_Sub1_Sub5) local31;
        @Pc(47)
        int local47 = (local37.method4751() - 1) * 64 + 60;
        @Pc(54)
        int local54 = local37.anInt6893 - local47 >> 7;
        @Pc(62)
        int local62 = local37.anInt6892 - local47 >> 7;
        @Pc(69)
        int local69 = local47 + local37.anInt6893 >> 7;
        @Pc(76)
        int local76 = local37.anInt6892 + local47 >> 7;
        if (local54 <= arg1 && local62 <= arg0 && arg1 <= local69 && arg0 <= local76) {
          @Pc(110)
          int local110 = (local76 + 1 - arg0) * (-arg1 + 1 + local69);
          if (local110 > local24) {
            local17 = local37;
            local24 = local110;
          }
        }
      }
    }
    return local17;
  }
}
