package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static393 {

	@OriginalMember(owner = "client!tt", name = "J", descriptor = "[I")
	public static int[] anIntArray501;

	@OriginalMember(owner = "client!tt", name = "A", descriptor = "[I")
	public static final int[] anIntArray500 = new int[32];

	@OriginalMember(owner = "client!tt", name = "a", descriptor = "(Lclient!iv;B)Lclient!br;")
	public static Class27_Sub1 method5149(@OriginalArg(0) Packet arg0) {
		return new Class27_Sub1(arg0.g2s(), arg0.g2s(), arg0.g2s(), arg0.g2s(), arg0.g2s(), arg0.g2s(), arg0.g2s(), arg0.g2s(), arg0.g3(), arg0.g1());
	}
}
