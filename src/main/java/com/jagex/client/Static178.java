package com.jagex.client;

import com.jagex.client.locale.LocalizedString;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static178 {

  @OriginalMember(owner = "client!j", name = "q", descriptor = "[I")
  public static int[] anIntArray223;

  @OriginalMember(owner = "client!j", name = "r", descriptor = "Lclient!va;")
  public static Node_Sub42 aClass4_Sub42_2;

  @OriginalMember(owner = "client!j", name = "i", descriptor = "Lclient!bg;")
  public static final Class22 aClass22_152 = new Class22(48, 3);

  @OriginalMember(owner = "client!j", name = "p", descriptor = "Lclient!gk;")
  public static final LocalizedString A_LOCALIZED_STRING___72 =
      new LocalizedString("M", "M", "M", "M");

  @OriginalMember(owner = "client!j", name = "a", descriptor = "(II)Z")
  public static boolean method2845(@OriginalArg(0) int arg0) {
    return arg0 == 2 || arg0 == 3;
  }
}
