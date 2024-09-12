package com.jagex.client;

import java.io.IOException;

import com.jagex.signlink.MonotonicClock;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!vn")
public final class JS5Connection {

	@OriginalMember(owner = "client!vn", name = "v", descriptor = "Lclient!al;")
	private ServerConnection serverConnection;

	@OriginalMember(owner = "client!vn", name = "w", descriptor = "J")
	private long aLong217;

	@OriginalMember(owner = "client!vn", name = "y", descriptor = "I")
	private int anInt7061;

	@OriginalMember(owner = "client!vn", name = "D", descriptor = "Lclient!je;")
	private JS5NetRequest aClass4_Sub1_Sub6_Sub1_2;

	@OriginalMember(owner = "client!vn", name = "j", descriptor = "Lclient!tn;")
	private final SecondaryLinkedList pendingUrgentRequests = new SecondaryLinkedList();

	@OriginalMember(owner = "client!vn", name = "s", descriptor = "Lclient!tn;")
	private final SecondaryLinkedList activeUrgentRequests = new SecondaryLinkedList();

	@OriginalMember(owner = "client!vn", name = "t", descriptor = "Lclient!tn;")
	private final SecondaryLinkedList pendingRegularRequests = new SecondaryLinkedList();

	@OriginalMember(owner = "client!vn", name = "u", descriptor = "Lclient!tn;")
	private final SecondaryLinkedList activeRegularRequests = new SecondaryLinkedList();

	@OriginalMember(owner = "client!vn", name = "x", descriptor = "Lclient!iv;")
	private final Packet outgoingPacket = new Packet(4);

	@OriginalMember(owner = "client!vn", name = "z", descriptor = "Lclient!iv;")
	private final Packet incomingPacket = new Packet(8);

	@OriginalMember(owner = "client!vn", name = "A", descriptor = "I")
	public volatile int js5ConnectAttempts = 0;

	@OriginalMember(owner = "client!vn", name = "B", descriptor = "B")
	private byte obfuscationKey = 0;

	@OriginalMember(owner = "client!vn", name = "c", descriptor = "(I)I")
	public int getUrgentRequestCount() {
		return this.pendingUrgentRequests.size() + this.activeUrgentRequests.size();
	}

	@OriginalMember(owner = "client!vn", name = "a", descriptor = "(I)Z")
	public boolean isUrgentRequestQueueFull() {
		return this.getUrgentRequestCount() >= 20;
	}

	@OriginalMember(owner = "client!vn", name = "C", descriptor = "I")
	public volatile int errorCode = 0;

	@OriginalMember(owner = "client!vn", name = "a", descriptor = "(B)I")
	private int getRegularRequestCount() {
		return this.pendingRegularRequests.size() + this.activeRegularRequests.size();
	}

	@OriginalMember(owner = "client!vn", name = "f", descriptor = "(B)Z")
	public boolean isRegularRequestQueueFull() {
		return this.getRegularRequestCount() >= 20;
	}

	@OriginalMember(owner = "client!vn", name = "a", descriptor = "(ILclient!al;Z)V")
	public void init(@OriginalArg(1) ServerConnection serverConnection, @OriginalArg(2) boolean arg1) {
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
		this.incomingPacket.pos = 0;
		this.aClass4_Sub1_Sub6_Sub1_2 = null;

		while (true) {
			@Pc(40) JS5NetRequest request = (JS5NetRequest) this.activeUrgentRequests.popHead();

			if (request == null) {
				while (true) {
					request = (JS5NetRequest) this.activeRegularRequests.popHead();

					if (request == null) {
						if (this.obfuscationKey != 0) {
							try {
								this.outgoingPacket.pos = 0;
								this.outgoingPacket.p1(JS5RequestOpCodes.JS5_STORE_OBFUSCATION_KEY);
								this.outgoingPacket.p1(this.obfuscationKey);
								this.outgoingPacket.p2(0);
								this.serverConnection.write(4, this.outgoingPacket.data);
							} catch (@Pc(102) IOException local102) {
								try {
									this.serverConnection.shutdown();
								} catch (@Pc(108) Exception local108) {
								}
								this.errorCode = -2;
								this.js5ConnectAttempts++;
								this.serverConnection = null;
							}
						}

						this.anInt7061 = 0;
						this.aLong217 = MonotonicClock.getCurrentTimeInMilliseconds();

						return;
					}
					this.pendingRegularRequests.insert(request);
				}
			}
			this.pendingUrgentRequests.insert(request);
		}
	}

	@OriginalMember(owner = "client!vn", name = "b", descriptor = "(B)V")
	private void method5462() {
		if (this.serverConnection == null) {
			return;
		}

		try {
			this.outgoingPacket.pos = 0;
			this.outgoingPacket.p1(6);
			this.outgoingPacket.p3(3);
			this.serverConnection.write(4, this.outgoingPacket.data);
		} catch (@Pc(38) IOException local38) {
			try {
				this.serverConnection.shutdown();
			} catch (@Pc(44) Exception local44) {
			}

			this.serverConnection = null;
			this.js5ConnectAttempts++;
			this.errorCode = -2;
		}
	}

	@OriginalMember(owner = "client!vn", name = "c", descriptor = "(B)V")
	public void method5464() {
		try {
			this.serverConnection.shutdown();
		} catch (@Pc(9) Exception local9) {
		}

		this.serverConnection = null;
		this.errorCode = -1;
		this.obfuscationKey = (byte) (Math.random() * 255.0D + 1.0D);
		this.js5ConnectAttempts++;
	}

	@OriginalMember(owner = "client!vn", name = "a", descriptor = "(IBBZI)Lclient!je;")
	public JS5NetRequest requestArchiveFile(@OriginalArg(0) int archive, @OriginalArg(1) byte arg1, @OriginalArg(3) boolean isUrgent, @OriginalArg(4) int group) {
		@Pc(19) long archiveGroupId = ((long) archive << 16) + group;

		@Pc(23) JS5NetRequest request = new JS5NetRequest();
		request.secondaryValue = archiveGroupId;
		request.isUrgent = isUrgent;
		request.aByte24 = arg1;

		if (isUrgent) {
			if (this.getUrgentRequestCount() >= 20) {
				throw new RuntimeException();
			}
			this.pendingUrgentRequests.insert(request);
		} else if (this.getRegularRequestCount() < 20) {
			this.pendingRegularRequests.insert(request);
		} else {
			throw new RuntimeException();
		}

		return request;
	}

	@OriginalMember(owner = "client!vn", name = "d", descriptor = "(B)V")
	public void breakConnection() {
		if (this.serverConnection != null) {
			this.serverConnection.breakConnection();
		}
	}

	@OriginalMember(owner = "client!vn", name = "a", descriptor = "(ZB)V")
	public void method5463(@OriginalArg(0) boolean arg0) {
		if (this.serverConnection == null) {
			return;
		}

		try {
			this.outgoingPacket.pos = 0;
			this.outgoingPacket.p1(arg0 ? 2 : 3);
			this.outgoingPacket.p3(0);
			this.serverConnection.write(4, this.outgoingPacket.data);
		} catch (@Pc(41) IOException e) {
			try {
				this.serverConnection.shutdown();
			} catch (@Pc(47) Exception ignored) {
			}

			this.errorCode = -2;
			this.serverConnection = null;
			this.js5ConnectAttempts++;
		}
	}

	@OriginalMember(owner = "client!vn", name = "e", descriptor = "(B)V")
	public void requestServerToDropRequests() {
		if (this.serverConnection == null) {
			return;
		}

		try {
			this.outgoingPacket.pos = 0;
			this.outgoingPacket.p1(JS5RequestOpCodes.JS5_DROP_ACTIVE_REQUESTS);
			this.outgoingPacket.p3(0);
			this.serverConnection.write(4, this.outgoingPacket.data);
		} catch (@Pc(32) IOException local32) {
			try {
				this.serverConnection.shutdown();
			} catch (@Pc(38) Exception local38) {
			}
			this.errorCode = -2;
			this.serverConnection = null;
			this.js5ConnectAttempts++;
		}
	}

	@OriginalMember(owner = "client!vn", name = "b", descriptor = "(I)Z")
	public boolean method5468() {
		@Pc(18) int local18;

		if (this.serverConnection != null) {
			@Pc(11) long currentTimeInMilliseconds = MonotonicClock.getCurrentTimeInMilliseconds();

			local18 = (int) (currentTimeInMilliseconds - this.aLong217);

			this.aLong217 = currentTimeInMilliseconds;

			if (local18 > 200) {
				local18 = 200;
			}

			this.anInt7061 += local18;

			if (this.anInt7061 > 30000) {
				try {
					this.serverConnection.shutdown();
				} catch (@Pc(42) Exception ignored) {
				}

				this.serverConnection = null;
			}
		}

		if (this.serverConnection == null) {
			return this.getUrgentRequestCount() == 0 && this.getRegularRequestCount() == 0;
		}

		try {
			this.serverConnection.verifyIsHealthy();

			for (@Pc(76) JS5NetRequest request = (JS5NetRequest) this.pendingUrgentRequests.getHead(); request != null; request = (JS5NetRequest) this.pendingUrgentRequests.next()) {
				this.outgoingPacket.pos = 0;
				this.outgoingPacket.p1(JS5RequestOpCodes.JS5_URGENT_REQUEST);
				this.outgoingPacket.p3((int) request.secondaryValue);
				this.serverConnection.write(4, this.outgoingPacket.data);
				this.activeUrgentRequests.insert(request);
			}

			for (@Pc(122) JS5NetRequest request = (JS5NetRequest) this.pendingRegularRequests.getHead(); request != null; request = (JS5NetRequest) this.pendingRegularRequests.next()) {
				this.outgoingPacket.pos = 0;
				this.outgoingPacket.p1(JS5RequestOpCodes.JS5_REGULAR_REQUEST);
				this.outgoingPacket.p3((int) request.secondaryValue);
				this.serverConnection.write(4, this.outgoingPacket.data);
				this.activeRegularRequests.insert(request);
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

					this.serverConnection.readBytesFromServer(
							this.aClass4_Sub1_Sub6_Sub1_2.aClass4_Sub12_4.pos,
							local226,
							this.aClass4_Sub1_Sub6_Sub1_2.aClass4_Sub12_4.data
					);

					if (this.obfuscationKey != 0) {
						for (local275 = 0; local275 < local226; local275++) {
							this.aClass4_Sub1_Sub6_Sub1_2.aClass4_Sub12_4.data[local275 + this.aClass4_Sub1_Sub6_Sub1_2.aClass4_Sub12_4.pos] ^= this.obfuscationKey;
						}
					}
					this.aClass4_Sub1_Sub6_Sub1_2.aClass4_Sub12_4.pos += local226;
					this.aClass4_Sub1_Sub6_Sub1_2.anInt3510 += local226;

					if (this.aClass4_Sub1_Sub6_Sub1_2.aClass4_Sub12_4.pos == local219) {
						this.aClass4_Sub1_Sub6_Sub1_2.secondaryPopSelf();
						this.aClass4_Sub1_Sub6_Sub1_2.aBoolean381 = false;
						this.aClass4_Sub1_Sub6_Sub1_2 = null;
					} else if (this.aClass4_Sub1_Sub6_Sub1_2.anInt3510 == 512) {
						this.aClass4_Sub1_Sub6_Sub1_2.anInt3510 = 0;
					}
				} else {
					local219 = local190 - this.incomingPacket.pos;

					if (local219 > local177) {
						local219 = local177;
					}

					this.serverConnection.readBytesFromServer(this.incomingPacket.pos, local219, this.incomingPacket.data);

					if (this.obfuscationKey != 0) {
						for (local226 = 0; local226 < local219; local226++) {
							this.incomingPacket.data[this.incomingPacket.pos + local226] ^= this.obfuscationKey;
						}
					}

					this.incomingPacket.pos += local219;

					if (local190 <= this.incomingPacket.pos) {
						if (this.aClass4_Sub1_Sub6_Sub1_2 == null) {
							this.incomingPacket.pos = 0;
							local226 = this.incomingPacket.g1();
							local275 = this.incomingPacket.g2();
							@Pc(459) int local459 = this.incomingPacket.g1();
							@Pc(464) int local464 = this.incomingPacket.g4();
							@Pc(468) int local468 = local459 & 0x7F;
							@Pc(479) boolean local479 = (local459 & 0x80) != 0;
							@Pc(486) long local486 = ((long) local226 << 16) + local275;
							@Pc(496) JS5NetRequest local496;
							if (local479) {
								for (local496 = (JS5NetRequest) this.activeRegularRequests.getHead(); local496 != null && local496.secondaryValue != local486; local496 = (JS5NetRequest) this.activeRegularRequests.next()) {
								}
							} else {
								for (local496 = (JS5NetRequest) this.activeUrgentRequests.getHead(); local496 != null && local496.secondaryValue != local486; local496 = (JS5NetRequest) this.activeUrgentRequests.next()) {
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
							this.incomingPacket.pos = 0;
							this.aClass4_Sub1_Sub6_Sub1_2.anInt3510 = 8;
						} else if (this.aClass4_Sub1_Sub6_Sub1_2.anInt3510 != 0) {
							throw new IOException();
						} else if (this.incomingPacket.data[0] == -1) {
							this.aClass4_Sub1_Sub6_Sub1_2.anInt3510 = 1;
							this.incomingPacket.pos = 0;
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
			this.js5ConnectAttempts++;
			this.errorCode = -2;
			this.serverConnection = null;
			return this.getUrgentRequestCount() == 0 && this.getRegularRequestCount() == 0;
		}
	}

	@OriginalMember(owner = "client!vn", name = "e", descriptor = "(I)V")
	public void shutdown() {
		if (this.serverConnection != null) {
			this.serverConnection.shutdown();
		}
	}
}
