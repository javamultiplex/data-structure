package com.javamultiplex.datastructure.recursion;

public class Power {

	public static void main(String[] args) {

		int n = 8, m = 3;
		int result = pow(n, m);
		System.out.printf("%d^%d = %d", n, m, result);

	}

	private static int pow(int n, int m) {

		if (m == 0) {
			return 1;
		}else{
			return n*pow(n,m-1);
		}
	}

}
