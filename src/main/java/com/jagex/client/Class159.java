package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!nj")
public final class Class159 {

	@OriginalMember(owner = "client!nj", name = "g", descriptor = "[Lclient!lv;")
	private Js5NetResourceProvider[] masterIndexArchiveData;

	@OriginalMember(owner = "client!nj", name = "k", descriptor = "Lclient!iv;")
	private Packet masterIndexResponsePacket;

	@OriginalMember(owner = "client!nj", name = "d", descriptor = "Lclient!vl;")
	private final Js5DiskCache aJs5DiskCache_2;

	@OriginalMember(owner = "client!nj", name = "h", descriptor = "Lclient!vn;")
	private final Js5NetQueue js5NetQueue;

	@OriginalMember(owner = "client!nj", name = "i", descriptor = "Lclient!je;")
	private Js5NetQueueRequest masterIndexRequest;

	@OriginalMember(owner = "client!nj", name = "<init>", descriptor = "(Lclient!vn;Lclient!vl;)V")
	public Class159(@OriginalArg(0) Js5NetQueue js5NetQueue, @OriginalArg(1) Js5DiskCache arg1) {
		this.js5NetQueue = js5NetQueue;
		this.aJs5DiskCache_2 = arg1;

		if (!this.js5NetQueue.isUrgentRequestQueueFull()) {
			this.masterIndexRequest = this.js5NetQueue.requestArchiveFile(255, (byte) 0, true, 255);
		}
	}

	@OriginalMember(owner = "client!nj", name = "a", descriptor = "(Z)Z")
	public boolean isReady() {
		if (this.masterIndexResponsePacket != null) {
			return true;
		}

		if (this.masterIndexRequest == null) {
			if (this.js5NetQueue.isUrgentRequestQueueFull()) {
				return false;
			}

			this.masterIndexRequest = this.js5NetQueue.requestArchiveFile(255, (byte) 0, true, 255);
		}

		if (this.masterIndexRequest.isRequestInProgress) {
			return false;
		} else {
			this.masterIndexResponsePacket = new Packet(this.masterIndexRequest.getResponseData());
			this.masterIndexArchiveData = new Js5NetResourceProvider[(this.masterIndexResponsePacket.data.length - 5) / 8];

			return true;
		}
	}

	@OriginalMember(owner = "client!nj", name = "a", descriptor = "(Lclient!st;Lclient!st;II)Lclient!lv;")
	public Js5NetResourceProvider method3817(@OriginalArg(0) Class222 arg0, @OriginalArg(1) Class222 arg1, @OriginalArg(3) int archive) {
		return this.getArchiveData(arg1, archive, arg0);
	}

	@OriginalMember(owner = "client!nj", name = "b", descriptor = "(I)V")
	public void method3819() {
		if (this.masterIndexArchiveData == null) {
			return;
		}

        for (Js5NetResourceProvider class143_sub1 : this.masterIndexArchiveData) {
            if (class143_sub1 != null) {
                class143_sub1.method3522();
            }
        }

        for (Js5NetResourceProvider class143Sub1 : this.masterIndexArchiveData) {
            if (class143Sub1 != null) {
                class143Sub1.method3520();
            }
        }
	}

	@OriginalMember(owner = "client!nj", name = "a", descriptor = "(Lclient!st;ZBILclient!st;)Lclient!lv;")
	private Js5NetResourceProvider getArchiveData(Class222 arg0, int archive, Class222 arg2) {
		if (this.masterIndexResponsePacket == null) {
			throw new RuntimeException();
		}

		this.masterIndexResponsePacket.pos = archive * 8 + 5;

		if (this.masterIndexResponsePacket.data.length <= this.masterIndexResponsePacket.pos) {
			throw new RuntimeException();
		} else if (this.masterIndexArchiveData[archive] == null) {
			int checksum = this.masterIndexResponsePacket.g4();
			int version = this.masterIndexResponsePacket.g4();
			Js5NetResourceProvider local64 = new Js5NetResourceProvider(archive, arg0, arg2, this.js5NetQueue, this.aJs5DiskCache_2, checksum, version, true);

			this.masterIndexArchiveData[archive] = local64;

			return local64;
		} else {
			return this.masterIndexArchiveData[archive];
		}
	}
}
