package com.jagex.signlink;

public final class MonotonicClock {

	private static long correctionMilliseconds;

	private static long previousTimeMilliseconds;

	public static synchronized long getCurrentTimeInMilliseconds() {
		long currentTimeMilliseconds = System.currentTimeMillis();

		if (previousTimeMilliseconds > currentTimeMilliseconds) {
			correctionMilliseconds += previousTimeMilliseconds - currentTimeMilliseconds;
		}

		previousTimeMilliseconds = currentTimeMilliseconds;

		return correctionMilliseconds + currentTimeMilliseconds;
	}
}
