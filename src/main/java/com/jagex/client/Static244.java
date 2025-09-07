package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static244 {

  @OriginalMember(owner = "client!mh", name = "B", descriptor = "F")
  public static float aFloat102;

  @OriginalMember(owner = "client!mh", name = "C", descriptor = "I")
  public static int anInt3027 = 0;

  @OriginalMember(owner = "client!mh", name = "b", descriptor = "(Z)V")
  public static void method2568() {
    Static119.anIntArray169 = Static417.method5356(0.4F);
  }

  @OriginalMember(owner = "client!mh", name = "a", descriptor = "(ILjava/lang/String;I)V")
  public static void method2569(@OriginalArg(1) String arg0, @OriginalArg(2) int arg1) {
    @Pc(8)
    SecondaryNode_Sub1_Sub11 local8 = Static405.method5222(arg1, 2);
    local8.method2604();
    local8.aString32 = arg0;
  }

  @OriginalMember(owner = "client!mh", name = "a", descriptor = "(III)I")
  public static int method2570(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
    return arg0 == 1 || arg0 == 3
        ? Static15.anIntArray12[arg1 & 0x3]
        : Static386.anIntArray262[arg1 & 0x3];
  }
}
