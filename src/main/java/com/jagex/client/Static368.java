package com.jagex.client;

import java.awt.Point;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static368 {

	@OriginalMember(owner = "client!so", name = "a", descriptor = "Lclient!gk;")
	public static final LocalizedString A_LOCALIZED_STRING___124 = new LocalizedString("Please remove ", "Bitte entferne ", "Veuillez commencer par supprimer ", "Remova ");

	@OriginalMember(owner = "client!so", name = "c", descriptor = "F")
	public static float aFloat192 = 0.0F;

	@OriginalMember(owner = "client!so", name = "a", descriptor = "(IB)V")
	public static void method4938(@OriginalArg(0) int arg0) {
		if (!Static323.aClass50_Sub1_1.aBoolean304) {
			arg0 = -1;
		}
		if (arg0 == Static6.anInt57) {
			return;
		}
		if (arg0 != -1) {
			@Pc(30) Class74 local30 = Static118.aClass172_2.method3977(arg0);
			@Pc(34) Class18 local34 = local30.method2061();
			if (local34 == null) {
				arg0 = -1;
			} else {
				GameShell.signLink.emitSetCustomCursorMessage(GameShell.canvas, local34.method324(), local34.method325(), local34.method319(), new Point(local30.anInt2420, local30.anInt2419));
				Static6.anInt57 = arg0;
			}
		}
		if (arg0 == -1 && Static6.anInt57 != -1) {
			GameShell.signLink.emitSetCustomCursorMessage(GameShell.canvas, -1, -1, null, new Point());
			Static6.anInt57 = -1;
		}
	}
}
