package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static61 {

	@OriginalMember(owner = "client!cu", name = "i", descriptor = "S")
	public static short aShort13 = 320;

	@OriginalMember(owner = "client!cu", name = "n", descriptor = "Lclient!gk;")
	public static final LocalizedString A_LOCALIZED_STRING___30 = new LocalizedString("Loaded client variable data", "Client-Variablen geladen", "Variables du client chargées", "As variáveis do sistema foram carregadas");

	@OriginalMember(owner = "client!cu", name = "A", descriptor = "[I")
	public static final int[] anIntArray65 = new int[5];

	@OriginalMember(owner = "client!cu", name = "a", descriptor = "(ILclient!iv;)Lclient!gu;")
	public static Class27_Sub2 method994(@OriginalArg(1) Packet arg0) {
		return new Class27_Sub2(arg0.g2s(), arg0.g2s(), arg0.g2s(), arg0.g2s(), arg0.g3(), arg0.g1());
	}
}
