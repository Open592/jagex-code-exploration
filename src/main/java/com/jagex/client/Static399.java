package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static399 {

  @OriginalMember(owner = "client!ud", name = "a", descriptor = "(IIB)Z")
  public static boolean method5172(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
    return (arg1 & 0x800) != 0;
  }
}
