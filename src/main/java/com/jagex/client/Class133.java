package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!lg")
public final class Class133 {

	@OriginalMember(owner = "client!lg", name = "a", descriptor = "Ljava/lang/String;")
	public String aString40;

	@OriginalMember(owner = "client!lg", name = "f", descriptor = "I")
	public int anInt4123;

	@OriginalMember(owner = "client!lg", name = "l", descriptor = "C")
	private char aChar2;

	@OriginalMember(owner = "client!lg", name = "e", descriptor = "Z")
	public boolean aBoolean385 = true;

	@OriginalMember(owner = "client!lg", name = "b", descriptor = "(I)Z")
	public boolean method3350() {
		return this.aChar2 == 's';
	}

	@OriginalMember(owner = "client!lg", name = "a", descriptor = "(ILclient!iv;I)V")
	private void method3352(@OriginalArg(1) Packet arg0, @OriginalArg(2) int arg1) {
		if (arg1 == 1) {
			this.aChar2 = CP1252StringTools.CP1252ToUTF8(arg0.g1s());
		} else if (arg1 == 2) {
			this.anInt4123 = arg0.g4();
		} else if (arg1 == 4) {
			this.aBoolean385 = false;
		} else if (arg1 == 5) {
			this.aString40 = arg0.gStringCP1252ToUTF8();
		}
	}

	@OriginalMember(owner = "client!lg", name = "a", descriptor = "(Lclient!iv;B)V")
	public void method3354(@OriginalArg(0) Packet arg0) {
		while (true) {
			@Pc(15) int local15 = arg0.g1();
			if (local15 == 0) {
				return;
			}
			this.method3352(arg0, local15);
		}
	}
}
