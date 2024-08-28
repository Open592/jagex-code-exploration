package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ib")
public final class Class102 {

	@OriginalMember(owner = "client!ib", name = "m", descriptor = "Lclient!vu;")
	private ListNode aListNode_121;

	@OriginalMember(owner = "client!ib", name = "n", descriptor = "J")
	private long aLong111;

	@OriginalMember(owner = "client!ib", name = "s", descriptor = "Lclient!vu;")
	private ListNode aListNode_122;

	@OriginalMember(owner = "client!ib", name = "r", descriptor = "I")
	private int anInt3171 = 0;

	@OriginalMember(owner = "client!ib", name = "d", descriptor = "[Lclient!vu;")
	public final ListNode[] aListNodeArray1;

	@OriginalMember(owner = "client!ib", name = "a", descriptor = "I")
	public final int anInt3159;

	@OriginalMember(owner = "client!ib", name = "<init>", descriptor = "(I)V")
	public Class102(@OriginalArg(0) int arg0) {
		this.aListNodeArray1 = new ListNode[arg0];
		this.anInt3159 = arg0;
		for (@Pc(13) int local13 = 0; local13 < arg0; local13++) {
			@Pc(23) ListNode local23 = this.aListNodeArray1[local13] = new ListNode();
			local23.previous = local23;
			local23.next = local23;
		}
	}

	@OriginalMember(owner = "client!ib", name = "a", descriptor = "(I)Lclient!vu;")
	public ListNode method2697() {
		if (this.aListNode_121 == null) {
			return null;
		}
		@Pc(23) ListNode local23 = this.aListNodeArray1[(int) ((long) (this.anInt3159 - 1) & this.aLong111)];
		while (local23 != this.aListNode_121) {
			if (this.aLong111 == this.aListNode_121.id) {
				@Pc(35) ListNode local35 = this.aListNode_121;
				this.aListNode_121 = this.aListNode_121.previous;
				return local35;
			}
			this.aListNode_121 = this.aListNode_121.previous;
		}
		this.aListNode_121 = null;
		return null;
	}

	@OriginalMember(owner = "client!ib", name = "b", descriptor = "(I)I")
	public int method2698() {
		@Pc(7) int local7 = 0;
		for (@Pc(9) int local9 = 0; local9 < this.anInt3159; local9++) {
			@Pc(16) ListNode local16 = this.aListNodeArray1[local9];
			@Pc(19) ListNode local19 = local16.previous;
			while (local16 != local19) {
				local19 = local19.previous;
				local7++;
			}
		}
		return local7;
	}

	@OriginalMember(owner = "client!ib", name = "c", descriptor = "(I)V")
	public void method2699() {
		for (@Pc(3) int local3 = 0; local3 < this.anInt3159; local3++) {
			@Pc(10) ListNode local10 = this.aListNodeArray1[local3];
			while (true) {
				@Pc(13) ListNode local13 = local10.previous;
				if (local13 == local10) {
					break;
				}
				local13.popSelf();
			}
		}
		this.aListNode_121 = null;
		this.aListNode_122 = null;
	}

	@OriginalMember(owner = "client!ib", name = "a", descriptor = "(JI)Lclient!vu;")
	public ListNode method2700(@OriginalArg(0) long arg0) {
		this.aLong111 = arg0;
		@Pc(20) ListNode local20 = this.aListNodeArray1[(int) (arg0 & (long) (this.anInt3159 - 1))];
		for (this.aListNode_121 = local20.previous; this.aListNode_121 != local20; this.aListNode_121 = this.aListNode_121.previous) {
			if (arg0 == this.aListNode_121.id) {
				@Pc(35) ListNode local35 = this.aListNode_121;
				this.aListNode_121 = this.aListNode_121.previous;
				return local35;
			}
		}
		this.aListNode_121 = null;
		return null;
	}

	@OriginalMember(owner = "client!ib", name = "a", descriptor = "(JILclient!vu;)V")
	public void method2703(@OriginalArg(0) long arg0, @OriginalArg(2) ListNode arg1) {
		if (arg1.next != null) {
			arg1.popSelf();
		}
		@Pc(26) ListNode local26 = this.aListNodeArray1[(int) (arg0 & (long) (this.anInt3159 - 1))];
		arg1.previous = local26;
		arg1.next = local26.next;
		arg1.next.previous = arg1;
		arg1.id = arg0;
		arg1.previous.next = arg1;
	}

	@OriginalMember(owner = "client!ib", name = "b", descriptor = "(B)Lclient!vu;")
	public ListNode method2704() {
		@Pc(24) ListNode local24;
		if (this.anInt3171 > 0 && this.aListNode_122 != this.aListNodeArray1[this.anInt3171 - 1]) {
			local24 = this.aListNode_122;
			this.aListNode_122 = local24.previous;
			return local24;
		}
		while (this.anInt3171 < this.anInt3159) {
			local24 = this.aListNodeArray1[this.anInt3171++].previous;
			if (this.aListNodeArray1[this.anInt3171 - 1] != local24) {
				this.aListNode_122 = local24.previous;
				return local24;
			}
		}
		return null;
	}

	@OriginalMember(owner = "client!ib", name = "c", descriptor = "(B)Lclient!vu;")
	public ListNode method2705() {
		this.anInt3171 = 0;
		return this.method2704();
	}

	@OriginalMember(owner = "client!ib", name = "d", descriptor = "(I)I")
	public int method2706() {
		return this.anInt3159;
	}

	@OriginalMember(owner = "client!ib", name = "a", descriptor = "(I[Lclient!vu;)I")
	public int method2708(@OriginalArg(1) ListNode[] arg0) {
		@Pc(15) int local15 = 0;
		for (@Pc(17) int local17 = 0; local17 < this.anInt3159; local17++) {
			@Pc(24) ListNode local24 = this.aListNodeArray1[local17];
			for (@Pc(27) ListNode local27 = local24.previous; local27 != local24; local27 = local27.previous) {
				arg0[local15++] = local27;
			}
		}
		return local15;
	}
}
