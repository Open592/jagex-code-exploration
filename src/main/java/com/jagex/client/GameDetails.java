package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!jk")
public final class GameDetails {

	@OriginalMember(owner = "client!jk", name = "h", descriptor = "Ljava/lang/String;")
	public final String name;

	@OriginalMember(owner = "client!jk", name = "c", descriptor = "I")
	public final int id;

	static {
		new Class83("Attempting to join channel...", "Chatraum wird betreten...", "Tentative de connexion au canal...", "Tentando acessar canal...");
	}

	@OriginalMember(owner = "client!jk", name = "<init>", descriptor = "(Ljava/lang/String;I)V")
	public GameDetails(@OriginalArg(0) String name, @OriginalArg(1) int id) {
		this.name = name;
		this.id = id;
	}

	@OriginalMember(owner = "client!jk", name = "toString", descriptor = "()Ljava/lang/String;")
	@Override
	public String toString() {
		throw new IllegalStateException();
	}
}
