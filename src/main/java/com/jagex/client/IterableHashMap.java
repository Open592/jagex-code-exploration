package com.jagex.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ib")
public final class IterableHashMap {

	@OriginalMember(owner = "client!ib", name = "m", descriptor = "Lclient!vu;")
	private ListNode searchNode;

	@OriginalMember(owner = "client!ib", name = "n", descriptor = "J")
	private long hash;

	@OriginalMember(owner = "client!ib", name = "s", descriptor = "Lclient!vu;")
	private ListNode tail;

	@OriginalMember(owner = "client!ib", name = "r", descriptor = "I")
	private int currentBucketIndex = 0;

	@OriginalMember(owner = "client!ib", name = "d", descriptor = "[Lclient!vu;")
	public final ListNode[] buckets;

	@OriginalMember(owner = "client!ib", name = "a", descriptor = "I")
	public final int bucketCount;

	@OriginalMember(owner = "client!ib", name = "<init>", descriptor = "(I)V")
	public IterableHashMap(@OriginalArg(0) int bucketCount) {
		this.buckets = new ListNode[bucketCount];
		this.bucketCount = bucketCount;

		for (@Pc(13) int i = 0; i < bucketCount; i++) {
			@Pc(23) ListNode bucket = this.buckets[i] = new ListNode();

			bucket.previous = bucket;
			bucket.next = bucket;
		}
	}

	@OriginalMember(owner = "client!ib", name = "a", descriptor = "(I)Lclient!vu;")
	public ListNode getNextHashCollision() {
		if (this.searchNode == null) {
			return null;
		}

		@Pc(23) ListNode bucket = this.buckets[(int) ((long) (this.bucketCount - 1) & this.hash)];

		while (bucket != this.searchNode) {
			if (this.hash == this.searchNode.id) {
				@Pc(35) ListNode ret = this.searchNode;

				this.searchNode = this.searchNode.previous;

				return ret;
			}

			this.searchNode = this.searchNode.previous;
		}

		this.searchNode = null;

		return null;
	}

	@OriginalMember(owner = "client!ib", name = "b", descriptor = "(I)I")
	public int countNodes() {
		@Pc(7) int count = 0;

		for (@Pc(9) int i = 0; i < this.bucketCount; i++) {
			@Pc(16) ListNode currentNode = this.buckets[i];
			@Pc(19) ListNode previousNode = currentNode.previous;

			while (currentNode != previousNode) {
				previousNode = previousNode.previous;

				count++;
			}
		}

		return count;
	}

	@OriginalMember(owner = "client!ib", name = "c", descriptor = "(I)V")
	public void clear() {
		for (@Pc(3) int i = 0; i < this.bucketCount; i++) {
			@Pc(10) ListNode current = this.buckets[i];

			while (true) {
				@Pc(13) ListNode previous = current.previous;

				if (previous == current) {
					break;
				}

				previous.popSelf();
			}
		}

		this.searchNode = null;
		this.tail = null;
	}

	@OriginalMember(owner = "client!ib", name = "a", descriptor = "(JI)Lclient!vu;")
	public ListNode get(@OriginalArg(0) long hash) {
		this.hash = hash;

		@Pc(20) ListNode bucket = this.buckets[(int) (hash & (long) (this.bucketCount - 1))];

		for (this.searchNode = bucket.previous; this.searchNode != bucket; this.searchNode = this.searchNode.previous) {
			if (hash == this.searchNode.id) {
				@Pc(35) ListNode ret = this.searchNode;

				this.searchNode = this.searchNode.previous;

				return ret;
			}
		}

		this.searchNode = null;

		return null;
	}

	@OriginalMember(owner = "client!ib", name = "a", descriptor = "(JILclient!vu;)V")
	public void set(@OriginalArg(0) long hash, @OriginalArg(2) ListNode node) {
		if (node.next != null) {
			node.popSelf();
		}

		@Pc(26) ListNode bucket = this.buckets[(int) (hash & (long) (this.bucketCount - 1))];

		node.previous = bucket;
		node.next = bucket.next;
		node.next.previous = node;
		node.id = hash;
		node.previous.next = node;
	}

	@OriginalMember(owner = "client!ib", name = "b", descriptor = "(B)Lclient!vu;")
	public ListNode next() {
		@Pc(24) ListNode ret;

		if (this.currentBucketIndex > 0 && this.tail != this.buckets[this.currentBucketIndex - 1]) {
			ret = this.tail;
			this.tail = ret.previous;
			return ret;
		}

		while (this.currentBucketIndex < this.bucketCount) {
			ret = this.buckets[this.currentBucketIndex++].previous;

			if (this.buckets[this.currentBucketIndex - 1] != ret) {
				this.tail = ret.previous;
				return ret;
			}
		}

		return null;
	}

	@OriginalMember(owner = "client!ib", name = "c", descriptor = "(B)Lclient!vu;")
	public ListNode head() {
		this.currentBucketIndex = 0;
		return this.next();
	}

	@OriginalMember(owner = "client!ib", name = "d", descriptor = "(I)I")
	public int count() {
		return this.bucketCount;
	}

	@OriginalMember(owner = "client!ib", name = "a", descriptor = "(I[Lclient!vu;)I")
	public int toArray(@OriginalArg(1) ListNode[] result) {
		@Pc(15) int size = 0;

		for (@Pc(17) int i = 0; i < this.bucketCount; i++) {
			@Pc(24) ListNode bucket = this.buckets[i];

			for (@Pc(27) ListNode node = bucket.previous; node != bucket; node = node.previous) {
				result[size++] = node;
			}
		}
		return size;
	}
}
