package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static204 {

	@OriginalMember(owner = "client!kg", name = "k", descriptor = "I")
	public static int anInt3896;

	@OriginalMember(owner = "client!kg", name = "l", descriptor = "F")
	public static float aFloat127;

	@OriginalMember(owner = "client!kg", name = "a", descriptor = "(ZZIIB)I")
	public static int method3185(@OriginalArg(1) boolean arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2) {
		@Pc(10) Node_Sub25 local10 = Static175.method2834(false, arg1);
		if (local10 == null) {
			return 0;
		}
		@Pc(16) int local16 = 0;
		for (@Pc(23) int local23 = 0; local23 < local10.anIntArray230.length; local23++) {
			if (local10.anIntArray230[local23] >= 0 && local10.anIntArray230[local23] < Static444.aClass206_3.anInt5987) {
				@Pc(49) Class211 local49 = Static444.aClass206_3.method4703(local10.anIntArray230[local23]);
				@Pc(59) int local59 = local49.method4781(arg2, Static153.aClass180_1.method4121(arg2).anInt4123);
				if (arg0) {
					local16 += local10.anIntArray229[local23] * local59;
				} else {
					local16 += local59;
				}
			}
		}
		return local16;
	}

	@OriginalMember(owner = "client!kg", name = "a", descriptor = "(IIIIIII)Lclient!tb;")
	public static Class99 method3186(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5) {
		@Pc(38) long local38 = (long) arg2 * 76724863L ^ (long) arg0 * 32147369L ^ (long) arg4 * 986053L ^ (long) arg3 * 67481L ^ (long) arg5 * 97549L ^ (long) arg1 * 475427L;
		@Pc(44) Class99 local44 = (Class99) Static406.aClass68_51.method1787(local38);
		if (local44 == null) {
			local44 = Static57.aClass19_7.method4268(arg3, arg5, arg1, arg4, arg0, arg2);
			Static406.aClass68_51.method1779(local38, local44);
			return local44;
		} else {
			return local44;
		}
	}
}
