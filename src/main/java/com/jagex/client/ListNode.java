package com.jagex.client;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!vu")
public class ListNode {

	@OriginalMember(owner = "client!vu", name = "b", descriptor = "Lclient!vu;")
	public ListNode aListNode_261;

	@OriginalMember(owner = "client!vu", name = "d", descriptor = "J")
	public long aLong224;

	@OriginalMember(owner = "client!vu", name = "h", descriptor = "Lclient!vu;")
	public ListNode aListNode_262;

	@OriginalMember(owner = "client!vu", name = "b", descriptor = "(I)Z")
	public final boolean method5683() {
		return this.aListNode_261 != null;
	}

	@OriginalMember(owner = "client!vu", name = "b", descriptor = "(B)V")
	public final void method5684() {
		if (this.aListNode_261 != null) {
			this.aListNode_261.aListNode_262 = this.aListNode_262;
			this.aListNode_262.aListNode_261 = this.aListNode_261;
			this.aListNode_262 = null;
			this.aListNode_261 = null;
		}
	}
}
