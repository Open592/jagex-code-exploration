package com.jagex.client;

import com.jagex.client.js5.Js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static236 {

  @OriginalMember(owner = "client!m", name = "i", descriptor = "Lclient!fs;")
  public static Js5 aJs5_49;

  @OriginalMember(owner = "client!m", name = "j", descriptor = "I")
  public static int anInt4491 = 0;

  @OriginalMember(owner = "client!m", name = "a", descriptor = "(II)I")
  public static int method3528(@OriginalArg(1) int arg0) {
    return arg0 >>> 8;
  }
}
