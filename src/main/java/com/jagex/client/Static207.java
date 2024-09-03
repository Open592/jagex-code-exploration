package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static207 {

	@OriginalMember(owner = "client!kj", name = "h", descriptor = "Lclient!la;")
	public static Class46 aClass46_9;

	@OriginalMember(owner = "client!kj", name = "w", descriptor = "I")
	public static int anInt5454;

	@OriginalMember(owner = "client!kj", name = "c", descriptor = "Lclient!bg;")
	public static final Class22 aClass22_253 = new Class22(83, 3);

	@OriginalMember(owner = "client!kj", name = "u", descriptor = "I")
	public static int anInt5452 = -1;

	@OriginalMember(owner = "client!kj", name = "v", descriptor = "I")
	public static int anInt5453 = -1;

	@OriginalMember(owner = "client!kj", name = "a", descriptor = "(Lclient!uu;I)V")
	public static void method4182(@OriginalArg(0) Class247 arg0) {
		if (!Static341.aBoolean599) {
			return;
		}
		if (arg0.anObjectArray17 != null) {
			@Pc(14) Class247 local14 = Static378.method3230(Static408.anInt6726, Static23.anInt350);
			if (local14 != null) {
				@Pc(20) Node_Sub34 local20 = new Node_Sub34();
				local20.aClass247_14 = local14;
				local20.aClass247_15 = arg0;
				local20.anObjectArray4 = arg0.anObjectArray17;
				Static271.method3894(local20);
			}
		}
		Static429.method5476(Static437.aClass215_66);
		Static3.aClass4_Sub12_Sub1_5.p4(arg0.anInt6809);
		Static3.aClass4_Sub12_Sub1_5.writeInt16LE(Static23.anInt350);
		Static3.aClass4_Sub12_Sub1_5.p2(arg0.anInt6865);
		Static3.aClass4_Sub12_Sub1_5.p4(Static408.anInt6726);
		Static3.aClass4_Sub12_Sub1_5.writeInt16LE(arg0.anInt6779);
		Static3.aClass4_Sub12_Sub1_5.p2(Static161.anInt3179);
	}

}
