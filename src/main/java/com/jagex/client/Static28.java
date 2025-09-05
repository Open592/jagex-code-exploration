package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static28 {

	@OriginalMember(owner = "client!bg", name = "c", descriptor = "I")
	public static int anInt464 = 0;

	@OriginalMember(owner = "client!bg", name = "a", descriptor = "(ZI)I")
	public static int method526(@OriginalArg(1) int arg0) {
		if (Static125.aServerConnection_5 != null) {
			Static125.aServerConnection_5.shutdown();
			Static125.aServerConnection_5 = null;
		}
		Static274.anInt5132++;
		if (Static274.anInt5132 > 4) {
			Static274.anInt5132 = 0;
			Static50.anInt862 = 0;
			return arg0;
		}
		if (Static133.JS5Port == Static313.anInt5435) {
			Static313.anInt5435 = Static11.HTTPPort;
		} else {
			Static313.anInt5435 = Static133.JS5Port;
		}
		Static50.anInt862 = 0;
		return -1;
	}

	@OriginalMember(owner = "client!bg", name = "a", descriptor = "(Lclient!wt;IIBI)V")
	public static void method528(@OriginalArg(0) Node_Sub45 arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(4) int arg3) {
		@Pc(20) long local20 = (long) (arg1 | arg3 << 28 | arg2 << 14);
		@Pc(26) Node_Sub18 local26 = (Node_Sub18) Static440.aHashMap_40.get(local20);
		if (local26 == null) {
			local26 = new Node_Sub18();
			Static440.aHashMap_40.set(local20, local26);
			local26.aLinkedList_14.addFirst(arg0);
			return;
		}
		@Pc(49) Class211 local49 = Static444.aClass206_3.method4703(arg0.anInt7355);
		@Pc(52) int local52 = local49.anInt6165;
		if (local49.anInt6164 == 1) {
			local52 *= arg0.anInt7356 + 1;
		}
		for (@Pc(71) Node_Sub45 local71 = (Node_Sub45) local26.aLinkedList_14.tail(); local71 != null; local71 = (Node_Sub45) local26.aLinkedList_14.previous()) {
			local49 = Static444.aClass206_3.method4703(local71.anInt7355);
			@Pc(82) int local82 = local49.anInt6165;
			if (local49.anInt6164 == 1) {
				local82 *= local71.anInt7356 + 1;
			}
			if (local52 > local82) {
				Static245.method3597(local71, arg0);
				return;
			}
		}
		local26.aLinkedList_14.addFirst(arg0);
	}

	@OriginalMember(owner = "client!bg", name = "b", descriptor = "(I)V")
	public static void method529() {
		Static297.aClass247ArrayArray2 = new Class247[Static356.aJs5_81.method2100()][];
		Static30.aClass247ArrayArray1 = new Class247[Static356.aJs5_81.method2100()][];
		Static453.aBooleanArray25 = new boolean[Static356.aJs5_81.method2100()];
	}
}
