package com.jagex.client;

import com.jagex.client.locale.LocalizedString;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static218 {

  @OriginalMember(owner = "client!kv", name = "J", descriptor = "I")
  public static int anInt4042 = 0;

  @OriginalMember(owner = "client!kv", name = "K", descriptor = "I")
  public static int anInt4043 = 1;

  @OriginalMember(owner = "client!kv", name = "P", descriptor = "Lclient!gk;")
  public static final LocalizedString A_LOCALIZED_STRING =
      new LocalizedString(
          "Face here", "Hierhin drehen", "Regarder dans cette direction", "Virar para cá");

  @OriginalMember(owner = "client!kv", name = "a", descriptor = "(II[Lclient!uu;IIZ)V")
  public static void method3278(
      @OriginalArg(0) int arg0,
      @OriginalArg(1) int arg1,
      @OriginalArg(2) Class247[] arg2,
      @OriginalArg(4) int arg3,
      @OriginalArg(5) boolean arg4) {
    for (@Pc(8) int local8 = 0; local8 < arg2.length; local8++) {
      @Pc(14)
      Class247 local14 = arg2[local8];
      if (local14 != null && local14.anInt6850 == arg3) {
        Static43.method5658(arg4, arg0, local14, arg1);
        Static309.method4160(local14, arg0, arg1);
        if (local14.anInt6825 > local14.anInt6821 - local14.anInt6833) {
          local14.anInt6825 = local14.anInt6821 - local14.anInt6833;
        }
        if (local14.anInt6825 < 0) {
          local14.anInt6825 = 0;
        }
        if (local14.anInt6849 > local14.anInt6834 - local14.anInt6805) {
          local14.anInt6849 = local14.anInt6834 - local14.anInt6805;
        }
        if (local14.anInt6849 < 0) {
          local14.anInt6849 = 0;
        }
        if (local14.anInt6840 == 0) {
          Static374.method4998(local14, arg4);
        }
      }
    }
  }

  @OriginalMember(owner = "client!kv", name = "a", descriptor = "(I)I")
  public static int getParticles() {
    return Static216.particles;
  }

  @OriginalMember(owner = "client!kv", name = "a", descriptor = "(IC)Z")
  public static boolean method3280(@OriginalArg(1) char arg0) {
    return arg0 >= '0' && arg0 <= '9' || arg0 >= 'A' && arg0 <= 'Z' || arg0 >= 'a' && arg0 <= 'z';
  }

  @OriginalMember(owner = "client!kv", name = "a", descriptor = "(ZIZ)V")
  public static void method3281(@OriginalArg(0) boolean arg0, @OriginalArg(2) boolean arg1) {
    if (arg1) {
      Static50.anInt855--;
      if (Static50.anInt855 == 0) {
        Static72.anIntArray115 = null;
      }
    }
    if (arg0) {
      Static186.anInt3550--;
      if (Static186.anInt3550 == 0) {
        Static335.anIntArray423 = null;
      }
    }
  }
}
