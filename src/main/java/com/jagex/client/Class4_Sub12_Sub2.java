package com.jagex.client;

import com.jagex.client.jaggl.memory.NativeStream;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!hk")
public final class Class4_Sub12_Sub2 extends ByteBuffer {

	@OriginalMember(owner = "client!hk", name = "<init>", descriptor = "(I)V")
	public Class4_Sub12_Sub2(@OriginalArg(0) int arg0) {
		super(arg0);
	}

	@OriginalMember(owner = "client!hk", name = "a", descriptor = "(FI)V")
	public void method2552(@OriginalArg(0) float arg0) {
		@Pc(12) int local12 = NativeStream.floatToRawIntBits(arg0);
		super.bytes[super.position++] = (byte) local12;
		super.bytes[super.position++] = (byte) (local12 >> 8);
		super.bytes[super.position++] = (byte) (local12 >> 16);
		super.bytes[super.position++] = (byte) (local12 >> 24);
	}

	@OriginalMember(owner = "client!hk", name = "a", descriptor = "(FB)V")
	public void method2556(@OriginalArg(0) float arg0) {
		@Pc(6) int local6 = NativeStream.floatToRawIntBits(arg0);
		super.bytes[super.position++] = (byte) (local6 >> 24);
		super.bytes[super.position++] = (byte) (local6 >> 16);
		super.bytes[super.position++] = (byte) (local6 >> 8);
		super.bytes[super.position++] = (byte) local6;
	}
}
