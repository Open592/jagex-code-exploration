package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static24 {

	@OriginalMember(owner = "client!ba", name = "A", descriptor = "Lclient!fs;")
	public static Class76 aClass76_61;

	@OriginalMember(owner = "client!ba", name = "y", descriptor = "Ljava/lang/String;")
	public static String aString53 = "";

	@OriginalMember(owner = "client!ba", name = "z", descriptor = "Lclient!bg;")
	public static final Class22 aClass22_245 = new Class22(40, 3);

	@OriginalMember(owner = "client!ba", name = "b", descriptor = "(II)I")
	public static int method4082(@OriginalArg(1) int arg0) {
		return arg0 & 0xFF;
	}
}
