package com.jagex.signlink;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class FileOnDisk {

	private final File file;

	private RandomAccessFile buffer;

	private long currentPOS;

	private final long maxLength;

	public FileOnDisk(File file, String mode, long maxLenth) throws IOException {
		if (maxLenth == -1) {
			maxLenth = Long.MAX_VALUE;
		}

		if (file.length() > maxLenth) {
			file.delete();
		}

		this.buffer = new RandomAccessFile(file, mode);
		this.maxLength = maxLenth;
		this.file = file;
		this.currentPOS = 0L;

		int firstByte = this.buffer.read();
		if (firstByte != -1 && !mode.equals("r")) {
			this.buffer.seek(0L);
			this.buffer.write(firstByte);
		}

		this.buffer.seek(0L);
	}

	public void close() throws IOException {
		if (this.buffer != null) {
			this.buffer.close();
			this.buffer = null;
		}
	}

	@Override
    protected void finalize() throws Throwable {
		if (this.buffer != null) {
			System.out.println("Warning! fileondisk " + this.file + " not closed correctly using close(). Auto-closing instead. ");

			this.close();
		}
	}

	public void write(int offset, int length, byte[] buffer) throws IOException {
		if (this.currentPOS + length > this.maxLength) {
			this.buffer.seek(this.maxLength);
			this.buffer.write(1);
			throw new EOFException();
		} else {
			this.buffer.write(buffer, offset, length);
			this.currentPOS += length;
		}
	}

	public int read(int offset, int length, byte[] buffer) throws IOException {
		int bytesRead = this.buffer.read(buffer, offset, length);

		if (bytesRead > 0) {
			this.currentPOS += bytesRead;
		}

		return bytesRead;
	}

	public File getFile() {
		return this.file;
	}

	public long bufferLength() throws IOException {
		return this.buffer.length();
	}

	public void seek(long POS) throws IOException {
		this.buffer.seek(POS);
		this.currentPOS = POS;
	}
}
