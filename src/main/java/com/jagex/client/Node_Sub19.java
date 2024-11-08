package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!fr")
public final class Node_Sub19 extends Node {

	@OriginalMember(owner = "client!fr", name = "m", descriptor = "[B")
	public final byte[] aByteArray24;

	static {
		new LocalizedString("Invalid channel name entered!", "Ungültiger Chatraum-Name angegeben.", "Nom de canal incorrect !", "Nome de canal inválido!");
	}

	@OriginalMember(owner = "client!fr", name = "<init>", descriptor = "([B)V")
	public Node_Sub19(@OriginalArg(0) byte[] arg0) {
		this.aByteArray24 = arg0;
	}
}
