package com.jagex.client;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!os")
public abstract class Node_Sub5 extends Node {

	@OriginalMember(owner = "client!os", name = "c", descriptor = "(B)I")
	public abstract int method515();

	@OriginalMember(owner = "client!os", name = "d", descriptor = "(B)J")
	public abstract long method516();

	@OriginalMember(owner = "client!os", name = "c", descriptor = "(I)I")
	public abstract int method518();

	@OriginalMember(owner = "client!os", name = "e", descriptor = "(B)I")
	public abstract int method519();
}
