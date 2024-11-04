package com.jagex.client;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!tn")
public final class SecondaryLinkedList {

	@OriginalMember(owner = "client!tn", name = "k", descriptor = "Lclient!ac;")
	private SecondaryNode nextNodePointer;

	@OriginalMember(owner = "client!tn", name = "d", descriptor = "Lclient!ac;")
	private final SecondaryNode sentinelNode = new SecondaryNode();

	@OriginalMember(owner = "client!tn", name = "<init>", descriptor = "()V")
	public SecondaryLinkedList() {
		this.sentinelNode.secondaryNext = this.sentinelNode;
		this.sentinelNode.secondaryPrevious = this.sentinelNode;
	}

	@OriginalMember(owner = "client!lg", name = "a", descriptor = "(ZLclient!ac;Lclient!ac;)V")
	public static void insertAfter(SecondaryNode node, SecondaryNode position) {
		if (position.secondaryNext != null) {
			position.secondaryPopSelf();
		}

		position.secondaryNext = node;
		position.secondaryPrevious = node.secondaryPrevious;
		position.secondaryNext.secondaryPrevious = position;
		position.secondaryPrevious.secondaryNext = position;
	}

	@OriginalMember(owner = "client!tn", name = "a", descriptor = "(B)V")
	public void clear() {
		while (true) {
			SecondaryNode current = this.sentinelNode.secondaryPrevious;

			if (this.sentinelNode == current) {
				this.nextNodePointer = null;
				return;
			}

			current.secondaryPopSelf();
		}
	}

	@OriginalMember(owner = "client!tn", name = "a", descriptor = "(ILclient!ac;)V")
	public void insert(SecondaryNode node) {
		if (node.secondaryNext != null) {
			node.secondaryPopSelf();
		}

		node.secondaryPrevious = this.sentinelNode;
		node.secondaryNext = this.sentinelNode.secondaryNext;
		node.secondaryNext.secondaryPrevious = node;
		node.secondaryPrevious.secondaryNext = node;
	}

	@OriginalMember(owner = "client!tn", name = "b", descriptor = "(B)Lclient!ac;")
	public SecondaryNode getHead() {
		SecondaryNode head = this.sentinelNode.secondaryPrevious;

		if (head == this.sentinelNode) {
			this.nextNodePointer = null;

			return null;
		} else {
			this.nextNodePointer = head.secondaryPrevious;

			return head;
		}
	}

	@OriginalMember(owner = "client!tn", name = "c", descriptor = "(B)Lclient!ac;")
	public SecondaryNode popHead() {
		SecondaryNode head = this.sentinelNode.secondaryPrevious;

		if (this.sentinelNode == head) {
			return null;
		} else {
			head.secondaryPopSelf();

			return head;
		}
	}

	@OriginalMember(owner = "client!tn", name = "b", descriptor = "(Z)Lclient!ac;")
	public SecondaryNode next() {
		SecondaryNode nextNode = this.nextNodePointer;

		if (this.sentinelNode == nextNode) {
			this.nextNodePointer = null;

			return null;
		} else {
			this.nextNodePointer = nextNode.secondaryPrevious;

			return nextNode;
		}
	}

	@OriginalMember(owner = "client!tn", name = "c", descriptor = "(Z)I")
	public int size() {
		int count = 0;
		SecondaryNode currentNode = this.sentinelNode.secondaryPrevious;

		while (currentNode != this.sentinelNode) {
			currentNode = currentNode.secondaryPrevious;
			count++;
		}

		return count;
	}
}
