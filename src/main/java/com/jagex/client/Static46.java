package com.jagex.client;

import java.awt.Container;
import java.awt.Insets;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static46 {

	@OriginalMember(owner = "client!cc", name = "f", descriptor = "I")
	public static int anInt5156;

	@OriginalMember(owner = "client!cc", name = "g", descriptor = "Lclient!fs;")
	public static Class76 aClass76_54;

	@OriginalMember(owner = "client!cc", name = "d", descriptor = "Lclient!ho;")
	public static final Class98 aClass98_11 = new Class98(6, 0, 4, 2);

	@OriginalMember(owner = "client!cc", name = "a", descriptor = "(Z)V")
	public static void method3938() {
		if (Static320.aFrame3 != null) {
			return;
		}
		@Pc(13) Container local13;
		if (Static226.aFrame1 == null) {
			local13 = Static206.signLink.hostApplet;
		} else {
			local13 = Static226.aFrame1;
		}
		Static425.anInt7000 = local13.getSize().width;
		Static17.anInt222 = local13.getSize().height;
		@Pc(31) Insets local31;
		if (Static226.aFrame1 == local13) {
			local31 = Static226.aFrame1.getInsets();
			Static425.anInt7000 -= local31.left + local31.right;
			Static17.anInt222 -= local31.bottom + local31.top;
		}
		if (Static450.method5664() == 1) {
			Static302.height = Static157.height;
			Static141.width = Static353.width;
			Static230.xPOS = (Static425.anInt7000 - Static353.width) / 2;
			Static303.yPOS = 0;
		} else if (Static70.anInt1503 < 96 && Static177.anInt2973 == 0) {
			@Pc(100) int local100 = Static425.anInt7000 > 1024 ? 1024 : Static425.anInt7000;
			Static141.width = local100;
			@Pc(109) int local109 = Static17.anInt222 <= 768 ? Static17.anInt222 : 768;
			Static230.xPOS = (Static425.anInt7000 - local100) / 2;
			Static302.height = local109;
			Static303.yPOS = 0;
		} else {
			Static302.height = Static17.anInt222;
			Static141.width = Static425.anInt7000;
			Static303.yPOS = 0;
			Static230.xPOS = 0;
		}
		if (Static104.modewhere != Static373.liveModeWhere) {
			@Pc(132) boolean local132;
			if (Static141.width < 1024 && Static302.height < 768) {
				local132 = true;
			} else {
				local132 = false;
			}
		}
		Static273.aCanvas5.setSize(Static141.width, Static302.height);
		if (Static122.aClass19_16 != null) {
			Static122.aClass19_16.method4272(Static273.aCanvas5);
		}
		if (local13 == Static226.aFrame1) {
			local31 = Static226.aFrame1.getInsets();
			Static273.aCanvas5.setLocation(Static230.xPOS + local31.left, local31.top - -Static303.yPOS);
		} else {
			Static273.aCanvas5.setLocation(Static230.xPOS, Static303.yPOS);
		}
		if (Static334.anInt5766 != -1) {
			Static327.method4422(true);
		}
		Static348.method4697();
	}
}
