package com.javamultiplex.datastructure.recursion;

public class TowerOfHanoi {

	public static void main(String[] args) {

		int disks = 3;
		TOH(disks, 1, 2, 3);
	}

	private static void TOH(int n, int A, int B, int C) {

		if (n == 1) {
			System.out.printf("\n %d -> %d", A, C);
			return;
		}
		TOH(n - 1, A, C, B);
		System.out.printf("\n %d -> %d", A, C);
		TOH(n - 1, B, A, C);
	}

}
