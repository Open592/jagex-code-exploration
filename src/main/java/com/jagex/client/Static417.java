package com.jagex.client;

import com.jagex.client.js5.Js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static417 {

	@OriginalMember(owner = "client!vb", name = "S", descriptor = "[Lclient!ta;")
	public static Class65[] aClass65Array4;

	@OriginalMember(owner = "client!vb", name = "ab", descriptor = "Lclient!fs;")
	public static Js5 aJs5_98;

	@OriginalMember(owner = "client!vb", name = "a", descriptor = "(ILclient!fs;BIZII)V")
	public static void method5355(@OriginalArg(0) int arg0, @OriginalArg(1) Js5 arg1, @OriginalArg(3) int arg2, @OriginalArg(6) int arg3) {
		Static206.anInt3920 = arg0;
		Static27.anInt461 = 1;
		Static397.anInt742 = 0;
		Static14.anInt190 = arg3;
		Static236.aJs5_49 = arg1;
		Static19.aBoolean30 = false;
		Static47.anInt811 = Static56.aClass4_Sub15_Sub1_1.method1437() / arg2;
		if (Static47.anInt811 < 1) {
			Static47.anInt811 = 1;
		}
	}

	@OriginalMember(owner = "client!vb", name = "a", descriptor = "(IZIIIFII)[I")
	public static int[] method5356(@OriginalArg(5) float arg0) {
		@Pc(11) int[] local11 = new int[2048];
		@Pc(15) Node_Sub6_Sub10 local15 = new Node_Sub6_Sub10();
		local15.anInt2706 = 8;
		local15.anInt2707 = 35;
		local15.anInt2698 = 4;
		local15.aBoolean248 = true;
		local15.anInt2699 = 8;
		local15.anInt2702 = (int) (arg0 * 4096.0F);
		local15.method5509();
		Static286.method3974(1, 2048);
		local15.method2283(local11, 0);
		return local11;
	}

	@OriginalMember(owner = "client!vb", name = "a", descriptor = "(Ljava/lang/String;ILclient!iv;)I")
	public static int method5359(@OriginalArg(0) String arg0, @OriginalArg(2) Packet arg1) {
		@Pc(6) int local6 = arg1.pos;
		@Pc(12) byte[] local12 = CP1252StringTools.UTF8ToCP1252(arg0);
		arg1.pSmart1or2(local12.length);
		arg1.pos += Static339.aClass119_1.method2935(local12, arg1.pos, 0, arg1.data, local12.length);
		return arg1.pos - local6;
	}
}
