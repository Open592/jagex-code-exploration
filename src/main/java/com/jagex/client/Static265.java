package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static265 {

  @OriginalMember(owner = "client!nj", name = "b", descriptor = "Z")
  public static boolean aBoolean457;

  @OriginalMember(owner = "client!nj", name = "o", descriptor = "[Ljava/lang/String;")
  public static String[] aStringArray20;

  @OriginalMember(owner = "client!nj", name = "q", descriptor = "Lclient!tb;")
  public static Class99 aClass99_5;

  @OriginalMember(owner = "client!nj", name = "m", descriptor = "Lclient!sl;")
  public static final Class215 aClass215_60 = new Class215(47, 3);

  @OriginalMember(owner = "client!nj", name = "p", descriptor = "Lclient!bg;")
  public static final Class22 aClass22_223 = new Class22(86, 8);

  @OriginalMember(owner = "client!nj", name = "a", descriptor = "(B)V")
  public static void method3816() {
    for (@Pc(7) int local7 = 0; local7 < Static1.aClass155ArrayArray1.length; local7++) {
      for (@Pc(11) int local11 = 0;
          local11 < Static1.aClass155ArrayArray1[local7].length;
          local11++) {
        Static1.aClass155ArrayArray1[local7][local11] = Static47.aClass155_1;
      }
    }
  }

  @OriginalMember(owner = "client!nj", name = "a", descriptor = "(II)I")
  public static int method3818(@OriginalArg(0) int arg0) {
    @Pc(12)
    int local12 = arg0 & 0x3F;
    @Pc(18)
    int local18 = arg0 >> 6 & 0x3;
    if (local12 == 18) {
      if (local18 == 0) {
        return 1;
      }
      if (local18 == 1) {
        return 2;
      }
      if (local18 == 2) {
        return 4;
      }
      if (local18 == 3) {
        return 8;
      }
    } else if (local12 == 19 || local12 == 21) {
      if (local18 == 0) {
        return 16;
      }
      if (local18 == 1) {
        return 32;
      }
      if (local18 == 2) {
        return 64;
      }
      if (local18 == 3) {
        return 128;
      }
    }
    return 0;
  }
}
