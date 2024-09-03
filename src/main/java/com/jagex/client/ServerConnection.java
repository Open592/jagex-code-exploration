package com.jagex.client;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.jagex.signlink.Message;
import com.jagex.signlink.SignLink;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!al")
public final class ServerConnection implements Runnable {

	@OriginalMember(owner = "client!al", name = "b", descriptor = "[B")
	private byte[] buffer;

	@OriginalMember(owner = "client!al", name = "n", descriptor = "Lclient!qt;")
	private Message Js5NetThreadMessage;

	@OriginalMember(owner = "client!al", name = "s", descriptor = "Z")
	private boolean isShuttingDown = false;

	@OriginalMember(owner = "client!al", name = "x", descriptor = "Z")
	private boolean connectionNotHealthy = false;

	@OriginalMember(owner = "client!al", name = "c", descriptor = "I")
	private int writePointer = 0;

	@OriginalMember(owner = "client!al", name = "t", descriptor = "I")
	private int readPointer = 0;

	@OriginalMember(owner = "client!al", name = "w", descriptor = "Ljava/net/Socket;")
	private final Socket connection;

	@OriginalMember(owner = "client!al", name = "f", descriptor = "Lclient!et;")
	private final SignLink signLink;

	@OriginalMember(owner = "client!al", name = "u", descriptor = "Ljava/io/InputStream;")
	private InputStream inputStream;

	@OriginalMember(owner = "client!al", name = "a", descriptor = "Ljava/io/OutputStream;")
	private OutputStream outputStream;

	@OriginalMember(owner = "client!al", name = "<init>", descriptor = "(Ljava/net/Socket;Lclient!et;)V")
	public ServerConnection(@OriginalArg(0) Socket connection, @OriginalArg(1) SignLink signLink) throws IOException {
		this.connection = connection;
		this.signLink = signLink;
		this.connection.setSoTimeout(30000);
		this.connection.setTcpNoDelay(true);
		this.inputStream = this.connection.getInputStream();
		this.outputStream = this.connection.getOutputStream();
	}

	@OriginalMember(owner = "client!al", name = "finalize", descriptor = "()V")
	@Override
    protected void finalize() {
		this.shutdown();
	}

	@OriginalMember(owner = "client!al", name = "d", descriptor = "(I)I")
	public int readByteFromServer() throws IOException {
		return this.isShuttingDown ? 0 : this.inputStream.read();
	}

	@OriginalMember(owner = "client!al", name = "a", descriptor = "(IBI[B)V")
	public void readBytesFromServer(@OriginalArg(0) int offset, @OriginalArg(2) int length, @OriginalArg(3) byte[] buffer) throws IOException {
		if (this.isShuttingDown) {
			return;
		}

		while (length > 0) {
			@Pc(23) int bytesRead = this.inputStream.read(buffer, offset, length);

			if (bytesRead <= 0) {
				throw new EOFException();
			}

			length -= bytesRead;
			offset += bytesRead;
		}
	}

	@OriginalMember(owner = "client!al", name = "a", descriptor = "(I)V")
	public void breakConnection() {
		if (!this.isShuttingDown) {
			this.inputStream = new NOOPInputStream();
			this.outputStream = new NOOPOutputStream();
		}
	}

	@OriginalMember(owner = "client!al", name = "b", descriptor = "(I)I")
	public int getEstimatedBytesAvailable() throws IOException {
		return this.isShuttingDown ? 0 : this.inputStream.available();
	}

	@OriginalMember(owner = "client!al", name = "a", descriptor = "(Z)V")
	public void shutdown() {
		if (this.isShuttingDown) {
			return;
		}

		synchronized (this) {
			this.isShuttingDown = true;
			this.notifyAll();
		}

		if (this.Js5NetThreadMessage != null) {
			while (this.Js5NetThreadMessage.status == 0) {
				Static435.sleepFor(1L);
			}

			if (this.Js5NetThreadMessage.status == 1) {
				try {
					((Thread) this.Js5NetThreadMessage.output).join();
				} catch (@Pc(56) InterruptedException ignored) {
				}
			}
		}

		this.Js5NetThreadMessage = null;
	}

	@OriginalMember(owner = "client!al", name = "run", descriptor = "()V")
	@Override
	public void run() {
		try {
			while (true) {
				writeBytes: {
					@Pc(40) int length;
					@Pc(28) int offset;

					synchronized (this) {
						if (this.readPointer == this.writePointer) {
							if (this.isShuttingDown) {
								break writeBytes;
							}

							try {
								this.wait();
							} catch (@Pc(24) InterruptedException ignored) {
							}
						}

						offset = this.writePointer;

						if (this.writePointer <= this.readPointer) {
							length = this.readPointer - this.writePointer;
						} else {
							length = 5000 - this.writePointer;
						}
					}

					if (length <= 0) {
						continue;
					}

					try {
						this.outputStream.write(this.buffer, offset, length);
					} catch (@Pc(65) IOException e) {
						this.connectionNotHealthy = true;
					}

					this.writePointer = (length + this.writePointer) % 5000;

					try {
						if (this.readPointer == this.writePointer) {
							this.outputStream.flush();
						}
					} catch (@Pc(86) IOException e) {
						this.connectionNotHealthy = true;
					}

					continue;
				}

				try {
					if (this.inputStream != null) {
						this.inputStream.close();
					}

					if (this.outputStream != null) {
						this.outputStream.close();
					}

					if (this.connection != null) {
						this.connection.close();
					}
				} catch (@Pc(110) IOException ignored) {
				}

				this.buffer = null;

				break;
			}
		} catch (@Pc(115) Exception e) {
			Static94.handleClientError(e, null);
		}
	}

	@OriginalMember(owner = "client!al", name = "e", descriptor = "(I)V")
	public void verifyIsHealthy() throws IOException {
		if (!this.isShuttingDown && this.connectionNotHealthy) {
			this.connectionNotHealthy = false;

			throw new IOException();
		}
	}

	@OriginalMember(owner = "client!al", name = "a", descriptor = "(II[BI)V")
	public void write(@OriginalArg(0) int length, @OriginalArg(2) byte[] bytes) throws IOException {
		if (this.isShuttingDown) {
			return;
		}

		if (this.connectionNotHealthy) {
			this.connectionNotHealthy = false;
			throw new IOException();
		}

		if (this.buffer == null) {
			this.buffer = new byte[5000];
		}

		synchronized (this) {
			for (@Pc(38) int i = 0; i < length; i++) {
				this.buffer[this.readPointer] = bytes[i];
				this.readPointer = (this.readPointer + 1) % 5000;
				if (this.readPointer == (this.writePointer + 4900) % 5000) {
					throw new IOException();
				}
			}

			if (this.Js5NetThreadMessage == null) {
				this.Js5NetThreadMessage = this.signLink.emitThreadInitializationMessage(3, this);
			}

			this.notifyAll();
		}
	}
}
