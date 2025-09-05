package com.jagex.client.js5;

import com.jagex.client.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!nj")
public final class Js5MasterIndexProvider {

	@OriginalMember(owner = "client!nj", name = "g", descriptor = "[Lclient!lv;")
	private Js5NetResourceProvider[] masterIndexArchiveData;

	@OriginalMember(owner = "client!nj", name = "k", descriptor = "Lclient!iv;")
	private Packet masterIndexResponsePacket;

	@OriginalMember(owner = "client!nj", name = "d", descriptor = "Lclient!vl;")
	private final Js5DiskCache diskQueue;

	@OriginalMember(owner = "client!nj", name = "h", descriptor = "Lclient!vn;")
	private final Js5NetQueue netQueue;

	@OriginalMember(owner = "client!nj", name = "i", descriptor = "Lclient!je;")
	private Js5NetQueueRequest masterIndexRequest;

	@OriginalMember(owner = "client!nj", name = "<init>", descriptor = "(Lclient!vn;Lclient!vl;)V")
	public Js5MasterIndexProvider(@OriginalArg(0) Js5NetQueue netQueue, @OriginalArg(1) Js5DiskCache diskCache) {
		this.netQueue = netQueue;
		this.diskQueue = diskCache;

		if (!this.netQueue.isUrgentRequestQueueFull()) {
			this.masterIndexRequest = this.netQueue.requestArchiveFile(255, (byte) 0, true, 255);
		}
	}

	@OriginalMember(owner = "client!nj", name = "a", descriptor = "(Z)Z")
	public boolean isReady() {
		if (this.masterIndexResponsePacket != null) {
			return true;
		}

		if (this.masterIndexRequest == null) {
			if (this.netQueue.isUrgentRequestQueueFull()) {
				return false;
			}

			this.masterIndexRequest = this.netQueue.requestArchiveFile(255, (byte) 0, true, 255);
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
	public Js5NetResourceProvider getArchiveDataResourceProvider(@OriginalArg(0) Cache arg0, @OriginalArg(1) Cache arg1, @OriginalArg(3) int archive) {
		return this.getArchiveDataResourceProvider(arg1, archive, arg0);
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
	private Js5NetResourceProvider getArchiveDataResourceProvider(Cache arg0, int archive, Cache arg2) {
		if (this.masterIndexResponsePacket == null) {
			throw new RuntimeException();
		}

		this.masterIndexResponsePacket.pos = archive * 8 + 5;

		if (this.masterIndexResponsePacket.data.length <= this.masterIndexResponsePacket.pos) {
			throw new RuntimeException();
		} else if (this.masterIndexArchiveData[archive] == null) {
			int checksum = this.masterIndexResponsePacket.g4();
			int version = this.masterIndexResponsePacket.g4();
			Js5NetResourceProvider resourceProvider = new Js5NetResourceProvider(archive, arg0, arg2, this.netQueue, this.diskQueue, checksum, version, true);

			this.masterIndexArchiveData[archive] = resourceProvider;

			return resourceProvider;
		} else {
			return this.masterIndexArchiveData[archive];
		}
	}
}
