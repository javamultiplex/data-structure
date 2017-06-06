package com.javamultiplex.datastructure.stack;

public class StackLinkedList {

	private class Node {

		private int data;
		private Node next;

		public Node() {

		}

		public Node(int data) {
			this.setData(data);
			setNext(null);
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}

	private Node top;
	private int size;

	public void push(int data) {
		if (top == null) {
			top = new Node(data);
		} else {
			Node myNode = new Node();
			myNode.setData(data);
			myNode.setNext(top);
			top = myNode;

		}
		size++;
	}

	public void pop() {
		if (top == null) {
			System.out.println("No Food");
		} else {
			System.out.println(top.getData());
			top = top.getNext();
			size--;
		}
	}

	public boolean isEmpty() {

		return top == null;
	}

	public int size() {
		return size;
	}

	public Node getTop() {
		return top;
	}

	public void display() {

		Node head = top;
		while (head != null) {
			System.out.println(head.getData());
			head = head.getNext();
		}
	}

}
