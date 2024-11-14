package com.jagex.client;

import java.net.URL;

import com.jagex.client.js5.Js5;
import com.jagex.signlink.Message;
import com.jagex.signlink.SignLink;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static197 {

	@OriginalMember(owner = "client!ju", name = "H", descriptor = "Lclient!cn;")
	public static SecondaryNode_Sub1_Sub5 aClass4_Sub1_Sub5_2;

	@OriginalMember(owner = "client!ju", name = "K", descriptor = "Lclient!fs;")
	public static Js5 aJs5_45;

	@OriginalMember(owner = "client!ju", name = "I", descriptor = "Lclient!sl;")
	public static final Class215 aClass215_39 = new Class215(32, -1);

	@OriginalMember(owner = "client!ju", name = "a", descriptor = "(Lclient!et;ILjava/lang/String;I)Lclient!qt;")
	public static Message method3110(@OriginalArg(0) SignLink signLink, @OriginalArg(1) int arg1, @OriginalArg(2) String url) {
		if (arg1 == 0) {
			return signLink.emitOpenURLInBrowserMessage(url);
		}
		@Pc(44) Message message;
		if (arg1 == 1) {
			try {
				Static458.callJavaScriptMethod(signLink.hostApplet, "openjs", new Object[] { (new URL(signLink.hostApplet.getCodeBase(), url)).toString() });
				message = new Message();
				message.status = 1;
				return message;
			} catch (@Pc(50) Throwable e) {
				message = new Message();
				message.status = 2;
				return message;
			}
		} else if (arg1 == 2) {
			try {
				signLink.hostApplet.getAppletContext().showDocument(new URL(signLink.hostApplet.getCodeBase(), url), "_blank");
				message = new Message();
				message.status = 1;
				return message;
			} catch (@Pc(86) Exception local86) {
				message = new Message();
				message.status = 2;
				return message;
			}
		} else if (arg1 == 3) {
			try {
				Static458.callJavaScriptMethod(signLink.hostApplet, "loggedout");
			} catch (@Pc(106) Throwable ignored) {
			}
			try {
				signLink.hostApplet.getAppletContext().showDocument(new URL(signLink.hostApplet.getCodeBase(), url), "_top");
				message = new Message();
				message.status = 1;
				return message;
			} catch (@Pc(128) Exception e) {
				message = new Message();
				message.status = 2;
				return message;
			}
		} else {
			throw new IllegalArgumentException();
		}
	}

	@OriginalMember(owner = "client!ju", name = "a", descriptor = "(Lclient!qc;)V")
	public static void method3111(@OriginalArg(0) Class191 arg0) {
		if (Static43.anInt7322 >= 65535) {
			return;
		}
		@Pc(6) Node_Sub21 local6 = arg0.aClass4_Sub21_2;
		Static106.aClass191Array1[Static43.anInt7322] = arg0;
		Static124.aBooleanArray12[Static43.anInt7322] = false;
		Static43.anInt7322++;
		@Pc(21) int local21 = arg0.anInt5570;
		if (arg0.aBoolean500) {
			local21 = 0;
		}
		@Pc(29) int local29 = arg0.anInt5570;
		if (arg0.aBoolean499) {
			local29 = Static235.anInt4487 - 1;
		}
		for (@Pc(38) int local38 = local21; local38 <= local29; local38++) {
			@Pc(41) int local41 = 0;
			@Pc(53) int local53 = local6.method3164() + Static333.anInt5747 - local6.method3165() >> Static231.anInt4434;
			if (local53 < 0) {
				local41 = -local53;
				local53 = 0;
			}
			@Pc(73) int local73 = local6.method3164() + local6.method3165() - Static333.anInt5747 >> Static231.anInt4434;
			if (local73 >= Static171.anInt3361) {
				local73 = Static171.anInt3361 - 1;
			}
			for (@Pc(82) int local82 = local53; local82 <= local73; local82++) {
				@Pc(89) short local89 = arg0.aShortArray189[local41++];
				@Pc(105) int local105 = (local6.method3160() + Static333.anInt5747 - local6.method3165() >> Static231.anInt4434) + (local89 >>> 8);
				@Pc(113) int local113 = local105 + (local89 & 0xFF) - 1;
				if (local105 < 0) {
					local105 = 0;
				}
				if (local113 >= Static422.anInt6945) {
					local113 = Static422.anInt6945 - 1;
				}
				for (@Pc(126) int local126 = local105; local126 <= local113; local126++) {
					@Pc(135) long local135 = Static444.aLongArrayArrayArray2[local38][local126][local82];
					if ((local135 & 0xFFFFL) == 0L) {
						Static444.aLongArrayArrayArray2[local38][local126][local82] = local135 | (long) Static43.anInt7322;
					} else if ((local135 & 0xFFFF0000L) == 0L) {
						Static444.aLongArrayArrayArray2[local38][local126][local82] = local135 | (long) Static43.anInt7322 << 16;
					} else if ((local135 & 0xFFFF00000000L) == 0L) {
						Static444.aLongArrayArrayArray2[local38][local126][local82] = local135 | (long) Static43.anInt7322 << 32;
					} else if ((local135 & 0xFFFF000000000000L) == 0L) {
						Static444.aLongArrayArrayArray2[local38][local126][local82] = local135 | (long) Static43.anInt7322 << 48;
					}
				}
			}
		}
	}
}
