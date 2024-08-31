package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!tn")
public final class Class229 {

	@OriginalMember(owner = "client!tn", name = "k", descriptor = "Lclient!ac;")
	private ContextualEntry aClass4_Sub1_58;

	@OriginalMember(owner = "client!tn", name = "d", descriptor = "Lclient!ac;")
	private final ContextualEntry aClass4_Sub1_57 = new ContextualEntry();

	@OriginalMember(owner = "client!tn", name = "<init>", descriptor = "()V")
	public Class229() {
		this.aClass4_Sub1_57.nextContext = this.aClass4_Sub1_57;
		this.aClass4_Sub1_57.previousContext = this.aClass4_Sub1_57;
	}

	@OriginalMember(owner = "client!tn", name = "a", descriptor = "(B)V")
	public void method5087() {
		while (true) {
			@Pc(5) ContextualEntry local5 = this.aClass4_Sub1_57.previousContext;
			if (this.aClass4_Sub1_57 == local5) {
				this.aClass4_Sub1_58 = null;
				return;
			}
			local5.popContextEntry();
		}
	}

	@OriginalMember(owner = "client!tn", name = "a", descriptor = "(ILclient!ac;)V")
	public void method5088(@OriginalArg(1) ContextualEntry arg0) {
		if (arg0.nextContext != null) {
			arg0.popContextEntry();
		}
		arg0.previousContext = this.aClass4_Sub1_57;
		arg0.nextContext = this.aClass4_Sub1_57.nextContext;
		arg0.nextContext.previousContext = arg0;
		arg0.previousContext.nextContext = arg0;
	}

	@OriginalMember(owner = "client!tn", name = "b", descriptor = "(B)Lclient!ac;")
	public ContextualEntry method5089() {
		@Pc(12) ContextualEntry local12 = this.aClass4_Sub1_57.previousContext;
		if (local12 == this.aClass4_Sub1_57) {
			this.aClass4_Sub1_58 = null;
			return null;
		} else {
			this.aClass4_Sub1_58 = local12.previousContext;
			return local12;
		}
	}

	@OriginalMember(owner = "client!tn", name = "c", descriptor = "(B)Lclient!ac;")
	public ContextualEntry method5091() {
		@Pc(7) ContextualEntry local7 = this.aClass4_Sub1_57.previousContext;
		if (this.aClass4_Sub1_57 == local7) {
			return null;
		} else {
			local7.popContextEntry();
			return local7;
		}
	}

	@OriginalMember(owner = "client!tn", name = "b", descriptor = "(Z)Lclient!ac;")
	public ContextualEntry method5092() {
		@Pc(11) ContextualEntry local11 = this.aClass4_Sub1_58;
		if (this.aClass4_Sub1_57 == local11) {
			this.aClass4_Sub1_58 = null;
			return null;
		} else {
			this.aClass4_Sub1_58 = local11.previousContext;
			return local11;
		}
	}

	@OriginalMember(owner = "client!tn", name = "c", descriptor = "(Z)I")
	public int method5093() {
		@Pc(13) int local13 = 0;
		@Pc(17) ContextualEntry local17 = this.aClass4_Sub1_57.previousContext;
		while (local17 != this.aClass4_Sub1_57) {
			local17 = local17.previousContext;
			local13++;
		}
		return local13;
	}
}
