package com.javamultiplex.array.rotation;

import java.util.Arrays;
import java.util.Scanner;

//Clockwise rotate an array by one
public class CyclicRotator {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter array size : ");
		int size = input.nextInt();
		int[] arr = new int[size];
		System.out.println("Now enter elements of array");
		for (int i = 0; i < size; i++) {
			arr[i] = input.nextInt();
		}
		clockwiseRotate(arr,size);
		System.out.println(Arrays.toString(arr));
		input.close();
	}

	private static void clockwiseRotate(int[] arr,int n) {

		int temp=arr[n-1];
		for(int i=n-1;i>0;i--){
			arr[i]=arr[i-1];
		}
		arr[0]=temp;
	}
	
}
