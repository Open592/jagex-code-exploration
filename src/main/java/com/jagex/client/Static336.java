package com.jagex.client;

import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static336 {

  @OriginalMember(owner = "client!rb", name = "p", descriptor = "Z")
  public static boolean aBoolean596 = false;

  @OriginalMember(owner = "client!rb", name = "e", descriptor = "(B)V")
  public static void method5139() {
    if (!Static341.aBoolean599) {
      return;
    }
    @Pc(11)
    Class247 local11 = Static378.method3230(Static408.anInt6726, Static23.anInt350);
    if (local11 != null && local11.anObjectArray25 != null) {
      @Pc(20)
      Node_Sub34 local20 = new Node_Sub34();
      local20.anObjectArray4 = local11.anObjectArray25;
      local20.aClass247_15 = local11;
      Static271.method3894(local20);
    }
    Static157.anInt3147 = -1;
    Static161.anInt3179 = -1;
    Static341.aBoolean599 = false;
    if (local11 != null) {
      Static63.method1142(local11);
    }
  }
}
