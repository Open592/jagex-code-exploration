package com.jagex.client;

import com.jagex.client.env.ModeGame;
import com.jagex.client.js5.Js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!qq")
public final class Class197 {

	@OriginalMember(owner = "client!qq", name = "e", descriptor = "Lclient!fs;")
	private final Js5 aJs5_74;

	@OriginalMember(owner = "client!qq", name = "g", descriptor = "I")
	public final int anInt5738;

	@OriginalMember(owner = "client!qq", name = "<init>", descriptor = "(Lclient!jk;ILclient!fs;)V")
	public Class197(@OriginalArg(0) ModeGame arg0, @OriginalArg(1) int arg1, @OriginalArg(2) Js5 arg2) {
		new Class68(64);
		this.aJs5_74 = arg2;
		this.anInt5738 = this.aJs5_74.method2108(15);
	}
}
