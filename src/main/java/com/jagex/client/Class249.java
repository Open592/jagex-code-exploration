package com.jagex.client;

import com.jagex.client.env.ModeGame;
import com.jagex.client.js5.Js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!v")
public final class Class249 {

  @OriginalMember(owner = "client!v", name = "h", descriptor = "Lclient!fa;")
  private final Class68 aClass68_52 = new Class68(64);

  @OriginalMember(owner = "client!v", name = "g", descriptor = "Lclient!fs;")
  private final Js5 aJs5_97;

  @OriginalMember(owner = "client!v", name = "<init>", descriptor = "(Lclient!jk;ILclient!fs;)V")
  public Class249(
      @OriginalArg(0) ModeGame arg0, @OriginalArg(1) int arg1, @OriginalArg(2) Js5 arg2) {
    this.aJs5_97 = arg2;
    this.aJs5_97.method2108(32);
  }

  @OriginalMember(owner = "client!v", name = "a", descriptor = "(BI)V")
  public void method5322() {
    @Pc(2)
    Class68 local2 = this.aClass68_52;
    synchronized (this.aClass68_52) {
      this.aClass68_52.method1788(5);
    }
  }

  @OriginalMember(owner = "client!v", name = "a", descriptor = "(I)V")
  public void method5324() {
    @Pc(7)
    Class68 local7 = this.aClass68_52;
    synchronized (this.aClass68_52) {
      this.aClass68_52.method1791();
    }
  }

  @OriginalMember(owner = "client!v", name = "a", descriptor = "(ZI)Lclient!mp;")
  public Class151 method5325(@OriginalArg(1) int arg0) {
    @Pc(6)
    Class68 local6 = this.aClass68_52;
    @Pc(16)
    Class151 local16;
    synchronized (this.aClass68_52) {
      local16 = (Class151) this.aClass68_52.method1787((long) arg0);
    }
    if (local16 != null) {
      return local16;
    }
    @Pc(41)
    byte[] local41 = this.aJs5_97.method2104(arg0, 32);
    local16 = new Class151();
    if (local41 != null) {
      local16.method3638(new Packet(local41));
    }
    @Pc(57)
    Class68 local57 = this.aClass68_52;
    synchronized (this.aClass68_52) {
      this.aClass68_52.method1779((long) arg0, local16);
      return local16;
    }
  }

  @OriginalMember(owner = "client!v", name = "c", descriptor = "(I)V")
  public void method5327() {
    @Pc(2)
    Class68 local2 = this.aClass68_52;
    synchronized (this.aClass68_52) {
      this.aClass68_52.clear();
    }
  }
}
