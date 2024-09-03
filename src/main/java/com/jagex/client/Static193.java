package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static193 {

	@OriginalMember(owner = "client!jp", name = "I", descriptor = "[[B")
	public static byte[][] aByteArrayArray13;

	@OriginalMember(owner = "client!jp", name = "a", descriptor = "(IIZ)Z")
	public static boolean method3032(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		return (arg1 & 0x580) != 0;
	}

	@OriginalMember(owner = "client!jp", name = "a", descriptor = "(Lclient!sp;B)Z")
	public static boolean isStagingEnvironment(@OriginalArg(0) ModeWhere modewhere) {
		return ClientSettings.MODEWHERE_WTRC == modewhere || modewhere == ClientSettings.MODEWHERE_WTQA || modewhere == ClientSettings.MODEWHERE_WTWIP || modewhere == ClientSettings.MODEWHERE_WTI;
	}
}
