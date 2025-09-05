package com.jagex.client;

import com.jagex.client.ds.LinkedList;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static404 {

	@OriginalMember(owner = "client!uj", name = "a", descriptor = "Lclient!pk;")
	private static final LinkedList A_LINKED_LIST___46 = new LinkedList();

	@OriginalMember(owner = "client!uj", name = "a", descriptor = "(Z)V")
	public static void method5219() {
		while (true) {
			@Pc(8) Node_Sub26 local8 = (Node_Sub26) A_LINKED_LIST___46.pollLast();
			if (local8 == null) {
				return;
			}
			local8.anInterface4_1.EA();
			local8.popSelf();
		}
	}

	@OriginalMember(owner = "client!uj", name = "a", descriptor = "(BLclient!d;)V")
	public static synchronized void method5220(@OriginalArg(1) Interface4 arg0) {
		@Pc(3) Node_Sub26 local3 = new Node_Sub26();
		local3.anInterface4_1 = arg0;
		A_LINKED_LIST___46.addFirst(local3);
	}
}
