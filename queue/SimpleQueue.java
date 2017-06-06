package com.javamultiplex.datastructure.queue;

public class SimpleQueue {

	private int[] queue;
	private int front;
	private int rear;
	private int N;

	public SimpleQueue(int N) {
		this.N = N;
		queue = new int[N];
		front = 0;
		rear = 0;
	}

	public boolean isEmpty() {
		return front == rear;
	}

	public void enQueue(int data) {

		if (rear == N) {
			System.out.println("Queue overflow.");
		} else {
			queue[rear] = data;
			rear++;
		}

	}

	public void deQueue() {
		if (front == rear) {
			System.out.println("Queue underflow.");
		} else {
			queue[front] = 0;
			front++;
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
