package com.javamultiplex.array.rotation;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotator {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter array size : ");
		int size = input.nextInt();
		int[] arr = new int[size];
		System.out.println("Now enter elements of array");
		for (int i = 0; i < size; i++) {
			arr[i] = input.nextInt();
		}
		System.out.println("How many elements do you want to rotate?");
		int rotationCount = input.nextInt();
		// rotateArrayMethod1(arr, size, rotationCount);
		// rotateArrayMethod2(arr, size, rotationCount);
		// rotateArrayMethod3(arr, size, rotationCount);
		rotateArrayMethod4(arr, size, rotationCount);
		System.out.println(Arrays.toString(arr));
		input.close();
	}

	// Reversal Algorithm = Time - O(n), Space - O(1)
	private static void rotateArrayMethod4(int[] arr, int n, int d) {
		
		reverseArray(arr, 0, d-1);
		reverseArray(arr, d, n-1);
		reverseArray(arr, 0, n-1);
		
	}

	// Juggling Algorithm = Time - 0(n), Space - O(1)
	private static void rotateArrayMethod3(int[] arr, int n, int d) {

		int sets = gcd(n, d);
		int j = 0, temp = 0, k = 0;
		for (int i = 0; i < sets; i++) {
			j = i;
			temp = arr[i];
			while (true) {
				k = (j + d) % n;
				if (k == i) {
					break;
				}
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = temp;
		}

	}

	// Time - 0(n), Space - O(d)
	private static void rotateArrayMethod2(int[] arr, int n, int d) {

		int[] temp = new int[d];
		int j = 0;
		for (int i = 0; i < d; i++) {
			temp[i] = arr[i];
		}

		for (int i = 0; i < n - d; i++) {
			arr[i] = arr[d + i];
		}
		for (int i = n - d; i < n; i++) {
			arr[i] = temp[j++];
		}

	}

	// Time - O(n*d), Space - O(1)
	private static void rotateArrayMethod1(int[] arr, int n, int d) {

		int temp = 0;
		for (int i = 0; i < d; i++) {
			temp = arr[0];
			for (int j = 0; j < n - 1; j++) {
				arr[j] = arr[j + 1];
			}
			arr[n - 1] = temp;
		}
	}

	private static int gcd(int a, int b) {

		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	private static void reverseArray(int[] arr, int start, int end) {
		int temp = 0;
		while (start < end) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

}
