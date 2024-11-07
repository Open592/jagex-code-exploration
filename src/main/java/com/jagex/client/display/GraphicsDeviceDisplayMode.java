package com.jagex.client.display;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ic")
public final class GraphicsDeviceDisplayMode {

	@OriginalMember(owner = "client!ic", name = "b", descriptor = "I")
	public int width;

	@OriginalMember(owner = "client!ic", name = "c", descriptor = "I")
	public int height;

	@OriginalMember(owner = "client!ic", name = "f", descriptor = "I")
	public int bitDepth;

	@OriginalMember(owner = "client!ic", name = "e", descriptor = "I")
	public int refreshRate;
}
