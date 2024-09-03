package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!jc")
public final class ModeWhat {

	@OriginalMember(owner = "client!jc", name = "b", descriptor = "I")
	private final int id;
	private final String name;

	@OriginalMember(owner = "client!jc", name = "<init>", descriptor = "(Ljava/lang/String;I)V")
	public ModeWhat(@OriginalArg(0) String name, @OriginalArg(1) int id) {
		this.name = name;
		this.id = id;
	}

	@OriginalMember(owner = "client!jc", name = "toString", descriptor = "()Ljava/lang/String;")
	@Override
	public String toString() {
		throw new IllegalStateException();
	}

	public String getName() {
		return this.name;
	}

	@OriginalMember(owner = "client!jc", name = "a", descriptor = "(Z)I")
	public int getId() {
		return this.id;
	}
}
