package com.jagex.client;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!je")
public final class JS5NetRequest extends SecondaryNode_Sub1_Sub6 {

	@OriginalMember(owner = "client!je", name = "I", descriptor = "Lclient!iv;")
	public Packet packet;

	@OriginalMember(owner = "client!je", name = "J", descriptor = "I")
	public int anInt3510;

	@OriginalMember(owner = "client!je", name = "L", descriptor = "B")
	public byte aByte24;

	@OriginalMember(owner = "client!je", name = "a", descriptor = "(I)I")
	@Override
	public int method3342() {
		return this.packet == null ? 0 : this.packet.pos * 100 / (this.packet.data.length - this.aByte24);
	}

	@OriginalMember(owner = "client!je", name = "b", descriptor = "(Z)[B")
	@Override
	public byte[] getResponseData() {
		if (super.isRequestInProgress || this.packet.pos < this.packet.data.length - this.aByte24) {
			throw new RuntimeException();
		}

		return this.packet.data;
	}
}
