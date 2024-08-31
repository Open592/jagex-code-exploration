package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!hu")
public final class Class100 {

	@OriginalMember(owner = "client!hu", name = "b", descriptor = "J")
	private long aLong110;

	@OriginalMember(owner = "client!hu", name = "c", descriptor = "Lclient!ac;")
	private ContextualEntry aClass4_Sub1_31;

	@OriginalMember(owner = "client!hu", name = "g", descriptor = "[Lclient!ac;")
	private final ContextualEntry[] aClass4_Sub1Array1;

	@OriginalMember(owner = "client!hu", name = "i", descriptor = "I")
	private final int anInt3143;

	@OriginalMember(owner = "client!hu", name = "<init>", descriptor = "(I)V")
	public Class100(@OriginalArg(0) int arg0) {
		this.aClass4_Sub1Array1 = new ContextualEntry[arg0];
		this.anInt3143 = arg0;
		for (@Pc(10) int local10 = 0; local10 < arg0; local10++) {
			@Pc(20) ContextualEntry local20 = this.aClass4_Sub1Array1[local10] = new ContextualEntry();
			local20.previousContext = local20;
			local20.nextContext = local20;
		}
	}

	@OriginalMember(owner = "client!hu", name = "a", descriptor = "(Z)Lclient!ac;")
	public ContextualEntry method2670() {
		if (this.aClass4_Sub1_31 == null) {
			return null;
		}
		@Pc(23) ContextualEntry local23 = this.aClass4_Sub1Array1[(int) ((long) (this.anInt3143 - 1) & this.aLong110)];
		while (this.aClass4_Sub1_31 != local23) {
			if (this.aClass4_Sub1_31.context == this.aLong110) {
				@Pc(35) ContextualEntry local35 = this.aClass4_Sub1_31;
				this.aClass4_Sub1_31 = this.aClass4_Sub1_31.previousContext;
				return local35;
			}
			this.aClass4_Sub1_31 = this.aClass4_Sub1_31.previousContext;
		}
		this.aClass4_Sub1_31 = null;
		return null;
	}

	@OriginalMember(owner = "client!hu", name = "a", descriptor = "(JI)Lclient!ac;")
	public ContextualEntry method2671(@OriginalArg(0) long arg0) {
		this.aLong110 = arg0;
		@Pc(20) ContextualEntry local20 = this.aClass4_Sub1Array1[(int) (arg0 & (long) (this.anInt3143 - 1))];
		for (this.aClass4_Sub1_31 = local20.previousContext; this.aClass4_Sub1_31 != local20; this.aClass4_Sub1_31 = this.aClass4_Sub1_31.previousContext) {
			if (this.aClass4_Sub1_31.context == arg0) {
				@Pc(39) ContextualEntry local39 = this.aClass4_Sub1_31;
				this.aClass4_Sub1_31 = this.aClass4_Sub1_31.previousContext;
				return local39;
			}
		}
		this.aClass4_Sub1_31 = null;
		return null;
	}

	@OriginalMember(owner = "client!hu", name = "a", descriptor = "(BLclient!ac;J)V")
	public void method2674(@OriginalArg(1) ContextualEntry arg0, @OriginalArg(2) long arg1) {
		if (arg0.nextContext != null) {
			arg0.popContextEntry();
		}
		@Pc(21) ContextualEntry local21 = this.aClass4_Sub1Array1[(int) (arg1 & (long) (this.anInt3143 - 1))];
		arg0.previousContext = local21;
		arg0.nextContext = local21.nextContext;
		arg0.nextContext.previousContext = arg0;
		arg0.context = arg1;
		arg0.previousContext.nextContext = arg0;
	}
}
