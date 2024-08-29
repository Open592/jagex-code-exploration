package com.jagex.client;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ib")
public final class LinkedHashMapIterator {

	@OriginalMember(owner = "client!ib", name = "m", descriptor = "Lclient!vu;")
	private LinkedHashEntry nextFoundEntryPointer;

	@OriginalMember(owner = "client!ib", name = "n", descriptor = "J")
	private long lastProvidedHashKey;

	@OriginalMember(owner = "client!ib", name = "s", descriptor = "Lclient!vu;")
	private LinkedHashEntry nextEntryPointer;

	@OriginalMember(owner = "client!ib", name = "r", descriptor = "I")
	private int currentBucketIndex = 0;

	@OriginalMember(owner = "client!ib", name = "d", descriptor = "[Lclient!vu;")
	public final LinkedHashEntry[] buckets;

	@OriginalMember(owner = "client!ib", name = "a", descriptor = "I")
	public final int size;

	@OriginalMember(owner = "client!ib", name = "<init>", descriptor = "(I)V")
	public LinkedHashMapIterator(int size) {
		this.buckets = new LinkedHashEntry[size];
		this.size = size;

		for (int i = 0; i < size; i++) {
			LinkedHashEntry sentinelEntry = this.buckets[i] = new LinkedHashEntry();

			sentinelEntry.previous = sentinelEntry;
			sentinelEntry.next = sentinelEntry;
		}
	}

	@OriginalMember(owner = "client!ib", name = "a", descriptor = "(I)Lclient!vu;")
	public LinkedHashEntry nextFoundEntry() {
		if (this.nextFoundEntryPointer == null) {
			return null;
		}

		LinkedHashEntry sentinelEntry = this.buckets[(int) ((long) (this.size - 1) & this.lastProvidedHashKey)];

		while (sentinelEntry != this.nextFoundEntryPointer) {
			if (this.lastProvidedHashKey == this.nextFoundEntryPointer.hashKey) {
				LinkedHashEntry ret = this.nextFoundEntryPointer;

				this.nextFoundEntryPointer = this.nextFoundEntryPointer.previous;

				return ret;
			}

			this.nextFoundEntryPointer = this.nextFoundEntryPointer.previous;
		}

		this.nextFoundEntryPointer = null;

		return null;
	}

	@OriginalMember(owner = "client!ib", name = "b", descriptor = "(I)I")
	public int entryCount() {
		int count = 0;

		for (int i = 0; i < this.size; i++) {
			LinkedHashEntry sentinelEntry = this.buckets[i];
			LinkedHashEntry currentEntry = sentinelEntry.previous;

			while (sentinelEntry != currentEntry) {
				currentEntry = currentEntry.previous;

				count++;
			}
		}

		return count;
	}

	@OriginalMember(owner = "client!ib", name = "c", descriptor = "(I)V")
	public void clear() {
		for (int i = 0; i < this.size; i++) {
			LinkedHashEntry sentinelEntry = this.buckets[i];

			while (true) {
				LinkedHashEntry currentEntry = sentinelEntry.previous;

				if (currentEntry == sentinelEntry) {
					break;
				}

				currentEntry.popSelf();
			}
		}

		this.nextFoundEntryPointer = null;
		this.nextEntryPointer = null;
	}

	@OriginalMember(owner = "client!ib", name = "a", descriptor = "(JI)Lclient!vu;")
	public LinkedHashEntry get(long hashKey) {
		this.lastProvidedHashKey = hashKey;

		LinkedHashEntry sentinelEntry = this.buckets[(int) (hashKey & (long) (this.size - 1))];

		for (
			this.nextFoundEntryPointer = sentinelEntry.previous;
			this.nextFoundEntryPointer != sentinelEntry;
			this.nextFoundEntryPointer = this.nextFoundEntryPointer.previous
		) {
			if (hashKey == this.nextFoundEntryPointer.hashKey) {
				LinkedHashEntry ret = this.nextFoundEntryPointer;

				this.nextFoundEntryPointer = this.nextFoundEntryPointer.previous;

				return ret;
			}
		}

		this.nextFoundEntryPointer = null;

		return null;
	}

	@OriginalMember(owner = "client!ib", name = "a", descriptor = "(JILclient!vu;)V")
	public void set(long hashKey, LinkedHashEntry entry) {
		if (entry.next != null) {
			entry.popSelf();
		}

		LinkedHashEntry sentinelEntry = this.buckets[(int) (hashKey & (long) (this.size - 1))];

		entry.previous = sentinelEntry;
		entry.next = sentinelEntry.next;
		entry.next.previous = entry;
		entry.hashKey = hashKey;
		entry.previous.next = entry;
	}

	@OriginalMember(owner = "client!ib", name = "b", descriptor = "(B)Lclient!vu;")
	public LinkedHashEntry nextEntry() {
		LinkedHashEntry ret;

		if (
			this.currentBucketIndex > 0 &&
			this.nextEntryPointer != this.buckets[this.currentBucketIndex - 1]
		) {
			ret = this.nextEntryPointer;

			this.nextEntryPointer = ret.previous;

			return ret;
		}

		while (this.currentBucketIndex < this.size) {
			ret = this.buckets[this.currentBucketIndex++].previous;

			if (this.buckets[this.currentBucketIndex - 1] != ret) {
				this.nextEntryPointer = ret.previous;

				return ret;
			}
		}

		return null;
	}

	@OriginalMember(owner = "client!ib", name = "c", descriptor = "(B)Lclient!vu;")
	public LinkedHashEntry head() {
		this.currentBucketIndex = 0;

		return this.nextEntry();
	}

	@OriginalMember(owner = "client!ib", name = "d", descriptor = "(I)I")
	public int size() {
		return this.size;
	}

	@OriginalMember(owner = "client!ib", name = "a", descriptor = "(I[Lclient!vu;)I")
	public int toArray(LinkedHashEntry[] result) {
		int size = 0;

		for (int i = 0; i < this.size; i++) {
			LinkedHashEntry sentinelEntry = this.buckets[i];

			for (LinkedHashEntry entry = sentinelEntry.previous; entry != sentinelEntry; entry = entry.previous) {
				result[size++] = entry;
			}
		}
		return size;
	}
}
