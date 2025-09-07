package com.jagex.client;

import com.jagex.client.jaggl.memory.NativeBuffer;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ue")
public final class Class152_Sub2 extends Class152 implements Interface11 {

  @OriginalMember(owner = "client!ue", name = "x", descriptor = "I")
  private int anInt6626;

  @OriginalMember(owner = "client!ue", name = "<init>", descriptor = "(Lclient!fd;I[BIZ)V")
  public Class152_Sub2(
      @OriginalArg(0) Class19_Sub2 arg0,
      @OriginalArg(1) int arg1,
      @OriginalArg(2) byte[] arg2,
      @OriginalArg(3) int arg3,
      @OriginalArg(4) boolean arg4) {
    super(arg0, 34962, arg2, arg3, arg4);
    this.anInt6626 = arg1;
  }

  @OriginalMember(
      owner = "client!ue",
      name = "<init>",
      descriptor = "(Lclient!fd;ILclient!jaggl/memory/NativeBuffer;IZ)V")
  public Class152_Sub2(
      @OriginalArg(0) Class19_Sub2 arg0,
      @OriginalArg(1) int arg1,
      @OriginalArg(2) NativeBuffer arg2,
      @OriginalArg(3) int arg3,
      @OriginalArg(4) boolean arg4) {
    super(arg0, 34962, arg2, arg3, arg4);
    this.anInt6626 = arg1;
  }

  @OriginalMember(owner = "client!ue", name = "a", descriptor = "(BII[B)V")
  @Override
  public void method5184(
      @OriginalArg(1) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) byte[] arg2) {
    this.method5177(arg0, arg2);
    this.anInt6626 = arg1;
  }

  @OriginalMember(owner = "client!ue", name = "d", descriptor = "(B)V")
  @Override
  protected void method5179() {
    super.aClass19_Sub2_37.method1944(this);
  }

  @OriginalMember(owner = "client!ue", name = "b", descriptor = "(I)J")
  @Override
  public long method5183() {
    return 0L;
  }

  @OriginalMember(owner = "client!ue", name = "a", descriptor = "(Z)I")
  @Override
  public int method5182() {
    return this.anInt6626;
  }

  @OriginalMember(owner = "client!ue", name = "a", descriptor = "(I)I")
  @Override
  public int method5181() {
    return super.anInt6614;
  }
}
