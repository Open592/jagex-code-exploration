package com.jagex.client;

import com.jagex.client.env.ModeGame;
import com.jagex.client.js5.Js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!bp")
public final class Class26 {

  @OriginalMember(owner = "client!bp", name = "b", descriptor = "Lclient!fa;")
  private Class68 aClass68_3 = new Class68(64);

  @OriginalMember(owner = "client!bp", name = "d", descriptor = "Lclient!fs;")
  private final Js5 aJs5_6;

  @OriginalMember(owner = "client!bp", name = "<init>", descriptor = "(Lclient!jk;ILclient!fs;)V")
  public Class26(
      @OriginalArg(0) ModeGame arg0, @OriginalArg(1) int arg1, @OriginalArg(2) Js5 arg2) {
    this.aJs5_6 = arg2;
    if (this.aJs5_6 != null) {
      @Pc(20)
      int local20 = this.aJs5_6.method2100() - 1;
      this.aJs5_6.method2108(local20);
    }
  }

  @OriginalMember(owner = "client!bp", name = "a", descriptor = "(I)V")
  public void method644() {
    @Pc(6)
    Class68 local6 = this.aClass68_3;
    synchronized (this.aClass68_3) {
      this.aClass68_3.clear();
    }
  }

  @OriginalMember(owner = "client!bp", name = "a", descriptor = "(BI)V")
  public void method645() {
    @Pc(6)
    Class68 local6 = this.aClass68_3;
    synchronized (this.aClass68_3) {
      this.aClass68_3.method1788(5);
    }
  }

  @OriginalMember(owner = "client!bp", name = "b", descriptor = "(II)V")
  public void method646(@OriginalArg(0) int arg0) {
    @Pc(6)
    Class68 local6 = this.aClass68_3;
    synchronized (this.aClass68_3) {
      this.aClass68_3.clear();
      this.aClass68_3 = new Class68(arg0);
    }
  }

  @OriginalMember(owner = "client!bp", name = "c", descriptor = "(II)Lclient!ki;")
  public Class126 method647(@OriginalArg(0) int arg0) {
    @Pc(6)
    Class68 local6 = this.aClass68_3;
    @Pc(16)
    Class126 local16;
    synchronized (this.aClass68_3) {
      local16 = (Class126) this.aClass68_3.method1787((long) arg0);
    }
    if (local16 != null) {
      return local16;
    }
    @Pc(39)
    byte[] local39 = this.aJs5_6.method2104(Static269.method3851(arg0), Static212.method3206(arg0));
    local16 = new Class126();
    if (local39 != null) {
      local16.method3191(new Packet(local39));
    }
    @Pc(55)
    Class68 local55 = this.aClass68_3;
    synchronized (this.aClass68_3) {
      this.aClass68_3.method1779((long) arg0, local16);
      return local16;
    }
  }

  @OriginalMember(owner = "client!bp", name = "a", descriptor = "(B)V")
  public void method649() {
    @Pc(6)
    Class68 local6 = this.aClass68_3;
    synchronized (this.aClass68_3) {
      this.aClass68_3.method1791();
    }
  }
}
