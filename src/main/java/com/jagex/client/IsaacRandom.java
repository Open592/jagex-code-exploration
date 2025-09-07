package com.jagex.client;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!dp")
public final class IsaacRandom {
  @OriginalMember(owner = "client!dp", name = "m", descriptor = "[I")
  private int[] randResult;

  @OriginalMember(owner = "client!dp", name = "l", descriptor = "I")
  private int valuesRemaining;

  @OriginalMember(owner = "client!dp", name = "j", descriptor = "[I")
  private int[] mm;

  @OriginalMember(owner = "client!dp", name = "c", descriptor = "I")
  private int aa;

  @OriginalMember(owner = "client!dp", name = "a", descriptor = "I")
  private int bb;

  @OriginalMember(owner = "client!dp", name = "k", descriptor = "I")
  private int cc;

  @OriginalMember(owner = "client!dp", name = "<init>", descriptor = "()V")
  private IsaacRandom() {}

  @OriginalMember(owner = "client!dp", name = "<init>", descriptor = "([I)V")
  public IsaacRandom(int[] seed) {
    this.randResult = new int[256];
    this.mm = new int[256];

    System.arraycopy(seed, 0, this.randResult, 0, seed.length);

    this.initRandom();
  }

  @OriginalMember(owner = "client!dp", name = "a", descriptor = "(B)V")
  private void initRandom() {
    int a7 = -1640531527;
    int a6 = -1640531527;
    int a5 = -1640531527;
    int a4 = -1640531527;
    int a3 = -1640531527;
    int a2 = -1640531527;
    int a1 = -1640531527;
    int a0 = -1640531527;

    int i;
    for (i = 0; i < 4; i++) {
      a0 ^= a1 << 11;
      a3 += a0;
      a1 += a2;
      a1 ^= a2 >>> 2;
      a2 += a3;
      a4 += a1;
      a2 ^= a3 << 8;
      a5 += a2;
      a3 += a4;
      a3 ^= a4 >>> 16;
      a6 += a3;
      a4 += a5;
      a4 ^= a5 << 10;
      a5 += a6;
      a7 += a4;
      a5 ^= a6 >>> 4;
      a6 += a7;
      a0 += a5;
      a6 ^= a7 << 8;
      a7 += a0;
      a1 += a6;
      a7 ^= a0 >>> 9;
      a0 += a1;
      a2 += a7;
    }

    for (i = 0; i < 256; i += 8) {
      a2 += this.randResult[i + 2];
      a7 += this.randResult[i + 7];
      a5 += this.randResult[i + 5];
      a4 += this.randResult[i + 4];
      a6 += this.randResult[i + 6];
      a3 += this.randResult[i + 3];
      a0 += this.randResult[i];
      a1 += this.randResult[i + 1];

      a0 ^= a1 << 11;
      a3 += a0;
      a1 += a2;
      a1 ^= a2 >>> 2;
      a2 += a3;
      a4 += a1;
      a2 ^= a3 << 8;
      a3 += a4;
      a5 += a2;
      a3 ^= a4 >>> 16;
      a6 += a3;
      a4 += a5;
      a4 ^= a5 << 10;
      a5 += a6;
      a7 += a4;
      a5 ^= a6 >>> 4;
      a0 += a5;
      a6 += a7;
      a6 ^= a7 << 8;
      a7 += a0;
      a1 += a6;
      a7 ^= a0 >>> 9;
      a2 += a7;
      a0 += a1;

      this.mm[i] = a0;
      this.mm[i + 1] = a1;
      this.mm[i + 2] = a2;
      this.mm[i + 3] = a3;
      this.mm[i + 4] = a4;
      this.mm[i + 5] = a5;
      this.mm[i + 6] = a6;
      this.mm[i + 7] = a7;
    }

    for (i = 0; i < 256; i += 8) {
      a4 += this.mm[i + 4];
      a3 += this.mm[i + 3];
      a1 += this.mm[i + 1];
      a2 += this.mm[i + 2];
      a6 += this.mm[i + 6];
      a0 += this.mm[i];
      a7 += this.mm[i + 7];
      a5 += this.mm[i + 5];

      a0 ^= a1 << 11;
      a1 += a2;
      a3 += a0;
      a1 ^= a2 >>> 2;
      a2 += a3;
      a4 += a1;
      a2 ^= a3 << 8;
      a5 += a2;
      a3 += a4;
      a3 ^= a4 >>> 16;
      a6 += a3;
      a4 += a5;
      a4 ^= a5 << 10;
      a7 += a4;
      a5 += a6;
      a5 ^= a6 >>> 4;
      a0 += a5;
      a6 += a7;
      a6 ^= a7 << 8;
      a1 += a6;
      a7 += a0;
      a7 ^= a0 >>> 9;
      a2 += a7;
      a0 += a1;

      this.mm[i] = a0;
      this.mm[i + 1] = a1;
      this.mm[i + 2] = a2;
      this.mm[i + 3] = a3;
      this.mm[i + 4] = a4;
      this.mm[i + 5] = a5;
      this.mm[i + 6] = a6;
      this.mm[i + 7] = a7;
    }

    this.generateMoreResults();
    this.valuesRemaining = 256;
  }

  @OriginalMember(owner = "client!dp", name = "b", descriptor = "(B)I")
  public int next() {
    if (this.valuesRemaining == 0) {
      this.generateMoreResults();
      this.valuesRemaining = 256;
    }

    return this.randResult[--this.valuesRemaining];
  }

  @OriginalMember(owner = "client!dp", name = "b", descriptor = "(I)V")
  private void generateMoreResults() {
    this.bb += ++this.cc;

    for (int i = 0; i < 256; i++) {
      int x = this.mm[i];

      if ((i & 0x2) == 0) {
        if ((i & 0x1) == 0) {
          this.aa ^= this.aa << 13;
        } else {
          this.aa ^= this.aa >>> 6;
        }
      } else if ((i & 0x1) == 0) {
        this.aa ^= this.aa << 2;
      } else {
        this.aa ^= this.aa >>> 16;
      }

      this.aa += this.mm[i + 128 & 0xFF];

      int y;
      this.mm[i] = y = this.bb + this.mm[x >> 2 & 0xFF] + this.aa;
      this.randResult[i] = this.bb = x + this.mm[y >> 8 >> 2 & 0xFF];
    }
  }

  @OriginalMember(owner = "client!dp", name = "c", descriptor = "(I)I")
  public int peek() {
    if (this.valuesRemaining == 0) {
      this.generateMoreResults();
      this.valuesRemaining = 256;
    }

    return this.randResult[this.valuesRemaining - 1];
  }
}
