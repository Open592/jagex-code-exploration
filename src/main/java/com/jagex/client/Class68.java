package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!fa")
public final class Class68 {

	@OriginalMember(owner = "client!fa", name = "k", descriptor = "Lclient!tn;")
	private final SecondaryLinkedList aSecondaryLinkedList_2 = new SecondaryLinkedList();

	@OriginalMember(owner = "client!fa", name = "l", descriptor = "I")
	private int anInt2034;

	@OriginalMember(owner = "client!fa", name = "f", descriptor = "I")
	private final int anInt2029;

	@OriginalMember(owner = "client!fa", name = "o", descriptor = "Lclient!ib;")
	private final HashMap aHashMap_10;

	@OriginalMember(owner = "client!fa", name = "<init>", descriptor = "(I)V")
	public Class68(@OriginalArg(0) int arg0) {
		this.anInt2034 = arg0;
		this.anInt2029 = arg0;
		@Pc(14) int local14;
		for (local14 = 1; arg0 > local14 + local14; local14 += local14) {
		}
		this.aHashMap_10 = new HashMap(local14);
	}

	@OriginalMember(owner = "client!fa", name = "a", descriptor = "(Z)V")
	public void method1777() {
		this.aSecondaryLinkedList_2.clear();
		this.aHashMap_10.clear();
		this.anInt2034 = this.anInt2029;
	}

	@OriginalMember(owner = "client!fa", name = "a", descriptor = "(IJLjava/lang/Object;)V")
	public void method1779(@OriginalArg(1) long arg0, @OriginalArg(2) Object arg1) {
		this.method1790(arg1, arg0);
	}

	@OriginalMember(owner = "client!fa", name = "a", descriptor = "(B)I")
	public int method1781() {
		return this.anInt2034;
	}

	@OriginalMember(owner = "client!fa", name = "b", descriptor = "(I)Ljava/lang/Object;")
	public Object method1782() {
		@Pc(11) SecondaryNode_Sub1_Sub8 local11 = (SecondaryNode_Sub1_Sub8) this.aHashMap_10.next();
		while (local11 != null) {
			@Pc(23) Object local23 = local11.method3885();
			if (local23 != null) {
				return local23;
			}
			@Pc(29) SecondaryNode_Sub1_Sub8 local29 = local11;
			local11 = (SecondaryNode_Sub1_Sub8) this.aHashMap_10.next();
			local29.popSelf();
			local29.secondaryPopSelf();
			this.anInt2034 += local11.anInt5084;
		}
		return null;
	}

	@OriginalMember(owner = "client!fa", name = "a", descriptor = "(JI)V")
	private void method1783(@OriginalArg(0) long arg0) {
		@Pc(10) SecondaryNode_Sub1_Sub8 local10 = (SecondaryNode_Sub1_Sub8) this.aHashMap_10.get(arg0);
		this.method1792(local10);
	}

	@OriginalMember(owner = "client!fa", name = "b", descriptor = "(B)I")
	public int method1785() {
		return this.anInt2029;
	}

	@OriginalMember(owner = "client!fa", name = "c", descriptor = "(B)I")
	public int method1786() {
		@Pc(7) int local7 = 0;
		for (@Pc(13) SecondaryNode_Sub1_Sub8 local13 = (SecondaryNode_Sub1_Sub8) this.aSecondaryLinkedList_2.getHead(); local13 != null; local13 = (SecondaryNode_Sub1_Sub8) this.aSecondaryLinkedList_2.next()) {
			if (!local13.method3883()) {
				local7++;
			}
		}
		return local7;
	}

	@OriginalMember(owner = "client!fa", name = "a", descriptor = "(JB)Ljava/lang/Object;")
	public Object method1787(@OriginalArg(0) long arg0) {
		@Pc(10) SecondaryNode_Sub1_Sub8 local10 = (SecondaryNode_Sub1_Sub8) this.aHashMap_10.get(arg0);
		if (local10 == null) {
			return null;
		}
		@Pc(18) Object local18 = local10.method3885();
		if (local18 == null) {
			local10.popSelf();
			local10.secondaryPopSelf();
			this.anInt2034 += local10.anInt5084;
			return null;
		}
		if (local10.method3883()) {
			@Pc(51) SecondaryNode_Sub1_Sub8_Sub1 local51 = new SecondaryNode_Sub1_Sub8_Sub1(local18, local10.anInt5084);
			this.aHashMap_10.set(local10.hashKey, local51);
			this.aSecondaryLinkedList_2.insert(local51);
			local51.secondaryValue = 0L;
			local10.popSelf();
			local10.secondaryPopSelf();
		} else {
			this.aSecondaryLinkedList_2.insert(local10);
			local10.secondaryValue = 0L;
		}
		return local18;
	}

	@OriginalMember(owner = "client!fa", name = "a", descriptor = "(II)V")
	public void method1788(@OriginalArg(0) int arg0) {
		if (Static293.aClass174_1 == null) {
			return;
		}
		for (@Pc(13) SecondaryNode_Sub1_Sub8 local13 = (SecondaryNode_Sub1_Sub8) this.aSecondaryLinkedList_2.getHead(); local13 != null; local13 = (SecondaryNode_Sub1_Sub8) this.aSecondaryLinkedList_2.next()) {
			if (local13.method3883()) {
				if (local13.method3885() == null) {
					local13.popSelf();
					local13.secondaryPopSelf();
					this.anInt2034++;
				}
			} else if (++local13.secondaryValue > (long) arg0) {
				@Pc(39) SecondaryNode_Sub1_Sub8 local39 = Static293.aClass174_1.method4040(local13);
				this.aHashMap_10.set(local13.hashKey, local39);
				SecondaryLinkedList.insertAfter(local13, local39);
				local13.popSelf();
				local13.secondaryPopSelf();
			}
		}
	}

	@OriginalMember(owner = "client!fa", name = "d", descriptor = "(B)Ljava/lang/Object;")
	public Object method1789() {
		@Pc(16) SecondaryNode_Sub1_Sub8 local16 = (SecondaryNode_Sub1_Sub8) this.aHashMap_10.head();
		while (local16 != null) {
			@Pc(22) Object local22 = local16.method3885();
			if (local22 != null) {
				return local22;
			}
			@Pc(26) SecondaryNode_Sub1_Sub8 local26 = local16;
			local16 = (SecondaryNode_Sub1_Sub8) this.aHashMap_10.next();
			local26.popSelf();
			local26.secondaryPopSelf();
			this.anInt2034 += local16.anInt5084;
		}
		return null;
	}

	@OriginalMember(owner = "client!fa", name = "a", descriptor = "(Ljava/lang/Object;IJI)V")
	private void method1790(@OriginalArg(0) Object arg0, @OriginalArg(2) long arg1) {
		if (this.anInt2029 < 1) {
			throw new IllegalStateException("s>cs");
		}
		this.method1783(arg1);
		this.anInt2034--;
		while (this.anInt2034 < 0) {
			@Pc(32) SecondaryNode_Sub1_Sub8 local32 = (SecondaryNode_Sub1_Sub8) this.aSecondaryLinkedList_2.popHead();
			this.method1792(local32);
		}
		@Pc(45) SecondaryNode_Sub1_Sub8_Sub1 local45 = new SecondaryNode_Sub1_Sub8_Sub1(arg0, 1);
		this.aHashMap_10.set(arg1, local45);
		this.aSecondaryLinkedList_2.insert(local45);
		local45.secondaryValue = 0L;
	}

	@OriginalMember(owner = "client!fa", name = "c", descriptor = "(I)V")
	public void method1791() {
		for (@Pc(7) SecondaryNode_Sub1_Sub8 local7 = (SecondaryNode_Sub1_Sub8) this.aSecondaryLinkedList_2.getHead(); local7 != null; local7 = (SecondaryNode_Sub1_Sub8) this.aSecondaryLinkedList_2.next()) {
			if (local7.method3883()) {
				local7.popSelf();
				local7.secondaryPopSelf();
				this.anInt2034 += local7.anInt5084;
			}
		}
	}

	@OriginalMember(owner = "client!fa", name = "a", descriptor = "(Lclient!fq;I)V")
	private void method1792(@OriginalArg(0) SecondaryNode_Sub1_Sub8 arg0) {
		if (arg0 != null) {
			arg0.popSelf();
			arg0.secondaryPopSelf();
			this.anInt2034 += arg0.anInt5084;
		}
	}
}
