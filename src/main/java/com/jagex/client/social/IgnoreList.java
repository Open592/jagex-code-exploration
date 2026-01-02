package com.jagex.client.social;

import com.jagex.client.*;
import com.jagex.client.locale.Messages;

public final class IgnoreList {
  public static final String[] aStringArray7 = new String[100];
  public static final String[] aStringArray11 = new String[100];
  public static final String[] aStringArray27 = new String[100];
  public static final String[] aStringArray26 = new String[100];

  public static int size = 0;

  public static boolean isPlayerIgnored(String username) {
    if (username == null) {
      return false;
    }

    for (int i = 0; i < size; i++) {
      if (username.equalsIgnoreCase(aStringArray7[i])) {
        return true;
      }

      if (username.equalsIgnoreCase(aStringArray11[i])) {
        return true;
      }
    }

    return false;
  }

  public static void addPlayer(boolean arg0, String encodedUsername) {
    if (encodedUsername == null) {
      return;
    }

    if (size >= 100) {
      Static415.method5323(Messages.yourIgnoreListIsFull.getString(ClientSettings.langID));
      return;
    }

    String local26 = Static123.method4868(encodedUsername);
    if (local26 == null) {
      return;
    }

    String local69;

    for (int i = 0; i < size; i++) {
      String local39 = Static123.method4868(aStringArray27[i]);

      if (local39 != null && local39.equals(local26)) {
        Static415.method5323(
            encodedUsername + Messages.userIsAlreadyOnIgnoreList.getString(ClientSettings.langID));
        return;
      }

      if (aStringArray26[i] != null) {
        local69 = Static123.method4868(aStringArray26[i]);
        if (local69 != null && local69.equals(local26)) {
          Static415.method5323(
              encodedUsername
                  + Messages.userIsAlreadyOnIgnoreList.getString(ClientSettings.langID));
          return;
        }
      }
    }

    for (int i = 0; i < FriendsList.size; i++) {
      local69 = Static123.method4868(FriendsList.aStringArray14[i]);

      if (local69 != null && local69.equals(local26)) {
        Static415.method5323(
            Messages.pleaseRemoveFromFriendsList1.getString(ClientSettings.langID)
                + encodedUsername
                + Messages.pleaseRemoveFromFriendsList2.getString(ClientSettings.langID));
        return;
      }

      if (Static57.aStringArray6[i] != null) {
        String local142 = Static123.method4868(Static57.aStringArray6[i]);
        if (local142 != null && local142.equals(local26)) {
          Static415.method5323(
              Messages.pleaseRemoveFromFriendsList1.getString(ClientSettings.langID)
                  + encodedUsername
                  + Messages.pleaseRemoveFromFriendsList2.getString(ClientSettings.langID));
          return;
        }
      }
    }

    if (Static123.method4868(Static1.aClass16_Sub1_Sub5_Sub1_1.aString44).equals(local26)) {
      Static415.method5323(Messages.cantAddSelfToIgnoreList.getString(ClientSettings.langID));
    } else {
      Static429.method5476(Static81.aClass215_17);
      Static3.aClass4_Sub12_Sub1_5.p1(Static269.method3856(encodedUsername) + 1);
      Static3.aClass4_Sub12_Sub1_5.pjstr(encodedUsername);
      Static3.aClass4_Sub12_Sub1_5.p1(arg0 ? 1 : 0);
    }
  }
}
