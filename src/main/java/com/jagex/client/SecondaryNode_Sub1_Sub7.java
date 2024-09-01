package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ep")
public final class SecondaryNode_Sub1_Sub7 extends SecondaryNode {

	@OriginalMember(owner = "client!ep", name = "G", descriptor = "Lclient!g;")
	public final Class16_Sub1_Sub3 aClass16_Sub1_Sub3_1;

	@OriginalMember(owner = "client!ep", name = "<init>", descriptor = "(Lclient!g;)V")
	public SecondaryNode_Sub1_Sub7(@OriginalArg(0) Class16_Sub1_Sub3 arg0) {
		this.aClass16_Sub1_Sub3_1 = arg0;
	}
}
