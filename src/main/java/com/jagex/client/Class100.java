package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!hu")
public final class Class100 {

  @OriginalMember(owner = "client!hu", name = "b", descriptor = "J")
  private long aLong110;

  @OriginalMember(owner = "client!hu", name = "c", descriptor = "Lclient!ac;")
  private SecondaryNode aClass4_Sub1_31;

  @OriginalMember(owner = "client!hu", name = "g", descriptor = "[Lclient!ac;")
  private final SecondaryNode[] aClass4_Sub1Array1;

  @OriginalMember(owner = "client!hu", name = "i", descriptor = "I")
  private final int anInt3143;

  @OriginalMember(owner = "client!hu", name = "<init>", descriptor = "(I)V")
  public Class100(@OriginalArg(0) int arg0) {
    this.aClass4_Sub1Array1 = new SecondaryNode[arg0];
    this.anInt3143 = arg0;
    for (@Pc(10) int local10 = 0; local10 < arg0; local10++) {
      @Pc(20)
      SecondaryNode local20 = this.aClass4_Sub1Array1[local10] = new SecondaryNode();
      local20.secondaryPrevious = local20;
      local20.secondaryNext = local20;
    }
  }

  @OriginalMember(owner = "client!hu", name = "a", descriptor = "(Z)Lclient!ac;")
  public SecondaryNode method2670() {
    if (this.aClass4_Sub1_31 == null) {
      return null;
    }
    @Pc(23)
    SecondaryNode local23 =
        this.aClass4_Sub1Array1[(int) ((long) (this.anInt3143 - 1) & this.aLong110)];
    while (this.aClass4_Sub1_31 != local23) {
      if (this.aClass4_Sub1_31.secondaryValue == this.aLong110) {
        @Pc(35)
        SecondaryNode local35 = this.aClass4_Sub1_31;
        this.aClass4_Sub1_31 = this.aClass4_Sub1_31.secondaryPrevious;
        return local35;
      }
      this.aClass4_Sub1_31 = this.aClass4_Sub1_31.secondaryPrevious;
    }
    this.aClass4_Sub1_31 = null;
    return null;
  }

  @OriginalMember(owner = "client!hu", name = "a", descriptor = "(JI)Lclient!ac;")
  public SecondaryNode method2671(@OriginalArg(0) long arg0) {
    this.aLong110 = arg0;
    @Pc(20)
    SecondaryNode local20 = this.aClass4_Sub1Array1[(int) (arg0 & (long) (this.anInt3143 - 1))];
    for (this.aClass4_Sub1_31 = local20.secondaryPrevious;
        this.aClass4_Sub1_31 != local20;
        this.aClass4_Sub1_31 = this.aClass4_Sub1_31.secondaryPrevious) {
      if (this.aClass4_Sub1_31.secondaryValue == arg0) {
        @Pc(39)
        SecondaryNode local39 = this.aClass4_Sub1_31;
        this.aClass4_Sub1_31 = this.aClass4_Sub1_31.secondaryPrevious;
        return local39;
      }
    }
    this.aClass4_Sub1_31 = null;
    return null;
  }

  @OriginalMember(owner = "client!hu", name = "a", descriptor = "(BLclient!ac;J)V")
  public void method2674(@OriginalArg(1) SecondaryNode arg0, @OriginalArg(2) long arg1) {
    if (arg0.secondaryNext != null) {
      arg0.secondaryPopSelf();
    }
    @Pc(21)
    SecondaryNode local21 = this.aClass4_Sub1Array1[(int) (arg1 & (long) (this.anInt3143 - 1))];
    arg0.secondaryPrevious = local21;
    arg0.secondaryNext = local21.secondaryNext;
    arg0.secondaryNext.secondaryPrevious = arg0;
    arg0.secondaryValue = arg1;
    arg0.secondaryPrevious.secondaryNext = arg0;
  }
}
