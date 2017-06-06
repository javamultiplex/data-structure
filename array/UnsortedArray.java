package com.javamultiplex.datastructure.array;

import java.util.Arrays;

public class UnsortedArray {

	public int[] arr;
	public int length;

	public UnsortedArray(int[] arr) {
		this.arr = arr;
		length = arr.length;
	}

	// O(n)
	public int search(int element) {

		for (int i = 0; i < length; i++) {
			if (arr[i] == element) {
				return i;
			}
		}
		return -1;
	}

	// O(n)
	public void insertAtBegining(int element) {

		length = length + 1;
		arr = Arrays.copyOf(arr, length);
		for (int i = length - 1; i >= 1; i--) {
			arr[i] = arr[i - 1];
		}
		arr[0] = element;
		System.out.println("Element has been inserted successfully.");
	}

	// O(1)
	public void insertAtEnd(int element) {
		length = length + 1;
		arr = Arrays.copyOf(arr, length);
		arr[length - 1] = element;
		System.out.println("Element has been inserted successfully.");
	}

	// O(n)
	public void display() {
		for (int i = 0; i < length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	// O(n-1)
	public void deleteFirstElement() {
		for (int i = 1; i < length; i++) {
			arr[i - 1] = arr[i];
		}
		length = length - 1;
		arr = Arrays.copyOf(arr, length);
		System.out.println("Element has been deleted successfully.");
	}

	// O(1)
	public void deleteLastElement() {
		length = length - 1;
		arr = Arrays.copyOf(arr, length);
		System.out.println("Element has been deleted successfully.");
	}

	// O(n)
	public void deleteElementAtPosition(int position) {
		if (position >= length) {
			System.out.println("Invalid position.");
		} else {
			for (int i = position; i < length - 1; i++) {
				arr[i] = arr[i + 1];
			}
			length = length - 1;
			System.out.println("Element has been deleted successfully.");
		}
	}

	// O(n)
	public void insertElementAtPosition(int element, int position) {
		length = length + 1;
		arr = Arrays.copyOf(arr, length);
		for (int i = length - 1; i > position; i--) {
			arr[i] = arr[i - 1];
		}
		arr[position] = element;
		System.out.println("Element has been deleted successfully.");
	}

}
