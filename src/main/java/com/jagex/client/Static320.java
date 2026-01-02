package com.jagex.client;

import com.jagex.client.locale.LocalizedString;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static320 {

  @OriginalMember(owner = "client!qb", name = "q", descriptor = "Lclient!gk;")
  public static final LocalizedString A_LOCALIZED_STRING___118 =
      new LocalizedString("level: ", "Stufe: ", "niveau ", "nível: ");

  @OriginalMember(owner = "client!qb", name = "B", descriptor = "I")
  public static int anInt5660 = -1;

  @OriginalMember(owner = "client!qb", name = "a", descriptor = "(I[FI)[F")
  public static float[] method4410(@OriginalArg(0) int arg0, @OriginalArg(1) float[] arg1) {
    @Pc(6)
    float[] local6 = new float[arg0];
    Static459.method3329(arg1, 0, local6, 0, arg0);
    return local6;
  }
}
