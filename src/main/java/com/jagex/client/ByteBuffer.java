package com.jagex.client;

import java.math.BigInteger;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!iv")
public class ByteBuffer extends Class4 {

	@OriginalMember(owner = "client!iv", name = "z", descriptor = "[B")
	public byte[] bytes;

	@OriginalMember(owner = "client!iv", name = "rb", descriptor = "I")
	public int position;

	static {
		new Class83("Join your channel by clicking 'Join Chat' and typing: ", "Klick auf 'Betreten' und gib ein: ", "Pour rejoindre votre canal, cliquez sur « Participer » et entrez : ", "Para entrar no seu canal, clique em \"Acessar bate-papo\" e digite: ");
	}

	@OriginalMember(owner = "client!iv", name = "<init>", descriptor = "(I)V")
	public ByteBuffer(@OriginalArg(0) int arg0) {
		this.bytes = Static277.method3931(arg0);
		this.position = 0;
	}

	@OriginalMember(owner = "client!iv", name = "<init>", descriptor = "([B)V")
	public ByteBuffer(@OriginalArg(0) byte[] arg0) {
		this.bytes = arg0;
		this.position = 0;
	}

	@OriginalMember(owner = "client!iv", name = "i", descriptor = "(II)V")
	public final void method2545(@OriginalArg(1) int arg0) {
		this.bytes[this.position - arg0 - 1] = (byte) arg0;
	}

	@OriginalMember(owner = "client!iv", name = "e", descriptor = "(II)V")
	public final void writeInt8(@OriginalArg(1) int arg0) {
		this.bytes[this.position++] = (byte) (128 - arg0);
	}

	@OriginalMember(owner = "client!iv", name = "m", descriptor = "(I)I")
	public final int readReverseInt8() {
		return -this.readByteIntoInt();
	}

	/**
	 * Min: 0 - Max: 255
	 */
	@OriginalMember(owner = "client!iv", name = "l", descriptor = "(I)I")
	public final int readUInt8() {
		return this.bytes[this.position++] - 128 & 0xFF;
	}

	/**
	 * Min: -128 - Max: 127
	 */
	@OriginalMember(owner = "client!iv", name = "c", descriptor = "(Z)B")
	public final byte readInt8() {
		return this.bytes[this.position++];
	}

	@OriginalMember(owner = "client!iv", name = "a", descriptor = "(I)I")
	public final int readByteIntoInt() {
		return this.bytes[this.position++] & 0xFF;
	}

	@OriginalMember(owner = "client!iv", name = "h", descriptor = "(I)B")
	public final byte readReverseByte() {
		return (byte) -this.readInt8();
	}

	@OriginalMember(owner = "client!iv", name = "s", descriptor = "(I)B")
	public final byte readUByte() {
		return (byte) (this.bytes[this.position++] - 128);
	}

	@OriginalMember(owner = "client!iv", name = "c", descriptor = "(B)I")
	public final int readUByteIntoInt() {
		return 128 - this.bytes[this.position++] & 0xFF;
	}

	@OriginalMember(owner = "client!iv", name = "o", descriptor = "(I)B")
	public final byte method2534() {
		return (byte) (128 - this.bytes[this.position++]);
	}

	@OriginalMember(owner = "client!iv", name = "l", descriptor = "(II)V")
	public final void writeByte(@OriginalArg(1) int value) {
		this.bytes[this.position++] = (byte) value;
	}

	@OriginalMember(owner = "client!iv", name = "h", descriptor = "(II)V")
	public final void writeReversedByte(@OriginalArg(0) int value) {
		this.writeByte(-value);
	}

	@OriginalMember(owner = "client!iv", name = "a", descriptor = "(BI)V")
	public final void writeUint8(@OriginalArg(1) int value) {
		this.bytes[this.position++] = (byte) (value + 128);
	}

	@OriginalMember(owner = "client!iv", name = "a", descriptor = "(IB)V")
	public final void writeInt16LE(@OriginalArg(0) int value) {
		this.bytes[this.position++] = (byte) value;
		this.bytes[this.position++] = (byte) (value >> 8);
	}

	@OriginalMember(owner = "client!iv", name = "d", descriptor = "(BI)V")
	public final void writeInt16BE(@OriginalArg(1) int value) {
		this.bytes[this.position++] = (byte) (value >> 8);
		this.bytes[this.position++] = (byte) value;
	}

	@OriginalMember(owner = "client!iv", name = "e", descriptor = "(BI)V")
	public final void method2541(@OriginalArg(1) int value) {
		this.bytes[this.position++] = (byte) value;
		this.bytes[this.position++] = (byte) (value >> 8);
	}

	@OriginalMember(owner = "client!iv", name = "b", descriptor = "(BI)V")
	public final void writeUint16LE(@OriginalArg(1) int value) {
		this.bytes[this.position++] = (byte) (value + 128);
		this.bytes[this.position++] = (byte) (value >> 8);
	}

	@OriginalMember(owner = "client!iv", name = "c", descriptor = "(BI)V")
	public final void writeUint16BE(@OriginalArg(1) int value) {
		this.bytes[this.position++] = (byte) (value >> 8);
		this.bytes[this.position++] = (byte) (value + 128);
	}

	@OriginalMember(owner = "client!iv", name = "j", descriptor = "(II)V")
	public final void writeInt16BEAtValueIndex(@OriginalArg(1) int value) {
		this.bytes[this.position - value - 2] = (byte) (value >> 8);
		this.bytes[this.position - value - 1] = (byte) value;
	}

	@OriginalMember(owner = "client!iv", name = "d", descriptor = "(II)V")
	public final void writeInt24BE(@OriginalArg(1) int value) {
		this.bytes[this.position++] = (byte) (value >> 16);
		this.bytes[this.position++] = (byte) (value >> 8);
		this.bytes[this.position++] = (byte) value;
	}

	@OriginalMember(owner = "client!iv", name = "c", descriptor = "(IB)V")
	public final void writeIntBE(@OriginalArg(0) int arg0) {
		this.bytes[this.position++] = (byte) (arg0 >> 24);
		this.bytes[this.position++] = (byte) (arg0 >> 16);
		this.bytes[this.position++] = (byte) (arg0 >> 8);
		this.bytes[this.position++] = (byte) arg0;
	}

	@OriginalMember(owner = "client!iv", name = "k", descriptor = "(II)V")
	public final void writeIntLE(@OriginalArg(1) int value) {
		this.bytes[this.position++] = (byte) value;
		this.bytes[this.position++] = (byte) (value >> 8);
		this.bytes[this.position++] = (byte) (value >> 16);
		this.bytes[this.position++] = (byte) (value >> 24);
	}

	@OriginalMember(owner = "client!iv", name = "g", descriptor = "(II)V")
	public final void method2532(@OriginalArg(0) int arg0) {
		this.bytes[this.position++] = (byte) (arg0 >> 8);
		this.bytes[this.position++] = (byte) arg0;
		this.bytes[this.position++] = (byte) (arg0 >> 24);
		this.bytes[this.position++] = (byte) (arg0 >> 16);
	}

	@OriginalMember(owner = "client!iv", name = "b", descriptor = "(II)V")
	public final void method2513(@OriginalArg(1) int arg0) {
		this.bytes[this.position++] = (byte) (arg0 >> 16);
		this.bytes[this.position++] = (byte) (arg0 >> 24);
		this.bytes[this.position++] = (byte) arg0;
		this.bytes[this.position++] = (byte) (arg0 >> 8);
	}

	@OriginalMember(owner = "client!iv", name = "c", descriptor = "(II)V")
	public final void method2514(@OriginalArg(1) int arg0) {
		this.bytes[this.position - arg0 - 4] = (byte) (arg0 >> 24);
		this.bytes[this.position - arg0 - 3] = (byte) (arg0 >> 16);
		this.bytes[this.position - arg0 - 2] = (byte) (arg0 >> 8);
		this.bytes[this.position - arg0 - 1] = (byte) arg0;
	}

	@OriginalMember(owner = "client!iv", name = "a", descriptor = "(JB)V")
	public final void method2504(@OriginalArg(0) long arg0) {
		this.bytes[this.position++] = (byte) (arg0 >> 56);
		this.bytes[this.position++] = (byte) (arg0 >> 48);
		this.bytes[this.position++] = (byte) (arg0 >> 40);
		this.bytes[this.position++] = (byte) (arg0 >> 32);
		this.bytes[this.position++] = (byte) (arg0 >> 24);
		this.bytes[this.position++] = (byte) (arg0 >> 16);
		this.bytes[this.position++] = (byte) (arg0 >> 8);
		this.bytes[this.position++] = (byte) arg0;
	}

	@OriginalMember(owner = "client!iv", name = "a", descriptor = "(ILjava/lang/String;)V")
	public final void writeString(@OriginalArg(1) String value) {
		@Pc(7) int nullIndex = value.indexOf(0);

		if (nullIndex >= 0) {
			throw new IllegalArgumentException("NUL character at " + nullIndex + " - cannot pjstr");
		}

		this.position += Static178.writeStringToByteBuffer(value, value.length(), this.position, this.bytes);
		this.bytes[this.position++] = 0;
	}

	@OriginalMember(owner = "client!iv", name = "c", descriptor = "(I)I")
	public final int method2491() {
		this.position += 4;
		return (this.bytes[this.position - 3] & 0xFF) + (((this.bytes[this.position - 2] & 0xFF) << 24) - (-((this.bytes[this.position - 1] & 0xFF) << 16) - ((this.bytes[this.position - 4] & 0xFF) << 8)));
	}

	@OriginalMember(owner = "client!iv", name = "a", descriptor = "(II)J")
	public final long method2492(@OriginalArg(1) int arg0) {
		@Pc(2) int local2 = arg0 - 1;
		if (local2 < 0 || local2 > 7) {
			throw new IllegalArgumentException();
		}
		@Pc(29) int local29 = local2 * 8;
		@Pc(31) long local31 = 0L;
		while (local29 >= 0) {
			local31 |= ((long) this.bytes[this.position++] & 0xFFL) << local29;
			local29 -= 8;
		}
		return local31;
	}

	@OriginalMember(owner = "client!iv", name = "d", descriptor = "(B)I")
	public final int method2493() {
		this.position += 3;
		return ((this.bytes[this.position - 2] & 0xFF) << 8) + (((this.bytes[this.position - 3] & 0xFF) << 16) + (this.bytes[this.position - 1] & 0xFF));
	}

	@OriginalMember(owner = "client!iv", name = "d", descriptor = "(I)Ljava/lang/String;")
	public final String method2497() {
		@Pc(22) byte local22 = this.bytes[this.position++];
		if (local22 != 0) {
			throw new IllegalStateException("Bad version number in gjstr2");
		}
		@Pc(35) int local35 = this.position;
		while (this.bytes[this.position++] != 0) {
		}
		@Pc(58) int local58 = this.position - local35 - 1;
		return local58 == 0 ? "" : Static412.resolveStringFromByteBuffer(this.bytes, local58, local35);
	}

	@OriginalMember(owner = "client!iv", name = "f", descriptor = "(I)I")
	public final int method2499() {
		@Pc(7) int local7 = 0;
		@Pc(11) int local11 = this.method2506();
		while (local11 == 32767) {
			local11 = this.method2506();
			local7 += 32767;
		}
		return local7 + local11;
	}

	@OriginalMember(owner = "client!iv", name = "a", descriptor = "(Z)Z")
	public final boolean method2500() {
		this.position -= 4;
		@Pc(17) int local17 = Static179.method2846(0, this.bytes, this.position);
		@Pc(21) int local21 = this.method2529();
		return local21 == local17;
	}

	@OriginalMember(owner = "client!iv", name = "b", descriptor = "(Z)J")
	public final long method2501() {
		@Pc(10) long local10 = (long) this.method2529() & 0xFFFFFFFFL;
		@Pc(22) long local22 = (long) this.method2529() & 0xFFFFFFFFL;
		return (local10 << 32) + local22;
	}

	@OriginalMember(owner = "client!iv", name = "g", descriptor = "(I)I")
	public final int method2502() {
		@Pc(16) int local16 = this.bytes[this.position] & 0xFF;
		return local16 < 128 ? this.readByteIntoInt() - 64 : this.method2536() - 49152;
	}

	@OriginalMember(owner = "client!iv", name = "e", descriptor = "(B)I")
	public final int method2503() {
		this.position += 2;
		@Pc(37) int local37 = (this.bytes[this.position - 2] & 0xFF) + ((this.bytes[this.position - 1] & 0xFF) << 8);
		if (local37 > 32767) {
			local37 -= 65536;
		}
		return local37;
	}

	@OriginalMember(owner = "client!iv", name = "f", descriptor = "(B)I")
	public final int method2506() {
		@Pc(17) int local17 = this.bytes[this.position] & 0xFF;
		return local17 < 128 ? this.readByteIntoInt() : this.method2536() - 32768;
	}

	@OriginalMember(owner = "client!iv", name = "a", descriptor = "(BII[B)V")
	public final void method2508(@OriginalArg(1) int arg0, @OriginalArg(3) byte[] arg1) {
		for (@Pc(3) int local3 = 0; local3 < arg0; local3++) {
			arg1[local3] = this.bytes[this.position++];
		}
	}

	@OriginalMember(owner = "client!iv", name = "g", descriptor = "(B)I")
	public final int method2509() {
		this.position += 2;
		@Pc(39) int local39 = (this.bytes[this.position - 1] - 128 & 0xFF) + ((this.bytes[this.position - 2] & 0xFF) << 8);
		if (local39 > 32767) {
			local39 -= 65536;
		}
		return local39;
	}

	@OriginalMember(owner = "client!iv", name = "i", descriptor = "(I)I")
	public final int method2510() {
		this.position += 4;
		return (this.bytes[this.position - 2] & 0xFF) + ((this.bytes[this.position - 4] & 0xFF) << 16) + ((this.bytes[this.position + -3] & 0xFF) << 24) + ((this.bytes[this.position + -1] & 0xFF) << 8);
	}

	@OriginalMember(owner = "client!iv", name = "j", descriptor = "(I)I")
	public final int method2511() {
		this.position += 4;
		return (this.bytes[this.position - 4] & 0xFF) + ((this.bytes[this.position - 3] & 0xFF) << 8) + ((this.bytes[this.position + -1] & 0xFF) << 24) + ((this.bytes[this.position + -2] & 0xFF) << 16);
	}

	@OriginalMember(owner = "client!iv", name = "h", descriptor = "(B)I")
	public final int method2512() {
		this.position += 2;
		@Pc(38) int local38 = ((this.bytes[this.position - 2] & 0xFF) << 8) + (this.bytes[this.position - 1] & 0xFF);
		if (local38 > 32767) {
			local38 -= 65536;
		}
		return local38;
	}

	@OriginalMember(owner = "client!iv", name = "i", descriptor = "(B)I")
	public final int method2515() {
		this.position += 2;
		return ((this.bytes[this.position - 1] & 0xFF) << 8) + (this.bytes[this.position - 2] - 128 & 0xFF);
	}

	@OriginalMember(owner = "client!iv", name = "k", descriptor = "(I)Ljava/lang/String;")
	public final String readString() {
		if (this.bytes[this.position] == 0) {
			this.position++;
			return null;
		} else {
			return this.readValidStringAtCurrentPosition();
		}
	}

	@OriginalMember(owner = "client!iv", name = "a", descriptor = "(IZ[BI)V")
	public final void method2519(@OriginalArg(2) byte[] arg0, @OriginalArg(3) int arg1) {
		for (@Pc(5) int local5 = 0; local5 < arg1; local5++) {
			this.bytes[this.position++] = arg0[local5];
		}
	}

	@OriginalMember(owner = "client!iv", name = "a", descriptor = "(Ljava/math/BigInteger;BLjava/math/BigInteger;)V")
	public final void method2522(@OriginalArg(0) BigInteger arg0, @OriginalArg(2) BigInteger arg1) {
		@Pc(6) int local6 = this.position;
		this.position = 0;
		@Pc(12) byte[] local12 = new byte[local6];
		this.method2508(local6, local12);
		@Pc(23) BigInteger local23 = new BigInteger(local12);
		@Pc(28) BigInteger local28 = local23.modPow(arg0, arg1);
		@Pc(31) byte[] local31 = local28.toByteArray();
		this.position = 0;
		this.writeByte(local31.length);
		this.method2519(local31, local31.length);
	}

	@OriginalMember(owner = "client!iv", name = "f", descriptor = "(II)I")
	public final int method2525(@OriginalArg(0) int arg0) {
		@Pc(16) int local16 = Static179.method2846(arg0, this.bytes, this.position);
		this.writeIntBE(local16);
		return local16;
	}

	@OriginalMember(owner = "client!iv", name = "a", descriptor = "(IJB)V")
	public final void method2526(@OriginalArg(0) int arg0, @OriginalArg(1) long arg1) {
		@Pc(6) int local6 = arg0 - 1;
		if (local6 < 0 || local6 > 7) {
			throw new IllegalArgumentException();
		}
		for (@Pc(24) int local24 = local6 * 8; local24 >= 0; local24 -= 8) {
			this.bytes[this.position++] = (byte) (arg1 >> local24);
		}
	}

	@OriginalMember(owner = "client!iv", name = "j", descriptor = "(B)I")
	public final int method2528() {
		@Pc(16) byte local16 = this.bytes[this.position++];
		@Pc(23) int local23 = 0;
		while (local16 < 0) {
			local23 = (local23 | local16 & 0x7F) << 7;
			local16 = this.bytes[this.position++];
		}
		return local23 | local16;
	}

	@OriginalMember(owner = "client!iv", name = "k", descriptor = "(B)I")
	public final int method2529() {
		this.position += 4;
		return ((this.bytes[this.position - 2] & 0xFF) << 8) + (this.bytes[this.position - 4] << 24 & 0xFF000000) + ((this.bytes[this.position + -3] & 0xFF) << 16) + (this.bytes[this.position + -1] & 0xFF);
	}

	@OriginalMember(owner = "client!iv", name = "p", descriptor = "(I)I")
	public final int method2535() {
		this.position += 2;
		@Pc(39) int local39 = ((this.bytes[this.position - 1] & 0xFF) << 8) + (this.bytes[this.position - 2] - 128 & 0xFF);
		if (local39 > 32767) {
			local39 -= 65536;
		}
		return local39;
	}

	@OriginalMember(owner = "client!iv", name = "l", descriptor = "(B)I")
	public final int method2536() {
		this.position += 2;
		return (this.bytes[this.position - 1] & 0xFF) + ((this.bytes[this.position - 2] & 0xFF) << 8);
	}

	@OriginalMember(owner = "client!iv", name = "q", descriptor = "(I)I")
	public final int method2538() {
		this.position += 2;
		return (this.bytes[this.position - 2] & 0xFF) + ((this.bytes[this.position - 1] & 0xFF) << 8);
	}

	@OriginalMember(owner = "client!iv", name = "a", descriptor = "([II)V")
	public final void method2540(@OriginalArg(0) int[] arg0) {
		@Pc(10) int local10 = this.position / 8;
		this.position = 0;
		for (@Pc(19) int local19 = 0; local19 < local10; local19++) {
			@Pc(25) int local25 = this.method2529();
			@Pc(29) int local29 = this.method2529();
			@Pc(31) int local31 = 0;
			@Pc(35) int local35 = 32;
			while (local35-- > 0) {
				local25 += arg0[local31 & 0x3] + local31 ^ local29 + (local29 << 4 ^ local29 >>> 5);
				local31 += -1640531527;
				local29 += arg0[local31 >>> 11 & 0xCB000003] + local31 ^ local25 + (local25 << 4 ^ local25 >>> 5);
			}
			this.position -= 8;
			this.writeIntBE(local25);
			this.writeIntBE(local29);
		}
	}

	@OriginalMember(owner = "client!iv", name = "f", descriptor = "(BI)V")
	public final void method2543(@OriginalArg(1) int arg0) {
		if (arg0 >= 0 && arg0 < 128) {
			this.writeByte(arg0);
		} else if (arg0 >= 0 && arg0 < 32768) {
			this.writeInt16BE(arg0 + 32768);
		} else {
			throw new IllegalArgumentException();
		}
	}

	@OriginalMember(owner = "client!iv", name = "a", descriptor = "(III[I)V")
	public final void method2544(@OriginalArg(1) int arg0, @OriginalArg(3) int[] arg1) {
		@Pc(8) int local8 = this.position;
		this.position = 5;
		@Pc(18) int local18 = (arg0 - 5) / 8;
		for (@Pc(20) int local20 = 0; local20 < local18; local20++) {
			@Pc(32) int local32 = this.method2529();
			@Pc(36) int local36 = this.method2529();
			@Pc(38) int local38 = -957401312;
			@Pc(42) int local42 = 32;
			while (local42-- > 0) {
				local36 -= (local32 >>> 5 ^ local32 << 4) + local32 ^ local38 + arg1[local38 >>> 11 & 0x4C600003];
				local38 -= -1640531527;
				local32 -= local36 + (local36 << 4 ^ local36 >>> 5) ^ arg1[local38 & 0x3] + local38;
			}
			this.position -= 8;
			this.writeIntBE(local32);
			this.writeIntBE(local36);
		}
		this.position = local8;
	}

	@OriginalMember(owner = "client!iv", name = "a", descriptor = "(ZI)V")
	public final void method2546(@OriginalArg(1) int arg0) {
		if ((arg0 & 0xFFFFFF80) != 0) {
			if ((arg0 & 0xFFFFC000) != 0) {
				if ((arg0 & 0xFFE00000) != 0) {
					if ((arg0 & 0xF0000000) != 0) {
						this.writeByte(arg0 >>> 28 | 0x80);
					}
					this.writeByte(arg0 >>> 21 | 0x80);
				}
				this.writeByte(arg0 >>> 14 | 0x80);
			}
			this.writeByte(arg0 >>> 7 | 0x80);
		}
		this.writeByte(arg0 & 0x7F);
	}

	@OriginalMember(owner = "client!iv", name = "r", descriptor = "(I)I")
	public final int method2548() {
		this.position += 2;
		return ((this.bytes[this.position - 2] & 0xFF) << 8) + (this.bytes[this.position - 1] - 128 & 0xFF);
	}

	@OriginalMember(owner = "client!iv", name = "m", descriptor = "(B)Ljava/lang/String;")
	protected final String readValidStringAtCurrentPosition() {
		@Pc(6) int position = this.position;

		while (this.bytes[this.position++] != 0) {
		}

		@Pc(31) int startingPosition = this.position - position - 1;

		return startingPosition == 0 ? "" : Static412.resolveStringFromByteBuffer(this.bytes, startingPosition, position);
	}
}
