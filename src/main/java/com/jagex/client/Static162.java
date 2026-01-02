package com.jagex.client;

import com.jagex.signlink.SignLink;
import java.net.URL;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static162 {

  @OriginalMember(owner = "client!ie", name = "d", descriptor = "[[[I")
  public static int[][][] anIntArrayArrayArray13;

  @OriginalMember(owner = "client!ie", name = "a", descriptor = "J")
  public static long aLong210 = 0L;

  @OriginalMember(owner = "client!ie", name = "f", descriptor = "I")
  public static int anInt6744 = 0;

  @OriginalMember(owner = "client!ie", name = "a", descriptor = "(II)I")
  public static int method5277(@OriginalArg(0) int arg0) {
    @Pc(14)
    int local14 = (arg0 & 0x55555555) + ((arg0 & 0xAAAAAAAB) >>> 1);
    @Pc(24)
    int local24 = (local14 & 0x33333333) + (local14 >>> 2 & 0x73333333);
    @Pc(32)
    int local32 = local24 + (local24 >>> 4) & 0xF0F0F0F;
    @Pc(38)
    int local38 = local32 + (local32 >>> 8);
    @Pc(44)
    int local44 = local38 + (local38 >>> 16);
    return local44 & 0xFF;
  }

  @OriginalMember(owner = "client!ie", name = "a", descriptor = "(ZI)Z")
  public static boolean method5279(@OriginalArg(1) int arg0) {
    @Pc(7)
    Class78_Sub1 local7 = Static206.method3192(arg0);
    if (local7 == null) {
      return false;
    } else if (SignLink.anInt1987 == 3) {
      @Pc(39)
      String local39 = "";
      if (!ClientSettings.modewhere.isLive()) {
        local39 = ":" + (local7.anInt3881 + 7000);
      }
      @Pc(55)
      String local55 = "";
      if (ClientSettings.settings != null) {
        local55 = "/p=" + ClientSettings.settings;
      }
      @Pc(104)
      String local104 =
          "http://"
              + local7.aString38
              + local39
              + "/l="
              + ClientSettings.langID
              + "/a="
              + ClientSettings.affiliateID
              + local55
              + "/j"
              + (ClientSettings.hasJS ? "1" : "0")
              + ",o"
              + (ClientSettings.hasObjectTag ? "1" : "0")
              + ",a2";
      try {
        Static6.client.getAppletContext().showDocument(new URL(local104), "_self");
        return true;
      } catch (
          @Pc(119)
          Exception local119) {
        return false;
      }
    } else {
      WorldManager.worldId = local7.anInt3881;
      client.host = local7.aString38;
      if (!ClientSettings.modewhere.isLive()) {
        client.fallbackServerPort = WorldManager.worldId + 50000;
        client.primaryServerPort = WorldManager.worldId + 40000;
        client.port = client.primaryServerPort;
      }
      return true;
    }
  }
}
