package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static222 {

	@OriginalMember(owner = "client!lg", name = "h", descriptor = "I")
	public static int anInt4125;

	@OriginalMember(owner = "client!lg", name = "m", descriptor = "Lclient!v;")
	public static Class249 aClass249_1;

	@OriginalMember(owner = "client!lg", name = "a", descriptor = "(II)Z")
	public static boolean method3349(@OriginalArg(0) int arg0) {
		return arg0 != 1 && arg0 != 7;
	}

	@OriginalMember(owner = "client!lg", name = "a", descriptor = "(IB)V")
	public static void method3351() {
		Static259.aClass68_26.method1788(50);
		Static232.aClass68_25.method1788(50);
		Static384.aClass68_47.method1788(50);
		Static52.aClass68_4.method1788(50);
		Static158.aClass68_16.method1788(50);
	}

	@OriginalMember(owner = "client!lg", name = "a", descriptor = "(ZLclient!ac;Lclient!ac;)V")
	public static void method3353(@OriginalArg(1) SecondaryNode arg0, @OriginalArg(2) SecondaryNode arg1) {
		if (arg1.secondaryNext != null) {
			arg1.secondaryPopSelf();
		}
		arg1.secondaryNext = arg0;
		arg1.secondaryPrevious = arg0.secondaryPrevious;
		arg1.secondaryNext.secondaryPrevious = arg1;
		arg1.secondaryPrevious.secondaryNext = arg1;
	}

	@OriginalMember(owner = "client!lg", name = "a", descriptor = "(B)V")
	public static void method3355() {
		Static336.aBoolean596 = true;
	}
}
