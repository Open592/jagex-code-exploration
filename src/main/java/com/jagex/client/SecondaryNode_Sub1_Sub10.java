package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!hi")
public final class SecondaryNode_Sub1_Sub10 extends SecondaryNode {

	@OriginalMember(owner = "client!hi", name = "y", descriptor = "Lclient!dd;")
	public final Class16_Sub1_Sub2 aClass16_Sub1_Sub2_1;

	@OriginalMember(owner = "client!hi", name = "<init>", descriptor = "(Lclient!dd;)V")
	public SecondaryNode_Sub1_Sub10(@OriginalArg(0) Class16_Sub1_Sub2 arg0) {
		this.aClass16_Sub1_Sub2_1 = arg0;
	}
}
