package com.javamultiplex.datastructure.recursion;

public class Fibonacci {

	public static void main(String[] args) {
		
		int num=10;
		int result=fib(num);
		System.out.println("Fibonacci sum is : "+result);
		
	}

	private static int fib(int num) {
		
		if(num==0 || num==1)
			return 1;
		else
			return fib(num-1)+fib(num-2);
		
	}
	
}
