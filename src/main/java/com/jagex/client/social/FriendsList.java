package com.jagex.client.social;

import com.jagex.client.*;
import org.openrs2.deob.annotation.OriginalArg;

public final class FriendsList {
  public static final String[] aStringArray14 = new String[200];
  public static int size = 0;

  public static void method5070(@OriginalArg(0) String encodedUsername) {
    if (encodedUsername == null) {
      return;
    }

    if (encodedUsername.startsWith("*")) {
      encodedUsername = encodedUsername.substring(1);
    }

    String username = Static123.method4868(encodedUsername);
    if (username == null) {
      return;
    }

    for (int i = 0; i < size; i++) {
      String local35 = aStringArray14[i];
      if (local35.startsWith("*")) {
        local35 = local35.substring(1);
      }
      local35 = Static123.method4868(local35);
      if (local35 != null && local35.equals(username)) {
        size--;
        for (int j = i; j < size; j++) {
          aStringArray14[j] = aStringArray14[j + 1];
          Static57.aStringArray6[j] = Static57.aStringArray6[j + 1];
          Static71.anIntArray536[j] = Static71.anIntArray536[j + 1];
          Static433.aStringArray38[j] = Static433.aStringArray38[j + 1];
          Static280.anIntArray339[j] = Static280.anIntArray339[j + 1];
          Static424.aBooleanArray23[j] = Static424.aBooleanArray23[j + 1];
        }
        Static244.anInt3027 = Static325.anInt5640;
        Static429.method5476(Static132.aClass215_36);
        Static3.aClass4_Sub12_Sub1_5.p1(Static269.method3856(encodedUsername));
        Static3.aClass4_Sub12_Sub1_5.pjstr(encodedUsername);
        return;
      }
    }
  }
}
