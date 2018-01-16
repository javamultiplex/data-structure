package com.javamultiplex.interview.ds;

import java.util.Scanner;

/*
 * 
 * Input - I Love My India
 * Output - India My Love I
 *
 */
public class Question1 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter String : ");
		String sentence = input.nextLine();
		String output = reverseString(sentence);
		System.out.println(output);
		input.close();
	}

	private static String reverseString(String sentence) {

		StringBuffer stringBuffer = new StringBuffer(sentence);
		int length = stringBuffer.length();
		int start = 0, end = 0;
		for (int i = 0; i < length; i++) {

			if (stringBuffer.charAt(i) == ' ' || i == stringBuffer.length() - 1) {
				end = i;
				if (i != stringBuffer.length() - 1) {
					end--;
				}
				swap(stringBuffer, start, end);
				start = i + 1;
			}
		}
		swap(stringBuffer, 0, length - 1);
		return stringBuffer.toString();
	}

	private static void swap(StringBuffer stringBuffer, int start, int end) {

		char temp = '\u0000';
		while (start < end) {
			temp = stringBuffer.charAt(start);
			stringBuffer.setCharAt(start, stringBuffer.charAt(end));
			stringBuffer.setCharAt(end, temp);
			start++;
			end--;
		}

	}

}
