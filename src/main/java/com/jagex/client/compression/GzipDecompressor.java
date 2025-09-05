package com.jagex.client.compression;

import java.util.zip.Inflater;

import com.jagex.client.Packet;

public final class GzipDecompressor {

	private Inflater inflater;

	public GzipDecompressor() {}

	public void uncompress(byte[] output, Packet inputPacket) {
		if (inputPacket.data[inputPacket.pos] != 31 || inputPacket.data[inputPacket.pos + 1] != -117) {
            throw new RuntimeException("Invalid GZIP header!");
		}

		if (this.inflater == null) {
            this.inflater = new Inflater(true);
		}

		try {
            this.inflater.setInput(inputPacket.data, inputPacket.pos + 10, inputPacket.data.length - inputPacket.pos - 18);
            this.inflater.inflate(output);
		} catch (Exception ignored) {
            this.inflater.reset();
            throw new RuntimeException("Invalid GZIP compressed data!");
		}

		this.inflater.reset();
	}
}
