package com.jagex.signlink;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class Class207 {

	private File aFile1;

	private RandomAccessFile aRandomAccessFile1;

	private long aLong200;

	private long aLong201;

	private Class207() {
	}

	public void method4713() throws IOException {
		if (this.aRandomAccessFile1 != null) {
			this.aRandomAccessFile1.close();
			this.aRandomAccessFile1 = null;
		}
	}

	@Override
	public void finalize() throws Throwable {
		if (this.aRandomAccessFile1 != null) {
			System.out.println("Warning! fileondisk " + this.aFile1 + " not closed correctly using close(). Auto-closing instead. ");
			this.method4713();
		}
	}

	public void method4714(int arg0, int arg1, byte[] arg2) throws IOException {
		if (this.aLong201 < this.aLong200 + (long) arg1) {
			this.aRandomAccessFile1.seek(this.aLong201);
			this.aRandomAccessFile1.write(1);
			throw new EOFException();
		} else {
			this.aRandomAccessFile1.write(arg2, arg0, arg1);
			this.aLong200 += arg1;
		}
	}

	public int method4715(int arg0, int arg1, byte[] arg2) throws IOException {
		int local6 = this.aRandomAccessFile1.read(arg2, arg0, arg1);

		if (local6 > 0) {
			this.aLong200 += local6;
		}

		return local6;
	}

	public File method4716() {
		return this.aFile1;
	}

	public long method4717() throws IOException {
		return this.aRandomAccessFile1.length();
	}

	public void method4718(long arg0) throws IOException {
		this.aRandomAccessFile1.seek(arg0);
		this.aLong200 = arg0;
	}
}
