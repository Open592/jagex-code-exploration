package com.jagex.client;

import com.jagex.client.js5.Js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static165 {

  @OriginalMember(owner = "client!ij", name = "H", descriptor = "[I")
  public static int[] anIntArray209;

  @OriginalMember(owner = "client!ij", name = "I", descriptor = "[I")
  public static int[] anIntArray210;

  @OriginalMember(owner = "client!ij", name = "a", descriptor = "(Lclient!fs;I)V")
  public static void method2730(@OriginalArg(0) Js5 arg0) {
    Static306.aJs5_65 = arg0;
  }

  @OriginalMember(owner = "client!ij", name = "e", descriptor = "(B)V")
  public static void method2731() {
    if (Static95.anInt1910 > 0) {
      Static251.method3639();
    } else {
      Static169.aServerConnection_6 = Static125.aServerConnection_5;
      Static125.aServerConnection_5 = null;
      Static187.method2932(40);
    }
  }
}
