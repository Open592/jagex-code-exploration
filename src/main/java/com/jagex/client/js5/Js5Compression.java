package com.jagex.client.js5;

import com.jagex.client.compression.Bzip2Decompressor;
import com.jagex.client.compression.GzipDecompressor;
import com.jagex.client.Packet;

public final class Js5Compression {
    public static final GzipDecompressor GZIP_DECOMPRESSOR = new GzipDecompressor();
    public static final int MAX_LENGTH = 0;

    public static byte[] uncompress(byte[] buffer) {
        Packet packet = new Packet(buffer);
        int compressionType = packet.g1();
        // NOTE:
        // If the data is compressed this points to the *compressed length*.
        // If the data is uncompressed this points to the *uncompressed* length.
        int dataLength = packet.g4();

        if (dataLength < 0 || MAX_LENGTH != 0 && MAX_LENGTH < dataLength) {
            throw new RuntimeException();
        }

        if (compressionType == 0) {
            byte[] sink = new byte[dataLength];

            packet.gArrayBuffer(dataLength, sink);

            return sink;
        }

        int uncompressedLength = packet.g4();

        if (uncompressedLength < 0 || MAX_LENGTH != 0 && MAX_LENGTH < uncompressedLength) {
            throw new RuntimeException();
        }

        byte[] sink = new byte[uncompressedLength];

        if (compressionType == 1) {
            Bzip2Decompressor.uncompress(sink, uncompressedLength, buffer);
        } else {
            GZIP_DECOMPRESSOR.uncompress(sink, packet);
        }

        return sink;
    }
}
