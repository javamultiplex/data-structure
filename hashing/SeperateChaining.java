package com.javamultiplex.datastructure.hashing;

import java.util.LinkedList;

//Separate chaining or Open hashing.
public class SeperateChaining {

	private LinkedList<Integer>[] table;
	int tableSize = 0;

	@SuppressWarnings("unchecked")
	public SeperateChaining(int N) {

		tableSize = N;
		setTable(new LinkedList[N]);
		for (int i = 0; i < N; i++) {
			table[i] = new LinkedList<>();
		}

	}

	public void insert(int key) {

		int index = hash(key);
		table[index].addFirst(key);
	}

	
	public int search(int key){
		
		int index=hash(key);
		if(table[index].contains(key)){
			return index;
		}
		return -1;
	}
	
	public void delete(int key){
		
		
		int index=search(key);
		if(index!=-1){
			table[index].remove((Integer)key);
			System.out.println("Key has been deleted successfully.");
		}else{
			System.out.println("Key not found");
		}
		
	}
	
	private int hash(int key) {
		return key % tableSize;
	}

	public LinkedList<Integer>[] getTable() {
		return table;
	}

	public void setTable(LinkedList<Integer>[] table) {
		this.table = table;
	}

}
