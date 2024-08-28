package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!pk")
public final class Class183 {

	@OriginalMember(owner = "client!pk", name = "r", descriptor = "Lclient!vu;")
	private ListNode aListNode_208;

	@OriginalMember(owner = "client!pk", name = "a", descriptor = "Lclient!vu;")
	public final ListNode aListNode_207 = new ListNode();

	@OriginalMember(owner = "client!pk", name = "<init>", descriptor = "()V")
	public Class183() {
		this.aListNode_207.next = this.aListNode_207;
		this.aListNode_207.previous = this.aListNode_207;
	}

	@OriginalMember(owner = "client!pk", name = "a", descriptor = "(ILclient!vu;)V")
	public void method4133(@OriginalArg(1) ListNode arg0) {
		if (arg0.next != null) {
			arg0.popSelf();
		}
		arg0.previous = this.aListNode_207.previous;
		arg0.next = this.aListNode_207;
		arg0.next.previous = arg0;
		arg0.previous.next = arg0;
	}

	@OriginalMember(owner = "client!pk", name = "a", descriptor = "(I)Lclient!vu;")
	public ListNode method4136() {
		@Pc(7) ListNode local7 = this.aListNode_207.previous;
		if (this.aListNode_207 == local7) {
			return null;
		} else {
			local7.popSelf();
			return local7;
		}
	}

	@OriginalMember(owner = "client!pk", name = "a", descriptor = "(ZLclient!vu;)V")
	public void method4137(@OriginalArg(1) ListNode arg0) {
		if (arg0.next != null) {
			arg0.popSelf();
		}
		arg0.previous = this.aListNode_207;
		arg0.next = this.aListNode_207.next;
		arg0.next.previous = arg0;
		arg0.previous.next = arg0;
	}

	@OriginalMember(owner = "client!pk", name = "b", descriptor = "(I)V")
	public void method4138() {
		while (true) {
			@Pc(5) ListNode local5 = this.aListNode_207.previous;
			if (this.aListNode_207 == local5) {
				this.aListNode_208 = null;
				return;
			}
			local5.popSelf();
		}
	}

	@OriginalMember(owner = "client!pk", name = "c", descriptor = "(I)Lclient!vu;")
	public ListNode method4139() {
		@Pc(12) ListNode local12 = this.aListNode_207.next;
		if (this.aListNode_207 == local12) {
			this.aListNode_208 = null;
			return null;
		} else {
			this.aListNode_208 = local12.next;
			return local12;
		}
	}

	@OriginalMember(owner = "client!pk", name = "d", descriptor = "(I)Lclient!vu;")
	public ListNode method4140() {
		@Pc(12) ListNode local12 = this.aListNode_207.previous;
		if (this.aListNode_207 == local12) {
			this.aListNode_208 = null;
			return null;
		} else {
			this.aListNode_208 = local12.previous;
			return local12;
		}
	}

	@OriginalMember(owner = "client!pk", name = "a", descriptor = "(Lclient!vu;ZLclient!pk;)V")
	private void method4141(@OriginalArg(0) ListNode arg0, @OriginalArg(2) Class183 arg1) {
		@Pc(7) ListNode local7 = this.aListNode_207.next;
		this.aListNode_207.next = arg0.next;
		arg0.next.previous = this.aListNode_207;
		if (arg0 != this.aListNode_207) {
			arg0.next = arg1.aListNode_207.next;
			arg0.next.previous = arg0;
			arg1.aListNode_207.next = local7;
			local7.previous = arg1.aListNode_207;
		}
	}

	@OriginalMember(owner = "client!pk", name = "b", descriptor = "(B)Lclient!vu;")
	public ListNode method4144() {
		@Pc(6) ListNode local6 = this.aListNode_208;
		if (this.aListNode_207 == local6) {
			this.aListNode_208 = null;
			return null;
		} else {
			this.aListNode_208 = local6.previous;
			return local6;
		}
	}

	@OriginalMember(owner = "client!pk", name = "c", descriptor = "(B)Lclient!vu;")
	public ListNode method4145() {
		@Pc(6) ListNode local6 = this.aListNode_208;
		if (this.aListNode_207 == local6) {
			this.aListNode_208 = null;
			return null;
		} else {
			this.aListNode_208 = local6.next;
			return local6;
		}
	}

	@OriginalMember(owner = "client!pk", name = "d", descriptor = "(B)Z")
	public boolean method4147() {
		return this.aListNode_207.previous == this.aListNode_207;
	}

	@OriginalMember(owner = "client!pk", name = "e", descriptor = "(I)I")
	public int method4148() {
		@Pc(7) int local7 = 0;
		for (@Pc(11) ListNode local11 = this.aListNode_207.previous; local11 != this.aListNode_207; local11 = local11.previous) {
			local7++;
		}
		return local7;
	}

	@OriginalMember(owner = "client!pk", name = "a", descriptor = "(Lclient!pk;B)V")
	public void method4149(@OriginalArg(0) Class183 arg0) {
		this.method4141(this.aListNode_207.previous, arg0);
	}
}
