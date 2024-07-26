package com.jagex.signlink;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class FileOnDisk {

	private File file;

	private RandomAccessFile buffer;

	private long currentPOS;

	private long aLong201;

	private FileOnDisk() {
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
		if (this.currentPOS + (long) length > this.aLong201) {
			this.buffer.seek(this.aLong201);
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
