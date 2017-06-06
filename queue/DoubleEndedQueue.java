package com.javamultiplex.datastructure.queue;

public class DoubleEndedQueue {

	private int[] queue;
	private int front;
	private int rear;
	private int N;

	public DoubleEndedQueue(int N) {
		this.N = N;
		queue = new int[N];
		front = 0;
		rear = 0;
	}

	public boolean isEmpty() {
		return front == rear;
	}

	public void insertAtEnd(int data) {

		if (rear == N) {
			System.out.println("Queue overflow.");
		} else {
			queue[rear] = data;
			rear++;
		}

	}

	public void insertAtBegining(int data) {

		if (rear == N) {
			System.out.println("Queue overflow.");
		} else {
			for (int i = rear; i > front; i--) {
				queue[i] = queue[i - 1];
			}
			queue[front] = data;
			rear++;
		}

	}

	public void deleteFirst() {
		if (front == rear) {
			System.out.println("Queue underflow.");
		} else {
			queue[front] = 0;
			front++;
		}
	}

	public void deleteLast() {
		if (front == rear) {
			System.out.println("Queue underflow.");
		} else {
			rear = rear - 1;
			queue[rear] = 0;
		}
	}

	public int getSize() {
		return rear - front;
	}

	public void display() {

		if (rear == front) {
			System.out.println("Queue is empty.");
		} else {
			for (int i = front; i < rear; i++) {
				System.out.print(queue[i] + " ");
			}
		}

	}

	public int getFront() {
		return queue[front];
	}

	public int getRear() {
		return queue[rear - 1];
	}

}
