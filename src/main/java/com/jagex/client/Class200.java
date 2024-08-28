package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!qu")
public final class Class200 {

	@OriginalMember(owner = "client!qu", name = "d", descriptor = "C")
	public char aChar3;

	@OriginalMember(owner = "client!qu", name = "g", descriptor = "C")
	public char aChar4;

	@OriginalMember(owner = "client!qu", name = "j", descriptor = "I")
	private int anInt5767;

	@OriginalMember(owner = "client!qu", name = "k", descriptor = "Lclient!ib;")
	public IterableHashMap aIterableHashMap_32;

	@OriginalMember(owner = "client!qu", name = "m", descriptor = "Lclient!ib;")
	private IterableHashMap aIterableHashMap_33;

	@OriginalMember(owner = "client!qu", name = "h", descriptor = "Ljava/lang/String;")
	private String aString58 = "null";

	@OriginalMember(owner = "client!qu", name = "a", descriptor = "(B)V")
	private void method4532() {
		this.aIterableHashMap_33 = new IterableHashMap(this.aIterableHashMap_32.count());
		for (@Pc(26) ListNode_Sub7 local26 = (ListNode_Sub7) this.aIterableHashMap_32.head(); local26 != null; local26 = (ListNode_Sub7) this.aIterableHashMap_32.next()) {
			@Pc(37) ListNode_Sub35 local37 = new ListNode_Sub35(local26.aString12, (int) local26.id);
			this.aIterableHashMap_33.set(Static237.method5625(local26.aString12), local37);
		}
	}

	@OriginalMember(owner = "client!qu", name = "a", descriptor = "(II)I")
	public int method4533(@OriginalArg(0) int arg0) {
		if (this.aIterableHashMap_32 == null) {
			return this.anInt5767;
		} else {
			@Pc(25) ListNode_Sub37 local25 = (ListNode_Sub37) this.aIterableHashMap_32.get((long) arg0);
			return local25 == null ? this.anInt5767 : local25.anInt5426;
		}
	}

	@OriginalMember(owner = "client!qu", name = "a", descriptor = "(ILclient!iv;)V")
	public void method4534(@OriginalArg(1) Packet arg0) {
		while (true) {
			@Pc(5) int local5 = arg0.g1();
			if (local5 == 0) {
				return;
			}
			this.method4537(arg0, local5);
		}
	}

	@OriginalMember(owner = "client!qu", name = "a", descriptor = "(ILjava/lang/String;)Z")
	public boolean method4535(@OriginalArg(1) String arg0) {
		if (this.aIterableHashMap_32 == null) {
			return false;
		}
		if (this.aIterableHashMap_33 == null) {
			this.method4532();
		}
		for (@Pc(30) ListNode_Sub35 local30 = (ListNode_Sub35) this.aIterableHashMap_33.get(Static237.method5625(arg0)); local30 != null; local30 = (ListNode_Sub35) this.aIterableHashMap_33.getNextHashCollision()) {
			if (local30.aString51.equals(arg0)) {
				return true;
			}
		}
		return false;
	}

	@OriginalMember(owner = "client!qu", name = "a", descriptor = "(ZI)Z")
	public boolean method4536(@OriginalArg(1) int arg0) {
		if (this.aIterableHashMap_32 == null) {
			return false;
		}
		if (this.aIterableHashMap_33 == null) {
			this.method4539();
		}
		@Pc(22) ListNode_Sub37 local22 = (ListNode_Sub37) this.aIterableHashMap_33.get((long) arg0);
		return local22 != null;
	}

	@OriginalMember(owner = "client!qu", name = "a", descriptor = "(Lclient!iv;II)V")
	private void method4537(@OriginalArg(0) Packet arg0, @OriginalArg(1) int arg1) {
		if (arg1 == 1) {
			this.aChar3 = CP1252StringTools.CP1252ToUTF8(arg0.g1s());
		} else if (arg1 == 2) {
			this.aChar4 = CP1252StringTools.CP1252ToUTF8(arg0.g1s());
		} else if (arg1 == 3) {
			this.aString58 = arg0.gStringCP1252ToUTF8();
		} else if (arg1 == 4) {
			this.anInt5767 = arg0.g4();
		} else if (arg1 == 5 || arg1 == 6) {
			@Pc(31) int local31 = arg0.g2();
			this.aIterableHashMap_32 = new IterableHashMap(Static370.method4949(local31));
			for (@Pc(43) int local43 = 0; local43 < local31; local43++) {
				@Pc(49) int local49 = arg0.g4();
				@Pc(61) ListNode local61;
				if (arg1 == 5) {
					local61 = new ListNode_Sub7(arg0.gStringCP1252ToUTF8());
				} else {
					local61 = new ListNode_Sub37(arg0.g4());
				}
				this.aIterableHashMap_32.set((long) local49, local61);
			}
		}
	}

	@OriginalMember(owner = "client!qu", name = "b", descriptor = "(II)Ljava/lang/String;")
	public String method4538(@OriginalArg(1) int arg0) {
		if (this.aIterableHashMap_32 == null) {
			return this.aString58;
		} else {
			@Pc(17) ListNode_Sub7 local17 = (ListNode_Sub7) this.aIterableHashMap_32.get((long) arg0);
			return local17 == null ? this.aString58 : local17.aString12;
		}
	}

	@OriginalMember(owner = "client!qu", name = "a", descriptor = "(I)V")
	private void method4539() {
		this.aIterableHashMap_33 = new IterableHashMap(this.aIterableHashMap_32.count());
		for (@Pc(24) ListNode_Sub37 local24 = (ListNode_Sub37) this.aIterableHashMap_32.head(); local24 != null; local24 = (ListNode_Sub37) this.aIterableHashMap_32.next()) {
			@Pc(33) ListNode_Sub37 local33 = new ListNode_Sub37((int) local24.id);
			this.aIterableHashMap_33.set((long) local24.anInt5426, local33);
		}
	}
}
