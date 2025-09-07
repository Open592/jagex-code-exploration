package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class BufferPool {
  @OriginalMember(owner = "client!tm", name = "k", descriptor = "[[B")
  public static final byte[][] smallBuffers = new byte[1000][];

  @OriginalMember(owner = "client!fq", name = "z", descriptor = "[[B")
  public static final byte[][] mediumBuffers = new byte[250][];

  @OriginalMember(owner = "client!mp", name = "cb", descriptor = "[[B")
  public static final byte[][] largeBuffers = new byte[50][];

  @OriginalMember(owner = "client!wh", name = "wb", descriptor = "I")
  public static int smallBufferCount = 0;

  @OriginalMember(owner = "client!to", name = "a", descriptor = "I")
  public static int mediumBufferCount = 0;

  @OriginalMember(owner = "client!rt", name = "b", descriptor = "I")
  public static int largeBufferCount = 0;

  @OriginalMember(owner = "client!oa", name = "a", descriptor = "(II)[B")
  public static synchronized byte[] allocate(@OriginalArg(1) int size) {
    if (size == 100 && smallBufferCount > 0) {
      byte[] buffer = smallBuffers[--smallBufferCount];

      smallBuffers[smallBufferCount] = null;

      return buffer;
    } else if (size == 5000 && mediumBufferCount > 0) {
      byte[] buffer = mediumBuffers[--mediumBufferCount];

      mediumBuffers[mediumBufferCount] = null;

      return buffer;
    } else if (size == 30000 && largeBufferCount > 0) {
      byte[] buffer = largeBuffers[--largeBufferCount];

      largeBuffers[largeBufferCount] = null;

      return buffer;
    } else {
      return new byte[size];
    }
  }
}
