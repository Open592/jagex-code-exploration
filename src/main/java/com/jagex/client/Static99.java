package com.jagex.client;

import com.jagex.client.locale.LocalizedString;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static99 {

  @OriginalMember(owner = "client!eu", name = "b", descriptor = "Lclient!gk;")
  public static final LocalizedString A_LOCALIZED_STRING___39 =
      new LocalizedString("wave2:", "welle2:", "ondulation2:", "onda2:");

  @OriginalMember(owner = "client!eu", name = "c", descriptor = "[I")
  public static final int[] anIntArray157 = new int[2048];

  @OriginalMember(owner = "client!eu", name = "e", descriptor = "Lclient!tn;")
  public static final SecondaryLinkedList A_SECONDARY_DOUBLY_LINKED_LIST___1 =
      new SecondaryLinkedList();

  @OriginalMember(owner = "client!eu", name = "a", descriptor = "(IIZI)I")
  public static int method1755(
      @OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(3) int arg2) {
    @Pc(3)
    int local3 = arg2 & 0x3;
    if (local3 == 0) {
      return arg0;
    } else if (local3 == 1) {
      return 1023 - arg1;
    } else if (local3 == 2) {
      return 1023 - arg0;
    } else {
      return arg1;
    }
  }

  @OriginalMember(owner = "client!eu", name = "a", descriptor = "(III)I")
  public static int method1757(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
    @Pc(50)
    int local50 =
        Static263.method3807(arg1 - 1, arg0 + -1)
            + Static263.method3807(arg1 - 1, arg0 + 1)
            + Static263.method3807(arg1 - -1, arg0 + -1)
            + Static263.method3807(arg1 + 1, arg0 + 1);
    @Pc(79)
    int local79 =
        Static263.method3807(arg1, arg0 - 1)
            + Static263.method3807(arg1, arg0 + 1)
            + Static263.method3807(arg1 + -1, arg0)
            + Static263.method3807(arg1 + 1, arg0);
    @Pc(84)
    int local84 = Static263.method3807(arg1, arg0);
    return local50 / 16 + local79 / 8 + local84 / 4;
  }
}
