package com.jagex.client;

import com.jagex.client.encoding.Base37;

public final class LoginManager {
  public static String username = "";
  public static String password = "";

  public static void performLogin(String arg0, int arg1, String arg2) {
    username = arg0;
    password = arg2;
    Static161.anInt3177 = arg1;

    if (username.equals("") || password.equals("")) {
      Static296.anInt5302 = 3;
    } else if (WorldManager.worldId == -1) {
      Static296.anInt5302 = -3;
      GameShell.anInt970 = 0;
      Static405.anInt6682 = 1;
      Static239.anInt4518 = 0;
      Packet local40 = new Packet(128);
      local40.p1(10);
      local40.p4((int) (Math.random() * 9.9999999E7D));
      local40.p8(Base37.encode(username));
      local40.p4((int) (Math.random() * 9.9999999E7D));
      local40.pjstr(password);
      local40.p4((int) (Math.random() * 9.9999999E7D));
      local40.rsaEncrypt(Static85.aBigInteger1, Static309.aBigInteger2);
      Static3.aClass4_Sub12_Sub1_5.pos = 0;
      Static3.aClass4_Sub12_Sub1_5.p1(Class60.aClass60_10.anInt1812);
      Static3.aClass4_Sub12_Sub1_5.p1(local40.pos + 2);
      Static3.aClass4_Sub12_Sub1_5.p2(592);
      Static3.aClass4_Sub12_Sub1_5.pArrayBuffer(local40.data, local40.pos);
    } else {
      Static445.method5617();
    }
  }
}
