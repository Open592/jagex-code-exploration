package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!bs")
public final class Class28 {

	@OriginalMember(owner = "client!bs", name = "a", descriptor = "I")
	public int anInt658;

	@OriginalMember(owner = "client!bs", name = "c", descriptor = "I")
	public int anInt660;

	@OriginalMember(owner = "client!bs", name = "f", descriptor = "I")
	public int anInt663;

	@OriginalMember(owner = "client!bs", name = "g", descriptor = "I")
	public int anInt664;

	@OriginalMember(owner = "client!bs", name = "m", descriptor = "B")
	private byte aByte11;

	@OriginalMember(owner = "client!bs", name = "n", descriptor = "I")
	public int anInt669;

	@OriginalMember(owner = "client!bs", name = "<init>", descriptor = "()V")
	public Class28() {
	}

	@OriginalMember(owner = "client!bs", name = "<init>", descriptor = "(Lclient!iv;)V")
	public Class28(@OriginalArg(0) Packet arg0) {
		this.aByte11 = arg0.g1s();
		this.anInt660 = arg0.g2();
		this.anInt663 = arg0.g4();
		this.anInt664 = arg0.g4();
		this.anInt658 = arg0.g4();
		this.anInt669 = arg0.g4();
	}

	@OriginalMember(owner = "client!bs", name = "a", descriptor = "(B)I")
	public int method667() {
		return this.aByte11 & 0x7;
	}

	@OriginalMember(owner = "client!bs", name = "b", descriptor = "(B)I")
	public int method668() {
		return (this.aByte11 & 0x8) == 8 ? 1 : 0;
	}
}
