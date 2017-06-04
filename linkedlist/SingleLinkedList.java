package com.javamultiplex.datastructure.linkedlist;

public class SingleLinkedList {

	private class Node {

		private int data;
		private Node next;

		Node(int data) {

			setData(data);
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

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public boolean isEmpty() {
		return getHead() == null;
	}

	//Insert at the end.
	public void insertAtEnd(int data) {

		Node node = new Node(data);

		if (isEmpty()) {
			setHead(node);
		} else {
			Node current = getHead();
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(node);
		}
		size++;
	}

	//Insert at the beginning.
	public void insertAtBeginning(int data) {

		Node node = new Node(data);
		if (!isEmpty()) {
			node.setNext(head);
		}
		setHead(node);
		size++;
	}

	//Insert at the middle.
	public void insertAtMiddle(int data, int position) {

		if (isEmpty()) {

			if (position == 1) {
				head = new Node(data);
			} else {
				System.out.println("Invalid position " + position + ".");
				return;
			}
		} else {

			Node node = new Node(data);
			if (position == 1) {
				node.setNext(head);
				setHead(node);
			} else if (position > 1 && position <= getSize()) {
				Node current = head, prev = null;
				int currentPosition = 1;
				while (currentPosition != position) {
					prev = current;
					current = current.getNext();
					currentPosition++;
				}
				prev.setNext(node);
				node.setNext(current);
			} else if (position == getSize() + 1) {
				Node current = head;
				while (current.getNext() != null) {
					current = current.getNext();
				}
				current.setNext(node);
			} else {
				System.out.println("Invalid position " + position + ".");
				return;
			}

		}
		size++;

	}

	//Delete from the middle.
	public void deleteFromMiddle(int position) {

		if (isEmpty()) {
			System.out.println("Linked list is empty.");
			return;
		} else {
			if (position == 1) {
				head = head.getNext();
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
				if (head.getNext() == null) {
					setHead(null);
				} else {
					Node current = head;
					while (current.getNext().getNext() != null) {
						current = current.getNext();
					}
					current.setNext(null);
				}
			} else {
				System.out.println("Invalid position");
				return;
			}
		}
		size--;

	}
	

	//Delete from the beginning.
	public void deleteFromBeginning() {

		if (isEmpty()) {
			System.out.println("Linked list is empty.");
			return;
		} else {
			head = head.getNext();
		}
		size--;
	}

	//Delete from the end.
	public void deleteFromEnd() {

		if (isEmpty()) {
			System.out.println("Linked list is empty.");
			return;
		} else {
			if (head.getNext() == null) {
				setHead(null);
			} else {
				Node current = head;
				while (current.getNext().getNext() != null) {
					current = current.getNext();
				}
				current.setNext(null);
			}
		}

		size--;

	}

	//Delete full linked list.
	public void delete() {

		if (isEmpty()) {
			System.out.println("Linked list is empty.");
			return;
		} else {
			while (head != null) {
				head = head.getNext();
				size--;
			}
		}

	}

	public void display() {

		if (isEmpty()) {

			System.out.println("Linked list is empty.");
			return;

		} else {
			Node current = head;
			while (current != null) {
				System.out.print(current.getData() + "->");
				current = current.getNext();
			}
		}

	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
