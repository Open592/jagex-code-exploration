package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static11 {

	@OriginalMember(owner = "client!aj", name = "j", descriptor = "I")
	public static int HTTPPort;

	@OriginalMember(owner = "client!aj", name = "k", descriptor = "[I")
	public static final int[] anIntArray10 = new int[] { 16, 32, 64, 128 };

	@OriginalMember(owner = "client!aj", name = "s", descriptor = "Lclient!ib;")
	public static final LinkedHashMapIterator A_ITERABLE_HASH_MAP___1 = new LinkedHashMapIterator(8);

	@OriginalMember(owner = "client!aj", name = "x", descriptor = "Lclient!bg;")
	public static final Class22 aClass22_16 = new Class22(0, 28);

	@OriginalMember(owner = "client!aj", name = "a", descriptor = "(II)Lclient!oc;")
	public static LinkedEntry_Sub6 method122(@OriginalArg(0) int arg0) {
		if (arg0 == 0) {
			return new LinkedEntry_Sub6_Sub21();
		} else if (arg0 == 1) {
			return new LinkedEntry_Sub6_Sub1();
		} else if (arg0 == 2) {
			return new LinkedEntry_Sub6_Sub26();
		} else if (arg0 == 3) {
			return new LinkedEntry_Sub6_Sub7();
		} else if (arg0 == 4) {
			return new LinkedEntry_Sub6_Sub24();
		} else if (arg0 == 5) {
			return new LinkedEntry_Sub6_Sub29();
		} else if (arg0 == 6) {
			return new LinkedEntry_Sub6_Sub13();
		} else if (arg0 == 7) {
			return new LinkedEntry_Sub6_Sub18();
		} else if (arg0 == 8) {
			return new LinkedEntry_Sub6_Sub2();
		} else if (arg0 == 9) {
			return new LinkedEntry_Sub6_Sub14();
		} else if (arg0 == 10) {
			return new LinkedEntry_Sub6_Sub6();
		} else if (arg0 == 11) {
			return new LinkedEntry_Sub6_Sub19();
		} else if (arg0 == 12) {
			return new LinkedEntry_Sub6_Sub33();
		} else if (arg0 == 13) {
			return new LinkedEntry_Sub6_Sub15();
		} else if (arg0 == 14) {
			return new LinkedEntry_Sub6_Sub4();
		} else if (arg0 == 15) {
			return new LinkedEntry_Sub6_Sub34();
		} else if (arg0 == 16) {
			return new LinkedEntry_Sub6_Sub23();
		} else if (arg0 == 17) {
			return new LinkedEntry_Sub6_Sub38();
		} else if (arg0 == 18) {
			return new LinkedEntry_Sub6_Sub3_Sub1();
		} else if (arg0 == 19) {
			return new LinkedEntry_Sub6_Sub22();
		} else if (arg0 == 20) {
			return new LinkedEntry_Sub6_Sub32();
		} else if (arg0 == 21) {
			return new LinkedEntry_Sub6_Sub30();
		} else if (arg0 == 22) {
			return new LinkedEntry_Sub6_Sub25();
		} else if (arg0 == 23) {
			return new LinkedEntry_Sub6_Sub11();
		} else if (arg0 == 24) {
			return new LinkedEntry_Sub6_Sub5();
		} else if (arg0 == 25) {
			return new LinkedEntry_Sub6_Sub35();
		} else if (arg0 == 26) {
			return new LinkedEntry_Sub6_Sub12();
		} else if (arg0 == 27) {
			return new LinkedEntry_Sub6_Sub39();
		} else if (arg0 == 28) {
			return new LinkedEntry_Sub6_Sub9();
		} else if (arg0 == 29) {
			return new LinkedEntry_Sub6_Sub8();
		} else if (arg0 == 30) {
			return new LinkedEntry_Sub6_Sub31();
		} else if (arg0 == 31) {
			return new LinkedEntry_Sub6_Sub27();
		} else if (arg0 == 32) {
			return new LinkedEntry_Sub6_Sub16();
		} else if (arg0 == 33) {
			return new LinkedEntry_Sub6_Sub37();
		} else if (arg0 == 34) {
			return new LinkedEntry_Sub6_Sub10();
		} else if (arg0 == 35) {
			return new LinkedEntry_Sub6_Sub36();
		} else if (arg0 == 36) {
			return new LinkedEntry_Sub6_Sub17();
		} else if (arg0 == 37) {
			return new LinkedEntry_Sub6_Sub20();
		} else if (arg0 == 38) {
			return new LinkedEntry_Sub6_Sub28();
		} else if (arg0 == 39) {
			return new LinkedEntry_Sub6_Sub3();
		} else {
			return null;
		}
	}

	@OriginalMember(owner = "client!aj", name = "a", descriptor = "(IIIIIIIBI)V")
	public static void method123(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(8) int arg7) {
		if (Static112.method2034(arg4)) {
			if (Static30.aClass247ArrayArray1[arg4] == null) {
				Static147.method2460(arg2, arg3, arg7, arg1, Static297.aClass247ArrayArray2[arg4], arg0, -1, arg5, arg6);
			} else {
				Static147.method2460(arg2, arg3, arg7, arg1, Static30.aClass247ArrayArray1[arg4], arg0, -1, arg5, arg6);
			}
		} else if (arg1 == -1) {
			for (@Pc(18) int local18 = 0; local18 < 100; local18++) {
				Static416.aBooleanArray21[local18] = true;
			}
		} else {
			Static416.aBooleanArray21[arg1] = true;
		}
	}
}
