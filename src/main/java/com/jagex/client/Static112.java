package com.jagex.client;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.Socket;

import com.jagex.signlink.MonotonicClock;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static112 {

	@OriginalMember(owner = "client!fl", name = "l", descriptor = "I")
	public static int anInt2392;

	@OriginalMember(owner = "client!fl", name = "a", descriptor = "(IBI)Z")
	public static boolean method2029(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
		if (Static72.method1353(arg0, arg1) | (arg1 & 0x10000) != 0 || Static230.method3468(arg0, arg1)) {
			return true;
		} else {
			return (arg0 & 0x37) == 0 && Static13.method137(arg0, arg1);
		}
	}

	@OriginalMember(owner = "client!fl", name = "a", descriptor = "(III)Z")
	public static boolean method2030(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		@Pc(7) int local7 = Static162.anIntArrayArrayArray13[arg0][arg1][arg2];
		if (local7 == -Static143.anInt2891) {
			return false;
		} else if (local7 == Static143.anInt2891) {
			return true;
		} else {
			@Pc(22) int local22 = arg1 << Static231.anInt4434;
			@Pc(26) int local26 = arg2 << Static231.anInt4434;
			if (Static299.method4088(local22 + 1, Static417.aClass65Array4[arg0].l(arg1, arg2), local26 + 1) && Static299.method4088(local22 + Static4.anInt5935 - 1, Static417.aClass65Array4[arg0].l(arg1 + 1, arg2), local26 + 1) && Static299.method4088(local22 + Static4.anInt5935 - 1, Static417.aClass65Array4[arg0].l(arg1 + 1, arg2 + 1), local26 + Static4.anInt5935 - 1) && Static299.method4088(local22 + 1, Static417.aClass65Array4[arg0].l(arg1, arg2 + 1), local26 + Static4.anInt5935 - 1) && Static299.method4088(local22 + Static333.anInt5747, Static417.aClass65Array4[arg0].l(arg1, arg2), local26 + 1) && Static299.method4088(local22 + Static4.anInt5935 - 1, Static417.aClass65Array4[arg0].l(arg1 + 1, arg2), local26 + Static333.anInt5747) && Static299.method4088(local22 + Static333.anInt5747, Static417.aClass65Array4[arg0].l(arg1, arg2 + 1), local26 + Static4.anInt5935 - 1) && Static299.method4088(local22 + Static4.anInt5935 - 1, Static417.aClass65Array4[arg0].l(arg1, arg2), local26 + Static333.anInt5747) && Static299.method4088(local22 + Static333.anInt5747, Static417.aClass65Array4[arg0].l(arg1, arg2), local26 + Static333.anInt5747)) {
				Static162.anIntArrayArrayArray13[arg0][arg1][arg2] = Static143.anInt2891;
				return true;
			} else {
				Static162.anIntArrayArrayArray13[arg0][arg1][arg2] = -Static143.anInt2891;
				return false;
			}
		}
	}

	@OriginalMember(owner = "client!fl", name = "a", descriptor = "([SI)[S")
	public static short[] method2031(@OriginalArg(0) short[] arg0) {
		if (arg0 == null) {
			return null;
		} else {
			@Pc(18) short[] local18 = new short[arg0.length];
			Static459.method3328(arg0, 0, local18, 0, arg0.length);
			return local18;
		}
	}

	@OriginalMember(owner = "client!fl", name = "a", descriptor = "(Lclient!r;Z)V")
	public static void method2032(@OriginalArg(0) Class16_Sub1_Sub5 arg0) {
		if (arg0 instanceof Class16_Sub1_Sub5_Sub2) {
			@Pc(24) Class16_Sub1_Sub5_Sub2 local24 = (Class16_Sub1_Sub5_Sub2) arg0;
			if (local24.aClass264_1 != null) {
				Static325.method4396(local24.aByte82 != Static1.aClass16_Sub1_Sub5_Sub1_1.aByte82, local24);
			}
		} else if (arg0 instanceof Class16_Sub1_Sub5_Sub1) {
			@Pc(8) Class16_Sub1_Sub5_Sub1 local8 = (Class16_Sub1_Sub5_Sub1) arg0;
			Static377.method4026(Static1.aClass16_Sub1_Sub5_Sub1_1.aByte82 != local8.aByte82, local8);
		}
	}

	@OriginalMember(owner = "client!fl", name = "b", descriptor = "(III)V")
	public static void method2033(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
		@Pc(12) SecondaryNode_Sub1_Sub11 local12 = Static405.method5222(arg1, 5);
		local12.method2604();
		local12.anInt3083 = arg0;
	}

	@OriginalMember(owner = "client!fl", name = "a", descriptor = "(II)Z")
	public static boolean method2034(@OriginalArg(1) int arg0) {
		if (Static453.aBooleanArray25[arg0]) {
			return true;
		} else if (Static356.aJs5_81.method2101(arg0)) {
			@Pc(30) int local30 = Static356.aJs5_81.method2108(arg0);
			if (local30 == 0) {
				Static453.aBooleanArray25[arg0] = true;
				return true;
			}
			if (Static297.aClass247ArrayArray2[arg0] == null) {
				Static297.aClass247ArrayArray2[arg0] = new Class247[local30];
			}
			for (@Pc(52) int local52 = 0; local52 < local30; local52++) {
				if (Static297.aClass247ArrayArray2[arg0][local52] == null) {
					@Pc(66) byte[] local66 = Static356.aJs5_81.method2104(local52, arg0);
					if (local66 != null) {
						@Pc(78) Class247 local78 = Static297.aClass247ArrayArray2[arg0][local52] = new Class247();
						local78.anInt6809 = local52 + (arg0 << 16);
						if (local66[0] != -1) {
							throw new IllegalStateException("if1");
						}
						local78.method5304(new Packet(local66));
					}
				}
			}
			Static453.aBooleanArray25[arg0] = true;
			return true;
		} else {
			return false;
		}
	}

	@OriginalMember(owner = "client!fl", name = "a", descriptor = "(I)I")
	public static int method2035() {
		try {
			if (Static50.anInt862 == 0) {
				if (Static162.aLong210 > MonotonicClock.getCurrentTimeInMilliseconds() - 5000L) {
					return 0;
				}
				Static292.aClass199_8 = GameShell.signLink.emitConnectionInitializationMessage(Static13.host, Static313.anInt5435);
				Static18.aLong14 = MonotonicClock.getCurrentTimeInMilliseconds();
				Static50.anInt862 = 1;
			}
			if (MonotonicClock.getCurrentTimeInMilliseconds() > Static18.aLong14 + 30000L) {
				return Static28.method526(1000);
			}
			@Pc(78) int local78;
			@Pc(110) int local110;
			if (Static50.anInt862 == 1) {
				if (Static292.aClass199_8.status == 2) {
					return Static28.method526(1001);
				}
				if (Static292.aClass199_8.status != 1) {
					return -1;
				}
				Static125.aServerConnection_5 = new ServerConnection((Socket) Static292.aClass199_8.output, GameShell.signLink);
				Static292.aClass199_8 = null;
				local78 = 0;
				if (Static94.aBoolean176) {
					local78 = Static70.anInt1504;
				}
				Static3.aClass4_Sub12_Sub1_5.pos = 0;
				Static3.aClass4_Sub12_Sub1_5.p1(Class60.aClass60_9.anInt1812);
				Static3.aClass4_Sub12_Sub1_5.p4(local78);
				Static125.aServerConnection_5.write(Static3.aClass4_Sub12_Sub1_5.pos, Static3.aClass4_Sub12_Sub1_5.data);
				Static329.method4427();
				local110 = Static125.aServerConnection_5.readByteFromServer();
				Static329.method4427();
				if (local110 != 0) {
					return Static28.method526(local110);
				}
				Static50.anInt862 = 2;
			}
			if (Static50.anInt862 == 2) {
				if (Static125.aServerConnection_5.getEstimatedBytesAvailable() < 2) {
					return -1;
				}
				Static422.anInt6950 = Static125.aServerConnection_5.readByteFromServer();
				Static422.anInt6950 <<= 0x8;
				Static422.anInt6950 += Static125.aServerConnection_5.readByteFromServer();
				Static50.anInt862 = 3;
				Static273.aByteArray64 = new byte[Static422.anInt6950];
				Static215.anInt3980 = 0;
			}
			if (Static50.anInt862 != 3) {
				return -1;
			}
			local78 = Static125.aServerConnection_5.getEstimatedBytesAvailable();
			if (local78 < 1) {
				return -1;
			}
			if (local78 > Static422.anInt6950 - Static215.anInt3980) {
				local78 = Static422.anInt6950 - Static215.anInt3980;
			}
			Static125.aServerConnection_5.readBytesFromServer(Static215.anInt3980, local78, Static273.aByteArray64);
			Static215.anInt3980 += local78;
			if (Static422.anInt6950 > Static215.anInt3980) {
				return -1;
			} else if (Static442.method5583(Static273.aByteArray64)) {
				Static392.aClass78_Sub1Array1 = new Class78_Sub1[Static33.anInt602];
				local110 = 0;
				for (@Pc(211) int local211 = Static396.anInt4816; local211 <= Static339.anInt5874; local211++) {
					@Pc(217) Class78_Sub1 local217 = Static206.method3192(local211);
					if (local217 != null) {
						Static392.aClass78_Sub1Array1[local110++] = local217;
					}
				}
				Static168.anInt3258 = 0;
				Static7.aClass4_Sub42_3 = null;
				Static125.aServerConnection_5.shutdown();
				Static125.aServerConnection_5 = null;
				Static273.aByteArray64 = null;
				Static274.anInt5132 = 0;
				Static50.anInt862 = 0;
				Static162.aLong210 = MonotonicClock.getCurrentTimeInMilliseconds();
				return 0;
			} else {
				return Static28.method526(1002);
			}
		} catch (@Pc(249) IOException local249) {
			return Static28.method526(1003);
		}
	}

	@OriginalMember(owner = "client!fl", name = "c", descriptor = "(I)V")
	public static void method2036() {
		try {
			@Pc(16) Method local16 = Runtime.class.getMethod("availableProcessors");
			if (local16 != null) {
				try {
					@Pc(20) Runtime local20 = Runtime.getRuntime();
					@Pc(26) Integer local26 = (Integer) local16.invoke(local20, (Object[]) null);
					Static249.anInt4622 = local26;
				} catch (@Pc(31) Throwable local31) {
				}
			}
		} catch (@Pc(33) Exception local33) {
		}
	}
}
