package com.jagex.client;

import com.jagex.client.js5.Js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static442 {

	@OriginalMember(owner = "client!wh", name = "G", descriptor = "Lclient!fa;")
	public static final Class68 aClass68_58 = new Class68(260);

	@OriginalMember(owner = "client!wh", name = "nb", descriptor = "J")
	public static long aLong219 = 0L;

	@OriginalMember(owner = "client!wh", name = "a", descriptor = "(III)V")
	public static void method5573(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
		@Pc(8) SecondaryNode_Sub1_Sub11 local8 = Static405.method5222(0, 15);
		local8.method2604();
		local8.anInt3082 = arg1;
		local8.anInt3083 = arg0;
	}

	@OriginalMember(owner = "client!wh", name = "a", descriptor = "(Z[B)Z")
	public static boolean method5583(@OriginalArg(1) byte[] arg0) {
		@Pc(20) Packet local20 = new Packet(arg0);
		@Pc(24) int local24 = local20.g1();
		if (local24 != 1) {
			return false;
		}
		@Pc(38) boolean local38 = local20.g1() == 1;
		if (local38) {
			Static142.method2425(local20);
		}
		Static340.method4615(local20);
		return true;
	}

	@OriginalMember(owner = "client!wh", name = "a", descriptor = "(IZLclient!l;Lclient!uu;Lclient!ma;III)V")
	public static void method5585(@OriginalArg(0) int arg0, @OriginalArg(2) Class57 arg1, @OriginalArg(3) Class247 arg2, @OriginalArg(4) Class145 arg3, @OriginalArg(5) int arg4, @OriginalArg(6) int arg5, @OriginalArg(7) int arg6) {
		if (arg1 == null) {
			return;
		}
		@Pc(21) int local21;
		if (Static111.anInt2386 == 4) {
			local21 = (int) Static368.aFloat192 & 0x3FFF;
		} else {
			local21 = Static175.anInt3399 + (int) Static368.aFloat192 & 0x3FFF;
		}
		@Pc(40) int local40 = Math.max(arg2.anInt6833 / 2, arg2.anInt6805 / 2) + 10;
		@Pc(48) int local48 = arg5 * arg5 + arg4 * arg4;
		if (local48 > local40 * local40) {
			return;
		}
		@Pc(62) int local62 = Class50_Sub1.anIntArray225[local21];
		@Pc(66) int local66 = Class50_Sub1.anIntArray224[local21];
		if (Static111.anInt2386 != 4) {
			local62 = local62 * 256 / (Static110.anInt2374 + 256);
			local66 = local66 * 256 / (Static110.anInt2374 + 256);
		}
		@Pc(97) int local97 = arg4 * local62 + arg5 * local66 >> 15;
		@Pc(108) int local108 = local66 * arg4 - local62 * arg5 >> 15;
		arg1.method5542(local97 + arg2.anInt6833 / 2 + arg0 - arg1.j() / 2, -local108 + arg2.anInt6805 / 2 + arg6 + -(arg1.T() / 2), arg3, arg0, arg6);
	}

	@OriginalMember(owner = "client!wh", name = "a", descriptor = "(ILclient!fs;Lclient!fs;Lclient!fs;Lclient!fs;)V")
	public static void method5586(@OriginalArg(1) Js5 arg0, @OriginalArg(2) Js5 arg1, @OriginalArg(3) Js5 arg2, @OriginalArg(4) Js5 arg3) {
		Static356.aJs5_81 = arg0;
		Static410.aJs5_95 = arg2;
		Static52.aJs5_15 = arg1;
		Static381.aJs5_89 = arg3;
		Static297.aClass247ArrayArray2 = new Class247[Static356.aJs5_81.method2100()][];
		Static453.aBooleanArray25 = new boolean[Static356.aJs5_81.method2100()];
	}
}
