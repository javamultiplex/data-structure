package com.javamultiplex.datastructure.array;

import java.util.Arrays;

public class SortedArray {

	private int arr[];
	private int length;

	public SortedArray(int arr[]) {
		int length = arr.length;
		this.arr = arr;
		this.length = length;
	}

	// O(n)
	public void insertInAscendingOrder(int element) {

		length = length + 1;

		arr = Arrays.copyOf(arr, length);
		int i = 0;
		for (i = 0; i < length - 1; i++) {
			if (arr[i] > element) {
				break;
			}
		}
		for (int j = length - 1; j > i; j--) {
			arr[j] = arr[j - 1];
		}
		arr[i] = element;
	}

	// O(n)
	public void insertInDescendingOrder(int element) {

		length = length + 1;

		arr = Arrays.copyOf(arr, length);
		int i = 0;
		for (i = 0; i < length - 1; i++) {
			if (arr[i] < element) {
				break;
			}
		}
		for (int j = length - 1; j > i; j--) {
			arr[j] = arr[j - 1];
		}
		arr[i] = element;
	}

	// O(n)
	public void display() {

		for (int i = 0; i < length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

	// O(n-1)
	public void deleteFirstElement() {

		for (int i = 0; i < length - 1; i++) {

			arr[i] = arr[i + 1];

		}

		length = length - 1;

	}

	// O(1)
	public void deleteLastElement() {
		length = length - 1;
	}

	// O(n-1)
	public void deleteElementAtPosition(int position) {
		if (position < 0 || position >= length) {
			System.out.println("Invalid postion.");
		} else {
			for (int i = position; i < length - 1; i++) {
				arr[i] = arr[i + 1];
			}
			length = length - 1;
		}
	}

	public int searchInAscendingOrderSortedArrayRecursively(int element) {
		return searchInAscendingOrderSortedArrayRecursively(element, 0, length - 1);
	}

	// O(log(n))
	private int searchInAscendingOrderSortedArrayRecursively(int element, int low, int high) {

		if (high >= low) {
			int mid = (low + high) / 2;
			if (arr[mid] == element) {
				return mid;
			} else if (arr[mid] > element) {
				return searchInAscendingOrderSortedArrayRecursively(element, low, mid - 1);
			} else {
				return searchInAscendingOrderSortedArrayRecursively(element, mid + 1, high);
			}
		}
		return -1;
	}

	public int searchInDescendingOrderSortedArrayRecursively(int element) {
		return searchInDescendingOrderSortedArrayRecursively(element, 0, length - 1);
	}

	// O(log(n))
	private int searchInDescendingOrderSortedArrayRecursively(int element, int low, int high) {

		if (high >= low) {
			int mid = (high + low) / 2;
			if (arr[mid] == element) {
				return mid;
			} else if (arr[mid] < element) {
				return searchInDescendingOrderSortedArrayRecursively(element, low, mid - 1);
			} else {
				return searchInDescendingOrderSortedArrayRecursively(element, mid + 1, high);
			}
		}
		return -1;

	}

	public int searchInAscendingOrderSortedArrayIteratively(int element) {
		return searchInAscendingOrderSortedArrayIteratively(element, 0, length - 1);
	}

	// O(log(n))
	private int searchInAscendingOrderSortedArrayIteratively(int element, int low, int high) {

		while (high >= low) {

			int mid = (low + high) / 2;
			if (arr[mid] == element) {
				return mid;
			} else if (arr[mid] > element) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}

		return -1;
	}

	public int searchInDescendingOrderSortedArrayIteratively(int element) {
		return searchInDescendingOrderSortedArrayIteratively(element, 0, length - 1);
	}

	private int searchInDescendingOrderSortedArrayIteratively(int element, int low, int high) {

		while (high >= low) {

			int mid = (low + high) / 2;
			if (arr[mid] == element) {
				return mid;
			} else if (arr[mid] < element) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}

		return -1;
	}

}
