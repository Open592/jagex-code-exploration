package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!tn")
public final class Class229 {

	@OriginalMember(owner = "client!tn", name = "k", descriptor = "Lclient!ac;")
	private SecondaryNode aClass4_Sub1_58;

	@OriginalMember(owner = "client!tn", name = "d", descriptor = "Lclient!ac;")
	private final SecondaryNode aClass4_Sub1_57 = new SecondaryNode();

	@OriginalMember(owner = "client!tn", name = "<init>", descriptor = "()V")
	public Class229() {
		this.aClass4_Sub1_57.secondaryNext = this.aClass4_Sub1_57;
		this.aClass4_Sub1_57.secondaryPrevious = this.aClass4_Sub1_57;
	}

	@OriginalMember(owner = "client!tn", name = "a", descriptor = "(B)V")
	public void method5087() {
		while (true) {
			@Pc(5) SecondaryNode local5 = this.aClass4_Sub1_57.secondaryPrevious;
			if (this.aClass4_Sub1_57 == local5) {
				this.aClass4_Sub1_58 = null;
				return;
			}
			local5.secondaryPopSelf();
		}
	}

	@OriginalMember(owner = "client!tn", name = "a", descriptor = "(ILclient!ac;)V")
	public void method5088(@OriginalArg(1) SecondaryNode arg0) {
		if (arg0.secondaryNext != null) {
			arg0.secondaryPopSelf();
		}
		arg0.secondaryPrevious = this.aClass4_Sub1_57;
		arg0.secondaryNext = this.aClass4_Sub1_57.secondaryNext;
		arg0.secondaryNext.secondaryPrevious = arg0;
		arg0.secondaryPrevious.secondaryNext = arg0;
	}

	@OriginalMember(owner = "client!tn", name = "b", descriptor = "(B)Lclient!ac;")
	public SecondaryNode method5089() {
		@Pc(12) SecondaryNode local12 = this.aClass4_Sub1_57.secondaryPrevious;
		if (local12 == this.aClass4_Sub1_57) {
			this.aClass4_Sub1_58 = null;
			return null;
		} else {
			this.aClass4_Sub1_58 = local12.secondaryPrevious;
			return local12;
		}
	}

	@OriginalMember(owner = "client!tn", name = "c", descriptor = "(B)Lclient!ac;")
	public SecondaryNode method5091() {
		@Pc(7) SecondaryNode local7 = this.aClass4_Sub1_57.secondaryPrevious;
		if (this.aClass4_Sub1_57 == local7) {
			return null;
		} else {
			local7.secondaryPopSelf();
			return local7;
		}
	}

	@OriginalMember(owner = "client!tn", name = "b", descriptor = "(Z)Lclient!ac;")
	public SecondaryNode method5092() {
		@Pc(11) SecondaryNode local11 = this.aClass4_Sub1_58;
		if (this.aClass4_Sub1_57 == local11) {
			this.aClass4_Sub1_58 = null;
			return null;
		} else {
			this.aClass4_Sub1_58 = local11.secondaryPrevious;
			return local11;
		}
	}

	@OriginalMember(owner = "client!tn", name = "c", descriptor = "(Z)I")
	public int method5093() {
		@Pc(13) int local13 = 0;
		@Pc(17) SecondaryNode local17 = this.aClass4_Sub1_57.secondaryPrevious;
		while (local17 != this.aClass4_Sub1_57) {
			local17 = local17.secondaryPrevious;
			local13++;
		}
		return local13;
	}
}
