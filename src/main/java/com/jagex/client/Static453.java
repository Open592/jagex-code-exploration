package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static453 {

    @OriginalMember(owner = "client!wu", name = "l", descriptor = "[Z")
	public static boolean[] aBooleanArray25;

	@OriginalMember(owner = "client!wu", name = "r", descriptor = "I")
	public static int anInt7371;

	@OriginalMember(owner = "client!wu", name = "u", descriptor = "I")
	public static int anInt7373;

	@OriginalMember(owner = "client!wu", name = "s", descriptor = "J")
	public static long aLong223 = 0L;

	@OriginalMember(owner = "client!wu", name = "a", descriptor = "(IIIZ)I")
	public static int method5678(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) boolean arg2) {
		@Pc(8) Node_Sub25 local8 = Static175.method2834(arg2, arg1);
		if (local8 == null) {
			return 0;
		} else if (arg0 >= 0 && local8.anIntArray229.length > arg0) {
			return local8.anIntArray229[arg0];
		} else {
			return 0;
		}
	}

	@OriginalMember(owner = "client!wu", name = "a", descriptor = "(II)V")
	public static void method5679(@OriginalArg(1) int arg0) {
		Static46.anInt5156 = arg0;
		Static71.anInt6920 = -1;
		Static71.anInt6920 = -1;
		Static394.method5160();
	}
}
