package com.javamultiplex.array.search;

import java.util.Arrays;
import java.util.Scanner;

//Search element using binary search.
public class BinarySearch {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter array size : ");
		int size = input.nextInt();
		int[] arr = new int[size];
		System.out.println("Now enter elements of array");
		for (int i = 0; i < size; i++) {
			arr[i] = input.nextInt();
		}
		Arrays.sort(arr);
		System.out.println("Enter element that you want to search : ");
		int element = input.nextInt();
		System.out.println("Sorted Array : ");
		System.out.println(Arrays.toString(arr));
		int index = binarySearch(arr, 0, size - 1, element);
		if (index != -1) {
			System.out.println("Element found at index " + index);
		} else {
			System.out.println("Element not found.");
		}
		input.close();
	}

	private static int binarySearch(int[] arr, int left, int right, int element) {

		if (left <= right) {
			int mid = (left + right) / 2;
			if (element == arr[mid]) {
				return mid;
			} else if (element < arr[mid]) {
				return binarySearch(arr, left, mid - 1, element);
			} else {
				return binarySearch(arr, mid + 1, right, element);
			}
		}
		return -1;
	}

}
