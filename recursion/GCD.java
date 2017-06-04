package com.javamultiplex.datastructure.recursion;

public class GCD {

	public static void main(String[] args) {
		
		int a=13, b=169;
		int result=gcd(a,b);
		System.out.println("GCD is : "+result);
		
	}

	private static int gcd(int a, int b) {
		if(b==0)
			return a;
		else
			return gcd(b,a%b);
	}
	
}
