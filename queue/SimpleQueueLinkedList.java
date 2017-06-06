package com.javamultiplex.datastructure.queue;

public class SimpleQueueLinkedList {

	private class Node {

		private int data;
		private Node next;
		
		public Node(int data){
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

	public void enQueue(int data) {
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

	public void deQueue() {
		if (head == null) {
			System.out.println("Queue is empty.");
		} else {
			head = head.getNext();
			size--;
		}
	}
	
	public int getSize(){
		return size;
	}
	
	public Node getHead(){
		return head;
	}
	public void display(){
		
		Node temp=head;
		while(temp!=null){
			System.out.print(temp.getData()+" ");
			temp=temp.getNext();
		}
		
	}

}
