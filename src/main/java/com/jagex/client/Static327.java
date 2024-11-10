package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static327 {

	@OriginalMember(owner = "client!qj", name = "k", descriptor = "Lclient!sl;")
	public static final Class215 aClass215_76 = new Class215(15, -1);

	@OriginalMember(owner = "client!qj", name = "p", descriptor = "I")
	public static int anInt5675 = -1;

	@OriginalMember(owner = "client!qj", name = "a", descriptor = "(BZ[B)Ljava/lang/Object;")
	public static Object method4416(@OriginalArg(2) byte[] arg0) {
		if (arg0 == null) {
			return null;
		}
		if (arg0.length > 136 && !Static279.aBoolean664) {
			try {
				@Pc(25) Class34 local25 = (Class34) Class.forName("Class34_Sub1").getDeclaredConstructor().newInstance();
				local25.method775(arg0);
				return local25;
			} catch (@Pc(34) Throwable local34) {
				Static279.aBoolean664 = true;
			}
		}
		return arg0;
	}

	@OriginalMember(owner = "client!qj", name = "a", descriptor = "(BZ)V")
	public static void method4422(@OriginalArg(1) boolean arg0) {
		Static395.method5164(arg0, Static302.height, Static334.anInt5766, Static141.width);
	}
}
