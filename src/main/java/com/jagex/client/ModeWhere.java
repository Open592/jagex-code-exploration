package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!sp")
public final class ModeWhere {

	@OriginalMember(owner = "client!sp", name = "a", descriptor = "I")
	public final int id;
	public final String name;

	@OriginalMember(owner = "client!sp", name = "<init>", descriptor = "(Ljava/lang/String;I)V")
	public ModeWhere(@OriginalArg(0) String name, @OriginalArg(1) int id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public int getId() {
		return this.id;
	}

	@OriginalMember(owner = "client!sp", name = "toString", descriptor = "()Ljava/lang/String;")
	@Override
	public String toString() {
		throw new IllegalStateException();
	}
}
