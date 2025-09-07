package com.jagex.client.js5;

import com.jagex.client.Packet;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!je")
public final class Js5NetQueueRequest extends Js5QueueRequest {

  @OriginalMember(owner = "client!je", name = "I", descriptor = "Lclient!iv;")
  public Packet packet;

  @OriginalMember(owner = "client!je", name = "J", descriptor = "I")
  public int currentBlockPos;

  @OriginalMember(owner = "client!je", name = "L", descriptor = "B")
  public byte reservedBytes;

  @OriginalMember(owner = "client!je", name = "a", descriptor = "(I)I")
  @Override
  public int getDownloadPercentage() {
    return this.packet == null
        ? 0
        : this.packet.pos * 100 / (this.packet.data.length - this.reservedBytes);
  }

  @OriginalMember(owner = "client!je", name = "b", descriptor = "(Z)[B")
  @Override
  public byte[] getResponseData() {
    if (super.isRequestInProgress
        || this.packet.pos < this.packet.data.length - this.reservedBytes) {
      throw new RuntimeException();
    }

    return this.packet.data;
  }
}
