package com.jagex.client;

import java.io.DataInputStream;
import java.net.URL;

import com.jagex.client.utilities.ThreadingUtilities;
import com.jagex.signlink.Message;
import com.jagex.signlink.SignLink;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static94 {

	@OriginalMember(owner = "client!eo", name = "l", descriptor = "Lclient!sl;")
	public static final Class215 aClass215_21 = new Class215(80, 7);

	@OriginalMember(owner = "client!eo", name = "m", descriptor = "Z")
	public static boolean aBoolean176 = false;

	@OriginalMember(owner = "client!eo", name = "a", descriptor = "(IBIII)V")
	public static void method1652(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3) {
		@Pc(8) SecondaryNode_Sub1_Sub11 local8 = Static405.method5222(arg0, 8);
		local8.method2604();
		local8.anInt3082 = arg1;
		local8.anInt3083 = arg2;
		local8.anInt3079 = arg3;
	}

	@OriginalMember(owner = "client!eo", name = "a", descriptor = "(IIIIIII)V")
	public static void method1653(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3, @OriginalArg(5) int arg4, @OriginalArg(6) int arg5) {
		@Pc(10) int local10 = arg0 - arg4;
		@Pc(14) int local14 = arg4 + arg5;
		for (@Pc(24) int local24 = arg5; local24 < local14; local24++) {
			Static251.method3640(arg1, arg2, arg3, Static96.anIntArrayArray21[local24]);
		}
		for (@Pc(40) int local40 = arg0; local40 > local10; local40--) {
			Static251.method3640(arg1, arg2, arg3, Static96.anIntArrayArray21[local40]);
		}
		@Pc(63) int local63 = arg3 - arg4;
		@Pc(67) int local67 = arg1 + arg4;
		for (@Pc(69) int local69 = local14; local69 <= local10; local69++) {
			@Pc(75) int[] local75 = Static96.anIntArrayArray21[local69];
			Static251.method3640(arg1, arg2, local67, local75);
			Static251.method3640(local63, arg2, arg3, local75);
		}
	}

	@OriginalMember(owner = "client!eo", name = "a", descriptor = "(Ljava/lang/Throwable;Ljava/lang/String;I)V")
	public static void handleClientError(@OriginalArg(0) Throwable error, @OriginalArg(1) String context) {
		try {
			@Pc(7) String errorMessage = "";
			if (error != null) {
				errorMessage = Static329.method4429(error);
			}
			if (context != null) {
				if (error != null) {
					errorMessage = errorMessage + " | ";
				}
				errorMessage = errorMessage + context;
			}
			Static13.method140(errorMessage);
			errorMessage = Static437.method4044("%3a", ":", errorMessage);
			errorMessage = Static437.method4044("%40", "@", errorMessage);
			errorMessage = Static437.method4044("%26", "&", errorMessage);
			errorMessage = Static437.method4044("%23", "#", errorMessage);
			if (Static386.signLink.hostApplet != null) {
				@Pc(99) Message message = Static386.signLink.emitOpenURLStreamMessage(new URL(Static386.signLink.hostApplet.getCodeBase(), "clienterror.ws?c=" + Static13.gameVersion + "&u=" + Static286.aLong174 + "&v1=" + SignLink.javaVendor + "&v2=" + SignLink.javaVersion + "&e=" + errorMessage));

				while (message.status == 0) {
					ThreadingUtilities.sleepFor(1L);
				}

				if (message.status == 1) {
					@Pc(125) DataInputStream responseStream = (DataInputStream) message.output;
					responseStream.read();
					responseStream.close();
				}
			}
		} catch (@Pc(132) Exception ignored) {
		}
	}
}
