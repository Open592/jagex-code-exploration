package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!lt")
public final class Class142 {

	@OriginalMember(owner = "client!lt", name = "f", descriptor = "Lclient!ac;")
	private SecondaryNode aClass4_Sub1_42 = new SecondaryNode();

	@OriginalMember(owner = "client!lt", name = "j", descriptor = "Lclient!tn;")
	private final SecondaryLinkedList aSecondaryLinkedList_3 = new SecondaryLinkedList();

	@OriginalMember(owner = "client!lt", name = "l", descriptor = "I")
	private final int anInt4442;

	@OriginalMember(owner = "client!lt", name = "k", descriptor = "I")
	private int anInt4441;

	@OriginalMember(owner = "client!lt", name = "m", descriptor = "Lclient!ib;")
	private final HashMap aLinkedHashMap_Iterator_19;

	@OriginalMember(owner = "client!lt", name = "<init>", descriptor = "(I)V")
	public Class142(@OriginalArg(0) int arg0) {
		this.anInt4442 = arg0;
		this.anInt4441 = arg0;
		@Pc(19) int local19;
		for (local19 = 1; arg0 > local19 + local19; local19 += local19) {
		}
		this.aLinkedHashMap_Iterator_19 = new HashMap(local19);
	}

	@OriginalMember(owner = "client!lt", name = "a", descriptor = "(JLclient!ac;I)V")
	public void method3480(@OriginalArg(0) long hashKey, @OriginalArg(1) SecondaryNode entry) {
		if (this.anInt4441 == 0) {
			@Pc(11) SecondaryNode local11 = this.aSecondaryLinkedList_3.popHead();
			local11.popSelf();
			local11.secondaryPopSelf();
			if (local11 == this.aClass4_Sub1_42) {
				local11 = this.aSecondaryLinkedList_3.popHead();
				local11.popSelf();
				local11.secondaryPopSelf();
			}
		} else {
			this.anInt4441--;
		}
		this.aLinkedHashMap_Iterator_19.set(hashKey, entry);
		this.aSecondaryLinkedList_3.insert(entry);
	}

	@OriginalMember(owner = "client!lt", name = "a", descriptor = "(JB)Lclient!ac;")
	public SecondaryNode method3483(@OriginalArg(0) long arg0) {
		@Pc(10) SecondaryNode local10 = (SecondaryNode) this.aLinkedHashMap_Iterator_19.get(arg0);
		if (local10 != null) {
			this.aSecondaryLinkedList_3.insert(local10);
		}
		return local10;
	}

	@OriginalMember(owner = "client!lt", name = "a", descriptor = "(B)V")
	public void method3484() {
		this.aSecondaryLinkedList_3.clear();
		this.aLinkedHashMap_Iterator_19.clear();
		this.aClass4_Sub1_42 = new SecondaryNode();
		this.anInt4441 = this.anInt4442;
	}
}
