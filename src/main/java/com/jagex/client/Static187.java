package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static187 {

	@OriginalMember(owner = "client!ji", name = "g", descriptor = "[I")
	public static final int[] anIntArray233 = new int[14];

	@OriginalMember(owner = "client!ji", name = "h", descriptor = "Lclient!gk;")
	public static final LocalizedString A_LOCALIZED_STRING___74 = new LocalizedString("K", "T", "K", "K");

	@OriginalMember(owner = "client!ji", name = "m", descriptor = "I")
	public static int anInt3559 = 0;

	@OriginalMember(owner = "client!ji", name = "n", descriptor = "Lclient!bg;")
	public static final Class22 aClass22_159 = new Class22(16, -1);

	@OriginalMember(owner = "client!ji", name = "o", descriptor = "I")
	public static int anInt3560 = 0;

	@OriginalMember(owner = "client!ji", name = "a", descriptor = "(BI)V")
	public static void method2932(@OriginalArg(1) int arg0) {
		if (arg0 == Static403.anInt6667) {
			return;
		}
		if (Static403.anInt6667 == 0) {
			Static253.method3676();
		}
		if (arg0 == 40) {
			Static445.method5617();
		}
		if (arg0 != 40 && Static169.aServerConnection_6 != null) {
			Static169.aServerConnection_6.shutdown();
			Static169.aServerConnection_6 = null;
		}
		if (Static403.anInt6667 == 25 || Static403.anInt6667 == 28) {
			Static74.aJs5_20.anInt2476 = 2;
			Static208.aJs5_29.anInt2476 = 2;
			Static424.aJs5_99.anInt2476 = 2;
			Static381.aJs5_87.anInt2476 = 2;
			Static391.aJs5_91.anInt2476 = 2;
			Static388.aJs5_90.anInt2476 = 2;
			Static55.aJs5_16.anInt2476 = 2;
		}
		if (arg0 == 25 || arg0 == 28) {
			Static275.anInt5144 = 0;
			Static26.anInt448 = 1;
			Static51.anInt883 = 0;
			Static100.anInt2020 = 0;
			Static444.anInt7298 = 1;
			Static33.method633(true);
			Static74.aJs5_20.anInt2476 = 1;
			Static208.aJs5_29.anInt2476 = 1;
			Static424.aJs5_99.anInt2476 = 1;
			Static381.aJs5_87.anInt2476 = 1;
			Static391.aJs5_91.anInt2476 = 1;
			Static388.aJs5_90.anInt2476 = 1;
			Static55.aJs5_16.anInt2476 = 1;
		}
		if (arg0 == 25 || arg0 == 10) {
			Static343.method744();
		}
		if (arg0 == 5) {
			Static443.method5592(Static122.aClass19_16, Static293.aJs5_60);
		} else {
			Static356.method4834();
		}
		@Pc(135) boolean local135 = arg0 == 5 || arg0 == 10 || arg0 == 28;
		@Pc(148) boolean local148 = Static403.anInt6667 == 5 || Static403.anInt6667 == 10 || Static403.anInt6667 == 28;
		if (local135 != local148) {
			if (local135) {
				Static62.anInt1117 = Static414.anInt6866;
				if (Static323.aClass50_Sub1_1.anInt3439 == 0) {
					Static397.method724();
				} else {
					Static408.method5258(Static323.aClass50_Sub1_1.anInt3439, Static46.aJs5_54, Static414.anInt6866);
				}
				client.js5NetQueue.informUserAuthenticationStatus(false);
			} else {
				Static397.method724();
				client.js5NetQueue.informUserAuthenticationStatus(true);
			}
		}
		if (arg0 == 25 || arg0 == 28 || arg0 == 40) {
			Static122.aClass19_16.method4281();
		}
		Static403.anInt6667 = arg0;
	}

	@OriginalMember(owner = "client!ji", name = "a", descriptor = "(IIIII)V")
	public static void method2934(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3) {
		if (Static323.aClass50_Sub1_1.anInt3448 != 0 && arg1 != 0 && Static109.anInt6886 < 50 && arg0 != -1) {
			Static86.aClass269Array1[Static109.anInt6886++] = new Class269((byte) 1, arg0, arg1, arg3, arg2, 0);
		}
	}

	@OriginalMember(owner = "client!ji", name = "b", descriptor = "(I)Lclient!aq;")
	public static Node_Sub3 method2937() {
		if (Static148.A_LINKED_LIST___41 == null || Static308.aClass63_1 == null) {
			return null;
		}
		for (@Pc(16) Node_Sub3 local16 = (Node_Sub3) Static308.aClass63_1.method1612(); local16 != null; local16 = (Node_Sub3) Static308.aClass63_1.method1612()) {
			@Pc(24) Class157 local24 = Static148.aClass182_3.method4124(local16.anInt234);
			if (local24 != null && local24.aBoolean448 && local24.method3778(Static148.anInterface12_2)) {
				return local16;
			}
		}
		return null;
	}

	@OriginalMember(owner = "client!ji", name = "a", descriptor = "(IIIIIII)I")
	public static int method2938(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(5) int arg4, @OriginalArg(6) int arg5) {
		@Pc(3) int local3 = arg1 & 0x3;
		if ((arg4 & 0x1) == 1) {
			@Pc(16) int local16 = arg5;
			arg5 = arg2;
			arg2 = local16;
		}
		if (local3 == 0) {
			return arg0;
		} else if (local3 == 1) {
			return arg3;
		} else if (local3 == 2) {
			return 1 + 7 - arg5 - arg0;
		} else {
			return 1 + 7 - arg2 - arg3;
		}
	}
}
