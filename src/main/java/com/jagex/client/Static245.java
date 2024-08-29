package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static245 {

	@OriginalMember(owner = "client!mj", name = "P", descriptor = "Lclient!bg;")
	public static final Class22 aClass22_205 = new Class22(72, 6);

	@OriginalMember(owner = "client!mj", name = "a", descriptor = "(III)Z")
	public static boolean method3594(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		return (arg1 & 0x21) != 0;
	}

	@OriginalMember(owner = "client!mj", name = "a", descriptor = "(IZIIZII)V")
	public static void method3596(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(5) int arg4, @OriginalArg(6) int arg5) {
		Static188.anInt5355 = arg3;
		Static365.anInt6311 = arg0;
		Static286.anInt5198 = arg2;
		Static67.anInt1408 = arg5;
		Static146.anInt266 = arg4;
		if (arg1 && Static286.anInt5198 >= 100) {
			Static163.anInt3197 = Static146.anInt266 * 128 + 64;
			Static145.anInt2906 = Static188.anInt5355 * 128 + 64;
			Static100.anInt2024 = Static13.method135(Static163.anInt3197, Static263.anInt4963, Static145.anInt2906) - Static365.anInt6311;
		}
		Static111.anInt2386 = 2;
	}

	@OriginalMember(owner = "client!mj", name = "a", descriptor = "(Lclient!vu;Lclient!vu;I)V")
	public static void method3597(@OriginalArg(0) LinkedHashEntry arg0, @OriginalArg(1) LinkedHashEntry arg1) {
		if (arg1.next != null) {
			arg1.popSelf();
		}
		arg1.next = arg0.next;
		arg1.previous = arg0;
		arg1.next.previous = arg1;
		arg1.previous.next = arg1;
	}
}
