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
	private int anInt170 = 0;

	@OriginalMember(owner = "client!al", name = "t", descriptor = "I")
	private int anInt183 = 0;

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

	@OriginalMember(owner = "client!al", name = "a", descriptor = "(IBI[B)V")
	public void method131(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) byte[] arg2) throws IOException {
		if (this.isShuttingDown) {
			return;
		}

		while (arg1 > 0) {
			@Pc(23) int bytesRead = this.inputStream.read(arg2, arg0, arg1);

			if (bytesRead <= 0) {
				throw new EOFException();
			}

			arg1 -= bytesRead;
			arg0 += bytesRead;
		}
	}

	@OriginalMember(owner = "client!al", name = "a", descriptor = "(I)V")
	public void method132() {
		if (!this.isShuttingDown) {
			this.inputStream = new InputStream_Sub1();
			this.outputStream = new OutputStream_Sub1();
		}
	}

	@OriginalMember(owner = "client!al", name = "b", descriptor = "(I)I")
	public int method133() throws IOException {
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

	@OriginalMember(owner = "client!al", name = "d", descriptor = "(I)I")
	public int readByte() throws IOException {
		return this.isShuttingDown ? 0 : this.inputStream.read();
	}

	@OriginalMember(owner = "client!al", name = "run", descriptor = "()V")
	@Override
	public void run() {
		try {
			while (true) {
				label80: {
					@Pc(40) int local40;
					@Pc(28) int local28;

					synchronized (this) {
						if (this.anInt183 == this.anInt170) {
							if (this.isShuttingDown) {
								break label80;
							}

							try {
								this.wait();
							} catch (@Pc(24) InterruptedException ignored) {
							}
						}

						local28 = this.anInt170;

						if (this.anInt170 <= this.anInt183) {
							local40 = this.anInt183 - this.anInt170;
						} else {
							local40 = 5000 - this.anInt170;
						}
					}

					if (local40 <= 0) {
						continue;
					}

					try {
						this.outputStream.write(this.buffer, local28, local40);
					} catch (@Pc(65) IOException e) {
						this.connectionNotHealthy = true;
					}

					this.anInt170 = (local40 + this.anInt170) % 5000;

					try {
						if (this.anInt183 == this.anInt170) {
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
	public void method141() throws IOException {
		if (!this.isShuttingDown && this.connectionNotHealthy) {
			this.connectionNotHealthy = false;
			throw new IOException();
		}
	}

	@OriginalMember(owner = "client!al", name = "a", descriptor = "(II[BI)V")
	public void queueClientMessage(@OriginalArg(0) int length, @OriginalArg(2) byte[] bytes) throws IOException {
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
				this.buffer[this.anInt183] = bytes[i];
				this.anInt183 = (this.anInt183 + 1) % 5000;
				if (this.anInt183 == (this.anInt170 + 4900) % 5000) {
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
