package com.jagex.client;

import com.jagex.client.locale.LocalizedString;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static243 {

  @OriginalMember(owner = "client!mg", name = "a", descriptor = "I")
  public static int anInt4530;

  @OriginalMember(owner = "client!mg", name = "j", descriptor = "Lclient!gk;")
  public static final LocalizedString A_LOCALIZED_STRING___96 =
      new LocalizedString("wave:", "welle:", "ondulation:", "onda:");

  @OriginalMember(owner = "client!mg", name = "k", descriptor = "Lclient!sl;")
  public static final Class215 aClass215_50 = new Class215(72, -1);

  @OriginalMember(owner = "client!mg", name = "a", descriptor = "(IC)Z")
  public static boolean method3559(@OriginalArg(1) char arg0) {
    return arg0 >= 'A' && arg0 <= 'Z' || arg0 >= 'a' && arg0 <= 'z';
  }

  @OriginalMember(owner = "client!mg", name = "a", descriptor = "(BLjava/lang/String;Z)V")
  public static void method3561(@OriginalArg(1) String arg0, @OriginalArg(2) boolean arg1) {
    Static391.archive19.anInt2476 = 1;
    @Pc(11)
    String local11 = arg0.toLowerCase();
    @Pc(14)
    short[] local14 = new short[16];
    @Pc(16)
    int local16 = 0;
    for (@Pc(18) int local18 = 0; local18 < Static444.aClass206_3.anInt5987; local18++) {
      @Pc(27)
      Class211 local27 = Static444.aClass206_3.method4703(local18);
      if ((!arg1 || local27.aBoolean564)
          && local27.anInt6175 == -1
          && local27.anInt6185 == -1
          && local27.anInt6151 == 0
          && local27.aString61.toLowerCase().indexOf(local11) != -1) {
        if (local16 >= 250) {
          Static191.aShortArray66 = null;
          Static406.anInt6702 = -1;
          return;
        }
        if (local16 >= local14.length) {
          @Pc(74)
          short[] local74 = new short[local14.length * 2];
          for (@Pc(76) int local76 = 0; local76 < local16; local76++) {
            local74[local76] = local14[local76];
          }
          local14 = local74;
        }
        local14[local16++] = (short) local18;
      }
    }
    Static47.anInt809 = 0;
    Static191.aShortArray66 = local14;
    Static406.anInt6702 = local16;
    @Pc(114)
    String[] local114 = new String[Static406.anInt6702];
    for (@Pc(116) int local116 = 0; local116 < Static406.anInt6702; local116++) {
      local114[local116] = Static444.aClass206_3.method4703(local14[local116]).aString61;
    }
    Static67.method1278(local114, Static191.aShortArray66);
    Static391.archive19.method2118();
    Static391.archive19.anInt2476 = 2;
  }

  @OriginalMember(owner = "client!mg", name = "a", descriptor = "(III)V")
  public static void method3562(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
    @Pc(8)
    SecondaryNode_Sub1_Sub11 local8 = Static405.method5222(arg0, 12);
    local8.method2604();
    local8.anInt3083 = arg1;
  }

  @OriginalMember(owner = "client!mg", name = "a", descriptor = "(II)I")
  public static int method3563(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
    return Static346.aByteArrayArray26 == null
        ? 0
        : (Static346.aByteArrayArray26[arg0][arg1] & 0xFF) << 3;
  }
}
