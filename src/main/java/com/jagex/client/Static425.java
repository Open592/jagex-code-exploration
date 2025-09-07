package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static425 {

  @OriginalMember(owner = "client!vk", name = "F", descriptor = "Lclient!lq;")
  public static BufferedFile cacheMasterIndexFile;

  @OriginalMember(owner = "client!vk", name = "I", descriptor = "I")
  public static int anInt7000;

  @OriginalMember(owner = "client!vk", name = "a", descriptor = "(Lclient!rs;I)V")
  public static void method5429(@OriginalArg(0) Class16_Sub1_Sub5_Sub2 arg0) {
    for (@Pc(10) Node_Sub8 local10 = (Node_Sub8) Static143.A_LINKED_LIST___20.tail();
        local10 != null;
        local10 = (Node_Sub8) Static143.A_LINKED_LIST___20.previous()) {
      if (arg0 == local10.aClass16_Sub1_Sub5_Sub2_1) {
        if (local10.aClass4_Sub15_Sub3_2 != null) {
          Static360.aClass4_Sub15_Sub2_2.method2955(local10.aClass4_Sub15_Sub3_2);
          local10.aClass4_Sub15_Sub3_2 = null;
        }
        local10.popSelf();
        return;
      }
    }
  }
}
