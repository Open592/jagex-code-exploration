package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!po")
public final class ListNode_Sub37 extends ListNode {

	@OriginalMember(owner = "client!po", name = "p", descriptor = "I")
	public int anInt5426;

	@OriginalMember(owner = "client!po", name = "<init>", descriptor = "()V")
	private ListNode_Sub37() {
	}

	@OriginalMember(owner = "client!po", name = "<init>", descriptor = "(I)V")
	public ListNode_Sub37(@OriginalArg(0) int arg0) {
		this.anInt5426 = arg0;
	}
}