package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static157 {

	@OriginalMember(owner = "client!hu", name = "f", descriptor = "I")
	public static int anInt3142;

	@OriginalMember(owner = "client!hu", name = "e", descriptor = "Lclient!gk;")
	public static final LocalizedString A_LOCALIZED_STRING___64 = new LocalizedString("cyan:", "blaugrün:", "cyan:", "cyan:");

	@OriginalMember(owner = "client!hu", name = "h", descriptor = "Lclient!gk;")
	public static final LocalizedString A_LOCALIZED_STRING___65 = new LocalizedString("scroll:", "scrollen:", "déroulement:", "rolagem:");

	@OriginalMember(owner = "client!hu", name = "m", descriptor = "I")
	public static int anInt3147 = -1;

	@OriginalMember(owner = "client!hu", name = "a", descriptor = "(Lclient!iv;II)V")
	public static void method2669(@OriginalArg(0) Packet arg0, @OriginalArg(2) int arg1) {
		if (Static394.randomFile == null) {
			return;
		}
		try {
			Static394.randomFile.seek(0L);
			Static394.randomFile.method3464(arg1, arg0.data, 24);
		} catch (@Pc(18) Exception local18) {
		}
	}

	@OriginalMember(owner = "client!hu", name = "a", descriptor = "(II)V")
	public static void method2673(@OriginalArg(0) int arg0) {
		if (arg0 < 0 || arg0 > 2) {
			arg0 = 0;
		}
		Static216.anInt4008 = arg0;
	}
}
