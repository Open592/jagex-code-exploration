package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ou")
public final class Node_Sub35 extends Node {

	@OriginalMember(owner = "client!ou", name = "o", descriptor = "Ljava/lang/String;")
	public String aString51;

	@OriginalMember(owner = "client!ou", name = "<init>", descriptor = "()V")
	private Node_Sub35() {
	}

	@OriginalMember(owner = "client!ou", name = "<init>", descriptor = "(Ljava/lang/String;I)V")
	public Node_Sub35(@OriginalArg(0) String arg0, @OriginalArg(1) int arg1) {
		this.aString51 = arg0;
	}
}
