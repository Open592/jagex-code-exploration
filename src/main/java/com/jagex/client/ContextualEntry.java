package com.jagex.client;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ac")
public class ContextualEntry extends LinkedEntry {

	@OriginalMember(owner = "client!ac", name = "o", descriptor = "J")
	public long context;

	@OriginalMember(owner = "client!ac", name = "r", descriptor = "Lclient!ac;")
	public ContextualEntry previousContext;

	@OriginalMember(owner = "client!ac", name = "s", descriptor = "Lclient!ac;")
	public ContextualEntry nextContext;

	@OriginalMember(owner = "client!ac", name = "c", descriptor = "(B)V")
	public final void popContextEntry() {
		if (this.nextContext != null) {
			this.nextContext.previousContext = this.previousContext;
			this.previousContext.nextContext = this.nextContext;
			this.previousContext = null;
			this.nextContext = null;
		}
	}

	@OriginalMember(owner = "client!ac", name = "a", descriptor = "(Z)Z")
	public final boolean hasNextContext() {
		return this.nextContext != null;
	}
}
