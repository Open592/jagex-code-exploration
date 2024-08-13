package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static178 {

	@OriginalMember(owner = "client!j", name = "q", descriptor = "[I")
	public static int[] anIntArray223;

	@OriginalMember(owner = "client!j", name = "r", descriptor = "Lclient!va;")
	public static Class4_Sub42 aClass4_Sub42_2;

	@OriginalMember(owner = "client!j", name = "i", descriptor = "Lclient!bg;")
	public static final Class22 aClass22_152 = new Class22(48, 3);

	@OriginalMember(owner = "client!j", name = "o", descriptor = "I")
	public static int langID = 0;

	@OriginalMember(owner = "client!j", name = "p", descriptor = "Lclient!gk;")
	public static final Class83 aClass83_72 = new Class83("M", "M", "M", "M");

	@OriginalMember(owner = "client!j", name = "a", descriptor = "(Ljava/lang/String;IIII[B)I")
	public static int writeStringToByteBuffer(
			@OriginalArg(0) String value,
			@OriginalArg(2) int length,
			@OriginalArg(3) int currentPosition,
			@OriginalArg(5) byte[] buffer
	) {
		for (@Pc(12) int i = 0; i < length; i++) {
			@Pc(20) char ch = value.charAt(i);

			if (ch > '\u0000' && ch < '\u0080' || !(ch < ' ' || ch > 'ÿ')) {
				buffer[i + currentPosition] = (byte) ch;
			} else if (ch == '€') {
				buffer[currentPosition + i] = -128;
			} else if (ch == '‚') {
				buffer[i + currentPosition] = -126;
			} else if (ch == 'ƒ') {
				buffer[i + currentPosition] = -125;
			} else if (ch == '„') {
				buffer[currentPosition + i] = -124;
			} else if (ch == '…') {
				buffer[i + currentPosition] = -123;
			} else if (ch == '†') {
				buffer[currentPosition + i] = -122;
			} else if (ch == '‡') {
				buffer[currentPosition + i] = -121;
			} else if (ch == 'ˆ') {
				buffer[currentPosition + i] = -120;
			} else if (ch == '‰') {
				buffer[currentPosition + i] = -119;
			} else if (ch == 'Š') {
				buffer[currentPosition + i] = -118;
			} else if (ch == '‹') {
				buffer[currentPosition + i] = -117;
			} else if (ch == 'Œ') {
				buffer[i + currentPosition] = -116;
			} else if (ch == 'Ž') {
				buffer[i + currentPosition] = -114;
			} else if (ch == '‘') {
				buffer[i + currentPosition] = -111;
			} else if (ch == '’') {
				buffer[currentPosition + i] = -110;
			} else if (ch == '“') {
				buffer[i + currentPosition] = -109;
			} else if (ch == '”') {
				buffer[i + currentPosition] = -108;
			} else if (ch == '•') {
				buffer[currentPosition + i] = -107;
			} else if (ch == '–') {
				buffer[i + currentPosition] = -106;
			} else if (ch == '—') {
				buffer[currentPosition + i] = -105;
			} else if (ch == '˜') {
				buffer[i + currentPosition] = -104;
			} else if (ch == '™') {
				buffer[i + currentPosition] = -103;
			} else if (ch == 'š') {
				buffer[i + currentPosition] = -102;
			} else if (ch == '›') {
				buffer[i + currentPosition] = -101;
			} else if (ch == 'œ') {
				buffer[currentPosition + i] = -100;
			} else if (ch == 'ž') {
				buffer[i + currentPosition] = -98;
			} else if (ch == 'Ÿ') {
				buffer[i + currentPosition] = -97;
			} else {
				buffer[i + currentPosition] = 63;
			}
		}

		return length;
	}

	@OriginalMember(owner = "client!j", name = "a", descriptor = "(II)Z")
	public static boolean method2845(@OriginalArg(0) int arg0) {
		return arg0 == 2 || arg0 == 3;
	}
}
