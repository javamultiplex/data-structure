package com.javamultiplex.datastructure.stack;

public class Stack {

	private int[] stack;
	private int top;
	private int N;

	public Stack(int N) {

		this.N = N;
		stack = new int[N];
		top = -1;

	}

	public boolean isEmpty() {

		boolean result = false;

		if (top == -1) {
			result = true;
		}
		return result;
	}

	public int size() {
		return top + 1;
	}

	public void push(int data) {

		if (top == N - 1) {
			System.out.println("Stack Overflow!!");
		} else {
			top = top + 1;
			stack[top] = data;
		}

	}

	public void pop() {

		if (isEmpty()) {
			System.out.println("Stack Underflow!!");
		} else {
			top = top - 1;
		}
		
	}
	
	public int getTop(){
		return stack[top];
	}
	
	public void display(){
		if(isEmpty()){
			System.out.println("Stack is empty.");
		}else{
			for(int i=top;i>=0;i--){
				System.out.println(stack[i]);
			}
		}
	}

}
