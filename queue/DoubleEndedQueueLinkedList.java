package com.javamultiplex.datastructure.queue;

public class DoubleEndedQueueLinkedList {

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

	private Node head;
	private int size;

	public boolean isEmpty() {
		return head == null;
	}

	public void insertAtEnd(int data) {
		if (head == null) {
			head = new Node(data);
		} else {
			Node rear = head;
			while (rear.getNext() != null) {
				rear = rear.getNext();
			}
			Node newNode = new Node(data);
			rear.setNext(newNode);
		}
		size++;
	}

	public void deleteFirst() {
		if (head == null) {
			System.out.println("Queue is empty.");
		} else {
			head = head.getNext();
			size--;
		}
	}

	public void insertAtBegining(int data) {
		if (head == null) {
			head = new Node(data);
		} else {
			Node node = new Node();
			node.setData(data);
			node.setNext(head);
			head = node;
		}
		size++;
	}

	public void deleteLast() {
		if (head == null) {
			System.out.println("Queue is empty.");
		} else {
			Node temp = head;
			if (temp.getNext() == null) {
				head = null;
			} else {
				while (temp.getNext().getNext() != null) {
					temp = temp.getNext();
				}
				temp.setNext(null);
			}
			size--;
		}
	}

	public int getSize() {
		return size;
	}

	public Node getHead() {
		return head;
	}

	public void display() {

		Node temp = head;
		if (temp == null) {
			System.out.println("Queue is empty.");
		} else {
			while (temp != null) {
				System.out.print(temp.getData() + " ");
				temp = temp.getNext();
			}
		}

	}

}
