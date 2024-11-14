package com.jagex.client.js5;

import java.io.EOFException;
import java.io.IOException;

import com.jagex.client.Class139;
import com.jagex.client.Static166;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!st")
public final class Class222 {

	@OriginalMember(owner = "client!st", name = "b", descriptor = "Lclient!lq;")
	private final Class139 cacheMasterIndexFile;

	@OriginalMember(owner = "client!st", name = "a", descriptor = "Lclient!lq;")
	private final Class139 cacheDataFile;

	@OriginalMember(owner = "client!st", name = "g", descriptor = "I")
	private final int anInt6379;

	@OriginalMember(owner = "client!st", name = "k", descriptor = "I")
	private final int archive;

	@OriginalMember(owner = "client!st", name = "<init>", descriptor = "(ILclient!lq;Lclient!lq;I)V")
	public Class222(int archive, Class139 cacheDataFile, Class139 cacheMasterIndexFile, int arg3) {
		this.cacheMasterIndexFile = cacheMasterIndexFile;
		this.cacheDataFile = cacheDataFile;
		this.archive = archive;

		// Was originally given a redundant default of 65000
		this.anInt6379 = arg3;
	}

	@OriginalMember(owner = "client!st", name = "toString", descriptor = "()Ljava/lang/String;")
	@Override
	public String toString() {
		return "Cache:" + this.archive;
	}

	@OriginalMember(owner = "client!st", name = "a", descriptor = "(II)[B")
	public byte[] method4981(@OriginalArg(1) int arg0) {
		@Pc(8) Class139 local8 = this.cacheDataFile;
		synchronized (this.cacheDataFile) {
			try {
				if (this.cacheMasterIndexFile.method3463() < (arg0 * 6L + 6)) {
					return null;
				}

				this.cacheMasterIndexFile.seek(arg0 * 6L);
				this.cacheMasterIndexFile.method3471(0, 6, Static166.aByteArray37);

				int local70 = (Static166.aByteArray37[2] & 0xFF) + (((Static166.aByteArray37[0] & 0xFF) << 16) + ((Static166.aByteArray37[1] & 0xFF) << 8));
				int local93 = ((Static166.aByteArray37[3] & 0xFF) << 16) + ((Static166.aByteArray37[4] & 0xFF) << 8) + (Static166.aByteArray37[5] & 0xFF);

				if (local70 < 0 || local70 > this.anInt6379) {
					return null;
				} else if (local93 > 0 && (long) local93 <= this.cacheDataFile.method3463() / 520L) {
					byte[] local137 = new byte[local70];
					int local139 = 0;
					int local147 = 0;

					while (local139 < local70) {
						if (local93 == 0) {
							return null;
						}

						this.cacheDataFile.seek((long) (local93 * 520));

						int local170 = local70 - local139;

						if (local170 > 512) {
							local170 = 512;
						}

						this.cacheDataFile.method3471(0, local170 + 8, Static166.aByteArray37);

						int local201 = ((Static166.aByteArray37[0] & 0xFF) << 8) + (Static166.aByteArray37[1] & 0xFF);
						int local215 = (Static166.aByteArray37[3] & 0xFF) + ((Static166.aByteArray37[2] & 0xFF) << 8);
						int local237 = ((Static166.aByteArray37[5] & 0xFF) << 8) + ((Static166.aByteArray37[4] & 0xFF) << 16) + (Static166.aByteArray37[6] & 0xFF);
						int local243 = Static166.aByteArray37[7] & 0xFF;

						if (arg0 == local201 && local147 == local215 && this.archive == local243) {
							if (local237 >= 0 && (long) local237 <= this.cacheDataFile.method3463() / 520L) {
								for (int i = 0; i < local170; i++) {
									local137[local139++] = Static166.aByteArray37[i + 8];
								}

								local147++;
								local93 = local237;

								continue;
							}

							return null;
						}

						return null;
					}

					return local137;
				} else {
					return null;
				}
			} catch (IOException local322) {
				return null;
			}
		}
	}

	@OriginalMember(owner = "client!st", name = "a", descriptor = "([BZII)Z")
	public boolean method4982(@OriginalArg(0) byte[] arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2) {
		@Pc(12) Class139 local12 = this.cacheDataFile;
		synchronized (this.cacheDataFile) {
			if (arg2 < 0 || arg2 > this.anInt6379) {
				throw new IllegalArgumentException();
			}
			@Pc(35) boolean local35 = this.method4983(arg1, arg0, arg2, true);
			if (!local35) {
				local35 = this.method4983(arg1, arg0, arg2, false);
			}
			return local35;
		}
	}

	@OriginalMember(owner = "client!st", name = "a", descriptor = "(II[BIZ)Z")
	private boolean method4983(@OriginalArg(0) int arg0, @OriginalArg(2) byte[] arg1, @OriginalArg(3) int arg2, @OriginalArg(4) boolean arg3) {
		@Pc(8) Class139 local8 = this.cacheDataFile;
		synchronized (this.cacheDataFile) {
			try {
				@Pc(67) int local67;
				if (arg3) {
					if ((long) (arg0 * 6 + 6) > this.cacheMasterIndexFile.method3463()) {
						return false;
					}
					this.cacheMasterIndexFile.seek((long) (arg0 * 6));
					this.cacheMasterIndexFile.method3471(0, 6, Static166.aByteArray37);
					local67 = ((Static166.aByteArray37[4] & 0xFF) << 8) + (Static166.aByteArray37[3] << 16 & 0xFF0000) + (Static166.aByteArray37[5] & 0xFF);
					if (local67 <= 0 || this.cacheDataFile.method3463() / 520L < (long) local67) {
						return false;
					}
				} else {
					local67 = (int) ((this.cacheDataFile.method3463() + 519L) / 520L);
					if (local67 == 0) {
						local67 = 1;
					}
				}
				Static166.aByteArray37[3] = (byte) (local67 >> 16);
				Static166.aByteArray37[5] = (byte) local67;
				Static166.aByteArray37[2] = (byte) arg2;
				Static166.aByteArray37[0] = (byte) (arg2 >> 16);
				Static166.aByteArray37[4] = (byte) (local67 >> 8);
				Static166.aByteArray37[1] = (byte) (arg2 >> 8);
				this.cacheMasterIndexFile.seek((long) (arg0 * 6));
				this.cacheMasterIndexFile.method3464(0, Static166.aByteArray37, 6);
				@Pc(163) int local163 = 0;
				@Pc(165) int local165 = 0;
				while (arg2 > local163) {
					@Pc(169) int local169 = 0;
					@Pc(204) int local204;
					if (arg3) {
						this.cacheDataFile.seek((long) (local67 * 520));
						try {
							this.cacheDataFile.method3471(0, 8, Static166.aByteArray37);
						} catch (@Pc(188) EOFException local188) {
							return true;
						}
						local204 = (Static166.aByteArray37[1] & 0xFF) + ((Static166.aByteArray37[0] & 0xFF) << 8);
						local169 = ((Static166.aByteArray37[4] & 0xFF) << 16) + ((Static166.aByteArray37[5] & 0xFF) << 8) + (Static166.aByteArray37[6] & 0xFF);
						@Pc(242) int local242 = ((Static166.aByteArray37[2] & 0xFF) << 8) + (Static166.aByteArray37[3] & 0xFF);
						@Pc(248) int local248 = Static166.aByteArray37[7] & 0xFF;
						if (arg0 != local204 || local242 != local165 || this.archive != local248) {
							return false;
						}
						if (local169 < 0 || (long) local169 > this.cacheDataFile.method3463() / 520L) {
							return false;
						}
					}
					if (local169 == 0) {
						arg3 = false;
						local169 = (int) ((this.cacheDataFile.method3463() + 519L) / 520L);
						if (local169 == 0) {
							local169++;
						}
						if (local67 == local169) {
							local169++;
						}
					}
					Static166.aByteArray37[1] = (byte) arg0;
					Static166.aByteArray37[2] = (byte) (local165 >> 8);
					Static166.aByteArray37[0] = (byte) (arg0 >> 8);
					Static166.aByteArray37[3] = (byte) local165;
					if (arg2 - local163 <= 512) {
						local169 = 0;
					}
					Static166.aByteArray37[7] = (byte) this.archive;
					Static166.aByteArray37[5] = (byte) (local169 >> 8);
					Static166.aByteArray37[4] = (byte) (local169 >> 16);
					Static166.aByteArray37[6] = (byte) local169;
					this.cacheDataFile.seek((long) (local67 * 520));
					this.cacheDataFile.method3464(0, Static166.aByteArray37, 8);
					local204 = arg2 - local163;
					if (local204 > 512) {
						local204 = 512;
					}
					this.cacheDataFile.method3464(local163, arg1, local204);
					local165++;
					local163 += local204;
					local67 = local169;
				}
				return true;
			} catch (@Pc(432) IOException local432) {
				return false;
			}
		}
	}
}
