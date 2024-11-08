package com.jagex.client;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ec")
public abstract class SecondaryNode_Sub1_Sub6 extends SecondaryNode {

	@OriginalMember(owner = "client!ec", name = "z", descriptor = "Z")
	public boolean aBoolean382;

	@OriginalMember(owner = "client!ec", name = "C", descriptor = "Z")
	public boolean isUrgent;

	@OriginalMember(owner = "client!ec", name = "y", descriptor = "Z")
	public volatile boolean isRequestInProgress = true;

	@OriginalMember(owner = "client!ec", name = "a", descriptor = "(I)I")
	public abstract int method3342();

	@OriginalMember(owner = "client!ec", name = "b", descriptor = "(Z)[B")
	public abstract byte[] getResponseData();
}
