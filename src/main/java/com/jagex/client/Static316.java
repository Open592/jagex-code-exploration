package com.jagex.client;

import com.jagex.client.utilities.ThreadingUtilities;
import com.jagex.signlink.Message;
import com.jagex.signlink.FileOnDisk;
import com.jagex.signlink.MonotonicClock;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static316 {

	@OriginalMember(owner = "client!pu", name = "e", descriptor = "Lclient!bg;")
	public static Class22 aClass22_257;

	@OriginalMember(owner = "client!pu", name = "i", descriptor = "[I")
	public static int[] anIntArray376 = new int[2];

	@OriginalMember(owner = "client!pu", name = "a", descriptor = "(I)V")
	public static void method4216() {
		@Pc(7) FileOnDisk local7 = null;
		try {
			@Pc(16) Message local16 = GameShell.signLink.emitResolvePreferencesFileLocationMessage("2");
			while (local16.status == 0) {
				ThreadingUtilities.sleepFor(1L);
			}
			if (local16.status == 1) {
				local7 = (FileOnDisk) local16.output;
				@Pc(41) Packet local41 = new Packet(Static268.anInt4998 * 6 + 3);
				local41.p1(1);
				local41.p2(Static268.anInt4998);
				for (@Pc(53) int local53 = 0; local53 < Static165.anIntArray210.length; local53++) {
					if (Static22.aBooleanArray3[local53]) {
						local41.p2(local53);
						local41.p4(Static165.anIntArray210[local53]);
					}
				}
				local7.write(0, local41.pos, local41.data);
			}
		} catch (@Pc(84) Exception local84) {
		}
		try {
			if (local7 != null) {
				local7.close();
			}
		} catch (@Pc(93) Exception local93) {
		}
		Static174.aLong119 = MonotonicClock.getCurrentTimeInMilliseconds();
		Static135.aBoolean256 = false;
	}

	@OriginalMember(owner = "client!pu", name = "a", descriptor = "(Z)V")
	public static void method4217() {
		@Pc(3) Class84[] local3 = Class147.aClass84Array1;
		synchronized (Class147.aClass84Array1) {
			for (@Pc(12) int local12 = 0; local12 < Class147.aClass84Array1.length; local12++) {
				Class147.aClass84Array1[local12] = new Class84();
				Static95.anIntArray154[local12] = 0;
			}
		}
	}

	@OriginalMember(owner = "client!pu", name = "a", descriptor = "(III)V")
	public static void method4221(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
		@Pc(8) SecondaryNode_Sub1_Sub11 local8 = Static405.method5222(arg0, 1);
		local8.method2604();
		local8.anInt3083 = arg1;
	}

}
