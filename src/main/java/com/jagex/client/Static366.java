package com.jagex.client;

import com.jagex.client.js5.Js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static366 {

  @OriginalMember(owner = "client!sm", name = "d", descriptor = "Lclient!fs;")
  public static Js5 aJs5_83;

  @OriginalMember(owner = "client!sm", name = "c", descriptor = "Lclient!gd;")
  public static final Node_Sub20 aClass4_Sub20_1 = new Node_Sub20(0, 0);

  @OriginalMember(owner = "client!sm", name = "a", descriptor = "(ZBLjava/lang/Object;)[B")
  public static byte[] method4930(@OriginalArg(0) boolean arg0, @OriginalArg(2) Object arg1) {
    if (arg1 == null) {
      return null;
    } else if (arg1 instanceof byte[]) {
      @Pc(13)
      byte[] local13 = (byte[]) arg1;
      return arg0 ? Static249.method3624(local13) : local13;
    } else if (arg1 instanceof BufferedBytes) {
      @Pc(27)
      BufferedBytes local27 = (BufferedBytes) arg1;
      return local27.get();
    } else {
      throw new IllegalArgumentException();
    }
  }
}
