package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!hq")
public abstract class BufferedBytes {

	@OriginalMember(owner = "client!hq", name = "a", descriptor = "(III)[B")
	public abstract byte[] getAt(@OriginalArg(0) int arg0);

	@OriginalMember(owner = "client!hq", name = "a", descriptor = "(B)[B")
	public abstract byte[] get();

	@OriginalMember(owner = "client!hq", name = "a", descriptor = "(I[B)V")
	public abstract void init(@OriginalArg(1) byte[] arg0);
}
