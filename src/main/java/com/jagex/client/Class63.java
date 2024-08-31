package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!em")
public final class Class63 {

	@OriginalMember(owner = "client!em", name = "e", descriptor = "Lclient!vu;")
	private LinkedEntry aLinkedEntry_70;

	@OriginalMember(owner = "client!em", name = "f", descriptor = "Lclient!pk;")
	private Class183 aClass183_5;

	@OriginalMember(owner = "client!em", name = "<init>", descriptor = "()V")
	public Class63() {
	}

	@OriginalMember(owner = "client!em", name = "<init>", descriptor = "(Lclient!pk;)V")
	public Class63(@OriginalArg(0) Class183 arg0) {
		this.aClass183_5 = arg0;
	}

	@OriginalMember(owner = "client!em", name = "a", descriptor = "(Z)Lclient!vu;")
	public LinkedEntry method1611() {
		@Pc(13) LinkedEntry local13 = this.aClass183_5.aLinkedEntry_207.previous;
		if (local13 == this.aClass183_5.aLinkedEntry_207) {
			this.aLinkedEntry_70 = null;
			return null;
		} else {
			this.aLinkedEntry_70 = local13.previous;
			return local13;
		}
	}

	@OriginalMember(owner = "client!em", name = "a", descriptor = "(B)Lclient!vu;")
	public LinkedEntry method1612() {
		@Pc(12) LinkedEntry local12 = this.aLinkedEntry_70;
		if (this.aClass183_5.aLinkedEntry_207 == local12) {
			this.aLinkedEntry_70 = null;
			return null;
		} else {
			this.aLinkedEntry_70 = local12.previous;
			return local12;
		}
	}

	@OriginalMember(owner = "client!em", name = "a", descriptor = "(Lclient!pk;I)V")
	public void method1615(@OriginalArg(0) Class183 arg0) {
		this.aClass183_5 = arg0;
	}
}
