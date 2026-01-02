package com.jagex.client;

import com.jagex.client.locale.LocalizedString;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static214 {

  @OriginalMember(owner = "client!kq", name = "e", descriptor = "[[[Lclient!nt;")
  public static Class164[][][] aClass164ArrayArrayArray4;

  @OriginalMember(owner = "client!kq", name = "f", descriptor = "Lclient!gk;")
  public static final LocalizedString A_LOCALIZED_STRING___79 =
      new LocalizedString("K", "T", "K", "K");

  @OriginalMember(owner = "client!kq", name = "a", descriptor = "(I)V")
  public static void method3224() {
    for (@Pc(14) Node_Sub39 local14 = (Node_Sub39) Static206.A_LINKED_LIST___28.tail();
        local14 != null;
        local14 = (Node_Sub39) Static206.A_LINKED_LIST___28.previous()) {
      if (Static444.method5641(local14.anInt5699)) {
        Static176.method2841(local14);
      }
    }
    if (Static407.anInt6710 == 1) {
      Static234.aBoolean411 = false;
      Static302.method4103(
          Static310.anInt5424, Static112.anInt2392, Static173.anInt3370, Static172.anInt3367);
      return;
    }
    Static302.method4103(
        Static310.anInt5424, Static112.anInt2392, Static173.anInt3370, Static172.anInt3367);
    @Pc(57)
    int local57 =
        Static118.aClass89_5.method2340(
            Static391.A_LOCALIZED_STRING___133.getString(ClientSettings.langID));
    for (@Pc(62) Node_Sub39 local62 = (Node_Sub39) Static206.A_LINKED_LIST___28.tail();
        local62 != null;
        local62 = (Node_Sub39) Static206.A_LINKED_LIST___28.previous()) {
      @Pc(68)
      int local68 = Static210.method3197(local62);
      if (local57 < local68) {
        local57 = local68;
      }
    }
    Static173.anInt3370 = local57 + 8;
    Static112.anInt2392 = (Static299.aBoolean481 ? 26 : 22) + Static407.anInt6710 * 16;
  }
}
