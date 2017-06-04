package com.javamultiplex.datastructure.linkedlist;

public class CircularLinkedList {

	private class Node {

		private int data;
		private Node next;

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

	// Insert at the end.
	public void insertAtEnd(int data) {

		if (isEmpty()) {
			head = new Node();
			head.setData(data);
			head.setNext(head);
		} else {
			Node node = new Node();
			Node current = head;
			while (current.getNext() != head) {
				current = current.getNext();
			}
			node.setData(data);
			node.setNext(head);
			current.setNext(node);

		}
		size++;
	}

	// Insert at the beginning.
	public void insertAtBeginning(int data) {

		if (isEmpty()) {
			head = new Node();
			head.setData(data);
			head.setNext(head);
		} else {
			Node node = new Node();
			Node current = head;
			while (current.getNext() != head) {
				current = current.getNext();
			}
			node.setData(data);
			node.setNext(head);
			current.setNext(node);
			head = node;

		}
		size++;
	}

	// Insert at the middle.
	public void insertAtMiddle(int data, int position) {

		if (isEmpty()) {

			if (position == 1) {
				head = new Node();
				head.setData(data);
				head.setNext(head);
			} else {
				System.out.println("Invalid position " + position + ".");
				return;
			}
		} else {

			Node node = new Node();
			if (position == 1) {
				Node current = head;
				while (current.getNext() != head) {
					current = current.getNext();
				}
				node.setData(data);
				node.setNext(head);
				current.setNext(node);
				head = node;

			} else if (position > 1 && position <= getSize()) {
				Node current = head, prev = null;
				int currentPosition = 1;
				while (currentPosition != position) {
					prev = current;
					current = current.getNext();
					currentPosition++;
				}
				node.setData(data);
				prev.setNext(node);
				node.setNext(current);
			} else if (position == getSize() + 1) {
				Node current = head;
				while (current.getNext() != head) {
					current = current.getNext();
				}
				node.setData(data);
				node.setNext(head);
				current.setNext(node);
			} else {
				System.out.println("Invalid position " + position + ".");
				return;
			}

		}
		size++;

	}

	// Delete from the middle.
	public void deleteFromMiddle(int position) {

		if (isEmpty()) {
			System.out.println("Circular Linked list is empty.");
			return;
		} else {
			if (position == 1) {

				Node current = head;
				while (current.getNext() != head) {

					current = current.getNext();
				}
				head = head.getNext();
				current.setNext(head);

			} else if (position > 1 && position < getSize()) {
				Node current = head, prev = null;
				int currentPosition = 1;
				while (currentPosition != position) {
					prev = current;
					current = current.getNext();
					currentPosition++;
				}
				prev.setNext(current.getNext());
			} else if (position == getSize()) {
				if (head.getNext() == head) {
					head = null;
				} else {
					Node current = head;
					while (current.getNext().getNext() != head) {
						current = current.getNext();
					}
					current.setNext(head);
				}
			} else {
				System.out.println("Invalid position");
				return;
			}
		}
		size--;

	}

	// Delete from the beginning.
	public void deleteFromBeginning() {

		if (isEmpty()) {
			System.out.println("Circular Linked list is empty.");
			return;
		} else {

			Node current = head;
			while (current.getNext() != head) {
				current = current.getNext();
			}
			head = head.getNext();
			current.setNext(head);
		}
		size--;
	}

	// Delete from the end.
	public void deleteFromEnd() {

		if (isEmpty()) {
			System.out.println("Circular Linked list is empty.");
			return;
		} else {
			if (head.getNext() == head) {
				head = null;
			} else {
				Node current = head;
				while (current.getNext().getNext() != head) {
					current = current.getNext();
				}
				current.setNext(head);
			}
		}

		size--;

	}

	// Delete full linked list.
	public void delete() {

		if (isEmpty()) {
			System.out.println("Circular Linked list is empty.");
		} else {

			while (true) {
				size--;
				if (head.getNext() == head) {
					head = null;
					break;
				} else {
					Node current = head;
					while (current.getNext() != head) {
						current = current.getNext();
					}
					head = head.getNext();
					current.setNext(head);
				}
			}
		}

	}

	public void display() {

		if (isEmpty()) {
			System.out.println("Circular Linked list is empty.");
			return;
		} else {
			Node current = head;
			do {
				System.out.print(current.getData() + "->");
				current = current.getNext();

			} while (current != head);
		}

	}

	public int getSize() {
		return size;
	}

}
