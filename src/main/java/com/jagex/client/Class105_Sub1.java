package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!us")
public final class Class105_Sub1 extends Class105 {

	@OriginalMember(owner = "client!us", name = "a", descriptor = "(Lclient!mh;I)Lclient!mh;")
	@Override
	public ContextualEntry_Sub1_Sub9 method5276(@OriginalArg(0) ContextualEntry_Sub1_Sub9 arg0) {
		return new ContextualEntry_Sub1_Sub9_(arg0.anInterface2_3, arg0.method2571(), arg0.anInt3025);
	}
}
