package com.jagex.client;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;

import com.jagex.signlink.FileOnDisk;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!lq")
public final class BufferedFile {

	@OriginalMember(owner = "client!lq", name = "i", descriptor = "J")
	private long aLong144;

	@OriginalMember(owner = "client!lq", name = "u", descriptor = "I")
	private int offset;

	@OriginalMember(owner = "client!lq", name = "f", descriptor = "J")
	private long aLong143 = -1L;

	@OriginalMember(owner = "client!lq", name = "r", descriptor = "I")
	private int anInt4426 = 0;

	@OriginalMember(owner = "client!lq", name = "o", descriptor = "J")
	private long aLong146 = -1L;

	@OriginalMember(owner = "client!lq", name = "g", descriptor = "Lclient!rp;")
	private final FileOnDisk file;

	@OriginalMember(owner = "client!lq", name = "j", descriptor = "J")
	private long aLong145;

	@OriginalMember(owner = "client!lq", name = "s", descriptor = "J")
	private long aLong147;

	@OriginalMember(owner = "client!lq", name = "a", descriptor = "J")
	private long filePointer;

	@OriginalMember(owner = "client!lq", name = "n", descriptor = "[B")
	private final byte[] writeBuffer;

	@OriginalMember(owner = "client!lq", name = "v", descriptor = "[B")
	private final byte[] readBuffer;

	static {
		new LocalizedString("You have been temporarily muted due to breaking a rule.", "Aufgrund eines Regelverstoßes wurdest du vorübergehend stumm geschaltet.", "La messagerie instantanée a été temporairement bloquée suite à une infraction.", "Você foi temporariamente vetado por ter violado uma regra.");
	}

	@OriginalMember(owner = "client!lq", name = "<init>", descriptor = "(Lclient!rp;II)V")
	public BufferedFile(FileOnDisk file, int readBufferSize, int writeBufferSize) throws IOException {
		this.file = file;
		this.aLong147 = this.aLong145 = file.bufferLength();
		this.filePointer = 0L;
		this.readBuffer = new byte[readBufferSize];
		this.writeBuffer = new byte[writeBufferSize];
	}

	@OriginalMember(owner = "client!lq", name = "a", descriptor = "([BI)V")
	public void method3462(byte[] arg0) throws IOException {
		this.method3471(0, arg0.length, arg0);
	}

	@OriginalMember(owner = "client!lq", name = "a", descriptor = "(Z)J")
	public long method3463() {
		return this.aLong147;
	}

	@OriginalMember(owner = "client!lq", name = "a", descriptor = "(IB[BI)V")
	public void method3464(int arg0, byte[] arg1, int arg2) throws IOException {
		try {
			if (this.aLong147 < (long) arg2 + this.filePointer) {
				this.aLong147 = (long) arg2 + this.filePointer;
			}
			if (this.aLong143 != -1L && (this.aLong143 > this.filePointer || this.filePointer > this.aLong143 + (long) this.anInt4426)) {
				this.method3472();
			}
			if (this.aLong143 != -1L && this.filePointer + (long) arg2 > this.aLong143 + (long) this.writeBuffer.length) {
				@Pc(100) int local100 = (int) (this.aLong143 + (long) this.writeBuffer.length - this.filePointer);
				Static459.method3330(arg1, arg0, this.writeBuffer, (int) (this.filePointer - this.aLong143), local100);
				arg0 += local100;
				this.filePointer += local100;
				arg2 -= local100;
				this.anInt4426 = this.writeBuffer.length;
				this.method3472();
			}
			if (arg2 > this.writeBuffer.length) {
				if (this.aLong144 != this.filePointer) {
					this.file.seek(this.filePointer);
					this.aLong144 = this.filePointer;
				}
				this.file.write(arg0, arg2, arg1);
				this.aLong144 += arg2;
				if (this.aLong144 > this.aLong145) {
					this.aLong145 = this.aLong144;
				}
				@Pc(195) long local195 = -1L;
				@Pc(197) long local197 = -1L;
				if (this.filePointer >= this.aLong146 && this.aLong146 + (long) this.offset > this.filePointer) {
					local195 = this.filePointer;
				} else if (this.aLong146 >= this.filePointer && this.aLong146 < (long) arg2 + this.filePointer) {
					local195 = this.aLong146;
				}
				if (this.aLong146 < (long) arg2 + this.filePointer && (long) arg2 + this.filePointer <= (long) this.offset + this.aLong146) {
					local197 = (long) arg2 + this.filePointer;
				} else if (this.aLong146 + (long) this.offset > this.filePointer && this.filePointer + (long) arg2 >= this.aLong146 + (long) this.offset) {
					local197 = (long) this.offset + this.aLong146;
				}
				if (local195 > -1L && local195 < local197) {
					@Pc(335) int local335 = (int) (local197 - local195);
					Static459.method3330(arg1, (int) (local195 + (long) arg0 - this.filePointer), this.readBuffer, (int) (local195 - this.aLong146), local335);
				}
				this.filePointer += arg2;
			} else if (arg2 > 0) {
				if (this.aLong143 == -1L) {
					this.aLong143 = this.filePointer;
				}
				Static459.method3330(arg1, arg0, this.writeBuffer, (int) (this.filePointer - this.aLong143), arg2);
				this.filePointer += arg2;
				if (this.filePointer - this.aLong143 > (long) this.anInt4426) {
					this.anInt4426 = (int) (this.filePointer - this.aLong143);
				}
			}
		} catch (IOException e) {
			this.aLong144 = -1L;

			throw e;
		}
	}

	@OriginalMember(owner = "client!lq", name = "a", descriptor = "(IJ)V")
	public void seek(long pos) throws IOException {
		if (pos < 0L) {
			throw new IOException("Invalid seek to " + pos + " in file " + this.getFile());
		}

		this.filePointer = pos;
	}

	@OriginalMember(owner = "client!lq", name = "a", descriptor = "(I)V")
	private void method3467() throws IOException {
		this.offset = 0;

		if (this.filePointer != this.aLong144) {
			this.file.seek(this.filePointer);
			this.aLong144 = this.filePointer;
		}

		this.aLong146 = this.filePointer;

		while (this.offset < this.readBuffer.length) {
			int length = this.readBuffer.length - this.offset;

			if (length > 200000000) {
				length = 200000000;
			}

			int local55 = this.file.read(this.offset, length, this.readBuffer);

			if (local55 == -1) {
				break;
			}

			this.aLong144 += local55;
			this.offset += local55;
		}
	}

	@OriginalMember(owner = "client!lq", name = "b", descriptor = "(IB[BI)V")
	public void method3471(int offset, int length, byte[] buffer) throws IOException {
		try {
			if (length > buffer.length) {
				throw new ArrayIndexOutOfBoundsException(length - buffer.length);
			}

			if (this.aLong143 != -1L && this.aLong143 <= this.filePointer && (long) this.anInt4426 + this.aLong143 >= this.filePointer + (long) length) {
				Static459.method3330(this.writeBuffer, (int) (this.filePointer - this.aLong143), buffer, 0, length);

				this.filePointer += length;

				return;
			}

			long local82 = this.filePointer;
			int local86 = length;
			int local124;

			if (this.aLong146 <= this.filePointer && this.filePointer < this.aLong146 + (long) this.offset) {
				local124 = (int) (this.aLong146 + (long) this.offset - this.filePointer);
				if (length < local124) {
					local124 = length;
				}
				Static459.method3330(this.readBuffer, (int) (this.filePointer - this.aLong146), buffer, 0, local124);
				offset = local124;
				length -= local124;
				this.filePointer += local124;
			}

			if (this.readBuffer.length < length) {
				this.file.seek(this.filePointer);
				this.aLong144 = this.filePointer;

				while (length > 0) {
					local124 = this.file.read(offset, length, buffer);

					if (local124 == -1) {
						break;
					}

					this.aLong144 += local124;
					this.filePointer += local124;

					offset += local124;
					length -= local124;
				}
			} else if (length > 0) {
				this.method3467();

				local124 = length;

				if (this.offset < length) {
					local124 = this.offset;
				}

				Static459.method3330(this.readBuffer, 0, buffer, offset, local124);

				this.filePointer += local124;

				offset += local124;
				length -= local124;
			}
			if (this.aLong143 != -1L) {
				if (this.filePointer < this.aLong143 && length > 0) {
					local124 = (int) (this.aLong143 - this.filePointer) + offset;

					if (local124 > length + offset) {
						local124 = length + offset;
					}

					while (local124 > offset) {
						buffer[offset++] = 0;
						length--;
						this.filePointer++;
					}
				}

				long local312 = -1L;

				if (this.aLong143 >= local82 && (long) local86 + local82 > this.aLong143) {
					local312 = this.aLong143;
				} else if (this.aLong143 <= local82 && this.aLong143 + (long) this.anInt4426 > local82) {
					local312 = local82;
				}

				long local361 = -1L;

				if ((long) this.anInt4426 + this.aLong143 > local82 && this.aLong143 + (long) this.anInt4426 <= local82 - -((long) local86)) {
					local361 = (long) this.anInt4426 + this.aLong143;
				} else if (this.aLong143 < local82 + (long) local86 && local82 + (long) local86 <= (long) this.anInt4426 + this.aLong143) {
					local361 = (long) local86 + local82;
				}

				if (local312 > -1L && local361 > local312) {
					int local440 = (int) (local361 - local312);

					Static459.method3330(this.writeBuffer, (int) (local312 - this.aLong143), buffer, (int) (local312 - local82), local440);

					if (local361 > this.filePointer) {
						length = (int) ((long) length + this.filePointer - local361);
						this.filePointer = local361;
					}
				}
			}
		} catch (IOException e) {
			this.aLong144 = -1L;

			throw e;
		}

		if (length > 0) {
			throw new EOFException();
		}
	}

	@OriginalMember(owner = "client!lq", name = "a", descriptor = "(B)V")
	private void method3472() throws IOException {
		if (this.aLong143 == -1L) {
			return;
		}

		if (this.aLong143 != this.aLong144) {
			this.file.seek(this.aLong143);

			this.aLong144 = this.aLong143;
		}

		this.file.write(0, this.anInt4426, this.writeBuffer);

		this.aLong144 += this.anInt4426;

		if (this.aLong145 < this.aLong144) {
			this.aLong145 = this.aLong144;
		}

		@Pc(63) long local63 = -1L;
		@Pc(65) long local65 = -1L;

		if (this.aLong143 >= this.aLong146 && this.aLong146 + (long) this.offset > this.aLong143) {
			local63 = this.aLong143;
		} else if (this.aLong143 <= this.aLong146 && (long) this.anInt4426 + this.aLong143 > this.aLong146) {
			local63 = this.aLong146;
		}

		if (this.aLong143 + (long) this.anInt4426 > this.aLong146 && this.aLong143 + (long) this.anInt4426 <= (long) this.offset + this.aLong146) {
			local65 = (long) this.anInt4426 + this.aLong143;
		} else if (this.aLong143 < (long) this.offset + this.aLong146 && (long) this.anInt4426 + this.aLong143 >= (long) this.offset + this.aLong146) {
			local65 = this.aLong146 + (long) this.offset;
		}

		if (local63 > -1L && local65 > local63) {
			@Pc(203) int local203 = (int) (local65 - local63);

			Static459.method3330(this.writeBuffer, (int) (local63 - this.aLong143), this.readBuffer, (int) (local63 - this.aLong146), local203);
		}

		this.aLong143 = -1L;
		this.anInt4426 = 0;
	}

	@OriginalMember(owner = "client!lq", name = "c", descriptor = "(I)Ljava/io/File;")
	private File getFile() {
		return this.file.getFile();
	}
}
