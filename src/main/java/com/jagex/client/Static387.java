package com.jagex.client;

import java.io.IOException;
import java.net.Socket;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static387 {

	@OriginalMember(owner = "client!tn", name = "l", descriptor = "Lclient!gt;")
	public static Class89 aClass89_10;

	@OriginalMember(owner = "client!tn", name = "h", descriptor = "Lclient!sl;")
	public static final Class215 aClass215_85 = new Class215(38, 8);

	@OriginalMember(owner = "client!tn", name = "a", descriptor = "(IZ)V")
	public static void method5086(@OriginalArg(0) int arg0) {
		@Pc(12) ListNode_Sub1_Sub11 local12 = Static405.method5222(arg0, 4);
		local12.method2608();
	}

	@OriginalMember(owner = "client!tn", name = "a", descriptor = "(Z)V")
	public static void method5090() {
		if (Static354.anInt6183 == 0) {
			return;
		}
		try {
			if (++Static348.anInt5976 > 2000) {
				if (Static125.aServerConnection_5 != null) {
					Static125.aServerConnection_5.shutdown();
					Static125.aServerConnection_5 = null;
				}
				if (Static119.anInt2524 >= 1) {
					Static354.anInt6183 = 0;
					Static249.anInt4623 = -5;
					return;
				}
				Static354.anInt6183 = 1;
				Static348.anInt5976 = 0;
				if (Static313.anInt5436 == Static407.port) {
					Static407.port = Static97.anInt1949;
				} else {
					Static407.port = Static313.anInt5436;
				}
				Static119.anInt2524++;
			}
			if (Static354.anInt6183 == 1) {
				Static36.aClass199_3 = Static206.signLink.emitConnectionInitializationMessage(Static321.host, Static407.port);
				Static354.anInt6183 = 2;
			}
			@Pc(120) int local120;
			if (Static354.anInt6183 == 2) {
				if (Static36.aClass199_3.status == 2) {
					throw new IOException();
				}
				if (Static36.aClass199_3.status != 1) {
					return;
				}
				Static125.aServerConnection_5 = new ServerConnection((Socket) Static36.aClass199_3.output, Static206.signLink);
				Static36.aClass199_3 = null;
				Static125.aServerConnection_5.enqueueClientMessage(Static3.aClass4_Sub12_Sub1_5.pos, Static3.aClass4_Sub12_Sub1_5.data);
				Static329.method4427();
				local120 = Static125.aServerConnection_5.readByteFromServer();
				Static329.method4427();
				if (local120 != 21) {
					Static249.anInt4623 = local120;
					Static354.anInt6183 = 0;
					Static125.aServerConnection_5.shutdown();
					Static125.aServerConnection_5 = null;
					return;
				}
				Static354.anInt6183 = 3;
			}
			if (Static354.anInt6183 == 3) {
				if (Static125.aServerConnection_5.getEstimatedBytesAvailable() < 1) {
					return;
				}
				Static206.aStringArray16 = new String[Static125.aServerConnection_5.readByteFromServer()];
				Static354.anInt6183 = 4;
			}
			if (Static354.anInt6183 == 4 && Static125.aServerConnection_5.getEstimatedBytesAvailable() >= Static206.aStringArray16.length * 8) {
				Static146.aClass4_Sub12_Sub1_3.pos = 0;
				Static125.aServerConnection_5.readBytesFromServer(0, Static206.aStringArray16.length * 8, Static146.aClass4_Sub12_Sub1_3.data);
				for (local120 = 0; local120 < Static206.aStringArray16.length; local120++) {
					Static206.aStringArray16[local120] = Static44.method763(Static146.aClass4_Sub12_Sub1_3.g8());
				}
				Static249.anInt4623 = 21;
				Static354.anInt6183 = 0;
				Static125.aServerConnection_5.shutdown();
				Static125.aServerConnection_5 = null;
			}
		} catch (@Pc(214) IOException local214) {
			if (Static125.aServerConnection_5 != null) {
				Static125.aServerConnection_5.shutdown();
				Static125.aServerConnection_5 = null;
			}
			if (Static119.anInt2524 >= 1) {
				Static354.anInt6183 = 0;
				Static249.anInt4623 = -4;
			} else {
				Static354.anInt6183 = 1;
				if (Static407.port == Static313.anInt5436) {
					Static407.port = Static97.anInt1949;
				} else {
					Static407.port = Static313.anInt5436;
				}
				Static119.anInt2524++;
				Static348.anInt5976 = 0;
			}
		}
	}
}
