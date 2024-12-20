package com.jagex.client.js5;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!oi")
public abstract class Js5ResourceProvider {

	@OriginalMember(owner = "client!oi", name = "<init>", descriptor = "()V")
	protected Js5ResourceProvider() {
	}

	@OriginalMember(owner = "client!oi", name = "a", descriptor = "(II)V")
	public abstract void method3512(@OriginalArg(0) int arg0);

	@OriginalMember(owner = "client!oi", name = "a", descriptor = "(B)Lclient!rt;")
	public abstract Js5Index fetchIndex();

	@OriginalMember(owner = "client!oi", name = "a", descriptor = "(IB)I")
	public abstract int getDownloadPercentage(@OriginalArg(0) int arg0);

	@OriginalMember(owner = "client!oi", name = "b", descriptor = "(II)[B")
	public abstract byte[] method3516(@OriginalArg(1) int arg0);
}
