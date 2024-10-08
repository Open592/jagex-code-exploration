package com.jagex.client;

import java.lang.ref.SoftReference;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!nq")
public final class SecondaryNode_Sub1_Sub8_Sub2 extends SecondaryNode_Sub1_Sub8 {

	@OriginalMember(owner = "client!nq", name = "B", descriptor = "Ljava/lang/ref/SoftReference;")
	private final SoftReference aSoftReference2;

	@OriginalMember(owner = "client!nq", name = "<init>", descriptor = "(Ljava/lang/Object;I)V")
	public SecondaryNode_Sub1_Sub8_Sub2(@OriginalArg(0) Object arg0, @OriginalArg(1) int arg1) {
		super(arg1);
		this.aSoftReference2 = new SoftReference(arg0);
	}

	@OriginalMember(owner = "client!nq", name = "e", descriptor = "(B)Z")
	@Override
	public boolean method3883() {
		return true;
	}

	@OriginalMember(owner = "client!nq", name = "d", descriptor = "(I)Ljava/lang/Object;")
	@Override
	public Object method3885() {
		return this.aSoftReference2.get();
	}
}
