package com.javamultiplex.datastructure.tree.heap.binaryheap;

public class BinaryMinHeap {

	private int[] arr;
	private int N;
	private int heapSize;

	public BinaryMinHeap(int N) {
		this.N = N;
		heapSize = 0;
		arr = new int[N];
	}

	// O(1)
	public int getMinimum() {
		return arr[0];
	}

	// O(1)
	public int getLeftChild(int i) {
		return 2 * i + 1;
	}

	// O(1)
	public int getRightChild(int i) {
		return 2 * i + 2;
	}

	// O(1)
	public int getParent(int i) {
		return (i - 1) / 2;
	}

	// O(log(n))
	public void insert(int element) {

		if (isFull()) {
			System.out.println("Heap Overflow!!");
			return;
		} else {
			heapSize++;
			int i = heapSize - 1;
			arr[i] = element;
			while (i != 0 && arr[i] < arr[getParent(i)]) {
				swap(i, getParent(i));
				i = getParent(i);

			}
		}
	}

	// O(log(n))
	public int extractMin() {

		if (isEmpty()) {
			System.out.println("Heap Underflow!!");
			return -1;
		} else {
			int min = arr[0];
			swap(0, heapSize - 1);
			heapSize--;
			minHeapify(0);
			return min;
		}

	}

	// O(log(n))
	private void minHeapify(int i) {

		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int smallest = 0;
		if (left < heapSize && arr[left] < arr[i]) {
			smallest = left;
		} else {
			smallest = i;
		}
		if (right < heapSize && arr[right] < arr[smallest]) {
			smallest = right;
		}
		if (smallest != i) {
			swap(smallest, i);
			minHeapify(smallest);
		}

	}

	// O(log(n))
	public void decreaseKey(int i, int value) {

		if (i < heapSize) {
			arr[i] = value;

			while (i != 0 && arr[i] < arr[getParent(i)]) {
				swap(i, getParent(i));
				i = getParent(i);
			}

		}

	}

	// O(log(n))
	public void delete(int i) {

		if (isEmpty()) {
			System.out.println("Heap Underflow!!");
			return;
		} else {
			decreaseKey(i, Integer.MIN_VALUE);
			extractMin();
		}

	}

	// O(1)
	private void swap(int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;

	}

	// O(1)
	public boolean isEmpty() {
		return heapSize == 0;
	}

	// O(1)
	public boolean isFull() {
		return heapSize == N;
	}

	// O(n)
	public void display() {
		for (int i = 0; i < heapSize; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
