package com.jagex.client;

import java.nio.ByteBuffer;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ce")
public final class ByteBufferBufferedBytes extends BufferedBytes {

  @OriginalMember(owner = "client!oc", name = "o", descriptor = "Z")
  private static boolean haveFailedToBuffer = false;

  @OriginalMember(owner = "client!ce", name = "h", descriptor = "Ljava/nio/ByteBuffer;")
  private ByteBuffer buffer;

  @OriginalMember(owner = "client!qj", name = "a", descriptor = "(BZ[B)Ljava/lang/Object;")
  public static Object attemptToBufferIfRequired(byte[] bytes) {
    if (bytes == null) {
      return null;
    }

    if (bytes.length > 136 && !haveFailedToBuffer) {
      try {
        BufferedBytes instance = new ByteBufferBufferedBytes();

        instance.init(bytes);

        return instance;
      } catch (Throwable ignored) {
        haveFailedToBuffer = true;
      }
    }

    return bytes;
  }

  @OriginalMember(owner = "client!ce", name = "a", descriptor = "(III)[B")
  @Override
  public byte[] getAt(int pos) {
    this.buffer.position(pos);

    byte[] sink = new byte[32768];

    this.buffer.get(sink, 0, 32768);

    return sink;
  }

  @OriginalMember(owner = "client!ce", name = "a", descriptor = "(B)[B")
  @Override
  public byte[] get() {
    byte[] sink = new byte[this.buffer.capacity()];

    this.buffer.position(0);
    this.buffer.get(sink);

    return sink;
  }

  @OriginalMember(owner = "client!ce", name = "a", descriptor = "(I[B)V")
  @Override
  public void init(@OriginalArg(1) byte[] arg0) {
    this.buffer = ByteBuffer.allocateDirect(arg0.length);
    this.buffer.position(0);
    this.buffer.put(arg0);
  }
}
