package com.jagex.client.js5;

import com.jagex.client.SecondaryLinkedList;
import com.jagex.client.Static94;
import com.jagex.client.utilities.ThreadingUtilities;
import com.jagex.signlink.Message;
import com.jagex.signlink.SignLink;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!vl")
public final class Js5DiskCache implements Runnable {

  @OriginalMember(owner = "client!vl", name = "g", descriptor = "Lclient!tn;")
  private final SecondaryLinkedList requestItems = new SecondaryLinkedList();

  @OriginalMember(owner = "client!vl", name = "q", descriptor = "I")
  public int anInt7015 = 0;

  @OriginalMember(owner = "client!vl", name = "p", descriptor = "Z")
  private boolean isStopped = false;

  @OriginalMember(owner = "client!vl", name = "n", descriptor = "Ljava/lang/Thread;")
  private Thread thread;

  @OriginalMember(owner = "client!vl", name = "<init>", descriptor = "(Lclient!et;)V")
  public Js5DiskCache(@OriginalArg(0) SignLink signLink) {
    @Pc(20)
    Message threadInitializationMessage = signLink.emitThreadInitializationMessage(5, this);

    while (threadInitializationMessage.isInProgress()) {
      ThreadingUtilities.sleepFor(10L);
    }

    if (!threadInitializationMessage.isSuccess()) {
      throw new RuntimeException();
    }

    this.thread = (Thread) threadInitializationMessage.output;
  }

  @OriginalMember(owner = "client!vl", name = "a", descriptor = "(ILclient!st;I)Lclient!lf;")
  public Js5DiskCacheRequestItem method5431(@OriginalArg(1) Cache arg0, @OriginalArg(2) int arg1) {
    @Pc(7)
    Js5DiskCacheRequestItem request = new Js5DiskCacheRequestItem();

    request.isUrgent = false;
    request.aCache_1 = arg0;
    request.anInt4117 = 3;
    request.secondaryValue = arg1;

    this.method5434(request);

    return request;
  }

  @OriginalMember(owner = "client!vl", name = "a", descriptor = "(Lclient!st;II)Lclient!lf;")
  public Js5DiskCacheRequestItem method5432(@OriginalArg(0) Cache arg0, @OriginalArg(2) int group) {
    @Pc(9)
    Js5DiskCacheRequestItem local9 = new Js5DiskCacheRequestItem();

    local9.anInt4117 = 1;

    synchronized (this.requestItems) {
      @Pc(23)
      Js5DiskCacheRequestItem requestItem = (Js5DiskCacheRequestItem) this.requestItems.getHead();

      while (true) {
        if (requestItem == null) {
          break;
        }

        if ((long) group == requestItem.secondaryValue
            && requestItem.aCache_1 == arg0
            && requestItem.anInt4117 == 2) {
          local9.isRequestInProgress = false;
          local9.responseData = requestItem.responseData;
          return local9;
        }

        requestItem = (Js5DiskCacheRequestItem) this.requestItems.next();
      }
    }

    local9.responseData = arg0.read(group);
    local9.isUrgent = true;
    local9.isRequestInProgress = false;

    return local9;
  }

  @OriginalMember(owner = "client!vl", name = "a", descriptor = "(I)V")
  public void stop() {
    this.isStopped = true;

    synchronized (this.requestItems) {
      this.requestItems.notifyAll();
    }

    try {
      this.thread.join();
    } catch (
        @Pc(30)
        InterruptedException local30) {
    }

    this.thread = null;
  }

  @OriginalMember(owner = "client!vl", name = "run", descriptor = "()V")
  @Override
  public void run() {
    while (!this.isStopped) {
      @Pc(10)
      SecondaryLinkedList local10 = this.requestItems;
      @Pc(18)
      Js5DiskCacheRequestItem local18;
      synchronized (this.requestItems) {
        local18 = (Js5DiskCacheRequestItem) this.requestItems.popHead();
        if (local18 == null) {
          try {
            this.requestItems.wait();
          } catch (
              @Pc(25)
              InterruptedException local25) {
          }
          continue;
        }
        this.anInt7015--;
      }
      try {
        if (local18.anInt4117 == 2) {
          local18.aCache_1.write(
              local18.responseData, (int) local18.secondaryValue, local18.responseData.length);
        } else if (local18.anInt4117 == 3) {
          local18.responseData = local18.aCache_1.read((int) local18.secondaryValue);
        }
      } catch (
          @Pc(74)
          Exception local74) {
        Static94.handleClientError(local74, null);
      }
      local18.isRequestInProgress = false;
    }
  }

  @OriginalMember(owner = "client!vl", name = "a", descriptor = "(ILclient!lf;)V")
  private void method5434(@OriginalArg(1) Js5DiskCacheRequestItem request) {
    @Pc(2)
    SecondaryLinkedList local2 = this.requestItems;

    synchronized (this.requestItems) {
      this.requestItems.insert(request);
      this.anInt7015++;
      this.requestItems.notifyAll();
    }
  }

  @OriginalMember(owner = "client!vl", name = "a", descriptor = "(II[BLclient!st;)Lclient!lf;")
  public Js5DiskCacheRequestItem method5435(
      @OriginalArg(1) int arg0, @OriginalArg(2) byte[] arg1, @OriginalArg(3) Cache arg2) {
    @Pc(13)
    Js5DiskCacheRequestItem local13 = new Js5DiskCacheRequestItem();

    local13.secondaryValue = arg0;
    local13.anInt4117 = 2;
    local13.responseData = arg1;
    local13.aCache_1 = arg2;
    local13.isUrgent = false;

    this.method5434(local13);

    return local13;
  }
}
