package com.jagex.client;

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

	@OriginalMember(owner = "client!pu", name = "k", descriptor = "I")
	public static int anInt5505 = 0;

	@OriginalMember(owner = "client!pu", name = "a", descriptor = "(I)V")
	public static void method4216() {
		@Pc(7) FileOnDisk local7 = null;
		try {
			@Pc(16) Message local16 = Static206.signLink.method1738("2");
			while (local16.status == 0) {
				Static435.sleepFor(1L);
			}
			if (local16.status == 1) {
				local7 = (FileOnDisk) local16.output;
				@Pc(41) Class4_Sub12 local41 = new Class4_Sub12(Static268.anInt4998 * 6 + 3);
				local41.method2551(1);
				local41.method2524(Static268.anInt4998);
				for (@Pc(53) int local53 = 0; local53 < Static165.anIntArray210.length; local53++) {
					if (Static22.aBooleanArray3[local53]) {
						local41.method2524(local53);
						local41.method2531(Static165.anIntArray210[local53]);
					}
				}
				local7.write(0, local41.anInt2997, local41.aByteArray36);
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
		@Pc(8) Class4_Sub1_Sub11 local8 = Static405.method5222(arg0, 1);
		local8.method2604();
		local8.anInt3083 = arg1;
	}

	@OriginalMember(owner = "client!pu", name = "a", descriptor = "(IZ)Lclient!sp;")
	public static ModeWhere resolveModeWhereFromID(@OriginalArg(0) int id) {
		for (ModeWhere modeWhere : Static15.getValidEnvironment()) {
			if (id == modeWhere.getID()) {
				return modeWhere;
			}
		}

		return null;
	}
}
