package com.jagex.client;

import com.jagex.client.env.ModeGame;
import com.jagex.client.js5.Js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!fp")
public final class Class75 {

	@OriginalMember(owner = "client!fp", name = "b", descriptor = "[I")
	public static final int[] anIntArray163 = new int[4096];

	@OriginalMember(owner = "client!fp", name = "f", descriptor = "Lclient!fa;")
	private final Class68 aClass68_11 = new Class68(64);

	@OriginalMember(owner = "client!fp", name = "a", descriptor = "Lclient!fs;")
	private final Js5 aJs5_28;

	static {
		for (@Pc(4) int local4 = 0; local4 < 4096; local4++) {
			anIntArray163[local4] = Static450.method5662(local4);
		}
	}

	@OriginalMember(owner = "client!fp", name = "<init>", descriptor = "(Lclient!jk;ILclient!fs;)V")
	public Class75(@OriginalArg(0) ModeGame arg0, @OriginalArg(1) int arg1, @OriginalArg(2) Js5 arg2) {
		this.aJs5_28 = arg2;
		this.aJs5_28.method2108(5);
	}

	@OriginalMember(owner = "client!fp", name = "a", descriptor = "(II)Lclient!an;")
	public SecondaryNode_Sub1_Sub2 method2079(@OriginalArg(1) int arg0) {
		@Pc(6) Class68 local6 = this.aClass68_11;
		@Pc(16) SecondaryNode_Sub1_Sub2 local16;
		synchronized (this.aClass68_11) {
			local16 = (SecondaryNode_Sub1_Sub2) this.aClass68_11.method1787((long) arg0);
		}
		if (local16 != null) {
			return local16;
		}
		@Pc(33) byte[] local33 = this.aJs5_28.method2104(arg0, 5);
		local16 = new SecondaryNode_Sub1_Sub2();
		if (local33 != null) {
			local16.method154(new Packet(local33));
		}
		@Pc(51) Class68 local51 = this.aClass68_11;
		synchronized (this.aClass68_11) {
			this.aClass68_11.method1779((long) arg0, local16);
			return local16;
		}
	}
}
