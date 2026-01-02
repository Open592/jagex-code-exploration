package com.jagex.client;

import com.jagex.client.js5.Js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static24 {

  @OriginalMember(owner = "client!ba", name = "A", descriptor = "Lclient!fs;")
  public static Js5 archive26;

  @OriginalMember(owner = "client!ba", name = "y", descriptor = "Ljava/lang/String;")
  public static String currentLoadingBoxText = "";

  @OriginalMember(owner = "client!ba", name = "b", descriptor = "(II)I")
  public static int method4082(@OriginalArg(1) int arg0) {
    return arg0 & 0xFF;
  }
}
