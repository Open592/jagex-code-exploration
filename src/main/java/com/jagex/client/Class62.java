package com.jagex.client;

import com.jagex.client.js5.Js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ek")
public final class Class62 {

  @OriginalMember(owner = "client!ek", name = "g", descriptor = "Lclient!fa;")
  private final Class68 aClass68_8 = new Class68(64);

  @OriginalMember(owner = "client!ek", name = "e", descriptor = "Lclient!fs;")
  private final Js5 aJs5_25;

  @OriginalMember(owner = "client!ek", name = "d", descriptor = "Lclient!fs;")
  private final Js5 aJs5_24;

  @OriginalMember(owner = "client!ek", name = "<init>", descriptor = "(ILclient!fs;Lclient!fs;)V")
  public Class62(@OriginalArg(0) int arg0, @OriginalArg(1) Js5 arg1, @OriginalArg(2) Js5 arg2) {
    this.aJs5_25 = arg1;
    this.aJs5_24 = arg2;
    if (this.aJs5_25 != null) {
      this.aJs5_25.method2108(0);
    }
    if (this.aJs5_24 != null) {
      this.aJs5_24.method2108(0);
    }
  }

  @OriginalMember(owner = "client!ek", name = "a", descriptor = "(IB)Lclient!np;")
  public SecondaryNode_Sub1_Sub16 method1607(@OriginalArg(0) int arg0) {
    @Pc(19)
    SecondaryNode_Sub1_Sub16 local19 =
        (SecondaryNode_Sub1_Sub16) this.aClass68_8.method1787((long) arg0);
    if (local19 != null) {
      return local19;
    }
    @Pc(33)
    byte[] local33;
    if (arg0 < 32768) {
      local33 = this.aJs5_25.method2104(arg0, 0);
    } else {
      local33 = this.aJs5_24.method2104(arg0 & 0x7FFF, 0);
    }
    local19 = new SecondaryNode_Sub1_Sub16();
    if (local33 != null) {
      local19.method3873(new Packet(local33));
    }
    if (arg0 >= 32768) {
      local19.method3870();
    }
    this.aClass68_8.method1779((long) arg0, local19);
    return local19;
  }
}
