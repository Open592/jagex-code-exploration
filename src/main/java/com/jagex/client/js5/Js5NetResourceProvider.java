package com.jagex.client.js5;

import com.jagex.client.Class183;
import com.jagex.client.Node;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import com.jagex.signlink.MonotonicClock;
import com.jagex.client.HashMap;

import java.util.zip.CRC32;

@OriginalClass("client!lv")
public final class Js5NetResourceProvider extends Js5ResourceProvider {

	@OriginalMember(owner = "client!qj", name = "n", descriptor = "Ljava/util/zip/CRC32;")
	public static final CRC32 aCRC32_1 = new CRC32();

	@OriginalMember(owner = "client!lv", name = "n", descriptor = "[B")
	private byte[] aByteArray56;

	@OriginalMember(owner = "client!lv", name = "t", descriptor = "Lclient!rt;")
	private Class209 aClass209_2;

	@OriginalMember(owner = "client!lv", name = "F", descriptor = "Z")
	private boolean aBoolean413;

	@OriginalMember(owner = "client!lv", name = "w", descriptor = "I")
	private int anInt4482 = 0;

	@OriginalMember(owner = "client!lv", name = "o", descriptor = "Lclient!ib;")
	private final HashMap groupRequests = new HashMap(16);

	@OriginalMember(owner = "client!lv", name = "J", descriptor = "I")
	private int anInt4489 = 0;

	@OriginalMember(owner = "client!lv", name = "G", descriptor = "Lclient!pk;")
	private final Class183 aClass183_30 = new Class183();

	@OriginalMember(owner = "client!lv", name = "L", descriptor = "J")
	private long aLong149 = 0L;

	@OriginalMember(owner = "client!lv", name = "h", descriptor = "Lclient!st;")
	private final Class222 aClass222_3;

	@OriginalMember(owner = "client!lv", name = "j", descriptor = "I")
	private final int archive;

	@OriginalMember(owner = "client!lv", name = "D", descriptor = "Z")
	private boolean aBoolean412;

	@OriginalMember(owner = "client!lv", name = "H", descriptor = "Lclient!pk;")
	private Class183 aClass183_31;

	@OriginalMember(owner = "client!lv", name = "g", descriptor = "I")
	private final int checksum;

	@OriginalMember(owner = "client!lv", name = "k", descriptor = "I")
	private final int version;

	@OriginalMember(owner = "client!lv", name = "K", descriptor = "Z")
	private final boolean aBoolean414;

	@OriginalMember(owner = "client!lv", name = "i", descriptor = "Lclient!st;")
	private final Class222 aClass222_4;

	@OriginalMember(owner = "client!lv", name = "l", descriptor = "Lclient!vn;")
	private final Js5NetQueue js5NetQueue;

	@OriginalMember(owner = "client!lv", name = "B", descriptor = "Lclient!vl;")
	private final Js5DiskCache diskCache;

	@OriginalMember(owner = "client!lv", name = "x", descriptor = "Lclient!ec;")
	private Js5QueueRequest request;

	@OriginalMember(owner = "client!lv", name = "<init>", descriptor = "(ILclient!st;Lclient!st;Lclient!vn;Lclient!vl;IIZ)V")
	public Js5NetResourceProvider(int archive, Class222 arg1, Class222 arg2, Js5NetQueue js5NetQueue, Js5DiskCache arg4, int checksum, int version, boolean arg7) {
		this.aClass222_3 = arg1;
		this.archive = archive;
		if (this.aClass222_3 == null) {
			this.aBoolean412 = false;
		} else {
			this.aBoolean412 = true;
			this.aClass183_31 = new Class183();
		}
		this.checksum = checksum;
		this.version = version;
		this.aBoolean414 = arg7;
		this.aClass222_4 = arg2;
		this.js5NetQueue = js5NetQueue;
		this.diskCache = arg4;
		if (this.aClass222_4 != null) {
			this.request = this.diskCache.method5432(this.aClass222_4, this.archive);
		}
	}

	@OriginalMember(owner = "client!lv", name = "b", descriptor = "(B)I")
	public int method3517() {
		return this.aClass209_2 == null ? 0 : this.aClass209_2.anInt6109;
	}

	@OriginalMember(owner = "client!lv", name = "a", descriptor = "(III)Lclient!ec;")
	private Js5QueueRequest method3518(@OriginalArg(0) int arg0, @OriginalArg(2) int group) {
		@Pc(13) Js5QueueRequest groupRequest = (Js5QueueRequest) this.groupRequests.get(group);

		if (groupRequest != null && arg0 == 0 && !groupRequest.isUrgent && groupRequest.isRequestInProgress) {
			groupRequest.popSelf();
			groupRequest = null;
		}

		if (groupRequest == null) {
			if (arg0 == 0) {
				if (this.aClass222_3 == null || this.aByteArray56[group] == -1) {
					if (this.js5NetQueue.isUrgentRequestQueueFull()) {
						return null;
					}

					groupRequest = this.js5NetQueue.requestArchiveFile(this.archive, (byte) 2, true, group);
				} else {
					groupRequest = this.diskCache.method5432(this.aClass222_3, group);
				}
			} else if (arg0 == 1) {
				if (this.aClass222_3 == null) {
					throw new RuntimeException();
				}

				groupRequest = this.diskCache.method5431(this.aClass222_3, group);
			} else if (arg0 == 2) {
				if (this.aClass222_3 == null) {
					throw new RuntimeException();
				}

				if (this.aByteArray56[group] != -1) {
					throw new RuntimeException();
				}

				if (this.js5NetQueue.isRegularRequestQueueFull()) {
					return null;
				}

				groupRequest = this.js5NetQueue.requestArchiveFile(this.archive, (byte) 2, false, group);
			} else {
				throw new RuntimeException();
			}

			this.groupRequests.set(group, groupRequest);
		}
		if (groupRequest.isRequestInProgress) {
			return null;
		}

		@Pc(161) byte[] local161 = groupRequest.getResponseData();
		@Pc(188) int local188;
		@Pc(238) Js5NetQueueRequest local238;

		if (!(groupRequest instanceof Js5DiskCacheRequestItem)) {
			try {
				if (local161 == null || local161.length <= 2) {
					throw new RuntimeException();
				}
				aCRC32_1.reset();
				aCRC32_1.update(local161, 0, local161.length - 2);
				local188 = (int) aCRC32_1.getValue();
				if (local188 != this.aClass209_2.anIntArray430[group]) {
					throw new RuntimeException();
				}
				this.js5NetQueue.js5ConnectAttempts = 0;
				this.js5NetQueue.errorCode = 0;
			} catch (@Pc(213) RuntimeException local213) {
				this.js5NetQueue.method5464();
				groupRequest.popSelf();
				if (groupRequest.isUrgent && !this.js5NetQueue.isUrgentRequestQueueFull()) {
					local238 = this.js5NetQueue.requestArchiveFile(this.archive, (byte) 2, true, group);
					this.groupRequests.set((long) group, local238);
				}
				return null;
			}
			local161[local161.length - 2] = (byte) (this.aClass209_2.anIntArray429[group] >>> 8);
			local161[local161.length - 1] = (byte) this.aClass209_2.anIntArray429[group];
			if (this.aClass222_3 != null) {
				this.diskCache.method5435(group, local161, this.aClass222_3);
				if (this.aByteArray56[group] != 1) {
					this.anInt4482++;
					this.aByteArray56[group] = 1;
				}
			}
			if (!groupRequest.isUrgent) {
				groupRequest.popSelf();
			}
			return groupRequest;
		}
		try {
			if (local161 == null || local161.length <= 2) {
				throw new RuntimeException();
			}
			aCRC32_1.reset();
			aCRC32_1.update(local161, 0, local161.length - 2);
			local188 = (int) aCRC32_1.getValue();
			if (this.aClass209_2.anIntArray430[group] != local188) {
				throw new RuntimeException();
			}
			@Pc(371) int local371 = ((local161[local161.length - 2] & 0xFF) << 8) + (local161[local161.length - 1] & 0xFF);
			if (local371 != (this.aClass209_2.anIntArray429[group] & 0xFFFF)) {
				throw new RuntimeException();
			}
			if (this.aByteArray56[group] != 1) {
				this.anInt4482++;
				this.aByteArray56[group] = 1;
			}
			if (!groupRequest.isUrgent) {
				groupRequest.popSelf();
			}
			return groupRequest;
		} catch (@Pc(412) Exception local412) {
			this.aByteArray56[group] = -1;
			groupRequest.popSelf();
			if (groupRequest.isUrgent && !this.js5NetQueue.isUrgentRequestQueueFull()) {
				local238 = this.js5NetQueue.requestArchiveFile(this.archive, (byte) 2, true, group);
				this.groupRequests.set((long) group, local238);
			}
			return null;
		}
	}

	@OriginalMember(owner = "client!lv", name = "b", descriptor = "(II)[B")
	@Override
	public byte[] method3516(@OriginalArg(1) int arg0) {
		@Pc(16) Js5QueueRequest local16 = this.method3518(0, arg0);
		if (local16 == null) {
			return null;
		} else {
			@Pc(24) byte[] local24 = local16.getResponseData();
			local16.popSelf();
			return local24;
		}
	}

	@OriginalMember(owner = "client!lv", name = "d", descriptor = "(I)V")
	public void method3520() {
		if (this.aClass183_31 != null) {
			if (this.method3514() == null) {
				return;
			}
			@Pc(21) boolean local21;
			@Pc(28) Node local28;
			@Pc(34) int local34;
			@Pc(127) Node local127;
			if (this.aBoolean412) {
				local21 = true;
				for (local28 = this.aClass183_31.method4140(); local28 != null; local28 = this.aClass183_31.method4144()) {
					local34 = (int) local28.hashKey;
					if (this.aByteArray56[local34] == 0) {
						this.method3518(1, local34);
					}
					if (this.aByteArray56[local34] == 0) {
						local21 = false;
					} else {
						local28.popSelf();
					}
				}
				while (this.anInt4489 < this.aClass209_2.anIntArray428.length) {
					if (this.aClass209_2.anIntArray428[this.anInt4489] == 0) {
						this.anInt4489++;
					} else {
						if (this.diskCache.anInt7015 >= 250) {
							local21 = false;
							break;
						}
						if (this.aByteArray56[this.anInt4489] == 0) {
							this.method3518(1, this.anInt4489);
						}
						if (this.aByteArray56[this.anInt4489] == 0) {
							local127 = new Node();
							local127.hashKey = this.anInt4489;
							local21 = false;
							this.aClass183_31.method4137(local127);
						}
						this.anInt4489++;
					}
				}
				if (local21) {
					this.anInt4489 = 0;
					this.aBoolean412 = false;
				}
			} else if (this.aBoolean413) {
				local21 = true;
				for (local28 = this.aClass183_31.method4140(); local28 != null; local28 = this.aClass183_31.method4144()) {
					local34 = (int) local28.hashKey;
					if (this.aByteArray56[local34] != 1) {
						this.method3518(2, local34);
					}
					if (this.aByteArray56[local34] == 1) {
						local28.popSelf();
					} else {
						local21 = false;
					}
				}
				while (this.anInt4489 < this.aClass209_2.anIntArray428.length) {
					if (this.aClass209_2.anIntArray428[this.anInt4489] == 0) {
						this.anInt4489++;
					} else {
						if (this.js5NetQueue.isRegularRequestQueueFull()) {
							local21 = false;
							break;
						}
						if (this.aByteArray56[this.anInt4489] != 1) {
							this.method3518(2, this.anInt4489);
						}
						if (this.aByteArray56[this.anInt4489] != 1) {
							local127 = new Node();
							local127.hashKey = this.anInt4489;
							local21 = false;
							this.aClass183_31.method4137(local127);
						}
						this.anInt4489++;
					}
				}
				if (local21) {
					this.anInt4489 = 0;
					this.aBoolean413 = false;
				}
			} else {
				this.aClass183_31 = null;
			}
		}
		if (!this.aBoolean414 || this.aLong149 > MonotonicClock.getCurrentTimeInMilliseconds()) {
			return;
		}
		for (@Pc(325) Js5QueueRequest request = (Js5QueueRequest) this.groupRequests.head(); request != null; request = (Js5QueueRequest) this.groupRequests.next()) {
			if (!request.isRequestInProgress) {
				if (request.isRequested) {
					if (!request.isUrgent) {
						throw new RuntimeException();
					}
					request.popSelf();
				} else {
					request.isRequested = true;
				}
			}
		}
		this.aLong149 = MonotonicClock.getCurrentTimeInMilliseconds() + 1000L;
	}

	@OriginalMember(owner = "client!lv", name = "a", descriptor = "(Z)I")
	public int method3521() {
		if (this.aClass209_2 == null) {
			return 0;
		} else if (this.aBoolean412) {
			@Pc(25) Node local25 = this.aClass183_31.method4140();
			return local25 == null ? 0 : (int) local25.hashKey;
		} else {
			return this.aClass209_2.anInt6109;
		}
	}

	@OriginalMember(owner = "client!lv", name = "a", descriptor = "(IB)I")
	@Override
	public int getDownloadPercentage(@OriginalArg(0) int arg0) {
		@Pc(11) Js5QueueRequest local11 = (Js5QueueRequest) this.groupRequests.get(arg0);
		return local11 == null ? 0 : local11.getDownloadPercentage();
	}

	@OriginalMember(owner = "client!lv", name = "c", descriptor = "(B)V")
	public void method3522() {
		if (this.aClass183_31 == null || this.method3514() == null) {
			return;
		}
		for (@Pc(23) Node local23 = this.aClass183_30.method4140(); local23 != null; local23 = this.aClass183_30.method4144()) {
			@Pc(29) int local29 = (int) local23.hashKey;
			if (local29 < 0 || local29 >= this.aClass209_2.anInt6112 || this.aClass209_2.anIntArray428[local29] == 0) {
				local23.popSelf();
			} else {
				if (this.aByteArray56[local29] == 0) {
					this.method3518(1, local29);
				}
				if (this.aByteArray56[local29] == -1) {
					this.method3518(2, local29);
				}
				if (this.aByteArray56[local29] == 1) {
					local23.popSelf();
				}
			}
		}
	}

	@OriginalMember(owner = "client!lv", name = "f", descriptor = "(I)I")
	public int getDownloadPercentage() {
		if (this.method3514() == null) {
			return this.request == null ? 0 : this.request.getDownloadPercentage();
		} else {
			return 100;
		}
	}

	@OriginalMember(owner = "client!lv", name = "a", descriptor = "(II)V")
	@Override
	public void method3512(int arg0) {
		if (this.aClass222_3 == null) {
			return;
		}

		for (Node local14 = this.aClass183_30.method4140(); local14 != null; local14 = this.aClass183_30.method4144()) {
			if (local14.hashKey == (long) arg0) {
				return;
			}
		}

		Node local43 = new Node();

		local43.hashKey = arg0;

		this.aClass183_30.method4137(local43);
	}

	@OriginalMember(owner = "client!lv", name = "d", descriptor = "(B)V")
	public void method3526() {
		if (this.aClass222_3 != null) {
			this.aBoolean413 = true;

			if (this.aClass183_31 == null) {
				this.aClass183_31 = new Class183();
			}
		}
	}

	@OriginalMember(owner = "client!lv", name = "g", descriptor = "(I)I")
	public int method3527() {
		return this.anInt4482;
	}

	@OriginalMember(owner = "client!lv", name = "a", descriptor = "(B)Lclient!rt;")
	@Override
	public Class209 method3514() {
		if (this.aClass209_2 != null) {
			return this.aClass209_2;
		}

		if (this.request == null) {
			if (this.js5NetQueue.isUrgentRequestQueueFull()) {
				return null;
			}

			this.request = this.js5NetQueue.requestArchiveFile(255, (byte) 0, true, this.archive);
		}

		if (this.request.isRequestInProgress) {
			return null;
		}

		byte[] responseData = this.request.getResponseData();

		if (this.request instanceof Js5DiskCacheRequestItem) {
			try {
				if (responseData == null) {
					throw new RuntimeException();
				}

				this.aClass209_2 = new Class209(responseData, this.checksum);

				if (this.aClass209_2.anInt6113 != this.version) {
					throw new RuntimeException();
				}
			} catch (@Pc(133) RuntimeException local133) {
				this.aClass209_2 = null;

				if (this.js5NetQueue.isUrgentRequestQueueFull()) {
					this.request = null;
				} else {
					this.request = this.js5NetQueue.requestArchiveFile(255, (byte) 0, true, this.archive);
				}

				return null;
			}
		} else {
			try {
				if (responseData == null) {
					throw new RuntimeException();
				}

				this.aClass209_2 = new Class209(responseData, this.checksum);
			} catch (@Pc(63) RuntimeException local63) {
				this.js5NetQueue.method5464();
				this.aClass209_2 = null;

				if (this.js5NetQueue.isUrgentRequestQueueFull()) {
					this.request = null;
				} else {
					this.request = this.js5NetQueue.requestArchiveFile(255, (byte) 0, true, this.archive);
				}

				return null;
			}
			if (this.aClass222_4 != null) {
				this.diskCache.method5435(this.archive, responseData, this.aClass222_4);
			}
		}

		this.request = null;

		if (this.aClass222_3 != null) {
			this.aByteArray56 = new byte[this.aClass209_2.anInt6112];
			this.anInt4482 = 0;
		}

		return this.aClass209_2;
	}
}
