package com.jagex.client;

import com.jagex.client.jaggl.memory.NativeHeap;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ai")
public final class Node_Sub2_Sub1 extends Node_Sub2 {

	@OriginalMember(owner = "client!ai", name = "s", descriptor = "Lclient!jaggl/memory/NativeHeap;")
	public final NativeHeap aNativeHeap1;

	@OriginalMember(owner = "client!ai", name = "<init>", descriptor = "(I)V")
	public Node_Sub2_Sub1(@OriginalArg(0) int arg0) {
		this.aNativeHeap1 = new NativeHeap(arg0);
	}

	@OriginalMember(owner = "client!ai", name = "c", descriptor = "(I)V")
	public void method104() {
		this.aNativeHeap1.b();
	}
}
