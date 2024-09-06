package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static437 {

	@OriginalMember(owner = "client!wa", name = "b", descriptor = "Lclient!sl;")
	public static final Class215 aClass215_66 = new Class215(55, 16);

	@OriginalMember(owner = "client!wa", name = "e", descriptor = "Z")
	public static boolean aBoolean477 = false;

	@OriginalMember(owner = "client!wa", name = "g", descriptor = "[C")
	public static final char[] aCharArray6 = new char[] { '[', ']', '#' };

	@OriginalMember(owner = "client!wa", name = "a", descriptor = "(ZIZLjava/lang/String;)I")
	public static int stringToInt(@OriginalArg(1) int base, @OriginalArg(3) String input) {
		@Pc(26) boolean local26 = false;
		@Pc(28) boolean local28 = false;
		@Pc(30) int local30 = 0;
		@Pc(33) int local33 = input.length();
		for (@Pc(35) int local35 = 0; local35 < local33; local35++) {
			@Pc(41) char local41 = input.charAt(local35);
			if (local35 == 0) {
				if (local41 == '-') {
					local26 = true;
					continue;
				}
				if (local41 == '+') {
					continue;
				}
			}
			@Pc(67) int local67;
			if (local41 >= '0' && local41 <= '9') {
				local67 = local41 - '0';
			} else if (local41 >= 'A' && local41 <= 'Z') {
				local67 = local41 - '7';
			} else if (local41 >= 'a' && local41 <= 'z') {
				local67 = local41 - 'W';
			} else {
				throw new NumberFormatException();
			}
			if (local67 >= base) {
				throw new NumberFormatException();
			}
			if (local26) {
				local67 = -local67;
			}
			@Pc(111) int local111 = local67 + local30 * base;
			if (local111 / base != local30) {
				throw new NumberFormatException();
			}
			local30 = local111;
			local28 = true;
		}
		if (!local28) {
			throw new NumberFormatException();
		}
		return local30;
	}

	@OriginalMember(owner = "client!wa", name = "a", descriptor = "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;")
	public static String method4044(@OriginalArg(0) String arg0, @OriginalArg(2) String arg1, @OriginalArg(3) String arg2) {
		for (@Pc(14) int local14 = arg2.indexOf(arg1); local14 != -1; local14 = arg2.indexOf(arg1, arg0.length() + local14)) {
			arg2 = arg2.substring(0, local14) + arg0 + arg2.substring(local14 + arg1.length());
		}
		return arg2;
	}
}
