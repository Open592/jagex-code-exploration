package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!nj")
public final class Class159 {

	@OriginalMember(owner = "client!nj", name = "g", descriptor = "[Lclient!lv;")
	private Class143_Sub1[] aClass143_Sub1Array2;

	@OriginalMember(owner = "client!nj", name = "k", descriptor = "Lclient!iv;")
	private Packet responsePacket;

	@OriginalMember(owner = "client!nj", name = "d", descriptor = "Lclient!vl;")
	private final Class254 aClass254_2;

	@OriginalMember(owner = "client!nj", name = "h", descriptor = "Lclient!vn;")
	private final JS5Connection js5Connection;

	@OriginalMember(owner = "client!nj", name = "i", descriptor = "Lclient!je;")
	private JS5NetRequest archiveFileRequest;

	@OriginalMember(owner = "client!nj", name = "<init>", descriptor = "(Lclient!vn;Lclient!vl;)V")
	public Class159(@OriginalArg(0) JS5Connection js5Connection, @OriginalArg(1) Class254 arg1) {
		this.js5Connection = js5Connection;
		this.aClass254_2 = arg1;

		if (!this.js5Connection.isUrgentRequestQueueFull()) {
			this.archiveFileRequest = this.js5Connection.requestArchiveFile(255, (byte) 0, true, 255);
		}
	}

	@OriginalMember(owner = "client!nj", name = "a", descriptor = "(Z)Z")
	public boolean method3814() {
		if (this.responsePacket != null) {
			return true;
		}

		if (this.archiveFileRequest == null) {
			if (this.js5Connection.isUrgentRequestQueueFull()) {
				return false;
			}
			this.archiveFileRequest = this.js5Connection.requestArchiveFile(255, (byte) 0, true, 255);
		}

		if (this.archiveFileRequest.isRequestInProgress) {
			return false;
		} else {
			this.responsePacket = new Packet(this.archiveFileRequest.getResponseData());
			this.aClass143_Sub1Array2 = new Class143_Sub1[(this.responsePacket.data.length - 5) / 8];

			return true;
		}
	}

	@OriginalMember(owner = "client!nj", name = "a", descriptor = "(Lclient!st;Lclient!st;II)Lclient!lv;")
	public Class143_Sub1 method3817(@OriginalArg(0) Class222 arg0, @OriginalArg(1) Class222 arg1, @OriginalArg(3) int archive) {
		return this.method3821(arg1, archive, arg0);
	}

	@OriginalMember(owner = "client!nj", name = "b", descriptor = "(I)V")
	public void method3819() {
		if (this.aClass143_Sub1Array2 == null) {
			return;
		}

        for (Class143_Sub1 class143_sub1 : this.aClass143_Sub1Array2) {
            if (class143_sub1 != null) {
                class143_sub1.method3522();
            }
        }

        for (Class143_Sub1 class143Sub1 : this.aClass143_Sub1Array2) {
            if (class143Sub1 != null) {
                class143Sub1.method3520();
            }
        }
	}

	@OriginalMember(owner = "client!nj", name = "a", descriptor = "(Lclient!st;ZBILclient!st;)Lclient!lv;")
	private Class143_Sub1 method3821(Class222 arg0, int archive, Class222 arg2) {
		if (this.responsePacket == null) {
			throw new RuntimeException();
		}
		this.responsePacket.pos = archive * 8 + 5;
		if (this.responsePacket.data.length <= this.responsePacket.pos) {
			throw new RuntimeException();
		} else if (this.aClass143_Sub1Array2[archive] == null) {
			int checksum = this.responsePacket.g4();
			int version = this.responsePacket.g4();
			Class143_Sub1 local64 = new Class143_Sub1(archive, arg0, arg2, this.js5Connection, this.aClass254_2, checksum, version, true);

			this.aClass143_Sub1Array2[archive] = local64;

			return local64;
		} else {
			return this.aClass143_Sub1Array2[archive];
		}
	}
}
