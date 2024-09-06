package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static337 {

	@OriginalMember(owner = "client!rc", name = "D", descriptor = "I")
	public static int anInt5794 = 0;

	@OriginalMember(owner = "client!rc", name = "a", descriptor = "(ILclient!uu;)Z")
	public static boolean method4579(@OriginalArg(1) Class247 arg0) {
		if (arg0.anInt6842 == Static262.anInt4940) {
			Static95.anInt1910 = 250;
			return true;
		} else {
			return false;
		}
	}

}
