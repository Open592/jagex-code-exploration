package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!sq")
public final class Class220 {

	@OriginalMember(owner = "client!sq", name = "o", descriptor = "Lclient!tn;")
	private final SecondaryLinkedList aSecondaryLinkedList_5 = new SecondaryLinkedList();

	@OriginalMember(owner = "client!sq", name = "p", descriptor = "I")
	private int anInt6338;

	@OriginalMember(owner = "client!sq", name = "k", descriptor = "I")
	private final int anInt6334;

	@OriginalMember(owner = "client!sq", name = "d", descriptor = "Lclient!ib;")
	private final HashMap aHashMap_37;

	@OriginalMember(owner = "client!sq", name = "<init>", descriptor = "(I)V")
	public Class220(@OriginalArg(0) int arg0) {
		this.anInt6338 = arg0;
		this.anInt6334 = arg0;
		@Pc(16) int local16;
		for (local16 = 1; local16 + local16 < arg0; local16 += local16) {
		}
		this.aHashMap_37 = new HashMap(local16);
	}

	@OriginalMember(owner = "client!sq", name = "a", descriptor = "(ILclient!bq;)V")
	private void method4943(@OriginalArg(1) Interface2 arg0) {
		@Pc(9) long local9 = arg0.method3685();
		for (@Pc(16) SecondaryNode_Sub1_Sub9 local16 = (SecondaryNode_Sub1_Sub9) this.aHashMap_37.get(local9); local16 != null; local16 = (SecondaryNode_Sub1_Sub9) this.aHashMap_37.nextFoundNode()) {
			if (local16.anInterface2_3.method3684(arg0)) {
				this.method4945(local16);
				return;
			}
		}
	}

	@OriginalMember(owner = "client!sq", name = "a", descriptor = "(I)I")
	public int method4944() {
		return this.anInt6338;
	}

	@OriginalMember(owner = "client!sq", name = "a", descriptor = "(Lclient!mh;I)V")
	private void method4945(@OriginalArg(0) SecondaryNode_Sub1_Sub9 arg0) {
		if (arg0 != null) {
			arg0.popSelf();
			arg0.secondaryPopSelf();
			this.anInt6338 += arg0.anInt3025;
		}
	}

	@OriginalMember(owner = "client!sq", name = "a", descriptor = "(Lclient!bq;I)Ljava/lang/Object;")
	public Object method4946(@OriginalArg(0) Interface2 arg0) {
		@Pc(9) long local9 = arg0.method3685();
		for (@Pc(23) SecondaryNode_Sub1_Sub9 local23 = (SecondaryNode_Sub1_Sub9) this.aHashMap_37.get(local9); local23 != null; local23 = (SecondaryNode_Sub1_Sub9) this.aHashMap_37.nextFoundNode()) {
			if (local23.anInterface2_3.method3684(arg0)) {
				@Pc(37) Object local37 = local23.method2571();
				if (local37 != null) {
					if (local23.method2567()) {
						@Pc(66) SecondaryNode_Sub1_Sub9_Sub2 local66 = new SecondaryNode_Sub1_Sub9_Sub2(arg0, local37, local23.anInt3025);
						this.aHashMap_37.set(local23.hashKey, local66);
						this.aSecondaryLinkedList_5.insert(local66);
						local66.secondaryValue = 0L;
						local23.popSelf();
						local23.secondaryPopSelf();
					} else {
						this.aSecondaryLinkedList_5.insert(local23);
						local23.secondaryValue = 0L;
					}
					return local37;
				}
				local23.popSelf();
				local23.secondaryPopSelf();
				this.anInt6338 += local23.anInt3025;
			}
		}
		return null;
	}

	@OriginalMember(owner = "client!sq", name = "b", descriptor = "(II)V")
	public void method4950() {
		if (Static224.aClass105_1 == null) {
			return;
		}
		for (@Pc(21) SecondaryNode_Sub1_Sub9 local21 = (SecondaryNode_Sub1_Sub9) this.aSecondaryLinkedList_5.getHead(); local21 != null; local21 = (SecondaryNode_Sub1_Sub9) this.aSecondaryLinkedList_5.next()) {
			if (local21.method2567()) {
				if (local21.method2571() == null) {
					local21.popSelf();
					local21.secondaryPopSelf();
					this.anInt6338 += local21.anInt3025;
				}
			} else if (++local21.secondaryValue > (long) 5) {
				@Pc(47) SecondaryNode_Sub1_Sub9 local47 = Static224.aClass105_1.method5276(local21);
				this.aHashMap_37.set(local21.hashKey, local47);
				SecondaryLinkedList.insertAfter(local21, local47);
				local21.popSelf();
				local21.secondaryPopSelf();
			}
		}
	}

	@OriginalMember(owner = "client!sq", name = "a", descriptor = "(Z)V")
	public void method4951() {
		this.aSecondaryLinkedList_5.clear();
		this.aHashMap_37.clear();
		this.anInt6338 = this.anInt6334;
	}

	@OriginalMember(owner = "client!sq", name = "c", descriptor = "(I)V")
	public void method4952() {
		for (@Pc(5) SecondaryNode_Sub1_Sub9 local5 = (SecondaryNode_Sub1_Sub9) this.aSecondaryLinkedList_5.getHead(); local5 != null; local5 = (SecondaryNode_Sub1_Sub9) this.aSecondaryLinkedList_5.next()) {
			if (local5.method2567()) {
				local5.popSelf();
				local5.secondaryPopSelf();
				this.anInt6338 += local5.anInt3025;
			}
		}
	}

	@OriginalMember(owner = "client!sq", name = "a", descriptor = "(ILjava/lang/Object;Lclient!bq;)V")
	public void method4953(@OriginalArg(1) Object arg0, @OriginalArg(2) Interface2 arg1) {
		this.method4955(arg1, arg0);
	}

	@OriginalMember(owner = "client!sq", name = "a", descriptor = "(B)I")
	public int method4954() {
		return this.anInt6334;
	}

	@OriginalMember(owner = "client!sq", name = "a", descriptor = "(Lclient!bq;Ljava/lang/Object;ZI)V")
	private void method4955(@OriginalArg(0) Interface2 arg0, @OriginalArg(1) Object arg1) {
		if (this.anInt6334 < 1) {
			throw new IllegalStateException("s>cs");
		}
		this.method4943(arg0);
		this.anInt6338--;
		while (this.anInt6338 < 0) {
			@Pc(36) SecondaryNode_Sub1_Sub9 local36 = (SecondaryNode_Sub1_Sub9) this.aSecondaryLinkedList_5.popHead();
			this.method4945(local36);
		}
		@Pc(59) SecondaryNode_Sub1_Sub9_Sub2 local59 = new SecondaryNode_Sub1_Sub9_Sub2(arg0, arg1, 1);
		this.aHashMap_37.set(arg0.method3685(), local59);
		this.aSecondaryLinkedList_5.insert(local59);
		local59.secondaryValue = 0L;
	}
}
