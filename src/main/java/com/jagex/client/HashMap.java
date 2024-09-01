package com.jagex.client;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ib")
public final class HashMap {

	@OriginalMember(owner = "client!ib", name = "m", descriptor = "Lclient!vu;")
	private Node nextFoundNodePointer;

	@OriginalMember(owner = "client!ib", name = "n", descriptor = "J")
	private long lastProvidedHashKey;

	@OriginalMember(owner = "client!ib", name = "s", descriptor = "Lclient!vu;")
	private Node nextNodePointer;

	@OriginalMember(owner = "client!ib", name = "r", descriptor = "I")
	private int currentBucketIndex = 0;

	@OriginalMember(owner = "client!ib", name = "d", descriptor = "[Lclient!vu;")
	public final Node[] buckets;

	@OriginalMember(owner = "client!ib", name = "a", descriptor = "I")
	public final int bucketCount;

	@OriginalMember(owner = "client!ib", name = "<init>", descriptor = "(I)V")
	public HashMap(int bucketCount) {
		this.buckets = new Node[bucketCount];
		this.bucketCount = bucketCount;

		for (int i = 0; i < bucketCount; i++) {
			Node sentinelNode = this.buckets[i] = new Node();

			sentinelNode.previous = sentinelNode;
			sentinelNode.next = sentinelNode;
		}
	}

	@OriginalMember(owner = "client!ib", name = "a", descriptor = "(I)Lclient!vu;")
	public Node nextFoundNode() {
		if (this.nextFoundNodePointer == null) {
			return null;
		}

		Node sentinelNode = this.buckets[(int) ((long) (this.bucketCount - 1) & this.lastProvidedHashKey)];

		while (sentinelNode != this.nextFoundNodePointer) {
			if (this.lastProvidedHashKey == this.nextFoundNodePointer.hashKey) {
				Node ret = this.nextFoundNodePointer;

				this.nextFoundNodePointer = this.nextFoundNodePointer.previous;

				return ret;
			}

			this.nextFoundNodePointer = this.nextFoundNodePointer.previous;
		}

		this.nextFoundNodePointer = null;

		return null;
	}

	@OriginalMember(owner = "client!ib", name = "b", descriptor = "(I)I")
	public int size() {
		int count = 0;

		for (int i = 0; i < this.bucketCount; i++) {
			Node sentinelNode = this.buckets[i];
			Node currentNode = sentinelNode.previous;

			while (sentinelNode != currentNode) {
				currentNode = currentNode.previous;

				count++;
			}
		}

		return count;
	}

	@OriginalMember(owner = "client!ib", name = "c", descriptor = "(I)V")
	public void clear() {
		for (int i = 0; i < this.bucketCount; i++) {
			Node sentinelNode = this.buckets[i];

			while (true) {
				Node currentNode = sentinelNode.previous;

				if (currentNode == sentinelNode) {
					break;
				}

				currentNode.popSelf();
			}
		}

		this.nextFoundNodePointer = null;
		this.nextNodePointer = null;
	}

	@OriginalMember(owner = "client!ib", name = "a", descriptor = "(JI)Lclient!vu;")
	public Node get(long hashKey) {
		this.lastProvidedHashKey = hashKey;

		Node sentinelNode = this.buckets[(int) (hashKey & (long) (this.bucketCount - 1))];

		for (
			this.nextFoundNodePointer = sentinelNode.previous;
			this.nextFoundNodePointer != sentinelNode;
			this.nextFoundNodePointer = this.nextFoundNodePointer.previous
		) {
			if (hashKey == this.nextFoundNodePointer.hashKey) {
				Node ret = this.nextFoundNodePointer;

				this.nextFoundNodePointer = this.nextFoundNodePointer.previous;

				return ret;
			}
		}

		this.nextFoundNodePointer = null;

		return null;
	}

	@OriginalMember(owner = "client!ib", name = "a", descriptor = "(JILclient!vu;)V")
	public void set(long hashKey, Node node) {
		if (node.next != null) {
			node.popSelf();
		}

		Node sentinelNode = this.buckets[(int) (hashKey & (long) (this.bucketCount - 1))];

		node.previous = sentinelNode;
		node.next = sentinelNode.next;
		node.next.previous = node;
		node.hashKey = hashKey;
		node.previous.next = node;
	}

	@OriginalMember(owner = "client!ib", name = "b", descriptor = "(B)Lclient!vu;")
	public Node next() {
		Node ret;

		if (
			this.currentBucketIndex > 0 &&
			this.nextNodePointer != this.buckets[this.currentBucketIndex - 1]
		) {
			ret = this.nextNodePointer;

			this.nextNodePointer = ret.previous;

			return ret;
		}

		while (this.currentBucketIndex < this.bucketCount) {
			ret = this.buckets[this.currentBucketIndex++].previous;

			if (this.buckets[this.currentBucketIndex - 1] != ret) {
				this.nextNodePointer = ret.previous;

				return ret;
			}
		}

		return null;
	}

	@OriginalMember(owner = "client!ib", name = "c", descriptor = "(B)Lclient!vu;")
	public Node head() {
		this.currentBucketIndex = 0;

		return this.next();
	}

	@OriginalMember(owner = "client!ib", name = "d", descriptor = "(I)I")
	public int bucketCount() {
		return this.bucketCount;
	}

	@OriginalMember(owner = "client!ib", name = "a", descriptor = "(I[Lclient!vu;)I")
	public int toArray(Node[] result) {
		int size = 0;

		for (int i = 0; i < this.bucketCount; i++) {
			Node sentinelNode = this.buckets[i];

			for (Node node = sentinelNode.previous; node != sentinelNode; node = node.previous) {
				result[size++] = node;
			}
		}
		return size;
	}
}
