package com.jagex.client;

import com.jagex.client.js5.Js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!oj")
public final class Class171 {

	@OriginalMember(owner = "client!oj", name = "j", descriptor = "Lclient!ib;")
	private final HashMap aHashMap_25 = new HashMap(256);

	@OriginalMember(owner = "client!oj", name = "o", descriptor = "Lclient!ib;")
	private final HashMap aHashMap_26 = new HashMap(256);

	@OriginalMember(owner = "client!oj", name = "b", descriptor = "Lclient!fs;")
	private final Js5 aJs5_56;

	@OriginalMember(owner = "client!oj", name = "i", descriptor = "Lclient!fs;")
	private final Js5 aJs5_57;

	@OriginalMember(owner = "client!oj", name = "<init>", descriptor = "(Lclient!fs;Lclient!fs;)V")
	public Class171(@OriginalArg(0) Js5 arg0, @OriginalArg(1) Js5 arg1) {
		this.aJs5_56 = arg1;
		this.aJs5_57 = arg0;
	}

	@OriginalMember(owner = "client!oj", name = "a", descriptor = "(III[I)Lclient!js;")
	private Node_Sub4_Sub1 method3970(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int[] arg2) {
		@Pc(15) int local15 = (arg0 << 4 & 0xFFF4 | arg0 >>> 12) ^ arg1;
		@Pc(21) int local21 = local15 | arg0 << 16;
		@Pc(24) long local24 = (long) local21;
		@Pc(31) Node_Sub4_Sub1 local31 = (Node_Sub4_Sub1) this.aHashMap_26.get(local24);
		if (local31 != null) {
			return local31;
		} else if (arg2 == null || arg2[0] > 0) {
			@Pc(54) Class241 local54 = Static464.method5244(this.aJs5_57, arg0, arg1);
			if (local54 == null) {
				return null;
			}
			local31 = local54.method5245();
			this.aHashMap_26.set(local24, local31);
			if (arg2 != null) {
				arg2[0] -= local31.aByteArray48.length;
			}
			return local31;
		} else {
			return null;
		}
	}

	@OriginalMember(owner = "client!oj", name = "a", descriptor = "(I[IBI)Lclient!js;")
	private Node_Sub4_Sub1 method3972(@OriginalArg(0) int arg0, @OriginalArg(1) int[] arg1, @OriginalArg(3) int arg2) {
		@Pc(15) int local15 = arg2 ^ (arg0 << 4 & 0xFFF2 | arg0 >>> 12);
		@Pc(26) int local26 = local15 | arg0 << 16;
		@Pc(31) long local31 = (long) local26 ^ 0x100000000L;
		@Pc(38) Node_Sub4_Sub1 local38 = (Node_Sub4_Sub1) this.aHashMap_26.get(local31);
		if (local38 != null) {
			return local38;
		} else if (arg1 == null || arg1[0] > 0) {
			@Pc(57) Node_Sub13 local57 = (Node_Sub13) this.aHashMap_25.get(local31);
			if (local57 == null) {
				local57 = Static68.method1318(this.aJs5_56, arg0, arg2);
				if (local57 == null) {
					return null;
				}
				this.aHashMap_25.set(local31, local57);
			}
			local38 = local57.method1322(arg1);
			if (local38 == null) {
				return null;
			} else {
				local57.popSelf();
				this.aHashMap_26.set(local31, local38);
				return local38;
			}
		} else {
			return null;
		}
	}

	@OriginalMember(owner = "client!oj", name = "a", descriptor = "([III)Lclient!js;")
	public Node_Sub4_Sub1 method3973(@OriginalArg(0) int[] arg0, @OriginalArg(1) int arg1) {
		if (this.aJs5_56.method2100() == 1) {
			return this.method3972(0, arg0, arg1);
		} else if (this.aJs5_56.method2108(arg1) == 1) {
			return this.method3972(arg1, arg0, 0);
		} else {
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!oj", name = "b", descriptor = "([III)Lclient!js;")
	public Node_Sub4_Sub1 method3976(@OriginalArg(0) int[] arg0, @OriginalArg(2) int arg1) {
		if (this.aJs5_57.method2100() == 1) {
			return this.method3970(0, arg1, arg0);
		} else if (this.aJs5_57.method2108(arg1) == 1) {
			return this.method3970(arg1, 0, arg0);
		} else {
			throw new RuntimeException();
		}
	}
}
