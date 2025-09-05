package com.jagex.client;

import com.jagex.client.ds.LinkedList;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!jl")
public final class Node_Sub15_Sub2 extends Node_Sub15 {

	@OriginalMember(owner = "client!jl", name = "p", descriptor = "Lclient!pk;")
	private final LinkedList aLinkedList_26 = new LinkedList();

	@OriginalMember(owner = "client!jl", name = "q", descriptor = "Lclient!pk;")
	private final LinkedList aLinkedList_27 = new LinkedList();

	@OriginalMember(owner = "client!jl", name = "r", descriptor = "I")
	private int anInt3580 = -1;

	@OriginalMember(owner = "client!jl", name = "s", descriptor = "I")
	private int anInt3581 = 0;

	@OriginalMember(owner = "client!jl", name = "e", descriptor = "()I")
	public synchronized int method2953() {
		return this.aLinkedList_26.count();
	}

	@OriginalMember(owner = "client!jl", name = "a", descriptor = "(Lclient!ti;)V")
	public synchronized void method2954(@OriginalArg(0) Node_Sub15 arg0) {
		this.aLinkedList_26.addLast(arg0);
	}

	@OriginalMember(owner = "client!jl", name = "b", descriptor = "(Lclient!ti;)V")
	public synchronized void method2955(@OriginalArg(0) Node_Sub15 arg0) {
		arg0.popSelf();
	}

	@OriginalMember(owner = "client!jl", name = "b", descriptor = "()Lclient!ti;")
	@Override
	public Node_Sub15 method4857() {
		return (Node_Sub15) this.aLinkedList_26.previous();
	}

	@OriginalMember(owner = "client!jl", name = "c", descriptor = "([III)V")
	private void method2956(@OriginalArg(0) int[] arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		for (@Pc(5) Node_Sub15 local5 = (Node_Sub15) this.aLinkedList_26.tail(); local5 != null; local5 = (Node_Sub15) this.aLinkedList_26.previous()) {
			local5.method4858(arg0, arg1, arg2);
		}
	}

	@OriginalMember(owner = "client!jl", name = "d", descriptor = "()Lclient!ti;")
	@Override
	public Node_Sub15 method4860() {
		return (Node_Sub15) this.aLinkedList_26.tail();
	}

	@OriginalMember(owner = "client!jl", name = "a", descriptor = "(Lclient!wr;)V")
	private void method2957(@OriginalArg(0) Node_Sub44 arg0) {
		arg0.popSelf();
		arg0.method5668();
		@Pc(9) Node local9 = this.aLinkedList_27.sentinelNode.previous;
		if (local9 == this.aLinkedList_27.sentinelNode) {
			this.anInt3580 = -1;
		} else {
			this.anInt3580 = ((Node_Sub44) local9).anInt7350;
		}
	}

	@OriginalMember(owner = "client!jl", name = "a", descriptor = "(Lclient!vu;Lclient!wr;)V")
	private void method2958(@OriginalArg(0) Node arg0, @OriginalArg(1) Node_Sub44 arg1) {
		while (arg0 != this.aLinkedList_27.sentinelNode && ((Node_Sub44) arg0).anInt7350 <= arg1.anInt7350) {
			arg0 = arg0.previous;
		}
		Static245.method3597(arg0, arg1);
		this.anInt3580 = ((Node_Sub44) this.aLinkedList_27.sentinelNode.previous).anInt7350;
	}

	@OriginalMember(owner = "client!jl", name = "c", descriptor = "(I)V")
	private void method2959(@OriginalArg(0) int arg0) {
		for (@Pc(5) Node_Sub15 local5 = (Node_Sub15) this.aLinkedList_26.tail(); local5 != null; local5 = (Node_Sub15) this.aLinkedList_26.previous()) {
			local5.method4861(arg0);
		}
	}

	@OriginalMember(owner = "client!jl", name = "f", descriptor = "()V")
	private void method2960() {
		if (this.anInt3581 <= 0) {
			return;
		}
		for (@Pc(8) Node_Sub44 local8 = (Node_Sub44) this.aLinkedList_27.tail(); local8 != null; local8 = (Node_Sub44) this.aLinkedList_27.previous()) {
			local8.anInt7350 -= this.anInt3581;
		}
		this.anInt3580 -= this.anInt3581;
		this.anInt3581 = 0;
	}

	@OriginalMember(owner = "client!jl", name = "c", descriptor = "()I")
	@Override
	public int method4859() {
		return 0;
	}

	@OriginalMember(owner = "client!jl", name = "a", descriptor = "(I)V")
	@Override
	public synchronized void method4861(@OriginalArg(0) int arg0) {
		do {
			if (this.anInt3580 < 0) {
				this.method2959(arg0);
				return;
			}
			if (this.anInt3581 + arg0 < this.anInt3580) {
				this.anInt3581 += arg0;
				this.method2959(arg0);
				return;
			}
			@Pc(29) int local29 = this.anInt3580 - this.anInt3581;
			this.method2959(local29);
			arg0 -= local29;
			this.anInt3581 += local29;
			this.method2960();
			@Pc(50) Node_Sub44 local50 = (Node_Sub44) this.aLinkedList_27.tail();
			synchronized (local50) {
				@Pc(58) int local58 = local50.method5669(this);
				if (local58 < 0) {
					local50.anInt7350 = 0;
					this.method2957(local50);
				} else {
					local50.anInt7350 = local58;
					this.method2958(local50.previous, local50);
				}
			}
		} while (arg0 != 0);
	}

	@OriginalMember(owner = "client!jl", name = "a", descriptor = "([III)V")
	@Override
	public synchronized void method4855(@OriginalArg(0) int[] arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		do {
			if (this.anInt3580 < 0) {
				this.method2956(arg0, arg1, arg2);
				return;
			}
			if (this.anInt3581 + arg2 < this.anInt3580) {
				this.anInt3581 += arg2;
				this.method2956(arg0, arg1, arg2);
				return;
			}
			@Pc(33) int local33 = this.anInt3580 - this.anInt3581;
			this.method2956(arg0, arg1, local33);
			arg1 += local33;
			arg2 -= local33;
			this.anInt3581 += local33;
			this.method2960();
			@Pc(60) Node_Sub44 local60 = (Node_Sub44) this.aLinkedList_27.tail();
			synchronized (local60) {
				@Pc(68) int local68 = local60.method5669(this);
				if (local68 < 0) {
					local60.anInt7350 = 0;
					this.method2957(local60);
				} else {
					local60.anInt7350 = local68;
					this.method2958(local60.previous, local60);
				}
			}
		} while (arg2 != 0);
	}
}
