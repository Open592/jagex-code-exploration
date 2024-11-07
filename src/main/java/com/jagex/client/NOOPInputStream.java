package com.jagex.client;

import java.io.InputStream;

import com.jagex.client.utilities.ThreadingUtilities;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!mm")
public final class NOOPInputStream extends InputStream {

	@OriginalMember(owner = "client!mm", name = "read", descriptor = "()I")
	@Override
	public int read() {
		ThreadingUtilities.sleepFor(30000L);
		return -1;
	}
}
