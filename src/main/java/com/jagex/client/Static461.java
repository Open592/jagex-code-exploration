package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static461 {

	@OriginalMember(owner = "client!nb", name = "a", descriptor = "(Lclient!fs;II)Lclient!nb;")
	public static ListNode_Sub30 method3724(@OriginalArg(0) Class76 arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		@Pc(5) byte[] local5 = arg0.method2104(arg2, arg1);
		return local5 == null ? null : new ListNode_Sub30(new Packet(local5));
	}
}
