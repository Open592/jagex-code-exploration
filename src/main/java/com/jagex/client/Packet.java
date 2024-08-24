package com.jagex.client;

import java.math.BigInteger;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!iv")
public class Packet extends Class4 {

	@OriginalMember(owner = "client!iv", name = "z", descriptor = "[B")
	public byte[] data;

	@OriginalMember(owner = "client!iv", name = "rb", descriptor = "I")
	public int pos;

	static {
		new Class83("Join your channel by clicking 'Join Chat' and typing: ", "Klick auf 'Betreten' und gib ein: ", "Pour rejoindre votre canal, cliquez sur « Participer » et entrez : ", "Para entrar no seu canal, clique em \"Acessar bate-papo\" e digite: ");
	}

	@OriginalMember(owner = "client!iv", name = "<init>", descriptor = "(I)V")
	public Packet(@OriginalArg(0) int arg0) {
		this.data = Static277.method3931(arg0);
		this.pos = 0;
	}

	@OriginalMember(owner = "client!iv", name = "<init>", descriptor = "([B)V")
	public Packet(@OriginalArg(0) byte[] arg0) {
		this.data = arg0;
		this.pos = 0;
	}

	@OriginalMember(owner = "client!iv", name = "a", descriptor = "(I)I")
	public final int g1() {
		return this.data[this.pos++] & 0xFF;
	}

	@OriginalMember(owner = "client!iv", name = "l", descriptor = "(I)I")
	public final int g1_alt1() {
		return this.data[this.pos++] - 128 & 0xFF;
	}

	@OriginalMember(owner = "client!iv", name = "m", descriptor = "(I)I")
	public final int g1_alt2() {
		return -this.data[this.pos++] & 0xFF;
	}

	@OriginalMember(owner = "client!iv", name = "c", descriptor = "(B)I")
	public final int g1_alt3() {
		return 128 - this.data[this.pos++] & 0xFF;
	}

	@OriginalMember(owner = "client!iv", name = "c", descriptor = "(Z)B")
	public final byte g1s() {
		return this.data[this.pos++];
	}

	@OriginalMember(owner = "client!iv", name = "s", descriptor = "(I)B")
	public final byte g1s_alt1() {
		return (byte) (this.data[this.pos++] - 128);
	}

	@OriginalMember(owner = "client!iv", name = "h", descriptor = "(I)B")
	public final byte g1s_alt2() {
		return (byte) -this.g1s();
	}

	@OriginalMember(owner = "client!iv", name = "o", descriptor = "(I)B")
	public final byte g1s_alt3() {
		return (byte) (128 - this.data[this.pos++]);
	}

	@OriginalMember(owner = "client!iv", name = "i", descriptor = "(II)V")
	public final void pSize1(@OriginalArg(1) int length) {
		this.data[this.pos - length - 1] = (byte) length;
	}

	@OriginalMember(owner = "client!iv", name = "l", descriptor = "(II)V")
	public final void p1(@OriginalArg(1) int value) {
		this.data[this.pos++] = (byte) value;
	}

	@OriginalMember(owner = "client!iv", name = "a", descriptor = "(BI)V")
	public final void p1_alt1(@OriginalArg(1) int value) {
		this.data[this.pos++] = (byte) (value + 128);
	}

	@OriginalMember(owner = "client!iv", name = "h", descriptor = "(II)V")
	public final void p1_alt2(@OriginalArg(0) int value) {
		this.p1(-value);
	}

	@OriginalMember(owner = "client!iv", name = "e", descriptor = "(II)V")
	public final void p1s_alt3(@OriginalArg(1) int arg0) {
		this.data[this.pos++] = (byte) (128 - arg0);
	}

	@OriginalMember(owner = "client!iv", name = "l", descriptor = "(B)I")
	public final int g2() {
		this.pos += 2;

		return (this.data[this.pos - 1] & 0xFF)
				+ ((this.data[this.pos - 2] & 0xFF) << 8);
	}

	@OriginalMember(owner = "client!iv", name = "q", descriptor = "(I)I")
	public final int g2_alt1() {
		this.pos += 2;

		return ((this.data[this.pos - 1] & 0xFF) << 8)
				+ (this.data[this.pos - 2] & 0xFF);
	}

	@OriginalMember(owner = "client!iv", name = "r", descriptor = "(I)I")
	public final int g2_alt2() {
		this.pos += 2;

		return (this.data[this.pos - 1] - 128 & 0xFF)
				+ ((this.data[this.pos - 2] & 0xFF) << 8);
	}

	@OriginalMember(owner = "client!iv", name = "i", descriptor = "(B)I")
	public final int g2_alt3() {
		this.pos += 2;

		return ((this.data[this.pos - 1] & 0xFF) << 8)
				+ (this.data[this.pos - 2] - 128 & 0xFF);
	}

	@OriginalMember(owner = "client!iv", name = "h", descriptor = "(B)I")
	public final int g2s() {
		this.pos += 2;

		@Pc(38) int result = (this.data[this.pos - 1] & 0xFF) + ((this.data[this.pos - 2] & 0xFF) << 8);

		if (result > 32767) {
			result -= 65536;
		}

		return result;
	}

	@OriginalMember(owner = "client!iv", name = "e", descriptor = "(B)I")
	public final int g2s_alt1() {
		this.pos += 2;

		@Pc(37) int result = ((this.data[this.pos - 1] & 0xFF) << 8) + (this.data[this.pos - 2] & 0xFF);

		if (result > 32767) {
			result -= 65536;
		}

		return result;
	}

	@OriginalMember(owner = "client!iv", name = "g", descriptor = "(B)I")
	public final int g2s_alt2() {
		this.pos += 2;

		@Pc(39) int result = (this.data[this.pos - 1] - 128 & 0xFF) + ((this.data[this.pos - 2] & 0xFF) << 8);

		if (result > 32767) {
			result -= 65536;
		}

		return result;
	}

	@OriginalMember(owner = "client!iv", name = "p", descriptor = "(I)I")
	public final int gts_alt3() {
		this.pos += 2;

		@Pc(39) int result = ((this.data[this.pos - 1] & 0xFF) << 8) + (this.data[this.pos - 2] - 128 & 0xFF);

		if (result > 32767) {
			result -= 65536;
		}

		return result;
	}

	@OriginalMember(owner = "client!iv", name = "j", descriptor = "(II)V")
	public final void pSize2(@OriginalArg(1) int length) {
		this.data[this.pos - length - 2] = (byte) (length >> 8);
		this.data[this.pos - length - 1] = (byte) length;
	}

	@OriginalMember(owner = "client!iv", name = "d", descriptor = "(BI)V")
	public final void p2(@OriginalArg(1) int value) {
		this.data[this.pos++] = (byte) (value >> 8);
		this.data[this.pos++] = (byte) value;
	}

	@OriginalMember(owner = "client!iv", name = "e", descriptor = "(BI)V")
	public final void p2_alt1(@OriginalArg(1) int value) {
		this.data[this.pos++] = (byte) value;
		this.data[this.pos++] = (byte) (value >> 8);
	}

	@OriginalMember(owner = "client!iv", name = "a", descriptor = "(IB)V")
	public final void writeInt16LE(@OriginalArg(0) int value) {
		this.data[this.pos++] = (byte) value;
		this.data[this.pos++] = (byte) (value >> 8);
	}

	@OriginalMember(owner = "client!iv", name = "c", descriptor = "(BI)V")
	public final void p2_alt2(@OriginalArg(1) int value) {
		this.data[this.pos++] = (byte) (value >> 8);
		this.data[this.pos++] = (byte) (value + 128);
	}

	@OriginalMember(owner = "client!iv", name = "b", descriptor = "(BI)V")
	public final void p2_alt3(@OriginalArg(1) int value) {
		this.data[this.pos++] = (byte) (value + 128);
		this.data[this.pos++] = (byte) (value >> 8);
	}

	@OriginalMember(owner = "client!iv", name = "d", descriptor = "(B)I")
	public final int g3() {
		this.pos += 3;

		return (this.data[this.pos - 1] & 0xFF)
				+ ((this.data[this.pos - 2] & 0xFF) << 8)
				+ ((this.data[this.pos - 3] & 0xFF) << 16);
	}

	@OriginalMember(owner = "client!iv", name = "d", descriptor = "(II)V")
	public final void p3(@OriginalArg(1) int value) {
		this.data[this.pos++] = (byte) (value >> 16);
		this.data[this.pos++] = (byte) (value >> 8);
		this.data[this.pos++] = (byte) value;
	}

	@OriginalMember(owner = "client!iv", name = "k", descriptor = "(B)I")
	public final int g4() {
		this.pos += 4;

		return (this.data[this.pos - 1] & 0xFF)
				+ ((this.data[this.pos - 2] & 0xFF) << 8)
				+ ((this.data[this.pos - 3] & 0xFF) << 16)
				+ (this.data[this.pos - 4] << 24 & 0xFF);
	}

	@OriginalMember(owner = "client!iv", name = "j", descriptor = "(I)I")
	public final int g4_alt1() {
		this.pos += 4;

		return ((this.data[this.pos - 1] & 0xFF) << 24)
				+ ((this.data[this.pos - 2] & 0xFF) << 16)
				+ ((this.data[this.pos - 3] & 0xFF) << 8)
				+ (this.data[this.pos - 4] & 0xFF);
	}

	@OriginalMember(owner = "client!iv", name = "c", descriptor = "(I)I")
	public final int g4_alt2() {
		this.pos += 4;

		return ((this.data[this.pos - 1] & 0xFF) << 16)
				+ ((this.data[this.pos - 2] & 0xFF) << 24)
				+ (this.data[this.pos - 3] & 0xFF)
				+ ((this.data[this.pos - 4] & 0xFF) << 8);
	}

	@OriginalMember(owner = "client!iv", name = "i", descriptor = "(I)I")
	public final int g4_alt3() {
		this.pos += 4;

		return ((this.data[this.pos - 1] & 0xFF) << 8)
				+ (this.data[this.pos - 2] & 0xFF)
				+ ((this.data[this.pos - 3] & 0xFF) << 24)
				+ ((this.data[this.pos - 4] & 0xFF) << 16);
	}

	@OriginalMember(owner = "client!iv", name = "c", descriptor = "(IB)V")
	public final void p4(@OriginalArg(0) int value) {
		this.data[this.pos++] = (byte) (value >> 24);
		this.data[this.pos++] = (byte) (value >> 16);
		this.data[this.pos++] = (byte) (value >> 8);
		this.data[this.pos++] = (byte) value;
	}

	@OriginalMember(owner = "client!iv", name = "k", descriptor = "(II)V")
	public final void p4_alt1(@OriginalArg(1) int value) {
		this.data[this.pos++] = (byte) value;
		this.data[this.pos++] = (byte) (value >> 8);
		this.data[this.pos++] = (byte) (value >> 16);
		this.data[this.pos++] = (byte) (value >> 24);
	}

	@OriginalMember(owner = "client!iv", name = "g", descriptor = "(II)V")
	public final void p4_alt2(@OriginalArg(0) int value) {
		this.data[this.pos++] = (byte) (value >> 8);
		this.data[this.pos++] = (byte) value;
		this.data[this.pos++] = (byte) (value >> 24);
		this.data[this.pos++] = (byte) (value >> 16);
	}

	@OriginalMember(owner = "client!iv", name = "b", descriptor = "(II)V")
	public final void p4_alt3(@OriginalArg(1) int value) {
		this.data[this.pos++] = (byte) (value >> 16);
		this.data[this.pos++] = (byte) (value >> 24);
		this.data[this.pos++] = (byte) value;
		this.data[this.pos++] = (byte) (value >> 8);
	}

	@OriginalMember(owner = "client!iv", name = "c", descriptor = "(II)V")
	public final void pSize4(@OriginalArg(1) int length) {
		this.data[this.pos - length - 4] = (byte) (length >> 24);
		this.data[this.pos - length - 3] = (byte) (length >> 16);
		this.data[this.pos - length - 2] = (byte) (length >> 8);
		this.data[this.pos - length - 1] = (byte) length;
	}

	@OriginalMember(owner = "client!iv", name = "b", descriptor = "(Z)J")
	public final long g8() {
		@Pc(10) long first = (long) this.g4() & 0xFFFFFFFFL;
		@Pc(22) long second = (long) this.g4() & 0xFFFFFFFFL;

		return (first << 32) + second;
	}

	@OriginalMember(owner = "client!iv", name = "a", descriptor = "(JB)V")
	public final void p8(@OriginalArg(0) long value) {
		this.data[this.pos++] = (byte) (value >> 56);
		this.data[this.pos++] = (byte) (value >> 48);
		this.data[this.pos++] = (byte) (value >> 40);
		this.data[this.pos++] = (byte) (value >> 32);
		this.data[this.pos++] = (byte) (value >> 24);
		this.data[this.pos++] = (byte) (value >> 16);
		this.data[this.pos++] = (byte) (value >> 8);
		this.data[this.pos++] = (byte) value;
	}

	@OriginalMember(owner = "client!iv", name = "j", descriptor = "(B)I")
	public final int gVarInt() {
		@Pc(16) byte currentByte = this.data[this.pos++];
		@Pc(23) int result = 0;

		while (currentByte < 0) {
			result = (result | currentByte & 0x7F) << 7;
			currentByte = this.data[this.pos++];
		}

		return result | currentByte;
	}

	@OriginalMember(owner = "client!iv", name = "a", descriptor = "(ZI)V")
	public final void pVarInt(@OriginalArg(1) int value) {
		if ((value & 0xFFFFFF80) != 0) {
			if ((value & 0xFFFFC000) != 0) {
				if ((value & 0xFFE00000) != 0) {
					if ((value & 0xF0000000) != 0) {
						this.p1(value >>> 28 | 0x80);
					}
					this.p1(value >>> 21 | 0x80);
				}
				this.p1(value >>> 14 | 0x80);
			}
			this.p1(value >>> 7 | 0x80);
		}
		this.p1(value & 0x7F);
	}

	@OriginalMember(owner = "client!iv", name = "a", descriptor = "(II)J")
	public final long gVarLong(@OriginalArg(1) int size) {
		@Pc(2) int shiftWidthMultiple = size - 1;

		if (shiftWidthMultiple < 0 || shiftWidthMultiple > 7) {
			throw new IllegalArgumentException();
		}

		@Pc(29) int shiftWidth = shiftWidthMultiple * 8;
		@Pc(31) long result = 0L;

		while (shiftWidth >= 0) {
			result |= ((long) this.data[this.pos++] & 0xFFL) << shiftWidth;
			shiftWidth -= 8;
		}

		return result;
	}

	@OriginalMember(owner = "client!iv", name = "a", descriptor = "(IJB)V")
	public final void pVarLong(@OriginalArg(0) int size, @OriginalArg(1) long value) {
		@Pc(6) int shiftWidthMultiple = size - 1;

		if (shiftWidthMultiple < 0 || shiftWidthMultiple > 7) {
			throw new IllegalArgumentException();
		}

		for (@Pc(24) int i = shiftWidthMultiple * 8; i >= 0; i -= 8) {
			this.data[this.pos++] = (byte) (value >> i);
		}
	}

	@OriginalMember(owner = "client!iv", name = "f", descriptor = "(B)I")
	public final int gSmart1Or2() {
		@Pc(17) int value = this.data[this.pos] & 0xFF;

		return value < 128 ? this.g1() : this.g2() - 32768;
	}

	@OriginalMember(owner = "client!iv", name = "g", descriptor = "(I)I")
	public final int gSmart1Or2s() {
		@Pc(16) int value = this.data[this.pos] & 0xFF;

		return value < 128 ? this.g1() - 64 : this.g2() - 49152;
	}

	@OriginalMember(owner = "client!iv", name = "f", descriptor = "(BI)V")
	public final void pSmart1or2(@OriginalArg(1) int value) {
		if (value >= 0 && value < 128) {
			this.p1(value);
		} else if (value >= 0 && value < 32768) {
			this.p2(value + 32768);
		} else {
			throw new IllegalArgumentException();
		}
	}

	@OriginalMember(owner = "client!iv", name = "f", descriptor = "(I)I")
	public final int gSmartsExtend() {
		@Pc(7) int local7 = 0;
		@Pc(11) int local11 = this.gSmart1Or2();

		while (local11 == 32767) {
			local11 = this.gSmart1Or2();
			local7 += 32767;
		}

		return local7 + local11;
	}

	@OriginalMember(owner = "client!iv", name = "a", descriptor = "(ILjava/lang/String;)V")
	public final void pjstr(@OriginalArg(1) String value) {
		@Pc(7) int nullCharLocation = value.indexOf(0);

		if (nullCharLocation >= 0) {
			throw new IllegalArgumentException("NUL character at " + nullCharLocation + " - cannot pjstr");
		}

		this.pos += Static178.writeStringToByteBuffer(value, value.length(), this.pos, this.data);
		this.data[this.pos++] = 0;
	}

	@OriginalMember(owner = "client!iv", name = "m", descriptor = "(B)Ljava/lang/String;")
	protected final String readValidStringAtCurrentPosition() {
		@Pc(6) int position = this.pos;

		while (this.data[this.pos++] != 0) {
		}

		@Pc(31) int startingPosition = this.pos - position - 1;

		return startingPosition == 0 ? "" : Static412.resolveStringFromByteBuffer(this.data, startingPosition, position);
	}

	@OriginalMember(owner = "client!iv", name = "d", descriptor = "(I)Ljava/lang/String;")
	public final String gjstr2() {
		@Pc(22) byte version = this.data[this.pos++];

		if (version != 0) {
			throw new IllegalStateException("Bad version number in gjstr2");
		}

		@Pc(35) int endPos = this.pos;

		while (this.data[this.pos++] != 0) {
		}

		@Pc(58) int length = this.pos - endPos - 1;

		return length == 0 ? "" : Static412.resolveStringFromByteBuffer(this.data, length, endPos);
	}

	@OriginalMember(owner = "client!iv", name = "f", descriptor = "(II)I")
	public final int method2525(@OriginalArg(0) int arg0) {
		@Pc(16) int local16 = Static179.method2846(arg0, this.data, this.pos);

		this.p4(local16);

		return local16;
	}

	@OriginalMember(owner = "client!iv", name = "a", descriptor = "(Z)Z")
	public final boolean method2500() {
		this.pos -= 4;

		@Pc(17) int local17 = Static179.method2846(0, this.data, this.pos);
		@Pc(21) int local21 = this.g4();

		return local21 == local17;
	}

	@OriginalMember(owner = "client!iv", name = "a", descriptor = "(BII[B)V")
	public final void gArrayBuffer(@OriginalArg(1) int length, @OriginalArg(3) byte[] buffer) {
		for (@Pc(3) int i = 0; i < length; i++) {
			buffer[i] = this.data[this.pos++];
		}
	}

	@OriginalMember(owner = "client!iv", name = "a", descriptor = "(IZ[BI)V")
	public final void pArrayBuffer(@OriginalArg(2) byte[] arg0, @OriginalArg(3) int arg1) {
		for (@Pc(5) int local5 = 0; local5 < arg1; local5++) {
			this.data[this.pos++] = arg0[local5];
		}
	}

	@OriginalMember(owner = "client!iv", name = "k", descriptor = "(I)Ljava/lang/String;")
	public final String readString() {
		if (this.data[this.pos] == 0) {
			this.pos++;
			return null;
		} else {
			return this.readValidStringAtCurrentPosition();
		}
	}

	@OriginalMember(owner = "client!iv", name = "a", descriptor = "(Ljava/math/BigInteger;BLjava/math/BigInteger;)V")
	public final void rsaEncrypt(@OriginalArg(0) BigInteger e, @OriginalArg(2) BigInteger n) {
		int size = this.pos;

		this.pos = 0;

		byte[] message = new byte[size];

		this.gArrayBuffer(size, message);

		BigInteger bi = new BigInteger(message);
		BigInteger encrypted = bi.modPow(e, n);
		byte[] data = encrypted.toByteArray();

		this.pos = 0;
		this.p1(data.length);
		this.pArrayBuffer(data, data.length);
	}

	@OriginalMember(owner = "client!iv", name = "a", descriptor = "([II)V")
	public final void tinyKeyEncrypt(int[] key) {
		int blocks = this.pos / 8;

		this.pos = 0;

		for (int i = 0; i < blocks; i++) {
			int v0 = this.g4();
			int v1 = this.g4();
			int sum = 0;
			int delta = 0x9E3779B9;
			int remainingRounds = 32;

			while (remainingRounds-- > 0) {
				sum += delta;
				v0 += key[sum & 0x3] + sum ^ v1 + (v1 << 4 ^ v1 >>> 5);
				v1 += key[sum >>> 11 & 0xCB000003] + sum ^ v0 + (v0 << 4 ^ v0 >>> 5);
			}

			this.pos -= 8;
			this.p4(v0);
			this.p4(v1);
		}
	}

	@OriginalMember(owner = "client!iv", name = "a", descriptor = "(III[I)V")
	public final void tinyKeyDecrypt(int length, int[] key) {
		int startingPosition = this.pos;
		int blocks = (length - 5) / 8;

		this.pos = 5;

		for (int i = 0; i < blocks; i++) {
			int v0 = this.g4();
			int v1 = this.g4();
			int sum = -957401312;
			int delta = 0x9E3779B9;
			int remainingRounds = 32;

			while (remainingRounds-- > 0) {
				v1 -= (v0 >>> 5 ^ v0 << 4) + v0 ^ sum + key[sum >>> 11 & 0x4C600003];
				v0 -= v1 + (v1 << 4 ^ v1 >>> 5) ^ key[sum & 0x3] + sum;
				sum -= delta;
			}

			this.pos -= 8;
			this.p4(v0);
			this.p4(v1);
		}

		this.pos = startingPosition;
	}
}
