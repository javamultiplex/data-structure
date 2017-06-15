package com.javamultiplex.datastructure.tree.heap.binaryheap;

public class HeapSort {

	private int arr[];
	private int N;
	private int heapSize;

	public HeapSort(int[] arr) {
		this.arr = arr;
		N = arr.length;
		heapSize = N;
	}

	// O(nlog(n))
	public void sortInAscendingOrder() {

		int temp[] = new int[N];
		buildMaxHeap();
		int i = N - 1;
		while (heapSize != 1) {
			temp[i] = extractMax();
			i--;
		}
		temp[i] = arr[0];
		arr = temp;
		heapSize = N;
	}

	// O(nlog(n))
	public void sortInDescendingOrder() {

		int temp[] = new int[N];
		buildMinHeap();
		int i = N - 1;
		while (heapSize != 1) {
			temp[i] = extractMin();
			i--;
		}
		temp[i] = arr[0];
		arr = temp;
		heapSize = N;
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
		if (left < heapSize && arr[left] > arr[i]) {
			largest = left;
		} else {
			largest = i;
		}

		if (right < heapSize && arr[right] > arr[largest]) {
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
	public int extractMax() {

		if (isEmpty()) {
			System.out.println("Heap Underflow!!");
			return -1;
		} else {
			int max = arr[0];
			swap(0, heapSize - 1);
			heapSize--;
			maxHeapify(0);
			return max;
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

	// O(1)
	public boolean isEmpty() {
		return heapSize == 0;
	}

	// O(1)
	private void swap(int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;

	}

	// O(n)
	public void display() {
		for (int i = 0; i < heapSize; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
