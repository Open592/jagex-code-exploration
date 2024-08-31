package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!an")
public final class ContextualEntry_Sub1_Sub2 extends ContextualEntry {

	@OriginalMember(owner = "client!an", name = "H", descriptor = "I")
	public int anInt207 = 0;

	@OriginalMember(owner = "client!an", name = "a", descriptor = "(ILclient!iv;)V")
	public void method154(@OriginalArg(1) Packet arg0) {
		while (true) {
			@Pc(16) int local16 = arg0.g1();
			if (local16 == 0) {
				return;
			}
			this.method159(local16, arg0);
		}
	}

	@OriginalMember(owner = "client!an", name = "a", descriptor = "(IILclient!iv;)V")
	private void method159(@OriginalArg(0) int arg0, @OriginalArg(2) Packet arg1) {
		if (arg0 == 2) {
			this.anInt207 = arg1.g2();
		}
	}
}
