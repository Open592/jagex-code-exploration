package com.jagex.client.js5;

import com.jagex.client.CRC32Checksum;
import com.jagex.client.Class235;
import com.jagex.client.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!rt")
public final class Js5Index {

  @OriginalMember(owner = "client!rt", name = "a", descriptor = "[I")
  public int[] anIntArray428;

  @OriginalMember(owner = "client!rt", name = "c", descriptor = "I")
  public int anInt6109;

  @OriginalMember(owner = "client!rt", name = "d", descriptor = "[I")
  public int[] anIntArray429;

  @OriginalMember(owner = "client!rt", name = "e", descriptor = "[I")
  public int[] anIntArray430;

  @OriginalMember(owner = "client!rt", name = "h", descriptor = "[[I")
  public int[][] anIntArrayArray46;

  @OriginalMember(owner = "client!rt", name = "i", descriptor = "[[I")
  public int[][] anIntArrayArray47;

  @OriginalMember(owner = "client!rt", name = "j", descriptor = "[I")
  public int[] anIntArray431;

  @OriginalMember(owner = "client!rt", name = "l", descriptor = "Lclient!ud;")
  public Class235 aClass235_1;

  @OriginalMember(owner = "client!rt", name = "m", descriptor = "I")
  public int anInt6112;

  @OriginalMember(owner = "client!rt", name = "n", descriptor = "I")
  public int version;

  @OriginalMember(owner = "client!rt", name = "p", descriptor = "[Lclient!ud;")
  public Class235[] aClass235Array1;

  @OriginalMember(owner = "client!rt", name = "q", descriptor = "[I")
  public int[] anIntArray432;

  @OriginalMember(owner = "client!rt", name = "w", descriptor = "[I")
  public int[] anIntArray433;

  @OriginalMember(owner = "client!rt", name = "k", descriptor = "I")
  public final int checksum;

  @OriginalMember(owner = "client!rt", name = "<init>", descriptor = "([BI)V")
  public Js5Index(byte[] buffer, int expectedChecksum) {
    this.checksum = CRC32Checksum.calculateChecksum(buffer.length, buffer);

    if (this.checksum != expectedChecksum) {
      throw new RuntimeException();
    }

    this.method4767(buffer);
  }

  @OriginalMember(owner = "client!rt", name = "a", descriptor = "([BI)V")
  private void method4767(@OriginalArg(0) byte[] arg0) {
    Packet packet = new Packet(Js5Compression.uncompress(arg0));
    int local16 = packet.g1();

    if (local16 != 5 && local16 != 6) {
      throw new RuntimeException();
    }

    if (local16 >= 6) {
      this.version = packet.g4();
    } else {
      this.version = 0;
    }

    int local45 = packet.g1();
    this.anInt6109 = packet.g2();
    int local52 = 0;
    this.anIntArray431 = new int[this.anInt6109];
    int local59 = -1;

    for (int i = 0; i < this.anInt6109; i++) {
      this.anIntArray431[i] = local52 += packet.g2();

      if (local59 < this.anIntArray431[i]) {
        local59 = this.anIntArray431[i];
      }
    }

    this.anInt6112 = local59 + 1;
    this.anIntArray429 = new int[this.anInt6112];
    this.anIntArray433 = new int[this.anInt6112];
    this.anIntArray430 = new int[this.anInt6112];
    this.anIntArray428 = new int[this.anInt6112];
    this.anIntArrayArray46 = new int[this.anInt6112][];

    if (local45 != 0) {
      this.anIntArray432 = new int[this.anInt6112];

      for (int i = 0; i < this.anInt6112; i++) {
        this.anIntArray432[i] = -1;
      }

      for (int i = 0; i < this.anInt6109; i++) {
        this.anIntArray432[this.anIntArray431[i]] = packet.g4();
      }

      this.aClass235_1 = new Class235(this.anIntArray432);
    }

    for (int i = 0; i < this.anInt6109; i++) {
      this.anIntArray430[this.anIntArray431[i]] = packet.g4();
    }

    for (int i = 0; i < this.anInt6109; i++) {
      this.anIntArray429[this.anIntArray431[i]] = packet.g4();
    }

    for (int i = 0; i < this.anInt6109; i++) {
      this.anIntArray428[this.anIntArray431[i]] = packet.g2();
    }

    int local249;
    int local256;
    int local258;
    int local283;

    for (int i = 0; i < this.anInt6109; i++) {
      local249 = this.anIntArray431[i];
      local52 = 0;
      local256 = this.anIntArray428[local249];
      local258 = -1;

      this.anIntArrayArray46[local249] = new int[local256];

      for (int j = 0; j < local256; j++) {
        local283 = this.anIntArrayArray46[local249][j] = local52 += packet.g2();

        if (local258 < local283) {
          local258 = local283;
        }
      }

      this.anIntArray433[local249] = local258 + 1;

      if (local256 == local258 + 1) {
        this.anIntArrayArray46[local249] = null;
      }
    }

    if (local45 == 0) {
      return;
    }

    this.aClass235Array1 = new Class235[local59 + 1];
    this.anIntArrayArray47 = new int[local59 + 1][];

    for (int i = 0; i < this.anInt6109; i++) {
      local256 = this.anIntArray431[i];
      local258 = this.anIntArray428[local256];

      this.anIntArrayArray47[local256] = new int[this.anIntArray433[local256]];

      for (int j = 0; j < this.anIntArray433[local256]; j++) {
        this.anIntArrayArray47[local256][j] = -1;
      }

      for (int j = 0; j < local258; j++) {
        int local391;

        if (this.anIntArrayArray46[local256] == null) {
          local391 = j;
        } else {
          local391 = this.anIntArrayArray46[local256][j];
        }

        this.anIntArrayArray47[local256][local391] = packet.g4();
      }

      this.aClass235Array1[local256] = new Class235(this.anIntArrayArray47[local256]);
    }
  }
}
