package com.javamultiplex.datastructure.tree.heap.binaryheap;

public class HeapBuilder {

	private int[] arr;
	private int N;

	public HeapBuilder(int[] arr) {
		N = arr.length;
		this.arr = arr;
	}

	// O(n)
	public void buildMaxHeap() {
		for (int i = ((N / 2) - 1); i >= 0; i--) {
			maxHeapify(i);
		}
	}

	// O(log(n))
	private void maxHeapify(int i) {

		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int largest = 0;
		if (left < N && arr[left] > arr[i]) {
			largest = left;
		} else {
			largest = i;
		}

		if (right < N && arr[right] > arr[largest]) {
			largest = right;
		}

		if (largest != i) {
			swap(largest, i);
			maxHeapify(largest);
		}

	}

	// O(n)
	public void buildMinHeap() {

		for (int i = ((N / 2) - 1); i >= 0; i--) {
			minHeapify(i);
		}
	}

	// O(log(n))
	private void minHeapify(int i) {

		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int smallest = 0;
		if (left < N && arr[left] < arr[i]) {
			smallest = left;
		} else {
			smallest = i;
		}
		if (right < N && arr[right] < arr[smallest]) {
			smallest = right;
		}
		if (smallest != i) {
			swap(smallest, i);
			minHeapify(smallest);
		}

	}

	private void swap(int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;

	}

	// O(n)
	public void display() {
		for (int i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
