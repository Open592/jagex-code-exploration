package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static8 {

  @OriginalMember(owner = "client!ag", name = "g", descriptor = "I")
  public static int anInt116;

  @OriginalMember(owner = "client!ag", name = "e", descriptor = "[I")
  public static final int[] anIntArray7 = new int[32];

  @OriginalMember(owner = "client!ag", name = "j", descriptor = "Lclient!bg;")
  public static final Class22 aClass22_11 = new Class22(82, 12);

  @OriginalMember(owner = "client!ag", name = "a", descriptor = "(III)Z")
  public static boolean method87(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
    return (arg0 & 0x800) != 0;
  }
}
