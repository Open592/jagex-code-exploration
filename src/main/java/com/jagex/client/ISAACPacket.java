package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!cw")
public final class ISAACPacket extends Packet {

  @OriginalMember(owner = "client!cw", name = "Cb", descriptor = "Lclient!dp;")
  private IsaacRandom isaacRandom;

  @OriginalMember(owner = "client!cw", name = "Nb", descriptor = "I")
  private int bitPos;

  @OriginalMember(owner = "client!cw", name = "<init>", descriptor = "(I)V")
  public ISAACPacket(@OriginalArg(0) int size) {
    super(size);
  }

  public void readEncryptedBytes(byte[] bytes, int len) {
    for (int i = 0; i < len; i++) {
      bytes[i] = (byte) (super.data[super.pos++] - this.isaacRandom.next());
    }
  }

  @OriginalMember(owner = "client!cw", name = "m", descriptor = "(II)V")
  public void method1133(@OriginalArg(0) int arg0) {
    super.data[super.pos++] = (byte) (arg0 + this.isaacRandom.next());
  }

  @OriginalMember(owner = "client!cw", name = "n", descriptor = "(B)V")
  public void method1135() {
    super.pos = (this.bitPos + 7) / 8;
  }

  @OriginalMember(owner = "client!cw", name = "u", descriptor = "(I)V")
  public void method1136() {
    this.bitPos = super.pos * 8;
  }

  @OriginalMember(owner = "client!cw", name = "n", descriptor = "(II)I")
  public int method1137(@OriginalArg(1) int arg0) {
    return arg0 * 8 - this.bitPos;
  }

  @OriginalMember(owner = "client!cw", name = "b", descriptor = "([II)V")
  public void initializeIsaacRandom(@OriginalArg(0) int[] seed) {
    this.isaacRandom = new IsaacRandom(seed);
  }

  @OriginalMember(owner = "client!cw", name = "v", descriptor = "(I)I")
  public int readOpcode() {
    int local21 = super.data[super.pos++] - this.isaacRandom.next() & 0xFF;

    return local21 < 128
        ? local21
        : (super.data[super.pos++] - this.isaacRandom.next() & 0xFF) + (local21 - 128 << 8);
  }

  @OriginalMember(owner = "client!cw", name = "w", descriptor = "(I)Z")
  public boolean method1141() {
    int local23 = super.data[super.pos] - this.isaacRandom.peek() & 0xFF;

    return local23 >= 128;
  }

  @OriginalMember(owner = "client!cw", name = "o", descriptor = "(II)I")
  public int method1143(@OriginalArg(1) int arg0) {
    @Pc(10)
    int local10 = this.bitPos >> 3;
    @Pc(18)
    int local18 = 8 - (this.bitPos & 0x7);
    @Pc(20)
    int local20 = 0;

    this.bitPos += arg0;

    while (local18 < arg0) {
      local20 += (super.data[local10++] & Static20.anIntArray14[local18]) << arg0 - local18;
      arg0 -= local18;
      local18 = 8;
    }

    if (arg0 == local18) {
      local20 += super.data[local10] & Static20.anIntArray14[local18];
    } else {
      local20 += super.data[local10] >> local18 - arg0 & Static20.anIntArray14[arg0];
    }

    return local20;
  }
}
