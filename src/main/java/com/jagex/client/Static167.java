package com.jagex.client;

import com.jagex.client.ds.LinkedList;
import com.jagex.client.preferences.ClientPreferences;
import com.jagex.client.social.Chat;
import com.jagex.client.social.FriendsList;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static167 {

  @OriginalMember(owner = "client!il", name = "e", descriptor = "Ljava/lang/String;")
  public static String aString35;

  @OriginalMember(owner = "client!il", name = "f", descriptor = "I")
  public static int anInt3231 = 0;

  @OriginalMember(owner = "client!il", name = "a", descriptor = "(I)V")
  public static void method2736() {
    Static74.archive2.anInt2476 = 1;
    Static6.client.method877();
    Static265.aBoolean457 = true;
    Static41.aBoolean74 = true;
    Static111.method2023();
    Static3.aClass4_Sub12_Sub1_5.pos = 0;
    Static316.aOpCode_257 = null;
    Static410.anInt6735 = 0;
    Protocol.currentOpcode = null;
    Static146.aClass4_Sub12_Sub1_3.pos = 0;
    Static95.anInt1910 = 0;
    Static35.aOpCode_42 = null;
    Static380.aOpCode_294 = null;
    Static188.anInt5353 = 0;
    for (@Pc(5586) int local5586 = 0; local5586 < Static306.aClass38Array1.length; local5586++) {
      Static306.aClass38Array1[local5586] = null;
    }
    for (@Pc(5608) int local5608 = 0; local5608 < 100; local5608++) {
      Chat.aStringArray2[local5608] = null;
    }
    Static341.aBoolean599 = false;
    Chat.anInt6639 = 0;
    Static147.method2462();
    Static273.anInt5119 = (int) (Math.random() * 80.0D) - 40;
    Static368.aFloat192 = (int) (Math.random() * 160.0D) - 80 & 0x3FFF;
    Static217.anInt4024 = (int) (Math.random() * 100.0D) - 50;
    Static175.anInt3399 = (int) (Math.random() * 120.0D) - 60;
    Static110.anInt2374 = (int) (Math.random() * 30.0D) - 20;
    Static323.anInt5620 = (int) (Math.random() * 110.0D) - 55;
    Static51.method836();
    for (@Pc(5675) int local5675 = 0; local5675 < 2048; local5675++) {
      Static267.aClass16_Sub1_Sub5_Sub1Array1[local5675] = null;
    }
    Static12.anInt163 = 0;
    for (@Pc(5689) int local5689 = 0; local5689 < 32768; local5689++) {
      Static143.aClass16_Sub1_Sub5_Sub2Array1[local5689] = null;
    }
    Static27.A_LINKED_LIST___2.clear();
    Static292.A_LINKED_LIST___36.clear();
    GameShell.aClass84_4.method2310();
    Static440.aHashMap_40.clear();
    Static115.aLinkedList_15 = new LinkedList();
    FriendsList.size = 0;
    Static376.anInt6277 = 0;
    Static257.aClass114_1.method2829();
    Static423.method5405();
    Static381.anInt6417 = 0;
    Static222.anInt4125 = 0;
    Static146.anInt266 = 0;
    Static67.anInt1408 = 0;
    Static365.anInt6311 = 0;
    Static111.anInt2379 = 0;
    Static419.anInt6924 = 0;
    Static188.anInt5355 = 0;
    Static238.anInt4509 = 0;
    Static286.anInt5198 = 0;
    for (@Pc(5748) int local5748 = 0; local5748 < Static165.anIntArray210.length; local5748++) {
      if (!Static22.aBooleanArray3[local5748]) {
        Static165.anIntArray210[local5748] = -1;
      }
    }
    if (Static334.anInt5766 != -1) {
      Static201.method4602(Static334.anInt5766);
    }
    for (@Pc(5778) Node_Sub43 local5778 = (Node_Sub43) Static325.aHashMap_29.head();
        local5778 != null;
        local5778 = (Node_Sub43) Static325.aHashMap_29.next()) {
      if (!local5778.hasNext()) {
        local5778 = (Node_Sub43) Static325.aHashMap_29.head();
        if (local5778 == null) {
          break;
        }
      }
      Static90.method1606(true, local5778, false);
    }
    Static334.anInt5766 = -1;
    Static325.aHashMap_29 = new HashMap(8);
    Static28.method529();
    Static304.aClass247_16 = null;
    for (@Pc(5818) int local5818 = 0; local5818 < 8; local5818++) {
      Static349.aStringArray29[local5818] = null;
      Static217.aBooleanArray13[local5818] = false;
      Static272.anIntArray333[local5818] = -1;
    }
    Static66.method4403();
    Static439.aBoolean676 = true;
    for (@Pc(5844) int local5844 = 0; local5844 < 100; local5844++) {
      Static416.aBooleanArray21[local5844] = true;
    }
    Static221.aString39 = null;
    Static290.anInt6410 = 0;
    GameShell.aClass15Array2 = null;
    for (@Pc(5862) int local5862 = 0; local5862 < 6; local5862++) {
      Static408.aClass28Array1[local5862] = new Class28();
    }
    for (@Pc(5878) int local5878 = 0; local5878 < 25; local5878++) {
      Static395.anIntArray502[local5878] = 0;
      Static198.anIntArray258[local5878] = 0;
      Static160.anIntArray207[local5878] = 0;
    }
    Static222.method3355();
    Static251.aBoolean429 = true;
    Static252.aShortArray151 =
        Static330.aShortArray196 =
            Static78.aShortArray46 = Static166.aShortArray97 = new short[256];
    aString35 = Static190.A_LOCALIZED_STRING___76.getString(ClientSettings.langID);
    Static183.anInt3512 = 0;
    ClientPreferences.preferences.aBoolean308 = false;
    ClientPreferences.preferences.aBoolean309 = false;
    Static103.method1816();
    Static1.method5();
    Static74.archive2.anInt2476 = 2;
    Static178.aClass4_Sub42_2 = null;
    Static419.aLong212 = 0L;
  }

  @OriginalMember(owner = "client!il", name = "a", descriptor = "(IIIIII)V")
  public static void method2738(
      @OriginalArg(0) int arg0,
      @OriginalArg(1) int arg1,
      @OriginalArg(2) int arg2,
      @OriginalArg(3) int arg3,
      @OriginalArg(4) int arg4) {
    @Pc(18)
    int local18 = arg3 - arg0;
    @Pc(23)
    int local23 = arg4 - arg1;
    if (local23 == 0) {
      if (local18 != 0) {
        Static287.method3980(arg3, arg0, arg1, arg2);
      }
    } else if (local18 == 0) {
      Static340.method4613(arg4, arg0, arg2, arg1);
    } else {
      if (local23 < 0) {
        local23 = -local23;
      }
      if (local18 < 0) {
        local18 = -local18;
      }
      @Pc(75)
      boolean local75 = local23 < local18;
      @Pc(79)
      int local79;
      @Pc(83)
      int local83;
      if (local75) {
        local79 = arg1;
        arg1 = arg0;
        local83 = arg4;
        arg4 = arg3;
        arg0 = local79;
        arg3 = local83;
      }
      if (arg4 < arg1) {
        local79 = arg1;
        arg1 = arg4;
        local83 = arg0;
        arg4 = local79;
        arg0 = arg3;
        arg3 = local83;
      }
      local79 = arg0;
      local83 = arg4 - arg1;
      @Pc(116)
      int local116 = arg3 - arg0;
      @Pc(121)
      int local121 = -(local83 >> 1);
      if (local116 < 0) {
        local116 = -local116;
      }
      @Pc(140)
      int local140 = arg3 > arg0 ? 1 : -1;
      @Pc(144)
      int local144;
      if (local75) {
        for (local144 = arg1; local144 <= arg4; local144++) {
          Static96.anIntArrayArray21[local144][local79] = arg2;
          local121 += local116;
          if (local121 > 0) {
            local79 += local140;
            local121 -= local83;
          }
        }
      } else {
        for (local144 = arg1; local144 <= arg4; local144++) {
          local121 += local116;
          Static96.anIntArrayArray21[local79][local144] = arg2;
          if (local121 > 0) {
            local79 += local140;
            local121 -= local83;
          }
        }
      }
    }
  }

  @OriginalMember(owner = "client!il", name = "a", descriptor = "(IZ)I")
  public static int method2739(@OriginalArg(0) int arg0) {
    return arg0 & 0xFF;
  }

  @OriginalMember(owner = "client!il", name = "a", descriptor = "(Z)V")
  public static void method2740() {
    Static64.method1241();
    Static420.method5385(ClientPreferences.preferences.aBoolean291);
    Static424.aClass49_2 = Static380.method5016(0, GameShell.signLink, 22050, GameShell.canvas);
    Static424.aClass49_2.method2070(Static363.aClass4_Sub15_Sub1_3);
    Static291.aClass49_1 = Static380.method5016(1, GameShell.signLink, 2048, GameShell.canvas);
    Static291.aClass49_1.method2070(Static360.aClass4_Sub15_Sub2_2);
  }
}
