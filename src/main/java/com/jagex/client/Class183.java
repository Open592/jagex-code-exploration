package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!pk")
public final class Class183 {

	@OriginalMember(owner = "client!pk", name = "r", descriptor = "Lclient!vu;")
	private Node aNode_208;

	@OriginalMember(owner = "client!pk", name = "a", descriptor = "Lclient!vu;")
	public final Node aNode_207 = new Node();

	@OriginalMember(owner = "client!pk", name = "<init>", descriptor = "()V")
	public Class183() {
		this.aNode_207.aNode_261 = this.aNode_207;
		this.aNode_207.aNode_262 = this.aNode_207;
	}

	@OriginalMember(owner = "client!pk", name = "a", descriptor = "(ILclient!vu;)V")
	public void method4133(@OriginalArg(1) Node arg0) {
		if (arg0.aNode_261 != null) {
			arg0.method5684();
		}
		arg0.aNode_262 = this.aNode_207.aNode_262;
		arg0.aNode_261 = this.aNode_207;
		arg0.aNode_261.aNode_262 = arg0;
		arg0.aNode_262.aNode_261 = arg0;
	}

	@OriginalMember(owner = "client!pk", name = "a", descriptor = "(I)Lclient!vu;")
	public Node method4136() {
		@Pc(7) Node local7 = this.aNode_207.aNode_262;
		if (this.aNode_207 == local7) {
			return null;
		} else {
			local7.method5684();
			return local7;
		}
	}

	@OriginalMember(owner = "client!pk", name = "a", descriptor = "(ZLclient!vu;)V")
	public void method4137(@OriginalArg(1) Node arg0) {
		if (arg0.aNode_261 != null) {
			arg0.method5684();
		}
		arg0.aNode_262 = this.aNode_207;
		arg0.aNode_261 = this.aNode_207.aNode_261;
		arg0.aNode_261.aNode_262 = arg0;
		arg0.aNode_262.aNode_261 = arg0;
	}

	@OriginalMember(owner = "client!pk", name = "b", descriptor = "(I)V")
	public void method4138() {
		while (true) {
			@Pc(5) Node local5 = this.aNode_207.aNode_262;
			if (this.aNode_207 == local5) {
				this.aNode_208 = null;
				return;
			}
			local5.method5684();
		}
	}

	@OriginalMember(owner = "client!pk", name = "c", descriptor = "(I)Lclient!vu;")
	public Node method4139() {
		@Pc(12) Node local12 = this.aNode_207.aNode_261;
		if (this.aNode_207 == local12) {
			this.aNode_208 = null;
			return null;
		} else {
			this.aNode_208 = local12.aNode_261;
			return local12;
		}
	}

	@OriginalMember(owner = "client!pk", name = "d", descriptor = "(I)Lclient!vu;")
	public Node method4140() {
		@Pc(12) Node local12 = this.aNode_207.aNode_262;
		if (this.aNode_207 == local12) {
			this.aNode_208 = null;
			return null;
		} else {
			this.aNode_208 = local12.aNode_262;
			return local12;
		}
	}

	@OriginalMember(owner = "client!pk", name = "a", descriptor = "(Lclient!vu;ZLclient!pk;)V")
	private void method4141(@OriginalArg(0) Node arg0, @OriginalArg(2) Class183 arg1) {
		@Pc(7) Node local7 = this.aNode_207.aNode_261;
		this.aNode_207.aNode_261 = arg0.aNode_261;
		arg0.aNode_261.aNode_262 = this.aNode_207;
		if (arg0 != this.aNode_207) {
			arg0.aNode_261 = arg1.aNode_207.aNode_261;
			arg0.aNode_261.aNode_262 = arg0;
			arg1.aNode_207.aNode_261 = local7;
			local7.aNode_262 = arg1.aNode_207;
		}
	}

	@OriginalMember(owner = "client!pk", name = "b", descriptor = "(B)Lclient!vu;")
	public Node method4144() {
		@Pc(6) Node local6 = this.aNode_208;
		if (this.aNode_207 == local6) {
			this.aNode_208 = null;
			return null;
		} else {
			this.aNode_208 = local6.aNode_262;
			return local6;
		}
	}

	@OriginalMember(owner = "client!pk", name = "c", descriptor = "(B)Lclient!vu;")
	public Node method4145() {
		@Pc(6) Node local6 = this.aNode_208;
		if (this.aNode_207 == local6) {
			this.aNode_208 = null;
			return null;
		} else {
			this.aNode_208 = local6.aNode_261;
			return local6;
		}
	}

	@OriginalMember(owner = "client!pk", name = "d", descriptor = "(B)Z")
	public boolean method4147() {
		return this.aNode_207.aNode_262 == this.aNode_207;
	}

	@OriginalMember(owner = "client!pk", name = "e", descriptor = "(I)I")
	public int method4148() {
		@Pc(7) int local7 = 0;
		for (@Pc(11) Node local11 = this.aNode_207.aNode_262; local11 != this.aNode_207; local11 = local11.aNode_262) {
			local7++;
		}
		return local7;
	}

	@OriginalMember(owner = "client!pk", name = "a", descriptor = "(Lclient!pk;B)V")
	public void method4149(@OriginalArg(0) Class183 arg0) {
		this.method4141(this.aNode_207.aNode_262, arg0);
	}
}
