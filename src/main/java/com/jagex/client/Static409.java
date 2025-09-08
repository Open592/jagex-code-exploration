package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static409 {

  @OriginalMember(owner = "client!up", name = "b", descriptor = "Lclient!bg;")
  public static final Class22 aClass22_325 = new Class22(3, -1);

  @OriginalMember(owner = "client!up", name = "f", descriptor = "Lclient!gk;")
  public static final LocalizedString A_LOCALIZED_STRING___146 =
      new LocalizedString("red:", "rot:", "rouge:", "vermelho:");

  @OriginalMember(owner = "client!up", name = "g", descriptor = "S")
  public static short aShort100 = 32767;

  @OriginalMember(owner = "client!up", name = "a", descriptor = "(Lclient!uu;Lclient!ma;IIIIIIJ)V")
  public static void method5484(
      @OriginalArg(0) Class247 arg0,
      @OriginalArg(1) Class145 arg1,
      @OriginalArg(2) int arg2,
      @OriginalArg(3) int arg3,
      @OriginalArg(4) int arg4,
      @OriginalArg(6) int arg5,
      @OriginalArg(7) int arg6,
      @OriginalArg(8) long arg7) {
    @Pc(11)
    int local11 = arg6 * arg6 + arg2 * arg2;
    if ((long) local11 > arg7) {
      return;
    }
    @Pc(31)
    int local31 = Math.min(arg0.anInt6833 / 2, arg0.anInt6805 / 2);
    if (local31 * local31 >= local11) {
      Static442.method5585(arg3, Static455.aClass57Array11[arg4], arg0, arg1, arg6, arg2, arg5);
      return;
    }
    local31 -= 10;
    @Pc(47)
    int local47;
    if (Static111.anInt2386 == 4) {
      local47 = (int) Static368.aFloat192 & 0x3FFF;
    } else {
      local47 = Static175.anInt3399 + (int) Static368.aFloat192 & 0x3FFF;
    }
    @Pc(60)
    int local60 = Class50_Sub1.anIntArray225[local47];
    @Pc(64)
    int local64 = Class50_Sub1.anIntArray224[local47];
    if (Static111.anInt2386 != 4) {
      local64 = local64 * 256 / (Static110.anInt2374 + 256);
      local60 = local60 * 256 / (Static110.anInt2374 + 256);
    }
    @Pc(95)
    int local95 = arg2 * local64 + local60 * arg6 >> 15;
    @Pc(106)
    int local106 = arg6 * local64 - arg2 * local60 >> 15;
    @Pc(112)
    double local112 = Math.atan2((double) local95, (double) local106);
    @Pc(119)
    int local119 = (int) (Math.sin(local112) * (double) local31);
    @Pc(126)
    int local126 = (int) (Math.cos(local112) * (double) local31);
    Static309.aClass57Array10[arg4].method5541(
        (float) arg0.anInt6833 / 2.0F + (float) arg3 + (float) local119,
        (float) -local126 + (float) arg0.anInt6805 / 2.0F + (float) arg5,
        4096,
        (int) (-local112 / 6.283185307179586D * 65535.0D));
  }

  @OriginalMember(owner = "client!up", name = "a", descriptor = "(B)V")
  public static void method5485() {
    Static154.aClass124_2.method3149();
    Static234.aClass192_2.method4342();
    Static420.aClass109_2.method2756();
    Static267.aClass262_2.method5555();
    Static329.aClass240_1.method5226();
    Static444.aClass206_3.method4707();
    Static182.aClass55_1.method1396();
    Static352.aClass194_2.method4423();
    Static26.aClass26_1.method644();
    Static183.aClass223_1.method5002();
    Static222.aClass249_1.method5327();
    Static76.aClass265_2.method5587();
    Static348.aClass182_4.method4127();
    Static426.aClass208_1.method4721();
    Static153.aClass180_1.method4116();
    Static296.aClass217_1.method4932();
    Static238.aClass226_1.method5020();
    Static405.aClass204_1.method4672();
    Static118.aClass172_2.method3978();
    Static280.aClass72_1.method1984();
    Static357.method4846();
    Static441.method5571();
    Static48.method789();
    if (!ClientSettings.modewhere.isLive()) {
      for (@Pc(76) int local76 = 0; local76 < Static392.aByteArrayArray28.length; local76++) {
        Static392.aByteArrayArray28[local76] = null;
      }
      Static102.anInt2043 = 0;
    }
    Static146.method210();
    Static247.method3609();
    Static91.method985();
    Static174.method2817();
    Static451.method5011();
    Static271.aClass68_29.method1777();
    Static122.aClass19_16.method4311();
    Static48.aClass142_1.method3484();
    Static103.method1813();
    Static395.archive0.method2118();
    Static324.archive1.method2118();
    Static74.archive2.method2118();
    Static256.archive3.method2118();
    Static67.archive4.method2118();
    Static49.archive5.method2118();
    Static46.archive6.method2118();
    Static357.archive7.method2118();
    Static293.archive8.method2118();
    Static196.archive9.method2118();
    Static88.archive10.method2118();
    Static284.archive11.method2118();
    Static197.archive12.method2118();
    Static209.archive13.method2118();
    Static312.archive14.method2118();
    Static350.archive15.method2118();
    Static424.archive16.method2118();
    Static208.archive17.method2118();
    Static381.archive18.method2118();
    Static391.archive19.method2118();
    Static388.archive20.method2118();
    Static55.archive21.method2118();
    Static64.archive22.method2118();
    Static163.archive23.method2118();
    Static66.archive24.method2118();
    Static154.archive25.method2118();
    Static24.archive26.method2118();
    Static417.archive27.method2118();
    Static19.archive28.method2118();
    Static366.archive29.method2118();
    Static261.aClass68_27.method1777();
    Static200.aClass68_22.method1777();
    Static386.aClass68_23.method1777();
    Static105.aClass68_9.method1777();
  }

  @OriginalMember(owner = "client!up", name = "a", descriptor = "(Lclient!cw;II)Z")
  public static boolean method5490(@OriginalArg(0) ISAACPacket arg0, @OriginalArg(2) int arg1) {
    @Pc(13)
    int local13 = arg0.method1143(2);
    @Pc(33)
    int local33;
    @Pc(38)
    int local38;
    @Pc(106)
    int local106;
    @Pc(110)
    int local110;
    @Pc(116)
    int local116;
    if (local13 == 0) {
      if (arg0.method1143(1) != 0) {
        method5490(arg0, arg1);
      }
      local33 = arg0.method1143(6);
      local38 = arg0.method1143(6);
      @Pc(50)
      boolean local50 = arg0.method1143(1) == 1;
      if (local50) {
        Static388.anIntArray497[Static441.anInt7199++] = arg1;
      }
      if (Static267.aClass16_Sub1_Sub5_Sub1Array1[arg1] != null) {
        throw new RuntimeException("hr:lr");
      }
      @Pc(73)
      Class253 local73 = Static306.aClass253Array1[arg1];
      @Pc(81)
      Class16_Sub1_Sub5_Sub1 local81 =
          Static267.aClass16_Sub1_Sub5_Sub1Array1[arg1] = new Class16_Sub1_Sub5_Sub1();
      local81.anInt6037 = arg1;
      if (Static354.A_BYTE_BUFFER_ARRAY_1[arg1] != null) {
        local81.method3422(Static354.A_BYTE_BUFFER_ARRAY_1[arg1]);
      }
      local81.method4745(local73.anInt6947);
      local81.anInt6034 = local73.anInt6946;
      local106 = local73.anInt6949;
      local110 = local106 >> 28;
      local116 = local106 >> 14 & 0xFF;
      local81.aBoolean400 = local73.aBoolean648;
      @Pc(124)
      int local124 = local106 & 0xFF;
      local81.aByteArray84[0] = Static411.aByteArray95[arg1];
      local81.aByte82 = (byte) local110;
      local81.method3426(
          local38 + (local124 << 6) - Static86.anInt1771,
          -Static180.anInt3453 + ((local116 << 6) - -local33));
      local81.aBoolean401 = false;
      Static306.aClass253Array1[arg1] = null;
      return true;
    } else if (local13 == 1) {
      local33 = arg0.method1143(2);
      local38 = Static306.aClass253Array1[arg1].anInt6949;
      Static306.aClass253Array1[arg1].anInt6949 =
          (local38 & 0xFFFFFFF) + (((local38 >> 28) + local33 & 0x3) << 28);
      return false;
    } else {
      @Pc(216)
      int local216;
      @Pc(221)
      int local221;
      @Pc(229)
      int local229;
      if (local13 != 2) {
        local33 = arg0.method1143(18);
        local38 = local33 >> 16;
        local216 = local33 >> 8 & 0xFF;
        local221 = local33 & 0xFF;
        local229 = Static306.aClass253Array1[arg1].anInt6949;
        local106 = local38 + (local229 >> 28) & 0x3;
        local110 = (local229 >> 14) + local216 & 0xFF;
        local116 = local229 + local221 & 0xFF;
        Static306.aClass253Array1[arg1].anInt6949 = local116 + (local106 << 28) + (local110 << 14);
        return false;
      }
      local33 = arg0.method1143(5);
      local38 = local33 >> 3;
      local216 = local33 & 0x7;
      local221 = Static306.aClass253Array1[arg1].anInt6949;
      local229 = local38 + (local221 >> 28) & 0x3;
      local106 = local221 >> 14 & 0xFF;
      local110 = local221 & 0xFF;
      if (local216 == 0) {
        local106--;
        local110--;
      }
      if (local216 == 1) {
        local110--;
      }
      if (local216 == 2) {
        local110--;
        local106++;
      }
      if (local216 == 3) {
        local106--;
      }
      if (local216 == 4) {
        local106++;
      }
      if (local216 == 5) {
        local110++;
        local106--;
      }
      if (local216 == 6) {
        local110++;
      }
      if (local216 == 7) {
        local106++;
        local110++;
      }
      Static306.aClass253Array1[arg1].anInt6949 = local110 + (local229 << 28) + (local106 << 14);
      return false;
    }
  }

  @OriginalMember(owner = "client!up", name = "a", descriptor = "(III)V")
  public static void method5491(
      @OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
    @Pc(7)
    Class164 local7 = Static202.aClass164ArrayArrayArray5[arg0][arg1][arg2];
    if (local7 != null && local7.aClass16_Sub4_2 != null) {
      local7.aClass16_Sub4_2 = null;
    }
  }
}
