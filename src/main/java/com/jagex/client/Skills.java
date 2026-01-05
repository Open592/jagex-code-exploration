package com.jagex.client;

public final class Skills {
  public static final int[] LEVEL_TO_XP_TABLE;
  public static final int[] MAX_LEVEL_FOR_SKILL =
      new int[] {
        99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99,
        99, 99
      };
  public static final int[] levels = new int[25];

  static {
    LEVEL_TO_XP_TABLE = new int[99];

    int experience = 0;

    for (int i = 0; i < 99; i++) {
      int level = i + 1;
      int delta = (int) ((double) level + Math.pow(2.0D, (double) level / 7.0D) * 300.0D);
      experience += delta;
      LEVEL_TO_XP_TABLE[i] = experience / 4;
    }
  }
}
