package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!bo")
public final class Class25 {

	@OriginalMember(owner = "client!bo", name = "g", descriptor = "Lclient!vu;")
	private LinkedEntry aLinkedEntry_33;

	@OriginalMember(owner = "client!bo", name = "h", descriptor = "I")
	private int anInt626 = 0;

	@OriginalMember(owner = "client!bo", name = "d", descriptor = "Lclient!ib;")
	private final LinkedHashMapIterator aLinkedHashMap_Iterator_5;

	@OriginalMember(owner = "client!bo", name = "<init>", descriptor = "(Lclient!ib;)V")
	public Class25(@OriginalArg(0) LinkedHashMapIterator arg0) {
		this.aLinkedHashMap_Iterator_5 = arg0;
	}

	@OriginalMember(owner = "client!bo", name = "a", descriptor = "(Z)Lclient!vu;")
	public LinkedEntry method640() {
		@Pc(30) LinkedEntry local30;
		if (this.anInt626 > 0 && this.aLinkedEntry_33 != this.aLinkedHashMap_Iterator_5.buckets[this.anInt626 - 1]) {
			local30 = this.aLinkedEntry_33;
			this.aLinkedEntry_33 = local30.previous;
			return local30;
		}
		while (this.anInt626 < this.aLinkedHashMap_Iterator_5.size) {
			local30 = this.aLinkedHashMap_Iterator_5.buckets[this.anInt626++].previous;
			if (this.aLinkedHashMap_Iterator_5.buckets[this.anInt626 - 1] != local30) {
				this.aLinkedEntry_33 = local30.previous;
				return local30;
			}
		}
		return null;
	}

	@OriginalMember(owner = "client!bo", name = "a", descriptor = "(I)Lclient!vu;")
	public LinkedEntry method641() {
		this.anInt626 = 0;
		return this.method640();
	}
}
