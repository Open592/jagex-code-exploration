package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!eh")
public final class Class60 {
  @OriginalMember(owner = "client!hp", name = "Y", descriptor = "[Lclient!eh;")
  private static final Class60[] aClass60Array1 = new Class60[32];

  @OriginalMember(owner = "client!hp", name = "D", descriptor = "Lclient!eh;")
  public static final Class60 aClass60_1 = new Class60(14);

  @OriginalMember(owner = "client!hp", name = "N", descriptor = "Lclient!eh;")
  public static final Class60 aClass60_2 = new Class60(15);

  @OriginalMember(owner = "client!hp", name = "P", descriptor = "Lclient!eh;")
  public static final Class60 aClass60_3 = new Class60(16);

  @OriginalMember(owner = "client!hp", name = "Q", descriptor = "Lclient!eh;")
  public static final Class60 aClass60_4 = new Class60(17);

  @OriginalMember(owner = "client!hp", name = "R", descriptor = "Lclient!eh;")
  public static final Class60 aClass60_5 = new Class60(18);

  @OriginalMember(owner = "client!hp", name = "S", descriptor = "Lclient!eh;")
  public static final Class60 aClass60_6 = new Class60(20);

  @OriginalMember(owner = "client!hp", name = "T", descriptor = "Lclient!eh;")
  public static final Class60 aClass60_7 = new Class60(21);

  @OriginalMember(owner = "client!hp", name = "U", descriptor = "Lclient!eh;")
  public static final Class60 aClass60_8 = new Class60(22);

  @OriginalMember(owner = "client!hp", name = "V", descriptor = "Lclient!eh;")
  public static final Class60 aClass60_9 = new Class60(23);

  @OriginalMember(owner = "client!hp", name = "X", descriptor = "Lclient!eh;")
  public static final Class60 aClass60_10 = new Class60(24);

  @OriginalMember(owner = "client!tg", name = "b", descriptor = "(Z)[Lclient!eh;")
  public static Class60[] method5040() {
    return new Class60[] {
      aClass60_1,
      aClass60_2,
      aClass60_3,
      aClass60_4,
      aClass60_5,
      aClass60_6,
      aClass60_7,
      aClass60_8,
      aClass60_9,
      aClass60_10
    };
  }

  static {
    @Pc(65)
    Class60[] local65 = method5040();

    for (Class60 class60 : local65) {
      aClass60Array1[class60.anInt1812] = class60;
    }
  }

  @OriginalMember(owner = "client!eh", name = "a", descriptor = "I")
  public final int anInt1812;

  @OriginalMember(owner = "client!eh", name = "<init>", descriptor = "(II)V")
  public Class60(@OriginalArg(0) int arg0) {
    this.anInt1812 = arg0;
  }

  @OriginalMember(owner = "client!eh", name = "toString", descriptor = "()Ljava/lang/String;")
  @Override
  public String toString() {
    throw new IllegalStateException();
  }
}
