package com.jagex.client;

import com.jagex.client.js5.Js5;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static357 {

	@OriginalMember(owner = "client!sd", name = "h", descriptor = "Lclient!fs;")
	public static Js5 aJs5_82;

	@OriginalMember(owner = "client!sd", name = "t", descriptor = "I")
	public static int anInt6240 = 0;

	@OriginalMember(owner = "client!sd", name = "b", descriptor = "(I)V")
	public static void method4846() {
		@Pc(5) Class68 local5 = Static442.aClass68_58;
		synchronized (Static442.aClass68_58) {
			Static442.aClass68_58.method1777();
		}
		local5 = Static190.aClass68_20;
		synchronized (Static190.aClass68_20) {
			Static190.aClass68_20.method1777();
		}
	}
}
