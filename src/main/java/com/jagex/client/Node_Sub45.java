package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!wt")
public final class Node_Sub45 extends Node {

	@OriginalMember(owner = "client!wt", name = "m", descriptor = "I")
	public int anInt7356;

	@OriginalMember(owner = "client!wt", name = "l", descriptor = "I")
	public final int anInt7355;

	@OriginalMember(owner = "client!wt", name = "<init>", descriptor = "(II)V")
	public Node_Sub45(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		this.anInt7356 = arg1;
		this.anInt7355 = arg0;
	}
}
