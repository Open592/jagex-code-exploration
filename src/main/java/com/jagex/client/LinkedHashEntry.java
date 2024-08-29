package com.jagex.client;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!vu")
public class LinkedHashEntry {

	@OriginalMember(owner = "client!vu", name = "b", descriptor = "Lclient!vu;")
	public LinkedHashEntry next;

	@OriginalMember(owner = "client!vu", name = "h", descriptor = "Lclient!vu;")
	public LinkedHashEntry previous;

	@OriginalMember(owner = "client!vu", name = "d", descriptor = "J")
	public long hashKey;

	@OriginalMember(owner = "client!vu", name = "b", descriptor = "(I)Z")
	public final boolean hasNext() {
		return this.next != null;
	}

	@OriginalMember(owner = "client!vu", name = "b", descriptor = "(B)V")
	public final void popSelf() {
		if (this.next != null) {
			this.next.previous = this.previous;
			this.previous.next = this.next;

			this.previous = null;
			this.next = null;
		}
	}
}
