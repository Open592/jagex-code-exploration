package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static326 {

  @OriginalMember(owner = "client!qi", name = "I", descriptor = "Z")
  public static boolean aBoolean509;

  @OriginalMember(owner = "client!qi", name = "L", descriptor = "I")
  public static int anInt5665;

  @OriginalMember(owner = "client!qi", name = "J", descriptor = "Lclient!sl;")
  public static final Class215 aClass215_75 = new Class215(11, 7);

  @OriginalMember(owner = "client!qi", name = "M", descriptor = "[I")
  public static final int[] anIntArray395 = new int[13];

  @OriginalMember(owner = "client!qi", name = "N", descriptor = "I")
  public static int anInt5666 = 104;

  @OriginalMember(owner = "client!qi", name = "a", descriptor = "(II)Z")
  public static boolean method4415(@OriginalArg(0) int arg0) {
    Static183.anInt3512 = arg0 + 1 & 0xFFFF;
    Static83.aBoolean159 = true;
    return true;
  }
}
