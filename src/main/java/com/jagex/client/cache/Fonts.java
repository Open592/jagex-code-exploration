package com.jagex.client.cache;

import com.jagex.client.js5.Js5;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public class Fonts {
  @OriginalMember(owner = "client!wj", name = "a", descriptor = "(BLclient!fs;Lclient!fs;)I")
  public static int getLoadedCount(Js5 archive13, Js5 archive8) {
    @Pc(5)
    int local5 = 0;
    if (archive8.method2125(Sprites.p11FullId)) {
      local5++;
    }
    if (archive8.method2125(Sprites.p12FullId)) {
      local5++;
    }
    if (archive8.method2125(Sprites.b12FullId)) {
      local5++;
    }
    if (archive13.method2125(Sprites.p11FullId)) {
      local5++;
    }
    if (archive13.method2125(Sprites.p12FullId)) {
      local5++;
    }
    if (archive13.method2125(Sprites.b12FullId)) {
      local5++;
    }
    return local5;
  }

  @OriginalMember(owner = "client!wv", name = "e", descriptor = "(I)I")
  public static int getTotalCount() {
    return 6;
  }
}
