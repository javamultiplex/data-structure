package com.javamultiplex.datastructure.queue;

public class CircularQueue {

	private int[] queue;
	private int front;
	private int rear;
	private int N;
	private int count;

	public CircularQueue(int N) {
		this.N = N;
		queue = new int[N];
		front = 0;
		rear = 0;
		count = 0;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public void enQueue(int data) {

		if (count == N) {
			System.out.println("Queue overflow.");
		} else {
			queue[rear] = data;
			rear = (rear + 1) % N;
			count++;
		}

	}

	public void deQueue() {
		if (count == 0) {
			System.out.println("Queue underflow.");
		} else {
			queue[front] = 0;
			front = (front + 1) % N;
			count--;
		}
	}

	public int getSize() {
		return count;
	}

	public void display() {

		int temp = front;
		if (count == 0) {
			System.out.println("Queue is empty.");
		} else {
			do {
				System.out.print(queue[temp] + " ");
				temp = (temp + 1) % N;
			} while (temp != rear);
		}

	}

	public int getFront() {
		return queue[front];
	}

	public int getRear() {
		int temp = 0;
		if (rear == 0) {
			temp = queue[N - 1];
		} else {
			temp = queue[rear - 1];
		}
		return temp;
	}

}
