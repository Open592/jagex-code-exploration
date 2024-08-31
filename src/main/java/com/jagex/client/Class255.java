package com.jagex.client;

import java.io.IOException;

import com.jagex.signlink.MonotonicClock;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!vn")
public final class Class255 {

	@OriginalMember(owner = "client!vn", name = "v", descriptor = "Lclient!al;")
	private ServerConnection serverConnection;

	@OriginalMember(owner = "client!vn", name = "w", descriptor = "J")
	private long aLong217;

	@OriginalMember(owner = "client!vn", name = "y", descriptor = "I")
	private int anInt7061;

	@OriginalMember(owner = "client!vn", name = "D", descriptor = "Lclient!je;")
	private LinkedEntry_Sub1_Sub6_Sub1 aClass4_Sub1_Sub6_Sub1_2;

	@OriginalMember(owner = "client!vn", name = "j", descriptor = "Lclient!tn;")
	private final Class229 aClass229_7 = new Class229();

	@OriginalMember(owner = "client!vn", name = "s", descriptor = "Lclient!tn;")
	private final Class229 aClass229_8 = new Class229();

	@OriginalMember(owner = "client!vn", name = "t", descriptor = "Lclient!tn;")
	private final Class229 aClass229_9 = new Class229();

	@OriginalMember(owner = "client!vn", name = "u", descriptor = "Lclient!tn;")
	private final Class229 aClass229_10 = new Class229();

	@OriginalMember(owner = "client!vn", name = "x", descriptor = "Lclient!iv;")
	private final Packet aPacket_8 = new Packet(4);

	@OriginalMember(owner = "client!vn", name = "A", descriptor = "I")
	public volatile int clientInitializationAttemptCount = 0;

	@OriginalMember(owner = "client!vn", name = "B", descriptor = "B")
	private byte aByte94 = 0;

	@OriginalMember(owner = "client!vn", name = "C", descriptor = "I")
	public volatile int anInt7063 = 0;

	@OriginalMember(owner = "client!vn", name = "z", descriptor = "Lclient!iv;")
	private final Packet aPacket_9 = new Packet(8);

	@OriginalMember(owner = "client!vn", name = "a", descriptor = "(B)I")
	private int method5459() {
		return this.aClass229_9.method5093() + this.aClass229_10.method5093();
	}

	@OriginalMember(owner = "client!vn", name = "a", descriptor = "(I)Z")
	public boolean method5460() {
		return this.method5469() >= 20;
	}

	@OriginalMember(owner = "client!vn", name = "a", descriptor = "(ILclient!al;Z)V")
	public void method5461(@OriginalArg(1) ServerConnection serverConnection, @OriginalArg(2) boolean arg1) {
		if (this.serverConnection != null) {
			try {
				this.serverConnection.shutdown();
			} catch (@Pc(14) Exception local14) {
			}
			this.serverConnection = null;
		}

		this.serverConnection = serverConnection;
		this.method5462();
		this.method5463(arg1);
		this.aPacket_9.pos = 0;
		this.aClass4_Sub1_Sub6_Sub1_2 = null;

		while (true) {
			@Pc(40) LinkedEntry_Sub1_Sub6_Sub1 local40 = (LinkedEntry_Sub1_Sub6_Sub1) this.aClass229_8.method5091();
			if (local40 == null) {
				while (true) {
					local40 = (LinkedEntry_Sub1_Sub6_Sub1) this.aClass229_10.method5091();
					if (local40 == null) {
						if (this.aByte94 != 0) {
							try {
								this.aPacket_8.pos = 0;
								this.aPacket_8.p1(4);
								this.aPacket_8.p1(this.aByte94);
								this.aPacket_8.p2(0);
								this.serverConnection.enqueueClientMessage(4, this.aPacket_8.data);
							} catch (@Pc(102) IOException local102) {
								try {
									this.serverConnection.shutdown();
								} catch (@Pc(108) Exception local108) {
								}
								this.anInt7063 = -2;
								this.clientInitializationAttemptCount++;
								this.serverConnection = null;
							}
						}
						this.anInt7061 = 0;
						this.aLong217 = MonotonicClock.getCurrentTimeInMilliseconds();
						return;
					}
					this.aClass229_9.method5088(local40);
				}
			}
			this.aClass229_7.method5088(local40);
		}
	}

	@OriginalMember(owner = "client!vn", name = "b", descriptor = "(B)V")
	private void method5462() {
		if (this.serverConnection == null) {
			return;
		}
		try {
			this.aPacket_8.pos = 0;
			this.aPacket_8.p1(6);
			this.aPacket_8.p3(3);
			this.serverConnection.enqueueClientMessage(4, this.aPacket_8.data);
		} catch (@Pc(38) IOException local38) {
			try {
				this.serverConnection.shutdown();
			} catch (@Pc(44) Exception local44) {
			}
			this.serverConnection = null;
			this.clientInitializationAttemptCount++;
			this.anInt7063 = -2;
		}
	}

	@OriginalMember(owner = "client!vn", name = "a", descriptor = "(ZB)V")
	public void method5463(@OriginalArg(0) boolean arg0) {
		if (this.serverConnection == null) {
			return;
		}
		try {
			this.aPacket_8.pos = 0;
			this.aPacket_8.p1(arg0 ? 2 : 3);
			this.aPacket_8.p3(0);
			this.serverConnection.enqueueClientMessage(4, this.aPacket_8.data);
		} catch (@Pc(41) IOException local41) {
			try {
				this.serverConnection.shutdown();
			} catch (@Pc(47) Exception local47) {
			}
			this.anInt7063 = -2;
			this.serverConnection = null;
			this.clientInitializationAttemptCount++;
		}
	}

	@OriginalMember(owner = "client!vn", name = "c", descriptor = "(B)V")
	public void method5464() {
		try {
			this.serverConnection.shutdown();
		} catch (@Pc(9) Exception local9) {
		}
		this.serverConnection = null;
		this.anInt7063 = -1;
		this.aByte94 = (byte) (Math.random() * 255.0D + 1.0D);
		this.clientInitializationAttemptCount++;
	}

	@OriginalMember(owner = "client!vn", name = "a", descriptor = "(IBBZI)Lclient!je;")
	public LinkedEntry_Sub1_Sub6_Sub1 method5465(@OriginalArg(0) int arg0, @OriginalArg(1) byte arg1, @OriginalArg(3) boolean arg2, @OriginalArg(4) int arg3) {
		@Pc(19) long local19 = (long) ((arg0 << 16) + arg3);
		@Pc(23) LinkedEntry_Sub1_Sub6_Sub1 local23 = new LinkedEntry_Sub1_Sub6_Sub1();
		local23.aLong198 = local19;
		local23.aBoolean384 = arg2;
		local23.aByte24 = arg1;
		if (arg2) {
			if (this.method5469() >= 20) {
				throw new RuntimeException();
			}
			this.aClass229_7.method5088(local23);
		} else if (this.method5459() < 20) {
			this.aClass229_9.method5088(local23);
		} else {
			throw new RuntimeException();
		}
		return local23;
	}

	@OriginalMember(owner = "client!vn", name = "d", descriptor = "(B)V")
	public void method5466() {
		if (this.serverConnection != null) {
			this.serverConnection.breakConnection();
		}
	}

	@OriginalMember(owner = "client!vn", name = "e", descriptor = "(B)V")
	public void method5467() {
		if (this.serverConnection == null) {
			return;
		}
		try {
			this.aPacket_8.pos = 0;
			this.aPacket_8.p1(7);
			this.aPacket_8.p3(0);
			this.serverConnection.enqueueClientMessage(4, this.aPacket_8.data);
		} catch (@Pc(32) IOException local32) {
			try {
				this.serverConnection.shutdown();
			} catch (@Pc(38) Exception local38) {
			}
			this.anInt7063 = -2;
			this.serverConnection = null;
			this.clientInitializationAttemptCount++;
		}
	}

	@OriginalMember(owner = "client!vn", name = "b", descriptor = "(I)Z")
	public boolean method5468() {
		@Pc(18) int local18;
		if (this.serverConnection != null) {
			@Pc(11) long local11 = MonotonicClock.getCurrentTimeInMilliseconds();
			local18 = (int) (local11 - this.aLong217);
			this.aLong217 = local11;
			if (local18 > 200) {
				local18 = 200;
			}
			this.anInt7061 += local18;
			if (this.anInt7061 > 30000) {
				try {
					this.serverConnection.shutdown();
				} catch (@Pc(42) Exception local42) {
				}
				this.serverConnection = null;
			}
		}
		if (this.serverConnection == null) {
			return this.method5469() == 0 && this.method5459() == 0;
		}
		try {
			this.serverConnection.checkConnectionHealth();
			for (@Pc(76) LinkedEntry_Sub1_Sub6_Sub1 local76 = (LinkedEntry_Sub1_Sub6_Sub1) this.aClass229_7.method5089(); local76 != null; local76 = (LinkedEntry_Sub1_Sub6_Sub1) this.aClass229_7.method5092()) {
				this.aPacket_8.pos = 0;
				this.aPacket_8.p1(1);
				this.aPacket_8.p3((int) local76.aLong198);
				this.serverConnection.enqueueClientMessage(4, this.aPacket_8.data);
				this.aClass229_8.method5088(local76);
			}
			for (@Pc(122) LinkedEntry_Sub1_Sub6_Sub1 local122 = (LinkedEntry_Sub1_Sub6_Sub1) this.aClass229_9.method5089(); local122 != null; local122 = (LinkedEntry_Sub1_Sub6_Sub1) this.aClass229_9.method5092()) {
				this.aPacket_8.pos = 0;
				this.aPacket_8.p1(0);
				this.aPacket_8.p3((int) local122.aLong198);
				this.serverConnection.enqueueClientMessage(4, this.aPacket_8.data);
				this.aClass229_10.method5088(local122);
			}
			for (local18 = 0; local18 < 100; local18++) {
				@Pc(177) int local177 = this.serverConnection.getEstimatedBytesAvailable();
				if (local177 < 0) {
					throw new IOException();
				}
				if (local177 == 0) {
					break;
				}
				this.anInt7061 = 0;
				@Pc(190) byte local190 = 0;
				if (this.aClass4_Sub1_Sub6_Sub1_2 == null) {
					local190 = 8;
				} else if (this.aClass4_Sub1_Sub6_Sub1_2.anInt3510 == 0) {
					local190 = 1;
				}
				@Pc(219) int local219;
				@Pc(226) int local226;
				@Pc(275) int local275;
				if (local190 <= 0) {
					local219 = this.aClass4_Sub1_Sub6_Sub1_2.aClass4_Sub12_4.data.length - this.aClass4_Sub1_Sub6_Sub1_2.aByte24;
					local226 = 512 - this.aClass4_Sub1_Sub6_Sub1_2.anInt3510;
					if (local219 - this.aClass4_Sub1_Sub6_Sub1_2.aClass4_Sub12_4.pos < local226) {
						local226 = local219 - this.aClass4_Sub1_Sub6_Sub1_2.aClass4_Sub12_4.pos;
					}
					if (local226 > local177) {
						local226 = local177;
					}
					this.serverConnection.readBytesFromServer(this.aClass4_Sub1_Sub6_Sub1_2.aClass4_Sub12_4.pos, local226, this.aClass4_Sub1_Sub6_Sub1_2.aClass4_Sub12_4.data);
					if (this.aByte94 != 0) {
						for (local275 = 0; local275 < local226; local275++) {
							this.aClass4_Sub1_Sub6_Sub1_2.aClass4_Sub12_4.data[local275 + this.aClass4_Sub1_Sub6_Sub1_2.aClass4_Sub12_4.pos] ^= this.aByte94;
						}
					}
					this.aClass4_Sub1_Sub6_Sub1_2.aClass4_Sub12_4.pos += local226;
					this.aClass4_Sub1_Sub6_Sub1_2.anInt3510 += local226;
					if (this.aClass4_Sub1_Sub6_Sub1_2.aClass4_Sub12_4.pos == local219) {
						this.aClass4_Sub1_Sub6_Sub1_2.method4662();
						this.aClass4_Sub1_Sub6_Sub1_2.aBoolean381 = false;
						this.aClass4_Sub1_Sub6_Sub1_2 = null;
					} else if (this.aClass4_Sub1_Sub6_Sub1_2.anInt3510 == 512) {
						this.aClass4_Sub1_Sub6_Sub1_2.anInt3510 = 0;
					}
				} else {
					local219 = local190 - this.aPacket_9.pos;
					if (local219 > local177) {
						local219 = local177;
					}
					this.serverConnection.readBytesFromServer(this.aPacket_9.pos, local219, this.aPacket_9.data);
					if (this.aByte94 != 0) {
						for (local226 = 0; local226 < local219; local226++) {
							this.aPacket_9.data[this.aPacket_9.pos + local226] ^= this.aByte94;
						}
					}
					this.aPacket_9.pos += local219;
					if (local190 <= this.aPacket_9.pos) {
						if (this.aClass4_Sub1_Sub6_Sub1_2 == null) {
							this.aPacket_9.pos = 0;
							local226 = this.aPacket_9.g1();
							local275 = this.aPacket_9.g2();
							@Pc(459) int local459 = this.aPacket_9.g1();
							@Pc(464) int local464 = this.aPacket_9.g4();
							@Pc(468) int local468 = local459 & 0x7F;
							@Pc(479) boolean local479 = (local459 & 0x80) != 0;
							@Pc(486) long local486 = (long) ((local226 << 16) + local275);
							@Pc(496) LinkedEntry_Sub1_Sub6_Sub1 local496;
							if (local479) {
								for (local496 = (LinkedEntry_Sub1_Sub6_Sub1) this.aClass229_10.method5089(); local496 != null && local496.aLong198 != local486; local496 = (LinkedEntry_Sub1_Sub6_Sub1) this.aClass229_10.method5092()) {
								}
							} else {
								for (local496 = (LinkedEntry_Sub1_Sub6_Sub1) this.aClass229_8.method5089(); local496 != null && local496.aLong198 != local486; local496 = (LinkedEntry_Sub1_Sub6_Sub1) this.aClass229_8.method5092()) {
								}
							}
							if (local496 == null) {
								throw new IOException();
							}
							@Pc(549) int local549 = local468 == 0 ? 5 : 9;
							this.aClass4_Sub1_Sub6_Sub1_2 = local496;
							this.aClass4_Sub1_Sub6_Sub1_2.aClass4_Sub12_4 = new Packet(local549 + local464 + this.aClass4_Sub1_Sub6_Sub1_2.aByte24);
							this.aClass4_Sub1_Sub6_Sub1_2.aClass4_Sub12_4.p1(local468);
							this.aClass4_Sub1_Sub6_Sub1_2.aClass4_Sub12_4.p4(local464);
							this.aPacket_9.pos = 0;
							this.aClass4_Sub1_Sub6_Sub1_2.anInt3510 = 8;
						} else if (this.aClass4_Sub1_Sub6_Sub1_2.anInt3510 != 0) {
							throw new IOException();
						} else if (this.aPacket_9.data[0] == -1) {
							this.aClass4_Sub1_Sub6_Sub1_2.anInt3510 = 1;
							this.aPacket_9.pos = 0;
						} else {
							this.aClass4_Sub1_Sub6_Sub1_2 = null;
						}
					}
				}
			}
			return true;
		} catch (@Pc(627) IOException local627) {
			try {
				this.serverConnection.shutdown();
			} catch (@Pc(633) Exception local633) {
			}
			this.clientInitializationAttemptCount++;
			this.anInt7063 = -2;
			this.serverConnection = null;
			return this.method5469() == 0 && this.method5459() == 0;
		}
	}

	@OriginalMember(owner = "client!vn", name = "c", descriptor = "(I)I")
	public int method5469() {
		return this.aClass229_7.method5093() + this.aClass229_8.method5093();
	}

	@OriginalMember(owner = "client!vn", name = "f", descriptor = "(B)Z")
	public boolean method5472() {
		return this.method5459() >= 20;
	}

	@OriginalMember(owner = "client!vn", name = "e", descriptor = "(I)V")
	public void method5474() {
		if (this.serverConnection != null) {
			this.serverConnection.shutdown();
		}
	}
}
