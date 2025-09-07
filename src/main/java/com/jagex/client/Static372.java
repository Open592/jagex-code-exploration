package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static372 {

  @OriginalMember(owner = "client!ss", name = "G", descriptor = "I")
  public static int anInt6373;

  @OriginalMember(owner = "client!ss", name = "I", descriptor = "Lclient!bg;")
  public static final Class22 aClass22_290 = new Class22(6, 11);

  @OriginalMember(owner = "client!ss", name = "K", descriptor = "[I")
  public static final int[] anIntArray484 = new int[] {16, 32, 64, 128};

  @OriginalMember(owner = "client!ss", name = "M", descriptor = "Lclient!sl;")
  public static final Class215 aClass215_84 = new Class215(57, 4);

  @OriginalMember(owner = "client!ss", name = "a", descriptor = "(IIII)V")
  public static void method4977(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
    Static79.aByteArrayArrayArray2 = new byte[4][arg1][arg0];
  }
}
