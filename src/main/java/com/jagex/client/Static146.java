package com.jagex.client;

import com.jagex.client.js5.Js5;
import com.jagex.client.locale.LocalizedString;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static146 {

  @OriginalMember(owner = "client!hh", name = "c", descriptor = "I")
  public static int anInt266;

  @OriginalMember(owner = "client!hh", name = "i", descriptor = "Lclient!fs;")
  public static Js5 aJs5_4;

  @OriginalMember(owner = "client!hh", name = "b", descriptor = "Lclient!bf;")
  public static final Class21 aClass21_2 = new Class21(12, 4);

  @OriginalMember(owner = "client!hh", name = "e", descriptor = "Lclient!gk;")
  public static final LocalizedString A_LOCALIZED_STRING___10 =
      new LocalizedString(" ", ": ", " ", " ");

  @OriginalMember(owner = "client!hh", name = "h", descriptor = "Lclient!cw;")
  public static final ISAACPacket aClass4_Sub12_Sub1_3 = new ISAACPacket(5000);

  @OriginalMember(owner = "client!hh", name = "a", descriptor = "(BI)V")
  public static void method208(@OriginalArg(1) int arg0) {
    if (Static112.method2034(arg0)) {
      Static122.method2212(-1, Static297.aClass247ArrayArray2[arg0]);
    }
  }

  @OriginalMember(owner = "client!hh", name = "a", descriptor = "(I)V")
  public static void method210() {
    Static406.aClass68_51.method1777();
  }

  @OriginalMember(owner = "client!hh", name = "a", descriptor = "([Ljava/lang/Object;[IZ)V")
  public static void method214(@OriginalArg(0) Object[] arg0, @OriginalArg(1) int[] arg1) {
    Static264.method3813(arg1, arg1.length - 1, 0, arg0);
  }
}
