package com.jagex.client.js5;

import com.jagex.client.Packet;
import com.jagex.client.SecondaryLinkedList;
import com.jagex.client.ServerConnection;
import com.jagex.signlink.MonotonicClock;
import java.io.IOException;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!vn")
public final class Js5NetQueue {

  @OriginalMember(owner = "client!vn", name = "v", descriptor = "Lclient!al;")
  private ServerConnection serverConnection;

  @OriginalMember(owner = "client!vn", name = "w", descriptor = "J")
  private long lastRequestProcessedTime;

  @OriginalMember(owner = "client!vn", name = "y", descriptor = "I")
  private int timeSinceLastByteFromServer;

  @OriginalMember(owner = "client!vn", name = "D", descriptor = "Lclient!je;")
  private Js5NetQueueRequest currentRequest;

  @OriginalMember(owner = "client!vn", name = "j", descriptor = "Lclient!tn;")
  private final SecondaryLinkedList pendingUrgentRequests = new SecondaryLinkedList();

  @OriginalMember(owner = "client!vn", name = "s", descriptor = "Lclient!tn;")
  private final SecondaryLinkedList activeUrgentRequests = new SecondaryLinkedList();

  @OriginalMember(owner = "client!vn", name = "t", descriptor = "Lclient!tn;")
  private final SecondaryLinkedList pendingRegularRequests = new SecondaryLinkedList();

  @OriginalMember(owner = "client!vn", name = "u", descriptor = "Lclient!tn;")
  private final SecondaryLinkedList activeRegularRequests = new SecondaryLinkedList();

  @OriginalMember(owner = "client!vn", name = "x", descriptor = "Lclient!iv;")
  private final Packet outgoingPacket = new Packet(4);

  /**
   * Incoming packet from the server whose responsibility is to deliver control messages to the
   * client.
   *
   * <p><b>Primarily handles:</b>
   *
   * <ul>
   *   <li>Response headers (8 bytes)
   *   <li>Continuation marker (1 byte)
   * </ul>
   */
  private final Packet incomingPacket = new Packet(8);

  @OriginalMember(owner = "client!vn", name = "A", descriptor = "I")
  public volatile int connectionFailures = 0;

  @OriginalMember(owner = "client!vn", name = "B", descriptor = "B")
  private byte obfuscationKey = 0;

  public enum ProcessConnectionsResult {
    SUCCESSFULLY_PROCESSED_REQUESTS,
    NO_REQUESTS_TO_PROCESS,
    UNABLE_TO_PROCESS_REQUESTS,
  }

  // The size of a block of data.
  private static final int BLOCK_SIZE = 512;

  // A marker byte signifying that the next block of data is available for
  // transmission.
  //
  // If, after reading a full block of data, the server does not send this marker
  // we know the request has concluded.
  private static final int CONTINUATION_MARKER = -1;

  @OriginalMember(owner = "client!vn", name = "c", descriptor = "(I)I")
  public int getUrgentRequestCount() {
    return this.pendingUrgentRequests.size() + this.activeUrgentRequests.size();
  }

  @OriginalMember(owner = "client!vn", name = "a", descriptor = "(I)Z")
  public boolean isUrgentRequestQueueFull() {
    return this.getUrgentRequestCount() >= 20;
  }

  @OriginalMember(owner = "client!vn", name = "C", descriptor = "I")
  public volatile int errorCode = 0;

  @OriginalMember(owner = "client!vn", name = "a", descriptor = "(B)I")
  private int getRegularRequestCount() {
    return this.pendingRegularRequests.size() + this.activeRegularRequests.size();
  }

  @OriginalMember(owner = "client!vn", name = "f", descriptor = "(B)Z")
  public boolean isRegularRequestQueueFull() {
    return this.getRegularRequestCount() >= 20;
  }

  @OriginalMember(owner = "client!vn", name = "a", descriptor = "(ILclient!al;Z)V")
  public void init(
      @OriginalArg(1) ServerConnection serverConnection, @OriginalArg(2) boolean arg1) {
    if (this.serverConnection != null) {
      try {
        this.serverConnection.shutdown();
      } catch (Exception ignored) {
      }
    }

    this.serverConnection = serverConnection;
    this.method5462();
    this.informUserAuthenticationStatus(arg1);
    this.incomingPacket.pos = 0;
    this.currentRequest = null;

    while (true) {
      @Pc(40)
      Js5NetQueueRequest request = (Js5NetQueueRequest) this.activeUrgentRequests.popHead();

      if (request == null) {
        while (true) {
          request = (Js5NetQueueRequest) this.activeRegularRequests.popHead();

          if (request == null) {
            if (this.obfuscationKey != 0) {
              try {
                this.outgoingPacket.pos = 0;
                this.outgoingPacket.p1(JS5RequestOpCodes.JS5_STORE_OBFUSCATION_KEY);
                this.outgoingPacket.p1(this.obfuscationKey);
                this.outgoingPacket.p2(0);
                this.serverConnection.write(4, this.outgoingPacket.data);
              } catch (
                  @Pc(102)
                  IOException local102) {
                try {
                  this.serverConnection.shutdown();
                } catch (Exception ignored) {
                }
                this.errorCode = -2;
                this.connectionFailures++;
                this.serverConnection = null;
              }
            }

            this.timeSinceLastByteFromServer = 0;
            this.lastRequestProcessedTime = MonotonicClock.getCurrentTimeInMilliseconds();

            return;
          }
          this.pendingRegularRequests.insert(request);
        }
      }
      this.pendingUrgentRequests.insert(request);
    }
  }

  @OriginalMember(owner = "client!vn", name = "b", descriptor = "(B)V")
  private void method5462() {
    if (this.serverConnection == null) {
      return;
    }

    try {
      this.outgoingPacket.pos = 0;
      this.outgoingPacket.p1(JS5RequestOpCodes.JS5_CONNECTION_START);
      this.outgoingPacket.p3(3);
      this.serverConnection.write(4, this.outgoingPacket.data);
    } catch (
        @Pc(38)
        IOException local38) {
      try {
        this.serverConnection.shutdown();
      } catch (Exception ignored) {
      }

      this.serverConnection = null;
      this.connectionFailures++;
      this.errorCode = -2;
    }
  }

  @OriginalMember(owner = "client!vn", name = "c", descriptor = "(B)V")
  public void method5464() {
    try {
      this.serverConnection.shutdown();
    } catch (Exception ignored) {
    }

    this.serverConnection = null;
    this.errorCode = -1;
    this.obfuscationKey = (byte) (Math.random() * 255.0D + 1.0D);
    this.connectionFailures++;
  }

  @OriginalMember(owner = "client!vn", name = "a", descriptor = "(IBBZI)Lclient!je;")
  public Js5NetQueueRequest requestArchiveFile(
      @OriginalArg(0) int archive,
      @OriginalArg(1) byte reservedBytes,
      @OriginalArg(3) boolean isUrgent,
      @OriginalArg(4) int group) {
    @Pc(19)
    long archiveGroupId = ((long) archive << 16) + group;

    @Pc(23)
    Js5NetQueueRequest request = new Js5NetQueueRequest();
    request.secondaryValue = archiveGroupId;
    request.isUrgent = isUrgent;
    request.reservedBytes = reservedBytes;

    if (isUrgent) {
      if (this.getUrgentRequestCount() >= 20) {
        throw new RuntimeException();
      }
      this.pendingUrgentRequests.insert(request);
    } else if (this.getRegularRequestCount() < 20) {
      this.pendingRegularRequests.insert(request);
    } else {
      throw new RuntimeException();
    }

    return request;
  }

  @OriginalMember(owner = "client!vn", name = "d", descriptor = "(B)V")
  public void breakConnection() {
    if (this.serverConnection != null) {
      this.serverConnection.breakConnection();
    }
  }

  @OriginalMember(owner = "client!vn", name = "a", descriptor = "(ZB)V")
  public void informUserAuthenticationStatus(boolean isLoggedIn) {
    if (this.serverConnection == null) {
      return;
    }

    try {
      this.outgoingPacket.pos = 0;
      this.outgoingPacket.p1(
          isLoggedIn
              ? JS5RequestOpCodes.JS5_INFORM_USER_IS_LOGGED_IN
              : JS5RequestOpCodes.JS5_INFORM_USER_IS_LOGGED_OUT);
      this.outgoingPacket.p3(0);
      this.serverConnection.write(4, this.outgoingPacket.data);
    } catch (IOException e) {
      try {
        this.serverConnection.shutdown();
      } catch (Exception ignored) {
      }

      this.errorCode = -2;
      this.serverConnection = null;
      this.connectionFailures++;
    }
  }

  @OriginalMember(owner = "client!vn", name = "e", descriptor = "(B)V")
  public void requestServerToDropRequests() {
    if (this.serverConnection == null) {
      return;
    }

    try {
      this.outgoingPacket.pos = 0;
      this.outgoingPacket.p1(JS5RequestOpCodes.JS5_DROP_ACTIVE_REQUESTS);
      this.outgoingPacket.p3(0);
      this.serverConnection.write(4, this.outgoingPacket.data);
    } catch (
        @Pc(32)
        IOException local32) {
      try {
        this.serverConnection.shutdown();
      } catch (Exception ignored) {
      }
      this.errorCode = -2;
      this.serverConnection = null;
      this.connectionFailures++;
    }
  }

  @OriginalMember(owner = "client!vn", name = "b", descriptor = "(I)Z")
  public ProcessConnectionsResult processJS5Requests() {
    if (this.serverConnection != null) {
      @Pc(11)
      long currentTimeInMilliseconds = MonotonicClock.getCurrentTimeInMilliseconds();

      int delta = (int) (currentTimeInMilliseconds - this.lastRequestProcessedTime);

      this.lastRequestProcessedTime = currentTimeInMilliseconds;
      this.timeSinceLastByteFromServer += Math.min(delta, 200);

      if (this.timeSinceLastByteFromServer > 30000) {
        try {
          this.serverConnection.shutdown();
        } catch (Exception ignored) {
        }

        this.serverConnection = null;
      }
    }

    if (this.serverConnection == null) {
      return (this.getUrgentRequestCount() == 0 && this.getRegularRequestCount() == 0)
          ? ProcessConnectionsResult.NO_REQUESTS_TO_PROCESS
          : ProcessConnectionsResult.UNABLE_TO_PROCESS_REQUESTS;
    }

    try {
      this.serverConnection.verifyIsHealthy();

      for (@Pc(76)
          Js5NetQueueRequest request = (Js5NetQueueRequest) this.pendingUrgentRequests.getHead();
          request != null;
          request = (Js5NetQueueRequest) this.pendingUrgentRequests.next()) {
        this.outgoingPacket.pos = 0;
        this.outgoingPacket.p1(JS5RequestOpCodes.JS5_URGENT_REQUEST);
        this.outgoingPacket.p3((int) request.secondaryValue);
        this.serverConnection.write(4, this.outgoingPacket.data);
        this.activeUrgentRequests.insert(request);
      }

      for (@Pc(122)
          Js5NetQueueRequest request = (Js5NetQueueRequest) this.pendingRegularRequests.getHead();
          request != null;
          request = (Js5NetQueueRequest) this.pendingRegularRequests.next()) {
        this.outgoingPacket.pos = 0;
        this.outgoingPacket.p1(JS5RequestOpCodes.JS5_REGULAR_REQUEST);
        this.outgoingPacket.p3((int) request.secondaryValue);
        this.serverConnection.write(4, this.outgoingPacket.data);
        this.activeRegularRequests.insert(request);
      }

      for (int i = 0; i < 100; i++) {
        @Pc(177)
        int estimatedBytesAvailable = this.serverConnection.getEstimatedBytesAvailable();

        if (estimatedBytesAvailable < 0) {
          throw new IOException();
        }

        if (estimatedBytesAvailable == 0) {
          break;
        }

        this.timeSinceLastByteFromServer = 0;

        // Read the rest of this block's data.
        @Pc(190)
        byte local190 = 0;

        if (this.currentRequest == null) {
          // Read next block's header
          local190 = 8;
        } else if (this.currentRequest.currentBlockPos == 0) {
          // Check for continuation marker
          local190 = 1;
        }

        if (local190 == 0) {
          int packetSize =
              this.currentRequest.packet.data.length - this.currentRequest.reservedBytes;
          int bytesToRead = BLOCK_SIZE - this.currentRequest.currentBlockPos;

          if (packetSize - this.currentRequest.packet.pos < bytesToRead) {
            bytesToRead = packetSize - this.currentRequest.packet.pos;
          }

          if (bytesToRead > estimatedBytesAvailable) {
            bytesToRead = estimatedBytesAvailable;
          }

          this.serverConnection.readBytesFromServer(
              this.currentRequest.packet.pos, bytesToRead, this.currentRequest.packet.data);

          // De-obfuscate all data read in this turn.
          if (this.obfuscationKey != 0) {
            for (int j = 0; j < bytesToRead; j++) {
              this.currentRequest.packet.data[j + this.currentRequest.packet.pos] ^=
                  this.obfuscationKey;
            }
          }

          this.currentRequest.packet.pos += bytesToRead;
          this.currentRequest.currentBlockPos += bytesToRead;

          if (this.currentRequest.packet.pos == packetSize) {
            this.currentRequest.secondaryPopSelf();
            this.currentRequest.isRequestInProgress = false;
            this.currentRequest = null;
          } else if (this.currentRequest.currentBlockPos == BLOCK_SIZE) {
            this.currentRequest.currentBlockPos = 0;
          }
        } else {
          int bytesToReadFromServer = local190 - this.incomingPacket.pos;

          if (bytesToReadFromServer > estimatedBytesAvailable) {
            bytesToReadFromServer = estimatedBytesAvailable;
          }

          this.serverConnection.readBytesFromServer(
              this.incomingPacket.pos, bytesToReadFromServer, this.incomingPacket.data);

          if (this.obfuscationKey != 0) {
            for (int j = 0; j < bytesToReadFromServer; j++) {
              this.incomingPacket.data[this.incomingPacket.pos + j] ^= this.obfuscationKey;
            }
          }

          this.incomingPacket.pos += bytesToReadFromServer;

          if (local190 <= this.incomingPacket.pos) {
            if (this.currentRequest == null) {
              this.incomingPacket.pos = 0;

              int archive = this.incomingPacket.g1();
              int group = this.incomingPacket.g2();
              int flags = this.incomingPacket.g1();
              int length = this.incomingPacket.g4();

              int compressionType = flags & 0x7F;
              boolean isPrefetch = (flags & 0x80) != 0;
              long archiveGroupId = ((long) archive << 16) + group;
              Js5NetQueueRequest request;

              var queueToSearch =
                  isPrefetch ? this.activeRegularRequests : this.activeUrgentRequests;

              for (request = (Js5NetQueueRequest) queueToSearch.getHead();
                  request != null && request.secondaryValue != archiveGroupId;
                  request = (Js5NetQueueRequest) queueToSearch.next()) {}

              if (request == null) {
                throw new IOException();
              }

              // If the data is compressed, the header will include both compressed and uncompressed
              // size,
              // otherwise it will just include the size of the uncompressed data.
              int headerSize = compressionType == 0 ? 5 : 9;
              this.currentRequest = request;
              this.currentRequest.packet =
                  new Packet(headerSize + length + this.currentRequest.reservedBytes);
              this.currentRequest.packet.p1(compressionType);
              this.currentRequest.packet.p4(length);
              this.currentRequest.currentBlockPos = 8;
              this.incomingPacket.pos = 0;
            } else if (this.currentRequest.currentBlockPos != 0) {
              // At this point we expect that we have finalized a data block.
              throw new IOException();
            } else if (this.incomingPacket.data[0] == CONTINUATION_MARKER) {
              this.currentRequest.currentBlockPos = 1;
              this.incomingPacket.pos = 0;
            } else {
              // Nothing more to read in this request.
              this.currentRequest = null;
            }
          }
        }
      }

      return ProcessConnectionsResult.SUCCESSFULLY_PROCESSED_REQUESTS;
    } catch (IOException e) {
      try {
        this.serverConnection.shutdown();
      } catch (Exception ignored) {
      }

      this.connectionFailures++;
      this.errorCode = -2;
      this.serverConnection = null;

      return (this.getUrgentRequestCount() == 0 && this.getRegularRequestCount() == 0)
          ? ProcessConnectionsResult.NO_REQUESTS_TO_PROCESS
          : ProcessConnectionsResult.UNABLE_TO_PROCESS_REQUESTS;
    }
  }

  @OriginalMember(owner = "client!vn", name = "e", descriptor = "(I)V")
  public void shutdown() {
    if (this.serverConnection != null) {
      this.serverConnection.shutdown();
    }
  }
}
