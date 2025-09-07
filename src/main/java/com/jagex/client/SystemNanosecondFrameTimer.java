package com.jagex.client;

import com.jagex.client.utilities.ThreadingUtilities;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ci")
public final class SystemNanosecondFrameTimer extends FrameTimer {

  @OriginalMember(owner = "client!ci", name = "f", descriptor = "J")
  private long aLong32 = 0L;

  @OriginalMember(owner = "client!ci", name = "g", descriptor = "J")
  private long aLong33 = 0L;

  @OriginalMember(owner = "client!ci", name = "h", descriptor = "I")
  private int sampleCount = 1;

  @OriginalMember(owner = "client!ci", name = "i", descriptor = "[J")
  private final long[] pastIntervals = new long[10];

  @OriginalMember(owner = "client!ci", name = "j", descriptor = "I")
  private int cursor = 0;

  @OriginalMember(owner = "client!ci", name = "k", descriptor = "J")
  private long lastNanoTime = 0L;

  @OriginalMember(owner = "client!ci", name = "<init>", descriptor = "()V")
  public SystemNanosecondFrameTimer() {
    this.aLong32 = System.nanoTime();
    this.aLong33 = System.nanoTime();
  }

  @OriginalMember(owner = "client!ci", name = "a", descriptor = "(I)J")
  private long getAverageIntervalNanoTime() {
    @Pc(1)
    long currentNanoTime = System.nanoTime();
    @Pc(7)
    long nanoDifference = currentNanoTime - this.lastNanoTime;

    this.lastNanoTime = currentNanoTime;

    if (nanoDifference > -5000000000L && nanoDifference < 5000000000L) {
      this.pastIntervals[this.cursor] = nanoDifference;
      this.cursor = (this.cursor + 1) % 10;

      if (this.sampleCount < 1) {
        this.sampleCount++;
      }
    }

    @Pc(51)
    long aggregate = 0;

    for (@Pc(53) int i = 1; i <= this.sampleCount; i++) {
      aggregate += this.pastIntervals[(this.cursor + 10 - i) % 10];
    }

    return aggregate / (long) this.sampleCount;
  }

  @OriginalMember(owner = "client!ci", name = "c", descriptor = "(B)J")
  @Override
  public long method2252() {
    return this.aLong32;
  }

  @OriginalMember(owner = "client!ci", name = "a", descriptor = "(ZI)I")
  @Override
  public int method2253(@OriginalArg(1) int frameTimeInMilliseconds) {
    @Pc(9)
    long frameTimeInNanoseconds = (long) frameTimeInMilliseconds * 1000000L;

    this.aLong32 += this.getAverageIntervalNanoTime();

    if (this.aLong33 > this.aLong32) {
      ThreadingUtilities.sleepFor((this.aLong33 - this.aLong32) / 1000000L);
      this.lastNanoTime += this.aLong33 - this.aLong32;
      this.aLong32 += this.aLong33 - this.aLong32;
      this.aLong33 += frameTimeInNanoseconds;
      return 1;
    }

    @Pc(25)
    int local25 = 0;

    do {
      local25++;
      this.aLong33 += frameTimeInNanoseconds;
    } while (local25 < 10 && this.aLong32 > this.aLong33);

    if (this.aLong33 < this.aLong32) {
      this.aLong33 = this.aLong32;
    }

    return local25;
  }

  @OriginalMember(owner = "client!ci", name = "a", descriptor = "(B)V")
  @Override
  public void reset() {
    this.lastNanoTime = 0L;

    if (this.aLong32 < this.aLong33) {
      this.aLong32 += this.aLong33 - this.aLong32;
    }
  }
}
