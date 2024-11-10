package com.jagex.client;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!lf")
public final class Js5DiskCacheRequestItem extends Js5QueueRequest {

	@OriginalMember(owner = "client!lf", name = "G", descriptor = "Lclient!st;")
	public Class222 aClass222_1;

	@OriginalMember(owner = "client!lf", name = "H", descriptor = "[B")
	public byte[] responseData;

	@OriginalMember(owner = "client!lf", name = "K", descriptor = "I")
	public int anInt4117;

	static {
		new LocalizedString("You have been permanently muted due to breaking a rule.", "Du wurdest permanent stumm geschaltet, da du gegen eine Regel verstoßen hast.", "L'accès à la messagerie instantanée vous a définitivement été retiré suite à une infraction.", "Você foi permanentemente vetado por ter violado uma regra.");
	}

	@OriginalMember(owner = "client!lf", name = "b", descriptor = "(Z)[B")
	@Override
	public byte[] getResponseData() {
		if (super.isRequestInProgress) {
			throw new RuntimeException();
		}

		return this.responseData;
	}

	@OriginalMember(owner = "client!lf", name = "a", descriptor = "(I)I")
	@Override
	public int getDownloadPercentage() {
		return super.isRequestInProgress ? 0 : 100;
	}
}
