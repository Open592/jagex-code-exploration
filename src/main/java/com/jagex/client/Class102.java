package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ib")
public final class Class102 {

	@OriginalMember(owner = "client!ib", name = "m", descriptor = "Lclient!vu;")
	private Node aNode_121;

	@OriginalMember(owner = "client!ib", name = "n", descriptor = "J")
	private long aLong111;

	@OriginalMember(owner = "client!ib", name = "s", descriptor = "Lclient!vu;")
	private Node aNode_122;

	@OriginalMember(owner = "client!ib", name = "r", descriptor = "I")
	private int anInt3171 = 0;

	@OriginalMember(owner = "client!ib", name = "d", descriptor = "[Lclient!vu;")
	public final Node[] aNodeArray1;

	@OriginalMember(owner = "client!ib", name = "a", descriptor = "I")
	public final int anInt3159;

	@OriginalMember(owner = "client!ib", name = "<init>", descriptor = "(I)V")
	public Class102(@OriginalArg(0) int arg0) {
		this.aNodeArray1 = new Node[arg0];
		this.anInt3159 = arg0;
		for (@Pc(13) int local13 = 0; local13 < arg0; local13++) {
			@Pc(23) Node local23 = this.aNodeArray1[local13] = new Node();
			local23.aNode_262 = local23;
			local23.aNode_261 = local23;
		}
	}

	@OriginalMember(owner = "client!ib", name = "a", descriptor = "(I)Lclient!vu;")
	public Node method2697() {
		if (this.aNode_121 == null) {
			return null;
		}
		@Pc(23) Node local23 = this.aNodeArray1[(int) ((long) (this.anInt3159 - 1) & this.aLong111)];
		while (local23 != this.aNode_121) {
			if (this.aLong111 == this.aNode_121.aLong224) {
				@Pc(35) Node local35 = this.aNode_121;
				this.aNode_121 = this.aNode_121.aNode_262;
				return local35;
			}
			this.aNode_121 = this.aNode_121.aNode_262;
		}
		this.aNode_121 = null;
		return null;
	}

	@OriginalMember(owner = "client!ib", name = "b", descriptor = "(I)I")
	public int method2698() {
		@Pc(7) int local7 = 0;
		for (@Pc(9) int local9 = 0; local9 < this.anInt3159; local9++) {
			@Pc(16) Node local16 = this.aNodeArray1[local9];
			@Pc(19) Node local19 = local16.aNode_262;
			while (local16 != local19) {
				local19 = local19.aNode_262;
				local7++;
			}
		}
		return local7;
	}

	@OriginalMember(owner = "client!ib", name = "c", descriptor = "(I)V")
	public void method2699() {
		for (@Pc(3) int local3 = 0; local3 < this.anInt3159; local3++) {
			@Pc(10) Node local10 = this.aNodeArray1[local3];
			while (true) {
				@Pc(13) Node local13 = local10.aNode_262;
				if (local13 == local10) {
					break;
				}
				local13.method5684();
			}
		}
		this.aNode_121 = null;
		this.aNode_122 = null;
	}

	@OriginalMember(owner = "client!ib", name = "a", descriptor = "(JI)Lclient!vu;")
	public Node method2700(@OriginalArg(0) long arg0) {
		this.aLong111 = arg0;
		@Pc(20) Node local20 = this.aNodeArray1[(int) (arg0 & (long) (this.anInt3159 - 1))];
		for (this.aNode_121 = local20.aNode_262; this.aNode_121 != local20; this.aNode_121 = this.aNode_121.aNode_262) {
			if (arg0 == this.aNode_121.aLong224) {
				@Pc(35) Node local35 = this.aNode_121;
				this.aNode_121 = this.aNode_121.aNode_262;
				return local35;
			}
		}
		this.aNode_121 = null;
		return null;
	}

	@OriginalMember(owner = "client!ib", name = "a", descriptor = "(JILclient!vu;)V")
	public void method2703(@OriginalArg(0) long arg0, @OriginalArg(2) Node arg1) {
		if (arg1.aNode_261 != null) {
			arg1.method5684();
		}
		@Pc(26) Node local26 = this.aNodeArray1[(int) (arg0 & (long) (this.anInt3159 - 1))];
		arg1.aNode_262 = local26;
		arg1.aNode_261 = local26.aNode_261;
		arg1.aNode_261.aNode_262 = arg1;
		arg1.aLong224 = arg0;
		arg1.aNode_262.aNode_261 = arg1;
	}

	@OriginalMember(owner = "client!ib", name = "b", descriptor = "(B)Lclient!vu;")
	public Node method2704() {
		@Pc(24) Node local24;
		if (this.anInt3171 > 0 && this.aNode_122 != this.aNodeArray1[this.anInt3171 - 1]) {
			local24 = this.aNode_122;
			this.aNode_122 = local24.aNode_262;
			return local24;
		}
		while (this.anInt3171 < this.anInt3159) {
			local24 = this.aNodeArray1[this.anInt3171++].aNode_262;
			if (this.aNodeArray1[this.anInt3171 - 1] != local24) {
				this.aNode_122 = local24.aNode_262;
				return local24;
			}
		}
		return null;
	}

	@OriginalMember(owner = "client!ib", name = "c", descriptor = "(B)Lclient!vu;")
	public Node method2705() {
		this.anInt3171 = 0;
		return this.method2704();
	}

	@OriginalMember(owner = "client!ib", name = "d", descriptor = "(I)I")
	public int method2706() {
		return this.anInt3159;
	}

	@OriginalMember(owner = "client!ib", name = "a", descriptor = "(I[Lclient!vu;)I")
	public int method2708(@OriginalArg(1) Node[] arg0) {
		@Pc(15) int local15 = 0;
		for (@Pc(17) int local17 = 0; local17 < this.anInt3159; local17++) {
			@Pc(24) Node local24 = this.aNodeArray1[local17];
			for (@Pc(27) Node local27 = local24.aNode_262; local27 != local24; local27 = local27.aNode_262) {
				arg0[local15++] = local27;
			}
		}
		return local15;
	}
}
