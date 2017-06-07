package com.javamultiplex.datastructure.recursion;

import java.util.Arrays;

//Generate 2^N string if we have bits 0 and 1.
public class NBitString {
	
	public static int count=0;
	
	public static void main(String[] args) {
		
		int n=3;
		int a[]=new int[n];
		binary(n,a);
		System.out.println("\nTotal possible combinations : "+count);
	}

	private static void binary(int n, int[] a) {
		
		if(n<1){
			System.out.println(Arrays.toString(a));
			count++;
		}else{
			
			a[n-1]=0;
			binary(n-1,a);
			a[n-1]=1;
			binary(n-1, a);
			
		}
		
	}
	
}
