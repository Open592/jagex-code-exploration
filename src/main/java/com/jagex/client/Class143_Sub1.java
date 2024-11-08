package com.jagex.client;

import com.jagex.signlink.MonotonicClock;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!lv")
public final class Class143_Sub1 extends Class143 {

	@OriginalMember(owner = "client!lv", name = "n", descriptor = "[B")
	private byte[] aByteArray56;

	@OriginalMember(owner = "client!lv", name = "t", descriptor = "Lclient!rt;")
	private Class209 aClass209_2;

	@OriginalMember(owner = "client!lv", name = "F", descriptor = "Z")
	private boolean aBoolean413;

	@OriginalMember(owner = "client!lv", name = "w", descriptor = "I")
	private int anInt4482 = 0;

	@OriginalMember(owner = "client!lv", name = "o", descriptor = "Lclient!ib;")
	private final HashMap aHashMap_20 = new HashMap(16);

	@OriginalMember(owner = "client!lv", name = "J", descriptor = "I")
	private int anInt4489 = 0;

	@OriginalMember(owner = "client!lv", name = "G", descriptor = "Lclient!pk;")
	private final Class183 aClass183_30 = new Class183();

	@OriginalMember(owner = "client!lv", name = "L", descriptor = "J")
	private long aLong149 = 0L;

	@OriginalMember(owner = "client!lv", name = "h", descriptor = "Lclient!st;")
	private final Class222 aClass222_3;

	@OriginalMember(owner = "client!lv", name = "j", descriptor = "I")
	private final int anInt4474;

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
	private final JS5Connection js5Connection;

	@OriginalMember(owner = "client!lv", name = "B", descriptor = "Lclient!vl;")
	private final Class254 aClass254_1;

	@OriginalMember(owner = "client!lv", name = "x", descriptor = "Lclient!ec;")
	private SecondaryNode_Sub1_Sub6 aClass4_Sub1_Sub6_1;

	@OriginalMember(owner = "client!lv", name = "<init>", descriptor = "(ILclient!st;Lclient!st;Lclient!vn;Lclient!vl;IIZ)V")
	public Class143_Sub1(int arg0, Class222 arg1, Class222 arg2, JS5Connection js5Connection, Class254 arg4, int checksum, int version, boolean arg7) {
		this.aClass222_3 = arg1;
		this.anInt4474 = arg0;
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
		this.js5Connection = js5Connection;
		this.aClass254_1 = arg4;
		if (this.aClass222_4 != null) {
			this.aClass4_Sub1_Sub6_1 = this.aClass254_1.method5432(this.aClass222_4, this.anInt4474);
		}
	}

	@OriginalMember(owner = "client!lv", name = "b", descriptor = "(B)I")
	public int method3517() {
		return this.aClass209_2 == null ? 0 : this.aClass209_2.anInt6109;
	}

	@OriginalMember(owner = "client!lv", name = "a", descriptor = "(III)Lclient!ec;")
	private SecondaryNode_Sub1_Sub6 method3518(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
		@Pc(13) SecondaryNode_Sub1_Sub6 local13 = (SecondaryNode_Sub1_Sub6) this.aHashMap_20.get((long) arg1);
		if (local13 != null && arg0 == 0 && !local13.isUrgent && local13.isRequestInProgress) {
			local13.popSelf();
			local13 = null;
		}
		if (local13 == null) {
			if (arg0 == 0) {
				if (this.aClass222_3 == null || this.aByteArray56[arg1] == -1) {
					if (this.js5Connection.isUrgentRequestQueueFull()) {
						return null;
					}
					local13 = this.js5Connection.requestArchiveFile(this.anInt4474, (byte) 2, true, arg1);
				} else {
					local13 = this.aClass254_1.method5432(this.aClass222_3, arg1);
				}
			} else if (arg0 == 1) {
				if (this.aClass222_3 == null) {
					throw new RuntimeException();
				}
				local13 = this.aClass254_1.method5431(this.aClass222_3, arg1);
			} else if (arg0 == 2) {
				if (this.aClass222_3 == null) {
					throw new RuntimeException();
				}
				if (this.aByteArray56[arg1] != -1) {
					throw new RuntimeException();
				}
				if (this.js5Connection.isRegularRequestQueueFull()) {
					return null;
				}
				local13 = this.js5Connection.requestArchiveFile(this.anInt4474, (byte) 2, false, arg1);
			} else {
				throw new RuntimeException();
			}
			this.aHashMap_20.set((long) arg1, local13);
		}
		if (local13.isRequestInProgress) {
			return null;
		}
		@Pc(161) byte[] local161 = local13.getResponseData();
		@Pc(188) int local188;
		@Pc(238) JS5NetRequest local238;
		if (!(local13 instanceof SecondaryNode_Sub1_Sub6_Sub2)) {
			try {
				if (local161 == null || local161.length <= 2) {
					throw new RuntimeException();
				}
				Static327.aCRC32_1.reset();
				Static327.aCRC32_1.update(local161, 0, local161.length - 2);
				local188 = (int) Static327.aCRC32_1.getValue();
				if (local188 != this.aClass209_2.anIntArray430[arg1]) {
					throw new RuntimeException();
				}
				this.js5Connection.js5ConnectAttempts = 0;
				this.js5Connection.errorCode = 0;
			} catch (@Pc(213) RuntimeException local213) {
				this.js5Connection.method5464();
				local13.popSelf();
				if (local13.isUrgent && !this.js5Connection.isUrgentRequestQueueFull()) {
					local238 = this.js5Connection.requestArchiveFile(this.anInt4474, (byte) 2, true, arg1);
					this.aHashMap_20.set((long) arg1, local238);
				}
				return null;
			}
			local161[local161.length - 2] = (byte) (this.aClass209_2.anIntArray429[arg1] >>> 8);
			local161[local161.length - 1] = (byte) this.aClass209_2.anIntArray429[arg1];
			if (this.aClass222_3 != null) {
				this.aClass254_1.method5435(arg1, local161, this.aClass222_3);
				if (this.aByteArray56[arg1] != 1) {
					this.anInt4482++;
					this.aByteArray56[arg1] = 1;
				}
			}
			if (!local13.isUrgent) {
				local13.popSelf();
			}
			return local13;
		}
		try {
			if (local161 == null || local161.length <= 2) {
				throw new RuntimeException();
			}
			Static327.aCRC32_1.reset();
			Static327.aCRC32_1.update(local161, 0, local161.length - 2);
			local188 = (int) Static327.aCRC32_1.getValue();
			if (this.aClass209_2.anIntArray430[arg1] != local188) {
				throw new RuntimeException();
			}
			@Pc(371) int local371 = ((local161[local161.length - 2] & 0xFF) << 8) + (local161[local161.length - 1] & 0xFF);
			if (local371 != (this.aClass209_2.anIntArray429[arg1] & 0xFFFF)) {
				throw new RuntimeException();
			}
			if (this.aByteArray56[arg1] != 1) {
				this.anInt4482++;
				this.aByteArray56[arg1] = 1;
			}
			if (!local13.isUrgent) {
				local13.popSelf();
			}
			return local13;
		} catch (@Pc(412) Exception local412) {
			this.aByteArray56[arg1] = -1;
			local13.popSelf();
			if (local13.isUrgent && !this.js5Connection.isUrgentRequestQueueFull()) {
				local238 = this.js5Connection.requestArchiveFile(this.anInt4474, (byte) 2, true, arg1);
				this.aHashMap_20.set((long) arg1, local238);
			}
			return null;
		}
	}

	@OriginalMember(owner = "client!lv", name = "b", descriptor = "(II)[B")
	@Override
	public byte[] method3516(@OriginalArg(1) int arg0) {
		@Pc(16) SecondaryNode_Sub1_Sub6 local16 = this.method3518(0, arg0);
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
						if (this.aClass254_1.anInt7015 >= 250) {
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
						if (this.js5Connection.isRegularRequestQueueFull()) {
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
		for (@Pc(325) SecondaryNode_Sub1_Sub6 local325 = (SecondaryNode_Sub1_Sub6) this.aHashMap_20.head(); local325 != null; local325 = (SecondaryNode_Sub1_Sub6) this.aHashMap_20.next()) {
			if (!local325.isRequestInProgress) {
				if (local325.aBoolean382) {
					if (!local325.isUrgent) {
						throw new RuntimeException();
					}
					local325.popSelf();
				} else {
					local325.aBoolean382 = true;
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
	public int method3515(@OriginalArg(0) int arg0) {
		@Pc(11) SecondaryNode_Sub1_Sub6 local11 = (SecondaryNode_Sub1_Sub6) this.aHashMap_20.get((long) arg0);
		return local11 == null ? 0 : local11.method3342();
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
	public int method3525() {
		if (this.method3514() == null) {
			return this.aClass4_Sub1_Sub6_1 == null ? 0 : this.aClass4_Sub1_Sub6_1.method3342();
		} else {
			return 100;
		}
	}

	@OriginalMember(owner = "client!lv", name = "a", descriptor = "(II)V")
	@Override
	public void method3512(@OriginalArg(0) int arg0) {
		if (this.aClass222_3 == null) {
			return;
		}
		for (@Pc(14) Node local14 = this.aClass183_30.method4140(); local14 != null; local14 = this.aClass183_30.method4144()) {
			if (local14.hashKey == (long) arg0) {
				return;
			}
		}
		@Pc(43) Node local43 = new Node();
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
		if (this.aClass4_Sub1_Sub6_1 == null) {
			if (this.js5Connection.isUrgentRequestQueueFull()) {
				return null;
			}
			this.aClass4_Sub1_Sub6_1 = this.js5Connection.requestArchiveFile(255, (byte) 0, true, this.anInt4474);
		}
		if (this.aClass4_Sub1_Sub6_1.isRequestInProgress) {
			return null;
		}

		@Pc(43) byte[] responseData = this.aClass4_Sub1_Sub6_1.getResponseData();

		if (this.aClass4_Sub1_Sub6_1 instanceof SecondaryNode_Sub1_Sub6_Sub2) {
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
				if (this.js5Connection.isUrgentRequestQueueFull()) {
					this.aClass4_Sub1_Sub6_1 = null;
				} else {
					this.aClass4_Sub1_Sub6_1 = this.js5Connection.requestArchiveFile(255, (byte) 0, true, this.anInt4474);
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
				this.js5Connection.method5464();
				this.aClass209_2 = null;
				if (this.js5Connection.isUrgentRequestQueueFull()) {
					this.aClass4_Sub1_Sub6_1 = null;
				} else {
					this.aClass4_Sub1_Sub6_1 = this.js5Connection.requestArchiveFile(255, (byte) 0, true, this.anInt4474);
				}
				return null;
			}
			if (this.aClass222_4 != null) {
				this.aClass254_1.method5435(this.anInt4474, responseData, this.aClass222_4);
			}
		}
		this.aClass4_Sub1_Sub6_1 = null;
		if (this.aClass222_3 != null) {
			this.aByteArray56 = new byte[this.aClass209_2.anInt6112];
			this.anInt4482 = 0;
		}
		return this.aClass209_2;
	}
}
