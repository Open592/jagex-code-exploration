package com.jagex.client;

import com.jagex.signlink.MonotonicClock;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!hp")
public final class SecondaryNode_Sub1_Sub11 extends SecondaryNode {

	@OriginalMember(owner = "client!hp", name = "Y", descriptor = "[Lclient!eh;")
	private static final Class60[] aClass60Array1 = new Class60[32];

	@OriginalMember(owner = "client!hp", name = "F", descriptor = "I")
	public int anInt3079;

	@OriginalMember(owner = "client!hp", name = "I", descriptor = "Ljava/lang/String;")
	public String aString32;

	@OriginalMember(owner = "client!hp", name = "J", descriptor = "I")
	public int anInt3082;

	@OriginalMember(owner = "client!hp", name = "L", descriptor = "I")
	public int anInt3083;

	static {
		@Pc(65) Class60[] local65 = Static382.method5040();
		for (@Pc(67) int local67 = 0; local67 < local65.length; local67++) {
			aClass60Array1[local65[local67].anInt1812] = local65[local67];
		}
	}

	@OriginalMember(owner = "client!hp", name = "<init>", descriptor = "(II)V")
	public SecondaryNode_Sub1_Sub11(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		super.hashKey = (long) arg0 << 32 | (long) arg1;
	}

	@OriginalMember(owner = "client!hp", name = "a", descriptor = "(I)V")
	public void method2604() {
		super.secondaryValue |= Long.MIN_VALUE;
		if (this.method2611() == 0L) {
			Static99.A_SECONDARY_DOUBLY_LINKED_LIST___1.insert(this);
		}
	}

	@OriginalMember(owner = "client!hp", name = "e", descriptor = "(B)I")
	public int method2606() {
		return (int) (super.hashKey >>> 32 & 0xFFL);
	}

	@OriginalMember(owner = "client!hp", name = "f", descriptor = "(B)V")
	public void method2608() {
		super.secondaryValue = MonotonicClock.getCurrentTimeInMilliseconds() + 500L | Long.MIN_VALUE & super.secondaryValue;
		Static250.A_SECONDARY_DOUBLY_LINKED_LIST___4.insert(this);
	}

	@OriginalMember(owner = "client!hp", name = "g", descriptor = "(B)I")
	public int method2609() {
		return (int) super.hashKey;
	}

	@OriginalMember(owner = "client!hp", name = "e", descriptor = "(I)J")
	public long method2611() {
		return super.secondaryValue & Long.MAX_VALUE;
	}
}
