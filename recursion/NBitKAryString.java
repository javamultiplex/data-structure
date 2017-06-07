package com.javamultiplex.datastructure.recursion;

import java.util.Arrays;

//Generate K^N strings if we have 0-K bits.
public class NBitKAryString {

	public static int count=0;
	
	public static void main(String[] args) {

		int n = 2, k = 4;
		int[] a = new int[n];
		kAry(n, a, k);
		System.out.println("\nTotal possible combinations : "+count);
	}

	private static void kAry(int n, int[] a, int k) {

		if (n < 1) {
			System.out.println(Arrays.toString(a));
			count++;
		} else {
			for (int i = 0; i < k; i++) {
				a[n - 1] = i;
				kAry(n - 1, a, k);
			}
		}

	}

}
