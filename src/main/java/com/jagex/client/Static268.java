package com.jagex.client;

import org.openrs2.deob.annotation.OriginalMember;

public final class Static268 {

	@OriginalMember(owner = "client!nm", name = "e", descriptor = "I")
	public static int anInt4991 = 0;

	@OriginalMember(owner = "client!nm", name = "p", descriptor = "I")
	public static int anInt4998 = 0;

	@OriginalMember(owner = "client!nm", name = "s", descriptor = "Lclient!gk;")
	public static final Class83 aClass83_104 = new Class83("RuneScape is loading - please wait...", "RuneScape wird geladen - bitte warten...", "Chargement de RuneScape en cours - veuillez patienter...", "RuneScape carregando. Aguarde...");

	@OriginalMember(owner = "client!nm", name = "A", descriptor = "I")
	public static int anInt5006 = 1;

	@OriginalMember(owner = "client!nm", name = "b", descriptor = "(B)[Lclient!jc;")
	public static ModeWhat[] method3834() {
		return new ModeWhat[] { Static183.liveModeWhat, Static346.RCModeWhat, Static65.WIPModeWhat};
	}
}
