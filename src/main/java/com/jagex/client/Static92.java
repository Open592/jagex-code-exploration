package com.jagex.client;

import com.jagex.signlink.MonotonicClock;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static92 {

	@OriginalMember(owner = "client!em", name = "c", descriptor = "Lclient!pn;")
	public static final Class186 aClass186_7 = new Class186("", 17);

	@OriginalMember(owner = "client!em", name = "h", descriptor = "I")
	public static int anInt1847 = 0;

	@OriginalMember(owner = "client!em", name = "a", descriptor = "(IBI)Z")
	public static boolean method1613(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
		return (arg0 & 0x10) != 0;
	}

	@OriginalMember(owner = "client!em", name = "a", descriptor = "(I)Lclient!hp;")
	public static SecondaryNode_Sub1_Sub11 method1614() {
		@Pc(12) SecondaryNode_Sub1_Sub11 local12 = (SecondaryNode_Sub1_Sub11) Static99.A_SECONDARY_DOUBLY_LINKED_LIST___1.getHead();
		if (local12 != null) {
			local12.popSelf();
			local12.secondaryPopSelf();
			return local12;
		}
		do {
			local12 = (SecondaryNode_Sub1_Sub11) Static250.A_SECONDARY_DOUBLY_LINKED_LIST___4.getHead();
			if (local12 == null) {
				return null;
			}
			if (local12.method2611() > MonotonicClock.getCurrentTimeInMilliseconds()) {
				return null;
			}
			local12.popSelf();
			local12.secondaryPopSelf();
		} while ((local12.secondaryValue & Long.MIN_VALUE) == 0L);
		return local12;
	}

	@OriginalMember(owner = "client!em", name = "a", descriptor = "(III)V")
	public static void method1617(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
		Static429.method5476(Static122.aClass215_33);
		Static3.aClass4_Sub12_Sub1_5.p2_alt2(arg1);
		Static3.aClass4_Sub12_Sub1_5.p4(arg0);
	}
}
