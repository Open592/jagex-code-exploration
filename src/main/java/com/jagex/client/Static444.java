package com.jagex.client;

import com.jagex.client.locale.LocalizedString;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static444 {

  @OriginalMember(owner = "client!wj", name = "j", descriptor = "[[[J")
  public static long[][][] aLongArrayArrayArray2;

  @OriginalMember(owner = "client!wj", name = "p", descriptor = "F")
  public static float aFloat223;

  @OriginalMember(owner = "client!wj", name = "x", descriptor = "I")
  public static int anInt7297;

  @OriginalMember(owner = "client!wj", name = "y", descriptor = "Lclient!ro;")
  public static Class206 aClass206_3;

  @OriginalMember(owner = "client!wj", name = "i", descriptor = "Lclient!gk;")
  public static final LocalizedString A_LOCALIZED_STRING___150 =
      new LocalizedString(
          "Connection lost.", "Verbindung abgebrochen.", "Connexion perdue.", "Conexão perdida.");

  @OriginalMember(owner = "client!wj", name = "A", descriptor = "I")
  public static int anInt7298 = 1;

  @OriginalMember(owner = "client!wj", name = "a", descriptor = "(II)Z")
  public static boolean method5641(@OriginalArg(1) int arg0) {
    return arg0 == 48 || arg0 == 47 || arg0 == 1002 || arg0 == 9 || arg0 == 60;
  }
}
