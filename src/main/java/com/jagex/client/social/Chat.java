package com.jagex.client.social;

import com.jagex.client.*;

public final class Chat {
  public static final int[] anIntArray411 = new int[100];
  public static final int[] anIntArray267 = new int[100];
  public static final String[] aStringArray32 = new String[100];
  public static final String[] aStringArray9 = new String[100];
  public static final String[] aStringArray2 = new String[100];
  public static final String[] aStringArray15 = new String[100];
  public static final int[] anIntArray294 = new int[100];
  public static int anInt6639 = 0;
  public static int anInt5303 = 0;

  public static void add(
      int arg0, String arg1, String arg2, String arg3, int arg4, String arg5, int arg6) {
    for (int local7 = 99; local7 > 0; local7--) {
      anIntArray411[local7] = anIntArray411[local7 - 1];
      anIntArray267[local7] = anIntArray267[local7 - 1];
      aStringArray32[local7] = aStringArray32[local7 - 1];
      aStringArray9[local7] = aStringArray9[local7 - 1];
      aStringArray2[local7] = aStringArray2[local7 - 1];
      aStringArray15[local7] = aStringArray15[local7 - 1];
      anIntArray294[local7] = anIntArray294[local7 - 1];
    }
    anIntArray411[0] = arg6;
    aStringArray32[0] = arg5;
    anIntArray267[0] = arg4;
    aStringArray9[0] = arg1;
    aStringArray2[0] = arg2;
    anInt6639++;
    anInt5303 = Static325.anInt5640;
    aStringArray15[0] = arg3;
    anIntArray294[0] = arg0;
  }
}
