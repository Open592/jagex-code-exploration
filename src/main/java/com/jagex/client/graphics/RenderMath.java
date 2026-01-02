package com.jagex.client.graphics;

public final class RenderMath {
  public static final int ANGULAR_STEPS = 16384;

  public static final int[] SINE_TABLE = new int[ANGULAR_STEPS];
  public static final int[] COSINE_TABLE = new int[ANGULAR_STEPS];

  private static final double FIXED_POINT_SCALE = 32768.0;
  private static final double RADIANS_PER_STEP = (Math.PI * 2) / ANGULAR_STEPS;

  static {
    for (int step = 0; step < ANGULAR_STEPS; step++) {
      double radians = step * RADIANS_PER_STEP;

      SINE_TABLE[step] = (int) (Math.sin(radians) * FIXED_POINT_SCALE);
      COSINE_TABLE[step] = (int) (Math.cos(radians) * FIXED_POINT_SCALE);
    }
  }
}
