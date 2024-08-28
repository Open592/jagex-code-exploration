package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!bo")
public final class Class25 {

	@OriginalMember(owner = "client!bo", name = "g", descriptor = "Lclient!vu;")
	private ListNode aListNode_33;

	@OriginalMember(owner = "client!bo", name = "h", descriptor = "I")
	private int anInt626 = 0;

	@OriginalMember(owner = "client!bo", name = "d", descriptor = "Lclient!ib;")
	private final IterableHashMap aIterableHashMap_5;

	@OriginalMember(owner = "client!bo", name = "<init>", descriptor = "(Lclient!ib;)V")
	public Class25(@OriginalArg(0) IterableHashMap arg0) {
		this.aIterableHashMap_5 = arg0;
	}

	@OriginalMember(owner = "client!bo", name = "a", descriptor = "(Z)Lclient!vu;")
	public ListNode method640() {
		@Pc(30) ListNode local30;
		if (this.anInt626 > 0 && this.aListNode_33 != this.aIterableHashMap_5.buckets[this.anInt626 - 1]) {
			local30 = this.aListNode_33;
			this.aListNode_33 = local30.previous;
			return local30;
		}
		while (this.anInt626 < this.aIterableHashMap_5.bucketCount) {
			local30 = this.aIterableHashMap_5.buckets[this.anInt626++].previous;
			if (this.aIterableHashMap_5.buckets[this.anInt626 - 1] != local30) {
				this.aListNode_33 = local30.previous;
				return local30;
			}
		}
		return null;
	}

	@OriginalMember(owner = "client!bo", name = "a", descriptor = "(I)Lclient!vu;")
	public ListNode method641() {
		this.anInt626 = 0;
		return this.method640();
	}
}
