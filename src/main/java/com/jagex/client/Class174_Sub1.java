package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!or")
public final class Class174_Sub1 extends Class174 {

	@OriginalMember(owner = "client!or", name = "a", descriptor = "(ILclient!fq;)Lclient!fq;")
	@Override
	public LinkedEntry_Sub1_Sub8 method4040(@OriginalArg(1) LinkedEntry_Sub1_Sub8 arg0) {
		return new LinkedEntry_Sub1_Sub8_Sub2(arg0.method3885(), arg0.anInt5084);
	}
}
