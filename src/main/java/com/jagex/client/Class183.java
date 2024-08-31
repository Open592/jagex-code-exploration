package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!pk")
public final class Class183 {

	@OriginalMember(owner = "client!pk", name = "r", descriptor = "Lclient!vu;")
	private LinkedEntry aLinkedEntry_208;

	@OriginalMember(owner = "client!pk", name = "a", descriptor = "Lclient!vu;")
	public final LinkedEntry aLinkedEntry_207 = new LinkedEntry();

	@OriginalMember(owner = "client!pk", name = "<init>", descriptor = "()V")
	public Class183() {
		this.aLinkedEntry_207.next = this.aLinkedEntry_207;
		this.aLinkedEntry_207.previous = this.aLinkedEntry_207;
	}

	@OriginalMember(owner = "client!pk", name = "a", descriptor = "(ILclient!vu;)V")
	public void method4133(@OriginalArg(1) LinkedEntry arg0) {
		if (arg0.next != null) {
			arg0.popSelf();
		}
		arg0.previous = this.aLinkedEntry_207.previous;
		arg0.next = this.aLinkedEntry_207;
		arg0.next.previous = arg0;
		arg0.previous.next = arg0;
	}

	@OriginalMember(owner = "client!pk", name = "a", descriptor = "(I)Lclient!vu;")
	public LinkedEntry method4136() {
		@Pc(7) LinkedEntry local7 = this.aLinkedEntry_207.previous;
		if (this.aLinkedEntry_207 == local7) {
			return null;
		} else {
			local7.popSelf();
			return local7;
		}
	}

	@OriginalMember(owner = "client!pk", name = "a", descriptor = "(ZLclient!vu;)V")
	public void method4137(@OriginalArg(1) LinkedEntry arg0) {
		if (arg0.next != null) {
			arg0.popSelf();
		}
		arg0.previous = this.aLinkedEntry_207;
		arg0.next = this.aLinkedEntry_207.next;
		arg0.next.previous = arg0;
		arg0.previous.next = arg0;
	}

	@OriginalMember(owner = "client!pk", name = "b", descriptor = "(I)V")
	public void method4138() {
		while (true) {
			@Pc(5) LinkedEntry local5 = this.aLinkedEntry_207.previous;
			if (this.aLinkedEntry_207 == local5) {
				this.aLinkedEntry_208 = null;
				return;
			}
			local5.popSelf();
		}
	}

	@OriginalMember(owner = "client!pk", name = "c", descriptor = "(I)Lclient!vu;")
	public LinkedEntry method4139() {
		@Pc(12) LinkedEntry local12 = this.aLinkedEntry_207.next;
		if (this.aLinkedEntry_207 == local12) {
			this.aLinkedEntry_208 = null;
			return null;
		} else {
			this.aLinkedEntry_208 = local12.next;
			return local12;
		}
	}

	@OriginalMember(owner = "client!pk", name = "d", descriptor = "(I)Lclient!vu;")
	public LinkedEntry method4140() {
		@Pc(12) LinkedEntry local12 = this.aLinkedEntry_207.previous;
		if (this.aLinkedEntry_207 == local12) {
			this.aLinkedEntry_208 = null;
			return null;
		} else {
			this.aLinkedEntry_208 = local12.previous;
			return local12;
		}
	}

	@OriginalMember(owner = "client!pk", name = "a", descriptor = "(Lclient!vu;ZLclient!pk;)V")
	private void method4141(@OriginalArg(0) LinkedEntry arg0, @OriginalArg(2) Class183 arg1) {
		@Pc(7) LinkedEntry local7 = this.aLinkedEntry_207.next;
		this.aLinkedEntry_207.next = arg0.next;
		arg0.next.previous = this.aLinkedEntry_207;
		if (arg0 != this.aLinkedEntry_207) {
			arg0.next = arg1.aLinkedEntry_207.next;
			arg0.next.previous = arg0;
			arg1.aLinkedEntry_207.next = local7;
			local7.previous = arg1.aLinkedEntry_207;
		}
	}

	@OriginalMember(owner = "client!pk", name = "b", descriptor = "(B)Lclient!vu;")
	public LinkedEntry method4144() {
		@Pc(6) LinkedEntry local6 = this.aLinkedEntry_208;
		if (this.aLinkedEntry_207 == local6) {
			this.aLinkedEntry_208 = null;
			return null;
		} else {
			this.aLinkedEntry_208 = local6.previous;
			return local6;
		}
	}

	@OriginalMember(owner = "client!pk", name = "c", descriptor = "(B)Lclient!vu;")
	public LinkedEntry method4145() {
		@Pc(6) LinkedEntry local6 = this.aLinkedEntry_208;
		if (this.aLinkedEntry_207 == local6) {
			this.aLinkedEntry_208 = null;
			return null;
		} else {
			this.aLinkedEntry_208 = local6.next;
			return local6;
		}
	}

	@OriginalMember(owner = "client!pk", name = "d", descriptor = "(B)Z")
	public boolean method4147() {
		return this.aLinkedEntry_207.previous == this.aLinkedEntry_207;
	}

	@OriginalMember(owner = "client!pk", name = "e", descriptor = "(I)I")
	public int method4148() {
		@Pc(7) int local7 = 0;
		for (@Pc(11) LinkedEntry local11 = this.aLinkedEntry_207.previous; local11 != this.aLinkedEntry_207; local11 = local11.previous) {
			local7++;
		}
		return local7;
	}

	@OriginalMember(owner = "client!pk", name = "a", descriptor = "(Lclient!pk;B)V")
	public void method4149(@OriginalArg(0) Class183 arg0) {
		this.method4141(this.aLinkedEntry_207.previous, arg0);
	}
}
