package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!lt")
public final class Class142 {

	@OriginalMember(owner = "client!lt", name = "f", descriptor = "Lclient!ac;")
	private ListNode_Sub1 aClass4_Sub1_42 = new ListNode_Sub1();

	@OriginalMember(owner = "client!lt", name = "j", descriptor = "Lclient!tn;")
	private final Class229 aClass229_3 = new Class229();

	@OriginalMember(owner = "client!lt", name = "l", descriptor = "I")
	private final int anInt4442;

	@OriginalMember(owner = "client!lt", name = "k", descriptor = "I")
	private int anInt4441;

	@OriginalMember(owner = "client!lt", name = "m", descriptor = "Lclient!ib;")
	private final IterableHashMap aIterableHashMap_19;

	@OriginalMember(owner = "client!lt", name = "<init>", descriptor = "(I)V")
	public Class142(@OriginalArg(0) int arg0) {
		this.anInt4442 = arg0;
		this.anInt4441 = arg0;
		@Pc(19) int local19;
		for (local19 = 1; arg0 > local19 + local19; local19 += local19) {
		}
		this.aIterableHashMap_19 = new IterableHashMap(local19);
	}

	@OriginalMember(owner = "client!lt", name = "a", descriptor = "(JLclient!ac;I)V")
	public void method3480(@OriginalArg(0) long arg0, @OriginalArg(1) ListNode_Sub1 arg1) {
		if (this.anInt4441 == 0) {
			@Pc(11) ListNode_Sub1 local11 = this.aClass229_3.method5091();
			local11.popSelf();
			local11.method4662();
			if (local11 == this.aClass4_Sub1_42) {
				local11 = this.aClass229_3.method5091();
				local11.popSelf();
				local11.method4662();
			}
		} else {
			this.anInt4441--;
		}
		this.aIterableHashMap_19.set(arg0, arg1);
		this.aClass229_3.method5088(arg1);
	}

	@OriginalMember(owner = "client!lt", name = "a", descriptor = "(JB)Lclient!ac;")
	public ListNode_Sub1 method3483(@OriginalArg(0) long arg0) {
		@Pc(10) ListNode_Sub1 local10 = (ListNode_Sub1) this.aIterableHashMap_19.get(arg0);
		if (local10 != null) {
			this.aClass229_3.method5088(local10);
		}
		return local10;
	}

	@OriginalMember(owner = "client!lt", name = "a", descriptor = "(B)V")
	public void method3484() {
		this.aClass229_3.method5087();
		this.aIterableHashMap_19.clear();
		this.aClass4_Sub1_42 = new ListNode_Sub1();
		this.anInt4441 = this.anInt4442;
	}
}
