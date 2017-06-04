
public class DoubleLinkedList {

	private class Node {

		private int data;
		private Node next;
		private Node prev;

		Node(int data) {

			setData(data);
			setNext(null);
			setPrev(null);
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

		public Node getPrev() {
			return prev;
		}

		public void setPrev(Node prev) {
			this.prev = prev;
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

	// Insert at the end.
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
			node.setPrev(current);
		}
		size++;
	}

	// Insert at the beginning.
	public void insertAtBeginning(int data) {

		Node node = new Node(data);
		if (!isEmpty()) {
			node.setNext(head);
			node.setPrev(null);
			head.setPrev(node);
		}
		setHead(node);
		size++;
	}

	// Insert at the middle.
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
				node.setPrev(null);
				setHead(node);
			} else if (position > 1 && position <= getSize()) {
				Node current = head;
				int currentPosition = 1;
				while (currentPosition != position) {
					current = current.getNext();
					currentPosition++;
				}
				current.getPrev().setNext(node);
				node.setNext(current);
				node.setPrev(current.getPrev());
				current.setPrev(node);
			} else if (position == getSize() + 1) {
				Node current = head;
				while (current.getNext() != null) {
					current = current.getNext();
				}
				current.setNext(node);
				node.setPrev(current);
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
			System.out.println("Double Linked list is empty.");
			return;
		} else {
			if (position == 1) {
				head = head.getNext();
				head.setPrev(null);
			} else if (position > 1 && position < getSize()) {
				Node current = head;
				int currentPosition = 1;
				while (currentPosition != position) {
					current = current.getNext();
					currentPosition++;
				}
				current.getNext().setPrev(current.getPrev());
				current.getPrev().setNext(current.getNext());
			} else if (position == getSize()) {
				if (head.getNext() == null) {
					setHead(null);
				} else {
					Node current = head;
					while (current.getNext()!= null) {
						current = current.getNext();
					}
					current.getPrev().setNext(null);
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
			System.out.println("Double Linked list is empty.");
			return;
		} else {
			head = head.getNext();
			head.setPrev(null);
		}
		size--;
	}

	// Delete from the end.
	public void deleteFromEnd() {

		if (isEmpty()) {
			System.out.println("Double Linked list is empty.");
			return;
		} else {
			if (head.getNext() == null) {
				setHead(null);
			} else {
				Node current = head;
				while (current.getNext() != null) {
					current = current.getNext();
				}
				current.getPrev().setNext(null);
			}
		}

		size--;

	}

	// Delete full linked list.
	public void delete() {

		if (isEmpty()) {
			System.out.println("Double Linked list is empty.");
			return;
		} else {
			while (head.getNext() != null) {
				head = head.getNext();
				head.setPrev(null);
				size--;
			}
			setHead(null);
			setSize(0);
		}

	}

	public void display() {

		if (isEmpty()) {

			System.out.println("Double Linked list is empty.");
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
