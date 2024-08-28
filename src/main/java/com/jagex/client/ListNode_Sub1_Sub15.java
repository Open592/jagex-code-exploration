package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!mb")
public final class ListNode_Sub1_Sub15 extends ListNode_Sub1 {

	@OriginalMember(owner = "client!mb", name = "F", descriptor = "[B")
	public final byte[] aByteArray57;

	@OriginalMember(owner = "client!mb", name = "<init>", descriptor = "([B)V")
	public ListNode_Sub1_Sub15(@OriginalArg(0) byte[] arg0) {
		this.aByteArray57 = arg0;
	}
}
