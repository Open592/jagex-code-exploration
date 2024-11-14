package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static397 {

	@OriginalMember(owner = "client!ua", name = "o", descriptor = "I")
	public static int anInt742;

	@OriginalMember(owner = "client!ua", name = "q", descriptor = "[I")
	public static final int[] anIntArray45 = new int[256];

	@OriginalMember(owner = "client!ua", name = "r", descriptor = "Lclient!gk;")
	public static final LocalizedString A_LOCALIZED_STRING___21 = new LocalizedString("Members object", "Gegenstand für Mitglieder", "Objet d'abonnés", "Objeto para membros");

	@OriginalMember(owner = "client!ua", name = "v", descriptor = "[Lclient!pt;")
	public static final SecondaryNode_Sub1_Sub17[] aClass4_Sub1_Sub17Array6 = new SecondaryNode_Sub1_Sub17[14];

	@OriginalMember(owner = "client!ua", name = "a", descriptor = "(III)Z")
	public static boolean method723(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
		return (arg1 & 0x70000) != 0 | Static245.method3594(arg0, arg1) || Static273.method3914(arg0, arg1);
	}

	@OriginalMember(owner = "client!ua", name = "a", descriptor = "(IB)V")
	public static void method724() {
		Static27.anInt461 = 1;
		Static47.anInt811 = 2;
		Static14.anInt190 = -1;
		Static206.anInt3920 = 0;
		Static236.aJs5_49 = null;
		anInt742 = -1;
		Static19.aBoolean30 = false;
	}

	@OriginalMember(owner = "client!ua", name = "a", descriptor = "(BII)Z")
	public static boolean method726(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
		return (arg1 & 0x180) != 0;
	}
}
