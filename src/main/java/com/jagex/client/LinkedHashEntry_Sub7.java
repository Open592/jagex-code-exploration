package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!bm")
public final class LinkedHashEntry_Sub7 extends LinkedHashEntry {

	@OriginalMember(owner = "client!bm", name = "o", descriptor = "Ljava/lang/String;")
	public String aString12;

	@OriginalMember(owner = "client!bm", name = "<init>", descriptor = "()V")
	private LinkedHashEntry_Sub7() {
	}

	@OriginalMember(owner = "client!bm", name = "<init>", descriptor = "(Ljava/lang/String;)V")
	public LinkedHashEntry_Sub7(@OriginalArg(0) String arg0) {
		this.aString12 = arg0;
	}
}
