package com.jagex.client;

import com.jagex.client.js5.Js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static461 {

  @OriginalMember(owner = "client!nb", name = "a", descriptor = "(Lclient!fs;II)Lclient!nb;")
  public static Node_Sub30 method3724(
      @OriginalArg(0) Js5 arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
    @Pc(5)
    byte[] local5 = arg0.method2104(arg2, arg1);
    return local5 == null ? null : new Node_Sub30(new Packet(local5));
  }
}
