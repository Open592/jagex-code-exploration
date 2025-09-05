package com.jagex.client.ds;

import com.jagex.client.Node;

public final class LinkedList {

	private Node cursor;

	public final Node sentinelNode = new Node();

	public LinkedList() {
		this.sentinelNode.next = this.sentinelNode;
		this.sentinelNode.previous = this.sentinelNode;
	}

	public void addLast(Node node) {
		if (node.next != null) {
			node.popSelf();
		}

		node.previous = this.sentinelNode.previous;
		node.next = this.sentinelNode;
		node.next.previous = node;
		node.previous.next = node;
	}

	public Node pollLast() {
		Node node = this.sentinelNode.previous;

		if (this.sentinelNode == node) {
			return null;
        }

        node.popSelf();
        return node;
	}

	public void addFirst(Node node) {
		if (node.next != null) {
			node.popSelf();
		}

		node.previous = this.sentinelNode;
		node.next = this.sentinelNode.next;
		node.next.previous = node;
		node.previous.next = node;
	}

	public void clear() {
		while (true) {
			Node node = this.sentinelNode.previous;

			if (this.sentinelNode == node) {
				this.cursor = null;
				return;
			}

			node.popSelf();
		}
	}

	public Node head() {
		Node node = this.sentinelNode.next;

		if (this.sentinelNode == node) {
			this.cursor = null;
			return null;
        }

        this.cursor = node.next;
        return node;
	}

	public Node tail() {
		Node node = this.sentinelNode.previous;

		if (this.sentinelNode == node) {
            this.cursor = null;
            return null;
        }

        this.cursor = node.previous;
        return node;
	}

	private void spliceAt(Node node, LinkedList destination) {
		Node head = this.sentinelNode.next;
		this.sentinelNode.next = node.next;
		node.next.previous = this.sentinelNode;

		if (node != this.sentinelNode) {
			node.next = destination.sentinelNode.next;
			node.next.previous = node;
			destination.sentinelNode.next = head;
			head.previous = destination.sentinelNode;
		}
	}

	public Node previous() {
		Node node = this.cursor;

		if (this.sentinelNode == node) {
			this.cursor = null;
			return null;
        }

        this.cursor = node.previous;
        return node;
	}

	public Node next() {
		Node node = this.cursor;

		if (this.sentinelNode == node) {
            this.cursor = null;
            return null;
        }

        this.cursor = node.next;
        return node;
	}

	public boolean isEmpty() {
		return this.sentinelNode.previous == this.sentinelNode;
	}

	public int count() {
		int count = 0;

		for (Node current = this.sentinelNode.previous; current != this.sentinelNode; current = current.previous) {
			count++;
		}

		return count;
	}

	public void moveTo(LinkedList destination) {
		this.spliceAt(this.sentinelNode.previous, destination);
	}
}
