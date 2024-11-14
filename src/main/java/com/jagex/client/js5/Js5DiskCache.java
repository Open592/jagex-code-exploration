package com.jagex.client.js5;

import com.jagex.client.Static94;
import com.jagex.client.utilities.ThreadingUtilities;
import com.jagex.client.SecondaryLinkedList;
import com.jagex.signlink.Message;
import com.jagex.signlink.SignLink;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!vl")
public final class Js5DiskCache implements Runnable {

	@OriginalMember(owner = "client!vl", name = "g", descriptor = "Lclient!tn;")
	private final SecondaryLinkedList aSecondaryLinkedList_6 = new SecondaryLinkedList();

	@OriginalMember(owner = "client!vl", name = "q", descriptor = "I")
	public int anInt7015 = 0;

	@OriginalMember(owner = "client!vl", name = "p", descriptor = "Z")
	private boolean aBoolean659 = false;

	@OriginalMember(owner = "client!vl", name = "n", descriptor = "Ljava/lang/Thread;")
	private Thread thread;

	@OriginalMember(owner = "client!vl", name = "<init>", descriptor = "(Lclient!et;)V")
	public Js5DiskCache(@OriginalArg(0) SignLink signLink) {
		@Pc(20) Message threadInitializationMessage = signLink.emitThreadInitializationMessage(5, this);

		while (threadInitializationMessage.isInProgress()) {
			ThreadingUtilities.sleepFor(10L);
		}

		if (!threadInitializationMessage.isSuccess()) {
			throw new RuntimeException();
		}

		this.thread = (Thread) threadInitializationMessage.output;
	}

	@OriginalMember(owner = "client!vl", name = "a", descriptor = "(ILclient!st;I)Lclient!lf;")
	public Js5DiskCacheRequestItem method5431(@OriginalArg(1) Class222 arg0, @OriginalArg(2) int arg1) {
		@Pc(7) Js5DiskCacheRequestItem request = new Js5DiskCacheRequestItem();

		request.isUrgent = false;
		request.aClass222_1 = arg0;
		request.anInt4117 = 3;
		request.secondaryValue = arg1;

		this.method5434(request);

		return request;
	}

	@OriginalMember(owner = "client!vl", name = "a", descriptor = "(Lclient!st;II)Lclient!lf;")
	public Js5DiskCacheRequestItem method5432(@OriginalArg(0) Class222 arg0, @OriginalArg(2) int arg1) {
		@Pc(9) Js5DiskCacheRequestItem local9 = new Js5DiskCacheRequestItem();
		local9.anInt4117 = 1;
		@Pc(15) SecondaryLinkedList local15 = this.aSecondaryLinkedList_6;
		synchronized (this.aSecondaryLinkedList_6) {
			@Pc(23) Js5DiskCacheRequestItem local23 = (Js5DiskCacheRequestItem) this.aSecondaryLinkedList_6.getHead();
			while (true) {
				if (local23 == null) {
					break;
				}
				if ((long) arg1 == local23.secondaryValue && local23.aClass222_1 == arg0 && local23.anInt4117 == 2) {
					local9.isRequestInProgress = false;
					local9.responseData = local23.responseData;
					return local9;
				}
				local23 = (Js5DiskCacheRequestItem) this.aSecondaryLinkedList_6.next();
			}
		}
		local9.responseData = arg0.method4981(arg1);
		local9.isUrgent = true;
		local9.isRequestInProgress = false;
		return local9;
	}

	@OriginalMember(owner = "client!vl", name = "a", descriptor = "(I)V")
	public void method5433() {
		this.aBoolean659 = true;
		@Pc(9) SecondaryLinkedList local9 = this.aSecondaryLinkedList_6;
		synchronized (this.aSecondaryLinkedList_6) {
			this.aSecondaryLinkedList_6.notifyAll();
		}
		try {
			this.thread.join();
		} catch (@Pc(30) InterruptedException local30) {
		}
		this.thread = null;
	}

	@OriginalMember(owner = "client!vl", name = "run", descriptor = "()V")
	@Override
	public void run() {
		while (!this.aBoolean659) {
			@Pc(10) SecondaryLinkedList local10 = this.aSecondaryLinkedList_6;
			@Pc(18) Js5DiskCacheRequestItem local18;
			synchronized (this.aSecondaryLinkedList_6) {
				local18 = (Js5DiskCacheRequestItem) this.aSecondaryLinkedList_6.popHead();
				if (local18 == null) {
					try {
						this.aSecondaryLinkedList_6.wait();
					} catch (@Pc(25) InterruptedException local25) {
					}
					continue;
				}
				this.anInt7015--;
			}
			try {
				if (local18.anInt4117 == 2) {
					local18.aClass222_1.method4982(local18.responseData, (int) local18.secondaryValue, local18.responseData.length);
				} else if (local18.anInt4117 == 3) {
					local18.responseData = local18.aClass222_1.method4981((int) local18.secondaryValue);
				}
			} catch (@Pc(74) Exception local74) {
				Static94.handleClientError(local74, null);
			}
			local18.isRequestInProgress = false;
		}
	}

	@OriginalMember(owner = "client!vl", name = "a", descriptor = "(ILclient!lf;)V")
	private void method5434(@OriginalArg(1) Js5DiskCacheRequestItem request) {
		@Pc(2) SecondaryLinkedList local2 = this.aSecondaryLinkedList_6;

		synchronized (this.aSecondaryLinkedList_6) {
			this.aSecondaryLinkedList_6.insert(request);
			this.anInt7015++;
			this.aSecondaryLinkedList_6.notifyAll();
		}
	}

	@OriginalMember(owner = "client!vl", name = "a", descriptor = "(II[BLclient!st;)Lclient!lf;")
	public Js5DiskCacheRequestItem method5435(@OriginalArg(1) int arg0, @OriginalArg(2) byte[] arg1, @OriginalArg(3) Class222 arg2) {
		@Pc(13) Js5DiskCacheRequestItem local13 = new Js5DiskCacheRequestItem();
		local13.secondaryValue = arg0;
		local13.anInt4117 = 2;
		local13.responseData = arg1;
		local13.aClass222_1 = arg2;
		local13.isUrgent = false;
		this.method5434(local13);
		return local13;
	}
}
