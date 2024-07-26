package com.jagex.signlink;

public final class Static282 {

	private static long aLong172;

	private static long aLong173;

	public static synchronized long method3962() {
		long currentTimeMillis = System.currentTimeMillis();

		if (aLong173 > currentTimeMillis) {
			aLong172 += aLong173 - currentTimeMillis;
		}

		aLong173 = currentTimeMillis;
		return aLong172 + currentTimeMillis;
	}
}
